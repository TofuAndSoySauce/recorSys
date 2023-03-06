package com.cos.recorSys.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.recorSys.config.auth.PrincipalDetail;
import com.cos.recorSys.model.Schedules;
import com.cos.recorSys.repository.ScheduleRepository;
import com.cos.recorSys.service.ScheduleService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor //스케쥴표기간검색시 날짜 parse하기 위해선 필요.
@Controller
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	ScheduleRepository scheduleRepository;

	//schedule 첫화면
	@GetMapping("/schedule")
	public String schedule(Model model) {
		model.addAttribute("schedules", scheduleService.스케쥴표());
		return "schedule/scheduleSave";
	}
	//schedule. 텍스트검색기능
	@GetMapping("/searchText")
	public String serchText(Model model, 
		@RequestParam(value = "search", required = false,defaultValue = "") String searchKeyword) { 
		//search는 input name="search".
	    if(searchKeyword == "")  model.addAttribute("schedules", scheduleService.스케쥴표()); //List<Schedules>
	    else if(searchKeyword != "") {
	        model.addAttribute("schedules", scheduleService.스케쥴표메모검색(searchKeyword));
	    }
	    
	    return "schedule/scheduleSave";
		
	}
	//schedule. find by~between을 이용한 선택기간검색
	@GetMapping("/searchDate")
	public String searchDate(Model model, 
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate
			) { 
		System.out.println("scheduleController 시작날짜"+startDate);
		
//		String to LocalDate
		LocalDateTime stringStartDate = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME);
		LocalDateTime stringEndDate = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME);
		
		
		if(startDate == null&&endDate==null)  model.addAttribute("schedules", scheduleService.스케쥴표()); //혹시나 input의 required 안먹히면 작동할수도있음.
		else {
			model.addAttribute("schedules", scheduleService.스케쥴표기간검색(stringStartDate,stringEndDate));
		}		
		return "schedule/scheduleSave";	
	}
	@GetMapping("/searchMonthly")
	public String searchDate(Model model, 
			@RequestParam(value = "monthly", required = false) String monthly) { 
		System.out.println("scheduleController 월별 날짜:"+monthly);
//		String to LocalDate
//		LocalDate sMonthly = LocalDate.parse(monthly, DateTimeFormatter.ISO_DATE);
		if(monthly == null)  model.addAttribute("schedules", scheduleService.스케쥴표());
		else {
			model.addAttribute("schedules", scheduleService.스케쥴표월별검색(monthly));
		}		
		return "schedule/scheduleSave";	
	}
	@GetMapping("/scheduleCalendar")
	public String scheduleCalendar() {
		return "schedule/scheduleCalendar";
	}
	@GetMapping("/scheduleFullCalendar")
	public String scheduleFullCalendar(Model model,@AuthenticationPrincipal PrincipalDetail principal) {
		
		List<Schedules> scheduleListByUsers = scheduleRepository.findByUsers(principal.getUser());
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
				
		Iterator<Schedules> it = scheduleListByUsers.iterator();
		while(it.hasNext()) {
			Schedules curVO = it.next();
			JsonObject object = new JsonObject();
			Long id = curVO.getId();
			//long id to string
			String stringtoid=id.toString();
		//createDate
//			LocalDate to String 변환
			LocalDateTime createDate =  curVO.getCreateDate();
			String createDateToString= createDate.toString();
//			LocalDate to String 변환끝
		//createDateStart
//			LocalDate to String 변환
//			LocalDate createDateStart =  curVO.getCreateDateStart();
//			String createDateStartToString= createDateStart.toString();
//			LocalDate to String 변환끝
		//createDateEnd	
//			LocalDate to String 변환
//			LocalDate createDateEnd =  curVO.getCreateDateEnd();
//			String createDateEndToString= createDateEnd.toString();
//			LocalDate to String 변환끝
			
			String memo = curVO.getMemo();
			
			object.addProperty("id", stringtoid);
			object.addProperty("title", memo);
			object.addProperty("start", createDateToString);
//			object.addProperty("end", createDateEndToString);
			jArray.add(object);
		}
				
		String json = gson.toJson(jArray);
		model.addAttribute("Schedulejson", json);

		return "schedule/scheduleFullCalendar";
	}
}

