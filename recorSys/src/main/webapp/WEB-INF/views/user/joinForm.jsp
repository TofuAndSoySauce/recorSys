<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"  %>

<main>
<form>
<input id="userid" name="userid" type="text" placeholder="ID" required oninput="isUseridExists();">
<div id="Context"></div>
<input id="username" name="username" type="text" placeholder="NAME" required>
<input id="password" name="password" type="password" placeholder="PASSWORD" required>
<input id="email" name="email" type="email" placeholder="EMAIL" required>

</form>
<button id="user-btn-save" type="button">회원가입</button>
</main>

<script src="/js/user.js"></script>
<script src="/js/useridCheck.js"></script>
<%@ include file="../layout/footer.jsp"  %>


