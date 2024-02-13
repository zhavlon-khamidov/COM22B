package kg.alatoo.beanlifecycledemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component("myCustomBean")
public class MyBean implements BeanNameAware,
        BeanFactoryAware, ApplicationContextAware,
        BeanPostProcessor, InitializingBean, DisposableBean {

    @Value("#{beanLifecycleDemoApplication.text}")
    private String textFromBean = "hello";

    @Value("${my.text}")
    private String myText = "jalsjdf";

    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("setBeanName of BeanNameAware called with name: " + name);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        String className = beanFactory.getClass().getName();
        System.out.println("setBeanFactory of BeanFactoryAware called with classname: " + className);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String className = applicationContext.getClass().getName();
        System.out.println("setApplicationContext of ApplicationContextAware called with classname: " + className);
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Preinitialization of BeanPostProcessor with beanName: " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet of InitializingBean called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Custom init method called");
        System.out.println("myText = " + myText);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Postinitialization of BeanPostProcessor with beanName: " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @PreDestroy
    public void customDestroyMethod() {
        System.out.println("Custom Bean destroy method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method of DisposableBean called");
    }
}
