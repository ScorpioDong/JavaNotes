# Day 23

## 1. 网络概述

### 1.1 C/S 和 B/S

1. C/S：客户端 / 服务器软件结构
   - 服务提供商给予用户服务需要准备的内容
     1. 各大平台的客户端
        - Android iOS PC windows Linux macOS
     2. 服务器提供服务
   - 软件更新
     - 服务器更新后，本地客户端也要更新
2. B/S：浏览器 / 服务器软件结构
   - 服务提供商提供数据服务，以及前端数据展示方式
      	1. 浏览器提供商
          - chrome firefox opera safari edge
     	2. 服务器提供服务
   - 软件更新
     - 服务器更新数据，浏览器刷新

### 1.2 网络通信协议

```
协议：
	protocol 协议
	网络通信协议要求双方传递数据的计算机必须遵守的，按照网络传输协议，才可以进行数据的交互和传递
	
目前网络段传输协议
	UDP TCP/IP
```

### 1.3 UDP 和 TCP 的区别

- UDP

  1. 面向无连接，数据传递不算特别安全
  2. 传输速度快
  3. 数据传递存在丢包问题
  4. 没有客户端和服务器的区别，都可以作为发送端和接收端

  - 使用场景
    - 直播，网络游戏

- TCP/IP

  1. 面向连接
  2. 传输速度较慢
  3. 数据传递有保障
  4. 有服务器和客户端之间的关系

  - 使用场景
    - 客户端登录，数据下载，文件传输

### 1.4 网络编程的sanyaos

1. 协议
   - 通信需要对应的协议完成
2. IP地址
   - 当前计算机在网络中的地址编号，类似于手机号
   - IPv4协议：32位的二进制数，通常展示效果a.b.c.d
   - IPv6协议：128位长度，16字节一组
3. 端口号
   - short类型，0~65535，0~1024不能用于自定义使用

## 2. IP类

```
SUN公司提供给开发者使用的IP地址类
	InetAddress
Methods
	InetAddress getLocalHost();
		获取本地IP
	InetAddress getByName(String str);
		根据主机名获取对应IP
	InetAddress[] getAllByName(String str);
		获取指定主机名，域名对应的所有IP
```

## 3. UDP 协议

### 3.1 UDP

```
User Datagram Protocol
	数据传递采用数据包方式传递所有数据进行打包操作，并且没有对应服务器客户端概念，有且只有发送端和接收端
	
Socket
	DatagramSocket();
	DatagramSocket(int port);

打包方式
	DatagramPacket DatagramPacket(byte[] buf, int length, InetAddress address, int port);
	buf : 需要传递的数据的直接数组
	length : 当前直接数组中数据的字节数
	address : 接收端IP
	port : 接收端端口号
	
接收端接收方式
	DatagramPacket DatagramPocket(byte[] bug, int length);
	buf : 字节缓冲数组，容量为1024整数倍
    length : 当前字节缓冲区容量
```

### 3.2 发送端

1. 创建UDP的发送端Socket
2. 准备对应数据包
3. 发送数据send()
4. 关闭Socket

### 3.3 接收端

1. 打开UDP服务Socket并且监听指定端口
2. 创建新的空数据包
3. 通过Socket接收数据，receive
4. 关闭Socket

### 3.4 UDP数据传输丢失问题

1. 网络不够好，稳定性不行，带宽不够
2. 电脑性能不好

## 4. TCP

### 4.1 TCP概述

```
	TCP相对于UDP比较稳定的传输协议，这里是在三次握手，保证连接的情况下，同时有明确的客户端和服务器之分
	TCP服务中需要服务器端先启动，需要监听指定端口，等待客户端连接
	客户端主动连接服务器，和服务器连接后才可以进行数据交互，服务器上不能主动连接客户端
	
TCP操作
	1. 服务器Socket
	java.net.ServerSocket
	创建对应的ServerSocket开启服务器，等待客户端连接
	2. 客户端Socket
	java.net.Socket
	
```

### 4.2 Socket客户端

```
Constructor
	Socket(String host,int port);
	通过指定的IP和端口号获取TCP连接对象
	
Method
	InputStream getInputStream();
		获取Socket对象输入字节流，可以从服务器获取对应数据
		资源，需要在程序退出时关闭
		Read
	OutputStream getOutputStream();
		获取Socket对象输出字节流，可以发送数据到服务器
		资源，需要在程序退出时关闭
		Write
	void close();
		关闭Socket
	void shutdownOutput();
		禁止当前Socket发送数据
		
TCP/IP协议对应的Socket是基于IO流实现的
```

### 4.3 ServerSocket服务端

```
Constructor
	ServerSocket(int port);
		开启ServerSocket服务器，明确服务端口

Method
	Socket accept();
		监听并且连接，得到一个Socket对象
		阻塞方法，一直监听
```

