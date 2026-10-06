package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class UnassignAssetPage {
    private Locator employeeBtn;
    private Locator assignBtn;
    private Locator checkBox;
    private Locator unAssign;

    public UnassignAssetPage(Page page) {
        employeeBtn = page.getByTestId("PeopleIcon");

        assignBtn = page.getByTestId("AssignmentIndIcon").first();

        checkBox = page.getByRole(AriaRole.CHECKBOX).first();

        unAssign = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Unassign"));

    }

    public void ClickemployeeBtn() {
        employeeBtn.click();
    }

    public void ClickassignBtn() {
        assignBtn.click();
    }

    public void ClickcheckBox() {
        checkBox.click();
    }

    public void ClickunAssign() {
        unAssign.click();
    }

}
