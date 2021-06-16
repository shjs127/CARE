<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jspf"%>	


<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
	<div class="register-box">


		<div class="register-box-body">
			<p class="login-box-msg">
				<c:if test="${errors.userId}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
				<c:if test="${errors.nickName}">닉네임을 입력하세요.</c:if>
				<c:if test="${errors.password}">암호를 입력하세요.</c:if>
				<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
				<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
				<c:if test="${errors.birth}">생년월일을 입력하세요.</c:if>
				<c:if test="${errors.email}">이메일을 입력하세요.</c:if>
			</p>

			<!-- <form action="registerProcess.jsp" method="post"> -->
			<form action="join.do" method="post">
			<!-- <form action="join.do" method="post" onsubmit="return loginCheak(this)"> -->
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="userid"
						placeholder="ID"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password"
						placeholder="Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="confirmPassword"
						placeholder="Retype password"> <span
						class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
					<div class="form-group has-feedback">
					<input type="text" class="form-control" name="name"
						placeholder="name"> <span
						class="glyphicon glyphicon-user form-control-feedback">
						</span>
				</div>
					
					<div class="form-group has-feedback">
					<input type="text" class="form-control" name="nickname"
						placeholder="닉네임"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
					
					<div class="form-group has-feedback">
					<input type="number" class="form-control" name="birth"
						placeholder="생년월일"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
					
					<div class="form-group has-feedback">
					<input type="email" class="form-control" name="email"
						placeholder="email"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
					
					<div class="form-group has-feedback">
					<div><input type="radio" name="sex" value="male" checked>남성</div>
 						<div><input type="radio" name="sex" value="fm">여성</div>
   						</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
                <!-- Register Col Starts -->
                    <div class="col-md-5 col-sm-12 offset-md-2">
                        <h4 class="text-spl-color">Login for first time user?</h4>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard..</p>
                        <button type="submit" class="btn btn-block btn-tertiary animation" data-toggle="modal" data-target="#registerModal">
                            Continue To Register <i class="fa fa-caret-right"></i>
                        </button>
                        <hr>
                        <a href="#" class="btn btn-block btn-twitter animation">
                        <i class="fa fa-twitter"></i> Sign in with Twitter</a>
                        <a href="#" class="btn btn-block btn-fb animation"><i class="fa fa-facebook"></i> Sign in with Facebook</a>
                        <a href="#" class="btn btn-block btn-prime tiny animation"><i class="fa fa-google-plus"></i> Sign in with Google</a>
                    </div>

			<a href="login.do" class="text-center">가입 취소</a>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->


	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
<!-- <script type="text/javascript" src="formCheak.js"></script> -->
</body>
</html>
<%@ include file="../include/footer.jspf"%>