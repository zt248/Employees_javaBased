<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees List</title>
</head>
<thead>

<table border="1" id="example" class="display">
    <thead>
    <th>id</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>День рождения</th>
    <th>Страна</th>
    <th>Город</th>
    <th>Улица</th>
    <th>Почтовый индекс</th>
    <%--<th>department</th>--%>
<c:forEach items="${listEmployees}" var="employees">
    <tr>
        <td>${employees.id}</td>
        <td>${employees.firstName}</td>
        <td>${employees.lastName}</td>
        <td>${employees.birthday}</td>
        <td>${employees.address.country}</td>
        <td>${employees.address.city}</td>
        <td>${employees.address.street}</td>
        <td>${employees.address.postCode}</td>
        <%--<td>${employees.departments}</td>--%>
    </tr>
    </c:forEach>
</table>
</thead>

</body>
</html>


<%--<script src="https://code.jquery.com/jquery-3.1.1.min.js">--%>
<%--</script>--%>
<%--<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">--%>
<%--<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>--%>

<%--<script type="text/javascript">--%>

    <%--$(document).ready(function () {--%>
        <%--var data = eval('${listEmployees}');--%>
        <%--var table = $('#example').DataTable({--%>
            <%--"aaData": data,--%>
            <%--"aoColumns": [--%>
                <%--{"mData": "id"},--%>
                <%--{"mData": "firstName"},--%>
                <%--{"mData": "lastName"},--%>
                <%--{"mData": "birthday"},--%>
                <%--{"mData": "address.city"},--%>
                <%--{"mData": "address.country"},--%>
                <%--{"mData": "address.street"},--%>
                <%--{"mData": "address.postCode"}--%>
            <%--],--%>
            <%--"paging": true,--%>
            <%--"pageLength": 4,--%>
            <%--"ordering": true--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>