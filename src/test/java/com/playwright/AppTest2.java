package com.playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class AppTest2 {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void LoginPage() {
        assertThat(page.locator("body")).containsText("Login");
        assertThat(page.locator("body")).containsText("Forgot your password?");
    }

    @Test
    public void Login() {
        page.getByPlaceholder("Username").fill("Admin");
        page.getByPlaceholder("Password").fill("admin123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login ")).click();
        page.waitForTimeout(10000);

    }

    @AfterClass
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();

    }

}
