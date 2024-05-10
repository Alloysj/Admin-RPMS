<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin RPMS</title>
        <link rel="stylesheet" href="index.css"/>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <% 
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if(session.getAttribute("username")==null){
        response.sendRedirect("index.html");
            }
        %>
        <h1>Welcome</h1>
        <div class="nav-links">
            <ul>
                <li><a href="researchers.jsp">Researchers</a></li>
                <li><a href="PI.jsp">Principal investigators</a></li>
                <li><a href="funders.jsp">Funders</a></li>
                <li><a href="projects.jsp">Projects</a></li>
                <li><a href="logout.jsp">logout</a></li>
            </ul>
        </div>
    </body>
</html>
