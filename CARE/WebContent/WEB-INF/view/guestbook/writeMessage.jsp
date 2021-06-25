<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="auth.service.Message"
	import="auth.service.WriteMessageService"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="message" class="auth.service.Message">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>

<%
	WriteMessageService writeService = WriteMessageService.getInstance();
int writeResult = writeService.writeMessage(message);
if (writeResult == 0)
	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
%>
// ajax success handler의 매개변수로 밑의 내용이 전달됩니다. (저는 사용 안 함)
<html>

<head>
<title>방명록 메시지 남김</title>
</head>

<body>
	방명록에 메시지를 남겼습니다.
	<br>
	<a href="food-details.jsp">[목록 보기]</a>
</body>

</html>