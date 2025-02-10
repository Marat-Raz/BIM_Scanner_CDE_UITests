package ui.pages;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ProjectsPage extends BasePage {

  public ProjectsPage(String pageUrl) {
    super(pageUrl);
  }

  public SelenideElement pageTitle =
      $(By.xpath("//h1[text()='Проекты']")); // todo сделать независимым от локализации
  public SelenideElement addProjectButton =
      $(By.xpath("//span[text()='Создать проект']")); // todo сделать независимым от локализации

  public SelenideElement linkCenterBefore = $x("//a[@href='/problems']");

  public void openPage() {
    Selenide.open("https://bimscannercde.frontend.test.briodev.ru/");
  }
  public void waitForLoadProjectsPage() {
    pageTitle.shouldBe(visible);
  }


  public SelenideElement projectPageLink = $x("//a[@aria-current='page']");

}
