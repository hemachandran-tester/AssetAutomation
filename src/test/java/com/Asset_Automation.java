package com;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;

public class Asset_Automation {

        Playwright playwright;
        Browser browser;
        BrowserContext context;
        Page page;

        @BeforeMethod
        public void setup() {
                playwright = Playwright.create();
                browser = playwright.chromium().launch(
                                new LaunchOptions().setHeadless(false));
                context = browser.newContext();
                page = context.newPage();
        }

        @Test
        public void LoginPage() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByRole(AriaRole.MAIN)
                                .getByRole(
                                                AriaRole.BUTTON,
                                                new Locator.GetByRoleOptions().setName("Add Asset"))
                                .click();
                assertThat(page.locator("body")).containsText("Add Asset");
                assertThat(page.locator("body")).containsText("Asset Name");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asset Name"))
                                .fill("LaptopAutomation3");
                assertThat(page.locator("body")).containsText("Serial Number");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Serial Number"))
                                .fill("SRNOAUT123453");
                assertThat(page.locator("body")).containsText("Location");
                page.getByPlaceholder("Enter The Location If not in Below List")
                                .fill("chennai");

                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("chennai"))
                                .click();

                assertThat(page.locator("body")).containsText("Asset Type");
                page.getByPlaceholder("Enter The Type If not in Below List")
                                .fill("Laptop");
                page.waitForTimeout(1000);

                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Laptop"))
                                .nth(0).click();
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Operating System"))
                                .fill("Windows11");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Model Name"))
                                .fill("Mdel123Aut");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Purchase Date"))
                                .fill("2000-07-18");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Warranty Date"))
                                .fill("2004-07-18");
                page.getByPlaceholder("Enter The SourcedBy If not in Below List")
                                .fill("Vendor");
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Vendor"))
                                .nth(0).click();
                assertThat(page.locator("body")).containsText("Add");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add"))
                                .click();
                page.waitForTimeout(2000);
        }

        @Test
        public void AddEmployee() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                page.getByTestId("PeopleIcon").click();
                page.getByTestId("AddCircleOutlineIcon").nth(1).click();

                assertThat(page.locator("body")).containsText("Employee ID");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Employee ID")).fill("V01245");

                assertThat(page.locator("body")).containsText("First Name");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Hema");

                assertThat(page.locator("body")).containsText("Last Name");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill("chandran");

                assertThat(page.locator("body")).containsText("Email");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"))
                                .fill("hemachandran12345@gmail.com");

                assertThat(page.locator("body")).containsText("Mobile");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile")).fill("9876543222");

                assertThat(page.locator("body")).containsText("Location");
                page.getByPlaceholder("Enter The Location If not in Below List").fill("Chennai");
                // page.locator("#:r1m:-label").fill("chennai");
                // page.getByRole(AriaRole.TEXTBOX, new
                // Page.GetByRoleOptions().setName("Location")).fill("Chennai");
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Chennai")).nth(0).click();

                assertThat(page.locator("body")).containsText("Department");
                page.getByPlaceholder("Enter The Department If not in Below List").fill("Delivery");
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Delivery")).click();

                assertThat(page.locator("body")).containsText("Designation");
                page.getByPlaceholder("Enter The Designation If not in Below List").fill("QA");
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("QA")).nth(0).click();

                page.locator("label").filter(
                                new Locator.FilterOptions().setHasText("Status"))
                                .locator("xpath=following-sibling::div[1]")
                                .locator("div[role='combobox']")
                                .click();
                page.getByRole(
                                AriaRole.OPTION,
                                new Page.GetByRoleOptions()
                                                .setName("Active")
                                                .setExact(true))
                                .click();
                page.locator("label").filter(
                                new Locator.FilterOptions().setHasText("Role"))
                                .locator("xpath=following-sibling::div[1]")
                                .locator("div[role='combobox']")
                                .click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Admin").setExact(true)).click();

                assertThat(page.locator("body")).containsText("Add");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
                page.waitForTimeout(5000);
                assertThat(page.locator("body")).containsText("hemachandran12345@gmail.com");
        }

        @Test
        public void AssignAsset() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByTestId("VisibilityIcon").nth(1).click();
                page.getByTestId("CloseIcon").click();
                page.getByTestId("PersonAddIcon").nth(0).click();
                page.getByPlaceholder("🔍 Search and Select Employee").fill("V01245 - Hema (Qa)");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Assign Asset")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
                page.getByTestId("HistoryIcon").nth(1).click();
                page.getByTestId("CloseIcon").click();
                page.getByTestId("AppsIcon").click();
                page.getByText("Show Assigned Assets",
                                new Page.GetByTextOptions().setExact(true)).click();
                page.waitForTimeout(5000);

        }

        @Test
        public void Unassign() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByTestId("PersonRemoveIcon").nth(1).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();

                page.waitForTimeout(3000);
        }

        @Test
        public void Export() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByTestId("FileDownloadIcon").click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Export to Excel")).click();
                page.waitForTimeout(5000);
        }

        @Test
        public void Import() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByText("IMPORT")
                                .locator("..")
                                .click();
                assertThat(page.locator("body")).containsText("Import Assets");
                // page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Choose
                // File")).click();
                page.getByText("Choose File").click();

                page.locator("input[type='file']")
                                .setInputFiles(Paths.get("C:\\Users\\V00857\\Downloads\\asset_data_export.xlsx"));
                page.waitForTimeout(5000);
        }

        @Test
        public void Profile() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                page.getByTestId("AccountCircleIcon").click();
                page.getByTestId("LockResetIcon").click();

        }

        @Test
        public void ChangePassword() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                page.getByTestId("AccountCircleIcon").click();
                page.getByTestId("LockResetIcon").click();
                page.getByTestId("CloseIcon").click();
                page.waitForTimeout(3000);
        }

        @Test
        public void ForgotPassword() {

                page.navigate("http://localhost:4200/login");
                page.getByText("Forgot Password?").click();
                page.getByPlaceholder("Enter your Employee Id").fill("V00857");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send OTP")).click();
                page.waitForTimeout(3000);
        }

        @Test
        public void EditAsset() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                page.getByTestId("EditIcon").nth(0).click();
                page.getByRole(
                                AriaRole.COMBOBOX,
                                new Page.GetByRoleOptions().setName("Status")).click();
                page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Scrap")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();
                page.waitForTimeout(3000);
        }

        @Test
        public void DeleteEmployee() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                page.getByTestId("PeopleIcon").click();
                // page.getByTestId("AddCircleOutlineIcon").nth(1).click();
                page.getByTestId("DeleteIcon").nth(0).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
                page.waitForTimeout(3000);
        }

        @Test
        public void NextPage() {
                page.navigate("http://localhost:4200/login");
                assertThat(page.locator("body")).containsText("Asset Manager");
                page.getByPlaceholder("Employee Id")
                                .fill("V00857");
                page.getByPlaceholder("Password")
                                .fill("Hema@123");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                                .click();
                assertThat(page.locator("body")).containsText("Hema");
                assertThat(page.locator("body")).containsText("Verinite - Assets Management");
                page.getByTestId("MonitorIcon")
                                .click();
                Locator nextButton = page.getByRole(
                                AriaRole.BUTTON,
                                new Page.GetByRoleOptions().setName("Go to next page"));

                for (int i = 0; i < 4; i++) {
                        nextButton.click();
                        page.waitForTimeout(1000);
                }
                page.waitForTimeout(3000);
        }

        @AfterMethod
        public void tearDown() {
                playwright.close();
                browser.close();
                context.close();
                page.close();
        }

}
