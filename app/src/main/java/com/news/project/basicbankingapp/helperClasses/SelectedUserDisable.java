package com.news.project.basicbankingapp.helperClasses;

public class SelectedUserDisable {

    public static  int  AccountNo;
    public SelectedUserDisable(int acNo){
        SelectedUserDisable.AccountNo = acNo;
    }

    public static int getAccountNo() {
        return AccountNo;
    }

}
