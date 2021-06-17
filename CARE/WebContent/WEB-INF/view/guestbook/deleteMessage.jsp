<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="auth.service.DeleteMessageService" %>
<%@ page import="auth.service.InvalidPasswordException" %>
<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	boolean invaliduserno = false;
	try {
		DeleteMessageService deleteService = 
				DeleteMessageService.getInstance();
		deleteService.deleteMessage(messageId, userNo);
	} catch(InvalidPasswordException ex) {
		invaliduserno = true;
	}
%>
<html>
<head>
	<title>리뷰 삭제함</title>
</head>
<body>
<%  if (!invaliduserno) { %>
리뷰를 삭제하였습니다.
<%  } else { %>
입력한 USERNO가 올바르지 않습니다. USERNO를 확인해주세요.
<%  }%>
<br/>
<a href="food-details.jsp">[목록 보기]</a>
</body>
</html>