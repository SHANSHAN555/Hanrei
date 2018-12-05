<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout_message/app.jsp">
    <c:param name="content">
        <table border="1">
            <tr>
                <th>番号</th>
                <td><c:out value="${message.id}"/></td>
            </tr>
            <tr>
                <th>ニックネーム</th>
                <td><c:out value="${message.name}"/></td>
            </tr>
            <tr>
                <th>タイトル</th>
                <td><c:out value="${message.title}"/></td>
            </tr>
            <tr>
                <th>内容</th>
                <td><pre><c:out value="${message.content}"/></pre></td>
            </tr>
            <tr>
            <th>依頼日時</th>
                <td><fmt:formatDate value="${message.created_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
            <th>更新日時</th>
                <td><fmt:formatDate value="${message.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </table>

        <p><a href="<c:url value='/message/edit?id=${message.id}'  />">編集する</a></p>
        <br /><br >
        <p><a href="<c:url value='/message/index'  />">一覧に戻る</a></p>
    </c:param>
</c:import>