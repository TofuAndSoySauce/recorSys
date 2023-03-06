<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>
<c:if test="${principal.user.userid==diarys.users.userid}">
<%-- <table border="1px solid" style="margin: 10px;">
     
      <tr><th>#</th><th scope="row">${diarys.id}</th></tr>
      <tr><td>아이디</td><td>${diarys.users.userid}</td></tr>
      <tr>
      	<td>작성일</td>
	      <td>
		      <!-- LocalDate일때는 오류 -->
		      <fmt:formatDate value="${diarys.createDate}" pattern="yyyy-MM-dd"/>
	      </td>
      </tr>
    
</table> --%>
</c:if>



<!-- summernote -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  
<form>
<input type="hidden" id="diaryid" value="${diarys.id}">
<input type="text" class="input-group input-group-lg form-control" value="User ID :  ${diarys.users.userid}" readonly>
다이어리 일자 : <input type="date" class="input-group input-group-lg form-control" id="diaryDate">
제목 : <input type="text" id="diaryTitle" class="input-group input-group-lg form-control"
placeholder="제목을 입력해 주세요" required value="${diarys.diaryTitle}">
<textarea id="diaryContent" class="summernote">${diarys.diaryContent}</textarea>
</form>

<button id="diary-btn-update" type="button">다이어리 수정</button>
<button id="diary-btn-delete" type="button">다이어리 삭제</button>
<script type="text/javascript" src="/js/diary.js"></script>



<script>

	//여기 아래 부분
	$('#diaryContent').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '다이어리를 작성해 주세요',	//placeholder 설정
		  theme: ""
          
	});

</script>
</main>
<%@ include file="../layout/footer.jsp"  %>