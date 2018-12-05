<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout_hanrei/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${hanrei != null}">
                <h2>id:${hanrei.id}の詳細ページ</h2>

                <table border="1">
                    <tbody>
                    <tr>
                        <th>番号</th>
                        <td><c:out value="${hanrei.id}"/></td>
                    </tr>
                    <tr>
                        <th>名称</th>
                        <td><c:out value="${hanrei.name}"/></td>
                    </tr>
                    <tr>
                        <th>内容</th>
                        <td>
                            <c:out value="${hanrei.content}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>年月日</th>
                        <td>
                            <c:out value="${hanrei.year}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>登録日時</th>
                        <td><fmt:formatDate value="${hanrei.created_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                    <tr>
                        <th>更新日時</th>
                        <td><fmt:formatDate value="${hanrei.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                    </tbody>
                </table>

                <p><a href="<c:url value='/hanrei/edit?id=${hanrei.id}'  />">編集する</a></p>
            </c:when>


            <c:otherwise>
                <h2>データが見つかりませんでした</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/hanrei/index'   />">一覧に戻る</a></p>
    </c:param>
</c:import>