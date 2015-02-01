<%@ page import="java.util.ArrayList"%>
<%@ page import="Objects.*"%>
<%@ page import="DAO.*"%>
<%@ page import="Objects.*"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fct" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ProductList</title>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/jquery_popup.css" />
<script src="jquery_popup.js"></script>
<script>
	$(document).ready(function() {
		$("#login #cancel").click(function() {
			$(this).parent().parent().hide();
		});
		$("#onclick").click(function() {
			$("#logindiv").css("display", "block");
		});

		$("#ButtonDisconnect").click(function() {
			$("#Disconnect").submit();
		});

		// Login form popup login-button click event.
		$("#loginbtn").click(function() {
			var name = $("#username").val();
			var password = $("#password").val();
			if (username == "" || password == "") {
				alert("Username or Password was empty");
			} else {
				$("#logindiv").css("display", "none");
			}

			$("#login").submit();
		});

		
	});


	var Msg ='<%=session.getAttribute("connect")%>';
    if (Msg != "null") {
 function alertName(){
 alert("<%=session.getAttribute("connect")%>");
 } 
 }
	
</script>
<script type="text/javascript"> window.onload = alertName; </script>
<style type="text/css">
@import url(http://fonts.googleapis.com/css?family=Fauna+One|Muli);

#mainform {
	float: right;
	font-family: 'Fauna One', serif;
	display: block;
}

h1 {
	text-align: center;
	text-shadow: 5px 1px 4px gray;
}

h2 {
	text-shadow: 5px 1px 4px gray;
}

#onclick {
	padding: 3px;
	color: green;
	cursor: pointer;
	padding: 5px 5px 5px 15px;
	width: 70px;
	color: white;
	background-color: #123456;
	box-shadow: 1px 1px 5px grey;
	border-radius: 3px;
}

#ButtonDisconnect {
	padding: 3px;
	color: green;
	cursor: pointer;
	padding: 5px 5px 5px 15px;
	width: 100px;
	color: white;
	background-color: #123456;
	box-shadow: 1px 1px 5px grey;
	border-radius: 3px;
}

b {
	font-size: 18px;
	text-shadow: 1px 0px 3px gray;
}

.form {
	border-radius: 2px;
	padding: 20px 30px;
	box-shadow: 0 0 15px;
	font-size: 14px;
	font-weight: bold;
	width: 350px;
	float: left;
}

input {
	width: 100%;
	height: 35px;
	margin-top: 5px;
	border: 1px solid #999;
	border-radius: 3px;
	padding: 5px;
}

input[type=button] {
	background-color: #123456;
	border: 1px solid white;
	font-family: 'Fauna One', serif;
	font-Weight: bold;
	font-size: 18px;
	color: white;
	width: 49%;
}

input[type="submit"] {
	cursor: pointer;
	width: 20%;
}

.buttonHolder {
	text-align: center;
}

#logindiv {
	opacity: 0.92;
	position: absolute;
	top: 0px;
	left: 0px;
	height: 100%;
	width: 100%;
	background: #000;
	display: none;
}

#login {
	width: 350px;
	margin: 0px;
	background-color: white;
	font-family: 'Fauna One', serif;
	position: relative;
	border: 5px solid rgb(90, 158, 181);
}

.img {
	float: right;
	margin-top: -35px;
	margin-right: -37px;
}

#login {
	left: 50%;
	top: 40%;
	margin-left: -210px;
}

.TFtable {
	text-align: center;
	width: 95%;
	border-collapse: collapse;
}

.TFtable td {
	padding: 3px;
	border: #4e95f4 1px solid;
}
/* provide some minimal visual accomodation for IE8 and below */
.TFtable tr {
	background: #b8d1f3;
}
/*  Define the background color for all the ODD background rows  */
.TFtable tr:nth-child(odd) {
	background: #b8d1f3;
}
/*  Define the background color for all the EVEN background rows  */
.TFtable tr:nth-child(even) {
	background: #dae5f4;
}
</style>
</head>
<body>

	<core:if test="${sessionScope.admin == false}">
		<div id="mainform">
			<div id="popup">
				<p id="onclick">Login</p>
			</div>
		</div>
	</core:if>

	<core:if test="${sessionScope.admin}">
		<div id="mainform">
			<div id="popup">
				<form action="DisconnectUser" method="post" id="Disconnect">
					<p id="ButtonDisconnect">Disconnect</p>
					<input type="hidden" name="action" value="ProductManagement">
				</form>
			</div>
		</div>
	</core:if>


	<div id="logindiv">
		<form class="form" action="LoginUser" method="post" id="login">
			<img
				src="http://www.formget.com/tutorial/jquery-popup-form-demo/button_cancel.png"
				class="img" id="cancel" />
			<h3>Login Form</h3>
			<label>Username : </label> <input type="text" id="username"
				name="username" placeholder="Ex -john123" /> <label>password
				: </label> <input type="text" id="password" name="password"
				placeholder="************" /> <input type="button" id="loginbtn"
				value="Login" /> <input type="button" id="cancel" value="Cancel" />
			<input type="hidden" name="action" value="ProductManagement">
		</form>
	</div>

	<form action="ProductDelete" method="post">
		<!-- 	<form name="form1" onsubmit="penis()"> -->

		<h1>Table of products</h1>


		<table class="TFtable">

			<thead>
				<tr>
					<th><h2>Line Number</h2></th>
					<th><h2>Name</h2></th>
					<th><h2>Barcode</h2></th>
					<core:if test="${sessionScope.admin}">
						<th><h2>Delete</h2></th>
					</core:if>
				</tr>
			</thead>

			<core:forEach var="product" items="${listProduct}" varStatus="count">
				<tr>
					<td><core:out value=" ${count.count}" /></td>
					<td><core:out value="${product.name}" /></td>
					<td><core:out value="${product.barcode}" /></td>
					<core:if test="${sessionScope.admin}">
						<td><INPUT type="checkbox" name="option"
							value="${product.barcode}"></td>


					</core:if>
				</tr>
			</core:forEach>
		</table>
		<core:if test="${sessionScope.admin}">
			<div class="buttonHolder">
				<input type="submit" value="Send">
			</div>
		</core:if>
	</form>



	<core:if test="${sessionScope.admin}">
		<h1>Access to Retailers Management</h1>

		<form action="RetailerManagement" method="post">
			<div class="buttonHolder">
				<input type="submit" value="Retailers Management">
			</div>

		</form>
	</core:if>




</body>
</html>