<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${errors != null}">
    <div id="flush_error">
        <c:forEach var="error" items="${errors}">
            <c:out value="${error}"/><br/>
        </c:forEach>
    </div>
</c:if>
<label for="name">ニックネーム</label><br />
<input type="text" name="name" value="${message.name}"/>
<br /><br />

<label for="title">タイトル</label><br />
<input type="text" name="title" value="${message.title}"/>
<br /><br />

<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50">${message.content}</textarea>
<br /><br />
<input type="hidden" name="_token" value="${_token}"/>
<button type="submit">依頼</button>