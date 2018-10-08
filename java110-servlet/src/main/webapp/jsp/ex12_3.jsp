<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션 태그</title>
</head>
<body>
<h1>jsp:useBean - 보관소에 객체가 없을 때?</h1>
<pre>
- 보관소에 객체가 없으면 기본으로 객체를 만든다.
    &lt;jsp:useBean 
        scope ="request" 
        id="names1"
        class="java.util.ArrayList"
        />
- 위의 태그는 다음과 같이 동작하는 자바 코드로 변환 된다.
    자바 코드:
    java.util.ArrayList names1 = (java.util.ArrayList)pageContext.getAttribute("names1");
    if (names1 == null) {
        names1 = new java.lang.String();
       pageContext.setAttribute("names1", names1);
    }

</pre>

<%
ArrayList<String> list1 = new ArrayList<>();
list1.add("홍길동");
list1.add("임꺽정");
list1.add("유관순");
request.setAttribute("names1", list1);
%>

<jsp:useBean 
    scope ="request" 
    id="names1"
    class="java.util.ArrayList"
    />
    
 
<p>이름: <%=names1.get(1)%></p>

<jsp:useBean 
    scope ="request" 
    id="names2"
    class="java.util.ArrayList"
    />
<%-- 자바코드
java.util.ArrayList names1 = (java.util.ArrayList)pageContext.getAttribute("names1");
    if (names2 == null) {
        names2 = new java.util.ArrayList();
       pageContext.setAttribute("names2", names2);
    }
 --%>
 <p>names2의 크기: <%=names2.size() %></p>
 
</body>
</html>

