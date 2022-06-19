package model.Query.functions;

import java.util.function.Function;

public class AND implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " AND " + s;
  }
}
