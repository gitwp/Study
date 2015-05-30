一、Web Service调用本质
	1、客户端把需要调用的参数，转换为XML文档片段（SOAP消息，input）
	2、客户端通过网络把XML文档片段传给远程服务器
	3、服务器接受XML文档片段
	4、服务器解析XML文档片段，提取其中的数据，并把数据转换为调用所需的参数
	5、服务器执行方法
	6、服务器将方法返回值，转换为XML文档片段（SOAP消息，output）
	7、服务器通过网路把XML文档片段传给远程客户端
	8、客户端接收XML文档片段
	9、客户端解析XML文档片段，提取其中的数据，并把数据转换为调用返回值
	
二、Web Service的三个技术基础
	1、WSDL(Web Services Description Language)
		Web Service接口
			①、types(标准的schema)
			②、message 共计2N个,包含(input output)
			③、portType N个operation(服务端暴露的接口)
		Web Service实现
			①、bingding N个更详细的operation
			②、service  指定Web Service服务器地址
	2、SOAP(Simple Object Access Protocol)
		Header是可选的。由程序员控制添加
		Body元素是默认的
			①、当交互正确时，Body元素的内容将有WSDL控制
			②、当交互失败时，由Fault元素控制
			

三、Web Service拦截器
