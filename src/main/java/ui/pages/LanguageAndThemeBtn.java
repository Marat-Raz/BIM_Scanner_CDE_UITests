package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public interface LanguageAndThemeBtn {
  
  public SelenideElement themeToggle = $("button[data-testid='theme-toggle']");
  public SelenideElement languageBtn = $("a[type='button']");


  default void clickOnThemeToggle() {
    themeToggle.click();
  }


  default void clickOnLanguageBtn() {
    languageBtn.click();
  }

}
