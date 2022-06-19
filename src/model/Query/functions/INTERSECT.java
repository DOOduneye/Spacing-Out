package model.Query.functions;

import java.util.function.Function;

public class INTERSECT implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " INTERSECT " + s;
  }

}
