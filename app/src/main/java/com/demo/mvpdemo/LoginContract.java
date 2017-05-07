package com.demo.mvpdemo;

/**
 * Created by ravi .
 */

public interface LoginContract {

    interface ILoginView {
        String getUserName();
        String getPassword();
        void onUserAuthenticated();
        void showErrorMessage(String msg);
    }

    interface ILoginPresentor {
        void validateUser(String userName, String password);
    }

}
