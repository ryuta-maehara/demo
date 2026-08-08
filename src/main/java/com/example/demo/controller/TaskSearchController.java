package com.example.demo.controller;

import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskSearchController {

  private final TaskService taskService;

  @GetMapping("/top")
  public String showListSelection() {
    return "task-list";
  }

  @PostMapping("/task-search-list")
  public String postMethodName(Model model) {

    model.addAttribute("taskSummaryList", taskService.findAll()); // modelにリストをセットする。
    return "task-list";
  }
}
