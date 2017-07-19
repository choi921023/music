<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="music.demo.DemoMusicDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Music Player</title>
<link rel='stylesheet prefetch'	href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch'	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>
<body>
<%!
	HashMap<Integer, DemoMusicDTO> stationList = new HashMap<Integer, DemoMusicDTO>();
%>
<%
	stationList.put(1, new DemoMusicDTO("./src/audio/heize.mp3", "비도 오고 그래서 (You, Clouds, Rain) (Feat. 신용재)", "헤이즈 (Heize)", "./src/img/albumArt1.jpg"));
	stationList.put(2, new DemoMusicDTO("./src/audio/RedVelvet.mp3", "빨간 맛(Red Flavor)", "레드벨벳 (Red Velvet)", "./src/img/albumArt2.jpg"));
%>

	<div class="music-player">
		<audio id="music" src=<%=stationList.get(1).getMusicAddress()%> hidden="true"></audio>
		<img src=<%=stationList.get(1).getAlbumAddress()%> class="album" />
		<div class="dash">
			<a href="#mute" class="fa fa-volume-up"></a> <span
				class="volume-level"> <em style="width: 75%"></em>
			</span><a href="#love"
				class="fa fa-heart"></a>
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
				<label><%=stationList.get(1).getArtist()%> - <%=stationList.get(1).getMusicTitle()%></label> 
				<small>앨범명</small>
			</div>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>

	<script src="js/index.js"></script>

</body>
</html>
