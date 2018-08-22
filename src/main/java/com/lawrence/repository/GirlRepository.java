package com.lawrence.repository;

import com.lawrence.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liush
 * 2018/8/21   3:25
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 年龄查询
     * @param age
     * @return
     */
     List<Girl> findByAge(Integer age);
}
