package com.lawrence.service;

import com.lawrence.domain.Girl;
import com.lawrence.enums.ResultEnum;
import com.lawrence.exception.GirlException;
import com.lawrence.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by liush
 * 2018/8/21   5:14
 */
@Service
public class GirlService{

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(24);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(25);
        girlB.setCupSize("BBBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();

        if (age < 10)
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        if (age >10 && age < 16)
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        if (age > 16)
            throw new GirlException(ResultEnum.HIGH_SCHOOL);
    }

    public Girl findOne(Integer id){
        return girlRepository.getOne(id);
    }
}
