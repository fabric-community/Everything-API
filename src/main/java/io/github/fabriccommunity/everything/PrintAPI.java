package io.github.fabriccommunity.everything;

public class PrintAPI implements Consumer<String> {

  @Override
  public void accept(String readFromConsole){
    System.out.println(readFromConsole);
  }

}
