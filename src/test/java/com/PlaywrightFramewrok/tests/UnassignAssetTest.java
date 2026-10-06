package com.PlaywrightFramewrok.tests;

import org.testng.annotations.Test;
import com.PlaywrightFramewrok.base.BaseTest;
import com.PlaywrightFramewrok.page.UnassignAssetPage;

public class UnassignAssetTest extends BaseTest {
    @Test
    public void Unassign() {

        // Login
        login();

        // Unassign
        UnassignAssetPage unassignAssetPage = new UnassignAssetPage(page);

        unassignAssetPage.ClickemployeeBtn();
        unassignAssetPage.ClickassignBtn();
        unassignAssetPage.ClickcheckBox();
        unassignAssetPage.ClickunAssign();
    }
}
