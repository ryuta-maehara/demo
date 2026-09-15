package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.TaskRegistForm;

@Controller
public class TaskRegistController {

    /**
     * タスク登録画面表示リクエスト
     * 
     * @param form
     * @return "task-regist"
     */
    @PostMapping("/task-show-regist")
    public String showRegist(@ModelAttribute TaskRegistForm form) {
        // 登録画面へ遷移
        return "task-regist";
    }

    /**
     * タスク登録リクエスト
     * 
     * @param form
     * @param bindingResult
     * @return "task-regist"
     * @return "task-confirm-regist"
     */
    @PostMapping("/task-regist")
    public String regist(@Validated @ModelAttribute TaskRegistForm form,
            BindingResult bindingResult) {

        // 入力チェックエラーがある場合は、登録画面に戻る
        if (bindingResult.hasErrors()) {
            return "task-regist";
        }

        // 確認画面へ遷移
        return "task-confirm-regist";
    }

    /**
     * タスク登録確認リクエスト
     * 
     * @param form
     * @param bindingResult
     * @param redirectAttributes
     * @return "task-regist"
     * @return "redirect:/task-complete"
     */
    @PostMapping("/task-confirm-regist")
    public String confirmRegist(@Validated @ModelAttribute TaskRegistForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        // 入力チェックエラーがある場合は、登録画面に戻る
        if (bindingResult.hasErrors()) {
            return "task-regist";
        }

        // 登録処理を実行する（仮)
        System.out.println("タスク登録処理を実行します。");
        System.out.println("タスク名: " + form.getTaskName());
        System.out.println("期限日: " + form.getLimitDate());
        System.out.println("ステータスコード: " + form.getStatusCode());
        System.out.println("備考: " + form.getRemarks());

        // フラッシュスコープにメッセージを設定
        redirectAttributes.addFlashAttribute("message", "タスクを登録しました。"); // 次のリクエストまで有効なメッセージを設定

        // 完了画面へ遷移
        return "redirect:/task-complete";
    }

}
