package com.PlaywrightFramewrok.tests;

import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.AddassetPage;
import org.testng.annotations.Test;

public class AddAssetTest extends BaseTest {
    @Test
    public void addAsset() {
        // Login

        login();

        // Add Asset
        AddassetPage addassetPage = new AddassetPage(page);

        addassetPage.click_asset_btn();
        addassetPage.click_add_asset_btn();
        addassetPage.enter_Asset_Name("Laptop");
        addassetPage.enter_Serial_No("AssetSerialNo1");
        addassetPage.enter_Location("Chennai");
        addassetPage.enter_Asset_Type("Laptop");
        addassetPage.click_Asset_Type_Option();
        addassetPage.enter_Operating_System("Windows11");
        addassetPage.enter_Model_Name("HP12345");
        addassetPage.enter_Purchase_Date("2000-07-18");
        addassetPage.enter_Warranty_Date("2004-07-18");
        addassetPage.enter_Asset_Sourced_BY("Vendor");
        addassetPage.click_Asset_Sourced_BY_Option();
        addassetPage.click_Add_Button();

        page.waitForTimeout(3000);
    }
}