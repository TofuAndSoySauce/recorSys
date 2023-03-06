package com.cos.recorSys.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="diarys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
@Entity
@SequenceGenerator(
		name = "DIARYS_SEQ_GENERATOR"
		, sequenceName = "DIARY_SEQ"
		, initialValue = 1
		, allocationSize = 1
		)
public class Diarys {

	@Id //기본키
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="DIARYS_SEQ_GENERATOR")
	private long id;
	
	@Column(nullable=true,length=100)
	private String diaryTitle;
	
	@Lob
	private String diaryContent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private Users users; //자바는 오브젝트를 저장할수있지만 DB는 오브젝트를 저장할수없기에 외래키를 사용한다
	
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@CreationTimestamp
	private Timestamp createDate;
	
	@CreatedDate
	@Column(updatable = true)
	private LocalDate diaryDate;
}
