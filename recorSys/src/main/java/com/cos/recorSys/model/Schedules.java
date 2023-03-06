package com.cos.recorSys.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="schedules")
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
@Entity
@SequenceGenerator(
		name = "SCHEDULE_SEQ_GENERATOR"
		, sequenceName = "SCHEDULE_SEQ"
		, initialValue = 1
		, allocationSize = 1
		)
public class Schedules {

	@Id //기본키
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCHEDULE_SEQ_GENERATOR")
	private long id;
	
	@Column(nullable=true,length=100)
	private String memo;
	
	/*
	 * @Lob //대용량 데이터. 이미지나 폰트설정도 가능 private String content; //댓글
	 */
	
	//연관관계
	//앞이 나자신 뒤는 다른 한명이 여러개의 게시글을 쓸수있다
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private Users users; //자바는 오브젝트를 저장할수있지만 DB는 오브젝트를 저장할수없기에 외래키를 사용한다
	
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@CreatedDate
	private LocalDateTime createDate;
	
//	@CreatedDate
//	private LocalDate createDateStart;
//	
//	@CreatedDate
//	private LocalDate createDateEnd;

	
}
