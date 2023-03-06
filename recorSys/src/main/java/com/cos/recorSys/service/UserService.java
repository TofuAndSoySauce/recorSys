package com.cos.recorSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.recorSys.model.RoleType;
import com.cos.recorSys.model.Users;
import com.cos.recorSys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encodeer;

	// 회원가입시 작동
	@Transactional
	public void 회원가입(Users user) {

		String rawPassword = user.getPassword(); // 원본
		String encPassword = encodeer.encode(rawPassword); // 암호화
		user.setPassword(encPassword);
		user.setRoles(RoleType.USER);
		userRepository.save(user); // 하나의 트랙잭션
	}

	@Transactional
	public void 회원수정(Users user) {
		Users persistance = userRepository.findByUserid(user.getUserid()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword = user.getPassword();
		String encPassword = encodeer.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		/* persistance.setAddress(user.getAddress()); */
	}

	@Transactional
	public void 회원삭제(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		userRepository.delete(persistance);
	}
}