package model.Database.functions;

import java.util.function.Function;

public class ON implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " ON " + s;
  }

}
