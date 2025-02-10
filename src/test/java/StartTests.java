import static api.models.user.UserType.DEFAULT_USER;

import api.base.Client;
import api.client.TokenClient;
import api.client.UserClient;
import api.models.token.TokenBuilder;
import api.models.user.User;
import api.models.user.UserFactory;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ui.App;

public class StartTests {

  private final TokenClient tokenClient = new TokenClient();
  protected App app;
  protected User defaultUser;
  protected String userId;
  protected ValidatableResponse baseResponse;
  protected UserClient userClient = new UserClient();
  protected UserFactory userFactory = new UserFactory();

  @BeforeTest
  @Step("Запуск Allure и логирования запросов по API, \n"
      + "получение токена пользователя admin для запросов, требующих прав админа, \n")
  public void globalSetUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(),
        new AllureRestAssured());
    app = new App();
    ValidatableResponse responseAdminToken = tokenClient.createToken(
        TokenBuilder.getTokenForAdminUser());
    Client.ADMIN_ACCESS_TOKEN = responseAdminToken.extract().path("access_token");
  }

  @BeforeMethod
  @Step("Создание пользователя")
  public void createUser() {
    defaultUser = userFactory.createUser(DEFAULT_USER);
    baseResponse = userClient.createUser(defaultUser);
    userId = baseResponse.extract().path("id");
  }

  @AfterMethod
  @Step("Удаление пользователя, очитка браузера")
  public void cleanData() {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
    userClient.deleteUser(userId);
  }

}
