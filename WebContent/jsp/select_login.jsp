<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="util.dbhelper.DBconn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	Connection conn = DBconn.getConnection();
	
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	//select * from vms.users where email = 'chlgusrla@naver.com' and password = 'eheh12';
	
	String preSql = "select * from users where email = ? and password =?";
	PreparedStatement  pstmt = conn.prepareStatement(preSql);
	pstmt.setString(1, email);
	pstmt.setString(2, password);
	ResultSet rs = pstmt.executeQuery();
	
	// 존재하면 if , 존재하지 않으면 else if
	if(rs.next()){
		response.sendRedirect("../views.html");
	}else{
		response.sendRedirect("../login.html");
	}
	
	DBconn.close();
%>
</body>
</html>