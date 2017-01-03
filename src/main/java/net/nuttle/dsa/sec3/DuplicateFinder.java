package net.nuttle.dsa.sec3;

public class DuplicateFinder {

  public static boolean hasDuplicateCharacters(String s) {
    String curr = null;
    for (int i = 0; i < s.length(); i++) {
      curr = s.substring(i, i+1);
      for (int j = i + 1; j < s.length(); j++) {
        if (s.substring(j, j+1).equals(curr)) {
          return true;
        }
      }
    }
    return false;
  }
}
