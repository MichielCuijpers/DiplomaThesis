package com.icsd.game.thesis.database;

import android.provider.BaseColumns;

public class User {
    private String username;
    private String sex;
    private int age;

    public User(String i) {
        this.username = i;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public int getAge() {
        return this.age;
    }

    public static class UserDBEntry implements BaseColumns {

        public static final String TABLE_NAME = "user";
        public static final String NICKNAME = "nickname";
        public static final String AGE = "age";
        public static final String SEX = "sex";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + User.UserDBEntry.TABLE_NAME + " (" +
                        User.UserDBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + UserDBEntry.AGE + " INTEGER,"
                        + UserDBEntry.SEX + " TEXT,"
                        + User.UserDBEntry.NICKNAME + " TEXT)";


    }

    public static class UsersLogin implements BaseColumns {
        public static final String TABLE_NAME = "login";
        public static final String DATE = "date";
        public static final String USER_ID = "userId";

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + UsersLogin.TABLE_NAME + " ("
                + UsersLogin._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsersLogin.DATE + " TEXT,"
                + USER_ID + " TEXT, "
                + "FOREIGN KEY(" + USER_ID + ") REFERENCES user(" + User.UserDBEntry._ID + "))";

    }

}
