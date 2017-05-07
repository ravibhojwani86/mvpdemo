package com.demo.mvpdemo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by ravi .
 */
@RunWith(JUnit4.class)
public class LoginPresentorTest {

    private LoginPresentor mPresenter;
    private LoginContract.ILoginView mView;

    @Before
    @SuppressWarnings("unchecked")
    public void setup() {

        mView = mock(LoginActivity.class);
        mPresenter = new LoginPresentor(mView);
    }

    @Test
    public void testLoginClicked()
    {
        mPresenter.validateUser("", null);
        verify(mView, times(1)).showErrorMessage("User name cannot be empty");

        mPresenter.validateUser("ravi", null);
        verify(mView, times(1)).showErrorMessage("Password cannot be empty");

        mPresenter.validateUser("ravi", "");
        verify(mView, times(2)).showErrorMessage("Password cannot be empty");

        mPresenter.validateUser("ravi", "wrongPassword");
        verify(mView, times(1)).showErrorMessage("Credentials invalid.");

        mPresenter.validateUser("ravi", "ravi");
        verify(mView, times(1)).onUserAuthenticated();
    }
}
