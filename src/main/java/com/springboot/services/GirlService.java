package com.springboot.services;

import com.springboot.beans.Girl;
import com.springboot.beans.Result;
import com.springboot.enums.GirlEnum;
import com.springboot.exception.GirlException;
import com.springboot.repository.GirlRepository;
import com.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girlOptional = girlRepository.findById(id);
        Girl girl = girlOptional.get();
        int age = girl.getAge();
        if(age >= 18 && age < 30){
            throw new GirlException(GirlEnum.SO_SEXY.getCode(),GirlEnum.SO_SEXY.getMessage());
        }else if(age >= 31 && age < 40){
            throw new GirlException(GirlEnum.TOO_OLD.getCode(),GirlEnum.TOO_OLD.getMessage());
        }
    }
}
