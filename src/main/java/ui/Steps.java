package ui;

import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;

public class Steps {

  public void clickOnBtn() {

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

  public static void main(String[] args) {
    ArrayList<String> list = generateTestDataOnBoundariesByCharacterCount(0, 10);
    System.out.println(list);
  }


}
