<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Food Bingo - Bootstrap Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Google Web Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic"
	rel="stylesheet" type="text/css">

<!-- Template CSS Files  -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="js/plugins/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="js/plugins/owl-carousel/owl.transitions.css"
	rel="stylesheet">
<link href="js/plugins/owl-carousel/owl.theme.css" rel="stylesheet">
<link href="js/plugins/magnific-popup/magnific-popup.css"
	rel="stylesheet">
<link href="js/plugins/datepicker/datepicker.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">

</head>
<body>
	<!-- Header Starts -->
	<header class="main-header">
		<!-- Nested Container Starts -->
		<div class="container text-xs-center text-sm-center text-lg-left">
			<!-- Nested Row Starts -->
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<!-- Logo Starts -->
					<img src="images/logo.png" alt="FoodBingo" class="logo img-fluid">
					<!-- Logo Ends -->
				</div>
				<div class="col-md-8 col-sm-12">
					<!-- Top Links Starts -->
					<ul
						class="list-unstyled list-inline top-links text-md-right text-weight-bold">
						<li class="list-inline-item"><a href="#">Help</a></li>
						<li class="list-inline-item"><a href="#">Request Call
								Back</a></li>
						<li class="list-inline-item"><a href="login.html">Register</a></li>
						<li class="list-inline-item"><a href="login.html">Login</a></li>
					</ul>
					<!-- Top Links Ends -->
					<!-- Starts -->
					<ul class="list-unstyled list-inline text-md-right order-info">
						<li class="list-inline-item lead"><i class="fa fa-phone"></i>
							Call : 001 9876 543 210</li>
						<li class="list-inline-item d-xs-none d-sm-none d-md-inline">&nbsp;</li>
						<li class="list-inline-item"><a href="#"
							class="btn btn-light animation">Order Food Online!</a></li>
					</ul>
					<!-- Ends -->
				</div>
			</div>
			<!-- Nested Row Ends -->
		</div>
		<!-- Nested Container Ends -->
	</header>
	<!-- Header Ends -->
	<!-- Main Menu Starts -->
	<nav id="nav" class="main-menu navbar navbar-expand-md rounded-0">
		<!-- Nested Container Starts -->
		<div class="container">
			<!-- Navbar Toggler Starts -->
			<button class="navbar-toggler ml-auto rounded-0" type="button"
				data-toggle="collapse" data-target=".navbar-cat-collapse"
				aria-controls=".navbar-cat-collapse" aria-expanded="false"
				aria-badge="Toggle navigation">
				<span class="navbar-toggler-icon fa fa-bars"></span>
			</button>
			<!-- Navbar Toggler Ends -->
			<!-- Navbar Cat collapse Starts -->
			<div class="collapse navbar-collapse navbar-cat-collapse">
				<ul class="nav navbar-nav text-uppercase text-weight-bold">
					<li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="about.html" class="nav-link">About
							Us</a></li>
					<li class="nav-item active"><a href="food-listing.html"
						class="nav-link">Food List</a></li>
					<li class="nav-item"><a href="food-grid.html" class="nav-link">Food
							Grid</a></li>
					<li class="nav-item"><a href="food-details.html"
						class="nav-link">Food Detail</a></li>
					<li class="nav-item"><a href="login.html" class="nav-link">Login
							&amp; Register</a></li>
					<li class="nav-item"><a href="terms.html" class="nav-link">Terms</a></li>
					<li class="nav-item"><a href="policy.html" class="nav-link">Policy</a></li>
					<li class="nav-item"><a href="contact.html" class="nav-link">Contact
							Us</a></li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
						<ul class="dropdown-menu rounded-0 float-md-right">
							<a href="index.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Home</a>
							<a href="about.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> About Us</a>
							<a href="food-listing.html" class="dropdown-item active"><i
								class="fa fa-angle-right"></i> Food List</a>
							<a href="food-grid.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Food Grid</a>
							<a href="food-details.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Food Detail</a>
							<a href="login.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Login &amp; Register</a>
							<a href="terms.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Terms</a>
							<a href="policy.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Policy</a>
							<a href="contact.html" class="dropdown-item"><i
								class="fa fa-angle-right"></i> Contact Us</a>
						</ul></li>
				</ul>
			</div>
			<!-- Navbar Cat collapse Ends -->
		</div>
		<!-- Nested Container Ends -->
	</nav>
	<!-- Main Menu Ends -->
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
						<!-- ???????????? ?????? -->
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
		<h4 class="main-heading-1 text-xs-center text-sm-center text-md-left">
			<br class="d-xs-block d-sm-block d-md-none">
			<!-- <a href="#" class="btn btn-main animation" data-toggle="modal" data-target="#change-location">Change Location <i class="fa fa-angle-double-right"></i></a> -->
			<!-- ?????? ?????? ?????? -->
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
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-default rounded-0" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
					<!-- Search Field Ends -->
					<!-- Sort By Field Starts -->
					<select class="form-control rounded-0 sidearea-filter-sort">
						<option>Sort by : ???????????????</option>
						<option>Top Rated</option>
						<option>Latest</option>
						<option>Cost</option>
						<option>Cheap</option>
					</select>
					<!-- Sort By Field Ends -->
					<!-- Filter By Restaurants Starts -->
					<h6 class="sidearea-filter-title">?????? ????????????</h6>



					<script type="text/javascript">
						function test_checkbox() {
							var flag = false;

							var values = document
									.getElementsByClass("form-check");
							alert(values.length);
							for (var i = 0; i < values.length; i++) {
								if (values[i].checked) {
									alert(values[i].value);
								}
							}

							return flag;
						}
					</script>
					
					
					
					


					<div class="sidearea-filter-checkbox-list">
						<div class="form-check">



							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option1"> ??? ????????? ???
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option2"> ????????? ????????? ???
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option3"> ???????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option4"> ?????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option5"> ?????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option6"> ????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option7"> ????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option8"> ????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option9"> ????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input" value="option9"> ????????????
							</label>
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input type="submit"
								onclick="return test_checkbox ()">
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
				<!-- Hotels List Starts -->
				<div class="hotels-list text-xs-center text-sm-center text-lg-left">
					<!-- List #1 Starts -->
					<div class="list-box clearfix">
						<!-- List Thumb Starts -->
						<div class="float-lg-left">
							<p>
								<a
									href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
									src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


							</p>
						</div>
						<!-- List Thumb Ends -->
						<!-- List Descriptions Starts -->
						<div class="float-lg-left list-box-info">
							<h5 class="list-box-info-title">
								<a href="food-details.html">37.5 ?????????</a>
							</h5>


                  <a href="food-details.html" class="btn-detail"
                     onclick="trackEvent('CLICK_RESTAURANT', {&quot;position&quot;:0,&quot;restaurant_key&quot;:&quot;3JyWTs_O5vx1&quot;})">
                      <div class="restaurant-more-text">????????? ></div>
                  </a>
							<ul class="list-unstyled list-inline list-box-info-tags">
								<li class="list-inline-item"><a href="#">?????????</a></li>

							</ul>
							<ul
								class="list-unstyled list-inline list-box-info-description text-weight-bold">

							</ul>
							<ul class="list-unstyled list-inline list-box-info-links">
								<li class="list-inline-item"><i class="fa fa-tag"></i> <a
									href="#">????????????</a></li>
								<li class="list-inline-item"><i class="fa fa-info-circle"></i>
									<a href="#">Information</a></li>
								<li class="list-inline-item"><i
									class="fa fa-star-half-full"></i> <a href="#">Food Reviews</a></li>
								<li class="list-inline-item"><i class="fa fa-asterisk"></i>
									<a href="#">Our Special</a></li>
							</ul>
						</div>
						<!-- List Descriptions Ends -->
						<!-- List Right Col Starts -->
						<div
							class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
							<ul class="list-unstyled list-inline list-box-ratings">
								<li class="list-inline-item star-rating"><i
									class="fa fa-star" data-rating="1"></i> <i class="fa fa-star"
									data-rating="2"></i> <i class="fa fa-star" data-rating="3"></i>
									<i class="fa fa-star-o" data-rating="4"></i> <i
									class="fa fa-star-o" data-rating="5"></i></li>
								<!-- <li class="list-inline-item">45 Ratings</li> -->
								<!-- 45Ratings ?????? -->
								<li class="list-inline-item"><a href="#"
									class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
							</ul>
							<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
							<!-- Flat 10% off ,  ???????????? ??? ?????? -->

						</div>
						<!-- List Right Col Ends -->
					</div>
					<!-- List #1 Ends -->
					<!-- List #2 Starts -->
					<div class="hotels-list text-xs-center text-sm-center text-lg-left">
						<!-- List #1 Starts -->
						<div class="list-box clearfix">
							<!-- List Thumb Starts -->
							<div class="float-lg-left">
								<p>
									<a
										href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
										src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


								</p>
							</div>
							<!-- List Thumb Ends -->
							<!-- List Descriptions Starts -->
							<div class="float-lg-left list-box-info">
								<h5 class="list-box-info-title">
									<a href="food-details.html">37.5 ?????????</a>
								</h5>


								<a href="food-details.html" class="dropdown-item"><i
									class="fa fa-angle-right"></i> Food Detail</a>
								<ul class="list-unstyled list-inline list-box-info-tags">
									<li class="list-inline-item"><a href="#">?????????</a>,</li>
									<li class="list-inline-item"><a href="#">?????????</a>
								</ul>
								<ul
									class="list-unstyled list-inline list-box-info-description text-weight-bold">

								</ul>
								<ul class="list-unstyled list-inline list-box-info-links">
									<li class="list-inline-item"><i class="fa fa-tag"></i> <a
										href="#">????????????</a></li>
									<li class="list-inline-item"><i class="fa fa-info-circle"></i>
										<a href="#">Information</a></li>
									<li class="list-inline-item"><i
										class="fa fa-star-half-full"></i> <a href="#">Food Reviews</a></li>
									<li class="list-inline-item"><i class="fa fa-asterisk"></i>
										<a href="#">Our Special</a></li>
								</ul>
							</div>
							<!-- List Descriptions Ends -->
							<!-- List Right Col Starts -->
							<div
								class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
								<ul class="list-unstyled list-inline list-box-ratings">
									<li class="list-inline-item star-rating"><i
										class="fa fa-star" data-rating="1"></i> <i class="fa fa-star"
										data-rating="2"></i> <i class="fa fa-star" data-rating="3"></i>
										<i class="fa fa-star-o" data-rating="4"></i> <i
										class="fa fa-star-o" data-rating="5"></i></li>
									<!-- <li class="list-inline-item">45 Ratings</li> -->
									<!-- 45Ratings ?????? -->
									<li class="list-inline-item"><a href="#"
										class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
								</ul>
								<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
								<!-- Flat 10% off ,  ???????????? ??? ?????? -->

							</div>
							<!-- List Right Col Ends -->
						</div>
						<!-- List #2 Ends -->
						<!-- List #3 Starts -->
						<div
							class="hotels-list text-xs-center text-sm-center text-lg-left">
							<!-- List #1 Starts -->
							<div class="list-box clearfix">
								<!-- List Thumb Starts -->
								<div class="float-lg-left">
									<p>
										<a
											href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
											src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


									</p>
								</div>
								<!-- List Thumb Ends -->
								<!-- List Descriptions Starts -->
								<div class="float-lg-left list-box-info">
									<h5 class="list-box-info-title">
										<a href="food-details.html">37.5 ?????????</a>
									</h5>


									<a href="food-details.html" class="dropdown-item"><i
										class="fa fa-angle-right"></i> Food Detail</a>
									<ul class="list-unstyled list-inline list-box-info-tags">
										<li class="list-inline-item"><a href="#">?????????</a>,</li>
										<li class="list-inline-item"><a href="#">?????????</a>,</li>
										<li class="list-inline-item"><a href="#">????????????</a>
									</ul>
									<ul
										class="list-unstyled list-inline list-box-info-description text-weight-bold">
									</ul>
									<ul class="list-unstyled list-inline list-box-info-links">
										<li class="list-inline-item"><i class="fa fa-tag"></i> <a
											href="#">????????????</a></li>
										<li class="list-inline-item"><i class="fa fa-info-circle"></i>
											<a href="#">Information</a></li>
										<li class="list-inline-item"><i
											class="fa fa-star-half-full"></i> <a href="#">Food
												Reviews</a></li>
										<li class="list-inline-item"><i class="fa fa-asterisk"></i>
											<a href="#">Our Special</a></li>
									</ul>
								</div>
								<!-- List Descriptions Ends -->
								<!-- List Right Col Starts -->
								<div
									class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
									<ul class="list-unstyled list-inline list-box-ratings">
										<li class="list-inline-item star-rating"><i
											class="fa fa-star" data-rating="1"></i> <i class="fa fa-star"
											data-rating="2"></i> <i class="fa fa-star" data-rating="3"></i>
											<i class="fa fa-star-o" data-rating="4"></i> <i
											class="fa fa-star-o" data-rating="5"></i></li>
										<!-- <li class="list-inline-item">45 Ratings</li> -->
										<!-- 45Ratings ?????? -->
										<li class="list-inline-item"><a href="#"
											class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
									</ul>
									<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
									<!-- Flat 10% off ,  ???????????? ??? ?????? -->

								</div>
								<!-- List Right Col Ends -->
							</div>
							<!-- List #3 Ends -->
							<!-- List #4 Starts -->
							<div
								class="hotels-list text-xs-center text-sm-center text-lg-left">
								<!-- List #1 Starts -->
								<div class="list-box clearfix">
									<!-- List Thumb Starts -->
									<div class="float-lg-left">
										<p>
											<a
												href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
												src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


										</p>
									</div>
									<!-- List Thumb Ends -->
									<!-- List Descriptions Starts -->
									<div class="float-lg-left list-box-info">
										<h5 class="list-box-info-title">
											<a href="food-details.html">37.5 ?????????</a>
										</h5>


										<a href="food-details.html" class="dropdown-item"><i
											class="fa fa-angle-right"></i> Food Detail</a>
										<ul class="list-unstyled list-inline list-box-info-tags">
											<li class="list-inline-item"><a href="#">?????????</a>,</li>
											<li class="list-inline-item"><a href="#">?????????</a>,</li>
											<li class="list-inline-item"><a href="#">????????????</a>,</li>
											<li class="list-inline-item"><a href="#">????????????</a>
										</ul>
										<ul
											class="list-unstyled list-inline list-box-info-description text-weight-bold">

										</ul>
										<ul class="list-unstyled list-inline list-box-info-links">
											<li class="list-inline-item"><i class="fa fa-tag"></i> <a
												href="#">????????????</a></li>
											<li class="list-inline-item"><i
												class="fa fa-info-circle"></i> <a href="#">Information</a></li>
											<li class="list-inline-item"><i
												class="fa fa-star-half-full"></i> <a href="#">Food
													Reviews</a></li>
											<li class="list-inline-item"><i class="fa fa-asterisk"></i>
												<a href="#">Our Special</a></li>
										</ul>
									</div>
									<!-- List Descriptions Ends -->
									<!-- List Right Col Starts -->
									<div
										class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
										<ul class="list-unstyled list-inline list-box-ratings">
											<li class="list-inline-item star-rating"><i
												class="fa fa-star" data-rating="1"></i> <i
												class="fa fa-star" data-rating="2"></i> <i
												class="fa fa-star" data-rating="3"></i> <i
												class="fa fa-star-o" data-rating="4"></i> <i
												class="fa fa-star-o" data-rating="5"></i></li>
											<!-- <li class="list-inline-item">45 Ratings</li> -->
											<!-- 45Ratings ?????? -->
											<li class="list-inline-item"><a href="#"
												class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
										</ul>
										<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
										<!-- Flat 10% off ,  ???????????? ??? ?????? -->

									</div>
									<!-- List Right Col Ends -->
								</div>
								<!-- List #4 Ends -->
								<!-- List #5 Starts -->
								<div
									class="hotels-list text-xs-center text-sm-center text-lg-left">
									<!-- List #1 Starts -->
									<div class="list-box clearfix">
										<!-- List Thumb Starts -->
										<div class="float-lg-left">
											<p>
												<a
													href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
													src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


											</p>
										</div>
										<!-- List Thumb Ends -->
										<!-- List Descriptions Starts -->
										<div class="float-lg-left list-box-info">
											<h5 class="list-box-info-title">
												<a href="food-details.html">37.5 ?????????</a>
											</h5>


											<a href="food-details.html" class="dropdown-item"><i
												class="fa fa-angle-right"></i> Food Detail</a>
											<ul class="list-unstyled list-inline list-box-info-tags">
												<li class="list-inline-item"><a href="#">?????????</a>,</li>
												<li class="list-inline-item"><a href="#">?????????</a>,</li>
												<li class="list-inline-item"><a href="#">????????????</a>,</li>
												<li class="list-inline-item"><a href="#">????????????</a>,</li>
												<li class="list-inline-item"><a href="#">????????????</a>
											</ul>
											<ul
												class="list-unstyled list-inline list-box-info-description text-weight-bold">

											</ul>
											<ul class="list-unstyled list-inline list-box-info-links">
												<li class="list-inline-item"><i class="fa fa-tag"></i>
													<a href="#">????????????</a></li>
												<li class="list-inline-item"><i
													class="fa fa-info-circle"></i> <a href="#">Information</a></li>
												<li class="list-inline-item"><i
													class="fa fa-star-half-full"></i> <a href="#">Food
														Reviews</a></li>
												<li class="list-inline-item"><i class="fa fa-asterisk"></i>
													<a href="#">Our Special</a></li>
											</ul>
										</div>
										<!-- List Descriptions Ends -->
										<!-- List Right Col Starts -->
										<div
											class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
											<ul class="list-unstyled list-inline list-box-ratings">
												<li class="list-inline-item star-rating"><i
													class="fa fa-star" data-rating="1"></i> <i
													class="fa fa-star" data-rating="2"></i> <i
													class="fa fa-star" data-rating="3"></i> <i
													class="fa fa-star-o" data-rating="4"></i> <i
													class="fa fa-star-o" data-rating="5"></i></li>
												<!-- <li class="list-inline-item">45 Ratings</li> -->
												<!-- 45Ratings ?????? -->
												<li class="list-inline-item"><a href="#"
													class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
											</ul>
											<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
											<!-- Flat 10% off ,  ???????????? ??? ?????? -->

										</div>
										<!-- List Right Col Ends -->
									</div>
									<!-- List #5 Ends -->
									<!-- List #6 Starts -->
									<div
										class="hotels-list text-xs-center text-sm-center text-lg-left">
										<!-- List #1 Starts -->
										<div class="list-box clearfix">
											<!-- List Thumb Starts -->
											<div class="float-lg-left">
												<p>
													<a
														href="https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%2037.5/place/1277536510?c=14144229.3642523,4467881.9789618,13,0,0,0,dh&placePath=%3Fentry%253Dpll"><img
														src="images/hotels/thumb/37.5.png" width="150" height="" /></a>


												</p>
											</div>
											<!-- List Thumb Ends -->
											<!-- List Descriptions Starts -->
											<div class="float-lg-left list-box-info">
												<h5 class="list-box-info-title">
													<a href="food-details.html">37.5 ?????????</a>
												</h5>


												<a href="food-details.html" class="dropdown-item"><i
													class="fa fa-angle-right"></i> Food Detail</a>
												<ul class="list-unstyled list-inline list-box-info-tags">
													<li class="list-inline-item"><a href="#">?????????</a>,</li>
													<li class="list-inline-item"><a href="#">?????????</a>,</li>
													<li class="list-inline-item"><a href="#">????????????</a>,</li>
													<li class="list-inline-item"><a href="#">????????????</a>,</li>
													<li class="list-inline-item"><a href="#">????????????</a>,</li>
													<li class="list-inline-item"><a href="#">????????????</a></li>
												</ul>
												<ul
													class="list-unstyled list-inline list-box-info-description text-weight-bold">

												</ul>
												<ul class="list-unstyled list-inline list-box-info-links">
													<li class="list-inline-item"><i class="fa fa-tag"></i>
														<a href="#">????????????</a></li>
													<li class="list-inline-item"><i
														class="fa fa-info-circle"></i> <a href="#">Information</a></li>
													<li class="list-inline-item"><i
														class="fa fa-star-half-full"></i> <a href="#">Food
															Reviews</a></li>
													<li class="list-inline-item"><i class="fa fa-asterisk"></i>
														<a href="#">Our Special</a></li>
												</ul>
											</div>
											<!-- List Descriptions Ends -->
											<!-- List Right Col Starts -->
											<div
												class="float-lg-right right-col text-xs-center text-sm-center text-lg-right">
												<ul class="list-unstyled list-inline list-box-ratings">
													<li class="list-inline-item star-rating"><i
														class="fa fa-star" data-rating="1"></i> <i
														class="fa fa-star" data-rating="2"></i> <i
														class="fa fa-star" data-rating="3"></i> <i
														class="fa fa-star-o" data-rating="4"></i> <i
														class="fa fa-star-o" data-rating="5"></i></li>
													<!-- <li class="list-inline-item">45 Ratings</li> -->
													<!-- 45Ratings ?????? -->
													<li class="list-inline-item"><a href="#"
														class="badge animation"><i class="fa fa-heart"></i> 10</a></li>
												</ul>
												<!-- <h6 class="sub-title"><i class="fa fa-certificate"></i> Flat 10% Off</h6>
								<a href="#" class="btn btn-prime animation">
									View Menu <i class="fa fa-chevron-right"></i>
								</a> -->
												<!-- Flat 10% off ,  ???????????? ??? ?????? -->

											</div>
											<!-- List Right Col Ends -->
										</div>
										<!-- List #6 Ends -->
									</div>
									<!-- Hotels List Ends -->
									<!-- Pagination Starts -->
									<div class="pagination-block clearfix">
										<ul class="pagination animation float-lg-right">
											<li class="page-item"><a href="#" class="page-link">&laquo;</a></li>
											<li class="page-item active"><a href="#"
												class="page-link">1</a></li>
											<li class="page-item"><a href="#" class="page-link">2</a></li>
											<li class="page-item"><a href="#" class="page-link">3</a></li>
											<li class="page-item"><a href="#" class="page-link">4</a></li>
											<li class="page-item"><a href="#" class="page-link">5</a></li>
											<li class="page-item"><a href="#" class="page-link">&raquo;</a></li>
										</ul>
									</div>
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
						<div class="modal fade" id="change-location" tabindex="-1"
							role="dialog" aria-labelledby="change-location">
							<div class="modal-dialog" role="document">
								<!-- Modal Content Starts -->
								<div class="modal-content">
									<!-- Modal Header Starts -->
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title">Choose your location in
											Jacksonville</h4>
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
											<label class="sr-only" for="newsletter-city">Please
												Select Your City</label> <input type="text" class="form-control"
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
														have read &amp; accepted the terms and conditions and
														privacy policy</span>
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
						<!-- Footer Area Starts -->
						<footer class="main-footer">
							<!-- Nested Container Starts -->
							<div class="container">
								<!-- Starts -->
								<div class="row">
									<!-- Logo Starts -->
									<div
										class="col-lg-3 col-sm-12 text-xs-center text-sm-center text-lg-left">
										<img src="images/logo.png" alt="FoodBingo" class="img-fluid">
									</div>
									<!-- Logo Ends -->
									<!-- Page Links Starts -->
									<div class="col-lg-6 col-sm-12">
										<ul class="list-unstyled list-inline page-links text-center">
											<li class="list-inline-item"><a href="index.html">Home</a></li>
											<li class="list-inline-item"><a href="about.html">About
													Us</a></li>
											<li class="list-inline-item"><a href="#">Recipes</a></li>
											<li class="list-inline-item"><a href="#">Foods</a></li>
											<li class="list-inline-item"><a href="#">Catering</a></li>
											<li class="list-inline-item"><a href="contact.html">Contact
													Us</a></li>
										</ul>
									</div>
									<!-- Page Links Ends -->
									<!-- Social Media Links Starts -->
									<div class="col-lg-3 col-sm-12">
										<ul
											class="list-unstyled list-inline sm-links text-xs-center text-sm-center text-lg-right">
											<li class="list-inline-item"><a href="#"
												class="btn btn-prime animation"> <i
													class="fa fa-twitter"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="btn btn-prime animation"> <i
													class="fa fa-facebook"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="btn btn-prime animation"> <i
													class="fa fa-linkedin"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="btn btn-prime animation"> <i class="fa fa-skype"></i>
											</a></li>
											<li class="list-inline-item"><a href="#"
												class="btn btn-prime animation"> <i
													class="fa fa-pinterest"></i>
											</a></li>
										</ul>
									</div>
									<!-- Social Media Links Ends -->
								</div>
								<!-- Ends -->
								<!-- Address Section Starts -->
								<section
									class="foot-address text-xs-center text-sm-center text-md-left">
									<h5 class="mt-4 mb-3">Address :</h5>
									<!-- Nested Row Starts -->
									<div class="row">
										<ul class="list-unstyled col-md-4 col-sm-12">
											<li>28 Jackson Blvd Ste 1020 Chicago</li>
											<li>IL 60604-2340</li>
										</ul>
										<ul class="list-unstyled col-md-4 col-sm-12">
											<li>Freephone: +1-800-559-1234</li>
											<li>Telephone: +1-800-603-9874</li>
										</ul>
										<ul class="list-unstyled col-md-4 col-sm-12">
											<li>FAX: +1-800-999-9898</li>
											<li>E-mail: <a href="mailto:mail@foodbingodemo.com">mail@foodbingodemo.com</a></li>
										</ul>
									</div>
									<!-- Nested Row Ends -->
								</section>
								<!-- Address Section Ends -->
								<!-- Links Section Starts -->
								<section
									class="footer-links-section text-xs-center text-sm-center text-md-left">
									<!-- Nested Row Starts -->
									<div class="row">
										<!-- Link Col #1 Starts -->
										<div class="col-lg-3 col-md-6 col-sm-12">
											<h5>Restaurants By Area</h5>
											<ul class="list-unstyled">
												<li><a href="#">Restaurants in Madhapur</a></li>
												<li><a href="#">Restaurants in Sainikpuri</a></li>
												<li><a href="#">Restaurants in Banjara Hills</a></li>
												<li><a href="#">Restaurants in Gachibowli</a></li>
												<li><a href="#">Restaurants in Jubilee Hills</a></li>
												<li><a href="#">Restaurants in Secunderabad</a></li>
												<li><a href="#">Restaurants in Hitech City</a></li>
											</ul>
										</div>
										<!-- Link Col #1 Ends -->
										<!-- Link Col #2 Starts -->
										<div class="col-lg-3 col-md-6 col-sm-12">
											<h5>Top Rated Cuisines</h5>
											<ul class="list-unstyled">
												<li><a href="#">North Indian</a></li>
												<li><a href="#">Italian</a></li>
												<li><a href="#">Bengali</a></li>
												<li><a href="#">Chinese</a></li>
												<li><a href="#">Mughlai</a></li>
												<li><a href="#">Continental</a></li>
												<li><a href="#">Hyderabadi Biriyani</a></li>
											</ul>
										</div>
										<!-- Link Col #2 Ends -->
										<!-- Link Col #3 Starts -->
										<div class="col-lg-3 col-md-6 col-sm-12">
											<h5>Popular Restaurants</h5>
											<ul class="list-unstyled">
												<li><a href="#">Hinglish Cafe</a></li>
												<li><a href="#">Mama Mia Italia</a></li>
												<li><a href="#">Khaan Saab</a></li>
												<li><a href="#">Call Of Benga</a></li>
												<li><a href="#">China By Marcopolo</a></li>
												<li><a href="#">Ulavacharu</a></li>
												<li><a href="#">Reshmi's</a></li>
											</ul>
										</div>
										<!-- Link Col #3 Ends -->
										<!-- Link Col #4 Starts -->
										<div class="col-lg-3 col-md-6 col-sm-12">
											<h5>Popular Cities</h5>
											<ul class="list-unstyled">
												<li><a href="#">Pune</a></li>
												<li><a href="#">Bangalore</a></li>
												<li><a href="#">Hyderabad</a></li>
												<li><a href="#">Chennai</a></li>
												<li><a href="#">Delhi</a></li>
												<li><a href="#">Mumbai</a></li>
												<li><a href="#">Gurgaon</a></li>
											</ul>
										</div>
										<!-- Link Col #4 Ends -->
									</div>
									<!-- Nested Row Ends -->
								</section>
								<!-- Links Section Ends -->
								<!-- Copyright Starts -->
								<p class="copyright text-center mb-0">All Rights Reserved
									&copy; 2010 - 2018 Food Bingo Service.</p>
								<!-- Copyright Ends -->
							</div>
							<!-- Nested Container Ends -->
						</footer>
						<!-- Footer Area Ends -->
						<!-- Template JS Files -->
						<script src="js/jquery-3.3.1.min.js"></script>
						<script src="js/popper.min.js"></script>
						<script src="js/bootstrap.min.js"></script>
						<script
							src="js/plugins/bootstrap-filestyle/bootstrap-filestyle.min.js"></script>
						<script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
						<script src="js/plugins/owl-carousel/owl.carousel.js"></script>
						<script
							src="js/plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
						<script
							src="https://maps.googleapis.com/maps/api/js?v=3&amp;sensor=false"></script>
						<script src="js/custom.js"></script>
</body>
</html>