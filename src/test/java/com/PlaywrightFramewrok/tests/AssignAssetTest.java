package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.AssignAssetPage;

public class AssignAssetTest extends BaseTest {
    @Test
    public void AssignAsset() {
        // Login
        login();

        // Assign Asset
        AssignAssetPage assignAssetPage = new AssignAssetPage(page);

        assignAssetPage.click_Asset_button();
        assignAssetPage.click_Assign_button();
        assignAssetPage.click_Select_employee();
        assignAssetPage.click_Assign();
    }
}
