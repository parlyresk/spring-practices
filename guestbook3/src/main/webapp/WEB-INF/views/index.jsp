<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.util.List"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<div id="content">
		<div id="guestbook">
			<form action="${pageContext.request.contextPath}/add"
				method="post">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan=4><textarea name="contents" id="content"></textarea></td>
					</tr>
					<tr>
						<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
					</tr>
				</table>
			</form>
			<ul>
				<c:set var="count" value="${fn:length(list) }" />
				<c:forEach var="guestbookVo" items="${list}" varStatus="status">
					<li>
						<table width="510" border="1">
							<tr>
								<td>${count-status.index}</td>
								<td>${guestbookVo.name}</td>
								<td>${guestbookVo.regDate}</td>
								<td><a
									href="${pageContext.request.contextPath}/deleteform/${guestbookVo.no}">삭제</a></td>
							</tr>
							<tr>
								<td colspan="4">${fn:replace(guestbookVo.contents, newline, '<br/>')}

								</td>
							</tr>
						</table> <br>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>