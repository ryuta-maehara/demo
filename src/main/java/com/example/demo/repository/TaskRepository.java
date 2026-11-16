package com.example.demo.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TaskSummary;
import com.example.demo.entity.Task;
import com.example.demo.entity.TaskDetail;

@Mapper
public interface TaskRepository {

  // 一覧全検索
  List<TaskSummary> findAll();

  // タスク登録
  void insert(@Param("task") Task task);

  // 条件検索
  List<TaskSummary> selectListByConditions(@Param("task") Task task);

  // タスク詳細検索
  TaskDetail selectDetailByTaskId(@Param("taskId") Integer taskId);
}
