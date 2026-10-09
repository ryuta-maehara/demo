package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskSummary;

public interface TaskService {

  /**
   * 一覧全検索
   *
   * @return List<TaskSummary>
   */
  List<TaskSummary> findAll();

  /**
   * タスク登録
   *
   * @param task Task
   */
  void regist(Task task);
}
