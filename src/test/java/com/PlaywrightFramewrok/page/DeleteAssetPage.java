package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DeleteAssetPage {

    private Locator assetIcon;
    private Locator deleteButton;
    private Locator conformation;
    private Locator moreIcon;

    public DeleteAssetPage(Page page) {

        assetIcon = page.getByTestId("MonitorIcon");

        deleteButton = page.getByTestId("DeleteIcon").first();

        conformation = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes"));

        moreIcon = page.getByTestId("AppsIcon");
    }

    public void clickAssetButton() {
        assetIcon.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickConformationButton() {
        conformation.click();
    }

    public void clickMoreIcon() {
        moreIcon.click();
    }
}
