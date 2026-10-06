package com.PlaywrightFramewrok.base;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ForgotPassBaseTest {
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

    protected void loginpage() {
        page.navigate(baseUrl + "/login");
        assertThat(page).hasTitle("Verinite - Asset Management");
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
