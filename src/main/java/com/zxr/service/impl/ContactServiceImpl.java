package com.zxr.service.impl;

import com.zxr.dao.ContactDao;
import com.zxr.dao.impl.ContactDaoImpl;
import com.zxr.domain.Contact;
import com.zxr.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//这个相当于bean-id可以用来get,需要指向实现类
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    //自动寻找和下面这个成员变量名相同的spring-bean-id，进行自动注入
    @Autowired
    ContactDao contactDao;

    public void setDao(ContactDao dao) {
        this.contactDao = dao;
    }

    @Override
    public List<Contact> queryAll() {
        return contactDao.queryAll();
    }

    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffset=(currentPage-1)*pageSize;
        return contactDao.queryAll(pageOffset,pageSize);
    }

    @Override
    public int getPageCount(int pageSize) {
        int count=contactDao.getContactCount();
        int pageCount=(int)Math.ceil(count/(double)pageSize);
        return pageCount;
    }

    @Override
    public boolean deleteById(String contactId) {
        int num=contactDao.deleteById(contactId);
        if(num==1){
            return true;
        }
        return false;
    }

    @Override
    public Contact getContact(String id) {
        Contact contact=contactDao.getContact(id);
        return contact;
    }

    @Override
    public boolean update(Contact contact) {
        int result=contactDao.update(contact);
        return result==1;
    }

    @Override
    public boolean add(Contact contact) {
        int result=contactDao.add(contact);
        return result==1;
    }


}
