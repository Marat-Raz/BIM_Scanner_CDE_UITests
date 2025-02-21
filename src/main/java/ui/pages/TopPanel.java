package ui.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;

public interface TopPanel extends LanguageAndThemeBtn {

  // todo поменять все локаторы после переименования разработчиками
  SelenideElement bimScannerBtn = $x("//a[@href='/']");
  SelenideElement themeToggleLight = $("button[data-testid='theme-toggle-light']");
  SelenideElement themeToggleDark = $("button[data-testid='theme-toggle-dark']");
  // todo для поиска проекта по тексту: SelenideElement divReactSelectOption = $(byText("амфук"));
  SelenideElement projectDropDown =
      $("div[class='flex items-center justify-between'] .p-2");

  default ProjectsPage clickOnBimScanner() {
    bimScannerBtn.click();
    return page(ProjectsPage.class);
  }

  default void selectProjectOnDropDown(String project) {
    projectDropDown.click();  // todo реализовать клик по списку, выбор элемента списка по тексту, проверить работу
    projectDropDown.find(withText(project)).parent().click();
  }

  default boolean lightThemeIsActive() {
    themeToggleLight.shouldBe(visible);
    return themeToggleLight.isDisplayed();
  }

  default boolean darkThemeIsActive() {
    themeToggleDark.shouldBe(visible);
    return themeToggleDark.isDisplayed();
  }

}
