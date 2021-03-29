use parayo3;
create schema parayo3 collate utf8_general_ci;

drop table `user`;

-- jpa 사용 시, 테이블 생성.
-- jpa에서 id를 generate를 사용하여 자동증가가 될 경우, sql에서도 auto_increment를 사용하여 자동증가되도록 설정해야 함.
-- 사이즈에 맞게 변수 사이즈 설정하기
create table `user` (
	id bigint(1) not null auto_increment primary key,
	email varchar(20),
    `password` varchar(70),
    `name` varchar(10),
    create_at varchar(30),
    update_at varchar(30)
);

select * from `user`;

create index user_idx_01 on user (email);