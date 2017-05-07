package com.demo.mvpdemo;

/**
 * Created by ravi .
 */

public class LoginService implements ILoginService{


    @Override
    public void validateCreds(String user, String password, LoginListenor listener) {


        if(null != user && null != password){
            if(user.contains("ravi") && password.contains("ravi")){
                listener.onSuccess();
            }else{
                listener.onFailure("Credentials invalid.");
            }
        }
    }

}
