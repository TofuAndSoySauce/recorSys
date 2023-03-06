package com.cos.recorSys.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.recorSys.config.auth.PrincipalDetail;
import com.cos.recorSys.dto.ResponseDto;
import com.cos.recorSys.model.Diarys;
import com.cos.recorSys.service.DiaryService;

@RestController
public class DiaryApiController {
	@Autowired
	DiaryService diaryService;
	@PostMapping("/api/diary")
	public ResponseDto<Integer> saveDiary(@RequestBody Diarys diary,
			@AuthenticationPrincipal PrincipalDetail principal){
		diaryService.다이어리작성(diary,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/api/diary/{id}")
	public ResponseDto<Integer> updateDiary(@RequestBody Diarys diary,
			@AuthenticationPrincipal PrincipalDetail principal,@PathVariable long id){
		diaryService.다이어리수정(diary,principal.getUser(),id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/diary/{id}")
	public ResponseDto<Integer> deleteDiary(@PathVariable long id){
		diaryService.다이어리삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
