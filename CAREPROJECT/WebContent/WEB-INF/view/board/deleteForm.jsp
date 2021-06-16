<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




	<%-- <input type="hidden" name="boardNo" value="${modReq.boardNo}">
	<input type="hidden" name="boardTitle" value="${modReq.boardTitle}">
	<input type="hidden" name="boardContents" value="${modReq.boardContents}">${modReq.boardContents}
	정말로 삭제하시겠습니까?
	<input type="submit" value="삭제"> --%>
<form name="removefrm" action="delete.do" method="post">
		<script>
			function() {

				if (confirm("정말 삭제하시겠습니까??") == true) { //확인

					document.removefrm.submit();

				} else { //취소

					return false;

				}

			}
		</script>
</form>