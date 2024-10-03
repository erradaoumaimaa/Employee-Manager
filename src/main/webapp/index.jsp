<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/webressources/masters/styles/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    
    <title>Manage Employees</title>
</head>
<body>
<div class="container">
    <div class="tbl_content">
        <h2>Manage Employees</h2>
        <table class="tbl">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Department</th>
                    <th>Position</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty employees}">
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td data-label="ID"><c:out value="${employee.id}" /></td>
                            <td data-label="Name"><c:out value="${employee.name}" /></td>
                            <td data-label="Email"><c:out value="${employee.email}" /></td>
                            <td data-label="Phone"><c:out value="${employee.phone}" /></td>
                            <td data-label="Department"><c:out value="${employee.department}" /></td>
                            <td data-label="Position"><c:out value="${employee.position}" /></td>
                            <td data-label="Edit">
                                <button class="btn_edit"><i class="fa fa-pencil"></i></button>
                            </td>
                            <td data-label="Delete">
                                <a href="<%=request.getContextPath() %>/EmployeeController?action=delete&id=${employee.id}" class="btn_trash" 
                                   onclick="return confirm('Are you sure you want to delete this employee?');">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty employees}">
                    <tr>
                        <td colspan="8">No employees found.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>