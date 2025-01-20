package ui.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  public LoginPage(String pageUrl) {
    super(pageUrl);
  }

  public SelenideElement loginField = $(byName("LoginInput.UserNameOrEmailAddress"));
  public SelenideElement passwordField = $(byName("LoginInput.Password"));
  public SelenideElement signInButton =
      $(By.xpath("//button[text()='Войти']")); // todo сделать независимым от локализации

  @Step("Ввод логина и пароля и нажать на кнопку «Войти»")
  public void loginWithSignInButton(String userName, String password) {
    loginField.setValue(userName);
    passwordField.setValue(password);
    signInButton.click();
  }

  @Step("Ввод логина и пароля и нажать на «Enter»")
  public void loginWithEnter(String userName, String password) {
    loginField.setValue(userName);
    passwordField.setValue(password).pressEnter();
  }

}


