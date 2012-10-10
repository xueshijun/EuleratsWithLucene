<%@ page language="java" pageEncoding="UTF-8"%>

<!-- isErrorPage="true" 表明此页面为错误转向页面，添加此句后，可用 out.println(exception); 打印出错误信息 -->
<%@ page isErrorPage="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>错误提示页面</title>
  </head>
 
  <body>
    <center>
  <%-- 可以写相关的错误提示信息 --%>
     <h3>程序出错啦，请与管理员联系！</h3>
     <%-- 打印错误信息 --%>
     <% out.println(exception); %>
    </center>
  </body>
</html>