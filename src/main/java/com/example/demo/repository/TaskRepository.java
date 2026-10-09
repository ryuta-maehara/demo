package com.example.demo.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TaskSummary;
import com.example.demo.entity.Task;

@Mapper
public interface TaskRepository {

  // 一覧全検索
  List<TaskSummary> findAll();

  // タスク登録
  void insert(@Param("task") Task task);
}
