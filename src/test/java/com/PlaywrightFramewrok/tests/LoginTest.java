package com.PlaywrightFramewrok.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

                { "V00857", "Hema@123", true },

                { "V00857", "Wrong123", false },

                { "V98689", "Hema@123", false },

                { "", "Hema@123", false },

                { "V00857", "", false }

        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(
            String employeeId,
            String password,
            boolean expectedResult) {

        page.navigate(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(employeeId, password);

    }
}