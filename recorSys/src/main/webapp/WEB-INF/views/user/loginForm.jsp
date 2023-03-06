<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>
<form action="/auth/loginProc" method="POST">
<input id="userid" name="userid" placeholder="ID" type="text">
<input id="password" name="password" placeholder="PASSWORD" type="password">
<button type="submit">로그인</button>
</form>
</main>

<%@ include file="../layout/footer.jsp"  %>