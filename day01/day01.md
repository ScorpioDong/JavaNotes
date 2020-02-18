# Day 01 

> ScorpioDong

## `Java`历史

- `SUN`公司开发创始，`Oracle`收购
- `Java`之父：詹姆斯·高斯林(`James Gosling`)

## `Java` 特征

- 面向对象
- 简单
- 跨平台
  - 平台
    - `windows`
    - `linux`
    - `unix`
  - `JVM(Java虚拟机)`
    - 因为存在`JVM`，`Java`才能在不同平台运行。
    - `.Java ==> .class ==> 二进制文件`
    - `Write Once Run Anywhere`

## 编译执行和解释执行

- 编译执行
  - C、C++
  - 编译结果直接交给CPU运作执行，效率较高
  - 不能跨平台
- 解释执行
  - `Java`、`C#`
  - 编译结果需要通过解释器解释后交给CPU执行，效率低一点点
  - `Java`借助`JIT`技术，效率现在已经可以接近`C++`了

- 名词解释
  - `JVM(Java Virtual Machine)`
  - `JRE(Java Runtime Environment)`
  - `JDK(Java Development Kit)`

## 安装 `JDK`

- 从官网获取对应的安装包
- 尽量不要安装到C盘
- 安装路径不能存在中文
- `JDK`内容
  - `bin`: 二进制可执行文件
    - `java`
    - `javac`
    - `javap`
    - `Javadoc`
  - `db`:`Java`自带的小型数据库
  - `include`:系统接口目录
  - `jre`:`Java`运行环境
  - `lib`:资源库目录，存在一些`jar`包
    - `src.zip`:源文件代码，`Java`的完整源代码，作为参考标准，学习的参照物

## 环境变量配置

- `JAVA_HOME`
- `CLASS_PATH`
- `PATH`

## DOS命令

- `tree` 遍历目录下的所有文件
- `dir` 查看当前工作目录的所有文件和文件夹
- `cd`  切换工作目录
- 路径
  - 绝对路径
  - 相对路径
  - `.` 当前目录
  - `..` 上级目录
- `mkdir` 创建目录
- `rd`  删除文件夹
  - 粉碎性删除
  - 慎用
- `echo`
- `del`
  - 删除文件
  - 必须带文件后缀名
  - 慎用
- 方向键上下：调出历史命令
- `*` 通配符
- `cls` 清屏

- `exit`  退出终端

