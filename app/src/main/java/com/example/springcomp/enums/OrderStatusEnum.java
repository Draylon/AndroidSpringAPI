package com.example.springcomp.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatusEnum {
    OPEN(0),           // 0 aberto
    CONFIRMED(1),      // 1 Confirmado pelo restaurante
    IN_TRANSIT(2),     // 2 Em transito
    COMPLETE(3),       // 3 Entregue

    EXPIRED(4),        // 4 Expirado
    CANCELED(5),       // 5 Cancelado
    ERROR(6);           // 6 Error :(

    private int selectedEnum;
    private static Map enumList = new HashMap();
    private static Map stringList = new HashMap();

    static {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            enumList.put(orderStatusEnum.selectedEnum,orderStatusEnum);
            stringList.put(orderStatusEnum.toString(),orderStatusEnum);

        }
    }

    public int getValue(){
        return this.selectedEnum;
    }

    public static OrderStatusEnum getEnum(int i){ return (OrderStatusEnum) enumList.get(i); }
    public static OrderStatusEnum getEnum(String s){ return (OrderStatusEnum) stringList.get(s);}


    public static String getString(int i){ return (String) stringList.get(enumList.get(i)); }
    public static String getString(OrderStatusEnum o){ return (String) stringList.get(o); }

    public static int getInt(OrderStatusEnum orderStatusEnum){ return (int) enumList.get(orderStatusEnum); }
    public static int getInt(String s){ return (int) enumList.get(stringList.get(s)); }

    OrderStatusEnum(int i) {
        this.selectedEnum = i;
    }
    /*OrderStatusEnum(String s){
        this.selectedEnum = getInt(s);
    }*/

}

/*
OPEN,CONFIRMED,IN_TRANSIT,COMPLETE,EXPIRED,CANCELED,ERROR
 */