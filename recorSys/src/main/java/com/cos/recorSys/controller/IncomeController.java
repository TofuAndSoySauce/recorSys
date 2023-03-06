package com.cos.recorSys.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.recorSys.config.auth.PrincipalDetail;
import com.cos.recorSys.model.Incomes;
import com.cos.recorSys.repository.IncomeRepository;
import com.cos.recorSys.service.IncomeService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class IncomeController {
	@Autowired
	IncomeService incomeService;
	
	@Autowired
	IncomeRepository incomeRepository;
	
		//income 첫화면
		@GetMapping("/income")
		public String income(Model model) {

				model.addAttribute("incomes",incomeService.소득표());
	
			return "income/income";
		}
		//총액화면에 출력
		@GetMapping("/incomeTot")
		public String incomeTot(Model model,@RequestParam(value = "useridid", required = false) long useridid) {
				model.addAttribute("incomeTots",incomeRepository.sumGroupByIncome(useridid));
				model.addAttribute("incomes",incomeService.소득표());
			return "income/income";
		}
		
		//incomeChart 유저별
		@GetMapping("/dailyIncomeChart")
		public String incomeChart(Model model,@AuthenticationPrincipal PrincipalDetail principal) {			
			List<Incomes> incomeListByUsers = incomeRepository.groupByIncomeChartView(principal.getUser().getId());
			Gson gson = new Gson();
			JsonArray jArray = new JsonArray();
					
			Iterator<Incomes> it = incomeListByUsers.iterator();
			while(it.hasNext()) {
				Incomes curVO = it.next();
				JsonObject object = new JsonObject();
				Long id = curVO.getId();
//				LocalDate to String 변환
				LocalDate createDate =  curVO.getCreateDate();
				String createDateToString= createDate.toString();
//				LocalDate to String 변환끝
				
				long income = curVO.getIncome();
				
			    object.addProperty("ID", id);
				object.addProperty("income", income);
				object.addProperty("createDate", createDateToString);
				jArray.add(object);
			}
					
			String json = gson.toJson(jArray);
			model.addAttribute("json", json);			
			return "income/incomeChart";
		}
		
//		Incomes 월별 검색
		@GetMapping("/iSearchMonthly")
		public String searchDate(Model model, 
				@RequestParam(value = "iMonthly", required = false) String iMonthly) { 
			System.out.println("incomeController 월별 날짜:"+iMonthly);
			
			if(iMonthly == "")  model.addAttribute("incomes", incomeService.소득표());
			else {
				model.addAttribute("incomes", incomeService.소득월별검색(iMonthly));
			}		
			return "income/income";	
		}
}

////Gson 객체 생성
//Gson gson = new Gson();
//
////Student 객체 -> Json 문자열
//String studentJson = gson.toJson(student);
//
////Json 문자열 출력
//System.out.println(studentJson);  // {"id":1,"name":"Anna"}


//
//List<LogVO> logNameList = ls.getLogNameList(dateMap);
//
//Gson gson = new Gson();
//JsonArray jArray = new JsonArray();
//	
//Iterator<LogVO> it = logNameList.iterator();
//while(it.hasNext()) {
//LogVO curVO = it.next();
//JsonObject object = new JsonObject();
//String userid = curVO.getLog_userid();
//int cnt = curVO.getCnt();
//
//object.addProperty("ID", userid);
//object.addProperty("Count", cnt);
//jArray.add(object);
//}
//	
//String json = gson.toJson(jArray);
//model.addAttribute("json", json);
//[출처] Spring에서 DB데이터를 Chart.js 로 시각화하기|작성자 파스텔군
