package com.springboot.repository;

import com.springboot.beans.Girl;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 *@Author: XieLiang
 *@Date : 2018/7/2
 *@Comment :
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    /**
     * 根据女生姓名模糊查询
     * @param name
     * @return
     */
    List<Girl> findByGirlNameLike(String name);
}
