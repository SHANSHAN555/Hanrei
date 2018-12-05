<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout_employee/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${employee != null}">
                <h2>id:${employee.id}の詳細ページ</h2>

                <table border="1">
                    <tbody>
                    <tr>
                        <th>社員番号</th>
                        <td><c:out value="${employee.code}"/></td>
                    </tr>
                    <tr>
                        <th>氏名</th>
                        <td><c:out value="${employee.name}"/></td>
                    </tr>
                    <tr>
                        <th>権限</th>
                        <td>
                            <c:choose>
                                <c:when test="${employee.admin_flag == 1}">管理者</c:when>
                                <c:otherwise>一般</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>登録日時</th>
                        <td><fmt:formatDate value="${employee.created_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                    <tr>
                        <th>更新日時</th>
                        <td><fmt:formatDate value="${employee.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                    <tr>
                        <th>詳細</th>
                        <td>

                        <c:if test="${sessionScope.employee_id != null}">
                                <a href="<c:url value='/category/index?id=${sessionScope.employee_id}'  />">カテゴリー一覧</a>&nbsp;
                        </c:if>
                        </td>
                    </tr>
                    </tbody>
                </table>


                    <c:if test="${employee != null}">
                        <c:if test="${employee.admin_flag != null}">
                            <p><a href="<c:url value='/employee/edit?id=${employee.id}'  />">編集する</a></p>
                        </c:if>

                    </c:if>

            </c:when>


            <c:otherwise>
                <h2>データが見つかりませんでした</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/employee/index'   />">一覧に戻る</a></p>
    </c:param>
</c:import>