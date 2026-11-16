package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskDetail;
import com.example.demo.entity.TaskSummary;

public interface TaskService {

  /**
   * 一覧全検索
   *
   * @return List<TaskSummary>
   */
  List<TaskSummary> findListAll();

  /**
   * タスク登録
   *
   * @param task Task
   */
  void regist(Task task);

  /**
   * 条件検索
   *
   * @param task Task
   * @return List<TaskSummary>
   */
  List<TaskSummary> findListByConditions(Task task);

  /**
   * タスク詳細検索
   *
   * @param taskId Integer
   * @return Task
   */
  TaskDetail findDetailByTaskId(Integer taskId);
}
