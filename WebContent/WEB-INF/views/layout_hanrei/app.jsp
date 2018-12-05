<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>判例一覧</title>
        <link rel="stylesheet" href="<c:url value='/css/hanrei.css' />">


    </head>
    <body>
        <div id="wrapper">
            <div class="header">
                <h2>判例集</h2>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div class="footer">
                by hono
            </div>
        </div>

    </body>
</html>