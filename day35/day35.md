# Day 35

##### 7.7 分组查询

```mysql
select fieldName
from tbName 
where condition_ 
group by 分组要求;
-- group by是一个分组关键字

-- 查询各部门人数是多少
-- 1. 需要按照department_id进行分组
-- 2. 计数需要使用count， 根据用户的employee_id进行计数操作
select department_id, count(employee_id)
from t_employees
group by department_id;

-- 查询各部门的平均工资
-- 1. 需要按照department_id进行分组
-- 2. 平均工资使用avg方法计算
select department_id, avg(salary)
from t_employees
group by department_id;

-- 查询各部门，各岗位的人数
-- 1. 需要按照department_id进行分组
-- 2. 需要按照岗位job_id进行分组
-- 3. 记录人数，count(employee_id)
select department_id, job_id, count(employee_id)
from t_employees
group by department_id, job_id;

-- [42000][1055] Expression #1 of SELECT list is not in GROUP BY
-- clause and contains nonaggregated column 'company.t_employees.department_id'
-- which is not functionally dependent on columns in GROUP BY clause;
-- this is incompatible with sql_mode=only_full_group_by
-- 如果使用group by要求分组字段一定是查询要求字段，这里需要根据查询结果进行分组
select department_id
from t_employees
group by job_id;
```

##### 7.8 分组过滤查询

```mysql
select fieldName
from tbName 
where condition_ 
group by 分组要求
having 过滤规则;
-- having是在 group by 之后的条件过滤

-- 查询指定100，50，30，80最高工资
-- 1. 需要按照department_id进行分组
-- 2. 最高工资
-- 3. 限制manager_id = 100
-- 4. 限制department_id号为100，50，30，80
select department_id, max(salary)
from t_employees
where manager_id = 100
group by department_id
having department_id in (100, 50, 30, 80);
```

##### 7.9 限定查询

```mysql
select fieldName
from tbName
limit 限制;

-- limit [offset_start], row_count

-- 查询员工表中前10个数据，员工first_name, employee_id
select employee_id, first_name
from t_employees
limit 10;

-- 查询员工表中10个数据，要求offset为3，员工first_name, employee_id
-- 起始行从0开始
select employee_id, first_name
from t_employees
limit 3,10;

-- 【重点】
-- limit核心用法，分页查询
-- pageCount 当前是第几页
-- itemCount 一页展示多少个元素
-- select * from tbName limit (pageCount - 1) * itemCount, itemCount;

-- 展示第一页10条数据
select employee_id, first_name
from t_employees
limit 0, 10;

-- 展示第二页10条数据
select employee_id, first_name
from t_employees
limit 10, 10;

-- 展示第三页10条数据
select employee_id, first_name
from t_employees
limit 20, 10;
```

##### 7.10 基本查询总结

```mysql
select fieldName
from tbName
where condition_
group by 分组
having 分组过滤
order by 排序 [asc/desc]
limit offset, count;

-- from 数据来源，从那张表中查询数据
-- where 查询数据的条件
-- group by 分组
-- having 分组之后条件约束
-- select 查询指定的字段
-- order by 排序要求
-- limit 限制结果行数
```

##### 7.11 子查询[重点，难点]

###### 7.11.1 基本格式

```mysql
select fieldName
from tbName
where (子查询结果);
```

###### 7.11.2 子查询结果作为条件判断约束

```mysql
-- 查询工资高于Jack的员工id和姓名
-- 1. 找出Jack的工资
-- 2. 得到Jack工资，作为条件查询对应的员工信息
select salary
from t_employees
where first_name = 'Jack';

select employee_id, first_name
from t_employees
where salary > 8400;

-- 整合为子查询
-- 条件判断
select employee_id, first_name
from t_employees
where salary > (select salary
                from t_employees
                where first_name = 'Jack');

```

###### 7.11.3 子查询结果作为枚举限制 in

```mysql
-- 查询和Jack同部门的员工信息
-- 1. 找出Jack的部门编号
select department_id
from t_employees
where first_name = 'Jack';

-- 2. 根据Jack的部门编号，使用in枚举查询，限制条件
select employee_id, first_name
from t_employees
where department_id in (80);

-- 整合为子查询
select employee_id, first_name
from t_employees
where department_id in (select department_id
                        from t_employees
                        where first_name = 'Jack');

```

###### 7.11.3 子查询结果作为一张表，从表内查询指定数据

```mysql
-- 查询员工表中工资前五名的员工信息
-- 1. 找到员工的id，first_name，工资降序
select employee_id, first_name
from t_employees
order by salary desc;

select employee_id, first_name
from (select employee_id, first_name
      from t_employees
      order by salary desc) as temp
limit 5;
```

##### 7.11 合并查询[仅了解]

```mysql
union

-- 合并，要求查询要求的字段个数一致
-- 去重
select employee_id, first_name
from t_employees
union
select job_id, job_title
from t_jobs;

-- 合并，要求查询要求的字段个数一致
-- 不去重
select department_id, first_name
from t_employees
union all
select manager_id, department_name
from t_departments;
```

##### 7.12 表连接查询【重点】

###### 7.12.1 基本格式

```mysql
select fieldName
from tbName1
连接符 tbName2
on 条件
```

###### 7.12.2 笛卡尔乘积【避免】

```mysql
-- 笛卡尔乘积，没有约束条件，数据库匹配发生相乘关系，结果也不是预期结果
-- 无意义结果
select employee_id, first_name
from t_employees
inner join t_jobs;
```

###### 7.12.3 内连接查询 inner join on 两张表

```mysql
-- 查询所有部门部门名，和对应的员工信息id和first_name
select t_departments.department_name,
       t_employees.employee_id,
       t_employees.first_name -- 查询内容
from t_employees -- 从员工表中查询
         inner join t_departments -- 内连接部门表
                    on t_employees.department_id = t_departments.department_id;
-- 条件限制员工表中的部门Id = 部门表中的部门id

-- 查询所有部门部门名，和对应的员工信息id和first_name
-- 给予表格一个别名，方便使用
select d.department_name,
       e.employee_id,
       e.first_name -- 查询内容
from t_employees e-- 从员工表中查询
         inner join t_departments d-- 内连接部门表
                    on e.department_id = d.department_id; -- 条件限制员工表中的部门Id = 部门表中的部门id
```

###### 7.12.4 内连接查询 inner join on 四张表

```mysql
-- 查询所有员工对应的ID号，名字，部门名称，和国家对应名字
select te.employee_id, te.first_name, td.department_name, tc.country_name
from t_employees te
    inner join t_departments td on te.department_id = td.department_id
    inner join t_locations tl on td.location_id = tl.location_id
    inner join t_countries tc on tl.country_id = tc.country_id;
```

###### 7.12.5 内连接查询 inner join on 五张表

```mysql
-- 查询所有员工对应的ID号，名字，工作职称，部门名称，和国家对应名字
select te.employee_id, te.first_name, tj.job_title, td.department_name, tc.country_name
from t_employees te
    inner join t_jobs tj on te.job_id = tj.job_id
    inner join t_departments td on te.department_id = td.department_id
    inner join t_locations tl on td.location_id = tl.location_id
    inner join t_countries tc on tl.country_id = tc.country_id;	
```

###### 7.12.6 左外连接 left join on

```mysql
-- 左外连接 左表是主表，要求左表完整显示，右表匹配左表数据，如果右表没有数据匹配，显示null

-- 查询所有的员工信息ID，first_ame，已经对应的部门名字
select te.employee_id, te.first_name, td.department_name
from t_employees te
         left join t_departments td on te.department_id = td.department_id;
```

###### 7.12.7 右外连接 right join on

```mysql
-- 右外连接查询，右表是主表，要求右表完整展示，左表匹配右表数据，如果左表没有数据匹配，显示null

-- 查询所有部门对应员工信息，员工信息没有显示null
select td.department_name,te.employee_id, te.first_name
from t_employees te
         right join t_departments td on te.department_id = td.department_id;
```

#### 8. DML语句

##### 8.1 增加 insert

```mysql
create table person(
    id int,
    name varchar(30),
    salary float(8, 2),
    age int
);

-- 规矩插入
insert into person(id, name, salary, age) VALUE (1, '骚磊', 100.5, 16);

-- 省略所有的字段名，按照字段顺序添加
insert into person value (2, '茂林', 20.5, 50);

-- 指定字段数据插入
insert into person(name, age) value ('骚杰', 66);

-- 禁止字段数据类型和插入数据类型不一致！！！
insert into person(name, age) value ('66', '23333333');
insert into person(name, age) value ('66', '你在整一个试试???');
```

##### 8.2 修改 update 【慎用】

```mysql
-- Unsafe query: 'Update' statement without 'where' updates all table rows at once
-- 没有任何约束的情况下，当前指定数据表中的所有数据行全部执行修改操作
-- 一定要带有where条件约束
update person set id = 10;

-- OK
update person set id = 10 where name = '骚磊';
-- 可以同时修改多个数据，不同的字段赋值操作使用 逗号隔开
update person set id = 20, age = 10, salary = 200000.01 where name = '骚磊';
```

##### 8.3 删除 delete【慎用】

```mysql
-- Unsafe query: 'Delete' statement without 'where' clears all data in the table
delete from person;

-- 根据条件约束删除是允许的
delete from person where name = '66';
```

##### 8.4 truncate 清空整表数据

```mysql
-- 清空整表数据，并且会影响到一定数据约束，例如auto_increment 自增长
truncate table person;
```

#### 9. 库表操作

##### 9.1 创建数据库

```mysql
-- dbName数据库的名字，可以约束编码集[是情况而定]
create database dbName [character set charset];
```

##### 9.2 删除数据库

```mysql
-- 删除指定数据库
drop database dbName;
```

##### 9.3 修改数据库

```mysql
-- 修改数据库编码集
alter database dbname character set utf8;
```

##### 9.4 数据类型

###### 9.4.1 数值类型

| 类型             | 大小                                     | 范围（有符号）                                 | 范围（无符号）              | 用途           |
| ---------------- | ---------------------------------------- | ---------------------------------------------- | --------------------------- | -------------- |
| [INT或INTEGER]() | 4 字节                                   | (-2 147 483 648，2 147 483 647)                | (0，4 294 967 295)          | 大整数值       |
| DOUBLE           | 8 字节                                   | （-1.797E+308,-2.22E-308）                     | (0,2.22E-308,1.797E+308)    | 双精度浮点数值 |
| [DOUBLE(M,D)]()  | 8个字节，M表示长度，D表示小数位数        | 同上，受M和D的约束   DUBLE(5,2) -999.99-999.99 | 同上，受M和D的约束          | 双精度浮点数值 |
| [DECIMAL(M,D)]() | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值，M最大值为65                    | 依赖于M和D的值，M最大值为65 | 小数值         |



###### 9.4.2 日期类型

| 类型         | 大小 | 范围                                                         | 格式                | 用途                     |
| ------------ | :--- | ------------------------------------------------------------ | ------------------- | ------------------------ |
| [DATE]()     | 3    | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME         | 3    | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR         | 1    | 1901/2155                                                    | YYYY                | 年份值                   |
| [DATETIME]() | 8    | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP    | 4    | 1970-01-01 00:00:00/2038 结束时间是第 **2147483647** 秒北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

###### 9.4.3 字符串类型

| 类型                            | 大小         | 用途                              |
| ------------------------------- | ------------ | --------------------------------- |
| [CHAR]()                        | 0-255字符    | 定长字符串  char(10) 10个字符     |
| [VARCHAR]()                     | 0-65535 字节 | 变长字符串  varchar(10)  10个字符 |
| [BLOB]()（binary large object） | 0-65 535字节 | 二进制形式的长文本数据            |
| [TEXT]()                        | 0-65 535字节 | 长文本数据                        |

- [CHAR和VARCHAR类型类似，但它们保存和检索的方式不同。它们的最大长度和是否尾部空格被保留等方面也不同。在存储或检索过程中不进行大小写转换。]()
- [BINARY和VARBINARY类类似于CHAR和VARCHAR，不同的是它们包含二进制字符串而不要非二进制字符串。也就是说，它们包含字节字符串而不是字符字符串。这说明它们没有字符集，并且排序和比较基于列值字节的数值值。]()
- [BLOB是一个二进制大对象，可以容纳可变数量的数据。有4种BLOB类型：TINYBLOB、BLOB、MEDIUMBLOB和LONGBLOB。它们只是可容纳值的最大长度不同。]()
- [有4种TEXT类型：TINYTEXT、TEXT、MEDIUMTEXT和LONGTEXT。]()

##### 9.5 创建表

```mysql
-- 1. 选择使用的数据库

create table tbName
(
    fieldName1 fieldType1,
    fieldName2 fieldType2,  
    fieldName3 fieldType3,  
    fieldName4 fieldType4
);
-- 可以加入约束，字符集和存储引擎
```

#### 10. 数据约束

##### 10.1 默认值 default

```mysql
-- 创建数据表的过程中，指定字段可以带有默认值，如果用户没有指定数据的情况下，当前
-- 字段会采用默认值方式来进行数据赋值操作。
-- default
create table person1
(
    id int,
    name varchar(50),
    country varchar(50) default 'PRC' -- 默认值字段
);

desc person1;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| id      | int(11)     | YES  |     | NULL    |       |
| name    | varchar(50) | YES  |     | NULL    |       |
| country | varchar(50) | YES  |     | PRC     |       |
+---------+-------------+------+-----+---------+-------+

-- 不给予带有默认值字段对应的数据，会采用默认值方式赋值当前子弹
insert into person1(id, name) value (1, '骚磊');

-- 给予当前带有默认值字段数据赋值操作，会采用给予的数据赋值当前字段
insert into person1(id, name, country) value (2, '航海中路彭于晏', '中华人民共和国');
```

##### 10.2 非空 not null

```mysql
-- not null 非空，要求当前字段必须有对应的数据，如果没有赋值报错
-- NN
-- 实际使用中必要字段！！！

create table person2
(
    id int,
    name varchar(50) not null,
    country varchar(50) default 'PRC' -- 默认值字段
);

+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| id      | int(11)     | YES  |     | NULL    |       |
| name    | varchar(50) | NO   |     | NULL    |       |
| country | varchar(50) | YES  |     | PRC     |       |
+---------+-------------+------+-----+---------+-------+


insert into person2(id, name) VALUE (1, '46号技师');
-- ERROR Field 'name' doesn't have a default value
insert into person2(id) VALUE (2);
```

##### 10.3 唯一 unique

```mysql
-- 字段使用unique约束，当前字段中保存的数据在当前表内不可以重复

create table person3
(
    id int unique,
    name varchar(50) not null,
    country varchar(50) default 'PRC' -- 默认值字段
);

+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| id      | int(11)     | YES  | UNI | NULL    |       |
| name    | varchar(50) | NO   |     | NULL    |       |
| country | varchar(50) | YES  |     | PRC     |       |
+---------+-------------+------+-----+---------+-------+

insert into person3(id, name) value (1, '哆啦A磊');
-- ERROR Duplicate entry '1' for key 'id'
-- 对应当前ID值已经存在，不能再次插入相同id数据
insert into person3(id, name) value (1, '老骚');

-- id使用unique限制唯一，但是null不作为唯一判断范围以内
insert into person3(name) value ('老骚');
insert into person3(name) value ('超超');
insert into person3(id, name) value (null, '贱贱的我就长大了');
insert into person3(id, name, country) value (null, '贱贱的我就长大了',null);
```

##### 10.4 主键 primary key

```mysql
-- 主要要求唯一，非空！！！
-- primary key 主键
-- 主键一般用于在开发中涉及到数据的唯一性参照物，但是不能使用带有业务逻辑要求数据作为
-- 主键，例如 性别 年龄 工资....

create table person4
(
    id int primary key,
    name varchar(50) not null,
    country varchar(50) default 'PRC' -- 默认值字段
);

+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| id      | int(11)     | NO   | PRI | NULL    |       |
| name    | varchar(50) | NO   |     | NULL    |       |
| country | varchar(50) | YES  |     | PRC     |       |
+---------+-------------+------+-----+---------+-------+

insert into person4(id, name) value (1, '骚磊');
-- ERROR Duplicate entry '1' for key 'PRIMARY'
-- 对应使用primary key修饰的主键id已存在。
insert into person4(id, name) value (1, '骚磊');
-- ERROR Field 'id' doesn't have a default value
insert into person4(name) value ('骚磊');
-- ERROR Column 'id' cannot be null
insert into person4(id, name) value (null, '骚磊');
```

##### 10.5 自增长 auto_increment

```mysql
-- 自增长修饰字段会在数据添加的过程中自动赋值叠加操作
-- auto_increment修饰的字段必须是一个Key
-- AI ==> auto_increment
create table person5
(
    id int primary key auto_increment,
    name varchar(50) not null,
    country varchar(50) default 'PRC' -- 默认值字段
);

+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| id      | int(11)     | NO   | PRI | NULL    | auto_increment |
| name    | varchar(50) | NO   |     | NULL    |                |
| country | varchar(50) | YES  |     | PRC     |                |
+---------+-------------+------+-----+---------+----------------+

-- 自增长字段会从1开始
insert into person5(name) value ('郭德纲'); -- id = 1
insert into person5(name) value ('于谦'); -- id = 2

-- 自增长可以指定数值，而且存在影响自增长计数情况
insert into person5(id, name) value (5, '高峰'); -- id = 5
insert into person5(name) value ('栾云平'); -- id = 6

-- 自增长可以指定数值，而且存在影响自增长计数情况 
insert into person5(id, name) value (8,'岳云鹏'); -- id = 8
insert into person5(name) value ('孙越'); -- id = 9

-- 指定id为7，但是当前id数据小于自增长，不影响自增长结果 数据保存排序
insert into person5(id, name) value (7, '郭麒麟'); -- id = 7
insert into person5(name) value ('阎鹤祥'); -- id = 10;

-- 删除数据 
delete from person5 where id = 7;
delete from person5 where id = 10;

-- 被删除的id可以指定使用
insert into person5(id, name) value (7, '郭麒麟'); -- id = 7
-- delete删除不会印象自增长计数
insert into person5(name) value ('阎鹤祥'); -- id = 11
delete from person5 where id = 11;

-- 清空数据表，同时会重置自增长
truncate person5;

-- 数据库彻底关闭，会影响到自增长保存
```

#### 