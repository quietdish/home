

//emp 테이블 
// 테이블? : 데이터가 저장되어있는 장소 (엑셀 비슷한) 행 열 구조  
  엑셀시트

select * from emp;  -- employee 직원


create table emp_temp
as
select empno, ename, job from emp;


select * from emp_temp;

            //         empno ename job
INSERT INTO emp_temp values ( 9138, 'sam', '군인');

1 2 3 4 5 6 65  32 3
 1 1 1 0 1 0 1 0  2 2 03
 
 다른 DB 시스템. 오라클DB mssql mysqwl mariadba mongogdb paostg;resl

auto ....
INSERT INTO emp_temp values (자동..., 'sam', '군인');

MON         MONDAY


시퀀스 사용할때마다 번호표처럼 뽑으면 그다음번호ㅗ 계쏙 짅행..

create sequence bank_number_seq
increment by 1
start with 1;

select bank_number_seq.nextval from dual;


INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');
INSERT INTO emp_temp values ( bank_number_seq.nextval, 'sam', '군인');


