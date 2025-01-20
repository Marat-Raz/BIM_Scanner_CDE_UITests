package api.client;

import static io.restassured.RestAssured.given;

import api.base.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.project.Project;
import models.project.ProjectWithConcurrencyStamp;

public class ProjectsClient extends Client {
  private static final String PROJECTS = "api/projects/";

  @Step("Получить список всех проектов DEFAULT_USER")
  public ValidatableResponse getListOfProjects() {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(DEFAULT_USER_ACCESS_TOKEN)
        .when()
        .get(PROJECTS)
        .then();
  }

  @Step("Получить список всех проектов по токену для любого пользователя")
  public ValidatableResponse getListOfProjects(String token) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(token)
        .when()
        .get(PROJECTS)
        .then();
  }

  @Step("Создать проект с токеном пользователя по умолчанию")
  public ValidatableResponse createProject(Project project) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(DEFAULT_USER_ACCESS_TOKEN)
        .body(project)
        .when()
        .post(PROJECTS)
        .then();
  }

  @Step("Создать проект с любым токеном")
  public ValidatableResponse createProject(String token, Project project) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(token)
        .body(project)
        .when()
        .post(PROJECTS)
        .then();
  }

  @Step("Получить проект по его id")
  public ValidatableResponse getProjectByItsId(String id) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(DEFAULT_USER_ACCESS_TOKEN)
        .when()
        .get(PROJECTS + id)
        .then();
  }

  @Step("Удалить проект по его id")
  public ValidatableResponse deleteProjectByItsId(String id) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(DEFAULT_USER_ACCESS_TOKEN)
        .when()
        .delete(PROJECTS + id)
        .then();
  }

  @Step("Удалить проект по его id с любым токеном")
  public ValidatableResponse deleteProjectByItsId(String token, String id) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(token)
        .when()
        .delete(PROJECTS + id)
        .then();
  }

  @Step("Удалить проект по его id")
  public ValidatableResponse putProjectByItsId(String id,
      ProjectWithConcurrencyStamp project) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(ADMIN_ACCESS_TOKEN)
        .body(project)
        .when()
        .put(PROJECTS + id)
        .then();
  }

  @Step("Удалить проект по его id")
  public ValidatableResponse putProjectByItsId(String token, String id,
      ProjectWithConcurrencyStamp newProject) {
    return given()
        .spec(getBaseSpec())
        .auth().oauth2(ADMIN_ACCESS_TOKEN)
        .body(newProject)
        .when()
        .put(PROJECTS + id)
        .then();
  }

}
