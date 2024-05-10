<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Beans.Researcher" %>
<%@ page import="Beans.ResearcherManager" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="Id" scope="session" class="Beans.ResearcherManager" />
<%
    List<Researcher> researchers = Id.getresearchers();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Researchers</title>
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
        <h1>Researchers</h1>
        
        <table border="1">
            <tr>
                <th>first name</th>
                <th>last Name</th>
                <th>project</th>
                <th>faculty</th>
                <th>department</th>
                <!-- More headers if needed -->
            </tr>
            <% for (Researcher researcher : researchers) { %>
            <tr>
                <td><a href="#" onclick="displayResearcherDetails('<%= researcher.getfName() %>', '<%= researcher.getlName() %>', '<%= researcher.getProject() %>', '<%= researcher.getFaculty() %>', '<%= researcher.getDepartment() %>')"><%= researcher.getfName() %></a></td>
                <td><%= researcher.getlName() %></td>
                <td><%= researcher.getProject() %></td>
                <td><%= researcher.getFaculty() %></td>
                <td><%= researcher.getDepartment() %></td>
            </tr>
            <% } %>
        </table>
        <!-- Pop-up form for displaying researcher details -->
        <div id="popupForm" class="popup-form">
            <h3>Researcher Details</h3>
            <form>
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" disabled><br>

                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" disabled><br>

                <label for="project">Project:</label>
                <input type="text" id="project" disabled><br>

                <label for="department">Department:</label>
                <input type="text" id="department" disabled><br>

                <label for="faculty">Faculty:</label>
                <input type="text" id="faculty" disabled><br>

                <button type="button" onclick="closePopup()">Close</button>
            </form>
        </div>

        <!-- Overlay to disable content when pop-up is active -->
        <div id="overlay" class="overlay"></div>

        <script>
            // Function to display researcher details in pop-up form
            function displayResearcherDetails(firstName, lastName, project, faculty, department) {
                document.getElementById('firstName').value = firstName;
                document.getElementById('lastName').value = lastName;
                document.getElementById('project').value = project;
                document.getElementById('faculty').value = faculty;
                document.getElementById('department').value = department;

                // Display the pop-up form
                document.getElementById('popupForm').style.display = 'block';
                // Display the overlay to disable content
                document.getElementById('overlay').style.display = 'block';
                // Disable content of underlying page
                document.body.classList.add('disabled-content');
            }

            // Function to close the pop-up form
            function closePopup() {
                // Hide the pop-up form
                document.getElementById('popupForm').style.display = 'none';
                // Hide the overlay
                document.getElementById('overlay').style.display = 'none';
                // Enable content of underlying page
                document.body.classList.remove('disabled-content');
            }
        </script>

        <form action="addResearcher.jsp">
            <input type="submit" value="Add researcher">
        </form>
    </body>
</html>
