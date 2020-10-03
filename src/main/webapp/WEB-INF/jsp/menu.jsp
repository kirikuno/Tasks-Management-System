<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">
	<a href="${pageContext.request.contextPath}/home">Home</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/#">Tasks</a> | &nbsp; 
	<a href="${pageContext.request.contextPath}/#">Create Project</a> | &nbsp; 
	<a href="${pageContext.request.contextPath}/#">Create User</a> 
	
	<a href="/logout" style="text-decoration: none; float: right;"> 
	   <i class="fa fa-sign-out"></i>
	   Log out
	</a>
</div>