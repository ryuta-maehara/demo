package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Status;

@Mapper
public interface StatusRepository {

    // 全件検索
    List<Status> selectAll();

    // 1件検索
    Status selectByCode(@Param("statusCode") String statusCode);
}
