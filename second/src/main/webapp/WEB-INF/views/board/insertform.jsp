<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> �۾��� �� </h1>
	<form action="insertboard" method=post>
		����:<input type=text name="title" ><br>
		����:<textarea rows=10 cols=100 name="contents" >���⿡ ������ �Է��մϴ� </textarea><br>
		�ۼ���:<input type=text name="writer" 
		value="${sessionScope.loginid }" readonly ><br>
		<input type=submit value="�۾���">
	</form>
</body>
</html>