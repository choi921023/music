--테이블 드랍
drop table likeinfo;
drop table historyinfo;
drop table stationinfo;
drop table userinfo;
drop table musicinfo;
drop table musicruleinfo;
drop table bpmruleinfo;
drop table genderruleinfo;
drop table melodyruleinfo;
drop table genreruleinfo;

--사용자 정보 테이블, 유저 아이디가 프라이머리 키 
create table userinfo (
	user_id varchar2(30) primary key,
	user_name varchar2(10) not null,
	user_pw varchar2(20) not null
);
--음악 정보 테이블, 음악 재생용 주소가 프라이머리 키
create table musicinfo (
	music_musadd varchar2(50) primary key,
	music_name varchar2(50) not null,
	music_singer varchar2(50) not null,
	music_genre varchar2(20) not null ,
	music_bpm number not null,
	music_gender varchar2(10) not null,
	music_melody varchar2(5) not null,
	music_albumadd varchar2(50) not null
);
--like 테이블, 유저 아이디와 음악 주소가 외부키
create table likeinfo (
	user_id varchar2(30),
	music_musadd varchar2(50) constraint likeinfo_music_musadd_fk references
	musicinfo(music_musadd)
);
--히스토리 테이블, 유저 아이디와 음악 주소가 외부키
create table historyinfo (
	user_id varchar2(30) constraint historyinfo_user_id_fk references
	userinfo(user_id),
	music_musadd varchar2(50) constraint historyinfo_music_musadd_fk references
	musicinfo(music_musadd),
	writeday date not null
);
--기준들에 대한 카운트를 기록하기 위한 테이블, 모든 기준들에 대해서 카운트
create table genreruleinfo (
	genre varchar2(20),
	num number default 0
);
create table bpmruleinfo (
	bpm varchar2(10),
	num number default 0
);
create table genderruleinfo (
	gender varchar2(10),
	num number default 0
);
create table melodyruleinfo (
	melody varchar2(10),
	num number default 0
);
--이용자마다 생성되는 스테이션 정보를 기록하기 위한 테이블
create table stationinfo (
	user_id varchar2(30),
	music_musadd varchar2(50) 
);

ALTER TABLE stationinfo  ADD FOREIGN KEY (user_id) REFERENCES userinfo  (user_id) ON DELETE CASCADE;
ALTER TABLE stationinfo  ADD FOREIGN KEY (music_musadd) REFERENCES musicinfo  (music_musadd) ON DELETE CASCADE;
ALTER TABLE stationinfo ADD PRIMARY KEY (user_id, music_musadd);
ALTER TABLE likeinfo  ADD FOREIGN KEY (user_id) REFERENCES userinfo  (user_id) ON DELETE CASCADE;

commit;

select * from USERINFO;