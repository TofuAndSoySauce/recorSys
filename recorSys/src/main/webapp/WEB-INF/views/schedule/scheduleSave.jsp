<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>
<!-- 스케쥴입력  -->
<form>
스케쥴입력 &nbsp; &nbsp; &nbsp; &nbsp;
<input id="memo" name="memo" type="text" placeholder="Memo">
<input id="createDate" name="createDate" type="datetime-local" required>
<button id="schedule-btn-save" type="button">스케쥴 기입</button>
</form>
<!-- 스케쥴 텍스트로 검색 -->
<form action="/searchText" method="GET">
스케쥴 검색 &nbsp; &nbsp; &nbsp;
<input type="text" id="search" name="search" placeholder="빈칸 검색은 전체보기">
<button type="submit" class="searchButton"><i class="fa fa-search"></i></button>	 
</form>
<!-- 스케쥴 기간별 검색 -->
<form action="/searchDate" method="GET">
스케쥴 기간별 &nbsp; &nbsp;
<input type="datetime" name="startDate" id="startDate" placeholder="시작날짜" required="required">  &nbsp;   -   &nbsp; 
<input type="datetime" name="endDate" id="endDate" placeholder="끝날짜" required="required">     
<button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
</form>

<form action="/searchMonthly" method="get">
스케쥴 월별 보기
<select name="monthly">
<option value="01">01
<option value="02">02
<option value="03">03
<option value="04">04
<option value="05">05
<option value="06">06
<option value="07">07
<option value="08">08
<option value="09">09
<option value="10">10
<option value="11">11
<option value="12">12
</select>
<button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
</form>

<%-- <a href="/schedule/${schedule.user.id}">스케쥴보기</a> --%>
<%-- <!-- 스케쥴 출력 -->
 <%@ include file="schedule.jsp"  %> --%>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">User ID</th>
      <th scope="col">Date</th>
      <th scope="col">Memo</th>
    </tr>
  </thead>

<tbody>



<c:forEach var="schedule" items="${schedules}">
<c:if test="${principal.user.userid==schedule.users.userid}">
    <tr>
      <th scope="row">${schedule.id}</th>
      <td>${schedule.users.userid}</td>
      <td>${schedule.createDate}
      
      <!-- java.util.Date 객체로 변환이 되어 LocalDate랑 안맞음. 에러나니 조심 -->
      <%-- <fmt:formatDate value="${schedule.createDate}" pattern="yyyy-MM-DD"/><br /> --%>
      </td>
      <td>${schedule.memo}</td>
      <td>
      <button type="button" onclick="index.deleteById(${schedule.id});"> 
      삭제  
      </button>
      </td>
    </tr>
</c:if>
</c:forEach>
</tbody>
</table>


</main>
<%-- <c:import url="/scheduleCalendar"></c:import> --%>
<a href="/scheduleFullCalendar">캘린더보기</a>


<!-- page 설정 -->
<%-- <ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
</ul> --%>


<!-- <script>
  document.getElementById('createDate').value= new Date().toISOString().slice(0, 10);
</script> -->
<script  src="/js/schedule.js"></script>
<%@ include file="../layout/footer.jsp"  %>