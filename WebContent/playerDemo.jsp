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
<title>Music Player</title>

<link rel='stylesheet prefetch'   href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch'   href='http://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/checkbox.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">


</head>

 
  
<body>


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
p2 {
    font-size: 150%;
    color: black;
}

footer {
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

.btn-group{
display:none;
} /*playlist 없으면*/

 .btn-group .button {
   background-color: black;
   border: 1px solid black;
   color: white;
   padding: 14px 20px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   cursor: pointer;
   width: 198px;
   display: block;
}

.btn-group .button:not(:last-child) {
    border-bottom: none; /* Prevent double borders */
}

.btn-group .button:hover {
    background-color: #555555;
}
  
</style>
<center>
<div class="logo"><font color="Black" size="10"><b>CU</b></font>
            <b>your music curation.</b> <i class="fa fa-headphones" style="font-size:30px"></i></div>

</center>


   <header>

      
      <div class="logout">
         <input type="button" class="signupb" onClick="location.href='login.jsp'"value="log out">
      <!--   <input type="button" class="signupb" onClick="'" value="station delete">  playlist 없으면 -->
      </div>


   </header>


<!-- <p1>Play list  &#9836;</p1><br> -->


<div class="btn-group" >
  <button class="button">song1</button>
  <button class="button">song2</button>
  <button class="button">song3</button>
  <button class="button">song4</button>
  <button class="button">song5</button>
  <button class="button">song6</button>
  <button class="button">song7</button>
  <button class="button">song8</button>
  <button class="button">song9</button>
  <button class="button">song10</button>
</div>

<div class="music-player">
      <audio id="music" src="" hidden="true" autoplay="autoplay"></audio>
      <img id="album" src="" class="album"/>
      <div class="dash">
         <a href="#mute" class="fa fa-volume-up"></a> 
         <span class="volume-level"> <em style="width: 75%"></em></span>
         <a href="#love"   class="fa fa-heart"></a>
         <div class="seeker">
            <div class="wheel">
               <div class="progress"></div>
            </div>
         </div>
         <a href="#seek"></a>
         <div class="controls">
            <a href="#back" class="fa fa-fast-backward"></a> 
            <a href="#play"  class="fa fa-pause"></a>
            <a href="#forward" class="fa fa-fast-forward"></a>   
         </div>
         <div class="info">
            <i><span name="current">0:00</span> / <span name="duration">0:00</span></i>
            <label id="title"></label> 
            <small id="artist"></small>
         </div>
      </div>
   </div>
   <script
      src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
   <script
      src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
   
   <script src="js/index.js" charset="utf-8"></script>
   
   <div>
            
            

</div>



<center>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
   


      <div class="logo"><font color="Black" size="5"><b>CU</b></font>
            your music curation. <i class="fa fa-headphones" style="font-size:25px"></i></div>
</center>

<footer>Copyright &copy; CUration.com</footer>
