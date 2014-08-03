BookManage
==========

SpringMVC+Spring+MyBatis整合

src 结构：
com.hsq.dao:存放spring与mybatis连接接口
com.hsq.service:存放service接口
com.hsq.service.impl:service 接口的实现
com.hsq.model：存放一些javaBean
com.hsq.controller:存放控制层controller
com.hsq.mapper:mybatis的mapper文件包

config.properties：数据库配置文件
spring-mvc.xml：springmvc的配置文件
spring.xml:spring 的配置文件
spring-mybatis.xml：spring和mybatis整合的配置文件

记得在web.xml中添加以上三个spring-mvc.xml、spring.xml、spring-mybatis.xml配置文件

controller->service.imp->dao->mapper.xml





