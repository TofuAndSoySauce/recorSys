<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>
<button onclick="location.href='/diary/save'">글작성하기</button>

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">User ID</th> 
      <th scope="col">Title</th>
      <th scope="col">Content</th>
      <th scope="col">Create Date</th>
      <th scope="col">Diary Date</th>
    </tr>
  </thead>

<tbody>

<c:forEach items="${diarys.content}" var="diary">
<c:if test="${principal.user.userid==diary.users.userid}">
    <tr> 
      <th scope="row">${diary.id}</th>
      <td>${diary.users.userid}</td>
      <td><a href="/diary/${diary.id}"> ${diary.diaryTitle} </a> </td>
      <td>${diary.diaryContent}</td>
      <td>
      <!-- LocalDate일때는 오류 -->
      <fmt:formatDate value="${diary.createDate}" pattern="yyyy-MM-dd"/>
      </td>
      <td>
      ${diary.diaryDate}
      </td>
    </tr>
</c:if>
</c:forEach>
<tr>
<td></td>
</tr>
</tbody>
</table>

<!-- page 설정 -->
<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${diarys.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${diarys.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${diarys.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${diarys.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${diarys.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${diarys.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
</ul>
</main>
<%@ include file="../layout/footer.jsp"  %>