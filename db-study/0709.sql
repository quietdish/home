select  조회 *
from
where 조건
group by 
having
order by 
;


select 
    grade, avg(weight)
from student
group by grade;


select 
    grade, avg(weight)
from student
where grade != 1
group by grade
having avg(weight) >= 68;

select * 
from student;

--65키로가 넘는 사람들만 대상으로 학과별 몸무게 총합
select
    deptno1, sum(weight)
from student
where weight > 65
group by deptno1;