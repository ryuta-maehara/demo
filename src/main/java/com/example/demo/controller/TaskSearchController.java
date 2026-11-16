package com.example.demo.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.StatusService;
import com.example.demo.service.TaskService;
import com.example.demo.entity.Task;
import com.example.demo.form.TaskSearchListForm;

@Controller
@RequiredArgsConstructor
public class TaskSearchController {

  private final TaskService taskService;
  private final StatusService statusService;

  @GetMapping("/top")
  public String showListSelection(@ModelAttribute("taskSearchListForm") TaskSearchListForm taskSearchListForm,
      Model model) {

    model.addAttribute("statusList", statusService.findAll()); // 取得したステータス一覧をmodelにセットする。
    return "task-list";
  }

  @PostMapping("/task-search-list")
  public String searchList(
      @Validated @ModelAttribute TaskSearchListForm form,
      Model model) {

    Task task = new Task();
    if (!form.getTaskName().isEmpty()) {
      task.setTaskName("%" + form.getTaskName() + "%");
    }
    task.setLimitDate(form.getLimitDate()); // limitDateに指定が無い場合はnullが送られてくる。その場合はnullのまま。
    
    if (!form.getStatusCode().isEmpty()) {
      task.setStatusCode(form.getStatusCode());
    }

    model.addAttribute("taskSummaryList", taskService.findListByConditions(task)); // 取得したタスク一覧をmodelにセットする。
    model.addAttribute("statusList", statusService.findAll()); // 取得したステータス一覧をmodelにセットする。

    return "task-list";
  }
}
