package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogOutPage {

    private Locator profile;
    private Locator logout;

    public LogOutPage(Page page) {

        profile = page.getByTestId("AccountCircleIcon");

        logout = page.getByTestId("LogoutIcon");
    }

    public void clickProfile() {
        profile.click();
    }

    public void clickLogout() {
        logout.click();
    }
}
