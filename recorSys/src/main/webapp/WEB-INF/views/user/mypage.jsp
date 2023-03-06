<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>
<main>
ID: ${principal.user.userid} <br>
PW: ${principal.user.password} <br>
name: ${principal.user.username} <br>
email: ${principal.user.email} <br>

</main>
<%@ include file="../layout/footer.jsp"  %>