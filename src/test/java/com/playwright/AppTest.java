package com.playwright;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.nio.file.Paths;

public class AppTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setIgnoreHTTPSErrors(true));

        page = context.newPage();
    }
    // https://www.way2automation.com/automationpracticesite1.html

    @Test
    public void clickWebInputs() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Try Login (admin / admin)")).click();
        assertThat(page.locator("body")).containsText("Login");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        assertThat(page.locator("body")).containsText("Featured Products");
        page.getByText("White Running Shoes").locator("..")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Add to cart")).click();
        page.locator(".fa-shopping-cart").click();
        assertThat(page.locator("#cart-total")).containsText("$119");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();

    }

    @Test
    public void elements() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        assertThat(page.locator("body")).containsText("Practice Elements");
        page.locator("a[onclick=\"showSection('elements')\"]").click();
        assertThat(page.locator("body")).containsText("Practice All UI Elements");
        Locator inputName = page.getByPlaceholder("Enter your name");
        inputName.fill("Hemachandran");
        assertThat(inputName).hasValue("Hemachandran");
        Locator inputEmail = page.getByPlaceholder("test@example.com");
        inputEmail.fill("Hemachandran@gmail.com");
        assertThat(inputEmail).hasValue("Hemachandran@gmail.com");
        Locator inputPass = page.getByPlaceholder("••••••••");
        inputPass.fill("Hema@123");
        assertThat(inputPass).hasValue("Hema@123");
        assertThat(page.locator("[name='gender'][value='male']")).isEnabled();
        assertThat(page.locator("[type='checkbox']").first()).isChecked();
        Locator codingCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Coding"));
        codingCheckBox.click();
        assertThat(codingCheckBox).isChecked();
        Locator gamingCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Gaming"));
        gamingCheckBox.click();
        assertThat(gamingCheckBox).isChecked();
        Locator travelingCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Traveling"));
        travelingCheckBox.click();
        assertThat(travelingCheckBox).isChecked();

    }

    @Test
    public void drag_drop() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        page.locator("a[onclick=\"showSection('elements')\"]").click();
        assertThat(page.locator("body")).containsText("Practice All UI Elements");
        page.getByText("Laptop").dragTo(page.getByText("Drop items here"));
        page.getByText("Mouse").dragTo(page.getByText("Drop items here"));
        page.getByText("Keyboard").dragTo(page.getByText("Drop items here"));
        page.waitForTimeout(5000);
    }

    @Test
    public void tabs() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        page.locator("a[onclick=\"showSection('elements')\"]").click();
        assertThat(page.locator("body")).containsText("Practice All UI Elements");
        assertThat(page.locator("body")).containsText("Product details");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reviews"));
        assertThat(page.locator("body")).containsText("Customer reviews");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Shipping"));
        assertThat(page.locator("body")).containsText("Shipping information");
        page.waitForTimeout(5000);
    }

    @Test
    public void Signup() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        page.locator("a[onclick=\"showSection('signup')\"]").click();
        assertThat(page.locator("body")).containsText("Create New Account");
        page.locator("#reg-name").fill("Hema");
        page.locator("#reg-email").fill("Hemachandran@gmail.com");
        page.locator("#reg-password").fill("Hema");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Account")).click();
    }

    @Test
    public void feature_products() {
        page.navigate("https://www.way2automation.com/automationpracticesite1.html");
        page.locator("a[onclick=\"showSection('products')\"]").click();
        assertThat(page.locator("body")).containsText("Featured Products");
        page.getByPlaceholder("Search products...").fill("Black Cargo Pants");
        page.keyboard().press("Enter");
    }

    @Test
    public void typingsite() {
        page.navigate("https://www.typewizz.com/typing-test/test");
        page.waitForTimeout(3000);

    }

    @Test
    public void calendar() {
        page.navigate("https://practice-automation.com/calendars/");
        assertThat(page.locator("body")).containsText("calendar");
        page.locator("#g1065-1-selectorenteradate").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("August")).click();
        assertThat(page.locator("body")).containsText("July");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("July")).click();
        page.locator("button.dp-cal-year").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("2004")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("18")).click();
        assertThat(page.locator("body")).containsText("Submit");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.waitForTimeout(5000);
        assertThat(page.locator("body")).containsText("Thank you");
    }

    @Test
    public void testblogsite() {
        page.navigate("https://practice.expandtesting.com/otp-login");
        assertThat(page.locator("body")).containsText("Automation Testing Practice");
        page.waitForTimeout(3000);
        page.locator("#email").fill("practice@expandtesting.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send OTP Code")).click();
        assertThat(page.locator("body")).containsText("practice@expandtesting.com");
        page.locator("#otp").fill("214365");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify OTP Code")).click();
        assertThat(page.locator("body")).containsText("You logged into a secure area!");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Logout")).click();
        assertThat(page.locator("body")).containsText("You logged out of the secure area!");
    }

    @Test
    public void fileUpload() {
        page.navigate("https://practice.expandtesting.com/upload");
        assertThat(page.locator("body")).containsText("Uploader page");
        page.getByTestId("file-input")
                .setInputFiles(
                        Paths.get(
                                "C:/Users/V00857/Downloads/Test-case-assignement (1).xlsx"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload")).click();
        page.waitForTimeout(5000);
    }

    @Test
    public void popups() {
        page.navigate("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
        page.waitForTimeout(3000);

        // page.getByRole(AriaRole.)
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}