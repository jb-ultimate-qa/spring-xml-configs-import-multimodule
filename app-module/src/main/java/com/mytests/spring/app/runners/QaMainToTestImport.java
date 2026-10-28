package com.mytests.spring.app.runners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

// IDEA-384253 QA: a main configuration imports a resource that exists only in src/test/resources.
public class QaMainToTestImport {
    public static void main(String[] args) {
        System.out.println("--- qa-test/test-imported.xml on the classpath: "
                           + QaMainToTestImport.class.getClassLoader().getResource("qa-test/test-imported.xml"));
        ApplicationContext ctx = new ClassPathXmlApplicationContext("qa-test-neg/test_04_main_to_test.xml");
        System.out.println("--- beans is context:");
        String[] names = ctx.getBeanDefinitionNames();
        Arrays.sort(names);
        for (String beanName : names) {
            System.out.println(beanName);
        }
    }
}
