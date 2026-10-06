package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.DeleteEmployeePage;

public class DeleteEmployeeTest extends BaseTest {
    @Test
    public void DeleteEmployee() {
        // Login
        login();

        // Delete Employee
        DeleteEmployeePage deleteEmployeePage = new DeleteEmployeePage(page);

        deleteEmployeePage.clickEmployeeButton();
        deleteEmployeePage.clickDeleteButton();
        deleteEmployeePage.clickDeleteConform();
    }

}
