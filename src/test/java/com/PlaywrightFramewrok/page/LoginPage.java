package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private Locator empId;
    private Locator password;
    private Locator loginbutton;

    public LoginPage(Page page) {
        empId = page.getByPlaceholder("Employee Id");
        password = page.getByPlaceholder("Password");
        loginbutton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }

    public void enterEmpID(String empIDvalue) {
        empId.fill(empIDvalue);
    }

    public void enterPassword(String passwordvalue) {
        password.fill(passwordvalue);
    }

    public void clickLoginButton() {
        loginbutton.click();
    }

    public void login(String empIDvalue, String passwordValue) {
        enterEmpID(empIDvalue);
        enterPassword(passwordValue);
        clickLoginButton();
    }

}