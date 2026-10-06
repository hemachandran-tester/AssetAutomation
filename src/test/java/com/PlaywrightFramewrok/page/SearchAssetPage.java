package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchAssetPage {

    private Locator dashboardBtn;
    private Locator searchBar;
    private Locator assetButton;
    private Locator employeeButton;

    public SearchAssetPage(Page page) {

        dashboardBtn = page.getByTestId("DashboardIcon");

        searchBar = page.getByPlaceholder("Search");

        assetButton = page.getByTestId("MonitorIcon");

        employeeButton = page.getByTestId("PeopleIcon");
    }

    public void clickDashboardbtn() {
        dashboardBtn.click();
    }

    public void enterTextSearchBar(String SearchBar_value) {
        searchBar.fill(SearchBar_value);
    }

    public void clickAssetButton() {
        assetButton.click();
    }

    public void clickEmployeeButton() {
        employeeButton.click();
    }

}
