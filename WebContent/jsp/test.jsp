<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.ofeeldeuk.vjm.db.DBconn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String membername = (String)session.getAttribute("MEMBERNAME");
		boolean login = membername == null ? false : true;
		
		if(login){
			%>	
			아이디 "<%= membername %>"로 로그인한 상태		
		<%
		}else {
			%>
			로그인 하지 않은 상태 
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