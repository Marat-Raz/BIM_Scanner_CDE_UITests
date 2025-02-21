package ui.pages;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProjectsPage extends BasePage implements TopPanel, LanguageAndThemeBtn {

  // todo поменять все локаторы после переименования разработчиками
  private SelenideElement pageTitle = $x("//h1[text()='Проекты']");
  private SelenideElement addProjectButton = $x("//span[text()='Создать проект']");
  private SelenideElement searchInputField = $x("//input[@placeholder='Поиск']");
  private SelenideElement sortBtnNewFirst = $(byText("Сначала новые"));
  private SelenideElement sortBtnOldestFirst = $(byText("Сначала старые"));
  private SelenideElement sortBtnAToZ = $(byText("от А до Я"));
  private SelenideElement sortBtnZToA = $(byText("от Я до А"));

  public ProjectsPage(String pageUrl) {
    super(pageUrl);
  }

  @Step("Открываем страницу «Проекты»")
  public void openPage() {
    Selenide.open("https://bimscannercde.frontend.test.briodev.ru/");
  }

  @Step("Ждем открытия страницы «Проекты»")
  public void waitForLoadProjectsPage() {
    pageTitle.shouldBe(visible);
  }

  @Step("Заголовок страницы «Проекты» виден?")
  public boolean projectsPagePageTitleIsDisplayed() {
    return pageTitle.shouldBe(visible).isDisplayed();
  }

  @Step("Ввод текста в поле ввода «Поиск»")
  public void enterTextInSearchInputField(String project) {
    searchInputField.shouldBe(visible).setValue(project);
  }

  @Step("Нажимаем на кнопку «Создать проект»")
  public void clickOnAddProjectButton() {
    addProjectButton.click();
  }

  @Step("Нажимаем на кнопку «Сначала новые»")
  public ProjectsPage clickOnSortBtnNewFirst() {
    sortBtnNewFirst.click();
    return this;
  }

  @Step("Нажимаем на кнопку «Сначала старые»")
  public ProjectsPage clickOnSortBtnOldestFirst() {
    sortBtnOldestFirst.click();
    return this;
  }

  @Step("Нажимаем на кнопку «от А до Я»")
  public ProjectsPage clickOnSortBtnAToZ() {
    sortBtnAToZ.click();
    return this;
  }

  @Step("Нажимаем на кнопку «от Я до А»")
  public ProjectsPage clickOnSortBtnZToA() {
    sortBtnZToA.click();
    return this;
  }

}
