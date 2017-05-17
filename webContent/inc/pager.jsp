<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager maxPageItems="12" items="${param.items }" export="curPage=pageNumber" url="${param.url }">
<nav aria-label="Page navigation">
	<ul class="pagination">
		<c:forEach items="${param.params }" var="p">
			<pg:param name="${p }"/>
		</c:forEach>
		<pg:first>
			<li>
				<a href="${pageUrl }">首页</a>
			</li>
		</pg:first>
		<pg:prev>
			<li>
			<a aria-label="Previous" href="${pageUrl }">
				<span aria-hidden="true">&laquo;</span>
			</a>
			</li>
		</pg:prev>
		<pg:pages>
		
		<c:if test="${curPage eq pageNumber }">
		<li>
			<a>[${pageNumber }]</a>
		</li>
		</c:if>
		<c:if test="${curPage ne pageNumber }">
		<li>
			<a href="${pageUrl }">${pageNumber }</a>
		</li>
		</c:if>
		</pg:pages>
		<pg:next>
			<li>
				<a aria-label="Next" href="${pageUrl }">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</pg:next>
		<pg:last>
		<li>
			<a href="${pageUrl }">尾页</a>
		</li>
		</pg:last>
	</ul>
</nav>
</pg:pager>