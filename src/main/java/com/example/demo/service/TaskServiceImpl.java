package com.example.demo.service;

import com.example.demo.entity.TaskSummary;
import com.example.demo.repository.TaskRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  /** {@inheritDoc} */
  @Override
  @Transactional(readOnly = true) // 検索系でもパフォーマンスの向上、リソース節約がされるため推奨されている。
  public List<TaskSummary> findAll() {
    return taskRepository.findAll();
  }
}
