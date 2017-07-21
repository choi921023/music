<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="music.demo.DemoMusicDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>selectSongs.jsp</title>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet prefetch'
   href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch'
   href='http://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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

header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
</style>
<script>
var maxChecked = 5;    //선택가능한 체크박스 갯수
var totalChecked = 0;   // 설정 끝
var myArray = new Array();
var currIdx = 0;

function CountChecked(field) {
    if (field.checked){
    	totalChecked += 1;
    	myArray[currIdx] = selectedMusic;
  	   	currIdx += 1;
    }else{
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
   }else{
      location.replace('login.jsp');
   }
   
   function addSelectedMusicFun(selectedMusic){
	   myArray.remove();
	   currIdx += 1;
   }
    
}
</script>


</head>
<body>

<ul>
<!-- 선택할 노래 -->
<c:forEach items="${musicList}" var="data">
		<li>${data.musicTitle}<input type="checkbox" name="song" value="${data.musicAddress}" onclick=CountChecked(this)></li><br>		
</c:forEach>

<div class="w3-center">
<h1>choice your Songs</h1>
<p1>Choose 5 or less</p1>
</div>

<form action="">


</ul>


<ul>
   <li>song1 <input type="checkbox" name="song" value="song1" onclick=CountChecked(this)></li><br>
   <li>song2 <input type="checkbox" name="song" value="song2" onclick=CountChecked(this)></li><br>
   <li>song3 <input type="checkbox" name="song" value="song3" onclick=CountChecked(this)></li><br>
   <li>song4 <input type="checkbox" name="song" value="song4" onclick=CountChecked(this)></li><br>
   <li>song5 <input type="checkbox" name="song" value="song5" onclick=CountChecked(this)></li><br>
   <li>song6 <input type="checkbox" name="song" value="song6" onclick=CountChecked(this)></li><br>
   <li>song7 <input type="checkbox" name="song" value="song7" onclick=CountChecked(this)></li><br>
   <li>song8 <input type="checkbox" name="song" value="song8" onclick=CountChecked(this)></li><br>
   <li>song9 <input type="checkbox" name="song" value="song9" onclick=CountChecked(this)></li><br>
   <li>song10 <input type="checkbox" name="song" value="song10" onclick=CountChecked(this)></li><br>
 
</ul>  
</form>

<c:forEach items="${musicList}" var="data">
		<li>${data.musicTitle}<input type="checkbox" name="song" value="${data.musicAddress}" onclick=CountChecked(this)></li><br>		
</c:forEach>


<nav>
  <ul>
    <li><a href="">songlist_title</a></li>
    <li><a href="checkbox.html">Back</a></li>
  </ul>
</nav>





<footer>Copyright &copy; Watermelon</footer>
   
   
</body>
</html>