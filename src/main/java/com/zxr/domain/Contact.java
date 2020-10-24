package com.zxr.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private int id;
    private String name;
    private String gender;
    private long birthday;
    private String birthplace;
    private String mobile;
    private String email;

    public Contact() {
    }

    public Contact(String name, String gender, long birthday, String birthplace, String mobile, String email) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.mobile = mobile;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{id='"+id +'\''+
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public int getAge(){
        long l = System.currentTimeMillis();
        int age=(int)((l-birthday)/1000/60/60/24/365);
        return age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormatBirthday(){
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        String format = s.format(birthday);
        return format;
    }
    public void setFormatBirthday(String formatBirthday){
        try {
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
            Date parse = null;
            parse = s.parse(formatBirthday);
            birthday = parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
