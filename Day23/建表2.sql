-- 1.创建student和score表
CREATE  TABLE  student ( 
id  INT(10)  NOT NULL  PRIMARY KEY  ,  #学生ID 自增
name  VARCHAR(20)  NOT NULL ,  #学生姓名
sex  VARCHAR(4)  , #学生性别
birth  YEAR,  #学生出生年份
department  VARCHAR(20) ,  #所在院系
address  VARCHAR(50) 	#家庭住址
); 

-- 创建score表。SQL代码如下： 
CREATE  TABLE  score ( 
id  INT(10)  NOT NULL  PRIMARY KEY  AUTO_INCREMENT , #自增ID
stu_id  INT(10)  NOT NULL , #学生ID ，外键创建可有可无
c_name  VARCHAR(20) , 	#学科名称
grade  INT(10) 	#分数
);

-- 2.添加记录

-- 向student表插入记录的INSERT语句如下： 
INSERT INTO student VALUES( 901,'张老大', '男',1985,'计算机系', '北京市海淀区'); 
INSERT INTO student VALUES( 902,'张老二', '男',1986,'中文系', '北京市昌平区'); 
INSERT INTO student VALUES( 903,'张三', '女',1990,'中文系', '湖南省永州市'); 
INSERT INTO student VALUES( 904,'李四', '男',1990,'英语系', '辽宁省阜新市'); 
INSERT INTO student VALUES( 905,'王五', '女',1991,'英语系', '福建省厦门市'); 
INSERT INTO student VALUES( 906,'王六', '男',1988,'计算机系', '湖南省衡阳市'); 
-- 向score表插入记录的INSERT语句如下： 
INSERT INTO score VALUES(NULL,901, '计算机',98); 
INSERT INTO score VALUES(NULL,901, '英语', 80); 
INSERT INTO score VALUES(NULL,902, '计算机',65); 
INSERT INTO score VALUES(NULL,902, '中文',88); 
INSERT INTO score VALUES(NULL,903, '中文',95); 
INSERT INTO score VALUES(NULL,904, '计算机',70); 
INSERT INTO score VALUES(NULL,904, '英语',92); 
INSERT INTO score VALUES(NULL,905, '英语',94); 
INSERT INTO score VALUES(NULL,906, '计算机',90); 
INSERT INTO score VALUES(NULL,906, '英语',85);

-- 3.查询student表的所有记录
SELECT * FROM student;
-- 4.查询student表的第2条到4条记录
SELECT * FROM student LIMIT 1,3;
-- 5.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息
SELECT id,name,department FROM student;
-- 6.从student表中查询计算机系和英语系的学生的信息
SELECT * FROM student WHERE department='计算机系' OR department='英语系';
-- 7.从student表中查询年龄1985~1990年份的学生信息
SELECT * FROM student WHERE birth BETWEEN 1985 AND 1990;
-- 8.从student表中查询每个院系有多少人
SELECT *,COUNT(department) '院系人数' FROM student GROUP BY department;
-- 9.从score表中查询每个科目的最高分
SELECT c_name,MAX(grade) FROM score WHERE grade GROUP BY c_name;
-- 10.查询李四的考试科目（c_name）和考试成绩（grade）
SELECT st.*,sc.c_name,sc.grade FROM student st,score sc WHERE st.id = sc.stu_id AND name='李四';
-- 11.用连接的方式查询所有学生的信息和考试信息
SELECT st.*,sc.c_name,sc.grade FROM student st LEFT JOIN score sc ON st.id = sc.stu_id;
-- 12.计算每个学生的总成绩
SELECT st.*,SUM(grade) '总成绩' FROM student st,score sc WHERE st.id = sc.stu_id GROUP BY st.name;
-- 13.计算每个考试科目的平均成绩
SELECT c_name,AVG(grade) FROM score GROUP BY c_name;
-- 14.查询计算机成绩低于95的学生信息
SELECT * FROM student st,score sc WHERE st.id = sc.stu_id AND c_name='计算机' AND sc.grade<95;
-- 15.将计算机考试成绩按从高到低进行排序
SELECT * FROM student st,score sc WHERE st.id = sc.stu_id AND c_name='计算机' ORDER BY grade DESC;
-- 16.查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
SELECT name,department,c_name,grade FROM student st,score sc WHERE st.id = sc.stu_id And( name LIKE '张%' OR name LIKE'王%'); 
-- 17.查询都是北京的学生的姓名、年龄、院系和考试科目及成绩
SELECT name,birth,department,c_name,grade FROM student st,score sc WHERE st.id = sc.stu_id AND address LIKE '北京%';
