<!-- <h1>GENRE</h1>
<h3>장르를 선택해주세요. 최대 3개까지 선택가능합니다.</h3> -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>checkboxGenre</title>
<link rel='stylesheet prefetch'
   href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch'
   href='http://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/checkbox.css">
</head>

<body>

<script type="text/javascript">
var maxChecked = 3;    //선택가능한 체크박스 갯수
var totalChecked = 0;   // 설정 끝

function CountChecked(field) {
    if (field.checked){
        totalChecked += 1;
    }
    else{
        totalChecked -= 1;
}
    if (totalChecked > maxChecked) {
    field.checked = false;
    totalChecked -= 1;
    }
}

function MinCountCheck(totalChecked){
   if(totalChecked < 1){
      alert("Please select at least one genre.");
   }
    
}
</script>


<style>
h1 {     
   font-size: 250%; 
}
h2 { 
    font-size: 200%;
}
p {
    font-size: 100%;
    color: white;
}
p1 {
    font-size: 100%;
    color: black;
}
.genrediv1 {

   background-color: black;
    width: 200px;
    height: 500px;
    border: 1px solid black;
    color="white"
}


body {
   vertical-align: middle;
}

form {
   height: 80%;
   width: 80%;
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


input[type=submit]{
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

input[type=button]{
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

input[type=button]:hover {
   opacity: 1;
}

input[type=submit]:hover {
   opacity: 1;
}
/*
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

.signupb:hover{
   opacity: 1;
}
*/
.container {
   margin: 20% 0;
}

span.psw {
   float: right;
   padding-top: 16px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<div class="w3-center">
<h1>GENRE</h1>
<h3>장르를 선택해주세요. 최대 3개까지 선택가능합니다.</h3>
</div>
<br>
<br>
<br>

<center>

      <form action="mc?command=musicRecommand" method="post">

         <div class="container">
            <ul>
               <li>Rap / Hip-hop<input type="checkbox" id="genreList" name="genreList" value="Rap / Hip-hop" onclick=CountChecked(this)></li><br>
               <li>Dance <input type="checkbox" id="genreList" name="genreList" value="Dance" onclick=CountChecked(this)></li><br>
               <li>Folk <input type="checkbox" id="genreList" name="genreList" value="Folk" onclick=CountChecked(this)></li><br>
               <li>Ballad <input type="checkbox" id="genreList" name="genreList" value="Ballad" onclick=CountChecked(this)></li><br>
               <li>R&B / Soul <input type="checkbox" id="genreList" name="genreList" value="R&B / Soul" onclick=CountChecked(this)></li><br>
               <li>Drama <input type="checkbox" id="genreList" name="genreList" value="Drama" onclick=CountChecked(this)></li><br>
               <li>Pop <input type="checkbox" id="genreList" name="genreList" value="Pop" onclick=CountChecked(this)></li><br>
               <li>Rock <input type="checkbox" id="genreList" name="genreList" value="Rock" onclick=CountChecked(this)></li><br>
               <li>Electronica <input type="checkbox" id="genreList" name="genreList" value="Electronica" onclick=CountChecked(this)></li><br>
               <li>Foreign Movie <input type="checkbox" id="genreList" name="genreList" value="Foreign Movie" onclick=CountChecked(this)></li><br>
             
            </ul> 
            </div> 
            <div>
            
               
               <input type="submit" class="signupb" value="next">
   
               <input type="button" class="signupb" onClick="location.href='logout.jsp'" value="log out">

            </div>
      </form>
   </center>
   

</body>
