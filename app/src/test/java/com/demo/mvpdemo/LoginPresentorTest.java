package com.demo.mvpdemo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravi .
 */
@RunWith(JUnit4.class)
public class LoginPresentorTest {

    private LoginPresentor mPresenter;
    private LoginContract.ILoginView mView;
    private ILoginService service;

    @Before
    @SuppressWarnings("unchecked")
    public void setup() {

        mView = mock(LoginActivity.class);
        mPresenter = new LoginPresentor(mView);
        service = mock(LoginService.class);
    }

    @Test
    public void testLoginClicked()
    {
        when(mView.getUserName()).thenReturn("");
        when(mView.getPassword()).thenReturn("");
        mPresenter.validateUser();

        verify(mView, times(1)).showErrorMessage("User name cannot be empty");

        when(mView.getUserName()).thenReturn("ravi");
        when(mView.getPassword()).thenReturn("");
        mPresenter.validateUser();

        verify(mView, times(1)).showErrorMessage("Password cannot be empty");


        when(mView.getUserName()).thenReturn("ravi");
        when(mView.getPassword()).thenReturn("wrongPassword");
        mPresenter.validateUser();
        verify(mView, times(1)).showErrorMessage("Credentials invalid.");

        when(mView.getUserName()).thenReturn("ravi");
        when(mView.getPassword()).thenReturn("ravi");
        mPresenter.validateUser();
        verify(mView, times(1)).onUserAuthenticated();
    }
}
