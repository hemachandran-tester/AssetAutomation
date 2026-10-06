package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HistoryAssetPage {

    private Locator assetBtn;
    private Locator historyBtn;

    public HistoryAssetPage(Page page) {

        assetBtn = page.getByTestId("MonitorIcon");

        historyBtn = page.getByTestId("HistoryIcon").first();

    }

    public void clickAssetBtn() {
        assetBtn.click();
    }

    public void clickHistoryBtn() {
        historyBtn.click();
    }
}
