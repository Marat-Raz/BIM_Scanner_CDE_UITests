package ui.pages;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static ui.AppConfig.baseUrl;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        Selenide.open(baseUrl);
    }


}
