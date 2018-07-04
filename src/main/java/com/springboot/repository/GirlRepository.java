package com.springboot.repository;

import com.springboot.beans.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    List<Girl> findByGirlNameLike(String name);
}
