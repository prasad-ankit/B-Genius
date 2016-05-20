package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.utils.TimeUtils;

public class FPSLogger
{
  long startTime = TimeUtils.nanoTime();

  public void log()
  {
    if (TimeUtils.nanoTime() - this.startTime > 1000000000L)
    {
      Gdx.app.log("FPSLogger", "fps: " + Gdx.graphics.getFramesPerSecond());
      this.startTime = TimeUtils.nanoTime();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.FPSLogger
 * JD-Core Version:    0.6.0
 */