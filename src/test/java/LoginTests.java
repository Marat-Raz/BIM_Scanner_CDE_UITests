import base.StartTests;
import org.testng.annotations.Test;

public class LoginTests extends StartTests {

  @Test(groups = "smoke",
      description = "Вход в аккаунт по нажатию Enter в поле ввода пароля")
  public void loginWithEnterOpenProjectPageTest() {
    app.loginPage.open();
    app.loginPage.loginWithEnter(defaultUser.getUserName(), defaultUser.getPassword());

    app.projectsPage.projectsPagePageTitleIsDisplayed();
  }

  @Test(groups = "smoke",
      description = "Вход в аккаунт по нажатию кнопки «Войти»")
  // todo @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/PBM-57")
  public void loginWithSignInButtonOpenProjectPageTest() {
    app.loginPage.open();
    app.loginPage.loginWithSignInButton(defaultUser.getUserName(), defaultUser.getPassword());

    app.projectsPage.projectsPagePageTitleIsDisplayed();
  }


}
