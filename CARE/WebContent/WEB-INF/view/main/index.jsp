<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
	<!-- Header Ends -->
	<!-- Main Menu Starts -->
		
	<!-- Main Menu Ends -->
	<!-- Search Section Starts -->
		<section class="search-area parallax">
		<!-- Nested Container Starts -->
			<div class="container text-center">
				<h3 class="text-weight-normal">Find the best Restaurants, Cafes &amp; Cuisine in Your Place</h3>
				<form class="top-search"  action="search.do" method="post">
					<div class="input-group">
						<div class="input-group-prepend search-panel">
							<button type="button" class="btn btn-lg btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<span class="fa fa-map-marker"></span>
								<span class="text-label">Please type location</span> 
							</button>
							<ul class="dropdown-menu rounded-0">
								<a href="#" class="dropdown-item">All of Texas</a>
								<a href="#" class="dropdown-item lead text-uppercase">Popular Places</a>
								<a href="#" class="dropdown-item">Huston, Texas</a>
								<a href="#" class="dropdown-item">San Antonio, Texas</a>
								<a href="#" class="dropdown-item">Galveston, Texas</a>
								<a href="#" class="dropdown-item">Corpus Christi, Texas</a>
							</ul>
						</div>
						<input type="text" class="form-control input-lg rounded-0" name="search-location" placeholder="지역, 카페 또는 메뉴">
						<button class="btn btn-lg btn-prime animation text-uppercase" type="button">검색</button>
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
<h4> 평점 Top6 <a href="#" class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a> </h4>

<div class="food-menu-grid row text-center">
<!-- Food Menu #1 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #1 Ends -->
<!-- Food Menu #2 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #2 Ends -->
<!-- Food Menu #3 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #3 Ends -->
<!-- Food Menu #4 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #4 Ends -->
<!-- Food Menu #5 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #5 Ends -->
<!-- Food Menu #6 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
 
</div>
</div>
<!-- Food Menu #6 Ends -->
</div>
<hr>
<h4> 조회수 Top6 <a href="#" class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a> </h4>
<div class="food-menu-grid row text-center">
<!-- Food Menu #1 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #1 Ends -->
<!-- Food Menu #2 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #2 Ends -->
<!-- Food Menu #3 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #3 Ends -->
<!-- Food Menu #4 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #4 Ends -->
<!-- Food Menu #5 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #5 Ends -->
<!-- Food Menu #6 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #6 Ends -->
</div>

<hr>
<h4> 즐겨찾기 <a href="#" class="btn btn-prime text-weight-bold text-uppercase animation">더보기</a></h4>
<div class="food-menu-grid row text-center">
<!-- Food Menu #1 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #1 Ends -->
<!-- Food Menu #2 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #2 Ends -->
<!-- Food Menu #3 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #3 Ends -->
<!-- Food Menu #4 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #4 Ends -->
<!-- Food Menu #5 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
</a>
<h4 class="text-uppercase">cafe</h4>
</div>
</div>
<!-- Food Menu #5 Ends -->
<!-- Food Menu #6 Starts -->
<div class="col-lg-4 col-md-6 col-sm-12">
<div class="hover-content">
<a href="#" target="_blank">
<img src="<%=request.getContextPath()%>/WEB-INF/images/menu/thumb/chinese-menu.jpg" alt="chinese" class="img-fluid animation">
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
	
<%@ include file="../include/footer.jspf"%>