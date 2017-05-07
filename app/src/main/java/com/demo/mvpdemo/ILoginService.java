package com.demo.mvpdemo;

/**
 * Created by ravi .
 */

public interface ILoginService {
    void validateCreds(String user, String password, LoginListenor listener);
}
