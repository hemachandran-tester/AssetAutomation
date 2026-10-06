package com.PlaywrightFramewrok.tests;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.AddEmployeePage;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployee() {

        // Login
        login();

        // Add Employee
        AddEmployeePage addEmployeePage = new AddEmployeePage(page);
        addEmployeePage.click_Employee_btn();
        addEmployeePage.click_Add_Employee_btn();
        addEmployeePage.enter_Employee_ID("V00555");
        addEmployeePage.enter_First_Name("Hema");
        addEmployeePage.enter_Last_Name("chandran");
        addEmployeePage.enter_Email("hemachandran@Verinite.com");
        addEmployeePage.enter_Mobile("9876543221");
        addEmployeePage.enter_Location("Chennai");
        addEmployeePage.click_Employee_Location_Option();
        addEmployeePage.click_Status();
        addEmployeePage.click_Status_Options();
        addEmployeePage.enter_Department("Delivery");
        addEmployeePage.click_Employee_Department_Option();
        addEmployeePage.click_Role();
        addEmployeePage.click_Role_Option();
        addEmployeePage.enter_Designation("QA");
        addEmployeePage.click_Designation_Option();
        addEmployeePage.click_Employee_Add_btn();
        page.waitForTimeout(3000);
    }
}
