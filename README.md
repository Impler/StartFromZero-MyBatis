# StartFromZero-MyBatis

##Note (无格式)
###核心对象  
每个MyBatis的应用程序都需要用到SqlSessionFactory，最好整个应用共用一个factory实例。
SqlSessionFactoryBuilder基于XML配置文件或Configuration类创建SqlSessionFactory实例。对象用完后即可销毁，不需要长久存活。
SqlSessionFactory用来创建SqlSession实例，SqlSession实例包含了所有的数据库操作方法。SqlSession是非线程安全的，所以SqlSession实例不应该为类的静态成员或私有成员，最好每个方法都单独创建自己的SqlSession实例，用完后及时close

##XML配置