package model.Query.functions;

import java.util.function.Function;

public class SELECT implements Function<String, String> {

  @Override
  public String apply(String columns) {
    return "SELECT " + columns;
  }

}