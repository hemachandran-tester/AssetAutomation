package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AssignAssetPage {

    private Locator assetButton;
    private Locator assignButton;
    private Locator selectEmployee;
    private Locator selectEmployeeOption;
    private Locator assign;

    public AssignAssetPage(Page page) {

        assetButton = page.getByTestId("MonitorIcon");

        assignButton = page.getByTestId("PersonAddIcon").nth(1);

        selectEmployee = page.getByPlaceholder("🔍 Search and Select Employee");

        selectEmployeeOption = page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("V01245"));

        assign = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Assign Asset"));
    }

    public void click_Asset_button() {
        assetButton.click();
    }

    public void click_Assign_button() {
        assignButton.click();
    }

    public void click_Select_employee() {
        selectEmployee.click();
    }

    public void click_Select_employee_Option() {
        selectEmployeeOption.click();
    }

    public void click_Assign() {
        assign.click();
    }
}
