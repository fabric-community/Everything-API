package io.github.fabriccommunity.everything;

public class PrintAPIUnitTest {

  public void ExecuteUnitTests(int count){
    for(int i=count;i>=0;i--){
      PrintAPI api=new PrintAPIBuilder().build();
      api.accept("Is valoeghese fat?");
      if(Math.random()<0.1)throw new AssertionError();
    }
  }
}
