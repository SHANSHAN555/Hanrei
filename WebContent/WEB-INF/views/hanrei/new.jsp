<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout_hanrei/app.jsp">
    <c:param name="content">
        <form method="POST" action="<c:url value='/hanrei/create'  />">
            <c:import url="_form.jsp"/>
        </form>

        <p><a href="<c:url value='/hanrei/index'  />">一覧に戻る</a></p>
    </c:param>
</c:import>