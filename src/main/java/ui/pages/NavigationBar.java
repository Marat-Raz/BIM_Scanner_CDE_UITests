package ui.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public interface NavigationBar extends LanguageAndThemeBtn {

  // todo поменять все локаторы после переименования разработчиками
  public SelenideElement boardLink = $x("//a[contains(@href, 'board')]");
  public SelenideElement tasksLink = $x(
      "//*[text() = 'Задачи']"); // таких элементов много может быть
  public SelenideElement statisticsLink = $x("//a[contains(@href, 'statistics')]");
  public SelenideElement modelsLink = $x("//a[contains(@href, 'models')]");
  public SelenideElement membersLink = $x("//a[contains(@href, 'members')]");
  public SelenideElement libraryLink = $x("//a[contains(@href, 'library')]");
  public SelenideElement templatesLink = $x("//a[contains(@href, 'templates')]");


}
