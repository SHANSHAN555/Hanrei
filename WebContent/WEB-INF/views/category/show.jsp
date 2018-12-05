<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout_category/app.jsp">
    <c:param name="content">
        <table>
            <tr>
                <th>番号</th>
                <td><c:out value="${category.id}"/></td>
            </tr>
            <tr>
                <th>カテゴリー名</th>
                <td><c:out value="${category.name}"/></td>
            </tr>
            <tr>
                <th>内容</th>
                <td>
                <pre><c:out value="${category.content}"/></pre>
                </td>
            </tr>
            <tr>
                <th>作成日時</th>
                <td><fmt:formatDate value="${category.created_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <th>更新日時</th>
                <td><fmt:formatDate value="${category.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <th>詳細</th>
                <td>
                <c:if test="${sessionScope.employee_id != null}">
                    <a href="<c:url value='/hanrei/index?id=${sessionScope.employee_id}'  />">判例一覧</a>&nbsp;
                </c:if>
                </td>
            </tr>
        </table>

            <p><a href="<c:url value='/category/edit?id=${category.id}'  />">編集する</a></p>
        <br />
        <p><a href="<c:url value='/category/index'  />">一覧に戻る</a></p>
    </c:param>
</c:import>