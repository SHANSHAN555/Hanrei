<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


        <c:if test="${errors != null}">
            <div id="flush_error">
                <c:forEach var="error" items="${errors}" >
                    <c:out value="${error}"/><br />
                </c:forEach>
            </div>
        </c:if>

<h2>カテゴリー一覧</h2>
<table border="1">
    <tbody>
    <tr>
                <th>id</th>
                <th>カテゴリー名</th>
            </tr>
        <c:forEach var="category" items="${category}" varStatus="status">

            <tr>
                <td><c:out value="${category.id}"/></td>
                <td><c:out value="${category.name}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br />

(判例の id はカテゴリー名と一致させてください)<br />
<label for="id">id</label><br />
<input type="text" name="id" value="${hanrei.id}"/>
<br /><br />

<label for="name">名称</label><br />
<input type="text" name="name" value="${hanrei.name}"/>
<br /><br />

<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50">${hanrei.content}</textarea>
<br /><br />

<label for="year">年月日</label><br />
<input type="text" name="year" value="${hanrei.year}"/>
<br /><br />

<label for="url">URL</label><br />
<input type="text" name="url" value="${hanrei.url}"/>
<br /><br />
<input type="hidden" name="_token" value="${_token}"/>
<button type="submit">追加</button>