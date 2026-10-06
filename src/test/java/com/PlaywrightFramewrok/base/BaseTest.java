package com.PlaywrightFramewrok.base;

import com.PlaywrightFramewrok.page.LoginPage;
import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.BrowserType.LaunchOptions;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected String baseUrl = "http://localhost:4200";

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    protected void login() {
        page.navigate(baseUrl + "/login");
        assertThat(page).hasTitle("Verinite - Asset Management");
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("V00857", "Hema@123");
        assertThat(page.locator("body")).containsText("Hema");
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
