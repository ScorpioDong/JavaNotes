# Day 34

## 1. 为什么要使用数据库

现有数据存储方式：

1. Java程序在运行过程中对于数据进行存储操作，变量，对象，数组，集合...。数据保存在内存中，数据存储是瞬时的，程序退出，电脑异常，都会导致数据丢失并且不可逆
2. 文件存储，XML，JSON，其他文件。可操作性较差，API繁琐，不同文件有不同解析方式，内存占用和效率问题上很难达到两全

存在问题

1. 文件保存的数据没有数据类型区分，都是字符串。
2. 数据存储量骄傲小，有一定限制。
3. 没有安全限制。
4. 文件操作没有自己的备份，回滚等数据保护机制。

## 2. 什么是数据库

​	数据库是按照特定的数据结构来进行数据的组织，管理和查询的软件。可以长期存储，有安全限制，数据恢复，并且数据存储可拓展。

数据库分类：

1. 网状结构数据库。
2. 层次结构数据库
3. 关系型数据库 
   1. 「Oracle，MySQL，DB2，SQL Server」
   2. 通过表结构方式进行数据存储 --> xls表格
4. 非关系型数据库
   1. MongoDB Redis
   2. 使用哈希表结构方式，Key-Value数据存储
5. ES
   1. ElasticSearch

## 3. 数据库管理系统

​	数据库管理系统(DataBase Management System) (DBMS)，操作和管理数据的大型软件，用于管理，建立，使用和查询数据。

常用DBMS：

1. Oracle
   1. 安全性，稳定性，数据存储复杂程度...
   2. 完全符合工业要求。
   3. 贵
2. DB2
   1. IBM公司出品。
   2. 不常见。
3. SQL Sever
   1. 微软家的。
4. SQLite
   1. 轻量级数据库
   2. 源码，1W行C语言
   3. 手机通讯录，
5. MySQL

## 4. MySQL

### 4.1 MySQL历史简介

​	MySQL数据库默认编码集 Latin1 ==> 西欧

​	瑞典的一个公司开发的！！ MySQL  AB公司， 免费

​	MySQL支持插件！！！

​	社区：InnoDB跨时代的存储引擎

​	MySQL被Oracle收购，一直保持免费，

​	目前流行的版本：5.6、5.7

​	最新版本：8.0  用的公司不多，缺少兼容性稳定性等验证

​	实际开发中我们要考虑稳定性，兼容性，普适性

### 4.2 MySQL获取和安装

官网获取

## 5. SQL 概述

### 5.1 SQL语句概述

​	数据库通用查询语句，不管是MySQL，Oracle，SQL Server都是支持标准SQL语句。不同的数据库都会有自己特定的一些SQL语句。 

​	SQL简单分类

1. C Create
2. R Read
3. U Update
4. D Delete

### 5.2 MySQL基本操作

```shell
# MySQL连接 Shell

mysql -hlocalhost -uroot -ppassword
# mysql 指当前操作连接的数据库
# -hlocalhost -h host 端口，当前数据库的服务器ip地址，域名或者主机名
# -uroot -u user 用户名
# -ppassword -p 用户密码
# 推荐方式 mysql -uroot -p，然后输入密码
```

```mysql
-- 展示当前数据库所有数据表
show databases;

-- 创建数据库
create database DBName;

-- 创建数据库修改编码集
create database DBName character set gbk;

-- 查看创建数据库的详细内容
show create database DBName;

-- 修改数据库编码集
alter database DBName character set gbk;

-- 删除对应数据库
drop database DBName;

-- 选择使用数据库
use DBName;

-- 查看当前使用的数据库
select database();

-- 注释类型1
#  注释类型2
```

## 6. MySQL开发工具使用

```
Navivat for MySQL 非常不错
SQLyog 小海豚
MySQLWorkBench 免费
IDEA 提供MySQL支持
```

## 7. 查询

### 7.1 基本格式

```mysql
select 查询内容 form 从哪里查;
-- 查询内容 字段名 列名
-- 从哪里查 表名
```

#### 7.1.1 查询，字段

```mysql
-- * 所有字段全部查询 （数据库加载时间非常长，数据压力大，不建议）
-- , 逗号分隔查询字段名
```

#### 7.2 查询结果字段数据计算

```mysql
-- 字段直接计算
select SALARY * 12 form table_test;

-- 这里允许加减乘除 + - * / 完成字段的直接算数计算
-- % 不是取余操作，而是占位符
```

#### 7.3 去重查询

```mysql
select distinct 字段 from table_test;
```

#### 7.4 字段别名

```mysql
-- 字段名 as ‘别名’

select 字段 as '别名' from table_test;
```

### 7.2 排序查询

```mysql
-- 基本格式
select fieldName from tbName order by fieldName asc[or desc];

-- 查询结果展示中，按照执行的字段作为标记完成排序
```

#### 7.2.1 单一条件排序

```mysql
select fieldName from tbName order by fieldName asc[or desc];
```

#### 7.2.2 多条件排序

```mysql
select fieldName from tbName 
order by fieldName1 asc[or desc], fieldName2 asc[or desc];
```

### 7.3 条件查询

#### 7.3.1 基本格式

```mysql
select fieldName from tbName where condition;
```

#### 7.3.2 等值判定

```mysql
-- Java中的等值判定是 == 或者equals方法
-- 数据库中使用 = 在where后是等值判定 
```

#### 7.3.3 不等值判定(> < >= <= != <>)

```mysql
-- 查询在员工表内容，工资大于10000 对应的id号，名，和工资
select EMPLOYEE_ID, FIRST_NAME, SALARY
from t_employees
where SALARY > 10000;

-- 查询在员工表内容，工资大于10000 对应的id号，名，和工资
select EMPLOYEE_ID, FIRST_NAME, SALARY
from t_employees
where SALARY >= 10000;

-- 查询在员工表内容，部门ID不等于80 对应的id号，名，工资和部门ID
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
from t_employees
where DEPARTMENT_ID <> 80;

-- 查询在员工表内容，部门ID不等于80 对应的id号，名，工资和部门ID
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
from t_employees
where DEPARTMENT_ID != 80;
```

#### 7.3.4 逻辑判断(and, or, not)

```mysql
-- 查询在员工表内容，要求工资大于10000并且部门编号为80 对应的ID号，名，工资和部门ID
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
from t_employees
where SALARY > 10000 and DEPARTMENT_ID = 80;

-- 查询在员工表内容，要求工资小于2500或者部门编号为90 对应的ID号，名，工资和部门ID
select EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
from t_employees
where SALARY < 2500 or DEPARTMENT_ID = 90;
```

#### 7.3.5 区间 between and

```mysql
-- 要求between min and max 在min <==> max范围以内，而且要求小值之前，大值不然会报
-- 错，这里区间范围是包含指定的边界

-- 区间范围
select EMPLOYEE_ID, FIRST_NAME, SALARY
from t_employees
where SALARY between 8000 and 10000;
```

#### 7.3.6 NULL值判断

```mysql
-- is null 指定当前的字段是null
-- is not null 指定当前字段不是null

-- 找出所有提成为null的数据
select FIRST_NAME, COMMISSION_PCT
from t_employees
where COMMISSION_PCT is null;

-- 找出所有提成不是null的数据
select FIRST_NAME, COMMISSION_PCT
from t_employees
where COMMISSION_PCT is not null;
```

#### 7.3.7 枚举查询 in

```mysql
-- 查询部门编号为60, 70, 90员工名字和对应部门编号
-- in查询效率较低，推荐使用多条件拼接完成查询操作
select FIRST_NAME, DEPARTMENT_ID
from t_employees
where DEPARTMENT_ID in(70, 60, 90);
```

#### 7.3.8 模糊查询 like

```mysql
-- LIKE
-- _ 匹配一个字符
-- % 匹配任意长度字符

-- 查询FIRST_NAME，要求FIRST_NAME字段D字母开头后面有4个字符
select FIRST_NAME
from t_employees
where FIRST_NAME like 'D____';

-- -- 查询FIRST_NAME，要求FIRST_NAME字段带有D字母就可以，而且不区分大小写
select FIRST_NAME
from t_employees
where FIRST_NAME like '%D%';
```

#### 7.3.9 分支结构查询

```mysql
case
	when condition1 then ret1
	when condition2 then ret2
	when condition3 then ret3
end
-- 从case开始，到end结束。满足条件对应一个结果，类似于Java中的switch case

-- 查询姓名，工资已经对应工资划分的等级LEVEL
select FIRST_NAME, SALARY,
case
    when SALARY >= 10000 then 'A'
    when SALARY >= 8000 and SALARY < 10000 then 'B'
    when SALARY >= 6000 and SALARY < 8000 then 'C'
    when SALARY >= 4000 and SALARY < 6000 then 'D'
    else 'E'
end as 'LEVEL'
from t_employees;
```

### 7.4 时间查询

```mysql
-- 语法
select 时间函数([参数列表]);
-- 查询时间情况下，得到的是一个单列单表(虚表)
```

| 时间函数            | 功能描述                             |
| ------------------- | ------------------------------------ |
| sysdate()           | 当前系统时间(年，月，日, 时，分，秒) |
| CURRENT_TIMESTAMP() | 当前系统时间(日，月，年，时，分，秒) |
| curdate()           | 当前日期                             |
| curtime()           | 当前时间                             |
| week()              | 指定日期是这一年的第几周             |
| hour()              | 指定日期是今天第几个小时             |
| minite()            | 指定日期是小时的第几分钟             |
| second()            | 指定日期是分钟的第几秒               |

```mysql
select sysdate();
select CURRENT_TIMESTAMP();
select curdate();
select curtime();
select week('2019-11-23');
select now();
select second(sysdate());
select minute(sysdate());
select hour(sysdate());
```

### 7.5 字符串应用

| 方法                          | 功能描述                                       |
| ----------------------------- | ---------------------------------------------- |
| concat(str1, str2, str3...)   | 拼接多个字符串                                 |
| insert(str, pos, len, newStr) | 在指定字符串位置pos，长度限制len，插入新字符串 |
| lower(str)                    | 大写转小写                                     |
| upper(str)                    | 小写转大写                                     |
| substring(str,pos, len)       | 指定字符串，从pos位置开始，长度限制len         |

```mysql
select concat('你好', ' MySQL', ' Oracle公司产品');
select insert('ABCDEFG', 3, 3, '你好');
select upper('abcdefg');
select lower('ABCDEF');
select substring('ABCDEFG', 2, 5);
```

### 7.6 内置方法

| 方法    | 功能描述               |
| ------- | ---------------------- |
| sum()   | 指定字段一列总会       |
| avg()   | 指定字段一列平均值     |
| max()   | 指定字段一列中的最大值 |
| min()   | 指定字段一列中的最小值 |
| count() | 指定字段有多少行       |

```mysql
-- 工资总和
select sum(SALARY)
from t_employees;

-- 工资平均数
select avg(SALARY)
from t_employees;

-- 工资最大值
select max(SALARY)
from t_employees;

-- 工资最小值
select min(SALARY)
from t_employees;

-- 当前有多少员工计数
select count(*)
from t_employees;

-- 当前有多少员工计数
-- count(1) 蜜汁比count(*) 快一点
select count(1)
from t_employees;

-- 统计有多少人有绩效
select count(COMMISSION_PCT)
from t_employees;
```

#### 