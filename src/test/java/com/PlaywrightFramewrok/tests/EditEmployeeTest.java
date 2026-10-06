package com.PlaywrightFramewrok.tests;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.EditEmployeePage;
import org.testng.annotations.Test;

public class EditEmployeeTest extends BaseTest {
    @Test
    public void EditEmployee() {
        // Login
        login();

        // Edit Empoyee
        EditEmployeePage editEmployeePage = new EditEmployeePage(page);
        editEmployeePage.click_Employee_btn();
        editEmployeePage.click_Edit_option();
        editEmployeePage.enter_Edit_First_Name("HEMA");
        editEmployeePage.enter_Edit_Edit_Last_Name("HEMA");
        editEmployeePage.click_Update_btn();
    }

}
