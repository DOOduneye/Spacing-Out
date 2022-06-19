package model.Query.functions;

import java.util.function.Function;

public class HAVING implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " HAVING " + s;
  }
}
