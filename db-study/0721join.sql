--selectjoin10

select * from department;   --12
select * from student;      --20
select * from professor;    --16

select s.name,
        s.deptno1,
        d.dname
from student s,
    department d
where s.deptno1 = d.deptno; --20 학과번호 같은 학생이름,학과이름

select *
from student s,
    professor p,
    department d
where s.profno = p.profno
and s.deptno1 = d.deptno;   --15 학과번호 같은

select *
from student s
inner join professor p
on s.profno = p.profno
inner join department d
on s.deptno1 = d.deptno;    --15 안시조인

select 
    s.name,
    p.name,
    d.dname
from student s
inner join professor p      --차례대로 조인
on s.profno = p.profno
inner join department d     --안시조인
on s.deptno1 = d.deptno;    --15 학과같은 학생이름,교수이름,학과이름

select 
    s.name,
    p.name,
    d.dname
from student s
inner join professor p      --차례대로 조인
on s.profno = p.profno
inner join department d     --안시조인
on s.deptno1 = d.deptno
and s.deptno1 = 101;        --3