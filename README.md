# StartFromZero-MyBatis
##简介
MyBatis是一种常见的Java持久层框架。减少了大量JDBC操作中机械、原始的代码，包括手动设置参数，操作结果集等。MyBatis支持手写SQL文，相较于其他O-R Mapping的框架更加灵活。  
##Note (无格式)
###核心对象  
每个MyBatis的应用程序都需要用到SqlSessionFactory，最好整个应用共用一个factory实例。如果使用多个数据库，应该为每个数据库单独创建SqlSessionFactory。
SqlSessionFactoryBuilder基于XML配置文件或Configuration类创建SqlSessionFactory实例。对象用完后即可销毁，不需要长久存活。
SqlSessionFactory用来创建SqlSession实例，SqlSession实例包含了所有的数据库操作方法。SqlSession是非线程安全的，所以SqlSession实例不应该为类的静态成员或私有成员，最好每个方法都单独创建自己的SqlSession实例，用完后及时close

##XML配置

###1 properties
properties用于配置系统所需的键值对。MyBatis支持引用外部properties文件，同时支持properties元素配置，也支持在代码中传入Properties对象。常见配置如下:  
```xml
<properties resource="org/mybatis/example/config.properties"> <!-- ② 引入外部properties文件 -->
	<!-- ① 自定义属性 -->
	<property name="username" value="dev_user"/>
	<property name="password" value="F2Fa3!33TYyg"/>
</properties>
```
```java
/*③ Properties作为入参，创建SqlSessionFactory*/
SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, props);
// 或者
SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader, environment, props);
```
通过`${xxx}`引用属性值：  
```xml
<dataSource>
	<property name="driver" value="${driver}"/>
	<property name="url" value="${url}"/>
	<property name="username" value="${username}"/>
	<property name="password" value="${password}"/>
</dataSource>
```
MyBatis加载Properties规则：  
- properties标签内配置的property项
- properties标签resource或url属性引用的外部properties文件中
- 创建SqlSessionFactory时传入的Properties对象  
如果有重复配置项，后面的将会覆盖前面的配置。  

###2 settings
settings用于全局配置MyBatis的运行时行为，包括缓存、加载方式等。  

|配置项|值域及默认值|含义|
|:--|:--|:--|
|cacheEnabled|true/false true|全局控制mapper文件中配置的cache|
|lazyLoadingEnabled|true/false false|全局控制是否延迟加载依赖属性|
|aggressiveLazyLoading|true/false true||
|multipleResultSetsEnabled|true/false true|是否允许一条语句返回多个结果集|
|useColumnLabel|true/false true|使用列标签还是列名称|
|useGeneratedKeys|true/false false|主键自增长|
|autoMappingBehavior|NONE/PARTIAL/FULL(包括内嵌属性) PARTIAL(不包括内嵌属性)|如何自动映射列和属性|
|defaultExecutorType|SIMPLE/REUSE/BATCH SIMPLE|默认executor|
|defaultStatementTimeout|正整数 未设置|数据库响应等待时间(秒)|
|defaultFetchSize|正整数 未设置|结果集数据最大条数|
|safeRowBoundsEnabled|true/false false|是否在内嵌的statement中使用RowBounds|
|mapUnderscoreToCamelCase|true/false false|自动将下划线形式的列明A_COLUMN转换成驼峰式的java属性aColumn|
|localCacheScope|SESSION/STATEMENT SESSION||
|jdbcTypeForNull|java.sql.Types OTHER|为null值指定JDBC Type|
|lazyLoadTriggerMethods|方法名，逗号间隔 equals,clone,hashCode,toString|触发延迟加载的方法|
|defaultScriptingLanguage|类别名或类全限定类名 org.apache.ibatis.scripting.xmltags.XMLDynamicLanguage||
|callSettersOnNulls|true/false false||
|logPrefix|任意字符串 未设置||
|logImpl|||
|proxyFactory|||

```xml
<settings>
	<setting name="cacheEnabled" value="true"/>
	<setting name="jdbcTypeForNull" value="OTHER"/>
</settings>
```
###3 typeAliases
typeAliases可为java全限定类名定义别名，方便书写。全限定类名可出现的地方，均可用别名代替。  
typeAliases的子元素package可以指定包名，MyBatis将会扫描包下面的所有类。如果类标识了@Alias，它的值将作为该类的别名。否则以类名小写首字母的形式表示别名。
```xml
<typeAliases>
	<typeAlias alias="Author" type="domain.blog.Author"/>
</typeAliases>
或
<typeAliases>
	<package name="domain.blog"/>
</typeAliases>
```
此外，MyBatis内置了常见Java类型的别名。一般来说，基本数据类型的别名为其前加"_"，其他数据类型以及基本数据类型的包装类型的别名为类名的小写形式，如String->string，Integer->int,integer，HashMap->hashmap。  
###4 typeHandlers
当从结果集读取数据，或 设置PreparedStatement参数时，需要使用TypeHandler适配数据类型。

|Type Handler|Java Types|JDBC Types|
|:--|:--|:--|
|BooleanTypeHandler|java.lang.Boolean,boolean|Any compatible BOOLEAN|
|ByteTypeHandler|java.lang.Byte, byte|Any compatible NUMERIC or BYTE|
|ShortTypeHandler|java.lang.Short, short|Any compatible NUMERIC or SHORT INTEGER|
|IntegerTypeHandler|java.lang.Integer, int|Any compatible NUMERIC or INTEGER|
|LongTypeHandler|java.lang.Long, long|Any compatible NUMERIC or LONG INTEGER|
|FloatTypeHandler|java.lang.Float, float|Any compatible NUMERIC or FLOAT|
|DoubleTypeHandler|java.lang.Double, double|Any compatible NUMERIC or DOUBLE|
|BigDecimalTypeHandler|java.math.BigDecimal|Any compatible NUMERIC or DECIMAL|
|StringTypeHandler|java.lang.String|CHAR, VARCHAR|
|ClobTypeHandler|java.lang.String|CHAR, VARCHAR|
|NStringTypeHandler|java.lang.String|NVARCHAR, NCHAR|
|NClobTypeHandler|java.lang.String|NCLOB|
|ByteArrayTypeHandler|byte[]|Any compatible byte stream type|
|BlobTypeHandler|byte[]|BLOB, LONGVARBINARY|
|DateTypeHandler|java.util.Date|TIMESTAMP|
|DateOnlyTypeHandler|java.util.Date|DATE|
|TimeOnlyTypeHandler|java.util.Date|TIME|
|SqlTimestampTypeHandler|java.sql.Timestamp|TIMESTAMP|
|SqlDateTypeHandler|java.sql.Date|DATE|
|SqlTimeTypeHandler|java.sql.Time|TIME|
|ObjectTypeHandler|Any|OTHER, or unspecified|
|EnumTypeHandler|Enumeration Type|VARCHAR any string compatible type, as the code is stored (not index)|
|EnumOrdinalTypeHandler|Enumeration Type|Any compatible NUMERIC or DOUBLE, as the position is stored (not the code itself).|

MyBatis支持自定义TypeHandler，实现org.apache.ibatis.type.TypeHandler接口或继承
org.apache.ibatis.type.BaseTypeHandler。  
例如自定义String类型TypeHandler，来处理VARCHAR类型：  
```java
public class ExampleTypeHandler extends BaseTypeHandler<String>
```
MyBatis通过读取TypeHandler泛型信息来确定该handler处理的java类型。也可以显式的使用javaType属性指定java类型，或在处理类上标识@MappedTypes，两者同时指定时，以前者为准。同样的，jdbcType属性和  @MappedJdbcTypes指定jdbc数据类型。
```xml
<typeHandlers>
	<typeHandler handler="org.mybatis.example.ExampleTypeHandler" javaType="String" jdbcType="VARCHAR"/>
</typeHandlers>
```
由于MyBatis不会参考数据库metadata来自动确定数据类型。所以需要在从结果集取值或设置参数时，显式指定列的type handler。  
```xml
<resultMap type="user" id="user">
	<result column="message" property="message" typeHandler="org.mybatis.example.ExampleTypeHandler" />
</resultMap>
```
同typeAliases，typeHandlers也支持自动扫描，不过这种方式下，jdbcType必须通过@MappedJdbcTypes注解指定:  
```xml
<typeHandlers>
	<package name="org.mybatis.example"/>
</typeHandlers>
```
如果需要定义一个handler可以处理一类Class(基于继承或实现的类群)，需要在handler类中添加接收指定类Class对象的构造函数，MyBatis将会在创建该handler时，通过构造函数传递真实的class对象：  
```java
public class GenericTypeHandler<E extends MyObject> extends BaseTypeHandler<E> {
	private Class<E> type;
	public GenericTypeHandler(Class<E> type) {
		if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
		this.type = type;
	}
}
```
####处理枚举类型
MyBatis提供`EnumTypeHandler`和`EnumOrdinalTypeHandler`来处理枚举类型，默认`EnumTypeHandler`。 但其局限性也非常明显，`EnumTypeHandler`根据枚举name属性完成映射，`EnumOrdinalTypeHandler`根据ordinal属性完成映射（枚举类型的ordinal属性为枚举元素定义的顺序值，从0开始）。很多时候ordinal的值并不能与业务逻辑完全匹配，所以这里提供了自己的枚举处理类:`com.study.mybatis.typehandler.GenericEnumHandler`。

###5 objectFactory
MyBatis使用ObjectFactory创建对象。  
`ObjectFactory`接口包含3个主要方法：  
- void setProperties(Properties properties): 传递ObjectFactory子元素property定义的属性
- <T> T create(Class<T> type): 调用默认的构造方法，创建对象
- <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs): 调用带参的够赞方法，创建对象
默认情况下，`DefaultObjectFactory`调用无参构造方法，完成对象创建工作。如果需要调用有参数的构造方法，并传递参数值，可以继承`DefaultObjectFactory`，并自定义配置：  
```xml
<objectFactory type="org.mybatis.example.ExampleObjectFactory">
	<property name="someProperty" value="100"/>
</objectFactory>
```
###6 plugins
###7 environments
environment
transactionManager
dataSource
###8 databaseIdProvider
###9 mappers