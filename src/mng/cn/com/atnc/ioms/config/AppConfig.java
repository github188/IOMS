package cn.com.atnc.ioms.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.util.file.ProjectFilePath;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 系统配置�?
 * 
 * @author:huangyijie
 * @date:2010-11-2 下午01:34:10
 * @version:1.0
 */
@Configuration
public class AppConfig extends AbstractService {

	/**
	 * 系统项目的路�?
	 */
	@Value("#{systemProperties['ioms.name']}")
	private String webappPath;

	@Bean(name = "projectFilePath")
	public ProjectFilePath projectFilePath() {
		ProjectFilePath projectFilePath = new ProjectFilePath(webappPath);
		return projectFilePath;
	}

	@Value("#{jdbcProperties.driverClassName}")
	private String driverClassName;
	@Value("#{jdbcProperties.url}")
	private String jdbcUrl;
	@Value("#{jdbcProperties.username}")
	private String username;
	@Value("#{jdbcProperties.password}")
	private String password;
	@Value("#{jdbcProperties.maxPoolSize}")
	private String maxPoolSize;

	// 配置datasource，定义数据库连接�?
	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() throws PropertyVetoException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		// 配置初始化大小、最小、最大
		dataSource.setInitialSize(10);
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(60);
		// 配置获取连接等待超时的时间
		dataSource.setMaxWait(10000);
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(300000);
		dataSource.setTestWhileIdle(true);
		// 这里建议配置为TRUE，防止取到的连接不可用
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(false);
		// 打开PSCache，并且指定每个连接上PSCache的大小
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		// 这里配置提交方式，默认就是TRUE，可以不用配置
		dataSource.setDefaultAutoCommit(true);
		/*ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClassName);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setMaxStatements(0);
		dataSource.setMinPoolSize(2);// 连接池中保留的最小连接数。默认为15
		dataSource.setMaxPoolSize(Integer.parseInt(maxPoolSize));// 连接池中保留的最大连接数。默认为15
		dataSource.setInitialPoolSize(2);// 初始化时创建的连接数，应在minPoolSize与maxPoolSize之间取值。默认为3；
		dataSource.setMaxIdleTime(600);// 最大空闲时间，超过空闲时间的连接将被丢弃。为0或负数则永不丢弃。默认为0；

		dataSource.setTestConnectionOnCheckout(false);// 因性能消耗大请只在需要的时候使用它。如果设为true那么在每个connection提交的时候都
														// 将校验其有效性。建议使用idleConnectionTestPeriod或automaticTestTable
		dataSource.setTestConnectionOnCheckin(true);
		dataSource.setAutomaticTestTable("C3P0TESTTABLE");
		dataSource.setIdleConnectionTestPeriod(120);// 隔多少秒检查所有连接池中的空闲连接，默认为0表示不检查；
		dataSource.setCheckoutTimeout(3000);
		dataSource.setBreakAfterAcquireFailure(true);// 获取连接失败将会引起所有等待获取连接的线程抛出异常。但是数据源仍有效保留，并在下次调
														// 用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认为
														// false；
		dataSource.setAcquireIncrement(3);// 当连接池中的连接用完时，C3P0一次性创建新连接的数目；
		dataSource.setAcquireRetryAttempts(30);// 定义在从数据库获取新连接失败后重复尝试获取的次数，默认为30；
		dataSource.setAcquireRetryDelay(1000);// 两次连接中间隔时间，单位毫秒，默认为1000；
		dataSource.setAutoCommitOnClose(true);// 连接关闭时默认将所有未提交的操作回滚。默认为false；
		dataSource.setIdleConnectionTestPeriod(2000);*/
		return dataSource;
	}

	@Value("#{jdbcProperties.dialect}")
	private String hibernateDialect;
	@Value("#{jdbcProperties.enableCache}")
	private boolean enableCache;

	// @Value("#{jdbcProperties.cacheServers}")
	// private String cacheServers;

	// 配置hibernate的session Factory
	@Bean(name = "sessionFactory")
	public AnnotationSessionFactoryBean sessionFactory() throws Exception {
		AnnotationSessionFactoryBean factory = new AnnotationSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[] { "cn.com.atnc.ioms.entity" });
		// hibernate properties
		Properties props = new Properties();
		/*props.setProperty("hibernate.connection.provider_class",
				"org.hibernate.connection.C3P0ConnectionProvider");*/
		props.setProperty("hibernate.connection.provider_class",
				"com.alibaba.druid.support.hibernate.DruidConnectionProvider");
		props.setProperty("hibernate.dialect", hibernateDialect);
		props.setProperty("hibernate.query.factory_class",
				"org.hibernate.hql.ast.ASTQueryTranslatorFactory");
		props.setProperty("hibernate.show_sql", "false");
		if (logger.isDebugEnabled()) {
			props.setProperty("hibernate.show_sql", "true");
			//props.setProperty("hibernate.hbm2ddl.auto", "validate");
		}
		// memcached二级缓存配置
		if (enableCache) {
			props.setProperty("hibernate.cache.use_query_cache", "true");
			props.setProperty("hibernate.cache.provider_class",
					"com.googlecode.hibernate.memcached.MemcachedCacheProvider");
			// props.setProperty("hibernate.memcached.servers", cacheServers);
		}
		props.setProperty("hibernate.use_outer_join", "true");
		factory.setHibernateProperties(props);
		if (factory.getObject() == null)
			factory.afterPropertiesSet();
		return factory;
	}

	// 配置回滚TransactionManager
	@Bean(name = "txManager")
	public HibernateTransactionManager transactionManager() throws Exception {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}
}
