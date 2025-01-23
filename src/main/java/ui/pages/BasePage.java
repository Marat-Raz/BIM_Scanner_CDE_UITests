package ui.pages;
import static ui.AppConfig.baseUrl;

import com.codeborne.selenide.Selenide;


public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        Selenide.open(baseUrl);
    }
}
