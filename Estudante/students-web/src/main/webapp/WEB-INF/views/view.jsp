<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1>Student Details</h1>
    
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${student.username}</h5>
            <p class="card-text">
                <strong>Student ID:</strong> ${student.sid}<br>
                <strong>Email:</strong> ${student.email}<br>
                <strong>Year:</strong> ${student.year}<br>
                <strong>Department:</strong> ${student.department}
            </p>
            <a href="students" class="btn btn-primary">Back to List</a>
        </div>
    </div>
</div>
</body>
</html>