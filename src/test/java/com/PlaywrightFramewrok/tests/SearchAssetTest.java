package com.PlaywrightFramewrok.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.SearchAssetPage;

public class SearchAssetTest extends BaseTest {

    @Test(priority = 0)
    public void SearchDashboard() {

        // Login
        login();

        SearchAssetPage searchAssetPage = new SearchAssetPage(page);

        // Dashboard

        searchAssetPage.clickDashboardbtn();
        searchAssetPage.enterTextSearchBar("Monitor");
        assertThat(page.locator("body")).containsText("17");

    }

    @Test(priority = 1)
    public void SearchAsset() {
        // Login
        login();

        SearchAssetPage searchAssetPage = new SearchAssetPage(page);
        // Asset

        searchAssetPage.clickAssetButton();
        searchAssetPage.enterTextSearchBar("mouse");
        assertThat(page.locator("body")).containsText("V00056");
    }

    @Test(priority = 2)
    public void SearchEmployee() {
        // Login
        login();

        SearchAssetPage searchAssetPage = new SearchAssetPage(page);
        // Employee

        searchAssetPage.clickEmployeeButton();
        searchAssetPage.enterTextSearchBar("hemachandran.saravanan@verinite.com");
        assertThat(page.locator("body")).containsText("Delivery");
    }

}
