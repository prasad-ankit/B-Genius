package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;

public class AnimationController extends BaseAnimationController
{
  public boolean allowSameAnimation;
  protected final Pool animationPool = new AnimationController.1(this);
  public AnimationController.AnimationDesc current;
  public boolean inAction;
  private boolean justChangedAnimation = false;
  public boolean paused;
  public AnimationController.AnimationDesc previous;
  public AnimationController.AnimationDesc queued;
  public float queuedTransitionTime;
  public float transitionCurrentTime;
  public float transitionTargetTime;

  public AnimationController(ModelInstance paramModelInstance)
  {
    super(paramModelInstance);
  }

  private AnimationController.AnimationDesc obtain(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener)
  {
    if (paramAnimation == null)
      return null;
    AnimationController.AnimationDesc localAnimationDesc = (AnimationController.AnimationDesc)this.animationPool.obtain();
    localAnimationDesc.animation = paramAnimation;
    localAnimationDesc.listener = paramAnimationListener;
    localAnimationDesc.loopCount = paramInt;
    localAnimationDesc.speed = paramFloat3;
    localAnimationDesc.offset = paramFloat1;
    if (paramFloat2 < 0.0F)
      paramFloat2 = paramAnimation.duration - paramFloat1;
    localAnimationDesc.duration = paramFloat2;
    boolean bool = paramFloat3 < 0.0F;
    float f = 0.0F;
    if (bool)
      f = localAnimationDesc.duration;
    localAnimationDesc.time = f;
    return localAnimationDesc;
  }

  private AnimationController.AnimationDesc obtain(AnimationController.AnimationDesc paramAnimationDesc)
  {
    return obtain(paramAnimationDesc.animation, paramAnimationDesc.offset, paramAnimationDesc.duration, paramAnimationDesc.loopCount, paramAnimationDesc.speed, paramAnimationDesc.listener);
  }

  private AnimationController.AnimationDesc obtain(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener)
  {
    if (paramString == null)
      return null;
    Animation localAnimation = this.target.getAnimation(paramString);
    if (localAnimation == null)
      throw new GdxRuntimeException("Unknown animation: " + paramString);
    return obtain(localAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener);
  }

  protected AnimationController.AnimationDesc action(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return action(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  protected AnimationController.AnimationDesc action(AnimationController.AnimationDesc paramAnimationDesc, float paramFloat)
  {
    if (paramAnimationDesc.loopCount < 0)
      throw new GdxRuntimeException("An action cannot be continuous");
    if ((this.current == null) || (this.current.loopCount == 0))
    {
      animate(paramAnimationDesc, paramFloat);
      return paramAnimationDesc;
    }
    if (this.inAction);
    for (AnimationController.AnimationDesc localAnimationDesc = null; ; localAnimationDesc = obtain(this.current))
    {
      this.inAction = false;
      animate(paramAnimationDesc, paramFloat);
      this.inAction = true;
      if (localAnimationDesc == null)
        break;
      queue(localAnimationDesc, paramFloat);
      return paramAnimationDesc;
    }
  }

  public AnimationController.AnimationDesc action(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return action(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  public AnimationController.AnimationDesc action(String paramString, int paramInt, float paramFloat1, AnimationController.AnimationListener paramAnimationListener, float paramFloat2)
  {
    return action(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
  }

  protected AnimationController.AnimationDesc animate(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return animate(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  protected AnimationController.AnimationDesc animate(AnimationController.AnimationDesc paramAnimationDesc, float paramFloat)
  {
    if (this.current == null)
    {
      this.current = paramAnimationDesc;
      return paramAnimationDesc;
    }
    if (this.inAction)
    {
      queue(paramAnimationDesc, paramFloat);
      return paramAnimationDesc;
    }
    if ((!this.allowSameAnimation) && (paramAnimationDesc != null) && (this.current.animation == paramAnimationDesc.animation))
    {
      paramAnimationDesc.time = this.current.time;
      this.animationPool.free(this.current);
      this.current = paramAnimationDesc;
      return paramAnimationDesc;
    }
    if (this.previous != null)
    {
      removeAnimation(this.previous.animation);
      this.animationPool.free(this.previous);
    }
    this.previous = this.current;
    this.current = paramAnimationDesc;
    this.transitionCurrentTime = 0.0F;
    this.transitionTargetTime = paramFloat;
    return paramAnimationDesc;
  }

  public AnimationController.AnimationDesc animate(String paramString, float paramFloat)
  {
    return animate(paramString, 1, 1.0F, null, paramFloat);
  }

  public AnimationController.AnimationDesc animate(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return animate(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  public AnimationController.AnimationDesc animate(String paramString, int paramInt, float paramFloat1, AnimationController.AnimationListener paramAnimationListener, float paramFloat2)
  {
    return animate(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
  }

  public AnimationController.AnimationDesc animate(String paramString, int paramInt, AnimationController.AnimationListener paramAnimationListener, float paramFloat)
  {
    return animate(paramString, paramInt, 1.0F, paramAnimationListener, paramFloat);
  }

  public AnimationController.AnimationDesc animate(String paramString, AnimationController.AnimationListener paramAnimationListener, float paramFloat)
  {
    return animate(paramString, 1, 1.0F, paramAnimationListener, paramFloat);
  }

  protected AnimationController.AnimationDesc queue(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return queue(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  protected AnimationController.AnimationDesc queue(AnimationController.AnimationDesc paramAnimationDesc, float paramFloat)
  {
    if ((this.current == null) || (this.current.loopCount == 0))
      animate(paramAnimationDesc, paramFloat);
    do
    {
      return paramAnimationDesc;
      if (this.queued != null)
        this.animationPool.free(this.queued);
      this.queued = paramAnimationDesc;
      this.queuedTransitionTime = paramFloat;
    }
    while (this.current.loopCount >= 0);
    this.current.loopCount = 1;
    return paramAnimationDesc;
  }

  public AnimationController.AnimationDesc queue(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener, float paramFloat4)
  {
    return queue(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener), paramFloat4);
  }

  public AnimationController.AnimationDesc queue(String paramString, int paramInt, float paramFloat1, AnimationController.AnimationListener paramAnimationListener, float paramFloat2)
  {
    return queue(paramString, 0.0F, -1.0F, paramInt, paramFloat1, paramAnimationListener, paramFloat2);
  }

  protected AnimationController.AnimationDesc setAnimation(Animation paramAnimation, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener)
  {
    return setAnimation(obtain(paramAnimation, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener));
  }

  protected AnimationController.AnimationDesc setAnimation(AnimationController.AnimationDesc paramAnimationDesc)
  {
    if (this.current == null)
    {
      this.current = paramAnimationDesc;
      this.justChangedAnimation = true;
      return paramAnimationDesc;
    }
    if ((!this.allowSameAnimation) && (paramAnimationDesc != null) && (this.current.animation == paramAnimationDesc.animation))
      paramAnimationDesc.time = this.current.time;
    while (true)
    {
      this.animationPool.free(this.current);
      this.current = paramAnimationDesc;
      break;
      removeAnimation(this.current.animation);
    }
  }

  public AnimationController.AnimationDesc setAnimation(String paramString)
  {
    return setAnimation(paramString, 1, 1.0F, null);
  }

  public AnimationController.AnimationDesc setAnimation(String paramString, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, AnimationController.AnimationListener paramAnimationListener)
  {
    return setAnimation(obtain(paramString, paramFloat1, paramFloat2, paramInt, paramFloat3, paramAnimationListener));
  }

  public AnimationController.AnimationDesc setAnimation(String paramString, int paramInt)
  {
    return setAnimation(paramString, paramInt, 1.0F, null);
  }

  public AnimationController.AnimationDesc setAnimation(String paramString, int paramInt, float paramFloat, AnimationController.AnimationListener paramAnimationListener)
  {
    return setAnimation(paramString, 0.0F, -1.0F, paramInt, paramFloat, paramAnimationListener);
  }

  public AnimationController.AnimationDesc setAnimation(String paramString, int paramInt, AnimationController.AnimationListener paramAnimationListener)
  {
    return setAnimation(paramString, paramInt, 1.0F, paramAnimationListener);
  }

  public AnimationController.AnimationDesc setAnimation(String paramString, AnimationController.AnimationListener paramAnimationListener)
  {
    return setAnimation(paramString, 1, 1.0F, paramAnimationListener);
  }

  public void update(float paramFloat)
  {
    if (this.paused);
    do
    {
      return;
      if (this.previous != null)
      {
        float f2 = paramFloat + this.transitionCurrentTime;
        this.transitionCurrentTime = f2;
        if (f2 >= this.transitionTargetTime)
        {
          removeAnimation(this.previous.animation);
          this.justChangedAnimation = true;
          this.animationPool.free(this.previous);
          this.previous = null;
        }
      }
      if (!this.justChangedAnimation)
        continue;
      this.target.calculateTransforms();
      this.justChangedAnimation = false;
    }
    while ((this.current == null) || (this.current.loopCount == 0) || (this.current.animation == null));
    float f1 = this.current.update(paramFloat);
    if ((f1 != 0.0F) && (this.queued != null))
    {
      this.inAction = false;
      animate(this.queued, this.queuedTransitionTime);
      this.queued = null;
      update(f1);
      return;
    }
    if (this.previous != null)
    {
      applyAnimations(this.previous.animation, this.previous.offset + this.previous.time, this.current.animation, this.current.offset + this.current.time, this.transitionCurrentTime / this.transitionTargetTime);
      return;
    }
    applyAnimation(this.current.animation, this.current.offset + this.current.time);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.AnimationController
 * JD-Core Version:    0.6.0
 */