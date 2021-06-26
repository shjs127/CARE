<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>


<%@ page import="auth.service.Message"
	import="auth.service.MessageListView"
	import="auth.service.GetMessageListViewService"%>

<%@ include file="../include/header.jspf"%>

<style type="text/css">
#wrap {
	width: 800px;
	margin: 0 auto 0 auto;
}

#detailBoard {
	text-align: center;
}

#title {
	height: 16;
	font-family: '돋움';
	font-size: 12;
	text-align: center;
	background-color: #F7F7F7;
}

#btn {
	font-family: '돋움';
	font-size: 14;
	text-align: center;
}

#map {
	width: 100%;
	height: 450px;
	position: relative;
	overflow: hidden;
	background: url('./pages/image/loading_n.png');
	margin-top: 2%;
}
</style>
<!-- Search Section Starts -->
<section class="search-area condensed parallax">
	<!-- Nested Container Starts -->
	<div class="container text-center">
		<h3 class="text-weight-normal">Find the best Restaurants, Cafes
			&amp; Cuisine in Your Place</h3>
		<form class="top-search">
			<div class="input-group">
				<div class="input-group-prepend search-panel">
					<button type="button"
						class="btn btn-lg btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="fa fa-map-marker"></span> <span class="text-label">Please
							type location</span>
					</button>
					<ul class="dropdown-menu rounded-0">
						<a href="#" class="dropdown-item">All of Texas</a>
						<a href="#" class="dropdown-item lead text-uppercase">Popular
							Places</a>
						<a href="#" class="dropdown-item">Huston, Texas</a>
						<a href="#" class="dropdown-item">San Antonio, Texas</a>
						<a href="#" class="dropdown-item">Galveston, Texas</a>
						<a href="#" class="dropdown-item">Corpus Christi, Texas</a>
					</ul>
				</div>
				<input type="text" class="form-control input-lg rounded-0"
					name="search-location"
					placeholder="Search for a Restaurants, Cafes, Cuisine, etc..,">
				<button class="btn btn-lg btn-prime animation text-uppercase"
					type="button">Search</button>
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
					Hyderabad</a></li>
			<li class="list-inline-item"><a href="#">Begumpet</a></li>
			<li class="active list-inline-item">Hyderabad Spl Food Dabha</li>
		</ul>

	</div>
	<!-- Nested Container Ends -->
</div>
<!-- BreadCrumb Ends -->
<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Heading Starts -->
	<h4 class="main-heading-1 text-xs-center text-sm-center text-md-left">
		${storeinfo.storeName}





		<ul class="list-unstyled float-lg-right text-lg-right">
			<li class="list-inline-item">${storeAvg}</li>
		</ul>
		
		
		<c:if test="${isExisFavoriteData}">

			<button id="starCheck">

				<ul class="list-unstyled list-inline rating-star-list">
					<li class="list-inline-item"><i class="fa fa-star"></i></li>
				</ul>

			</button>
		</c:if>
		<c:if test="${!isExisFavoriteData}">
			<button id="starCheck">
				

				<ul class="list-unstyled list-inline rating-star-list">
					<li class="list-inline-item"><i class="fa fa-star-o"></i></li>
				</ul>

			</button>
		</c:if>
		
	</h4>



	<!-- Heading Ends -->
	<!-- Main Banner Starts -->
	<div class="banner-area"></div>
	<!-- Main Banner Ends -->
	<!-- Nested Row Starts -->
	<div class="row">
		<!-- Mainarea Starts -->
		<div class="col-md-9 col-sm-12">
			<!-- Menu Tabs Starts -->
			<div class="menu-tabs-wrap">

				<!-- Menu Tabs List Starts -->
				<ul
					class="nav nav-tabs nav-menu-tabs text-xs-center text-sm-center text-md-left">
					<li class="nav-item"><a href="#information"
						class="nav-link active" data-toggle="tab">매장 정보</a></li>

					<!-- <li class="nav-item"><a href="#gallery" class="nav-link"
						data-toggle="tab">매장 사진첩</a></li> -->
					<li class="nav-item"><a href="#reviews" class="nav-link"
						data-toggle="tab">리뷰</a></li>

				</ul>
				<%
					int count;

				if (session.getAttribute("count") != null) {
					count = ((Integer) session.getAttribute("count")).intValue();

				}

				else {
					count = 0;
				}

				count++;
				%>

				- 방문 횟수 :
				<%=count%>

				<%
					session.setAttribute("count", new Integer(count));
				%>
				<br> <br>

				<!-- Menu Tabs List Ends -->
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<div id="information" class="tab-pane fade show active">
						<!-- Tab #2 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<div class="side-block-1">
									<h6>정보</h6>
									<ul class="list-unstyled list-style-2">
										<li>주소 : ${storeinfo.address }</li>
										<li>영업시간 : ${storeinfo.hours }</li>
										<li>휴무일 : ${storeinfo.closedDays }</li>
										<li>전화번호 : ${storeinfo.callNumber }</li>
									</ul>
									<hr>
									&ensp;&ensp;총 좌석 수: <span class="float-right text-spl-color">${detailinfo.totalSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;충전기가 있는 좌석 수: <span
										class="float-right text-spl-color">${detailinfo.socketSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;디저트: <span class="float-right text-spl-color">${detailinfo.dessertSales }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;테라스: <span class="float-right text-spl-color">${detailinfo.terrace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;루프탑: <span class="float-right text-spl-color">${detailinfo.roofTop }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;와이파이: <span class="float-right text-spl-color">${detailinfo.wifi }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;애견동반: <span class="float-right text-spl-color">${detailinfo.companionDog }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;주차공간: <span class="float-right text-spl-color">${detailinfo.parkingSpace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;노키즈존: <span class="float-right text-spl-color">${detailinfo.noKidsZone }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;흡연존: <span class="float-right text-spl-color">${detailinfo.smokingArea }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>

								</div>


							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
									<p class="text-center"></p>
									<!-- Spacer Starts -->
									<!-- Spacer Ends -->

									<!-- 지도를 보여주는 html -->
									<div id="map"></div>

									<!-- 자바스크립트 -->
									<script type="text/javascript"
										src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ecfa9545ea95f1247efbf60cf9429d4c&libraries=services"></script>
									<script>
										var storeAddress = "${storeinfo.address}";
										var storeName = "${storeinfo.storeName}";
										var mapContainer = document
												.getElementById('map'), // 지도를 표시할 div 
										mapOption = {
											center : new daum.maps.LatLng(
													33.450701, 126.570667), // 지도의 중심좌표 
											level : 3
										// 지도의 확대 레벨 
										};
										// 지도를 생성합니다 
										var map = new daum.maps.Map(
												mapContainer, mapOption);
										// 주소-좌표 변환 객체를 생성합니다 
										var geocoder = new daum.maps.services.Geocoder();

										// 주소로 좌표를 검색합니다 
										geocoder
												.addressSearch(
														storeAddress,
														function(result, status) {
															// 정상적으로 검색이 완료됐으면 
															if (status === daum.maps.services.Status.OK) {
																var coords = new daum.maps.LatLng(
																		result[0].y,
																		result[0].x);
																// 결과값으로 받은 위치를 마커로 표시합니다 
																var marker = new daum.maps.Marker(
																		{
																			map : map,
																			position : coords
																		});
																// 인포윈도우로 장소에 대한 설명을 표시합니다 
																var infowindow = new daum.maps.InfoWindow(
																		{
																			content : '<div style="width:150px;text-align:center;padding:6px 0;">'
																					+ storeName
																					+ '</div>'
																		});
																infowindow
																		.open(
																				map,
																				marker);

																// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다 
																map.relayout();
																map
																		.setCenter(coords);
																// 												map.setLevel(4);
																// 												map.setLevel(3);
																// 												map.relayout();
																// 												setTimeout(function(){ 
																// 													map.relayout(); 
																// 												}, 0);
															}
														});
									</script>



									<!-- Spacer Starts -->
									<!-- Spacer Ends -->
									<!-- Banners Starts -->
									<!-- Banners Ends -->
								</div>
								<!-- Information Tab Pane Ends -->
							</div>
							<!-- Right Column Ends -->
						</div>
						<!-- Tab #2 Nested Row Ends -->
					</div>
					<!-- Tab #1 Ends -->
					<!-- Tab #2 Starts -->
					<div id="menu" class="tab-pane fade">

						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<script>
									function wishList1() {
										let answer = confirm("로그인이 필요합니다.");

										if (answer == true) {
											location.href = "/CARE/login.do";
										} else if (answer != true) {

										}

									}
									$(function() {
										$("#starCheck")
												.on(
														"click",
														function() {

															var storeNo = "${storeinfo.storeNo}";
															var userNo = "${authUser.userNo}";
															var sendData = 'storeNo='
																	+ storeNo
																	+ '&userNo='
																	+ userNo;

															if (userNo == "") {

																let answer = confirm("로그인이 필요합니다.");
																if (answer == true) {
																	location.href = "/CARE/login.do";
																} else if (answer != true) {

																}

															}

															$
																	.ajax({
																		url : "favorite.do",
																		type : "POST",
																		data : sendData,
																		success : function() {
																			location
																					.reload();
																		}
																	});
														});
									});
								</script>

								<br>
							</div>

							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Order Menu Tab Pane Starts -->
								<div
									class="order-menu-tab-pane text-xs-center text-sm-center text-md-left">
									<p class="text-center"></p>
									<!-- Order Menu List #1 Starts -->


									<div class="spacer"></div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<!-- Order Menu List #1 Ends -->
									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->
									<!-- Order Menu List #2 Starts -->

									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix"></div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<!-- Order Menu List #2 Ends -->
									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->
									<!-- Order Menu List #3 Starts -->

									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<div class="order-menu-item clearfix">
										<div class="float-left"></div>
										<div class="float-right"></div>
									</div>
									<!-- Order Menu List #3 Ends -->
								</div>
								<!-- Order Menu Tab Pane Ends -->
								<!-- Pagination Starts -->
								<div class="pagination-block clearfix"></div>
								<!-- Pagination Ends -->
								<!-- Banners Starts -->
								<div class="row text-center">
									<div class="col-6"></div>
									<div class="col-6"></div>
								</div>
								<!-- Banners Ends -->
							</div>
							<!-- Right Column Ends -->
						</div>
						<!-- Tab #1 Nested Row Ends -->

					</div>
					<!-- Tab #2 Ends -->


					<!-- Tab #3 Starts -->
					<div id="gallery" class="tab-pane fade">
						<!-- Image Gallery Starts -->

						<!-- Image Gallery Ends -->
					</div>
					<!-- Tab #3 Ends -->
					<!-- Tab #4 Starts -->
					<div id="reviews" class="tab-pane fade">

						<!-- Tab #4 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								<div class="side-block-1">
									<h6>정보</h6>
									<ul class="list-unstyled list-style-2">
										<li>주소 : ${storeinfo.address }</li>
										<li>영업시간 : ${storeinfo.hours }</li>
										<li>휴무일 : ${storeinfo.closedDays }</li>
										<li>전화번호 : ${storeinfo.callNumber }</li>
									</ul>
									<hr>
									&ensp;&ensp;총 좌석 수: <span class="float-right text-spl-color">${detailinfo.totalSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;충전기가 있는 좌석 수: <span
										class="float-right text-spl-color">${detailinfo.socketSeat }개&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;디저트: <span class="float-right text-spl-color">${detailinfo.dessertSales }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;테라스: <span class="float-right text-spl-color">${detailinfo.terrace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;루프탑: <span class="float-right text-spl-color">${detailinfo.roofTop }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;와이파이: <span class="float-right text-spl-color">${detailinfo.wifi }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;애견동반: <span class="float-right text-spl-color">${detailinfo.companionDog }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;주차공간: <span class="float-right text-spl-color">${detailinfo.parkingSpace }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;노키즈존: <span class="float-right text-spl-color">${detailinfo.noKidsZone }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>
									&ensp;&ensp;흡연존: <span class="float-right text-spl-color">${detailinfo.smokingArea }&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</span><br>

								</div>
							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Reviews Tab Pane Starts -->
								<div class="reviews-tab-pane">

									<!-- Reviews Form Box Starts -->
									<div class="reviews-form-box">
										<h6>리뷰쓰기</h6>

										<section class="content">

											<!-- Default box -->

											<div class="box-body">

												<%
													// 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
												if (session.getAttribute("authUser") == null) {
												%>
												<a href="#"
													class="btn btn-black animation text-uppercase float-right"
													onclick="wishList1();">리뷰쓰기</a>
												<%
													}

												// 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
												else {
												%>

												<div class="box-body">
													<form action="writeMessage.do" method="post" id="writeForm">
														<!-- // form에 ID 지정 -->
														<input type="hidden" name="storeNo"
															value="${param.storeno }" />
														<p>
															<textarea name="reviewContents" cols="60" rows="10"
																placeholder="리뷰를 작성하세요"></textarea>
														</p>

														<script type="text/javascript">
															$(function() {
																$("#writeForm")
																		.submit(
																				function() {
																					if ($("#reviewContents").val() == "") {
																						alert("리뷰 내용을 입력하세요!");
																						$("#reviewContents").focus();
																						return false;
																					}
																				});
															});
														</script>
<!-- 리뷰변경 -->

														<h9>별점을 선택하세요.</h9>
														<select name="avgScore">

															<option value="1">★☆☆☆☆</option>
															<option value="2">★★☆☆☆</option>
															<option value="3">★★★☆☆</option>
															<option value="4">★★★★☆</option>
															<option value="5" selected>★★★★★</option>
														</select> <br> <br>

														<p>
															<input type="submit" value="리뷰쓰기"
																class="btn btn-black animation text-uppercase float-right" />
														</p>
													</form>

													<form action="file.do" method="post"
														enctype="multipart/form-data">
														<tr>
															<td></td>
															<td><input type="file" name="fileName1"></td>
														</tr>
													</form>

													<%
														}
													%>

												</div>
											</div>
										</section>


									</div>
									<!-- Content Wrapper. Contains page content -->
									<div class="content-wrapper">
										<!-- Content Header (Page header) -->
										<section class="content-header"></section>

										<!-- Main content -->

										<!-- Default box -->
										<div class="box">


											<div class="review-list">
												<c:if test="${view.isEmpty()}">
													<p>등록된 메시지가 없습니다.</p>
												</c:if>
												<c:if test="${!view.isEmpty()}">
													<table border="1">
														<c:forEach var="message" items="${view.messageList}">
															<div class="clearfix">
																<div class="float-left">
																	<h6>
																		<i class="fa fa-calendar"></i> ${message.reviewDate}
																	</h6>
																	<h6>회원 닉네임: ${userInfo.nickName}</h6>

																</div>
																<img src="images/review-thumb-img1.png" alt="Image"
																	class="img-fluid float-right">
															</div>
															<div class="review-list-content">
																<p>리뷰내용: ${message.reviewContents}</p>
																<p>평점: ${message.avgScore}</p>
																<p>메시지 번호: ${message.reviewNo}</p>
															</div>
														</c:forEach>
													</table>

													<div>
														<c:forEach var="pageNum" begin="1"
															end="${view.totalPages}">
															<span><a href="messageList.jsp?page=${pageNum}">[${pageNum}]</a></span>
														</c:forEach>
													</div>
												</c:if>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
					<!-- Reviews Form Box Ends -->
					<!-- Reviews List Starts -->
					<!-- Default box -->
					<div class="box">

						<div class="box-body">

							<div class="reviews-box">

								<!-- Review #1 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>



									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #1 Ends -->
								<!-- Review #2 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #2 Ends -->
								<!-- Review #3 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #3 Ends -->
								<!-- Review #4 Starts -->
								<div class="review-list">
									<div class="clearfix">
										<div class="float-left"></div>

									</div>
									<div class="review-list-content"></div>
								</div>
								<!-- Review #4 Ends -->
							</div>
							<!-- Reviews List Ends -->
							<!-- Spacer Starts -->
							<div class="spacer-1 condensed"></div>
							<!-- Spacer Ends -->
							<!-- Banners Starts -->
							<div class="row text-center">
								<div class="col-6"></div>
								<div class="col-6"></div>
							</div>
							<!-- Banners Ends -->
						</div>
						<!-- Reviews Tab Pane Ends -->
					</div>
					<!-- Right Column Ends -->
				</div>
				<!-- Tab #4 Nested Row Ends -->
			</div>
			<!-- Tab #4 Ends -->
			<!-- Tab #5 Starts -->
			<div id="reachus" class="tab-pane fade">
				<!-- Tab #5 Nested Row Starts -->
				<div class="row">
					<!-- Left Column Starts -->

					<!-- Tab #5 Nested Row Ends -->
				</div>
				<!-- Tab #5 Ends -->
			</div>

			<div class="col-md-3 col-sm-12">
				<!-- Spacer Starts -->
				<div class="spacer-1 medium d-xs-block d-sm-block d-md-none"></div>
				<!-- Spacer Ends -->
				<!-- Your Order Starts -->
				<div class="side-block-order border-radius-4">
					<!-- Heading Starts -->
					<h6 class="text-center">가게 메뉴</h6>
					<!-- Heading Ends -->
					<!-- Order Content Starts -->

					<c:forEach var="menuInfo2" items="${menuListView.menuInfoList}">
								  &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
								    메뉴 이름:  ${menuInfo2.menu }&ensp;<br>
									&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
									 -가격:  <span class="float-right text-spl-color">${menuInfo2.price }
							&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<br>
						</span>

						<br>
					</c:forEach>

				</div>

			</div>

		</div>

	</div>
</div>

<%@ include file="../include/footer.jspf"%>