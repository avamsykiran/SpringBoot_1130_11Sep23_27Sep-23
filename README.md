Session Objectives
---------------------------------------------------------
Spring Boot initialization, Dependency Injection
REST Web Service architecture , HTTP Endpoint handling
cross origin, Errors and Exception Handling,
Building custom response using Response Entity
Validating input request using javax.validation
Logging, Lombak
Eurekha Registry, Zuul Server, Feign Client ,Ribbon

Lab Setup
-------------------------------

    JDK 1.8
    STS latest
    MySQL Community Server

Spring Framework

    1. Light Weight
    2. Modular

        Dependency Injection        Spring Core, Spring Bean, Spring Context, Spring SpEL
        Aspect Oritneted Program    Spring AOP
        Web MVC, Rest API           Spring Web
        Reactive Programming        Spring Reactive
        Asychronous Program         Spring WebFlux
        Test                        Spring Test
        Jdbc                        Spring Data JDBC
        ORM - JPA                   Spring Data JPA
        Batch Pargramming           Spring Batch ...et.,

    3. Interaparability
    4. Dependency Injection via IoC

Dependency Injection

    Dependecy / Functional Dependency ?

        A software component can not compelkte its operation with out the operation
        of another component, that then first is said to depend on the second.

        Eg: a Service is dependent on a DAO.

    interface EmployeeDAO{

    }

    class EmployeeDAOJdbcImpl implements EmployeeDAO {
    
    }

    class EmployeeDAOJpaImpl implements EmployeeDAO {
    
    }
    
    interface EmployeeService{

    }

    /*class EmployeeServiceImpl implements EmployeeService {
        
        private EmployeeDAO employeeDAO;

        public EmployeeServiceImpl(){
            //this.employeeDAO = new EmployeeDAOJdbcImpl();
            this.employeeDAO = new EmployeeDAOJpaImpl();
        }
    }*/

    /*class EmployeeServiceImpl implements EmployeeService {
        
        private EmployeeDAO employeeDAO;

        public EmployeeServiceImpl(EmployeeDAO employeeDAO ){
            this.employeeDAO = employeeDAO;
        }
    }*/

    class EmployeeServiceImpl implements EmployeeService {
        
        private EmployeeDAO employeeDAO;

        public EmployeeServiceImpl(){

        }
        
        public void setEmployeeDAO(EmployeeDAO employeeDAO ){
            this.employeeDAO = employeeDAO;
        }
    }


IoC - Inversion of Control

    Container
    Component
    Bean

    a container is a resposnible to create and amange the life cycle of a bean.
    a bean is an object of a component.
    a component is any class in our application whos object must be created and manged by the container.

    Spring offers two containers:
        1. BeanFactory              Spring Bean
        2. ApplicationContext       Spring Context


Bean Configuration

    is all about informing the contaienr, the list of component classes and their dependencies.

    1. XML Based Configuaration
    2. Java Based Configuration
    3. Annotation Based Configuaration

    XML Based Configuration

    mybeans.xml
        <beans>

            <bean id="b1" class="com.cts.hrdemo.dao.EmployeeDAOJpaImpl" />

            <bean id="b2" class="com.cts.hrdemo.ervice.EmployeeServiceImpl" >
                <property name="employeeDao" ref="b1" />
            </bean>

            <bean id="today" class="java.time.LocalDate" factory-method="now" />

        </beans>


        ApplicationContext context = new XmlConfigurationApplicationContext("mybeans.xml");

        EmployeeServicve es = (EmployeeService) context.getBean("b2");


    Annotation and Java Based Configuaration

        @Component
            @Service
            @Repository
            @Controller
                .....etc.,

        @Repository
        class EmployeeDAOJpaImpl implements EmployeeDAO {
        
        }
        
        @Service
        class EmployeeServiceImpl implements EmployeeService {
            
            @Autowired            
            private EmployeeDAO employeeDAO;

        }

        @Configuration
        @ComponentScan("com.cts.hrdemo")
        class MyBeanConfig{

            @Bean
            public LocalDate today(){
                return LocalDate.now();
            }

        }

        ApplicationContext context = new AnnotationConfigurationApplicationContext(MyBeanConfig.class);

        EmployeeServicve es = (EmployeeService) context.getBean("employeeServiceImpl");

Autowiring

    byType              @Autowired

    byName              @Autowired
                        @Qualifier("beanId")


    byField             apply the @Autiwired / @Autowired and @Qualifier on the field
    byConstructor       apply the @Autiwired / @Autowired and @Qualifier on the constructor
    bySetter            apply the @Autiwired / @Autowired and @Qualifier on the setter

@Scope

    prototype
    singleton           default
    request
    session
    global-session

    @Scope annoation is use alongise the @Component or @Bean

Externalizing Configuaration Through .properties file

    application.properties

        key=value

    @PropertySource("classpath:application.properties")     alongside @Configuration

    @Value("${key:default value}")
    private primitiveTypeOrString field;

Spring Boot

    is a another spring framework module that offer auto-configuration to provide RAD ( Rapid Application Developmnet).

    it uses starter packages for each and every spring module, where a starter package is a combination of the module and
    ite defualt configs.

    these default config, allow the developer to right way start the application out of the box, and these configs
    are customizable if needed.

    @SpringBootApplication  =   @Configuration
                                @ComponentScan
                                @PropertySource


    the application.proeprties file is the deautl properties file for any spring boot project
    and the application main lcass itself is the configration class.
    the root-package in which the application main class resides, itself is the base-package for ComponentScan

    Spring Boot Application can be created using:
        1. STS
        2. Spring Initializer as on https://start.spring.io 
        3. Spring Boot CLI

    
    @SpringBootApplication
    public class SpringIocBootDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringIocBootDemoApplication.class, args);
        }

    }

    SpringApplication.run

            1. Create the ApplicationContext
            2. The applicationContext then will load all the beans
            3. the Spring Runners, if nay, are executed
            4. the emebeded server , if any, is started
            5. Once the server, if any started, shuts down, 
            6. the applicationContext is claosed and the application terminates

    Spring Runner is a class that implements CommandLineRunner or ApplicationRunner interfaces
        CommandLineRunner   public void run(String ...arg)
        ApplicationRunner   public void run(ApplicationArgument ...arg) 

    
Spring Data JPA integrating with Spring Boot

    CrudRepository
        |
        |- JpaRepository

                save(entity)
                deleteById(pk)
                existsById(pk)
                findById(pk)
                findAll()


    @Entity
    public class Customer {
        @Id
        @GeneratedValue(strategy=GeneratedValue.AUTO)
        private Long customerPNR;
        private String fullName;
        private String mobileNumber;
        private String mailId;
        private LocalDate registrationDate;

        //setter, getters and constructors
    }

    public interface CustomerRepo extends JpaRepository<Customer,Long>{

        boolean existsByMobileNumber(String mobileNumber);
        Optional<Customer> findByMobileNumber(String mobileNumber);
        List<Customer> findAllByFullName(String fullName);

        @Query("SELECT c FROM Customer WHERE c.registrationDate BETWEEN :start AND :end")
        List<Customer> extractCustoemrRegistedBetween(LocalDate start,LocalDate end);

    }








