package com.demo.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView{

    @Bind(R.id.usernameet)
    EditText userName;

    @Bind(R.id.passwordet)
    EditText password;

    @Bind(R.id.login)
    Button login;

    LoginContract.ILoginPresentor iLoginPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iLoginPresentor = new LoginPresentor(this);
    }

    @OnClick(R.id.login)
    void onLoginClick(){
        iLoginPresentor.validateUser(getUserName(), getPassword());
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void onUserAuthenticated() {

    }

    @Override
    public void showErrorMessage(String msg) {

    }
}
