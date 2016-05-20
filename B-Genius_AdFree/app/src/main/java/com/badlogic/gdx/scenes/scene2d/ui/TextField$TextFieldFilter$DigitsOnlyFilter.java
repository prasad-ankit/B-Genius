package com.badlogic.gdx.scenes.scene2d.ui;

public class TextField$TextFieldFilter$DigitsOnlyFilter
  implements TextField.TextFieldFilter
{
  public boolean acceptChar(TextField paramTextField, char paramChar)
  {
    return Character.isDigit(paramChar);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldFilter.DigitsOnlyFilter
 * JD-Core Version:    0.6.0
 */