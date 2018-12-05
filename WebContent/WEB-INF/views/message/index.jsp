<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout_message/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

        <h1>編集依頼一覧</h1>
        <table border="1">
                <tbody>
                    <tr>
                        <th>番号</th>
                        <th>ニックネーム</th>
                        <th>タイトル</th>
                        <th>詳細</th>
                    </tr>
                    <tr>
                        <c:forEach var="message" items="${message}" varStatus="status">
                            <td>
                            <c:out value="${message.id}"/>
                            </td>
                            <td><c:out value="${message.name}"/></td>
                            <td><c:out value="${message.title}"/></td>
                            <td><a href="<c:url value='/message/show?id=${message.id}'  />">詳細へ</a></td>
                        </c:forEach>
                    </tr>
                </tbody>
         </table>

         <div id="pagination">
             (全${message_count}件)<br />
             <c:forEach var="i" begin="1" end="${((message_count  -1) /15) + 1}" step="1">
                 <c:choose>
                     <c:when test="${i == page}">
                         <c:out value="${i}"/>&nbsp;
                     </c:when>
                     <c:otherwise>
                          <a href="<c:url value='/message/index?page=${i}'   />"><c:out value="${i}"  /></a>&nbsp;
                     </c:otherwise>
                 </c:choose>
             </c:forEach>
         </div>
         <p><a href="<c:url value='/message/new'  />">新規作成</a></p>
         <p><a href="<c:url value='/category/index'  />">カテゴリー一覧へ戻る</a></p>
    </c:param>
</c:import>