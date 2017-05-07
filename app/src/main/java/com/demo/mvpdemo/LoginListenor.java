package com.demo.mvpdemo;

/**
 * Created by ravi .
 */

public interface LoginListenor {
    void onSuccess();
    void onFailure(String errorMessage);
}
