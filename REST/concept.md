	
&#160; &#160; &#160; &#160;JAX-WS,WebService协议栈的复杂性很高，在实战中互操作性并不好（例如升级过程困难而且复杂），WebService仅仅将HTTP协议当做一种传输协议来使用，还依赖XML这种冗余度很高的文本格式，这导致WebService应用性能低下。

&#160; &#160; &#160; &#160;JAX-RS,Java世界开发RESTful Web Service的规范（Java EE 6）
	
# **一、JAX-RS2.0入门** #

# **1、概念** #

## **REST:一种跨平台、跨语言的架构风格** ##

&#160; &#160; &#160; &#160;对象被抽象为一种资源(resource)，资源的命名使用概念清晰的名词来定义；表述性状态是对资源数据在某个瞬间状态的快照，资源的某一个瞬间被定义为一种表述(representation)。

&#160; &#160; &#160; &#160;请求一个资源的过程可以理解为：访问一个具有指定行和描述性的URI，经由HTTP，将资源的表述从服务器转移到客户端，或者相反方向。

## REST式的WEB服务：REST在WEB领域的实现 ##

&#160; &#160; &#160; &#160;REST式的Web服务是一种ROA(Re##  ##source-Oriented Architecture,面向资源的架构)的应用，其主要特点是方法信息存在于HTTP的方法中（GET,PUT,POST,DELETE），作用域存在于URI中。


&#160; &#160; &#160; &#160;相比于Web服务领域广为流行的RPC（Remote Procedure Call，远程过程调用）风格，REST风格更轻量和快速。REST无须引入SOAP消息传输层，无须注册服务，也没有客户端stub的概念等，但是REST风格的Web服务并没有像Web Service那样提供诸如安全侧率等全面的标准规范。

## JAX-RS标准：JAVA领域、对REST式的WEB服务制定的实现标准 ##


&#160; &#160; &#160; &#160;基于POJO,以HTTP为中心，格式独立，容器独立性，内置于Java EE     
## Jersey:JAX-RS标准的参考实现 ##

## **2、特点** ##

&#160; &#160; &#160; &#160;客户端-服务器的，无状态的，可缓存的，统一接口，分层系统，按需编码

## 3、REST实现思想 ##
&#160; &#160; &#160; &#160;实现一个REST应用需要考虑2点：

1、第一点是如何定义一个资源（以什么方式发布一个请求，它的输入输出是什么）

2、如何部署一个Java RESTful Web Service应用，以匹配既有的REST服务类型

## 4、REST服务类型 ##
&#160; &#160; &#160; &#160;在REST服务中，资源类是接收REST请求并完成响应的核心类，而资源类是由REST服务的提供者来调度的。

&#160; &#160; &#160; &#160;REST中的提供者：JAX-RS2.0中定义的Application和Servlet

类型一：即不存在Application子类也不存在Servlet的子类

类型二：不存在Application子类存在Servlet的子类

类型三：定义了Application子类并且这个Application子类使用了@ApplicationPath注解

类型四：定义了Application子类但是这个Application子类未使用了@ApplicationPath注解

## 5、REST API设计 ##

1、安全性、幂等性

&#160; &#160; &#160; &#160;每一种HTTP请求方法都可以从安全性和幂等性两方面考虑。安全性(safety)代表安全的REST接口，是指外系统对接口的访问，不会使服务器端资源的状态发生改变；幂等性(idempotence)是指外系统对同一REST接口的多次访问，得到的资源状态是相同的。

## 6、REST-扩展点：过滤器、拦截器 ##

1、Providers

&#160; &#160; &#160; &#160;javax.ws.rs.ext.Providers是JAX-RS2.0定义的一种辅助接口，实现类用于辅助REST框架完成过滤和读写拦截等功能。使用注解@Provider来标注这些实现类，可以被JAX-RS2.0的运行时自动探测、加载。

&#160; &#160; &#160; &#160;Provider实例可以通过@Context注解被依赖注入到其他实例中，Providers接口定义了4个方法，分别用来获取【MessageBodyReader、MessageBodyWriter】用户处理不同输入输出的表述、ExceptionMapper、【ContextResolver】用于提供资源类和其他Provider上下文信息的接口。

2、REST请求流程

1）、客户端：用户提交请求数据，客户端接收请求，进入第一个扩展点：ClientRequestFilter（客户端请求过滤器）的实现类的filter()方法。

2）、客户端：请求过滤处理完毕后，流程进入第二个扩展点：WriterInterceptor(客户端写拦截器)实现类的aroundWriteTo()方法实现对客户端序列化操作的拦截。

3）、客户端：MessageBodyWriter执行序列化，流程从客户端过度到服务端

4）、服务端：服务器接收请求，流程进入第三个扩展点：Pre-matching ContainerRequestFilter(服务器前置请求过滤器)实现类的filter()方法

5）、服务端：服务器根据请求匹配资源方法，如果匹配到相应的资源方法，流程进入第四个扩展点：ContainerRequestFilter(服务器后置请求过滤器)实现类的filter()方法。

6）、服务器：第五个扩展点：ReaderInterceptor(服务器读拦截器)实现类的aroundReadFrom()方法，拦截服务器端反序列化操作。

7）、服务器：MessageBodyReader（服务器消息体读处理器）完成对客户端数据流的反序列化，服务器执行匹配资源方法。

8）、服务器：执行资源方法后，进入第六个扩展点：ContainerResponseFilter实现类的fiter()方法。

9）、服务器：第7个扩展点：WriterInterceptor（服务器写拦截器）实现类的aroundWriteTo()方法，实现服务器端序列化到客户端这个操作的拦截。

10）、服务器：MessageBodyWriter(服务器消息体写处理器)执行序列化，流程返回到客户端

11）、客户端：第八个扩展点：(ClientResponseFilter)客户端响应过滤器实现类的filter()方法。

12）、客户端：响应实例response返回到用户一侧，用户执行response.readEntity()，流程进入第九个扩展点：ReaderInterceptor(客户端读拦截器)实现类的aroundReadFrom()方法，对客户端反序列化进行拦截。

13）、客户端：MessageBodyReader（客户端消息体读处理器）执行反序列化，将java类型的对象最终作为readEntity()方法的返回值。

在这个期间，如果出现异常或资源不匹配等情况，则会从出错点结束流程。

3、过滤器与拦截器

相同之处在于都是一种在请求---响应模型中用作切面处理的Provider

不同之处在于功能上的差异（一个是用于过滤消息，另一个是用于拦截处理），形式上也不同

拦截器是基于java的反射机制的，而过滤器是基于函数回调 

过滤器依赖与servlet容器，而拦截器不依赖与servlet容器 

拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用 

拦截器可以访问action上下文、值栈里的对象，而过滤器不能 

在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次 

## 7、REST-安全 ##

REST的特点是无状态的，因此基本的安全手段就是应用系统实现AAA的过程。认证（Authentication）,授权（Authorization）,计费（Accounting）

1、身份认证

HTTP Basic(基本认证)、HTTP Digest(摘要认证)、表单认证、证书认证

认证过程中使用了诸多安全技术，比如加密算法、摘要算法、公钥/私钥对、证书生成-导入-导出-吊销等。授权的实现可以由容器级别的配置完成，或者通过程序级别的注解和编码完成。
