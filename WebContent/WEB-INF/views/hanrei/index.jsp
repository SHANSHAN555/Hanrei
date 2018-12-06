<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout_hanrei/app.jsp">
    <c:param name="content">
<h2>判例集</h2>


                <c:forEach var="hanrei" items="${hanrei}" varStatus="status">

                <c:choose>
                    <c:when test="${hanrei.id == category_id}">

                     <table border="1">
                     <tbody>
                <tr>
                    <th>番号</th>
                    <th>名称</th>
                    <th>年月日</th>
                    <th>詳細</th>
                </tr>
                    <tr>
                <td><c:out value="${hanrei.id}"/></td>
                <td><c:out value="${hanrei.name}"/></td>
                    <td><c:out value="${hanrei.year}"/></td>
                    <td>
                        <a href="<c:url value='/hanrei/show?id=${hanrei.id}'  />">こちらへ</a>
                    </td>
                </tr>
</tbody>

                     </table>
        <p><a href="<c:url value='/hanrei/index' />">全判例一覧へ</a></p>


                    </c:when>
                    <c:when test="${category_id == null}">
                    <table border="1">
                     <tbody>
                <tr>
                    <th>番号</th>
                    <th>名称</th>
                    <th>年月日</th>
                    <th>詳細</th>
                </tr>
                    <tr>
                <td><c:out value="${hanrei.id}"/></td>
                <td><c:out value="${hanrei.name}"/></td>
                    <td><c:out value="${hanrei.year}"/></td>
                    <td>
                        <a href="<c:url value='/hanrei/show?id=${hanrei.id}'  />">こちらへ</a>
                    </td>
                </tr>
</tbody>
</table>
                    </c:when>





                </c:choose>
                </c:forEach>


<div id="pagination">

                (全${hanrei_count}件)<br />
                <c:forEach var="i" begin="1" end="${((hanrei_count -1) /10) + 1}" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}"/>&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/hanrei/index?page=${i}'  />"><c:out value="${i}"/></a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                </div>





        <p><a href="<c:url value='/hanrei/new'  />">新規登録</a></p>
        <p><a href="<c:url value='/message/new' />">編集依頼</a></p>
        <p><a href="<c:url value='/category/index'  />">カテゴリー一覧へ戻る</a></p>
    </c:param>
</c:import>

