package com.example.springcomp.enums;

import java.util.HashMap;
import java.util.Map;

public enum  UserTypeEnum {
    CLIENT(0),
    VENDOR(1);

    private UserTypeEnum selectedUserType;
    private Integer selectedInt;
    private static Map list = new HashMap();
    static{
        for (UserTypeEnum userType : UserTypeEnum.values()){
            list.put(userType.selectedUserType,userType);
        }
    }
    UserTypeEnum(int i) {
        this.selectedInt=i;
        setSelectedUserType();
    }
    public Integer getSelectedInt() {
        return selectedInt;
    }
    public UserTypeEnum getSelectedUserType() {
        return selectedUserType;
    }
    public void setSelectedUserType() {
        this.selectedUserType = (UserTypeEnum) list.get(selectedInt);
    }
}