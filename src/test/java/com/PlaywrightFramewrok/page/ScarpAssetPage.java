package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ScarpAssetPage {

    private Locator assetButton;
    private Locator scrapButton;

    public ScarpAssetPage(Page page) {

        assetButton = page.getByTestId("MonitorIcon");

        scrapButton = page.getByRole(
                AriaRole.MAIN).getByRole(
                        AriaRole.BUTTON,
                        new Locator.GetByRoleOptions().setName("Scrap"));

    }

    public void clickAssetButton() {
        assetButton.click();
    }

    public void clickScrapButton() {
        scrapButton.click();
    }
}
