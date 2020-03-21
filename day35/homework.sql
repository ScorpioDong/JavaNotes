-- 1. 查询Student表中的所有记录的Sname、Ssex和Class列。
select SNAME, SSEX, CLASS
from STUDENT;

-- 2、 查询教师所有的单位即不重复的Depart列。
select distinct DEPART
from TEACHER;

-- 3、 查询Student表的所有记录。
select *
from STUDENT;

-- 4、 查询Score表中成绩在60到80之间的所有记录。
select *
from SCORE
where DEGREE between 60 and 80;

-- 5、 查询Score表中成绩为85，86或88的记录。
select *
from SCORE
where DEGREE in (85, 86, 88);

-- 6、 查询Student表中“95031”班或性别为“女”的同学记录。
select *
from STUDENT
where CLASS = 95031
   or SSEX = '女';

-- 7、 以Class降序查询Student表的所有记录。
select *
from STUDENT
order by CLASS desc;

-- 8、 以Cno升序、Degree降序查询Score表的所有记录。
select *
from SCORE
order by CNO asc, DEGREE desc;

-- 9、 查询“95031”班的学生人数。
select count(1)
from STUDENT
where CLASS = 95031;

-- 10、查询Score表中的最高分的学生学号和课程号。
select SNO, CNO
from SCORE s
where DEGREE = (select max(DEGREE) from SCORE);

-- 11. 查询‘3-105’号课程的平均分。
select avg(DEGREE)
from SCORE
where CNO = '3-105';

-- 12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
select avg(DEGREE)
from SCORE
where CNO like '3%'
  and CNO = (select CNO
             from (select CNO, count(CNO) as NUM from SCORE group by CNO) as CN
             where NUM > 5);

-- 13、查询最低分大于70，最高分小于90的Sno列。
select SNO
from SCORE
where DEGREE between 70 and 90;

-- 14、查询所有学生的Sname、Cno和Degree列。
select SNAME, CNO, DEGREE
from STUDENT stu,
     SCORE sco
where stu.SNO = sco.SNO;

-- 15、查询所有学生的Sno、Cname和Degree列。
select SNO, CNAME, DEGREE
from COURSE cou,
     SCORE sco
where cou.CNO = sco.CNO;

-- 16、查询所有学生的Sname、Cname和Degree列。
select SNAME, CNAME, DEGREE
from STUDENT stu,
     COURSE cou,
     SCORE sco
where cou.CNO = sco.CNO
  and stu.SNO = sco.SNO;

-- 17、查询“95033”班所选课程的平均分。
select avg(DEGREE)
from STUDENT stu,
     SCORE sco
where stu.CLASS = '95033'
  and stu.SNO = sco.SNO;

# 18、假设使用如下命令建立了一个grade表：
#
# create table grade(low number(3,0),upp number(3),rank char(1));
# insert into grade values(90,100,’A’);
# insert into grade values(80,89,’B’);
# insert into grade values(70,79,’C’);
# insert into grade values(60,69,’D’);
# insert into grade values(0,59,’E’);
# commit;
# 现查询所有同学的Sno、Cno和rank列。

create table grade
(
    low  numeric(3, 0),
    upp  numeric(3),
    rank char(1)
);
insert into grade
values (90, 100, 'A');
insert into grade
values (80, 89, 'B');
insert into grade
values (70, 79, 'C');
insert into grade
values (60, 69, 'D');
insert into grade
values (0, 59, 'E');
commit;

select stu.SNO, sco.CNO, grade.rank
from STUDENT stu
         left join SCORE sco on stu.SNO = sco.SNO
         left join grade grade on sco.DEGREE between grade.low and grade.upp;

-- 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
select sco.SNO, SNAME, SSEX, SBIRTHDAY, CLASS, CNO, DEGREE
from STUDENT stu,
     SCORE sco
where stu.SNO = sco.SNO
  and sco.CNO = '3-105'
  and sco.DEGREE > (
    select DEGREE
    from SCORE
    where SNO = 109
      and CNO = '3-105');

-- 20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
-- 一门以上课程的同学的最高分
select SNO, DMAX
from (select SNO, COUNT(SNO) as NUM, MAX(DEGREE) as DMAX from SCORE group by SNO) as TEMP
where TEMP.NUM > 1;

-- 整合
select *
from SCORE
         inner join (select SNO, DMAX
                     from (select SNO, COUNT(SNO) as NUM, MAX(DEGREE) as DMAX from SCORE group by SNO) as TEMP
                     where TEMP.NUM > 1) as TEMP2 on SCORE.SNO = TEMP2.SNO and DEGREE != DMAX;

-- 21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
select *
from SCORE
where DEGREE > (select DEGREE from SCORE where SNO = 109 and CNO = '3-105');

-- 22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
select SNO, SNAME, SBIRTHDAY
from STUDENT
where YEAR(SBIRTHDAY) = (select YEAR(SBIRTHDAY) from STUDENT where SNO = 108);

-- 23、查询“张旭“教师任课的学生成绩。
select SNO, DEGREE
from SCORE sco,
     COURSE cou,
     TEACHER tea
where tea.TNAME = '张旭'
  and tea.TNO = cou.TNO
  and cou.CNO = sco.CNO;

-- 24、查询选修某课程的同学人数多于5人的教师姓名。
;
select TNAME
from TEACHER tea,
     COURSE cou
where tea.TNO = cou.TNO
  and cou.CNO in (select CNO from (select CNO, count(SNO) as count from SCORE group by CNO) as T where T.count > 5);

-- 25、查询95033班和95031班全体学生的记录。
select *
from STUDENT
where CLASS in (95033, 95031);

-- 26、查询存在有85分以上成绩的课程Cno.
select CNO
from SCORE
where DEGREE > 85;

-- 27、查询出“计算机系“教师所教课程的成绩表。
select SNO, DEGREE, CNAME, TNAME
from SCORE sco,
     COURSE cou,
     TEACHER tea
where sco.CNO = cou.CNO
  and cou.TNO = tea.TNO
  and tea.DEPART = '计算机系';

-- 28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。

-- 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
select CNO, SNO, DEGREE
from SCORE
where DEGREE > (select max(DEGREE) from SCORE where CNO = '3-245')
  and CNO = '3-105'
order by DEGREE desc;

-- 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.

-- 31、查询所有教师和同学的name、sex和birthday.
select SNAME as NAME, SSEX as SEX, SBIRTHDAY as BIRTHDAY
from STUDENT
union
select TNAME as NAME, TSEX as SEX, TBIRTHDAY as BIRTHDAY
from TEACHER;

-- 32、查询所有“女”教师和“女”同学的name、sex和birthday.
select SNAME as NAME, SSEX as SEX, SBIRTHDAY as BIRTHDAY
from STUDENT
where SSEX = '女'
union
select TNAME as NAME, TSEX as SEX, TBIRTHDAY as BIRTHDAY
from TEACHER
where TSEX = '女';

-- 33、查询成绩比该课程平均成绩低的同学的成绩表。
select SNO, SCORE.CNO, DEGREE
from SCORE
         inner join (select CNO, AVG(DEGREE) as AVG from SCORE group by CNO) as TEMP
                    on SCORE.CNO = TEMP.CNO and SCORE.DEGREE < TEMP.AVG;

-- 34、查询所有任课教师的Tname和Depart.
select TNAME, DEPART
from TEACHER;

-- 35、查询所有未讲课的教师的Tname和Depart.
select TNAME, DEPART
from TEACHER
where TEACHER.TNO not in (select TEACHER.TNO
                          from TEACHER,
                               COURSE
                          where TEACHER.TNO = COURSE.TNO);

-- 36、查询至少有2名男生的班号。

select CLASS
from (select CLASS, count(SNO) as COUNT from STUDENT where SSEX = '男' group by CLASS) as TEMP
where TEMP.COUNT >= 2;

-- 37、查询Student表中不姓“王”的同学记录。
select *
from STUDENT
where SNAME not like '王%';

-- 38、查询Student表中每个学生的姓名和年龄。
select SNAME, (YEAR(now()) - YEAR(SBIRTHDAY)) as AGE
from STUDENT;

-- 39、查询Student表中最大和最小的Sbirthday日期值。
select MAX(SBIRTHDAY) as MIN, MIN(SBIRTHDAY) as MAX
from STUDENT;

-- 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
select *
from STUDENT
order by CLASS desc, SBIRTHDAY asc;

-- 41、查询“男”教师及其所上的课程。
select TNAME, CNAME
from TEACHER,
     COURSE
where TEACHER.TSEX = '男'
  and TEACHER.TNO = COURSE.TNO;

-- 42、查询最高分同学的Sno、Cno和Degree列。
select SNO, CNO, DEGREE
from SCORE
where DEGREE = (select max(DEGREE) from SCORE);

-- 43、查询和“李军”同性别的所有同学的Sname.
select SNAME
from STUDENT
where SSEX = (select SSEX from STUDENT where SNAME = '李军');

-- 44、查询和“李军”同性别并同班的同学Sname.
select SNAME
from STUDENT
         inner join (select SSEX, CLASS from STUDENT where SNAME = '李军') as TEMP
where STUDENT.CLASS = TEMP.CLASS
  and TEMP.SSEX = STUDENT.SSEX;

-- 45、查询所有选修“计算机导论”课程的“男”同学的成绩表
select STUDENT.SNO, SNAME, S.CNO, DEGREE
from STUDENT
         inner join SCORE S on STUDENT.SNO = S.SNO
         inner join COURSE C on S.CNO = C.CNO and C.CNAME = '计算机导论'
where SSEX = '男';