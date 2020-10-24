package com.zxr.dao;

import com.zxr.domain.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> queryAll();

    List<Contact> queryAll(int currentPage, int pageSize);

    int getContactCount();

    int deleteById(String contactId);

    Contact getContact(String id);

    int update(Contact contact);

    int add(Contact contact);
}
