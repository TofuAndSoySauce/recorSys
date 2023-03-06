package com.cos.recorSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.recorSys.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	DiaryService diaryService;
	//diary Pageable
	@GetMapping("/diary")
	public String diary(Model model,@PageableDefault(size= 10, sort = "id",
			direction = Sort.Direction.DESC) Pageable pageable) {

			model.addAttribute("diarys",diaryService.다이어리보기(pageable));

		return "diary/diary";
	}
	//diary 상세
	@GetMapping("/diary/{id}")
	public String diaryDetail(Model model,@PathVariable long id ) {

			model.addAttribute("diarys",diaryService.다이어리상세보기(id));

		return "diary/diaryDetail";
	}
	//diarySave
	@GetMapping({"/diary/save"})
	public String saveForm() {
		return "diary/diarySave";
	}
}
