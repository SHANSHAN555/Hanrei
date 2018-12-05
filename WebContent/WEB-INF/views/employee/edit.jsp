<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout_employee/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${employee != null}">
                <h2>id:${employee.id}の編集画面</h2>
                <p>(パスワードは変更する場合のみ入力してください。)</p>

                <form method="POST" action="<c:url value='/employee/update'  />">
                    <c:import url="_form.jsp"/>
                </form>

                <p><a href="#" onclick="confirmDestroy();">削除する</a></p>
                <form method="POST" action="<c:url value='/employee/destroy'  />">
                    <input type="hidden" name="_token" value="${_token}"/>
                </form>
                <script>
                    function confirmDestroy(){
                        if(confirm("本当に削除しますか？")){
                            document.forms[1].submit();
                        }
                    }
                </script>
            </c:when>
            <c:otherwise>
                <h2>データが見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/employee/index'  />">一覧に戻る</a></p>
    </c:param>
</c:import>