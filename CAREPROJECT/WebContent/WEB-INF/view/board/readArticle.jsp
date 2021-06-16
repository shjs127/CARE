<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../include/header.jspf"%>


<h3 class="main title" align="center">게시판</h3>
<table class="table">
	<tbody>
		<tr>
			<th>제목</th>
			<td class="text-align-left text-indent text-strong text-orange"
				colspan="1">${articleData.boardInfo.boardTitle}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td class="text-align-left text-indent" colspan="3">${articleData.boardInfo.boardDate}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${articleUser.nickName}</td>
			<th>조회수</th>
			<td>${articleData.boardInfo.viewCount}</td>
		</tr>
		<tr class="content">
			<td colspan="4" style="word-break:break-all; padding-left: 30px; padding-right: 100px;">${articleData.boardInfo.boardContents}</td>
		</tr>
	</tbody>
</table>

<div class="margin-top">
	<table class="table border-top-default">
		<tbody>

			<tr>
				<td class="text-align-left text-indent"><a
					class="text-blue text-strong"
					href="read.do?boardNo=${articleData.boardInfo.boardNo-1}">이전글</a></td>

				<td class=" text-align-center text-indent"><a
					class="btn btn-list" href="list.do">목록</a></td>

				<td class="text-align-right text-indent"><a
					href="read.do?boardNo=${articleData.boardInfo.boardNo+1}">다음글</a></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- <form action="modify.do" method="post"> -->
<input type="hidden" name="boardNo">
<div style="text-align: right;">

			<%-- <c:if test="${articleData.boardInfo.userNo == session.getAttribute('}"> --%>
	<form name="removefrm" action="delete.do" method="post">
		<!-- <td> -->
		<button class="btn1" onclick="removeCheck()">삭제</button>
			<input type="hidden" name="boardContents" value="${articleData.boardInfo.boardContents}">
			<input type="hidden" name="boardTitle" value="${articleData.boardInfo.boardTitle}">
			<input type="hidden" name="boardNo" value="${articleData.boardInfo.boardNo}">
		<script>
			function removeCheck() {

				if (confirm("정말 삭제하시겠습니까??") == true) { //확인

					document.removefrm.submit();

				} else { //취소

					return false;

				}

			}
		</script>
	</form>

	<!-- </a> -->
	<!-- </td> -->


	<!-- <td> -->
	<a href="modify.do?boardNo=${articleData.boardInfo.boardNo}">
		<button class="btn1">수정</button>
	</a>
	<!-- </td> -->
	<%-- 	</c:if> --%>
</div>
<!-- 	</form> -->



<%@ include file="../include/footer.jspf"%>