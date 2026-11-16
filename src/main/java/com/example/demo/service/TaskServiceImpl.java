package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskDetail;
import com.example.demo.entity.TaskSummary;
import com.example.demo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  /** {@inheritDoc} */
  @Override
  @Transactional(readOnly = true) // 検索系でもパフォーマンスの向上、リソース節約がされるため推奨されている。
  public List<TaskSummary> findListAll() {
    return taskRepository.findAll();
  }

  /** {@inheritDoc} */
  @Override
  @Transactional // 更新系は必ず@Transactionalを付与する。
  public void regist(Task task) {
    taskRepository.insert(task);
  }

  /** {@inheritDoc} */
  @Override
  @Transactional(readOnly = true) // 検索系でもパフォーマンスの向上、リソース節約がされるため推奨されている。
  public List<TaskSummary> findListByConditions(Task task) {
    return taskRepository.selectListByConditions(task);
  }

  /** {@inheritDoc} */
  @Override
  @Transactional(readOnly = true) // 検索系でもパフォーマンスの向上、リソース節約がされるため推奨されている。
  public TaskDetail findDetailByTaskId(Integer taskId) {
    return taskRepository.selectDetailByTaskId(taskId);
  }
}
