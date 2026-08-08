package com.example.demo.repository;

import com.example.demo.entity.TaskSummary;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskRepository {

  // 一覧全検索
  List<TaskSummary> findAll();
}
