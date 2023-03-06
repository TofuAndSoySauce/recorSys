package com.cos.recorSys.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.recorSys.model.Schedules;
import com.cos.recorSys.model.Users;
import com.cos.recorSys.repository.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepository;
	@Transactional
	public void 스케쥴작성(Schedules schedule,Users user) {
		schedule.setUsers(user);
		scheduleRepository.save(schedule); // 하나의 트랙잭션
	}

	@Transactional
	public void 스케쥴수정 (Long id, Schedules requestSchedule) {
		Schedules schedule = scheduleRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("스케쥴아이디 찾기 실패");
		});
		
		schedule.setCreateDate(requestSchedule.getCreateDate());
		schedule.setMemo(requestSchedule.getMemo());

	}

//	@Transactional
//	public void 스케쥴삭제(Users user) {
//		Schedules persistance = scheduleRepository.findById(user.getId()).orElseThrow(() -> {
//			return new IllegalArgumentException("회원 찾기 실패");
//		});
//		scheduleRepository.delete(persistance);
//	}
	@Transactional(readOnly = true)
	public Page<Schedules> 스케쥴목록(Pageable pageable) {
		return scheduleRepository.findAll(pageable);
	}
	@Transactional(readOnly = true)
	public List<Schedules> 스케쥴표() {
		return scheduleRepository.findAll();
	}
	
	//검색기능1
	@Transactional(readOnly = true)
	public List<Schedules> 스케쥴표메모검색(String search) {
		System.out.println("검색 scheduleService 스케쥴표검색 "+search);
		return scheduleRepository.findByMemoContaining(search);
	}
	//검색기능2
	@Transactional(readOnly = true)
	public List<Schedules> 스케쥴표기간검색(LocalDateTime stringStartDate,LocalDateTime stringEndDate) {
	
		/* System.out.printf("scheduleSevice 시작날짜 "+시작날짜,"/ 끝날짜 "+끝날짜); */
		
		return scheduleRepository.findByCreateDateBetween(stringStartDate,stringEndDate);
	}
	//검색기능3
	@Transactional(readOnly = true)
	public List<Schedules> 스케쥴표월별검색(String sMonthly) {
//		java.util.Date 타입 
//		String checkDate = new SimpleDateFormat("yyyy-MM-dd").format(monthly);
		System.out.printf("scheduleSevice monthly "+sMonthly);

		return scheduleRepository.searchMonthlyParam(sMonthly);
	}

	public List<Schedules> findAll() {
		// TODO Auto-generated method stub
		return scheduleRepository.findAll();
	}

	public void 스케쥴삭제(long id) {
		// TODO Auto-generated method stub
		scheduleRepository.deleteById(id);
		
	}

	
	
	
}
