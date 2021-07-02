<%@page import="cybersoft.java12.jsp.util.UrlUtils"%>
<%@page import="cybersoft.java12.jsp.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.java12.jsp.util.UrlUtils" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="shortcut icon" href="vs.ico" type="image/x-icon">
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="container">
    <h1 class="text-primary text-center m-2"> <i class="fa fa-home"></i> Customer Dashboard</h1>
    	<a href="<%=request.getContextPath() + UrlUtils.CUSTOMER_ADD %> " 
    	class="btn btn-primary text-while p-2 mb-3"> Add new Customer</a>
    <br>
    <table class="table table-bordered">
        <thead class="text-primary">
            <tr>
            	<th>No.</th>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Function</th>
                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" varStatus="loopStatus" items="${customers }">
           <tr>
           		<td>${loopStatus.count }</td>
                <td>${customer.code }</td>
                <td>${customer.name }</td>
                <td>${customer.address }</td>
                <td>${customer.email }</td>
                <td>
                	<a href="<%=request.getContextPath() + UrlUtils.CUSTOMER_DELETE %>?code=${customer.code}" class="btn btn-sm btn-outline-danger text-danger"><i class="fa fa-trash" aria-hidden="true"></i></a>
                	<a href="<%=request.getContextPath() + UrlUtils.CUSTOMER_UPDATE %>?code=${customer.code}" class="btn btn-sm btn-outline-success success"><i class="fa fa-wrench" aria-hidden="true"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>