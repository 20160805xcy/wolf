# 特色简介

1. springboot项目.
    - 直接嵌入了内置tomcat,打包方式简单,配置端口位置在properties文件中.
    - 多环境配置:dev,test,pro.
    - 约定优于配置(启动方式,配置文件...)
2. 没有采用前后端分离(能力有限,前端技术局限于jsp).单体项目(练手).后期如果可以的话,改造成前后端分离.
3. 持久层(dao层)使用通用mapper来完成. generatorConfig.xml配置自动代码生成器.
4. pageHelper插件实现分页.封装查询对象qo类,两种方式实现table数据展示.
    - 简单的jquery插件实现.
    - 使用layer-ui前端框架实现.
5. 使用filter实现url拦截.如果用户没有登录(session不存在)则不能进行访问后端url访问.直接重定向到登录页面,提示用户进行登录.
6. 记录接口调用日志.
	- 使用切面注解@Aspect + @Pointcut + @Around...
7. springboot 用监听器统计在线人数
8. 全局异常拦截