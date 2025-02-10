import static com.codeborne.selenide.Condition.visible;

import org.testng.annotations.Test;

public class LoginTests extends StartTests {

  @Test (groups = "smoke",
      description = "Вход в аккаунт по нажатию Enter в поле ввода пароля")
  public void loginWithEnterOpenProjectPageTest() {
    app.loginPage.open();
    app.loginPage.loginWithEnter(defaultUser.getUserName(), defaultUser.getPassword());
    app.projectsPage.addProjectButton.shouldBe(visible);
  }

  @Test (groups = "smoke",
      description = "Вход в аккаунт по нажатию кнопки «Войти»")
  public void loginWithSignInButtonOpenProjectPageTest() {
    app.loginPage.open();
    app.loginPage.loginWithSignInButton(defaultUser.getUserName(), defaultUser.getPassword());
    app.projectsPage.addProjectButton.shouldBe(visible);
  }


}
