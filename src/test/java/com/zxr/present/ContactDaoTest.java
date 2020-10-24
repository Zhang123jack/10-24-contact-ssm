package com.zxr.present;

import com.zxr.config.SpringConfig;
import com.zxr.dao.ContactDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactDaoTest {
    @Test
    public void testDAO() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ContactDao contactDAO = context.getBean("contactDAO",ContactDao.class);

        ContactDao contactDAO1 = context.getBean("contactDAO", ContactDao.class);
        System.out.println(contactDAO);
        System.out.println(contactDAO.queryAll(1,10));
        System.out.println(contactDAO1);
        context.close();
    }
}
