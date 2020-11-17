
#
# Structure for table "dept"
#

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) DEFAULT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "dept"
#

INSERT INTO `dept` VALUES (10,'教研部','北京'),(20,'学工部','上海'),(30,'销售部','广州'),(40,'财务部','深圳');

#
# Structure for table "emp"
#

DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) DEFAULT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "emp"
#

INSERT INTO `emp` VALUES (1001,'甘宁','文员',1013,'2000-12-17',8000.00,NULL,20),(1002,'黛绮丝','销售员',1006,'2001-02-20',16000.00,3000.00,30),(1003,'殷天正','销售员',1006,'2001-02-22',12500.00,5000.00,30),(1004,'刘备','经理',1009,'2001-04-02',29750.00,NULL,20),(1005,'谢逊','销售员',1006,'2001-09-28',12500.00,14000.00,30),(1006,'关羽','经理',1009,'2001-05-01',28500.00,NULL,30),(1007,'张飞','经理',1009,'2001-09-01',24500.00,NULL,10),(1008,'诸葛亮','分析师',1004,'2007-04-19',30000.00,NULL,20),(1009,'曾阿牛','董事长',NULL,'2001-11-17',50000.00,NULL,10),(1010,'韦一笑','销售员',1006,'2011-09-08',15000.00,0.00,30),(1011,'周泰','文员',1008,'2007-05-23',11000.00,NULL,20),(1012,'程普','文员',1006,'2001-12-03',9500.00,NULL,30),(1013,'庞统','分析师',1004,'2001-12-03',30000.00,NULL,20),(1014,'黄盖','文员',1007,'2002-01-23',13000.00,NULL,10),(1015,'张三','保洁员',1001,'2013-05-01',80000.00,50000.00,50);

#
# Structure for table "profit"
#

DROP TABLE IF EXISTS `profit`;
CREATE TABLE `profit` (
  `year` year(4) DEFAULT NULL,
  `zz` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "profit"
#

INSERT INTO `profit` VALUES (2010,100),(2011,150),(2012,250),(2013,800),(2014,1000);

#
# Structure for table "salgrade"
#

DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `GRADE` int(11) NOT NULL DEFAULT '0' COMMENT '工资的等级',
  `LOwSAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最低工资',
  `HISAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最高工资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资等级表';

#
# Data for table "salgrade"
#

INSERT INTO `salgrade` VALUES (1,7000.00,12000.00),(2,12010.00,14000.00),(3,14010.00,20000.00),(4,20010.00,30000.00),(5,30010.00,99990.00);

#
# Structure for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_id` int(10) NOT NULL,
  `c_name` varchar(20) DEFAULT NULL,
  `greade` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "score"
#

INSERT INTO `score` VALUES (1,901,'计算机',98),(2,901,'英语',80),(3,902,'计算机',65),(4,902,'中文',88),(5,903,'中文',95),(6,904,'计算机',70),(7,904,'英语',92),(8,905,'英语',94),(9,906,'计算机',90),(10,906,'英语',85);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birth` year(4) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (901,'张老大','男',1985,'计算机系','北京市海淀区'),(902,'张老二','男',1986,'中文系','北京市昌平区'),(903,'张三','女',1990,'中文系','湖南省永州市'),(904,'李四','男',1990,'英语系','辽宁省阜新市'),(905,'王五','女',1991,'英语系','福建省厦门市'),(906,'王六','男',1988,'计算机系','湖南省衡阳市');

-- 1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
SELECT d.*,COUNT(dname) '部门人数' FROM emp e,dept d WHERE d.deptno=e.deptno GROUP BY dname; 
-- 2. 列出所有员工的姓名及其直接上级的姓名。
SELECT e1.ename '员工姓名',e2.ename '上级姓名' FROM emp e1 INNER JOIN emp e2 ON e1.mgr=e2.empno;
-- 3. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
SELECT e1.empno,e1.ename,e1.hiredate,e2.ename,e2.hiredate,d.dname FROM dept d,emp e1 INNER JOIN emp e2 ON e1.mgr=e2.empno WHERE e1.deptno=d.deptno AND e1.hiredate<e2.hiredate;
-- 4. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
SELECT * FROM dept LEFT JOIN emp ON dept.deptno=emp.deptno ORDER BY dept.deptno;
-- 5. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。
SELECT job,COUNT(job) '人数' FROM emp WHERE (sal+IFNULL(comm,0)>15000) GROUP BY job;
-- 6. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
SELECT * FROM emp,dept WHERE emp.deptno=dept.deptno AND dname ='销售部';
-- 7. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
SELECT
	(SELECT AVG(sal) FROM emp) '公司平均薪金',
	e1.*, d.dname,
	e2.ename,
	s.GRADE
FROM
  dept d,
	salgrade s,
	emp e1
LEFT JOIN emp e2 ON e1.mgr = e2.empno
WHERE
  e1.deptno = d.deptno AND
	(e1.sal) > (SELECT AVG(sal) FROM emp) AND
	((e1.sal) BETWEEN s.LOwSAL AND s.HISAL);
	
-- 8.列出与庞统从事相同工作的所有员工及部门名称。
SELECT e2.ename,d.dname FROM emp e1 INNER JOIN emp e2 ON e1.job = e2.job LEFT JOIN dept d ON e1.deptno = d.deptno WHERE e1.ename='庞统'; 
-- 9.列出薪金高于在部门30工作的所有员工的薪金　的员工姓名和薪金、部门名称。
SELECT * FROM emp e1,dept d WHERE e1.deptno = d.deptno AND e1.sal>(SELECT AVG(sal) FROM emp WHERE deptno=30);
-- 10.查出年份、利润、年度增长比。 
SELECT p1.*, IFNULL( CONCAT( (p1.zz - p2.zz) / p2.zz * 100,'%'),'0%') FROM profit p1 LEFT OUTER JOIN profit p2 ON p1. YEAR = p2. YEAR + 1;






