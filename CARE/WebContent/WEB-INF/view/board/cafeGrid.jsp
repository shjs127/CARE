<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jspf"%>

<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">Find the best Restaurants, Cafes
			&amp; Cuisine in Your Place</h3>
		<form class="top-search" action="${pageContext.request.contextPath }/board/search.do" method="post" name="frm" id="frm">
			<div class="input-group">
				<div class="input-group-prepend search-panel">
				</div>
				<input type="text" class="form-control input-lg rounded-0" name="searchKeyword" id="searchKeyword" placeholder="지역, 카페 또는 메뉴" value="${param.searchKeyword}">
				<button class="btn btn-lg btn-prime animation text-uppercase" type="submit">검색</button>
			</div>
		</form>
	</div>
	<!-- Nested Container Ends -->
</section>
<!-- Search Section Ends -->
<!-- BreadCrumb Starts -->
<div class="breadcrumb rounded-0">
	<!-- Nested Container Starts -->
	<div class="container text-xs-center text-sm-center text-md-left">
		<ul class="list-unstyled list-inline">
			<li class="list-inline-item"><a href="index.html">Home</a></li>
			<li class="list-inline-item"><a href="#">Restaurants in
					jacksonville</a></li>
			<li class="active list-inline-item">Jack Hills</li>
		</ul>
	</div>
	<!-- Nested Container Ends -->
</div>
<!-- BreadCrumb Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Heading Starts -->
	<h4 class="main-heading-1 text-xs-center text-sm-center text-md-left">
		Order from 45 restaurants in Jack Hills, Jacksonville<br
			class="d-xs-block d-sm-block d-md-none"> <a href="#"
			class="btn btn-main animation" data-toggle="modal"
			data-target="#change-location">Change Location <i
			class="fa fa-angle-double-right"></i></a>
	</h4>
	<!-- Heading Ends -->
	<!-- Starts -->
	<div class="row">
		<!-- Sidearea Starts -->
		<div class="col-lg-3 col-md-4 col-sm-12">
			<!-- Sidearea Filters Starts -->
			<div class="sidearea-filter">
				<!-- Search Field Starts -->
				<div class="input-group sidearea-filter-search">
					<input type="text" class="form-control rounded-0"
						placeholder="검색..."> <span class="input-group-append">
						<button class="btn btn-default rounded-0" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
				<!-- Search Field Ends -->
				<!-- Sort By Field Starts -->
				<select class="form-control rounded-0 sidearea-filter-sort">
					<option>정렬 : 인기순</option>
					<option>평점순</option>
					<option>조회순</option>
				</select>
				<!-- Sort By Field Ends -->
				<!-- Filter By Restaurants Starts -->
				<h6 class="sidearea-filter-title">Filter By cafe</h6>
				<div class="sidearea-filter-checkbox-list">
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option1"> 총 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option2"> 콘센트 테이블 수
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option3"> 디저트 판매
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option4"> 테라스
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option5"> 루프탑
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option6"> 와이파이
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option7"> 애견 동반
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option8"> 주차 공간
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option9"> 노키즈존
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input" value="option10"> 흡연구역
						</label>
					</div>
				</div>
				<!-- Filter By Restaurants Ends -->
			</div>
			<!-- Sidearea Filters Ends -->
			<!-- Spacer For Smaller Devices -->
			<p class="d-xs-block d-sm-block d-md-none">
				<br>
			</p>
			<!-- Spacer For Smaller Ends -->
		</div>
		<!-- Sidearea Ends -->
		<!-- Mainarea Starts -->
		<div class="col-lg-9 col-md-8 col-sm-12">
			<!-- Hotels Grid List Starts -->
			<div class="hotels-list-grid">
				<!-- Nested Row Starts -->
				<div class="row">
					<!-- List Box #1 Starts -->
					<!-- List 시작 -->

					<c:if test="${storePage.hasNoStores()}">
						<div>매장이 없습니다.</div>
					</c:if>

					<c:forEach var="storeinfo" items="${storePage.list}">
						<div class="col-lg-4 col-md-6 col-sm-12">
							<!-- Grid Box Starts -->
							<div class="grid-box">
								<!-- Images Starts -->
								<div class="image text-center">
									<img
										src="<%=request.getContextPath()%>/CARE/images/hotels/thumb/hotel-grid-thumb-img1.jpg"
										alt="Eagle Boys Village Plaza" class="img-fluid img-center">
									<span class="delivery-time">${storeinfo.storeNo}</span>
								</div>

								<!-- Images Ends -->
								<!-- Content Starts -->
								<div class="content text-center text-lg-left">
									<!-- Title Starts -->
									<h6 class="grid-box-title">
										<a href="${pageContext.request.contextPath}/main/foodDetail.do?storeno=${storeinfo.storeNo}">${storeinfo.storeName}</a>
									</h6>
									<!-- Title Ends -->
									<!-- Tags Starts -->
									<ul class="list-unstyled list-inline grid-box-tags">
										<li class="list-inline-item"><a href="#">Pizza</a>,</li>
										<li class="list-inline-item"><a href="#">American</a>,</li>
										<li class="list-inline-item"><a href="#">Pasta</a>,</li>
										<li class="list-inline-item"><a href="#">Wraps</a></li>
									</ul>
									<!-- Tags Ends -->
									<!-- Offer Details Starts -->
									<ul class="list-unstyled grid-box-info clearfix">
										<li class="float-lg-left"><span class="sub-title"><i
												class="fa fa-certificate"></i> Flat 10% Off</span></li>
										<li class="float-lg-right text-lg-right"><a href="#"
											class="btn btn-prime animation"> View Menu <i
												class="fa fa-chevron-right"></i>
										</a></li>
									</ul>
									<!-- Offer Details Ends -->
									<!-- Links Starts -->
									<div class="clearfix">
										<!-- Info Links Starts -->
										<ul
											class="list-unstyled list-inline grid-box-info-links float-lg-left">
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Coupons"><i
													class="fa fa-tag"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top"
												title="Information"><i class="fa fa-info-circle"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Reviews"><i
													class="fa fa-star-half-full"></i></a></li>
											<li class="list-inline-item"><a href="#"
												data-toggle="tooltip" data-placement="top" title="Specials"><i
													class="fa fa-asterisk"></i></a></li>
										</ul>
										<!-- Info Links Ends -->
										<!-- Ratings Starts -->
										<ul
											class="list-unstyled list-inline grid-box-ratings float-lg-right text-lg-right">
											<li class="list-inline-item star-rating"><i
												class="fa fa-star"></i> 45</li>
											<li class="list-inline-item"><a href="#"
												class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
										</ul>
										<!-- Ratings Ends -->
									</div>
									<!-- Links Ends -->
								</div>
								<!-- Content Ends -->
							</div>
							<!-- Grid Box Ends -->
						</div>
						<!-- List Box #1 Ends -->
					</c:forEach>

				</div>
				<!-- Nested Row Ends -->
			</div>
			<!-- Hotels Grid List Ends -->
			<!-- 페이징 처리 -->
			<c:if test="${storePage.hasStores()}">
				<div class="pagination-block clearfix">
					<ul class="pagination animation float-lg-right">
						<c:if test="${storePage.startPage > 5}">
							<li class="page-item"><a
								href="storelist.do?pageNo=${storePage.startPage -5}"
								class="page-link">&laquo;</a></li>
						</c:if>
						<c:forEach var="pNo" begin="${storePage.startPage}"
							end="${storePage.endPage}">
							<li class="page-item"><a href="storelist.do?pageNo=${pNo}"
								class="page-link">${pNo}</a></li>
						</c:forEach>
						<c:if test="${storePage.endPage < storePage.totalPages}">
							<li class="page-item"><a
								href="storelist.do?pageNo=${storePage.startPage + 5}"
								class="page-link">&raquo;</a></li>
						</c:if>
					</ul>
				</div>
			</c:if>
			<!-- Pagination Starts -->
			<!-- <div class="pagination-block clearfix">
                        <ul class="pagination animation float-lg-right">
                            <li class="page-item"><a href="#" class="page-link">&laquo;</a></li>
                            <li class="page-item active"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">&raquo;</a></li>
                        </ul>
                    </div> -->
			<!-- Pagination Ends -->
			<!-- Banners Starts -->
			<div class="row">
				<div class="col-4">
					<img src="images/banners/banner-img1.png" alt="Banner 1"
						class="img-fluid">
				</div>
				<div class="col-4">
					<img src="images/banners/banner-img2.png" alt="Banner 2"
						class="img-fluid">
				</div>
				<div class="col-4">
					<img src="images/banners/banner-img3.png" alt="Banner 3"
						class="img-fluid">
				</div>
			</div>
			<!-- Banners Ends -->
		</div>
		<!-- Mainarea Ends -->
	</div>
	<!-- Ends -->
</div>
<!-- Main Container Ends -->
<!-- Change Location Modal Window Starts -->
<div class="modal fade" id="change-location" tabindex="-1" role="dialog"
	aria-labelledby="change-location">
	<div class="modal-dialog" role="document">
		<!-- Modal Content Starts -->
		<div class="modal-content">
			<!-- Modal Header Starts -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Choose your location in Jacksonville</h4>
			</div>
			<!-- Modal Header Ends -->
			<!-- Modal Body Starts -->
			<div class="modal-body">
				<!-- Nested Container Starts -->
				<div class="container-fluid">
					<h4>Jacksonville City</h4>
					<div class="row">
						<div class="col-md-4 col-sm-12">
							<ul class="list-unstyled">
								<li><a href="#">Abids</a></li>
								<li><a href="#">Adikmet</a></li>
								<li><a href="#">Amberpet</a></li>
								<li><a href="#">Ameerpet</a></li>
								<li><a href="#">Attapur</a></li>
								<li><a href="#">Balanagar</a></li>
								<li><a href="#">Banjara Hills</a></li>
								<li><a href="#">Basheer Bagh</a></li>
								<li><a href="#">Begum Bazaar</a></li>
								<li><a href="#">Begumpet</a></li>
								<li><a href="#">Chanda Nagar</a></li>
								<li><a href="#">Chandrayanagutta</a></li>
								<li><a href="#">Charminar</a></li>
								<li><a href="#">Dilsukhnagar</a></li>
							</ul>
						</div>
						<div class="col-md-4 col-sm-12">
							<ul class="list-unstyled">
								<li><a href="#">Abids</a></li>
								<li><a href="#">Adikmet</a></li>
								<li><a href="#">Amberpet</a></li>
								<li><a href="#">Ameerpet</a></li>
								<li><a href="#">Attapur</a></li>
								<li><a href="#">Balanagar</a></li>
								<li><a href="#">Banjara Hills</a></li>
								<li><a href="#">Basheer Bagh</a></li>
								<li><a href="#">Begum Bazaar</a></li>
								<li><a href="#">Begumpet</a></li>
								<li><a href="#">Chanda Nagar</a></li>
								<li><a href="#">Chandrayanagutta</a></li>
								<li><a href="#">Charminar</a></li>
								<li><a href="#">Dilsukhnagar</a></li>
							</ul>
						</div>
						<div class="col-md-4 col-sm-12">
							<ul class="list-unstyled">
								<li><a href="#">Abids</a></li>
								<li><a href="#">Adikmet</a></li>
								<li><a href="#">Amberpet</a></li>
								<li><a href="#">Ameerpet</a></li>
								<li><a href="#">Attapur</a></li>
								<li><a href="#">Balanagar</a></li>
								<li><a href="#">Banjara Hills</a></li>
								<li><a href="#">Basheer Bagh</a></li>
								<li><a href="#">Begum Bazaar</a></li>
								<li><a href="#">Begumpet</a></li>
								<li><a href="#">Chanda Nagar</a></li>
								<li><a href="#">Chandrayanagutta</a></li>
								<li><a href="#">Charminar</a></li>
								<li><a href="#">Dilsukhnagar</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- Nested Container Ends -->
			</div>
			<!-- Modal Body Ends -->
		</div>
		<!-- Modal Content Ends -->
	</div>
</div>
<!-- Change Location Modal Window Ends -->
<!-- Newsletter Section Starts -->
<section class="footer-top">
	<!-- Nested Container Starts -->
	<div class="container">
		<h3 class="text-center text-weight-bold">Subscribe to our
			Newsletter:</h3>
		<ul class="list-unstyled list-inline text-center">
			<li class="list-inline-item"><i class="fa fa-check-circle"></i>
				Receive deals from all our top restaurants via e-mail</li>
			<li class="list-inline-item"><i class="fa fa-check-circle"></i>
				Don't miss out on our great offers</li>
		</ul>
		<!-- Newsletter Form Starts -->
		<form class="newsletter-form">
			<!-- Nested Row Starts -->
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<label class="sr-only" for="newsletter-city">Please Select
						Your City</label> <input type="text" class="form-control"
						id="newsletter-city" placeholder="Please Select Your City">
				</div>
				<div class="col-md-5 col-sm-12">
					<label class="sr-only" for="newsletter-email">Email</label> <input
						type="text" class="form-control" id="newsletter-email"
						placeholder="Enter Your E-mail Id">
				</div>
				<div class="col-md-3 col-sm-12">
					<button type="submit"
						class="btn btn-prime btn-block text-uppercase text-weight-bold animation">Sign
						Up Now</button>
				</div>
				<div class="col-sm-12 text-center">
					<h6 class="text-weight-bold">
						<label> <input type="checkbox"> <span>I
								have read &amp; accepted the terms and conditions and privacy
								policy</span>
						</label>
					</h6>
				</div>
			</div>
			<!-- Nested Row Ends -->
		</form>
		<!-- Newsletter Form Ends -->
	</div>
	<!-- Nested Container Ends -->
</section>
<!-- Newsletter Section Ends -->

<script type="text/javascript">
	$(function(){
		$("#frm").submit(function(){
			if($("#searchKeyword").val() == ""){
				alert("검색어를 입력하세요!");
				$("#searchKeyword").focus();
				return false;
			}
		});
	});
</script>
<%@ include file="../include/footer.jspf"%>