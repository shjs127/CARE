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
					<td>${articleData.boardInfo.userNo}</td>
					<th>조회수</th>
					<td>${articleData.boardInfo.viewCount}</td>
				</tr>
				<tr class="content">
					<td colspan="4">${articleData.boardInfo.boardContents}</td>
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
						class="btn btn-list" href="board.do">목록</a></td>

					<td class="text-align-right text-indent"><a
						href="read.do?boardNo=${articleData.boardInfo.boardNo+1}">다음글</a></td>


				</tr>


			</tbody>
		</table>
	</div>
	<div style="text-align:right;">
		<%-- <c:choose>
			<c:when test="${articleData.boardInfo.boardNo eq null} == sessionID || sessionID == null"> --%>
				<!-- <td> --><a href="delete.do?boardNo=${articleData.boardInfo.boardNo}">
						<button class="btn1">삭제</button>
				</a><!-- </td> -->
				<!-- <td> --><a href="modify.do?boardNo=${articleData.boardInfo.boardNo}">
						<button class="btn1">수정</button>
				</a><!-- </td> -->
		<%-- 	</c:when>
		</c:choose> --%>
	</div>



<%@ include file="../include/footer.jspf"%>