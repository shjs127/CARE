
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.*"%>


<%@ page import="auth.service.Message"
	import="auth.service.MessageListView"
	import="auth.service.GetMessageListViewService"%>

<!-- Main Container Starts -->
<div class="main-container container">
	<!-- Nested Row Starts -->
	<div class="row">
		<!-- Mainarea Starts -->
		<div class="col-md-9 col-sm-12">
			<!-- Menu Tabs Starts -->
			<div class="menu-tabs-wrap">
				<!-- Menu Tabs List Starts -->
				<ul
					class="nav nav-tabs nav-menu-tabs text-xs-center text-sm-center text-md-left">
					<li class="nav-item"><a href="#menu" class="nav-link active"
						data-toggle="tab">개인정보</a></li>
					<li class="nav-item"><a href="#information" class="nav-link"
						data-toggle="tab">내가쓴 댓글</a></li>
					<li class="nav-item"><a href="#gallery" class="nav-link"
						data-toggle="tab">즐겨찾기</a></li>
				</ul>
				<!-- Menu Tabs List Ends -->
				<!-- Menu Tabs Content Starts -->
				<div class="tab-content">
					<!-- Tab #1 Starts -->
					<div id="menu" class="tab-pane fade show active">
						<!-- Tab #1 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-12 col-sm-20">
								<section class="registration-area">
									<div class="row">
										<div class="col-sm-8">
											<!-- Registration Block Starts -->
											<div class="panel panel-smart">
												<div class="panel-heading">
													<h3 class="panel-title">Personal Information</h3>
												</div>
												<div class="panel-body">
													<!-- Registration Form Starts -->
													<form class="form-horizontal" action="profile.do"
														method="post">
														<!-- Personal Information Starts -->

														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">이 름 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="newUserName" placeholder="${userInfo.name}"
																	required readonly>
																<%-- 	<p>${userInfo.name}</p> --%>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputCurPassword"
																class="col-sm-3 col-form-label text-right">비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="password" class="form-control"
																	name="curPwd" placeholder="비밀번호">
																<c:choose>
																	<c:when test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다..</c:when>
																	<c:otherwise>현재 암호를 입력하세요</c:otherwise>
																</c:choose>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputNewPassword"
																class="col-sm-3 col-form-label text-right">새비밀번호
																:</label>
															<div class="col-sm-9">
																<input type="password" class="form-control"
																	name="newPwd" placeholder="새비밀번호">
																<%-- <c:choose>
																	<c:when test="${errors.newPwd}">새 비밀번호를 입력하세요</c:when>
																	<c:when test="${newPwd==null}">새 비밀번호를 입력하세요</c:when>

																</c:choose> --%>
															</div>
														</div>
														<div class="form-group row">
															<label for="inputFname"
																class="col-sm-3 col-form-label text-right">닉네임 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	name="newNickName" placeholder="${userInfo.nickName}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputBirth"
																class="col-sm-3 col-form-label text-right">생 일 :</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="newBirth"
																	placeholder="${userInfo.birth}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputEmail"
																class="col-sm-3 col-form-label text-right">Email
																:</label>
															<div class="col-sm-9">
																<input type="email" class="form-control" name="newEmail"
																	placeholder="${userInfo.email}">
															</div>
														</div>
														<div class="form-group row">
															<label for="inputGender"
																class="col-sm-3 col-form-label text-right">성 별 :</label>
															<div class="col-sm-9">
																<div class="radio">
																	<label> <input type="radio" name="newGender"
																		value="male"
																		<c:if test="${userInfo.gender eq 'male'}">checked="checked"</c:if>>남성
																		<input type="radio" name="newGender" value="female"
																		<c:if test="${userInfo.gender eq 'female'}">checked="checked"</c:if>>여성
																	</label>
																</div>
															</div>
														</div>
														<div class="form-group row">

															<button type="submit"
																class="btn btn-block btn-prime animation">
																저장 <i class="fa fa-caret-right"></i>
															</button>

														</div>
														<!-- Personal Information Ends -->
													</form>
												</div>
											</div>
										</div>
									</div>
								</section>
							</div>
							<!-- Left Column Ends -->
						</div>
						<!-- Tab #1 Nested Row Ends -->
					</div>
					<!-- Tab #1 Ends -->
					<!-- Tab #2 Starts -->
					<div id="information" class="tab-pane fade">
						<!-- Tab #2 Nested Row Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								
							</div>
							
							
							
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
									<%
										// 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
									if (session.getAttribute("authUser") == null) {
									%>
									로그인을 해주세요.
									<li class="list-inline-item"><a
										href="${pageContext.request.contextPath }/login.do">로그인</a></li>
									<%
										}
									// 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
									else {
									%>
									<li style="”color: white;" " class="list-inline-item">${authUser.nickName }
										<%
											out.print("님의 댓글 목록입니다.");
										%>
									</li>
							     
							      </div>
									
									<table border="1">
							       		<tr>
							       		
							       		<th><p>리뷰 번호</p></th>
							       		<th><p>리뷰 내용</p> </th>
							       		<th><p>수정</p></th>
							       		<th><p>삭제</p></th>
							       		
							       </tr>
							       <c:forEach var="message" items="${messageListView.messageList}">
							       <tr>
							       <td>${message.reviewNo }</td>
							       <td> ${message.reviewContents }</td>
							        <td><input type='button' value='수정' action='msgmodify.do'></td>
							        <td><input type='button' value='삭제' action='msgdelete.do'></td>
							       </tr>
							        </c:forEach>
							       </table>
							      
									
										<!-- 	
										<form>
											<input type='button' value='수정' action='msgmodify.do'>
											<input type='button' value='삭제' action='msgdelete.do'>
										</form> -->
									</div>
									</div>
									
									
									
									<%
										}
									%>


									<!-- Spacer Starts -->
									<div class="spacer big"></div>
									<!-- Spacer Ends -->

									<!-- Delivery Hours Starts -->
									<!-- Delivery Hours Ends -->
									<!-- Takeway Hours Starts -->
									<!-- Takeway Hours Ends -->
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
					</div>
					</div>
					<!-- Tab #2 Ends -->
					<!-- Tab #3 Starts -->
					<div id="gallery" class="tab-pane fade">
						<!-- Image Gallery Starts -->
						<div class="row">
							<!-- Left Column Starts -->
							<div class="col-md-4 col-sm-12">
								
							</div>
							<!-- Left Column Ends -->
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Information Tab Pane Starts -->
								<div class="information-tab-pane">
									<%
										// 현재 로그인된 아이디가 없다면 (= session에 저장된 id가 없다면)
									if (session.getAttribute("authUser") == null) {
									%>
									로그인을 해주세요.
									<li class="list-inline-item"><a
										href="${pageContext.request.contextPath }/login.do">로그인</a></li>
									<%
										}
									// 현재 로그인된 아이디가 있다면 (= session에 저장된 id가 있다면)
									else {
									%>
									<li style="”color: white;" " class="list-inline-item">${authUser.nickName }
										<%
											out.print("님의 즐겨찾기 목록입니다.");
										%>
									</li>
									
									
									
									<table border="1">
							       		<tr>
							       		
							       		<th><p>가게 번호</p></th>
							       		<th><p>가게 이름</p> </th>
							       </tr>
							       <c:forEach var="storeInfo" items="${storeInfoList}">
							       <tr>
							       <td>${storeInfo.storeNo }</td>
							       <td>${storeInfo.storeName }</td>
							       </tr>
							        </c:forEach>
							       </table>
							      
										
									</div>
									<%
										}
									%>
								</div>
								</div>
							   <%-- <c:forEach var="storeinfo" items="${storeInfoListView.storeInfoList}">
							   매장이름:${storeinfo.storeName }
							   </c:forEach> --%>
							<!-- Gallery Image #1 Ends -->
					
						<!-- Image Gallery Ends -->
					</div>
					<!-- Tab #3 Ends -->
					<!-- Tab #4 Starts -->
					<div id="reviews" class="tab-pane fade">
						<!-- Tab #4 Nested Row Starts -->
						<div class="row">
							<!-- Right Column Starts -->
							<div class="col-md-8 col-sm-12">
								<!-- Reviews Tab Pane Starts -->
								<div class="reviews-tab-pane">
									<!-- Menu Tabs Content Ends -->
								</div>
								<!-- Menu Tabs Ends -->
							</div>
							<!-- Mainarea Ends -->
							<!-- Sidearea Starts -->
							<div class="col-md-3 col-sm-12">
								<!-- Spacer Starts -->
								<div class="spacer-1 medium d-xs-block d-sm-block d-md-none"></div>
								<!-- Spacer Ends -->

							</div>
							<!-- Sidearea Ends -->
						</div>
						<!-- Nested Row Ends -->
					</div>
					<!-- Main Container Ends -->


					<%@ include file="../include/footer.jspf"%>