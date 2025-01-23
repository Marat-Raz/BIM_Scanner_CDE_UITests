package ui.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  public SelenideElement loginField = $(byName("LoginInput.UserNameOrEmailAddress"));
  public SelenideElement passwordField = $(byName("LoginInput.Password"));
  public SelenideElement signInButton =
      $("button[name='Action']"); // todo сделать независимым от локализации
  public SelenideElement register =
      $(By.xpath("//a[@href='/Account/Register']"));

  public LoginPage(String pageUrl) {
    super(pageUrl);
  }

  public void openPage() { // todo со временем изменить страницу на страницу авторизации
    Selenide.open("https://bimscannercde.frontend.test.briodev.ru/");
  }

  public void setUsername(String username) {
    loginField.setValue(username);
  }

  public void setPassword(String password) {
    passwordField.setValue(password);
  }

  public void clickSignInButton() {
    signInButton.click();
  }

  @Step("Ввод логина и пароля и нажать на кнопку «Войти»")
  public ProjectsPage loginWithSignInButton(String userName, String password) {
    setUsername(userName);
    setPassword(password);
    clickSignInButton();
    ProjectsPage projectsPage = page(ProjectsPage.class);
    projectsPage.waitForLoadProjectsPage();
    return projectsPage;
  }

  @Step("Ввод логина и пароля и нажать на «Enter»")
  public ProjectsPage loginWithEnter(String userName, String password) {
    setUsername(userName);
    passwordField.setValue(password).pressEnter();
    ProjectsPage projectsPage = page(ProjectsPage.class);
    projectsPage.waitForLoadProjectsPage();
    return projectsPage;
  }
}


