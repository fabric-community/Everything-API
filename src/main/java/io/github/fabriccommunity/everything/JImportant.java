package io.github.fabriccommunity.everything;

public interface JImportant {

  /* yes or no */
  boolean isImportant();
  
  /* range from double.min_value to byte.max_value */
  double importantness();
  
  /* range from -4 to int.max_value */
  int volatility();
  
}
