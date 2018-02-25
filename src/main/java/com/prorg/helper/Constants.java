package com.prorg.helper;

public class Constants {
    public static class SessionKeys {
        public static final String LOGGED_IN_USER = "loggedInUser";
    }

    public static class ModelAttributes {
        public static final String MESSAGE = "message";
        public static final String RESULT = "result";
    }

    public static class Route {
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String REGISTER = "/register";
        public static final String ROOT = "/";
        public static final String REDIRECT = "redirect:";
    }

    public static class RedirectPage {
        public static final String INDEX = "index";
        public static final String LOGIN_FORM = "login";
        public static final String REGISTRATION_FORM = "registrationForm";
    }

    public static class RequestAttributes {
        public static final String REFERER = "referer";
        public static String HttpMethod = "_method";
    }

    public class HttpMethod {
        public static final String DELETE = "_delete";
    }

    public class User{
        public static final String USER_PROFILE = "/profile";
    }

    public class Courier{
        public static final String NEW_ORDER = "/orders";
        public static final String GET_ORDER = "/orders/{id}";
    }
}
