package com.example.springcomp.socketService;

public class ApiServerLink {

    private static String serverIP;
    private static String serverPort;

    public static final String MAIN_PATH = "/api/v1";

    public static final String USER_LINK = "/user";
    public static final String USER_QUERY = "/GetUser";
    public static final String USER_QUERY_EMAIL = "/GetUserByEmail";
    public static final String USER_LOGIN = "/GetLogin";

    public static final String PRODUCT_LINK = "/Product";
    public static final String PRODUCT_QUERY = "/GetProduct";
    public static final String PRODUCT_QUERYALL_ALIKE = "/GetProductListAlike";

    public static final String ORDER_LINK = "/Order";
    public static final String ORDER_QUERY = "/GetOrder";

    public static final String RESTAURANT_LINK = "/Restaurant";
    public static final String RESTAURANT_QUERY = "/GetRestaurant";
    public static final String RESTAURANT_QUERYALL_ALIKE = "/GetRestaurantListAlike";


    public static String getServerIP() { return serverIP; }

    public static void setServerIP(String serverIP) { ApiServerLink.serverIP = serverIP; }

    public static String getServerPort() { return serverPort; }

    public static void setServerPort(String serverPort) { ApiServerLink.serverPort = serverPort; }
}
