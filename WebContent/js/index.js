var i = 0;
var timer = null;
var like = false;
var stationList = //null;
//{"DemoMusic":[{"musicTitle":"비도 오고 그래서 (Feat. 신용재)","artist":"헤이즈 (Heize)","musicAddress":"./src/audio/001.mp3","albumAddress":"./src/img/001.jpg","likeInfo":"false"}]}
{"DemoMusic":[{"musicTitle":"비도 오고 그래서 (Feat. 신용재)","artist":"헤이즈 (Heize)","musicAddress":"./src/audio/001.mp3","genre":"Rap / Hip-hop","gender":"F","bpm":156.44,"albumAddress":"./src/img/001.jpg"},{"musicTitle":"빨간 맛 (Red Flavor)","artist":"Red Velvet (레드벨벳)","musicAddress":"./src/audio/002.mp3","genre":"Dance","gender":"F","bpm":124.99,"albumAddress":"./src/img/002.jpg"},{"musicTitle":"Artist","artist":"지코 (ZICO)","musicAddress":"./src/audio/003.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":118.09,"albumAddress":"./src/img/003.jpg"},{"musicTitle":"널 너무 모르고","artist":"헤이즈 (Heize)","musicAddress":"./src/audio/004.mp3","genre":"Rap / Hip-hop","gender":"F","bpm":105,"albumAddress":"./src/img/004.jpg"},{"musicTitle":"마지막처럼","artist":"BLACKPINK","musicAddress":"./src/audio/005.mp3","genre":"Dance","gender":"F","bpm":125.01,"albumAddress":"./src/img/005.jpg"},{"musicTitle":"나로 말할 것 같으면","artist":"마마무","musicAddress":"./src/audio/006.mp3","genre":"Dance","gender":"F","bpm":119.99,"albumAddress":"./src/img/006.jpg"},{"musicTitle":"남이 될 수 있을까","artist":"볼빨간사춘기, 스무살","musicAddress":"./src/audio/007.mp3","genre":"Folk","gender":"F","bpm":85,"albumAddress":"./src/img/007.jpg"},{"musicTitle":"매일 듣는 노래 (A Daily Song)","artist":"황치열","musicAddress":"./src/audio/008.mp3","genre":"Ballad","gender":"M","bpm":131.89,"albumAddress":"./src/img/008.jpg"},{"musicTitle":"FIVE","artist":"Apink (에이핑크)","musicAddress":"./src/audio/009.mp3","genre":"Dance","gender":"F","bpm":115.01,"albumAddress":"./src/img/009.jpg"},{"musicTitle":"무제(無題) (Untitled, 2014)","artist":"G-DRAGON","musicAddress":"./src/audio/010.mp3","genre":"R&B / Soul","gender":"M","bpm":105.45,"albumAddress":"./src/img/010.jpg"},{"musicTitle":"처음부터 너와 나","artist":"볼빨간사춘기","musicAddress":"./src/audio/011.mp3","genre":"Drama","gender":"F","bpm":97.01,"albumAddress":"./src/img/011.jpg"},{"musicTitle":"Shape of You","artist":"Ed Sheeran","musicAddress":"./src/audio/012.mp3","genre":"Pop","gender":"M","bpm":123.04,"albumAddress":"./src/img/012.jpg"},{"musicTitle":"New Face","artist":"싸이 (PSY)","musicAddress":"./src/audio/013.mp3","genre":"Dance","gender":"M","bpm":132,"albumAddress":"./src/img/013.jpg"},{"musicTitle":"SIGNAL","artist":"TWICE (트와이스)","musicAddress":"./src/audio/014.mp3","genre":"Dance","gender":"F","bpm":104.02,"albumAddress":"./src/img/014.jpg"},{"musicTitle":"오늘 취하면 (Feat.창모) (Prod. SUGA)","artist":"수란 (SURAN)","musicAddress":"./src/audio/015.mp3","genre":"R&B / Soul","gender":"MIX","bpm":146.03,"albumAddress":"./src/img/015.jpg"},{"musicTitle":"Why Don`t You Know (Feat. 넉살)","artist":"청하","musicAddress":"./src/audio/016.mp3","genre":"Dance","gender":"MIX","bpm":146.4,"albumAddress":"./src/img/016.jpg"},{"musicTitle":"팔레트 (Feat. G-DRAGON)","artist":"아이유","musicAddress":"./src/audio/017.mp3","genre":"R&B / Soul","gender":"MIX","bpm":101.99,"albumAddress":"./src/img/017.jpg"},{"musicTitle":"REALLY REALLY","artist":"WINNER","musicAddress":"./src/audio/018.mp3","genre":"Dance","gender":"M","bpm":103,"albumAddress":"./src/img/018.jpg"},{"musicTitle":"미치고 싶다","artist":"한동근","musicAddress":"./src/audio/019.mp3","genre":"Ballad","gender":"M","bpm":126.11,"albumAddress":"./src/img/019.jpg"},{"musicTitle":"NEVER","artist":"국민의 아들","musicAddress":"./src/audio/020.mp3","genre":"Dance","gender":"M","bpm":110.01,"albumAddress":"./src/img/020.jpg"},{"musicTitle":"I LUV IT","artist":"싸이 (PSY)","musicAddress":"./src/audio/021.mp3","genre":"Dance","gender":"M","bpm":125.01,"albumAddress":"./src/img/021.jpg"},{"musicTitle":"ANTI (Feat. G.Soul)","artist":"지코 (ZICO)","musicAddress":"./src/audio/022.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":156.03,"albumAddress":"./src/img/022.jpg"},{"musicTitle":"FANXY CHILD (Feat. FANXY CHILD)","artist":"지코 (ZICO)","musicAddress":"./src/audio/023.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":144.01,"albumAddress":"./src/img/023.jpg"},{"musicTitle":"밤편지","artist":"아이유","musicAddress":"./src/audio/024.mp3","genre":"Ballad","gender":"F","bpm":120.83,"albumAddress":"./src/img/024.jpg"},{"musicTitle":"BLUE MOON (Prod. GroovyRoom)","artist":"효린, 창모 (CHANGMO)","musicAddress":"./src/audio/025.mp3","genre":"Dance","gender":"MIX","bpm":107,"albumAddress":"./src/img/025.jpg"},{"musicTitle":"좋니","artist":"윤종신","musicAddress":"./src/audio/026.mp3","genre":"Ballad","gender":"M","bpm":151.88,"albumAddress":"./src/img/026.jpg"},{"musicTitle":"LONELY","artist":"씨스타","musicAddress":"./src/audio/027.mp3","genre":"R&B / Soul","gender":"F","bpm":85.16,"albumAddress":"./src/img/027.jpg"},{"musicTitle":"아침에 (Feat. Bryn)","artist":"양홍원 (Young B)","musicAddress":"./src/audio/028.mp3","genre":"Rap / Hip-hop","gender":"MIX","bpm":105.14,"albumAddress":"./src/img/028.jpg"},{"musicTitle":"첫눈처럼 너에게 가겠다","artist":"에일리","musicAddress":"./src/audio/029.mp3","genre":"Drama","gender":"F","bpm":133.98,"albumAddress":"./src/img/029.jpg"},{"musicTitle":"맞지?","artist":"언니쓰","musicAddress":"./src/audio/030.mp3","genre":"Dance","gender":"F","bpm":129.99,"albumAddress":"./src/img/030.jpg"},{"musicTitle":"Marry Me","artist":"마크툽 (MAKTUB), 구윤회","musicAddress":"./src/audio/031.mp3","genre":"Ballad","gender":"M","bpm":122.85,"albumAddress":"./src/img/031.jpg"},{"musicTitle":"사랑이 잘 (With 오혁)","artist":"아이유","musicAddress":"./src/audio/032.mp3","genre":"R&B / Soul","gender":"MIX","bpm":130.86,"albumAddress":"./src/img/032.jpg"},{"musicTitle":"좋다고 말해","artist":"볼빨간사춘기","musicAddress":"./src/audio/033.mp3","genre":"Folk","gender":"F","bpm":161.3,"albumAddress":"./src/img/033.jpg"},{"musicTitle":"KNOCK KNOCK","artist":"TWICE (트와이스)","musicAddress":"./src/audio/034.mp3","genre":"Dance","gender":"F","bpm":129.98,"albumAddress":"./src/img/034.jpg"},{"musicTitle":"아름다워","artist":"창모 (CHANGMO)","musicAddress":"./src/audio/035.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":88.01,"albumAddress":"./src/img/035.jpg"},{"musicTitle":"사랑앓이 (With 김나영)","artist":"FTISLAND","musicAddress":"./src/audio/036.mp3","genre":"Ballad","gender":"MIX","bpm":143.53,"albumAddress":"./src/img/036.jpg"},{"musicTitle":"봄날","artist":"방탄소년단","musicAddress":"./src/audio/037.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":107.06,"albumAddress":"./src/img/037.jpg"},{"musicTitle":"TOMBOY","artist":"혁오 (HYUKOH)","musicAddress":"./src/audio/038.mp3","genre":"Rock","gender":"M","bpm":147.95,"albumAddress":"./src/img/038.jpg"},{"musicTitle":"아재개그 (Narr. 김대희, 김준호)","artist":"마마무","musicAddress":"./src/audio/039.mp3","genre":"Dance","gender":"MIX","bpm":133,"albumAddress":"./src/img/039.jpg"},{"musicTitle":"먹구름 (Feat. nafla)","artist":"헤이즈 (Heize)","musicAddress":"./src/audio/040.mp3","genre":"Rap / Hip-hop","gender":"MIX","bpm":104.98,"albumAddress":"./src/img/040.jpg"},{"musicTitle":"Outside (Feat. Beenzino)","artist":"Crush","musicAddress":"./src/audio/041.mp3","genre":"R&B / Soul","gender":"M","bpm":115,"albumAddress":"./src/img/041.jpg"},{"musicTitle":"나만 안되는 연애","artist":"볼빨간사춘기","musicAddress":"./src/audio/042.mp3","genre":"Folk","gender":"F","bpm":136,"albumAddress":"./src/img/042.jpg"},{"musicTitle":"돌아오지마 (Feat. 용준형 Of 비스트)","artist":"헤이즈 (Heize)","musicAddress":"./src/audio/043.mp3","genre":"Rap / Hip-hop","gender":"MIX","bpm":95.41,"albumAddress":"./src/img/043.jpg"},{"musicTitle":"불장난","artist":"BLACKPINK","musicAddress":"./src/audio/044.mp3","genre":"Dance","gender":"F","bpm":96.99,"albumAddress":"./src/img/044.jpg"},{"musicTitle":"ALL I WANNA DO (K) (Feat. Hoody, Loco)","artist":"박재범","musicAddress":"./src/audio/045.mp3","genre":"R&B / Soul","gender":"MIX","bpm":96.01,"albumAddress":"./src/img/045.jpg"},{"musicTitle":"우주를 줄게","artist":"볼빨간사춘기","musicAddress":"./src/audio/046.mp3","genre":"Folk","gender":"F","bpm":82.99,"albumAddress":"./src/img/046.jpg"},{"musicTitle":"Closer (Feat. Halsey)","artist":"The Chainsmokers","musicAddress":"./src/audio/047.mp3","genre":"Electronica","gender":"MIX","bpm":94.97,"albumAddress":"./src/img/047.jpg"},{"musicTitle":"작두 (Feat. 넉살, Huckleberry P)","artist":"딥플로우","musicAddress":"./src/audio/048.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":84.02,"albumAddress":"./src/img/048.jpg"},{"musicTitle":"여보세요","artist":"뉴이스트","musicAddress":"./src/audio/049.mp3","genre":"Ballad","gender":"M","bpm":95.99,"albumAddress":"./src/img/049.jpg"},{"musicTitle":"On&On (Feat. 챈슬러)","artist":"린","musicAddress":"./src/audio/050.mp3","genre":"R&B / Soul","gender":"MIX","bpm":90.01,"albumAddress":"./src/img/050.jpg"},{"musicTitle":"부담이 돼 (Feat. 휘인 Of 마마무)","artist":"정키","musicAddress":"./src/audio/051.mp3","genre":"Ballad","gender":"MIX","bpm":137.91,"albumAddress":"./src/img/051.jpg"},{"musicTitle":"오빠야","artist":"신현희와김루트","musicAddress":"./src/audio/052.mp3","genre":"Folk","gender":"MIX","bpm":109.98,"albumAddress":"./src/img/052.jpg"},{"musicTitle":"CALLING YOU","artist":"하이라이트 (Highlight)","musicAddress":"./src/audio/053.mp3","genre":"Dance","gender":"M","bpm":89.99,"albumAddress":"./src/img/053.jpg"},{"musicTitle":"천재 (Behind the scene)","artist":"지코 (ZICO)","musicAddress":"./src/audio/054.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":103.13,"albumAddress":"./src/img/054.jpg"},{"musicTitle":"D (half moon) (Feat. 개코)","artist":"DEAN","musicAddress":"./src/audio/055.mp3","genre":"R&B / Soul","gender":"M","bpm":84.98,"albumAddress":"./src/img/055.jpg"},{"musicTitle":"개소리 (BULLSHIT)","artist":"G-DRAGON","musicAddress":"./src/audio/056.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":96.02,"albumAddress":"./src/img/056.jpg"},{"musicTitle":"Decalcomanie (데칼코마니)","artist":"마마무","musicAddress":"./src/audio/057.mp3","genre":"Dance","gender":"F","bpm":115.94,"albumAddress":"./src/img/057.jpg"},{"musicTitle":"Gucci","artist":"제시 (Jessi)","musicAddress":"./src/audio/058.mp3","genre":"Rap / Hip-hop","gender":"F","bpm":100.2,"albumAddress":"./src/img/058.jpg"},{"musicTitle":"Oh Little Girl","artist":"슬레이트","musicAddress":"./src/audio/059.mp3","genre":"Dance","gender":"F","bpm":93.02,"albumAddress":"./src/img/059.jpg"},{"musicTitle":"Love Yourself","artist":"Justin Bieber","musicAddress":"./src/audio/060.mp3","genre":"Pop","gender":"M","bpm":100.01,"albumAddress":"./src/img/060.jpg"},{"musicTitle":"TT","artist":"TWICE (트와이스)","musicAddress":"./src/audio/061.mp3","genre":"Dance","gender":"F","bpm":130,"albumAddress":"./src/img/061.jpg"},{"musicTitle":"어디에도","artist":"엠씨더맥스","musicAddress":"./src/audio/062.mp3","genre":"Ballad","gender":"M","bpm":131.97,"albumAddress":"./src/img/062.jpg"},{"musicTitle":"소나기","artist":"아이오아이 (I.O.I)","musicAddress":"./src/audio/063.mp3","genre":"Ballad","gender":"F","bpm":124.64,"albumAddress":"./src/img/063.jpg"},{"musicTitle":"Young & Free","artist":"시우민 (XIUMIN), 마크 (MARK)","musicAddress":"./src/audio/064.mp3","genre":"Dance","gender":"M","bpm":100.03,"albumAddress":"./src/img/064.jpg"},{"musicTitle":"Something Just Like This","artist":"The Chainsmokers, Coldplay","musicAddress":"./src/audio/065.mp3","genre":"Electronica","gender":"M","bpm":102.99,"albumAddress":"./src/img/065.jpg"},{"musicTitle":"얼굴 찌푸리지 말아요","artist":"하이라이트 (Highlight)","musicAddress":"./src/audio/066.mp3","genre":"Dance","gender":"M","bpm":150,"albumAddress":"./src/img/066.jpg"},{"musicTitle":"그대라는 사치","artist":"한동근","musicAddress":"./src/audio/067.mp3","genre":"Ballad","gender":"M","bpm":136,"albumAddress":"./src/img/067.jpg"},{"musicTitle":"너였다면","artist":"정승환","musicAddress":"./src/audio/068.mp3","genre":"Drama","gender":"M","bpm":135.95,"albumAddress":"./src/img/068.jpg"},{"musicTitle":"굿모닝 (Good Morning)","artist":"케이시 (Kassy)","musicAddress":"./src/audio/069.mp3","genre":"Drama","gender":"F","bpm":85.02,"albumAddress":"./src/img/069.jpg"},{"musicTitle":"어땠을까 (Feat. 박정현)","artist":"싸이 (PSY)","musicAddress":"./src/audio/070.mp3","genre":"Rap / Hip-hop","gender":"MIX","bpm":106.01,"albumAddress":"./src/img/070.jpg"},{"musicTitle":"심술","artist":"볼빨간사춘기","musicAddress":"./src/audio/071.mp3","genre":"Folk","gender":"F","bpm":156.02,"albumAddress":"./src/img/071.jpg"},{"musicTitle":"나야 나 (PICK ME)","artist":"PRODUCE 101","musicAddress":"./src/audio/072.mp3","genre":"Dance","gender":"M","bpm":128.01,"albumAddress":"./src/img/072.jpg"},{"musicTitle":"See You Again (폴 워커 추모 엔딩곡)","artist":"Charlie Puth, Wiz Khalifa","musicAddress":"./src/audio/073.mp3","genre":"Foreign Movie","gender":"M","bpm":160.13,"albumAddress":"./src/img/073.jpg"},{"musicTitle":"지나쳐 (Feat. DEAN)","artist":"로꼬","musicAddress":"./src/audio/074.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":102.01,"albumAddress":"./src/img/074.jpg"},{"musicTitle":"오랜 날 오랜 밤","artist":"악동뮤지션","musicAddress":"./src/audio/075.mp3","genre":"Folk","gender":"MIX","bpm":117.06,"albumAddress":"./src/img/075.jpg"},{"musicTitle":"You Better Know","artist":"Red Velvet (레드벨벳)","musicAddress":"./src/audio/076.mp3","genre":"Dance","gender":"F","bpm":120.02,"albumAddress":"./src/img/076.jpg"},{"musicTitle":"Beautiful","artist":"Crush","musicAddress":"./src/audio/077.mp3","genre":"Drama","gender":"M","bpm":109.87,"albumAddress":"./src/img/077.jpg"},{"musicTitle":"마에스트로 (Maestro)","artist":"창모 (CHANGMO)","musicAddress":"./src/audio/078.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":113.99,"albumAddress":"./src/img/078.jpg"},{"musicTitle":"Rookie","artist":"Red Velvet (레드벨벳)","musicAddress":"./src/audio/079.mp3","genre":"Dance","gender":"F","bpm":163.99,"albumAddress":"./src/img/079.jpg"},{"musicTitle":"CHEER UP","artist":"TWICE (트와이스)","musicAddress":"./src/audio/080.mp3","genre":"Dance","gender":"F","bpm":86.5,"albumAddress":"./src/img/080.jpg"},{"musicTitle":"바람이 불었으면 좋겠어","artist":"길구봉구","musicAddress":"./src/audio/081.mp3","genre":"Ballad","gender":"F","bpm":135.99,"albumAddress":"./src/img/081.jpg"},{"musicTitle":"Hands on me","artist":"PRODUCE 101","musicAddress":"./src/audio/082.mp3","genre":"Dance","gender":"M","bpm":120,"albumAddress":"./src/img/082.jpg"},{"musicTitle":"She`s a Baby","artist":"지코 (ZICO)","musicAddress":"./src/audio/083.mp3","genre":"R&B / Soul","gender":"M","bpm":153.93,"albumAddress":"./src/img/083.jpg"},{"musicTitle":"열어줘","artist":"Knock","musicAddress":"./src/audio/084.mp3","genre":"Dance","gender":"M","bpm":145.95,"albumAddress":"./src/img/084.jpg"},{"musicTitle":"알듯 말듯해","artist":"서은광 (비투비), 임현식 (비투비), 육성재 (비투비)","musicAddress":"./src/audio/085.mp3","genre":"Drama","gender":"M","bpm":98,"albumAddress":"./src/img/085.jpg"},{"musicTitle":"FRUITY (Prod. GroovyRoom)","artist":"효린, 키썸 (Kisum)","musicAddress":"./src/audio/086.mp3","genre":"Dance","gender":"F","bpm":97.01,"albumAddress":"./src/img/086.jpg"},{"musicTitle":"이 소설의 끝을 다시 써보려 해","artist":"한동근","musicAddress":"./src/audio/087.mp3","genre":"Ballad","gender":"M","bpm":134.15,"albumAddress":"./src/img/087.jpg"},{"musicTitle":"울고 싶지 않아","artist":"세븐틴","musicAddress":"./src/audio/088.mp3","genre":"Dance","gender":"M","bpm":100.02,"albumAddress":"./src/img/088.jpg"},{"musicTitle":"You(=I)","artist":"볼빨간사춘기","musicAddress":"./src/audio/089.mp3","genre":"Folk","gender":"F","bpm":105,"albumAddress":"./src/img/089.jpg"},{"musicTitle":"SUPER STAR","artist":"G-DRAGON","musicAddress":"./src/audio/090.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":130.01,"albumAddress":"./src/img/090.jpg"},{"musicTitle":"에라 모르겠다","artist":"BIGBANG","musicAddress":"./src/audio/091.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":90,"albumAddress":"./src/img/091.jpg"},{"musicTitle":"피 땀 눈물","artist":"방탄소년단","musicAddress":"./src/audio/092.mp3","genre":"Rap / Hip-hop","gender":"M","bpm":93,"albumAddress":"./src/img/092.jpg"},{"musicTitle":"이런 엔딩","artist":"아이유","musicAddress":"./src/audio/093.mp3","genre":"Ballad","gender":"F","bpm":121.74,"albumAddress":"./src/img/093.jpg"},{"musicTitle":"숨","artist":"박효신","musicAddress":"./src/audio/094.mp3","genre":"Ballad","gender":"M","bpm":99.23,"albumAddress":"./src/img/094.jpg"},{"musicTitle":"넌 왜? (Feat. 서사무엘)","artist":"박보람","musicAddress":"./src/audio/095.mp3","genre":"R&B / Soul","gender":"MIX","bpm":94.01,"albumAddress":"./src/img/095.jpg"},{"musicTitle":"널 사랑하지 않아","artist":"어반자카파","musicAddress":"./src/audio/096.mp3","genre":"Ballad","gender":"MIX","bpm":147.93,"albumAddress":"./src/img/096.jpg"},{"musicTitle":"이 지금","artist":"아이유","musicAddress":"./src/audio/097.mp3","genre":"Ballad","gender":"F","bpm":120.79,"albumAddress":"./src/img/097.jpg"},{"musicTitle":"내가 저지른 사랑","artist":"임창정","musicAddress":"./src/audio/098.mp3","genre":"Ballad","gender":"M","bpm":128.11,"albumAddress":"./src/img/098.jpg"},{"musicTitle":"오빠 (PROD. Brother Su)","artist":"유승우, 산들 (B1A4)","musicAddress":"./src/audio/099.mp3","genre":"Ballad","gender":"M","bpm":110.02,"albumAddress":"./src/img/099.jpg"},{"musicTitle":"Seoul (Feat. Killagramz)","artist":"이효리","musicAddress":"./src/audio/100.mp3","genre":"R&B / Soul","gender":"MIX","bpm":143.01,"albumAddress":"./src/img/100.jpg"}]};

function setTimer() {
	  if(timer == null)
		  timer = setInterval(function(){ Player.playing() }, 1000);
}

function resetTimer() {
	clearInterval(timer);
	timer = null;
}

function setMusicInfo() {
	document.getElementById("music").src = stationList.DemoMusic[i].musicAddress;
	document.getElementById("album").src = stationList.DemoMusic[i].albumAddress;
	$('#title').html(stationList.DemoMusic[i].musicTitle);
	$('#artist').html(stationList.DemoMusic[i].artist);
	like = stationList.DemoMusic[i].like;
	if(like){
		$('.music-player > .dash > a[href="#love"]').toggleClass('fa-heart-on fa-heart-off');
	}																																			
}

function sendLikeInfo() {
	//전역변수 boolean like (line3)
	//현재 음악 재생 중에 좋아요(하트) 누르면 true값 저장  player.like() (line61)
	
	//현재 좋아요 상태 <> 기존 좋아요 상태 : true	: 저장 미실시
	//												false	: 저장 실행
	//												공통 	: 좋아요 불 꺼주고/전역변수 like false로 초기화
	//현재 음악에서 다른 노래로 이동 시(player.skip 발생 시)-> true값이면 해당 정보 전송..(request.setAttribute) //session에 저장 // ?? 저장된 정보를 어떻게 확인해서 나중에 다시 노래 틀었을 때, 그 좋아요 취소가 가능??
	if(like == stationList.DemoMusic[i].like) {	//현재 좋아요 정보와 기존 좋아요 정보 일치// 변경사항 없음!		
		if(like){
			$('.music-player > .dash > a[href="#love"]').toggleClass('fa-heart-on fa-heart-off');
		}
		like = false; //like 초기화
		return;
	} 
	
	stationList.DemoMusic[i].like = like; // 정보 불일치 시// 기존 정보 제거하고 새 정보 저장
	
//	if(like) {
//		$.ajax({
//			url : "mc",
//			data : { 
//				command : "createLike",
//				email	: sessionScope.userId, // 미정
//				musicAddress : stationList.DemoMusic[i].musicAddress
//			},
//			type : "post",
//			dataType : "json", //? "html"? or "text"
//			success : function(result) { //? ~ LikeDAO.createLike 밑단에 json파싱 함수 만들고  LikeDAO.createLike(retun타입:: 현호: musicDTO=> 나: JsonObj) 값 출력 전에 호출
//				console.log("좋아요 추가 성공");
//				stationList.DemoMusic[i+1] = requestScope.nextSongInfo;				
//			}
//		}); //end of ajax
//	}else {
//		$.ajax({
//			url : "mc",
//			data : { 
//				command : "deleteLike",
//				email	: sessionScope.userId, // 미정
//				musicAddress : stationList.DemoMusic[i].musicAddress
//			},
//			type : "post",
//			dataType : "json", //?
//			success : function() { //?
//				console.log("좋아요 제거 성공");
//				stationList.DemoMusic[i+1] = requestScope.nextSongInfo;	
//			}
//		}); //end of ajax		https://okky.kr/article/295089
//	}
	
	if(like){
		$('.music-player > .dash > a[href="#love"]').toggleClass('fa-heart-on fa-heart-off');
	}
	like = false; //like 초기화
	return;
}

var Player =
{
  isMuted: false,
  isPlaying: false,
  
  duration: 0,
  current: 0,

  mute: function()
  {
    this.isMuted = this.isMuted ? false : true;
    if(window.console) console.log(this.isMuted ? 'Muted' : 'Unmuted');
    if(this.isMuted){
    	document.getElementById("music").muted = true;
    } else {
    	document.getElementById("music").muted = false;
    }
  
    return this
  },
  
  like: function() 
  {
	  if(!like){ //like==false (default) 에서 like가 눌린 상황. 따라서 like에 true값 저장
		  like = true;
	  } else {//like 눌렀다가 취소한 상황. false값 저장
		  like = false;
	  }
	  
	  if(window.console) console.log(like ? 'LuvIT' : 'NoLuv');

	  return this
  },
  
  play: function()
  {
    this.isPlaying = this.isPlaying ? false : true;
    if(window.console) console.log(this.isPlaying ? 'Playing' : 'Paused');
    if(this.isPlaying) {
    	document.getElementById("music").play();
    } else {
    	document.getElementById("music").pause();
    }
    	
    return this
  },
  
  skip: function(d)
  {
    if(window.console) console.log('Skipping', d == 'l' ? 'Backwards' : 'Forwards');
    sendLikeInfo();
    if(d == 'l') { //Backwards
	    resetTimer();
	    if(i != 0) { 
	    	i = i-1;
	    }	
    } else {	//Forwards
    	resetTimer();
    	if(i != 99) {	
    		i = i+1;
    	}
    }
    this.current = 0;
    setMusicInfo();

    return this
  },
  
  vol: function(v)
  {
    if(window.console) console.log('Set volume to:', v, '%');
    document.getElementById("music").volume = (v/100);
    
    return this
  },
  
  setDuration: function(s)
  {
    this.duration = s;
    
    var m = 0;
    while(s > 60) { m ++; s -= 60 }
    while(String(s).length == 1) s = '0' + s;
    
    $('.music-player > .dash > .info > i > [name="duration"]').html(m + ':' + s.toFixed(0));
    
    return this
  },
  
  setCurrent: function(s)
  {
    this.current = s;
    
    var m = 0, pct = this.current / this.duration;
    while(s > 60) { m ++; s -= 60 }
    while(String(s).length == 1) s = '0' + s;
    
    $('.music-player > .dash > .info > i > [name="current"]').html(m + ':' + s);
    
    $('.music-player > .dash > a[href="#seek"]:not(:active)').each(function()
    {
      var rotate = 'rotate(-' + ((pct * 180) + 90) + 'deg)';
      
      $(this).add('.music-player > .dash > .seeker > .wheel > .progress').css(
      {
        '-webkit-transform': rotate,
        '-moz-transform': rotate,
        '-ms-transform': rotate,
        '-o-transform': rotate,
        'transform' : rotate
      });
    });
    
    return this
  },
  
  playing: function()
  {
    if(!this.isPlaying)
    	return this;
    
    if(this.current > (this.duration - 1))
    	this.skip('r');
    else
      this.setCurrent(this.current + 1);
    
    return this
  }
};

//main 인터페이스~ 최초에 여기부터 시작
$(function()
{	
	//최초 playerDemo.jsp 시작 시, 장르로부터 추천받은 곡 초기화
	window.onload = function(){
		//stationList = requestScope.musicList;
		
		//var a = JSON.parse(document.getElementById('test11').value);
	   // console.log(a);
	};
	
	//최초 시작
	setMusicInfo();
	Player.play();
  
	document.getElementById("music").addEventListener('loadedmetadata', function() {	  
	  Player.setDuration(document.getElementById("music").duration);
	  Player.setCurrent(0);
	  setTimer();
  });
 
  
  $('.music-player > .dash > a[href="#mute"]').click(function()
  {
    $(this).toggleClass('fa-volume-up fa-volume-off');
    Player.mute();
    
    return !1;
  });
  
  $('.music-player > .dash > a[href="#love"]').click(function()
  {
	  $(this).toggleClass('fa-heart-on fa-heart-off');
	  Player.like();
	  
	  return !1;
  });
  
  $('.music-player > .dash > .controls > a[href="#play"]').click(function()
  {
    $(this).toggleClass('fa-play fa-pause');
    Player.play();
    
    return !1;
  });
  
  $('.music-player > .dash > .controls > a[href="#back"]').click(function() {
	Player.skip('l');
	return !1
	});
  
  $('.music-player > .dash > .controls > a[href="#forward"]').click(function() {
	Player.skip('r');
	return !1
	});
  
  $('.music-player > .dash > .volume-level').bind('mousemove', function(e)
  {
    if($(this).is(':active'))
    {
      $(this).find('em').css('width', e.pageX - $(this).offset().left);
      var vol = $(this).find('em').width() / $(this).width() * 100;
      
      Player.vol(vol > 100 ? 100 : vol);
    }
  });
  
  $('.music-player').on('mousemove', function(e)
  {
    //http://jsfiddle.net/sandeeprajoria/x5APH/11/
    
    var wheel = $(this).find('.dash > .seeker > .wheel'), rotate,
      x = (e.pageX - 20) - wheel.offset().left - wheel.width() / 2,
      y = -1 * ((e.pageY - 20) - wheel.offset().top - wheel.height() / 2),
      deg = (90 - Math.atan2(y, x) * (180 / Math.PI)), pct, nc, nm = 0;
      if(deg > 270) deg = 270; else if(deg < 90) deg = 90;
      rotate = 'rotate(' + deg + 'deg)';
      pct = deg; pct = 270 - pct; pct = pct / 180;
      nc = Math.round(Player.duration * pct);
  
    $(this).find('.dash > a[href="#seek"]:active').each(function()
    {
      Player.current = nc;
      while(nc > 60) { nm ++; nc -= 60 }
      while(String(nc).length == 1) nc = '0' + nc;
      
      $('.music-player > .dash > .info > i > [name="current"]').html(nm + ':' + nc);
      
      $(this).add('.music-player > .dash > .seeker > .wheel > .progress').css(
      {
        '-webkit-transform': rotate,
        '-moz-transform': rotate,
        '-ms-transform': rotate,
        '-o-transform': rotate,
        'transform' : rotate
      });
    });
  });
});