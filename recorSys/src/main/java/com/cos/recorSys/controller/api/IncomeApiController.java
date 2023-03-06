package com.cos.recorSys.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.recorSys.config.auth.PrincipalDetail;
import com.cos.recorSys.dto.ResponseDto;
import com.cos.recorSys.model.Incomes;
import com.cos.recorSys.service.IncomeService;
@RestController
public class IncomeApiController {
	@Autowired
	IncomeService incomeService;
	@PostMapping("/api/income")
	public ResponseDto<Integer> save(@RequestBody Incomes income, @AuthenticationPrincipal PrincipalDetail principal) {
		incomeService.소득작성(income, principal.getUser());
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1);
	}
	@PutMapping("/api/income/{id}")
	public ResponseDto<Integer> update(@PathVariable long id,@RequestBody Incomes income){
		incomeService.소득수정(id, income);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}







