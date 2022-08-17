package com.testing;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;

public class MyPage {

    public SelenideElement myImage = $x("/html/body/div[2]/table[2]/tbody/tr[2]/td/div[2]/form/div/a/img");
    public SelenideElement chooseImage = $x("/html/body/div[2]/table[2]/tbody/tr[2]/td/div[2]/"
            + "form/div/div/label/input");
    public SelenideElement deleteChosen = $x("/html/body/div[2]/table[2]/tbody/tr[2]/td/div[2]/"
            + "div/table/tbody/tr/td[2]/a");
    public SelenideElement imageInNewTab = $x("/html/body/main/div[2]/div[2]/div/div[1]/a/img");

}
