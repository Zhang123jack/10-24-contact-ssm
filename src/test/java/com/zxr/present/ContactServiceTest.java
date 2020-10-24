package com.zxr.present;

import com.zxr.config.SpringConfig;
import com.zxr.domain.Contact;
import com.zxr.service.ContactService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ContactServiceTest {
    @Test
    public void testService() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ContactService contactService = context.getBean("contactService", ContactService.class);

        List<Contact> contacts = contactService.queryAll(1, 10);

        System.out.println(contacts);

        context.close();
    }
}
