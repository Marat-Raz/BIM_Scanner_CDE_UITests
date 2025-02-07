package ui;

import ui.pages.LoginPage;
import ui.pages.ProjectsPage;

public class PageBuilder {

  public static LoginPage buildLoginPage() {
    return new LoginPage("https://cde-auth.test.briodev.ru/Account/Login");
  }

  static ProjectsPage buildProjectsPage() {
    return new ProjectsPage("https://bimscannercde.frontend.test.briodev.ru");
  }

}
