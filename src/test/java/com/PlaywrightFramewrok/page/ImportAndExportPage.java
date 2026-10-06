package com.PlaywrightFramewrok.page;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ImportAndExportPage {

    private Locator assetButton;
    private Locator Import;
    private Locator export;
    private Locator exportToExcel;
    private Locator file;
    private Locator uploadBtn;

    public ImportAndExportPage(Page page) {

        assetButton = page.getByTestId("MonitorIcon");

        export = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" EXPORT"));

        exportToExcel = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Export to Excel"));

        Import = page.getByText("IMPORT")
                .locator("..");

        file = page.locator("input[type='file']");

        uploadBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload"));

    }

    public void click_AssetButton() {
        assetButton.click();
    }

    public void click_Export() {
        export.click();
    }

    public void click_Export_to_Excel() {
        exportToExcel.click();
    }

    public void click_Import() {
        Import.waitFor();
        Import.click();
    }

    public void uploadFile() {
        file.setInputFiles(Paths.get("C:\\Users\\V00857\\Downloads\\asset_data_export.xlsx"));
    }

    public void click_Update_btn() {
        uploadBtn.click();
    }

}
