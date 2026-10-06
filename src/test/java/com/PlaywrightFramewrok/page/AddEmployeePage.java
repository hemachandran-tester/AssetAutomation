package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddEmployeePage {

        private Locator employeeBtn;
        private Locator addEmployeeBtn;
        private Locator employeeID;
        private Locator firstName;
        private Locator lastName;
        private Locator email;
        private Locator mobile;
        private Locator location;
        private Locator employeeLocationOption;
        private Locator status;
        private Locator statusOptions;
        private Locator department;
        private Locator employeeDepartmentOption;
        private Locator role;
        private Locator roleOption;
        private Locator designation;
        private Locator designationOption;
        private Locator employeeAddBtn;

        public AddEmployeePage(Page page) {

                employeeBtn = page.getByTestId("PeopleIcon");

                addEmployeeBtn = page.getByTestId("AddCircleOutlineIcon").nth(1);

                employeeID = page.getByRole(AriaRole.TEXTBOX,
                                new Page.GetByRoleOptions()
                                                .setName("Employee ID"));

                firstName = page.getByRole(AriaRole.TEXTBOX,
                                new Page.GetByRoleOptions()
                                                .setName("First Name"));

                lastName = page.getByRole(AriaRole.TEXTBOX,
                                new Page.GetByRoleOptions()
                                                .setName("Last Name"));

                email = page.getByRole(AriaRole.TEXTBOX,
                                new Page.GetByRoleOptions()
                                                .setName("Email"));

                mobile = page.getByRole(AriaRole.TEXTBOX,
                                new Page.GetByRoleOptions()
                                                .setName("Mobile"));

                location = page.getByPlaceholder("Enter The Location If not in Below List");

                employeeLocationOption = page.getByRole(AriaRole.OPTION,
                                new Page.GetByRoleOptions()
                                                .setName("Chennai"))
                                .nth(0);

                status = page.locator("label").filter(
                                new Locator.FilterOptions().setHasText("Status"))
                                .locator("xpath=following-sibling::div[1]")
                                .locator("div[role='combobox']").nth(0);

                statusOptions = page.getByRole(AriaRole.OPTION,
                                new Page.GetByRoleOptions()
                                                .setName("Active"))
                                .nth(0);

                department = page.getByPlaceholder("Enter The Department If not in Below List");

                employeeDepartmentOption = page.getByRole(AriaRole.OPTION,
                                new Page.GetByRoleOptions()
                                                .setName("Delivery"))
                                .nth(0);

                role = page.locator("label").filter(
                                new Locator.FilterOptions().setHasText("Role"))
                                .locator("xpath=following-sibling::div[1]")
                                .locator("div[role='combobox']");

                roleOption = page.getByRole(AriaRole.OPTION,
                                new Page.GetByRoleOptions()
                                                .setName("Admin"));

                designation = page.getByPlaceholder("Enter The Designation If not in Below List");

                designationOption = page.getByRole(AriaRole.OPTION,
                                new Page.GetByRoleOptions().setName("QA"))
                                .nth(0);
                employeeAddBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add"));
        }

        public void click_Employee_btn() {
                employeeBtn.click();
        }

        public void click_Add_Employee_btn() {
                addEmployeeBtn.click();
        }

        public void enter_Employee_ID(String Employee_ID_Value) {
                employeeID.fill(Employee_ID_Value);
        }

        public void enter_First_Name(String First_Name_Value) {
                firstName.fill(First_Name_Value);
        }

        public void enter_Last_Name(String Last_Name_Value) {
                lastName.fill(Last_Name_Value);
        }

        public void enter_Email(String Email_Value) {
                email.fill(Email_Value);
        }

        public void enter_Mobile(String Mobile_Value) {
                mobile.fill(Mobile_Value);
        }

        public void enter_Location(String Location_Value) {
                location.fill(Location_Value);
        }

        public void click_Employee_Location_Option() {
                employeeLocationOption.click();
        }

        public void click_Status() {
                status.click();
        }

        public void click_Status_Options() {
                statusOptions.click();
        }

        public void enter_Department(String Department_Value) {
                department.fill(Department_Value);
        }

        public void click_Employee_Department_Option() {
                employeeDepartmentOption.click();
        }

        public void click_Role() {
                role.click();
        }

        public void click_Role_Option() {
                roleOption.click();
        }

        public void enter_Designation(String Designation_Value) {
                designation.fill(Designation_Value);
        }

        public void click_Designation_Option() {
                designationOption.click();
        }

        public void click_Employee_Add_btn() {
                employeeAddBtn.click();
        }

}
