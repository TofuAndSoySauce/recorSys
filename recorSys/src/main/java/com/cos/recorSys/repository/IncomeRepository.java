package com.cos.recorSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.recorSys.model.Incomes;
import com.cos.recorSys.model.Users;

public interface IncomeRepository extends JpaRepository<Incomes, Long> {
//	유저의 총액
	@Query(value =
	        "select sum(income) from incomes "
	        + "where userid = :useridid"
	            , nativeQuery = true
	    )
	    long sumGroupByIncome(
	    		@Param("useridid") long useridid 
	    		);
	
//유저의 날짜별 총액 chart.js 구현을 위해 만들어야함. 아직 안함
	@Query(value =
	        "select sum(income), createdate,id from incomes " +
	            "group by createdate, userid, id having userid = ?1"
	            , nativeQuery = true
	    )
	    List<Incomes> groupByIncomeChartView(long users);
	
	
	//IncomeController chartView
	List<Incomes> findByUsers(Users users);
	
	List<Incomes> findByCreateDateLike(String monthly);
	
	 @Query(value = "select * from incomes where createdate like '__/'||:iMonthly||'%'", nativeQuery=true)
	    List<Incomes> searchMonthlyParam(@Param("iMonthly") String iMonthly); 
}
