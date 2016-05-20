package com.badlogic.gdx.graphics.profiling;

public abstract interface GLErrorListener
{
  public static final GLErrorListener LOGGING_LISTENER = new GLErrorListener.1();
  public static final GLErrorListener THROWING_LISTENER = new GLErrorListener.2();

  public abstract void onError(int paramInt);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.profiling.GLErrorListener
 * JD-Core Version:    0.6.0
 */