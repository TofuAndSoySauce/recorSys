<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>>

<c:forEach var="income" items="${incomeTots}">
${income}
</c:forEach>
</body>
</html>