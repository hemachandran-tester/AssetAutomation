package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.ScarpAssetPage;

public class ScarpAssetTest extends BaseTest {

    @Test
    public void clickScarp() {

        // Login
        login();

        // Scrap Asset
        ScarpAssetPage scarpAssetPage = new ScarpAssetPage(page);

        scarpAssetPage.clickAssetButton();
        scarpAssetPage.clickScrapButton();

    }
}