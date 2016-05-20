package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.math.MathUtils;

public class AnimationController$AnimationDesc
{
  public Animation animation;
  public float duration;
  public AnimationController.AnimationListener listener;
  public int loopCount;
  public float offset;
  public float speed;
  public float time;

  protected float update(float paramFloat)
  {
    if ((this.loopCount != 0) && (this.animation != null))
    {
      float f1 = paramFloat * this.speed;
      int i;
      if (!MathUtils.isZero(this.duration))
      {
        this.time = (f1 + this.time);
        i = (int)Math.abs(this.time / this.duration);
        if (this.time < 0.0F)
        {
          i++;
          while (this.time < 0.0F)
            this.time += this.duration;
        }
        this.time = Math.abs(this.time % this.duration);
      }
      for (int j = 0; ; j++)
      {
        float f2 = 0.0F;
        float f4;
        label199: float f5;
        float f6;
        if (j < i)
        {
          if (this.loopCount > 0)
            this.loopCount = (-1 + this.loopCount);
          if ((this.loopCount != 0) && (this.listener != null))
            this.listener.onLoop(this);
          if (this.loopCount != 0)
            continue;
          float f3 = (i - 1 - j) * this.duration;
          if (f1 >= 0.0F)
            break label250;
          f4 = this.duration - this.time;
          f5 = f3 + f4;
          if (f1 >= 0.0F)
            break label259;
          f6 = 0.0F;
        }
        while (true)
        {
          this.time = f6;
          if (this.listener != null)
            this.listener.onEnd(this);
          f2 = f5;
          return f2;
          i = 1;
          break;
          label250: f4 = this.time;
          break label199;
          label259: f6 = this.duration;
        }
      }
    }
    return paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc
 * JD-Core Version:    0.6.0
 */