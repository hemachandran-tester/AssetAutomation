package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ForgotPassowrdPage {

    private Locator forgotPasswordBtn;
    private Locator employeeID;
    private Locator sendOtp;
    private Locator enterMail;
    private Locator enterOtp;
    private Locator enterNewPassword;
    private Locator conformPassword;
    // private Locator resetbtn;
    private Locator cancelbtn;

    public ForgotPassowrdPage(Page page) {

        forgotPasswordBtn = page.getByText("Forgot Password?");

        employeeID = page.getByPlaceholder("Enter your Employee Id");

        sendOtp = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send OTP"));

        enterMail = page.getByPlaceholder("Enter your email");

        enterOtp = page.getByPlaceholder("Enter your OTP");

        enterNewPassword = page.getByPlaceholder("Enter New Password");

        conformPassword = page.getByPlaceholder("Confirm Password");

        cancelbtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));

    }

    public void clickforgotPasswordBtn() {
        forgotPasswordBtn.click();
    }

    public void enteremployeeID(String employeeIDValue) {
        employeeID.fill(employeeIDValue);
    }

    public void clicksendOtp() {
        sendOtp.click();
    }

    public void enterenterMail(String enterMailValue) {
        enterMail.fill(enterMailValue);

    }

    public void enterenterOtp(String enterOtpValue) {
        enterOtp.fill(enterOtpValue);

    }

    public void enterenterNewPassword(String enterNewPasswordValue) {
        enterNewPassword.fill(enterNewPasswordValue);

    }

    public void enterconformPassword(String conformPasswordValue) {
        conformPassword.fill(conformPasswordValue);

    }

    public void clickcancelbtn() {
        cancelbtn.click();
    }

}
