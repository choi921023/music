<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="EUC-KR">
<title>register.jsp</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<style>
html {
	background-position: center;
	background-attachment: fixed;
	width: 100%;
	height: 100%;
	background:
		url(https://i0.wp.com/livewallpaperhd.com/wp-content/uploads/2017/05/Black-Background-Phone.jpg)
		no-repeat center center fixed;
	background-size: cover;
}

body {
	vertical-align: middle;
}

form {
	height: 80%;
	width: 80%;
}
footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
    bottom:0;
    position:absolute;
    width:97%;
    height : 30px;
}
input[type=email], input[type=password], input[type=text] {
	text-align: center;
	width: 300px;
	padding: 12px 10px;
	margin: 0.5% 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 10px;
}

button.register {
	background-color: black;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 200px;
	opacity: 0.8;
	border-radius: 10px;
}

button:hover {
	background-color: black;
	opacity: 1;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 100px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

span.psw {
	float: right;
	padding-top: 16px;
}

.container {
	margin: 15% 0;
}
</style>

<body>

	<script type="text/javascript">
	if("${auth}" == "registerfail"){
		alert("이미 존재하는 아이디입니다.");
	}
	</script>

	<center>
		<form name="command" action="mc?command=addMember"
			method="post">
			<div class="container">
			<font color="Black" size="35"><b>CU</b></font>
            your music curation. <i class="fa fa-headphones" style="font-size:25px"></i><br>
				<input type="email" id="id" name="id" placeholder="Enter Your Email"><br>
				<!--  
    <label><b><font color="white">Password</font></b></label>
    <br>-->
				<input type="text" id="name" name="name"
					placeholder="Enter Your Name"><br>
				<!--  
    <label><b><font color="white">Password</font></b></label>
    <br>-->
				<input type="password" id="password" name="password"
					placeholder="Enter Password"><br>

				<button class="register" type="submit">Sign Up</button>
			</div>


		</form>
	</center>
<footer>Copyright &copy; CUration.com</footer>
</body>
</html>
