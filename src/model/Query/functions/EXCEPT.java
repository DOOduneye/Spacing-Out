package model.Query.functions;

import java.util.function.Function;

public class EXCEPT implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " EXCEPT " + s;
  }

}
