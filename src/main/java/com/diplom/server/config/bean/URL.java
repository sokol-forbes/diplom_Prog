package com.diplom.server.config.bean;

public final class URL {

    public static final String ROOT = "/";
    public static final String CONTEXT_PATH = "/api/v1";
    public static final String TOKEN = "/token";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";
    public static final String REFRESH = "/refresh";
    public static final String USERINFO = "/userinfo";

    public static final String USERS = "/user";
    public static final String GET_ALL_USER = "/get-all";
    public static final String GET_USER_BY_ID = "/{id}";
    public static final String ADD_USER = "/add";

    public static final String TEST = "/test";
    public static final String ONE_ROLE = "/one-role";
    public static final String TWO_ROLES = "/two-role";
    public static final String ALL_ROLES = "/all-roles";
    public static final String ONLY_ADMIN = "/only-admin";

    public static final String TABLES = "/tables";
    public static final String MT103 = "/mt103";

    private URL() {
        throw new UnsupportedOperationException();
    }
}
