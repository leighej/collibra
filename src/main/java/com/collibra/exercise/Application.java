package com.collibra.exercise;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        
        MySocket app = new MySocket();
            System.out.println("\r\nRunning Server: " + 
                    "Host=" + app.getSocketAddress().getHostAddress() + 
                    " Port=" + app.getPort());
        
        app.listen();
    }
   
}