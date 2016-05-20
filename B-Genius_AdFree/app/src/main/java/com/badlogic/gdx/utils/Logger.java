package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class Logger
{
  public static final int DEBUG = 3;
  public static final int ERROR = 1;
  public static final int INFO = 2;
  public static final int NONE;
  private int level;
  private final String tag;

  public Logger(String paramString)
  {
    this(paramString, 1);
  }

  public Logger(String paramString, int paramInt)
  {
    this.tag = paramString;
    this.level = paramInt;
  }

  public void debug(String paramString)
  {
    if (this.level >= 3)
      Gdx.app.debug(this.tag, paramString);
  }

  public void debug(String paramString, Exception paramException)
  {
    if (this.level >= 3)
      Gdx.app.debug(this.tag, paramString, paramException);
  }

  public void error(String paramString)
  {
    if (this.level > 0)
      Gdx.app.error(this.tag, paramString);
  }

  public void error(String paramString, Throwable paramThrowable)
  {
    if (this.level > 0)
      Gdx.app.error(this.tag, paramString, paramThrowable);
  }

  public int getLevel()
  {
    return this.level;
  }

  public void info(String paramString)
  {
    if (this.level >= 2)
      Gdx.app.log(this.tag, paramString);
  }

  public void info(String paramString, Exception paramException)
  {
    if (this.level >= 2)
      Gdx.app.log(this.tag, paramString, paramException);
  }

  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Logger
 * JD-Core Version:    0.6.0
 */