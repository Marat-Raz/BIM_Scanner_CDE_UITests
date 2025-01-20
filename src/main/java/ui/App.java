package ui;

import ui.pages.LoginPage;
import ui.pages.ProjectsPage;

public class App {

  public LoginPage loginPage;
  public ProjectsPage projectsPage;

  public App() {
    loginPage = PageBuilder.buildLoginPage();
    projectsPage = PageBuilder.buildProjectsPage();
  }
}
