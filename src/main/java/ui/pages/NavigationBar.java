package ui.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

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
  public SelenideElement collapseBtn = $("button[class*='my-4']");

  default BoardPage clickOnBoardLink() {
    boardLink.click();
    return page(BoardPage.class);
  }

  default TasksPage clickOnTasksLink() {
    tasksLink.click();
    return page(TasksPage.class);
  }

  default StatisticsPage clickOnStatisticsLink() {
    statisticsLink.click();
    return page(StatisticsPage.class);
  }

  default ModelsPage clickOnModelsLink() {
    modelsLink.click();
    return page(ModelsPage.class);
  }

  default MembersPage clickOnMembersLink() {
    membersLink.click();
    return page(MembersPage.class);
  }

  default LibraryPage clickOnLibraryLink() {
    libraryLink.click();
    return page(LibraryPage.class);
  }

  default TemplatesPage clickOnTemplatesLink() {
    templatesLink.click();
    return page(TemplatesPage.class);
  }

  default void clickOnCollapseBtn() {
    collapseBtn.click();
  }
}
