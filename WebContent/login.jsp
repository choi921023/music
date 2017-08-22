<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
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
input[type=email], input[type=password] {
   text-align: center;
   width: 400px;
   padding: 12px 10px;
   margin: 0.5% 0;
   display: inline-block;
   border: 1px solid #ccc;
   box-sizing: border-box;
   border-radius : 10px;
}

button.login {
   background-color: black;
   color: white;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   cursor: pointer;
   width: 198px;
   opacity: 0.8;
   border-radius : 10px;
}

button:hover {
   opacity: 1;
}

.signupb {
   /*background-color:black;
   margin:0;
   width: 10%
   */
   color:white;
   /*background-color:black;*/
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   cursor: pointer;
   text-decoration: none;
   background-color: black;
   width: 198px;
   opacity: 0.8;
   border-radius : 10px;
}

.container {
   margin: 20% 0;
}

span.psw {
   float: right;
   padding-top: 16px;
}
</style>

<body>
   <script type="text/javascript">
      if("${auth}" == "loginfail"){
         alert("아이디 혹은 비밀번호가 잘못 입력되었습니다.");
      }
   </script>
   
   <center>

      <form name="command" action="mc?command=getMember"
         method="post">

         <div class="container">
            
            <font color="Black" size="35"><b>CU</b></font>
            your music <b>cu</b>ration. <i class="fa fa-headphones" style="font-size:25px"></i><br>
            <input type="email" id="email" name="email" placeholder="Enter Your Email"><br>
            <input type="password" id="password" name="password"
               placeholder="Enter Password"><br>
            <div>
               <button class="login" type="submit">
                  <b>Login</b>
               </button>
               <input type="button" class="signupb" onClick="location.href='register.jsp'" value="Sign Up">
               </button>
            </div>
         </div>
      </form>
   </center>
<footer>Copyright &copy; CUration.com</footer>
</body>

</html>