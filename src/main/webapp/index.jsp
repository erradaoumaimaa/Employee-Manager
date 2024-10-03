<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/webressources/masters/styles/style.css" />
<h2>Users List</h2>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:if test="${not empty employees}">
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty employees}">
            <tr>
                <td colspan="2">No employees found.</td>
            </tr>
        </c:if>
    </table>
</div>