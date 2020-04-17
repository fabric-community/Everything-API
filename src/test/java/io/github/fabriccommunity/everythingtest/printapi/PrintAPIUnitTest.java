package io.github.fabriccommunity.everythingtest.printapi;

import io.github.fabriccommunity.everything.PrintAPI;
import io.github.fabriccommunity.everything.PrintAPIBuilder;

public class PrintAPIUnitTest {

  public void ExecuteUnitTests(int count){
    for(int i=count;i>=0;i--){
      PrintAPI api=new PrintAPIBuilder().build();
      api.accept("Is valoeghese fat?");
      if(Math.random()<0.1)throw new AssertionError();
    }
  }
}
