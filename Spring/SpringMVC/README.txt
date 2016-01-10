SpringMVC
1、概述
采用了松散耦合可插拔组件结构，比其他MVC框架更具扩展性和灵活性

2、基于方法的请求映射
	@RequestMapping能够映射http请求路径(value,支持ant风格的资源地址)，请求方法(method)，请求参数(params)，请求头(headers)

3、请求参数绑定
	①、@RequestParam注解获取请求参数
	②、@RequestHeader注解可以获取请求头信息
	③、@CookieValue注解获取cookie信息
	④、@PathVarialble可以映射URL绑定的占位符,这是一种REST风格
	⑤、POJO映射请求参数：POJO属性名与请求参数名匹配，支持级联
	⑥、原生ServletAPI类型的参数，HttpServletRequest,HttpServletResponse,HttpSession,java.security.Principal,Locale,InputStream,OutputStream,Reader,Writer
	
4、SpringMVC-REST风格GET、POST、PUT、DELETE请求处理方式
	浏览器form表单只支持GET与POST请求，而DELETE、PUT等method并不支持，Spring3.0添加了一个过滤器（HiddenHttpMethodFilter），
可以将这些请求转换为标准的http方法，使得支持GET、POST、PUT、DELETE请求。
	①、配置HiddenHttpMethodFilter
	②、发送POST请求
	③、请求携带一个name="_method"的隐藏域，值为DELETE或PUT
	
5、输出模型数据
	①、ModelAndView：目标方法返回ModelAndView类型的对象
	②、Map、Model、ModelMap：目标方法传入Map、Model、ModelMap类型的对象
	以上两种方法将model的数据其实最终放到了request对象里面
	③、@SessionAttributes：使用于类上的注解，将输出模型数据中对应的属性名或对应的类型数据放到Session域中
	④、@ModelAttribute：这个注解标记的方法，会在每个目标方法执行前被SpringMVC调用；这个方法中放入到Map中的键要和目标方法
						入参类型的第一个字母小写的字符串一致
						
6、mvn:annotation-driven
	①、自动注册RequestMappingHandlerMapping/RequestMappingHandlerAdapter/ExceptionHandlerExceptionResolver三个bean
	②、支持使用ConversionService实例对表单参数进行类型装换、支持使用@NumberFormat/@DateTimeFormat注解完成数据类型格式化
		支持使用@Valid注解对JavaBean实例进行JSR303验证、支持使用@RequestBody和@ResponseBody注解