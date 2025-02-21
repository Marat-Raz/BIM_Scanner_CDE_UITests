package ui;

import static com.codeborne.selenide.Condition.enabled;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;

public class Steps {

  @Step("Нажать на элемент")
  public void clickOnElement(SelenideElement locator) {
    locator.scrollTo();
    locator.shouldBe(enabled).click();
  }

  @Step("Клик правой кнопки мышки на элемент")
  public void clickRightButtonMouse(SelenideElement locator) {
    locator.shouldBe(enabled).contextClick();
  }

  @Step("Ввод текстового поля")
  public void inputField(SelenideElement locator, String str) {
    locator.hover().shouldBe(enabled).setValue(str);
  }

  public static ArrayList<String> generateTestDataOnBoundariesByCharacterCount(int begin, int end) {
    Set<Integer> charCounts = new HashSet<>();
    charCounts.add(0);
    charCounts.add(begin - 1);
    charCounts.add(begin);
    charCounts.add(begin + 1);
    charCounts.add(begin / 2);
    charCounts.add((begin + end) / 2);
    charCounts.add(end - 1);
    charCounts.add(end);
    charCounts.add(end + 1);
    charCounts.add(end * 2);
    charCounts.removeIf(num -> num < 0);

    ArrayList<String> listString = new ArrayList<>();
    for (Integer charCount : charCounts) {
      listString.add(RandomStringUtils.randomAlphabetic(charCount));
    }
    return listString;
  }


}
