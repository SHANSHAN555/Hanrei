<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout_category/app.jsp">
    <c:param name="content">
    <h2>id:${category.id}の編集画面</h2>
        <form method="POST" action="<c:url value='/category/update'  />">
            <c:import url="_form.jsp"/>
        </form>
        <br />
        <p><a href="<c:url value='/category/index'  />">一覧に戻る</a></p>
        <br />

        <p><a href="#" onclick="confirmDestroy();">削除する</a></p>
        <form method="POST" action="<c:url value='/category/destroy'  />">
            <input type="hidden" name="_token" value="${_token}"/>
        </form>
        <script>
            function confirmDestroy(){
            	if(confirm("削除してもいいですか？")){
            		document.forms[1].submit();
            	}
            }
        </script>
    </c:param>
</c:import>