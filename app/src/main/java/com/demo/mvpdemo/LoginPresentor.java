package com.demo.mvpdemo;

/**
 * Created by ravi .
 */

public class LoginPresentor implements LoginContract.ILoginPresentor, LoginListenor {


    LoginContract.ILoginView mView;
    ILoginService iLoginService;

    LoginPresentor(LoginContract.ILoginView view){
        mView = view;
        setLoginService(new LoginService());
    }

    void setLoginService(ILoginService loginService){
        iLoginService = loginService;
    }

    @Override
    public void validateUser(String userName, String password) {
        if(isEmpty(userName)){
            mView.showErrorMessage("User name cannot be empty");
            return;
        }

        if(isEmpty(password)){
            mView.showErrorMessage("Password cannot be empty");
            return;
        }

        iLoginService.validateCreds(userName, password, this);
    }

    @Override
    public void onSuccess() {
        mView.onUserAuthenticated();
    }

    @Override
    public void onFailure(String errorMessage) {
        mView.showErrorMessage(errorMessage);
    }

    private boolean isEmpty(String string){
        return null == string || string.trim().length() == 0;
    }
}
