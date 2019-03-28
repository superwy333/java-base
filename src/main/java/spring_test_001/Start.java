package spring_test_001;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_test_001.config.MainConfig;
import spring_test_001.controller.TestController;
import spring_test_001.processor.Processor;


public class Start {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String name:beans) {
            System.out.println(name);
        }

        //Processor processor = (Processor) applicationContext.getBean("processor1");
        //System.out.println(processor.getProjectId());

        TestController testController = (TestController) applicationContext.getBean("testController");
        testController.userLogin();

        //while (true);



    }



}
