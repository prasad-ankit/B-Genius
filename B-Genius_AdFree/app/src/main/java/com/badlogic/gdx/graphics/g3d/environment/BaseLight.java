package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;

public abstract class BaseLight
{
  public final Color color = new Color(0.0F, 0.0F, 0.0F, 1.0F);

  public BaseLight setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return this;
  }

  public BaseLight setColor(Color paramColor)
  {
    this.color.set(paramColor);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.environment.BaseLight
 * JD-Core Version:    0.6.0
 */