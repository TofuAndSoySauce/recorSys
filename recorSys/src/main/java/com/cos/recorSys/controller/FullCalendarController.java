//package com.cos.recorSys.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.cos.recorSys.model.Schedules;
//import com.cos.recorSys.repository.ScheduleRepository;
//import com.cos.recorSys.service.ScheduleService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/full-calendar")
//public class FullCalendarController {
//	@Autowired
//	ScheduleRepository scheduleRepository;
//	
////	logger는 무엇인가
//	//FullCalendarController의 로거는 상수이다.로깅 프레임 워크. 로그작성해서 뭐가문제인지 보려고
//    private static final Logger log = LoggerFactory.getLogger(FullCalendarController.class);
// 
//	private final ScheduleService scheduleService;
// 
//    @GetMapping("/calendar-admin")
//    @ResponseBody
//    public List<Map<String, Object>> monthPlan() {
//        List<Schedules> listAll = scheduleService.findAll();
// 
//        JSONObject jsonObj = new JSONObject();
//        JSONArray jsonArr = new JSONArray();
// 
//        HashMap<String, Object> hash = new HashMap<>();
// 
//        for (int i = 0; i < listAll.size(); i++) {
//            hash.put("title", listAll.get(i).getMemo());
//            hash.put("start", listAll.get(i).getCreateDateStart());
////            hash.put("time", listAll.get(i).getScheduleTime());
// 
//            jsonObj = new JSONObject(hash);
//            jsonArr.add(jsonObj);
//        }
//        log.info("jsonArrCheck: {}", jsonArr);
//        return jsonArr;
//    }
//}
 