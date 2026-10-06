package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.LogOutPage;

public class LogOutTest extends BaseTest {

    @Test
    public void logout() {

        // Login
        login();

        // Logout
        LogOutPage logOutPage = new LogOutPage(page);

        logOutPage.clickProfile();
        logOutPage.clickLogout();
    }
}
