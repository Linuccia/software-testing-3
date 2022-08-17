package com.testing;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public SelenideElement chooseFile = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/form/div/"
            + "div[2]/input");
    public SelenideElement noTitle = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/form/div/"
            + "div[4]/fieldset[1]/label[3]/input");
    public SelenideElement upload = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/form/div/input");
    public SelenideElement imageInfo = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/div[2]");
    public SelenideElement rules = $x("/html/body/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td/div/"
            + "a[2]/div/div[4]");
    public SelenideElement about = $x("/html/body/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td/div/"
            + "a[3]/div/div[4]");
    public SelenideElement donate = $x("/html/body/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td/div/"
            + "a[6]/div/div[4]");
    public SelenideElement addField = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/form/div/div[2]/"
            + "div/a[1]");
    public SelenideElement addedField = $x("/html/body/div[2]/table[2]/tbody/tr[3]/td/div/form/div/"
            + "div[2]/input[2]");

}
