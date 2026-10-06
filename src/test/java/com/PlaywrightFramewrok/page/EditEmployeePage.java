package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EditEmployeePage {

    private Locator employeeBtn;
    private Locator editOption;
    private Locator editFirstName;
    private Locator editLastName;
    private Locator editRole;
    private Locator editRoleOption;
    private Locator editEmail;
    private Locator editMobileNo;
    private Locator editLocation;
    private Locator editLocationOption;
    private Locator editStatus;
    private Locator editStatusOptions;
    private Locator editDepartment;
    private Locator editDepartmentOption;
    private Locator editDesignation;
    private Locator editDesignationOption;
    private Locator updateBtn;

    public EditEmployeePage(Page page) {

        employeeBtn = page.getByTestId("PeopleIcon");

        editOption = page.getByTestId("EditIcon").nth(0);

        editFirstName = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("First Name"));

        editLastName = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Last Name"));

        editEmail = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Email"));

        editMobileNo = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions()
                        .setName("Mobile"));

        editLocation = page.getByPlaceholder("Enter The Location If not in Below List");

        editLocationOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions()
                        .setName("Chennai"))
                .nth(0);

        editStatus = page.locator("label").filter(
                new Locator.FilterOptions().setHasText("Status"))
                .locator("xpath=following-sibling::div[1]")
                .locator("div[role='combobox']").nth(0);

        editStatusOptions = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions()
                        .setName("Active"))
                .nth(0);

        editDepartment = page.getByPlaceholder("Enter The Department If not in Below List");

        editDepartmentOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions()
                        .setName("Delivery"))
                .nth(0);

        editRole = page.locator("label").filter(
                new Locator.FilterOptions().setHasText("Role"))
                .locator("xpath=following-sibling::div[1]")
                .locator("div[role='combobox']");

        editRoleOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions()
                        .setName("Admin"));

        editDesignation = page.getByPlaceholder("Enter The Designation If not in Below List");

        editDesignationOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions().setName("QA"))
                .nth(0);
        updateBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update"));
    }

    public void click_Employee_btn() {
        employeeBtn.click();
    }

    public void click_Edit_option() {
        editOption.click();
    }

    public void enter_Edit_First_Name(String Edit_First_Name_Value) {
        editFirstName.fill(Edit_First_Name_Value);
    }

    public void enter_Edit_Edit_Last_Name(String Edit_Last_Name_Value) {
        editLastName.fill(Edit_Last_Name_Value);
    }

    public void click_Edit_Role() {
        editRole.click();
    }

    public void click_Edit_Role_Option() {
        editRoleOption.click();
    }

    public void enter_Edit_Email(String Edit_Email_Value) {
        editEmail.fill(Edit_Email_Value);
    }

    public void enter_Edit_Mobile_no(String Edit_Mobile_no_Value) {
        editMobileNo.fill(Edit_Mobile_no_Value);
    }

    public void enter_Edit_Location(String Edit_Location_Value) {
        editLocation.fill(Edit_Location_Value);
    }

    public void click_Edit_Location_Option() {
        editLocationOption.click();
    }

    public void click_Edit_Status() {
        editStatus.click();
    }

    public void click_Edit_Status_Options() {
        editStatusOptions.click();
    }

    public void enter_Edit_Department(String Edit_Department_Value) {
        editDepartment.fill(Edit_Department_Value);
    }

    public void click_Edit_Department_Option() {
        editDepartmentOption.click();
    }

    public void enter_Edit_Designationt(String Edit_Designation_Value) {
        editDesignation.fill(Edit_Designation_Value);
    }

    public void click_Edit_Designation_Option() {
        editDesignationOption.click();
    }

    public void click_Update_btn() {
        updateBtn.click();
    }

}
