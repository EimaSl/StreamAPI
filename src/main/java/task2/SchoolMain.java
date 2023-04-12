package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchoolMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        School mySchool = (School) context.getBean("school");
        mySchool.workingStatus();

        Address newAddress = new Address();
        newAddress.setCity("Kaunas");
        newAddress.setStreet("Menulio g");

        mySchool.setAddress(newAddress);
        mySchool.setName("Kodo kelias 2");

        mySchool.workingStatus();

    }
}
