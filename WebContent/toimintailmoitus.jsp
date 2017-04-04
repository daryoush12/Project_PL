<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isThreadSafe="true"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="pizza" scope="session" class="pizzaLovers.Pizza" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Sivu ei toimi</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
	<!--     IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
<form action="YllapitoServletti" method="get">
<h3>Tämä ei vielä toimi, kehitysprosessissa</h3>
<br />
<img src="pics/under_process.jpg" alt="Koodariapina" style="width:281px;height:270px"></img>
<ul class="nav nav-pills">
<li class="active"><input class="btn btn-primary navbar-btn" type="submit" value="Takaisin pizzalistaan" name="action"/></li>
</ul>
</form>
 </div> <!-- /.container -->
</body>
</html>