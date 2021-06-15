<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메장 정보</title>
</head>
<body>
	<h4>Model2 (MVC + FrontController) 메장 정보</h4>
	<ul>
		<%--- DispatcherServlet에서 요청 처리 
			(TotalCountController) 후,  
			(count-view.jsp)에서 응답 --%>
		<li><a href="front?command=totalCount">전체 상품수 조회</a></li>
		<li><a href="find-product-form.jsp">상품 검색</a></li>
		<li><a href="front?command=totalProduct">전체 상품 정보 조회</a></li>
		<%-- 
			command = getmakerlist --> MakerKindController <--> DAO
											ㅣ 
												forward
											ㅣ
											maker-form.jsp
											(제조사를 라디오 버튼으로 보여준다.)
		 --%>
		<li><a href="front?command=getmakerlist">제조사 리스트 조회</a></li>
	</ul>
</body>
</html>