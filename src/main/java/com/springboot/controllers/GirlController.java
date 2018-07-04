package com.springboot.controllers;

import com.springboot.beans.Girl;
import com.springboot.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

/*
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女生信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    /**
     * 新增女生信息
     * @param girlName
     * @param age
     * @param cupSize
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl saveGirl(@RequestParam("girlName") String girlName,
                         @RequestParam("age") int age,
                         @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setGirlName(girlName);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return  girlRepository.save(girl);
    }

    /**
     * 根据ID查询女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> findGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

    /**
     * 修改女生信息
     * @param id
     * @param girlName
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("girlName") String girlName,
                           @RequestParam("age") int age,
                           @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setGirlName(girlName);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 根据ID删除女生信息
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
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


}
