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
import com.example.demo.form.TaskSearchListForm;
import com.example.demo.entity.TaskSummary;

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
  public String postMethodName(
      @Validated @ModelAttribute TaskSearchListForm form,
      Model model) {

    // form内容をsystem.outへ出力する。
    System.out.println("---searchList---");
    System.out.println(form);

    model.addAttribute("taskSummaryList", taskService.findListAll()); // 取得したタスク一覧をmodelにセットする。
    model.addAttribute("statusList", statusService.findAll()); // 取得したステータス一覧をmodelにセットする。

    return "task-list";
  }
}
