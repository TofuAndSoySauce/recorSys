package com.cos.recorSys.controller.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.recorSys.dto.ResponseDto;
import com.cos.recorSys.model.Users;
import com.cos.recorSys.repository.UserRepository;
import com.cos.recorSys.service.UserService;

@RestController
public class UserApiController {

	@Autowired 
	private UserService userService;
	@Autowired 
	private UserRepository userRepository;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody Users user) {
		System.out.println("UserApiController 호출됨");
		userService.회원가입(user);
		System.out.println("회원가입 실행");
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}


	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody Users user) {
		userService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/delete")
	public ResponseDto<Integer> delete(@RequestBody Users user) {
		userService.회원삭제(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//userid 존재유무 확인
	@PostMapping("/auth/isUseridExists")
	public ResponseDto<Integer> useridCheckView(@RequestBody Users user) {
		if(!userRepository.existsByUserid(user.getUserid())) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
			
			}else if(userRepository.existsByUserid(user.getUserid())) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), -1);	
			}
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 0);	
	}

}