<%--
  Created by IntelliJ IDEA.
  User: ubedu
  Date: 2021/9/1
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>

    <style>
      h3{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: deepskyblue;
        border-radius: 5px;
      }
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
    </style>

  </head>
  <body>
  <h3>
    <a href="${pageContext.request.contextPath}/book/allBook">
      展示全部书籍
    </a>
  </h3>
  </body>
</html>
