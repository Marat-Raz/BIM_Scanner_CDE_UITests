package ui.pages;

import static com.codeborne.selenide.Selenide.$;

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

}
