package com.lawrence.controller;

import com.lawrence.aspect.HttpAspect;
import com.lawrence.domain.Girl;
import com.lawrence.domain.Result;
import com.lawrence.repository.GirlRepository;
import com.lawrence.service.GirlService;
import com.lawrence.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liush
 * 2018/8/21   3:12
 */
@RestController
public class GirlController {

    private static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList=>start");
        return girlRepository.findAll();
    }

    /**
     * 添加
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Validated Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        try {
            girl = girlRepository.save(girl);
        }catch (Exception e){
            return ResultUtil.error(1,e.getMessage());
        }

        return ResultUtil.success(girl);
    }

    /**
     * id查询
     */
    @GetMapping(value = "/girls/{id}")
    public Girl queryGirl(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    /**
     * 年龄查询
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> queryByage(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 更新一个
     */
    @PostMapping(value = "/girls/{id}")
    public boolean updateGirl(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age){
        Girl girl = queryGirl(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        try {
            girlRepository.saveAndFlush(girl);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * 删除一个
     */
    @DeleteMapping(value = "/girls/{id}")
    public boolean deleteGirl(@PathVariable("id") Integer id){

        try {
            girlRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @PostMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
