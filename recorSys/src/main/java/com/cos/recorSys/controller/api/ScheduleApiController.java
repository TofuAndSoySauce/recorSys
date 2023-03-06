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
import com.cos.recorSys.model.Schedules;
import com.cos.recorSys.service.ScheduleService;

@RestController
public class ScheduleApiController {
	
	@Autowired
	ScheduleService schedulService;
	
	@PostMapping("/api/schedule")
	public ResponseDto<Integer> save(@RequestBody Schedules schedule, @AuthenticationPrincipal PrincipalDetail principal) {
		schedulService.스케쥴작성(schedule, principal.getUser());
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1);
	}
	@PutMapping("/api/schedule/{id}")
	public ResponseDto<Integer> update(@PathVariable long id,@RequestBody Schedules schedule){
		schedulService.스케쥴수정(id, schedule);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/schedule/{id}")
	public ResponseDto<Integer> delete(@PathVariable long id){
		schedulService.스케쥴삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
