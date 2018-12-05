<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${error != null}">
    <div id="flush_error">
        <c:forEach var="error" items="${error}">
            <c:out value="${error}"></c:out>
        </c:forEach>
    </div>
</c:if>

<label for="name">カテゴリー名</label><br/>
<input type="text" name="name" value="${category.name}"/>
<br /><br />

<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50">${category.content}</textarea>
<br /><br />

<input type="hidden" name="_token" value="${_token}"/>
<button type="submit">追加</button>