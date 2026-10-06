package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.ForgotPassBaseTest;
import com.PlaywrightFramewrok.page.ForgotPassowrdPage;

public class ForgotPassowrdTest extends ForgotPassBaseTest {
    @Test
    public void forgotPasword() {

        // Login Page

        loginpage();

        // Forgot Password
        ForgotPassowrdPage forgotPassowrdPage = new ForgotPassowrdPage(page);

        forgotPassowrdPage.clickforgotPasswordBtn();
        forgotPassowrdPage.enteremployeeID("V00857");
        forgotPassowrdPage.clicksendOtp();

        // Reset Password

        forgotPassowrdPage.enterenterMail("exampleMail@gmail.com");
        forgotPassowrdPage.enterenterOtp("12345");
        forgotPassowrdPage.enterenterNewPassword("Asdf123");
        forgotPassowrdPage.enterconformPassword("Asdf123");

        // Cancel

        forgotPassowrdPage.clickcancelbtn();

        // page.waitForTimeout(3000);

    }

}
