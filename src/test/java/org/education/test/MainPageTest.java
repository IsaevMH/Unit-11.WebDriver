package org.education.test;

import org.education.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends CommonConditions{

    @Test
    public void writeSomeCode(){
        MainPage mainPage = new MainPage(driver)
                .openPage()
                .clickNewPasteBtn()
                .inputTextArea("Hello from WebDriver")
                .selectPasteExpirationFromDropDownList("10 Minutes")
                .inputTitle("helloweb")
                .clickCreateNewPasteBtn();
        Assert.assertNotNull(mainPage);
    }

    @Test
    public void createdPasteIsEqual() {
        String command = "git config --global user.name  \"New Sheriff in Town\"" +
                "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "\ngit push origin master --force";
        MainPage mainPage = new MainPage(driver)
                .openPage()
                .clickNewPasteBtn()
                .inputTextArea(command)
                .selectPastSyntaxHighlightingFromDropDownList("Bash")
                .selectPasteExpirationFromDropDownList("10 Minutes")
                .inputTitle("how to gain dominance among developers")
                .clickCreateNewPasteBtn();

        Assert.assertTrue(true);
    }
}
