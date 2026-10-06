package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Typing {

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

        context = browser.newContext();

        page = context.newPage();
    }

    @Test
    public void typingTest() {

        page.navigate(
                "https://www.livechat.com/typing-speed-test/#/");

        Locator input = page.locator("#test-input");

        input.waitFor();
        input.click();

        String previousText = "";

        for (int round = 0; round < 100; round++) {

            Locator words = page.locator(".tst-input-wrapper span");

            // Get the currently rendered text
            String currentText = words.allInnerTexts()
                    .stream()
                    .map(String::trim)
                    .filter(text -> !text.isEmpty())
                    .reduce("", (a, b) -> a + " " + b)
                    .trim();

            if (currentText.isEmpty()) {

                System.out.println(
                        "No words found. Test may have finished.");

                break;
            }

            /*
             * Wait for the text to finish rendering.
             * Keep checking until the text remains unchanged.
             */
            String stableText = currentText;

            for (int i = 0; i < 10; i++) {

                page.waitForTimeout(50);

                String newText = words.allInnerTexts()
                        .stream()
                        .map(String::trim)
                        .filter(text -> !text.isEmpty())
                        .reduce("", (a, b) -> a + " " + b)
                        .trim();

                if (newText.equals(stableText)) {

                    // Text is stable, so rendering is complete
                    break;
                }

                stableText = newText;
            }

            currentText = stableText;

            // If this is new text
            if (!currentText.equals(previousText)) {

                String textToType = "";

                if (currentText.startsWith(previousText)) {

                    // Get only newly rendered words
                    textToType = currentText
                            .substring(previousText.length())
                            .trim();

                } else {

                    // Completely new batch
                    textToType = currentText;
                }

                if (!textToType.isEmpty()) {

                    System.out.println(
                            "Full batch rendered: " + textToType);

                    // Type the entire batch
                    page.keyboard().type(
                            textToType,
                            new Keyboard.TypeOptions()
                                    .setDelay(0));

                    page.keyboard().press("Space");

                    previousText = currentText;
                }
            }

            page.waitForTimeout(500);
        }

        page.waitForTimeout(5000);
    }

    @AfterMethod
    public void tearDown() {

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}