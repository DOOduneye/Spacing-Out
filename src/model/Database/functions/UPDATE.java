package model.Database.functions;

import java.util.function.Function;

public class UPDATE implements Function<String, String> {

  @Override
  public String apply(String s) {
    return "UPDATE " + s;
  }

}
