<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Worker
</h1>
 
<c:url var="addAction" value="/worker/add" ></c:url>
 
<form:form action="${addAction}" commandName="worker">
<table>
    <c:if test="${!empty worker.firstname}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="firstname">
                <spring:message text="First Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstname" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="lastname">
                <spring:message text="Last Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastname" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty worker.firstname}">
                <input type="submit"
                    value="<spring:message text="Edit Worker"/>" />
            </c:if>
            <c:if test="${empty worker.firstname}">
                <input type="submit"
                    value="<spring:message text="Add Worker"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Workers List</h3>
<c:if test="${!empty listWorkers}">
    <table class="tg">
    <tr>
        <th width="80">Worker ID</th>
        <th width="120">Worker First Name</th>
        <th width="120">Worker Last Name</th>
        <th width="80">Worker Salary</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listWorkers}" var="worker">
        <tr>
            <td>${worker.id}</td>
            <td>${person.firstname}</td>
            <td>${person.lastname}</td>
            <td>${person.salary}</td>
            <td><a href="<c:url value='/edit/${worker.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${worker.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>