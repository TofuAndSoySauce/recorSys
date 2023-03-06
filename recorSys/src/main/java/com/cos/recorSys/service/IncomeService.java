package com.cos.recorSys.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.recorSys.model.Incomes;
import com.cos.recorSys.model.Schedules;
import com.cos.recorSys.model.Users;
import com.cos.recorSys.repository.IncomeRepository;
@Service
public class IncomeService {
	@Autowired
	IncomeRepository incomeRepository;
	
	@Transactional(readOnly = true)
	public Page<Incomes> 소득목록(Pageable pageable) {
		return incomeRepository.findAll(pageable);
	}
	@Transactional(readOnly = true)
	public List<Incomes> 소득표() {
		return incomeRepository.findAll();
	}

	@Transactional
	public void 소득작성(Incomes income,Users user) {
		income.setUsers(user);
		incomeRepository.save(income); // 하나의 트랙잭션
	}

	@Transactional
	public void 소득수정 (Long id, Incomes requestIncome) {
		Incomes income = incomeRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("스케쥴아이디 찾기 실패");
		});
		
		income.setCreateDate(requestIncome.getCreateDate());
		income.setIncome(requestIncome.getIncome());

	}
	
	@Transactional(readOnly = true)
	public List<Incomes> 소득월별검색(String smonthly) {
//		String stringDate = new SimpleDateFormat("yyyy-MM-dd").format(smonthly);
		
		System.out.printf("incomeSevice monthly "+smonthly);
//		String[] modi=monthly.split("-");
//		for(int i=0;i>modi.length;i++) {
//			System.out.println(modi[i]);
//		}
		return incomeRepository.searchMonthlyParam(smonthly);
	}
	
}
