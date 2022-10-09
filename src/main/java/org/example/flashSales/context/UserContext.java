package org.example.flashSales.context;

import org.example.flashSales.domain.User;

/**
 * @description: 用于保存User的ThreadLocal
 */
public class UserContext {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        return userThreadLocal.get();
    }
}