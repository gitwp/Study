一、RMI
	RMI（Remote Method Invocation，远程方法调用）是用Java在JDK1.1中实现的，它大大增强了Java开发分布式应用的能力

	可以被看作是RPC的Java版本。但是传统RPC并不能很好地应用于分布式对象系统。
而Java RMI 则支持存储于不同地址空间的程序级对象之间彼此进行通信，实现远程对象之间的无缝远程调用

	RMI目前使用Java远程消息交换协议JRMP（Java Remote Messaging Protocol）进行通信。JRMP是专为Java的远程对象制定的协议

问题：
	RMI很难穿越防火墙，这是因为RMI使用任意端口来交互，这是防火墙通常所不允许的。
	RMI是基于JAVA的，这意味着客户端和服务端必须都是采用JAVA开发的，因为RMI使用了JAVA的序列化机制，所以通过网络传输的
对象类型必须保证在调用的两端是相同的版本。

二、Hessian和Burlap发布远程服务
	Hessian和Burlap是Caucho Technology提供的两种基于HTTP的轻量级远程服务解决方案，致力于用尽可能简单的API和通信协议来简化Web服务。
	Hessian使用二进制消息（省带宽）进行C-S交互，支持多种语言相互调用
	Burlap基于XML的远程调用技术，具有可移植性，更具可读性
	
问题：
	因为Hessian和Burlap都是基于HTTP的，它们都解决了RMI所头疼的防火墙渗透问题。但是当传递过来的RPC消息中包含序列化对象时，RMI就完胜
Hessian和Burlap了，因为Hessian和Burlap都采用了私有的序列化机制，而RMI使用的是JAVA本身的序列化机制。如果数据模型非常复杂，那么Hessian
和Burlap的序列化模型可能无法胜任。

三、Spring的HttpInvoker
	Spring的HttpInvoker是一个新的远程调用模型，作为Spring框架的一部分，来执行基于HTTP的远程调用，并使用JAVA的序列化机制
	
四、WEB服务
	SOA：面向服务的体系结构（service-oriented architecture，SOA）是一个组件模型，它将应用程序的不同功能单元（称为服务）
通过这些服务之间定义良好的接口和契约联系起来。
	SOA的核心理念是：应用程序可以并且应该被设计成依赖于一组公共的核心服务，而不是为每个应用都重新实现相同的功能