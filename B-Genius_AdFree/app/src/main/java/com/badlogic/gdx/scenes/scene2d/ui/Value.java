package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Value
{
  public static Value maxHeight;
  public static Value maxWidth;
  public static Value minHeight;
  public static Value minWidth;
  public static Value prefHeight;
  public static Value prefWidth;
  public static final Value.Fixed zero = new Value.Fixed(0.0F);

  static
  {
    minWidth = new Value.1();
    minHeight = new Value.2();
    prefWidth = new Value.3();
    prefHeight = new Value.4();
    maxWidth = new Value.5();
    maxHeight = new Value.6();
  }

  public static Value percentHeight(float paramFloat)
  {
    return new Value.8(paramFloat);
  }

  public static Value percentHeight(float paramFloat, Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    return new Value.10(paramActor, paramFloat);
  }

  public static Value percentWidth(float paramFloat)
  {
    return new Value.7(paramFloat);
  }

  public static Value percentWidth(float paramFloat, Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    return new Value.9(paramActor, paramFloat);
  }

  public abstract float get(Actor paramActor);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Value
 * JD-Core Version:    0.6.0
 */