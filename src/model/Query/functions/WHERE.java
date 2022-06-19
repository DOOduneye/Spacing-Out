package model.Query.functions;

import java.util.function.Function;

public class WHERE implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " WHERE " + s;
  }

}
