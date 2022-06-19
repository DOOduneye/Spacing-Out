package model.Query.functions;

import java.util.function.Function;

public class UNION implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " UNION " + s;
  }
}
