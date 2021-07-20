package com.news.project.basicbankingapp.helperClasses;
/*
* user info class so that user's details can be displayed on UserDetails class
* */
public  class UserInfo {

    private static String username , AccountNumber , CurrentBalance;
    public UserInfo(String name, String AccoutNo , String Balance){
        username = name;
        AccountNumber = AccoutNo;
        CurrentBalance = Balance;
    }

    public static  String getUsername() {
        return username;
    }

    public static String getAccountNumber() {
        return AccountNumber;
    }

    public static String getCurrentBalance() {
        return CurrentBalance;
    }
}
