package com.springboot.controllers;

import com.springboot.beans.Girl;
import com.springboot.beans.Result;
import com.springboot.enums.GirlEnum;
import com.springboot.repository.GirlRepository;
import com.springboot.services.GirlService;
import com.springboot.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * 查询所有女生信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        logger.info("getGirlList");
        return girlRepository.findAll();
    }

    /**
     * 新增女生信息
     * @return
     */
    @PostMapping(value = "/girls")
    public Object saveGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(GirlEnum.UNKONW_ERROR.getCode(),GirlEnum.UNKONW_ERROR.getMessage());
            //表单验证
           //logger.info(bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultUtil.success(girlRepository.save(girl));
//        girl.setGirlName(girl.getGirlName());
//        girl.setAge(girl.getAge());
//        girl.setCupSize(girl.getCupSize());
//        return  girlRepository.save(girl);
    }

    /**
     * 根据ID查询女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> findGirlById(@PathVariable("id") Integer id){
        logger.info("findGirlById");
        return girlRepository.findById(id);
    }

    /**
     * 修改女生信息
     * @param id
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           Girl girl){
        girl.setId(id);
        girl.setGirlName(girl.getGirlName());
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return girlRepository.save(girl);
    }

    /**
     * 根据ID删除女生信息
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    @Transactional(rollbackOn = Exception.class)
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 根据姓名模糊查询女生信息
     * @param girlName
     * @return
     */
    @GetMapping(value = "/girls/name/{name}")
    public List<Girl> findByGirlNameLike(@PathVariable("name") String girlName){
        return girlRepository.findByGirlNameLike('%'+girlName+'%');
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
