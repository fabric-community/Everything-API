package io.github.fabriccommunity.everything;

import static io.github.fabriccommunity.everything.functions.QuadFunction.runGc;

public class PrintAPIBuilder{
  
  public PrintAPIBuilder(){
  }
  
  public PrintAPI build(){
    runGc();
    return new PrintAPI();
  }
}
