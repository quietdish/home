--join 예전 방식.. from '','' where

select * from emp;      --12
select * from dept;     --4

select e.empno,
        e.ename,
        d.dname,
        d.loc
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e, dept d
where e.deptno = d.deptno;

--ansi join 요즘 방식.. from '' join '' on

select *
from emp e
inner join dept d
on e.deptno = d.deptno;     --12행

--조건 추가 and
select *
from emp e
inner join dept d
on e.deptno = d.deptno
and e.deptno in (20,30);    --20또는30만 보여라 9행

select *
from emp e, dept d
where e.deptno = d.deptno
and e.deptno in (20,30);    --20또는30만 보여라 9행 (10이 3행ㅋ)

--조인조건where을 빼면 카티션 곱 (예를들어 직원12명*부서3개면 36개 결과 나온대)

--inner join은 null을 빼고 합쳐짐

--outer join
---left outer join 학생 무조건 다 보여줘 (교수없어도)

select * from student;      --20    교수없는학생null 5명
select * from professor;    --16

select 
    s.name, s.profno,
    p.name, p.profno
from student s, professor p
where s.profno = p.profno;      --15

select
    s.name, s.profno,
    p.name, p.profno
from student s
left join professor p           --왼쪽 테이블 살림. 학생 모두 조회.
on s.profno = p.profno;         --20    null 나옴. 지도교수없어도 학생 조회, 교수null

select
    s.name, s.profno,
    p.name, p.profno
from student s
right join professor p          --오른쪽 테이블 살림. 교수 모두 조회.
on s.profno = p.profno;         --22    null나옴. 지도학생이 없어도 교수 조회, 학생null

--FROM A, B
--WHERE A.id = B.id             --oracle옛날방식

--FROM A
--JOIN B
--ON A.id = B.id                --ansi방식


--count 
select count(*)
from student s
left join professor p           --왼쪽 테이블 살림. 학생 모두 조회.
on s.profno = p.profno;         --20

select count(*)
from student s
right join professor p          --오른쪽 테이블 살림. 교수 모두 조회.
on s.profno = p.profno;         --22 교수 한명이 학생 여러명을 맡을 수 있음.

select * from professor;
select * from student;

--지도학생이 없는 교수
select count(*)             --7
from professor p
left join student s          --오른쪽 테이블 살림. 교수 모두 조회.
on p.profno = s.profno
where s.studno is null;           --학생 번호가 없다 = 학생이 한명도 연결 안됐다

select p.profno, p.name
from professor p
left join student s          --오른쪽 테이블 살림. 교수 모두 조회.
on p.profno = s.profno
where s.studno is null;      --7