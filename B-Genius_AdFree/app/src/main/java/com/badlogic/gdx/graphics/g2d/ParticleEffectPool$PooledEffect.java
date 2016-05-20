package com.badlogic.gdx.graphics.g2d;

public class ParticleEffectPool$PooledEffect extends ParticleEffect
{
  ParticleEffectPool$PooledEffect(ParticleEffectPool paramParticleEffectPool, ParticleEffect paramParticleEffect)
  {
    super(paramParticleEffect);
  }

  public void free()
  {
    this.this$0.free(this);
  }

  public void reset()
  {
    super.reset();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect
 * JD-Core Version:    0.6.0
 */