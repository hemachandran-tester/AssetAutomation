package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.DeleteAssetPage;

public class DeleteAssetTest extends BaseTest {
    @Test
    public void DeleteAsset() {
        // Login
        login();

        // Delete Asset
        DeleteAssetPage deleteAssetPage = new DeleteAssetPage(page);

        deleteAssetPage.clickAssetButton();
        deleteAssetPage.clickDeleteButton();
        deleteAssetPage.clickConformationButton();

        // More
        deleteAssetPage.clickMoreIcon();
        assertThat(page.locator("div[data-id='5']")).isVisible();
        page.waitForTimeout(3000);
    }
}
