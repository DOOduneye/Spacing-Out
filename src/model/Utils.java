package model;

import java.util.Arrays;
import java.util.List;

public class Utils {

  @SafeVarargs
  public static <T> T[] requireNonNulls(T... objs) {
    for (T obj : objs) {
      if (obj == null)
        throw new IllegalArgumentException("Argument cannot be null");
    }
    return objs;
  }

  public static <T> boolean compareList(List<T> a, List<T> b) {
    Utils.requireNonNulls(a, b);

    T[] arr1 = (T[]) a.toArray(new Object[0]);
    T[] arr2 = (T[]) b.toArray(new Object[0]);

    if (a.size() != b.size()) {
      return false;
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    return Arrays.equals(arr1, arr2);
  }
}
