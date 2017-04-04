<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isThreadSafe="true"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="pizza" scope="session" class="pizzaLovers.Pizza" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- <meta http-equiv="REFRESH" content="text/html; charset=ISO-8859-1" /> -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Tervetuloa PizzaLovers pizzeriaan</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="contrainer">

        <header class="container">
            <img src="pics/PizzaLovers.jpg" alt="PizzaLovers logo"></img>
        </header>
        

<form action="YllapitoServletti" method="get"></form>

<!-- Fixed navbar -->
    <nav class="navbar" role="navigation">
      <div class="container">
          <div class="navbar-header">
            <ul class="nav nav-pills">
              <li class="active"><input class="btn btn-primary navbar-btn" type="submit" value="Lisää" name="action"/></li>
              <li><input class="btn btn-primary navbar-btn" type="submit" value="Päivitä" name="action" /></li>
              <li><input class="btn btn-primary navbar-btn" type="submit" value="Suosikkilistaan" name="action" /></li>
			  <li><input class="btn btn-primary navbar-btn" type="submit" value="Poista" name="action" /></li>
			  </ul>
          </div><!--/.nav-collapse -->
         </div>
      </nav>
     </div> 
<div class="container">


<c:forEach items="${pizzat}" var="pizza" >

<div class="row">
  <div class="col-md-3 col-sm-6">
    <div class="thumbnail">
          <img src="pics/pizzathumb.png" alt="pizza">
      <div class="caption">
      <h3><c:out value="${pizza.nimi}" />  <c:out value="${pizza.hinta}" /> eur</h3>
      <p>Täyte</p>
     </div>
    </div>
  </div>
</c:forEach>
</div>
           



 </div><!-- /.container -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>