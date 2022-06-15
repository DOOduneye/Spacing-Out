package model.Database.functions;

import java.util.function.Function;

public class DELETE implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " DELETE FROM " + s;
  }

}