package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.form.TaskEditForm;
import com.example.demo.service.StatusService;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskEditController {

    private final StatusService statusService;
    private final TaskService taskService;

    /**
     * タスク編集画面表示リクエスト
     * 
     * @param form
     * @return "task-edit"
     */
    @PostMapping("/task-show-edit")
    public String showEdit(@ModelAttribute TaskEditForm form, Model model) {

        // ステータスリストを取得し Model に設定
        List<Status> list = statusService.findAll();
        model.addAttribute("statusList", list);

        // 編集画面へ遷移
        return "task-edit";
    }

    /**
     * タスク編集リクエスト
     * 
     * @param form
     * @param bindingResult
     * @return "task-edit"
     * @return "task-confirm-edit"
     */
    @PostMapping("/task-edit")
    public String edit(@Validated @ModelAttribute TaskEditForm form,
            BindingResult bindingResult,
            Model model) {

        // 入力チェックエラーがある場合は、編集画面に戻る
        if (bindingResult.hasErrors()) {

            // ステータス一覧を取得してモデルに設定
            List<Status> list = statusService.findAll();
            model.addAttribute("statusList", list);
            return "task-edit";
        }

        // ステータスコードからステータス名を取得してフォームに設定
        Status status = statusService.findByCode(form.getStatusCode());
        form.setStatusName(status.getStatusName());

        // 確認画面へ遷移
        return "task-confirm-edit";
    }

    /**
     * タスク編集確認リクエスト
     * 
     * @param form
     * @param bindingResult
     * @param redirectAttributes
     * @return "task-edit"
     * @return "redirect:/task-complete"
     */
    @PostMapping("/task-confirm-edit")
    public String confirmEdit(@Validated @ModelAttribute TaskEditForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {

        // 入力チェックエラーがある場合は、編集画面に戻る
        if (bindingResult.hasErrors()) {

            // ステータス一覧を取得してモデルに設定
            List<Status> statusList = statusService.findAll();
            model.addAttribute("statusList", statusList);
            return "task-edit";
        }

        Task task = new Task.Builder()
                .taskId(form.getTaskId())
                .taskName(form.getTaskName())
                .statusCode(form.getStatusCode())
                .limitDate(form.getLimitDate())
                .remarks(form.getRemarks())
                .build();

        // ここでとりあえずタスク内容を表示する。
        System.out.println("更新処理スタート");
        System.out.println(task);

        // フラッシュスコープにメッセージを設定
        redirectAttributes.addFlashAttribute("message", "タスクを更新しました。"); // 次のリクエストまで有効なメッセージを設定

        // 完了画面へ遷移
        return "redirect:/task-complete";
    }

}
