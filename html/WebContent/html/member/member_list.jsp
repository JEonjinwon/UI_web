<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
request.setCharacterEncoding("UTF-8");

String postId =request.getParameter("아이디");
String postName = request.getParameter("이름");
%>
[
<%
List<MemberVo> list = (List<MemberVo>)request.getAttribute("memberVoList");
//JSON으로 만들어 주기
for(int i=0;i<list.size();i++){
   MemberVo vo =list.get(i);
   int num = i+1;
   String id =  vo.getId();
   String name =  vo.getName();
   String addr =  vo.getAddr();
   String tel =  vo.getTel();
   
   if(i>0){
      %>, <%
   }
   
   
   	if(postId.equals(id) || postName.equals(name)){
   		%>
   		{ 
   		"num":"<%=num %>"
     	 ,"id":"<%=id %>"
     	 ,"name":"<%=name %>"
     	 ,"addr":"<%=addr %>"
      	,"tel":"<%=tel %> "
     	 } 
   		<%
   		
   	}
   	else if(!postId.equals(id) && !postName.equals(name) 
   				&& (!postId.equals("") || !postName.equals(""))){
   		%>
   		{ 
   		 "num":""
     	 ,"id":""
     	 ,"name":""
     	 ,"addr":""
      	,"tel":""
     	 } 
   		
   	<%	
   	}
   	else if(postId.equals("") && postName.equals(""))
   	{%>
   	{ 
   		 "num":"<%=num %>"
     	 ,"id":"<%=id %>"
     	 ,"name":"<%=name %>"
     	 ,"addr":"<%=addr %>"
      	,"tel":"<%=tel %> "
      	
     	 } 
   	
   	<%
   	}
}
%>  
]