<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>Students List</h1>
    <a href="students?action=new" class="btn btn-primary mb-3">Add New Student</a>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Year</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.sid}</td>
                    <td>${student.username}</td>
                    <td>${student.email}</td>
                    <td>${student.year}</td>
                    <td>${student.department}</td>
                    <td>
                        <a href="students?action=edit&sid=${student.sid}" class="btn btn-sm btn-warning">Edit</a>
                        <a href="students?action=view&sid=${student.sid}" class="btn btn-sm btn-info">View</a>
                        <a href="students?action=delete&sid=${student.sid}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>