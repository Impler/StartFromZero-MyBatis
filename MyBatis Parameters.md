# StartFromZero-MyBatis
## MyBatis 数据库操作中的参数传递
MyBatis 支持在CRUD的SQL语句中动态传入参数，从而构建PreparedStatement对象。其支持传入的参数类型包括基本类型、自定义类型、List以及Map等。不同的参数类型以及参数个数可能对应的Mapper配置略有不同，在此进行分类总结。  
调用Mybatis 执行CRUD操作主要有两种方式，一是通过SqlSession API方法，如selectOne、selectList等，另外一种是通过SqlSession.getMapper()调用接口方法。下文中所说的接口方法对应Mapper的调用方式，SqlSession API对应调用SqlSession selectOne、selectList等的方式。
### 基本数据类型
#### 单个基本数据类型参数
接口：
```java
	User selectById(int id);
```
调用:
```java
	int i = 1;
	User u = userDao.selectById(i);
```
Mapper:
```xml
	<select id="selectById" resultMap="user">
		select * from t_useraccount where id = #{参数名随意写}
	</select>
```
这种情况下，Mapper中对应的参数名可以随意写，Mybatis并不关心方法参数名或实参参数名是什么。
#### 多个基本数据类型参数
接口：
```java
	List<User> selectByStatusAndRole(int status, int role);
```
调用:
```java
	int status = 1;
	int role = 1;
	List<User> us = userDao.selectByStatusAndRole(status, role);
```
Mapper:
```xml
	<!-- 错误的写法 -->
	<!-- 
		将会抛出异常 org.apache.ibatis.binding.BindingException：Parameter 'role' not found. Available parameters are [1, 0, param1, param2]
	-->
	<select id="selectByStatusAndRole" resultMap="user">
		select * from t_useraccount where role = #{role} && active = #{status};
	</select>
	<!-- 正确的写法-->
	<!-- 从上面的异常信息可以看出，这种情况下，只能通过下标0，1...或param1，param2...对应接口方法中的参数 -->
	<select id="selectByStatusAndRole" resultMap="user">
		select * from t_useraccount where role = #{1} && active = #{0};
	</select>
	<!-- 或 -->
	<select id="selectByStatusAndRole" resultMap="user">
		select * from t_useraccount where role = #{param2} && active = #{param1};
	</select>
```
这种情况下，只能在Mapper配置中通过下标对应参数。这种方式存在诸多弊端，比如一旦接口方法参数位置发生变化，Mapper配置也要跟着变动。  MyBatis 提供了另外一种方案，即使用@Param注解，在多参数的情况下，为每个参数设定独立的别名，以便在Mapper中引用。  
接口：
```java
	List<User> selectByStatusAndRole1(@Param("_role")int role, @Param("_status")int status);
```
Mapper:
```xml
	<select id="selectByStatusAndRole1" resultMap="user">
		select * from t_useraccount where role = #{_role} && active = #{_status};
	</select>
```
注意SqlSession API接口方法中，仅能传递一个Object 类型参数，不支持传递多个参数，如果Dao接口方法中存在多个参数，需要将多个参数封装成对象或Map，下面介绍。
### 自定义类型
### List
### Map类型
### 总结