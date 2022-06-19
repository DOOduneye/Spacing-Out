package model.Query.functions;

import java.util.function.Function;

public class JOIN implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " JOIN " + s;
  }

}
