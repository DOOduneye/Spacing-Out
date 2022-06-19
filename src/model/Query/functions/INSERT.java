package model.Query.functions;

import java.util.function.Function;

public class INSERT implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " INSERT INTO " + s;
  }

}

