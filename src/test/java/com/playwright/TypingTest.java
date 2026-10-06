package com.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.*;

public class TypingTest {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));

        page = browser.newPage();
    }

    @Test
    public void typingWebsite() {

        page.navigate("https://www.typewizz.com/typing-test");

        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Start test"))
                .click();

        page.locator("#scrollable-text").click();

        for (int i = 0; i < 10000; i++) {

            try {
                Locator current = page.locator(".letter.current").first();

                current.waitFor(
                        new Locator.WaitForOptions()
                                .setTimeout(3000));

                String raw = current.textContent();

                if (raw == null)
                    continue;

                String key = raw.trim();

                // Handle spaces
                if (key.isEmpty() || raw.contains("\u00A0")) {
                    key = " ";
                }

                System.out.println("Typing: [" + key + "]");

                // Type character
                if (key.equals(" ")) {
                    page.keyboard().press("Space");
                } else {
                    page.keyboard().insertText(key);
                }

                /*
                 * First part: faster
                 * Later part: slightly slower
                 * This prevents duplicate letters when the page scrolls.
                 */
                if (i < 500) {
                    page.waitForTimeout(17);
                } else {
                    page.waitForTimeout(30);
                }

            } catch (PlaywrightException e) {
                System.out.println("Test finished");
                break;
            }
        }

        page.waitForTimeout(3000);
    }

    @AfterMethod
    public void tearDown() {

        if (browser != null)
            browser.close();

        if (playwright != null)
            playwright.close();
    }
}