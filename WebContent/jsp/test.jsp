<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.ofeeldeuk.vjm.db.DBconn"%>
<%@ page import="com.ofeeldeuk.vjm.heap.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content=" text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		HeapJpsSource HJS = new HeapJpsSource();
		HeapJps HJ = new HeapJps();

		ArrayList<String> list = new ArrayList<String>();
		String pid = null;
		String Pname = "ProjectTest1RunTime";
		for (int i = 0; i < list.size(); i++) {
	%>
	<%=list.get(i)%><br>
	<%
		}

		//		request.setCharacterEncoding("utf-8");
		//		String name = "Choi";
		//		String email = "Hyun@naver.com";//request.getParameter("email");
		//		String passwd = "bin123";//request.getParameter("passwd");

		//		String preSql = "insert into users ( name, email, password) values ( ?, ?, ?)";
		//		PreparedStatement pstmt = conn.prepareStatement(preSql);
		//		pstmt.setString(1, name);
		//		pstmt.setString(2, email);
		//		pstmt.setString(3, passwd);
		//		pstmt.executeUpdate();

		//		out.println(name + " 님 환영합니다.");
	%>
</body>
</html>