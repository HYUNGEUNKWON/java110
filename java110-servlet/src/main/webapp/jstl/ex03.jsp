<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
    <h1>JSTL - c:set</h1>
    <pre>
        - 보관소에 값을 저장한다.
        &lt;c:set
        var="변수명"
        scope=""
        value="보관소에 저장할 값"/>
        http://localhost:8888/jstl/ex03.jsp
    </pre>
<c:set scope="request" var="name1" value="JEJE"/>
1: ${requestScope.name1}<br>
2: ${pageScope.name1}<br>

<c:set var="name2" value="EKEK"/>
1: ${requestScope.name2}<br>
2: ${pageScope.name2}<br>

<c:set var="name3">pppp</c:set>
1: ${requestScope.name3}<br>
2: ${pageScope.name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<jsp:useBean id="m1" class="bitcamp.java110.Member"/>
<jsp:setProperty name="m1" property="no" value="100"/>
<c:set target="${m1}" property="email" value="mnm@mnm.com"/>
${pageScope.m1.no}<br>
${pageScope.m1.email}<br>
</body>
</html>