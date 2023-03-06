<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../layout/header.jsp"  %> --%>


<h5 style="text-align: center;">유저별 그래프</h5>
<canvas id="dailyIncomeChart" style="width: 600px; height: 200px;"></canvas>

<!-- [출처] Spring에서 DB데이터를 Chart.js 로 시각화하기|작성자 파스텔군 -->



<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> 

<!-- 외부링크로 연결하면 작동x chart.js-->
<script>
var jsonData =${json};/* 여기만 jsp에있으면 됨 */
</script>
<!-- chart.js 구현 나머지부분 -->
<script src="/js/incomeChartView.js"></script>

</body>
</html>