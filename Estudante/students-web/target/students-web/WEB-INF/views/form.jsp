<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${empty student.sid ? 'Add' : 'Edit'}"/> Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .form-container {
            max-width: 600px;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-group label {
            font-weight: 500;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2 class="text-center mb-4"><c:out value="${empty student.sid ? 'Add New' : 'Edit'}"/> Student</h2>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <form action="students" method="post">
            <input type="hidden" name="action" value="${empty student.sid ? 'insert' : 'update'}">
            
            <!-- Campo Student ID -->
            <div class="form-group">
                <label for="sid">Student ID</label>
                <input type="text" class="form-control" id="sid" name="sid" 
                       value="${student.sid}" 
                       ${empty student.sid ? '' : 'readonly'}
                       required>
            </div>
            
            <!-- Campo Name -->
            <div class="form-group">
                <label for="username">Full Name</label>
                <input type="text" class="form-control" id="username" name="username" 
                       value="${student.username}" required>
            </div>
            
            <!-- Campo Email -->
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" 
                       value="${student.email}" required>
            </div>
            
            <!-- Campo Year -->
            <div class="form-group">
                <label for="year">Year</label>
                <select class="form-control" id="year" name="year" required>
                    <option value="">Select Year</option>
                    <option value="1" ${student.year == 1 ? 'selected' : ''}>1st Year</option>
                    <option value="2" ${student.year == 2 ? 'selected' : ''}>2nd Year</option>
                    <option value="3" ${student.year == 3 ? 'selected' : ''}>3rd Year</option>
                    <option value="4" ${student.year == 4 ? 'selected' : ''}>4th Year</option>
                    <option value="5" ${student.year == 5 ? 'selected' : ''}>5th Year</option>
                    <option value="6" ${student.year == 6 ? 'selected' : ''}>6th Year</option>
                </select>
            </div>
            
            <!-- Campo Department -->
            <div class="form-group">
                <label for="department">Department</label>
                <input type="text" class="form-control" id="department" name="department" 
                       value="${student.department}" required>
            </div>
            
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary mr-2">
                    ${empty student.sid ? 'Create' : 'Update'}
                </button>
                <a href="students" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>

<!-- Script para debug (opcional) -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    console.log('Student ID field:', document.getElementById('sid'));
    console.log('Form mode:', '${empty student.sid ? "Create" : "Edit"}');
});
</script>
</body>
</html>