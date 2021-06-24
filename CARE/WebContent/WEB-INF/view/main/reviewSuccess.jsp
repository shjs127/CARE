<%@ page contentType = "text/html; charset=utf-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<script>
	alert("성공적으로 저장 되었습니다.");
	//history.go(-1);
	//location.reload();
	location.href="${pageContext.request.contextPath }/main/foodDetail.do?storeno=?";
		/* response.sendRedirect("/WEB-INF/view/login/login.jsp") */
</script>
