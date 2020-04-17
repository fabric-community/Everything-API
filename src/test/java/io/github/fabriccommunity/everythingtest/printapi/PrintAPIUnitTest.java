package io.github.fabriccommunity.everythingtest.printapi;

import io.github.fabriccommunity.everything.api.console.PrintManager;
import io.github.fabriccommunity.everything.api.console.PrintManagerBuilder;

public class PrintAPIUnitTest {

  public void ExecuteUnitTests(int count){
    for(int i=count;i>=0;i--){
      PrintManager api=new PrintManagerBuilder().build();
      api.accept("Is valoeghese fat?");
      if(Math.random()<0.1)throw new AssertionError();
    }
  }
}
