package com.example.demo.service;

import com.example.demo.entity.TaskSummary;
import java.util.List;

public interface TaskService {

  /**
   * 一覧全検索
   *
   * @return List<TaskSummary>
   */
  List<TaskSummary> findAll();
}
