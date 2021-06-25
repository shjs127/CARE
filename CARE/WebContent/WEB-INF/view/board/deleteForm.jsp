<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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