package net_banking_api.banking_api.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("net_banking_api.banking_api.banking")

public class BankingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApiApplication.class, args);
	}

}



// 1. Load all bean definitions, creating an ordered graph. 

// 2. Instantiate and run BeanFactoryPostProcessors (you can update bean 
// definitions here). 

// 3. Instantiate each bean. 

// 4. Spring injects the values and bean references into the beans' properties.

// 5. Spring passes the ID of the bean to the setBeanName() method of the 
// BeanNameAware interface if any bean implements it. 
// 6. Spring passes the reference of the bean factory itself to the setBeanFactory() 
// method of BeanFactoryAware if any bean implements it. 
// 7. Spring passes the reference of the application context itself to the 
// setApplicationContext() method of ApplicationContextAware if any 
// bean implements it. 

// 8. BeanPostProcessor is an interface, and Spring allows you to implement it with 
// your bean, and modifies the instance of the bean before the initializer is invoked 
// in the Spring bean container by calling its 
// postProcessBeforeInitialization(). 

// 9. If your bean implements the InitializingBean interface, Spring calls its 
// afterPropertiesSet() method to initialize any process or loading resource 
// for your application. It's dependent on your specified initialization method. 
// There are other methods to achieve this step, for example, you can use the init- 
// method of the <bean> tag, the initMethod attribute of the @Bean annotation, 
// and JSR 250's @PostConstruct annotation. 
// 10. BeanPostProcessor is an interface, and spring allows you to implement it with 
// your bean. It modifies the instance of the bean after the initializer is invoked in 
// the spring bean container by calling its postProcessAfterInitialization(). 
// 11. Now your bean is ready to use in the step, and your application can access this 
// bean by using the getBean() method of the application context. Your beans 
// remain live in the application context until it is closed by calling the close() 
// method of the application context. 
// 12. If your bean implements the DisposibleBean interface, Spring calls its 
// destroy() method to destroy any process or clean up the resources of your 
// application. There are other methods to achieve this step-for example, you can 
// use the destroy-method of the <bean> tag, the destroyMethod attribute of the 
// @Bean annotation, and JSR 250's @PreDestroy annotation.
 