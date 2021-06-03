<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/quiz"  
     user="anuj"  password="Anujsingh@123"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from exam;  
</sql:query>
<table border="2" width="100%">  
<tr>  

<th>question</th>
<th>options</th>  
<th>correct option</th>  
<th>qno</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><a href='waste2?questionr=${Integer.toString(table.qno).concat(1)} '><c:out value="${table.question}"/></a></td>  
<td><a href='waste2?questionr=${Integer.toString(table.qno).concat(2)} '><c:out value="${table.options}"/></td>  
<td><a href='waste2?questionr=${table.qno+.3} '><c:out value="${table.correctoption}"/></td>  
<td><c:out value="${table.qno}"/></td>  
</tr>  
</c:forEach>  
</table>  
     
</body>
</html>