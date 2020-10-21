<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>intro post 방식</title>
</head>
<%
request.setCharacterEncoding("UTF-8");

String str =request.getParameter("이름");
String age = request.getParameter("나이");
String[] hobby = request.getParameterValues("hobby");
String hobbyName="";
for(int i =0;i<hobby.length;i++){
	if(i==hobby.length-1){
		hobbyName+=hobby[i];
	}else{
		hobbyName+=hobby[i]+", ";
	}
}
%>
<body>
<h1>Hi~~....
	<br>
	<span id="nameSpan">이름 : <%=str %></span><br>
	<span id="nameSpan">나이 : <%=age %></span><br>
	<span id="nameSpan">취미 : <%=hobbyName%></span></h1>
	
</body>
</html>