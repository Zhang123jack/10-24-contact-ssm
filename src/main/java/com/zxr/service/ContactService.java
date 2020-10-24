package com.zxr.service;

import com.zxr.domain.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> queryAll();

    List<Contact> queryAll(int currentPage, int pageSize);

    int getPageCount(int pageSize);

    boolean deleteById(String contactId);

    Contact getContact(String id);

    boolean update(Contact contact);

    boolean add(Contact contact);
}
