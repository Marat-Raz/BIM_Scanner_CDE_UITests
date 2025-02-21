package base;

import static api.models.user.UserType.DEFAULT_USER;

import api.base.Client;
import api.client.TokenClient;
import api.client.UserClient;
import api.models.token.TokenBuilder;
import api.models.user.User;
import api.models.user.UserFactory;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import java.net.URI;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ui.App;

//@Log4j2
public class StartTests {

  private final TokenClient tokenClient = new TokenClient();
  protected App app;
  protected User defaultUser;
  protected String userId;
  protected ValidatableResponse baseResponse;
  protected UserClient userClient = new UserClient();
  protected UserFactory userFactory = new UserFactory();
  protected RemoteWebDriver driver;


  @BeforeSuite
  public void globalSetUp() throws Exception {
    String runType = "selenoid";
    switch (runType) {
      case ("local"):
        Configuration.browser = "chrome";
        break;
      case ("selenoid"):
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("66");
        browser.setCapability("enableVNC", true);
        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), browser);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        WebDriverRunner.setWebDriver(driver);
        break;
    }


/*    log.info("Testing started with: " +
        "\nRun Type: " + getRunType() +
        "\nBrowser: " + getBrowser() +
        "\nBase Url: " + getBaseUrl());*/
  }

  @BeforeTest
  @Step("Запуск Allure и логирования запросов по API, \n"
      + "получение токена пользователя admin для запросов, требующих прав админа, \n")
  public void setUp() {
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

  @AfterMethod(alwaysRun = true)
  @Step("Удаление пользователя, очитка браузера")
  public void cleanData() {
    Selenide.clearBrowserCookies();
    Selenide.clearBrowserLocalStorage();
    userClient.deleteUser(userId);
  }

}
