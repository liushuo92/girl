package com.lawrence.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LawrenceLiu  2019/8/14 11:34
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Gun {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static Condition condition1 = lock.newCondition();
    private static LinkedBlockingDeque<Object> queue= new LinkedBlockingDeque<>(20);

    public static void main(String[] args) {
        //上膛
        Thread thread1 = new Thread(()->{
            while (queue.size()<20){
                lock.lock();
                try {
                    queue.push(new Object());
                    System.out.println("装弹:目前子弹"+queue.size());
                    Thread.sleep(10);

                    condition1.signal();
                    if (queue.size() == 20){
                        condition.await();
//                        condition1.signal();
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        //shot
        Thread thread2 = new Thread(()->{
            while (queue.size()>0){
                lock.lock();
                try{
                    queue.poll();
                    System.out.println("shot:子弹剩余"+queue.size());
                    Thread.sleep(10);
                    condition.signal();
                    if (queue.isEmpty()){
//                        condition.signal();
                        condition1.await();
                        Thread.sleep(10);
                    }
                }catch (InterruptedException e){
                    e.getMessage();
                }finally {
                    lock.unlock();
                }
            }
        });
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
