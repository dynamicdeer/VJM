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
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	String preSql = "select * from users where email = ?";
	PreparedStatement  pstmt = conn.prepareStatement(preSql);
	pstmt.setString(1, email);
	ResultSet rs = pstmt.executeQuery();
	
	// �����ϸ� if , �������� ������ else if
	if(rs.next()){
		out.println("������� �̸����Դϴ�.");
		response.sendRedirect("../login.html");
		
	}else{
		preSql = "insert into users ( name, email, password) values ( ?, ?, ?)";
		pstmt = conn.prepareStatement(preSql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		pstmt.executeUpdate();
		
		response.sendRedirect("../views.html");
	}
	DBconn.close();
%>

</body>
</html>