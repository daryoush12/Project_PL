<?xml version="1.0" encoding="ISO-8859-15" ?>
<%@ page language="java" contentType="text/html; ISO-8859-15" pageEncoding="ISO-8859-15"%>
<%@ page isThreadSafe="true"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="pizza" scope="session" class="pizzaLovers.Pizza" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="REFRESH" content="text/html" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" >

<title>Tervetuloa PizzaLovers pizzeriaan</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Shrikhand">
    
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
<div class="contrainer">

        <header class="container logo">
          <img src="pics/logo.png" alt="PizzaLovers logo">
        </header>
        

<form action="YllapitoServletti" method="get">

<!-- Fixed navbar -->
    <nav class="navbar" role="navigation">
      <div class="container container-nav">
          <div class="navbar-header">
            <ul class="nav navbar-nav ">
            <!-- Valikon painikkeet ovat tässä -->
              <li class="active"><input class="btn btn-primary navbar-btn" type="submit" value="Lisää" name="action"/></li>
              <li><input class="btn btn-primary navbar-btn" type="submit" value="Päivitä" name="action" /></li>
              <li><input class="btn btn-primary navbar-btn" type="submit" value="Pizzalistaan" name="action" /></li>
			  <li><input class="btn btn-primary navbar-btn" type="submit" value="Poista" name="action" /></li>
			  </ul>
          </div><!--/.nav-collapse -->
         </div>
      </nav>
      </form>
     </div> <!-- /.container -->
     
<div class="container container-body">



<!-- Tulostetaan pizzat, kuvat ja täytteet ruudulle -->
<div class="row">
<c:forEach items="${pizzat}" var="pizza" varStatus="loopCounter" >
  <div class="col-md-3 col-sm-6">
    <div class="thumbnail">
    <!-- Laitetaan pizzoille oikeat kuvat -->
       <c:if test="${pizza.nimi == 'Pizza Viennese'}"><img src="pics/pizza-viennese.png" alt="pizza"></img></c:if>
       <c:if test="${pizza.nimi == 'Kinkku- ja sienipizza'}"><img src="pics/pizza-kinkku-sieni.jpg" alt="pizza"></img></c:if>
       <c:if test="${pizza.nimi == 'Pizza Capricciosa'}"><img src="pics/pizza-capricciosa.png" alt="pizza"></img></c:if>
       <c:if test="${pizza.nimi == 'Pizza Romana'}"><img src="pics/pizza-romana.jpg" alt="pizza"></img></c:if>
      <div class="caption">
      <!-- Määritetään maaksi suomi ja otetaan käyttöön EURO symbooli -->
      <fmt:setLocale value="fi-FI" scope="session"/>
      <h3><c:out value="${pizza.nimi}" /><br /><fmt:formatNumber value="${pizza.hinta}" type="currency" currencyCode='EUR' minFractionDigits="2" /></h3>
		<!-- Loopataan mukaan myös täytteet -->	
		<c:forEach items="${pizza.taytteet}" var="tayte" varStatus="loopStatus" >	
		<!-- Hyödynnetään .last optiota, jotta pilkkua ei laiteta enää viimeisen täytteen jälkeen -->	
      		<c:out value="${tayte}" /><c:if test="${!loopStatus.last}">,</c:if>
		</c:forEach>
     </div>
    </div>
  </div>
</c:forEach>
  </div>
           


 </div><!-- /.container -->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
</body>
</html>