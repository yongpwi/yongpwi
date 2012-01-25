<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>소녀시대 스케줄</title>
</head>
<body>
    <div>
        스케줄 확인하기
        <ul>
        <c:forEach var="sosi" items="${sosiList}">
            <li><a href="/sosischedule/schedule/${sosi.key.id}">${sosi.key.id}. ${sosi.sosiName}</a></li>
        </c:forEach>
        </ul>
    </div>
</body>
</html>