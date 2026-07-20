select * from emp;

select *
from emp 
where hiredate = '80/12/17';

select *
from emp 
where hiredate = '1980-12-17';

select *
from emp 
where hiredate > '80/08/20'; --이날 이후 입사한 사람들

select *
from emp 
where hiredate <= '1981-04-05'; --이전에 입사한 사람들

desc emp;


/*-------------------------------*/
정렬 order by
단순조회 - 정렬을 명시하지 않으면 순서보장하지않음
order by 정렬기준 컬럼명 [asc } desc] [오름차순 | 내림차순]

select ...
from ...
--where ..
order by ...
;

select * 
from student
order by name; --asc 오름차순 기본 a~

select * 
from student
order by name desc;     --내림차순 z~

-- 학생들 학년기준 내림차순 - 이름,학년 조회
select name, grade
from student
order by grade desc;

-- 학생 기준 1,2,3학년 키 내림차순 순서로 조회  ---15행
select *
from student 
where grade in (1,2,3)
order by height desc;

select *
from student 
where grade in (1,2,3)
order by grade, height desc;    --학년으로 정렬 다음에 키순으로 내림차순

select *
from student 
where grade in (1,2,3)
order by height, grade desc;    --키 먼저 정렬 다음에 학년 내림차순

select *
from student 
where grade in (1,2,3)
order by grade desc, height asc;    -- 학년먼저 내림차순, 키 오름차순

select *
from student
order by birthday;  --오름차순 (숫자)작은->큰    작을수록 날짜는 과거

select *
from student
order by birthday desc; --생일늦은(미래). 어린사람 내림차순