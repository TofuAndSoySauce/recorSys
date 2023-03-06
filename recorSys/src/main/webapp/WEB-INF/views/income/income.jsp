<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>


<form name="incomeSaveForm">
<input id="incomeDate" name="incomeDate" type="date" required="required">
<input id="income" name="income" type="number" placeholder="Income Amount" required="required">

<button id="income-btn-save" type="button">소득</button>
</form>
<form action="/iSearchMonthly" method="get">
스케쥴 월별 보기
<select name="iMonthly">
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

<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">User ID</th>
      <th scope="col">Date</th>
      <th scope="col">Income</th>
    </tr>
  </thead>

<tbody>
<%-- test test
${incomes.userid}
 --%>
<c:forEach var="income" items="${incomes}">
<c:if test="${principal.user.userid==income.users.userid}">
    <tr>
      <th scope="row">${income.id}</th>
      <td>${income.users.userid}</td>
      <td>${income.createDate}</td>
      <td>${income.income}</td>
    </tr>
</c:if>
</c:forEach>
<tr>
<td></td>
</tr>
</tbody>
</table>

<form action="/incomeTot" method="get">
<input name="useridid" id="useridid" value="${principal.user.id}">
<button type="submit">total income</button>
</form>
총액 : ${incomeTots}
<br>
 <a href="/dailyIncomeChart">daily income chart</a>




</main>

<div>
<c:import url="/dailyIncomeChart"></c:import> 
</div>						
<!-- input값 오늘날짜 -->
<script>
  document.getElementById('incomeDate').value= new Date().toISOString().slice(0, 10);
</script>
<script  src="/js/income.js"></script>
<%-- <%@ include file="../layout/footer.jsp"  %> --%>