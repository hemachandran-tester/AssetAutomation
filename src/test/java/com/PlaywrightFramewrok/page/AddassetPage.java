package com.PlaywrightFramewrok.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddassetPage {

    private Locator assetName;
    private Locator serialNo;
    private Locator location;
    private Locator locationOption;
    private Locator assetType;
    private Locator assetTypeOption;
    private Locator operatingSystem;
    private Locator modelName;
    private Locator purchaseDate;
    private Locator warrantyDate;
    private Locator assetSourcedBY;
    private Locator assetSourcedBYOption;
    private Locator assetButton;
    private Locator addAssetButton;
    private Locator addButton;

    public AddassetPage(Page page) {

        assetButton = page.getByTestId("MonitorIcon");

        addAssetButton = page.getByTestId("AddCircleOutlineIcon").nth(1);

        assetName = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Asset Name"));

        serialNo = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Serial Number"));

        location = page.getByPlaceholder("Enter The Location If not in Below List");

        locationOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions().setName("chennai"));

        assetType = page.getByPlaceholder("Enter The Type If not in Below List");

        assetTypeOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions().setName("Laptop")).nth(0);

        operatingSystem = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Operating System"));

        modelName = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Model Name"));

        purchaseDate = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Purchase Date"));

        warrantyDate = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("Warranty Date"));

        assetSourcedBY = page.getByPlaceholder("Enter The SourcedBy If not in Below List");

        assetSourcedBYOption = page.getByRole(AriaRole.OPTION,
                new Page.GetByRoleOptions().setName("Vendor")).nth(0);

        addButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add"));
    }

    public void click_asset_btn() {
        assetButton.click();
    }

    public void click_add_asset_btn() {
        addAssetButton.click();
    }

    public void enter_Asset_Name(String Asset_Name_value) {
        assetName.fill(Asset_Name_value);
    }

    public void enter_Serial_No(String Serial_No_value) {
        serialNo.fill(Serial_No_value);
    }

    public void enter_Location(String Location_value) {
        location.fill(Location_value);
    }

    public void click_location_option() {
        locationOption.click();
    }

    public void enter_Asset_Type(String Asset_Type_value) {
        assetType.fill(Asset_Type_value);
    }

    public void click_Asset_Type_Option() {
        assetTypeOption.click();
    }

    public void enter_Operating_System(String Operating_System_value) {
        operatingSystem.fill(Operating_System_value);
    }

    public void enter_Model_Name(String Model_Name_value) {
        modelName.fill(Model_Name_value);
    }

    public void enter_Purchase_Date(String Purchase_Date_value) {
        purchaseDate.fill(Purchase_Date_value);
    }

    public void enter_Warranty_Date(String Warranty_Date_value) {
        warrantyDate.fill(Warranty_Date_value);
    }

    public void enter_Asset_Sourced_BY(String Asset_Sourced_BY_value) {
        assetSourcedBY.fill(Asset_Sourced_BY_value);
    }

    public void click_Asset_Sourced_BY_Option() {
        assetSourcedBYOption.click();
    }

    public void click_Add_Button() {
        addButton.click();
    }

}
