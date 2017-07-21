--���̺� ���
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

--����� ���� ���̺�, ���� ���̵� �����̸Ӹ� Ű 
create table userinfo (
	user_id varchar2(30) primary key,
	user_name varchar2(10) not null,
	user_pw varchar2(20) not null
);
--���� ���� ���̺�, ���� ����� �ּҰ� �����̸Ӹ� Ű
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
--like ���̺�, ���� ���̵�� ���� �ּҰ� �ܺ�Ű
create table likeinfo (
	user_id varchar2(30),
	music_musadd varchar2(50) constraint likeinfo_music_musadd_fk references
	musicinfo(music_musadd)
);
--�����丮 ���̺�, ���� ���̵�� ���� �ּҰ� �ܺ�Ű
create table historyinfo (
	user_id varchar2(30) constraint historyinfo_user_id_fk references
	userinfo(user_id),
	music_musadd varchar2(50) constraint historyinfo_music_musadd_fk references
	musicinfo(music_musadd),
	writeday date not null
);
--���ص鿡 ���� ī��Ʈ�� ����ϱ� ���� ���̺�, ��� ���ص鿡 ���ؼ� ī��Ʈ
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
--�̿��ڸ��� �����Ǵ� �����̼� ������ ����ϱ� ���� ���̺�
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