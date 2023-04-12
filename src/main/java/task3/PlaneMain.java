package task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlaneMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        Plane plane = context.getBean(Plane.class);
        plane.flyThePlane();
    }
}
