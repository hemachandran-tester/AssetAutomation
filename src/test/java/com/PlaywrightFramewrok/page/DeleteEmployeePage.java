package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DeleteEmployeePage {

    private Locator employeeButton;
    private Locator deleteButton;
    private Locator deleteConformBtn;

    public DeleteEmployeePage(Page page) {

        employeeButton = page.getByTestId("PeopleIcon");

        deleteButton = page.getByTestId("DeleteIcon").first();

        deleteConformBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes"));

    }

    public void clickEmployeeButton() {
        employeeButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickDeleteConform() {
        deleteConformBtn.click();
    }
}
