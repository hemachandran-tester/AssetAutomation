package com.PlaywrightFramewrok.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.HistoryAssetPage;

public class HistoryAssetTest extends BaseTest {

    @Test
    public void history() {
        // Login
        login();

        // History
        HistoryAssetPage historyAssetPage = new HistoryAssetPage(page);

        historyAssetPage.clickAssetBtn();
        assertThat(page.getByTestId("HistoryIcon").first()).isVisible();

        historyAssetPage.clickHistoryBtn();
        assertThat(page.locator("body")).containsText("18/09/2026");
    }
}
