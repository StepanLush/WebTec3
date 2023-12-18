<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.luschickij.criticine.criticines.util.Domain" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>
<fmt:setBundle basename="messages"/>

<fmt:setLocale value="en"/>
<fmt:bundle basename="messages"/>
<%
    String domainAddress = Domain.DOMAIN;
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>CritiCine</title>
    <style><%@include file="/WEB-INF/css/header.css"%></style>
</head>
<body>
<div class="header">
    <div class="logo">CritiCine</div>
    <nav>
        <ul>
            <li><a href="<%=domainAddress%>/app/"><fmt:message key="header.home"/></a></li>
        </ul>
    </nav>
    <c:if test="${empty sessionScope.user_role}">
        <div class="button-container">
            <div class="signin-button">
                <a href="<%=domainAddress%>/app/register" class="signin-link"><fmt:message key="header.signIn"/></a>
            </div>
            <div class="login-button">
                <a href="<%=domainAddress%>/app/login" class="login-link"><fmt:message key="header.logIn"/></a>
            </div>
        </div>
    </c:if>
    <c:if test="${not empty sessionScope.user_role}">
        <div class="button-container">
            <form th:action="@{/logout}" method="post">
                <input type="submit" value="<fmt:message key="header.logout"/>"/>
            </form>
            <<%--div class="signin-button">
                <a href="<%=domainAddress%>/app/logout" class="login-link"><fmt:message key="header.logout"/></a>
            </div>--%>
        </div>
    </c:if>
</div>
</body>