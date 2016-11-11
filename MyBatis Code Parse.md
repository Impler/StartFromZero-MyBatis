# StartFromZero-MyBatis
# MyBatis 详解
## MyBatis配置详解
### 
SqlSessionFactoryBuilder用来构建SqlSessionFactory，核心方法：  
```java
  public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
  	XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
  	return build(parser.parse());
  }
    
  public SqlSessionFactory build(Configuration config) {
    return new DefaultSqlSessionFactory(config);
  }
```
XMLConfigBuilder 继承自BaseBuilder 构建Configuration对象，核心方法：  
```java
  private void parseConfiguration(XNode root) {
	// 读取settings配置，并判断settings的key是否是合法的
    Properties settings = settingsAsPropertiess(root.evalNode("settings"));
	// 读取Properties配置，并保存在Configuration的variables对象和XPathParser对象中
    propertiesElement(root.evalNode("properties"));
	// 注册到自定义的VFS实现到Configuration的vfsImpl对象中
	loadCustomVfs(settings);
	// 处理typeAlias，保存到Configuration的TypeAliasRegistry对象中
    typeAliasesElement(root.evalNode("typeAliases"));
	// 处理plugin（interceptor）保存到Configuration的interceptorChain对象中
    pluginElement(root.evalNode("plugins"));
	// 处理ObjectFactory，保存到Configuration的objectFactory对象中
    objectFactoryElement(root.evalNode("objectFactory"));
	// 处理reflectionFactory，保存到Configuration的reflectorFactory对象中
    objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
	// 配置settings，不存在的使用默认配置
    settingsElement(root.evalNode("settings"));
	// 处理environments，创建TransactionFactory和DataSource对象，保存在Configuration的environment对象中
    environmentsElement(root.evalNode("environments"));
	databaseIdProviderElement(root.evalNode("databaseIdProvider"));
    // 处理typeHandler，并保存到Configuration的typeHandlerRegistry对象中
	typeHandlerElement(root.evalNode("typeHandlers"));
	// 解析Mapper文件
    mapperElement(root.evalNode("mappers"));
  }
```

- 处理typeAlias:  


辅助类
ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();