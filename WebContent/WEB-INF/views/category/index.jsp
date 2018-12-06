<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout/app.jsp">
    <c:param name="content">
    <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

                <h2>カテゴリー</h2>
                <table id="category_list">
                    <tr>
                        <th>番号</th>
                        <th>カテゴリー名</th>
                        <th>詳細</th>
                    </tr>

                    <c:forEach var="category" items="${category}" varStatus="status">
                    <tr>
                         <td><c:out value="${category.id}"/></td>
                         <td><c:out value="${category.name}"/></td>
                         <td><a href="<c:url value='/category/show?id=${category.id}'  />">詳細</a></td>
                    </tr>
                    </c:forEach>
                </table>

        <div id="pagination">
             (全${category_count}件)<br />
                <c:forEach var="i" begin="1" end="${((category_count -1) / 5) + 1}" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}"/>&nbsp;
                        </c:when>

                        <c:otherwise>
                            <a href="<c:url value='/category/index?page=${i}'   />"><c:out value="${i}"/></a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
        </div>


        <p><a href="<c:url value='/category/new'  />">新規登録</a></p>
        <p><a href="<c:url value='/message/new'  />">編集依頼</a></p>
    </c:param>

</c:import>