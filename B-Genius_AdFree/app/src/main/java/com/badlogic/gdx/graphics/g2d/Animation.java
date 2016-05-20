package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Animation
{
  private float animationDuration;
  private float frameDuration;
  final TextureRegion[] keyFrames;
  private int lastFrameNumber;
  private float lastStateTime;
  private Animation.PlayMode playMode = Animation.PlayMode.NORMAL;

  public Animation(float paramFloat, Array paramArray)
  {
    this.frameDuration = paramFloat;
    this.animationDuration = (paramFloat * paramArray.size);
    this.keyFrames = new TextureRegion[paramArray.size];
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
      this.keyFrames[j] = ((TextureRegion)paramArray.get(j));
    this.playMode = Animation.PlayMode.NORMAL;
  }

  public Animation(float paramFloat, Array paramArray, Animation.PlayMode paramPlayMode)
  {
    this.frameDuration = paramFloat;
    this.animationDuration = (paramFloat * paramArray.size);
    this.keyFrames = new TextureRegion[paramArray.size];
    int i = paramArray.size;
    for (int j = 0; j < i; j++)
      this.keyFrames[j] = ((TextureRegion)paramArray.get(j));
    this.playMode = paramPlayMode;
  }

  public Animation(float paramFloat, TextureRegion[] paramArrayOfTextureRegion)
  {
    this.frameDuration = paramFloat;
    this.animationDuration = (paramFloat * paramArrayOfTextureRegion.length);
    this.keyFrames = paramArrayOfTextureRegion;
    this.playMode = Animation.PlayMode.NORMAL;
  }

  public float getAnimationDuration()
  {
    return this.animationDuration;
  }

  public float getFrameDuration()
  {
    return this.frameDuration;
  }

  public TextureRegion getKeyFrame(float paramFloat)
  {
    int i = getKeyFrameIndex(paramFloat);
    return this.keyFrames[i];
  }

  public TextureRegion getKeyFrame(float paramFloat, boolean paramBoolean)
  {
    Animation.PlayMode localPlayMode = this.playMode;
    if ((paramBoolean) && ((this.playMode == Animation.PlayMode.NORMAL) || (this.playMode == Animation.PlayMode.REVERSED)))
    {
      if (this.playMode == Animation.PlayMode.NORMAL)
        break label105;
      this.playMode = Animation.PlayMode.LOOP_REVERSED;
    }
    while (true)
    {
      TextureRegion localTextureRegion = getKeyFrame(paramFloat);
      this.playMode = localPlayMode;
      return localTextureRegion;
      if ((paramBoolean) || (this.playMode == Animation.PlayMode.NORMAL) || (this.playMode == Animation.PlayMode.REVERSED))
        continue;
      if (this.playMode == Animation.PlayMode.LOOP_REVERSED)
      {
        this.playMode = Animation.PlayMode.REVERSED;
        continue;
      }
      label105: this.playMode = Animation.PlayMode.LOOP;
    }
  }

  public int getKeyFrameIndex(float paramFloat)
  {
    if (this.keyFrames.length == 1)
      return 0;
    int i = (int)(paramFloat / this.frameDuration);
    switch (Animation.1.$SwitchMap$com$badlogic$gdx$graphics$g2d$Animation$PlayMode[this.playMode.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      this.lastFrameNumber = i;
      this.lastStateTime = paramFloat;
      return i;
      i = Math.min(-1 + this.keyFrames.length, i);
      continue;
      i %= this.keyFrames.length;
      continue;
      i %= (-2 + (this.keyFrames.length << 1));
      if (i < this.keyFrames.length)
        continue;
      i = -2 + this.keyFrames.length - (i - this.keyFrames.length);
      continue;
      if ((int)(this.lastStateTime / this.frameDuration) != i)
      {
        i = MathUtils.random(-1 + this.keyFrames.length);
        continue;
      }
      i = this.lastFrameNumber;
      continue;
      i = Math.max(-1 + (this.keyFrames.length - i), 0);
      continue;
      int j = i % this.keyFrames.length;
      i = -1 + (this.keyFrames.length - j);
    }
  }

  public TextureRegion[] getKeyFrames()
  {
    return this.keyFrames;
  }

  public Animation.PlayMode getPlayMode()
  {
    return this.playMode;
  }

  public boolean isAnimationFinished(float paramFloat)
  {
    int i = (int)(paramFloat / this.frameDuration);
    return -1 + this.keyFrames.length < i;
  }

  public void setFrameDuration(float paramFloat)
  {
    this.frameDuration = paramFloat;
    this.animationDuration = (paramFloat * this.keyFrames.length);
  }

  public void setPlayMode(Animation.PlayMode paramPlayMode)
  {
    this.playMode = paramPlayMode;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.Animation
 * JD-Core Version:    0.6.0
 */