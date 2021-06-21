<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../include/header.jspf"%>
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
					<!-- 위치변경 삭제 -->
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
	<h2 class=main-heading-1>게 시 판</h2>
	<!-- Heading Ends -->
	<!-- Starts -->
	<div class="row">
		<!-- Sidearea Starts -->
		<div class="col-lg-3 col-md-4 col-sm-12">


			<!-- 검색창 Start -->
			<div class="sidearea-filter">
				<form class="teble-form">
					<select name="f">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="writer">작성자</option>
					</select>
					<!-- Search Field Starts -->
					<div class="input-group sidearea-filter-search">
						<input type="text" name="q" class="form-control rounded-0"
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-default rounded-0" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- 검색창 Ends -->


				<!-- Sort By Field Starts -->
				<form class="teble-form">
				<select name = "v" class="form-control rounded-0 sidearea-filter-sort" onchange="this.form.submit()">
					<option></option>
					<option value ="5">5개씩보기</option>
					<option value ="10">10개씩 보기</option>
				</select>
				</form>
				<!-- Sort By Field Ends -->
			</div>
		</div>
		<!-- Spacer For Smaller Ends -->
		<!-- Sidearea Ends -->
		<!-- Mainarea Starts -->
		<div class="col-lg-9 col-md-8 col-sm-12">
			<!-- Hotels List Starts -->
			<div class="hotels-list text-xs-center text-sm-center text-lg-left">
				<!-- List #1 Starts -->
				<!-- List Descriptions Starts -->
				<div class="float-center list-box-info">


					<c:if test="${articlePage.hasNoArticles()}">
						<tr>
							<td colspan="4">게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="article" items="${articlePage.list}">
						<div class="list-box clearfix">
							<h5 class="list-box-info-title">
								<a href="read.do?boardNo=${article.boardNo}">
								<c:choose>
								<c:when test = "${fn:length(article.boardTitle) gt 15}">
								<c:out value = "${fn:substring(article.boardTitle,0,14)}...">
								</c:out>
								</c:when>
								<c:otherwise>
								<c:out value= "${article.boardTitle}"></c:out></c:otherwise>
								</c:choose>
								</a>
							</h5>
							<a href="read.do?boardNo=${article.boardNo}"
								class="dropdown-item"><i class="fa fa-angle-right"></i>
								<c:choose>
								<c:when test = "${fn:length(article.boardContents) gt 50}">
								<c:out value = "${fn:substring(article.boardContents,0,49)}...">
								</c:out>
								</c:when>
								<c:otherwise>
								<c:out value= "${article.boardContents}"></c:out></c:otherwise>
								</c:choose></a>
							<!-- <ul class="list-unstyled list-inline list-box-info-tags">
								<li class="list-inline-item"><a href="#">Pizza</a>,</li>
								<li class="list-inline-item"><a href="#">American</a>,</li>
								<li class="list-inline-item"><a href="#">Sandwiches</a>,</li>
								<li class="list-inline-item"><a href="#">Steak House</a>,</li>
								<li class="list-inline-item"><a href="#">Pasta</a>,</li>
								<li class="list-inline-item"><a href="#">Wraps</a></li>
							</ul>
							<ul
								class="list-unstyled list-inline list-box-info-description text-weight-bold">
								<li class="list-inline-item"><span>Delivery In</span><br>
									1h 15min</li>
								<li class="list-inline-item"><span>Delivery Fee</span><br>
									$5.00</li>
								<li class="list-inline-item"><span>Min Order</span><br>
									$30.00</li>
								<li class="list-inline-item"><span>Distance</span><br>
									1.2 miles</li>
							</ul> -->
							<ul class="list-unstyled list-inline list-box-info-links">
								<li class="list-inline-item"><i class="fa fa-info-circle"></i>${article.boardDate}</li>
								<li class="list-inline-item"><i
									class="fa fa-star-half-full"></i> <a href="">답글(몇개)</a></li>
								<li class="list-inline-item"><i class="fa fa-asterisk"></i>${article.viewCount}</li>
							</ul>
						</div>
					</c:forEach>
				</div>
				<!-- List Descriptions Ends -->
				<!-- Pagination Starts -->
				<%
				if (session.getAttribute("authUser") != null) {
				%>
				<div style="float: right;">
					<a href="write.do" class="btn btn-primary"
						style="margin-bottom: 14px;">글쓰기</a>
				</div>
				<%
					}
				%>


				<div class="pagination">
					<ul style="margin: 0 auto;"
						class="pagination animation float-lg-right">
						<c:if test="${articlePage.startPage>1}">
							<li class="page-item"><a
								href="?p=${articlePage.startPage-5}&f=&q=&v=${articlePage.pageV}" class="page-link">&laquo;</a></li>
						</c:if>
						<c:if test="${articlePage.startPage<=1}">
							<li class="page-item" onclick="alert('이전 페이지가 없습니다.');"><a
								class="page-link">&laquo;</a></li>
						</c:if>
						<c:forEach var="pNo" begin="${articlePage.startPage}" end="${articlePage.endPage}">
							<c:choose>
								<c:when
									test="${(param.p) == (pNo)}">
									<li class="page-item active"><a
										href="?p=${pNo}&f=${param.f}&q=${param.q}&v=${articlePage.pageV}"
										class="page-link">${pNo}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="?p=${pNo}&f=${param.f}&q=${param.q}&v=${articlePage.pageV}" class="page-link">${pNo}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${articlePage.startPage+5 <= articlePage.totalPages}">
							<li class="page-item"><a href="?p=${articlePage.startPage+5}&f=&q=&v=${articlePage.pageV}"
								class="page-link">&raquo;</a></li>
						</c:if>
						<c:if test="${articlePage.startPage+5 > articlePage.totalPages}">
							<li class="page-item" onclick="alert('다음 페이지가 없습니다.');"><a
								class="page-link">&raquo;</a></li>
						</c:if>
					</ul>
				</div>
				<!-- Pagination Ends -->
				<!-- Banners Starts -->
			</div>
		</div>
		<!-- Mainarea Ends -->
	</div>
	<!-- Ends -->
</div>
<%@ include file="../include/footer.jspf"%>