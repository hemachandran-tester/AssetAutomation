package com.PlaywrightFramewrok.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.ImportAndExportPage;
import com.PlaywrightFramewrok.page.LoginPage;

public class ImportAndExportTest extends BaseTest {

    @Test
    public void ImprtAndExport() {

        // login
        page.navigate("http://localhost:4200/login");
        assertThat(page).hasTitle("Verinite - Asset Management");
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("V00857", "Hema@123");
        assertThat(page.locator("body")).containsText("Hema");

        // Export
        page.waitForTimeout(3000);
        ImportAndExportPage ImportAndExportPage = new ImportAndExportPage(page);
        ImportAndExportPage.click_AssetButton();
        ImportAndExportPage.click_Export();
        ImportAndExportPage.click_Export_to_Excel();

        page.waitForTimeout(3000);

        // Import
        ImportAndExportPage.click_Import();
        ImportAndExportPage.uploadFile();

        ImportAndExportPage.click_Update_btn();
        page.waitForTimeout(3000);
    }

}
