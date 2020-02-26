package com.example.springcomp.enums;

import java.util.HashMap;
import java.util.Map;

public enum  UserTypeEnum {
    CLIENT(0),
    VENDOR(1);

    private int selectedInt;
    private String selectedString;
    private static Map list = new HashMap();
    private static Map strList = new HashMap();
    static{
        for (UserTypeEnum userType : UserTypeEnum.values()){
            list.put(userType.selectedInt,userType);
            strList.put(userType.toString(),userType);
        }
    }
    UserTypeEnum(int i) {
        this.selectedInt=i;
    }
    public Integer getSelectedInt() {
        return selectedInt;
    }
    public UserTypeEnum getSelectedUserType() {
        return (UserTypeEnum) list.get(selectedInt);
    }

    public static String getString(UserTypeEnum o){ return (String) strList.get(o); }
}