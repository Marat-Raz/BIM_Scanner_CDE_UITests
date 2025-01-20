import static models.user.UserType.DEFAULT_USER;

import api.base.Client;
import api.client.TokenClient;
import api.client.UserClient;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import models.token.TokenBuilder;
import models.user.User;
import models.user.UserFactory;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.App;


public class StartTests {

  private static TokenClient tokenClient = new TokenClient();
  protected static App app;
  protected static User defaultUser;
  protected static String userId;
  protected static ValidatableResponse baseResponse;
  protected static UserClient userClient = new UserClient();
  protected static UserFactory userFactory = new UserFactory();

  @BeforeSuite
  @Step("Запуск Allure и логирования запросов по API, \n"
      + "получение токена пользователя admin для запросов, требующих прав админа, \n"
      + "создание пользователя по умолчанию.\n")
  public static void globalSetUp() {
    RestAssured.filters(
        new RequestLoggingFilter(), new ResponseLoggingFilter(),
        new AllureRestAssured());
    app  = new App();
    ValidatableResponse responseAdminToken =
        tokenClient.createToken(TokenBuilder.getTokenForAdminUser());
    Client.ADMIN_ACCESS_TOKEN = responseAdminToken.extract().path("access_token");
    defaultUser = userFactory.createUser(DEFAULT_USER);
    baseResponse = userClient.createUser(defaultUser);
    userId = baseResponse.extract().path("id");
    ValidatableResponse responseToken =
        tokenClient.createToken(TokenBuilder.getTokenForUser(defaultUser));
    Client.DEFAULT_USER_ACCESS_TOKEN = responseToken.extract().path("access_token");
    // todo выдать для user права на создание проектов раздел permission
  }


  @AfterSuite
  @Step("Удаление профиля пользователя")
  public static void deleteUser() {
    userClient.deleteUser(userId);
  }

}