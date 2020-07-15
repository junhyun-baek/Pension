<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String users_id=(String)session.getAttribute("users_id");
	
	String day1=request.getParameter("1days");
	String day2=request.getParameter("2days");
	String day3=request.getParameter("3days");
	String day4=request.getParameter("4days");
	
	String[] checked=request.getParameterValues("check");
	
	int a=0;
	for(int i=0;i<checked.length;i++){
		if(checked[i].equals("1")){
			a+=(Integer.parseInt(day1))*200000;
		}
		if(checked[i].equals("2")){
			a+=(Integer.parseInt(day2))*200000;	
		}
		if(checked[i].equals("3")){
			a+=(Integer.parseInt(day3))*200000;	
		}
		if(checked[i].equals("4")){
			a+=(Integer.parseInt(day4))*200000;	
		}
	}
	System.out.println(a);
	
	
	for(int i=0;i<checked.length;i++)
		System.out.println(checked[i]);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	// 폼으로부터 전송된 내용 받아서 가격 얼마 무슨 방 맞는지 출력
</script>
</body>
</html>