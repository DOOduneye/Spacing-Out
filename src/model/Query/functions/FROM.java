package model.Query.functions;

import java.util.function.Function;

public class FROM implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " FROM " + s;
  }

}
