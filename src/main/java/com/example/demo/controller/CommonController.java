package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	/**
	 * タスク登録完了画面表示リクエスト
	 * 
	 * @return "task-complete"
	 */
	@GetMapping("/task-complete")
	private String completeTask() {
		return "task-complete";
	}
}
