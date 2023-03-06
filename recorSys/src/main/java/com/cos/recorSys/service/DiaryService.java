package com.cos.recorSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.recorSys.model.Diarys;
import com.cos.recorSys.model.Users;
import com.cos.recorSys.repository.DiaryRepository;

@Service
public class DiaryService {
	@Autowired
	DiaryRepository diaryRepository;

	@Transactional(readOnly = true)
	public Page<Diarys> 다이어리보기(Pageable pageable) {
		return diaryRepository.findAll(pageable);
	}	
	@Transactional(readOnly = true)
	public Diarys 다이어리상세보기(long id) {
		return diaryRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("diary 상세보기 실패");
		});
	}
	@Transactional
	public void 다이어리작성(Diarys diary, Users user) {
		// TODO Auto-generated method stub
		diary.setUsers(user);
		diaryRepository.save(diary);
		
	}
	@Transactional
	public void 다이어리수정(Diarys requestDiary, Users user, long id) {
		// TODO Auto-generated method stub
		Diarys diary = diaryRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("스케쥴아이디 찾기 실패");
		});
		
		diary.setDiaryTitle(requestDiary.getDiaryTitle());
		diary.setDiaryContent(requestDiary.getDiaryContent());
		diary.setDiaryDate(requestDiary.getDiaryDate());

		
	}	

	@Transactional
	public void 다이어리삭제(Long id) {
		diaryRepository.deleteById(id);
	}
}
