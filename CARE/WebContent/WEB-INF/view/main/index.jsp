<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jspf"%>
<!-- Header Ends -->
<!-- Main Menu Starts -->

<!-- Main Menu Ends -->
<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">
			솔직한 리뷰, 믿을 수 있는 평점! <br> 카레
		</h3>
		<form class="top-search"
			action="${pageContext.request.contextPath }/board/search.do"
			method="post" name="frm" id="frm">
			<div class="input-group">
				<div class="input-group-prepend search-panel"></div>
				<input type="text" class="form-control input-lg rounded-0"
					name="searchKeyword" id="searchKeyword" placeholder="지역, 카페 또는 메뉴"
					value="${param.searchKeyword}">
				<button class="btn btn-lg btn-prime animation text-uppercase"
					type="submit">검색</button>
			</div>
		</form>
	</div>
	<!-- Nested Container Ends -->
</section>
<!-- Search Section Ends -->
<!-- Intro Section Ends -->
<section class="welcome section">
	<!-- Nested Container Starts -->
	<div class="container">
		<!-- Welcome Content Starts -->

		<!-- Welcome Content Ends -->
		<!-- Food Menu Grid Starts -->

		<hr>
		<h4>평점 Top6</h4>

		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<c:forEach var="storea" items="${storageAvgTop}">
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="hover-content">
						<a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${storea.storeNo}">
							<img
							src="<%=request.getContextPath()%>/CARE/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
							alt="Eagle Boys Village Plaza" class="img-fluid img-center">
						</a> <a
							href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${storea.storeNo}">
							<h5 class="text-uppercase">${storea.storeName}
								${storea.storeAvg}</h5>
						</a>
					</div>
				</div>
			</c:forEach>
			<!-- Food Menu #1 Ends -->
		</div>
		<hr>
		<h4>
			조회수 Top6 <a href="#"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #1 Ends -->
			<!-- Food Menu #2 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #2 Ends -->
			<!-- Food Menu #3 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #3 Ends -->
			<!-- Food Menu #4 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #4 Ends -->
			<!-- Food Menu #5 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #5 Ends -->
			<!-- Food Menu #6 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #6 Ends -->
		</div>

		<hr>
		<h4>
			즐겨찾기 <a href="#"
				class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a>
		</h4>
		<div class="food-menu-grid row text-center">
			<!-- Food Menu #1 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #1 Ends -->
			<!-- Food Menu #2 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #2 Ends -->
			<!-- Food Menu #3 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #3 Ends -->
			<!-- Food Menu #4 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #4 Ends -->
			<!-- Food Menu #5 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #5 Ends -->
			<!-- Food Menu #6 Starts -->
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="hover-content">
					<a href="#" target="_blank"> <img
						src="<%=request.getContextPath()%>/CARE/images/menu/thumb/chinese-menu.jpg"
						alt="chinese" class="img-fluid animation">
					</a>
					<h4 class="text-uppercase">cafe</h4>
				</div>
			</div>
			<!-- Food Menu #6 Ends -->

		</div>
		<!-- Food Menu Grid Ends -->
	</div>
	<!-- Nested Container Ends -->
</section>
<!-- Welcome Section Ends -->
<!-- Nested Container Ends -->
<!-- News & Events Section Starts -->
<!-- News & Events Section Ends -->
<!-- Download App Section Starts -->
<!-- Download App Section Ends -->
<!-- Newsletter Section Starts -->
<!-- Nested Container Ends -->
<!-- Newsletter Section Ends -->

<script type="text/javascript">
	$(function() {
		$("#frm").submit(function() {
			if ($("#searchKeyword").val() == "") {
				alert("검색어를 입력하세요!");
				$("#searchKeyword").focus();
				return false;
			}
		});
	});
</script>

<%@ include file="../include/footer.jspf"%>