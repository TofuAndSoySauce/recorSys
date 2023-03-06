package com.cos.recorSys.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.recorSys.model.Schedules;
import com.cos.recorSys.model.Users;

public interface ScheduleRepository extends JpaRepository<Schedules, Long>{


	
	List<Schedules> findByMemoContaining(String memo);
	
	List<Schedules> findByCreateDateBetween(LocalDateTime stringStartDate,LocalDateTime stringEndDate);
	List<Schedules> findByCreateDateLike(String monthly);
	
	 @Query(value = "select * from schedules where createDate like '__/'||:monthly||'%'", nativeQuery=true)
	    List<Schedules> searchMonthlyParam(@Param("monthly") String monthly); 

	 List<Schedules> findByUsers(Users users);

	
}
