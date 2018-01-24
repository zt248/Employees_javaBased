<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Места работы</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>organization</th>
        <th>position</th>
        <th width="100"></th>
        <th width="100"></th>
        <th width="100"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDepartment}" var="department">
    <tr>
        <th>${department.id}</th>
        <th>${department.organization}</th>
        <th>${department.position}</th>
        <th><a href="<c:url value="/department/getByIdDepartment/${department.id}"/> "><button>Query</button></a> </th>
        <th><a href="<c:url value="/department/getUpdateDepartmentForm/${department.id}"/> "><button>Редактировать</button></a> </th>
        <th><a href="<c:url value="/department/deleteDepartment/${department.id}"/> "><button>Удалить</button></a> </th>
    </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <a href="/department/getAddDepartmentForm"><button>Новая запись</button> </a>
</div>
</body>
</html>

