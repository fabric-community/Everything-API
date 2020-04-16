package io.github.fabriccommunity.everything;

import java.util.function.Consumer;

public class PrintAPI implements Consumer<String> {

  @Override
  public void accept(String readFromConsole){
    System.out.println(readFromConsole);
  }

}
