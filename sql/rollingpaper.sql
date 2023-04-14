--======================
--관리자계정
--======================
alter session set "_oracle_script" = true;

create user khrollingpaper identified by khrollingpaper
default tablespace users;

alter user khrollingpaper quota unlimited on users;

grant connect, resource to khrollingpaper;

--=======================
-- khrollingpaper
--=======================
create table member(
    no number,
    name varchar2(30) not null,
    password varchar2(300) not null,
    constraint pk_member_no primary key(no)
);

create sequence seq_member_no;

insert into member values(seq_member_no.nextval, '장원정', '1234');

insert into member values(seq_member_no.nextval, '김동현', '1234');

select * from member;

update member set password = '$2a$10$i.nopDUnqs81BGOA2UibEeXt2jH.3uLhLPzKtwQDma4mBYPXBQxgq' where name = '장원정';

update member set password = '$2a$10$Q9s4QExggvgYQfM0vGCJ4O5oMp0wh0IxckO6c7jZeikbLgT9CWbOy' where name = '김동현';

create table board(
    no number,
    owner_no number,
    writer varchar2(30) not null,
    title varchar2(2000) not null,
    content varchar2(4000) not null,
    constraint pk_board_no primary key(no),
    constraint fk_board_owner_no foreign key(owner_no) references member(no) on delete cascade
);

create sequence seq_board_no;

select * from board;



