package com.badlogic.gdx.graphics.g3d.particles.emitters;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class RegularEmitter extends Emitter
  implements Json.Serializable
{
  private boolean continuous;
  protected float delay;
  protected float delayTimer;
  public RangedNumericValue delayValue = new RangedNumericValue();
  protected float duration;
  protected float durationTimer;
  public RangedNumericValue durationValue = new RangedNumericValue();
  protected int emission;
  protected int emissionDelta;
  protected int emissionDiff;
  private RegularEmitter.EmissionMode emissionMode;
  public ScaledNumericValue emissionValue = new ScaledNumericValue();
  protected int life;
  private ParallelArray.FloatChannel lifeChannel;
  protected int lifeDiff;
  protected int lifeOffset;
  protected int lifeOffsetDiff;
  public ScaledNumericValue lifeOffsetValue = new ScaledNumericValue();
  public ScaledNumericValue lifeValue = new ScaledNumericValue();

  public RegularEmitter()
  {
    this.durationValue.setActive(true);
    this.emissionValue.setActive(true);
    this.lifeValue.setActive(true);
    this.continuous = true;
    this.emissionMode = RegularEmitter.EmissionMode.Enabled;
  }

  public RegularEmitter(RegularEmitter paramRegularEmitter)
  {
    this();
    set(paramRegularEmitter);
  }

  private void addParticles(int paramInt)
  {
    int i = Math.min(paramInt, this.maxParticleCount - this.controller.particles.size);
    if (i <= 0)
      return;
    this.controller.activateParticles(this.controller.particles.size, i);
    ParallelArray localParallelArray = this.controller.particles;
    localParallelArray.size = (i + localParallelArray.size);
  }

  public void activateParticles(int paramInt1, int paramInt2)
  {
    int i = this.life + (int)(this.lifeDiff * this.lifeValue.getScale(this.percent));
    int j = (int)(this.lifeOffset + this.lifeOffsetDiff * this.lifeOffsetValue.getScale(this.percent));
    if (j > 0)
      if (j >= i)
        j = i - 1;
    for (int k = i - j; ; k = i)
    {
      float f = 1.0F - k / i;
      int m = paramInt1 * this.lifeChannel.strideSize;
      int n = m + paramInt2 * this.lifeChannel.strideSize;
      while (m < n)
      {
        this.lifeChannel.data[m] = k;
        this.lifeChannel.data[(m + 1)] = i;
        this.lifeChannel.data[(m + 2)] = f;
        m += this.lifeChannel.strideSize;
      }
      return;
    }
  }

  public void allocateChannels()
  {
    this.lifeChannel = ((ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life));
  }

  public ParticleControllerComponent copy()
  {
    return new RegularEmitter(this);
  }

  public RangedNumericValue getDelay()
  {
    return this.delayValue;
  }

  public RangedNumericValue getDuration()
  {
    return this.durationValue;
  }

  public ScaledNumericValue getEmission()
  {
    return this.emissionValue;
  }

  public RegularEmitter.EmissionMode getEmissionMode()
  {
    return this.emissionMode;
  }

  public ScaledNumericValue getLife()
  {
    return this.lifeValue;
  }

  public ScaledNumericValue getLifeOffset()
  {
    return this.lifeOffsetValue;
  }

  public float getPercentComplete()
  {
    if (this.delayTimer < this.delay)
      return 0.0F;
    return Math.min(1.0F, this.durationTimer / this.duration);
  }

  public void init()
  {
    super.init();
    this.emissionDelta = 0;
    this.durationTimer = this.duration;
  }

  public boolean isComplete()
  {
    if (this.delayTimer < this.delay);
    do
      return false;
    while ((this.durationTimer < this.duration) || (this.controller.particles.size != 0));
    return true;
  }

  public boolean isContinuous()
  {
    return this.continuous;
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.continuous = ((Boolean)paramJson.readValue("continous", Boolean.TYPE, paramJsonValue)).booleanValue();
    this.emissionValue = ((ScaledNumericValue)paramJson.readValue("emission", ScaledNumericValue.class, paramJsonValue));
    this.delayValue = ((RangedNumericValue)paramJson.readValue("delay", RangedNumericValue.class, paramJsonValue));
    this.durationValue = ((RangedNumericValue)paramJson.readValue("duration", RangedNumericValue.class, paramJsonValue));
    this.lifeValue = ((ScaledNumericValue)paramJson.readValue("life", ScaledNumericValue.class, paramJsonValue));
    this.lifeOffsetValue = ((ScaledNumericValue)paramJson.readValue("lifeOffset", ScaledNumericValue.class, paramJsonValue));
  }

  public void set(RegularEmitter paramRegularEmitter)
  {
    super.set(paramRegularEmitter);
    this.delayValue.load(paramRegularEmitter.delayValue);
    this.durationValue.load(paramRegularEmitter.durationValue);
    this.lifeOffsetValue.load(paramRegularEmitter.lifeOffsetValue);
    this.lifeValue.load(paramRegularEmitter.lifeValue);
    this.emissionValue.load(paramRegularEmitter.emissionValue);
    this.emission = paramRegularEmitter.emission;
    this.emissionDiff = paramRegularEmitter.emissionDiff;
    this.emissionDelta = paramRegularEmitter.emissionDelta;
    this.lifeOffset = paramRegularEmitter.lifeOffset;
    this.lifeOffsetDiff = paramRegularEmitter.lifeOffsetDiff;
    this.life = paramRegularEmitter.life;
    this.lifeDiff = paramRegularEmitter.lifeDiff;
    this.duration = paramRegularEmitter.duration;
    this.delay = paramRegularEmitter.delay;
    this.durationTimer = paramRegularEmitter.durationTimer;
    this.delayTimer = paramRegularEmitter.delayTimer;
    this.continuous = paramRegularEmitter.continuous;
  }

  public void setContinuous(boolean paramBoolean)
  {
    this.continuous = paramBoolean;
  }

  public void setEmissionMode(RegularEmitter.EmissionMode paramEmissionMode)
  {
    this.emissionMode = paramEmissionMode;
  }

  public void start()
  {
    float f;
    if (this.delayValue.active)
    {
      f = this.delayValue.newLowValue();
      this.delay = f;
      this.delayTimer = 0.0F;
      this.durationTimer = 0.0F;
      this.duration = this.durationValue.newLowValue();
      this.percent = (this.durationTimer / this.duration);
      this.emission = (int)this.emissionValue.newLowValue();
      this.emissionDiff = (int)this.emissionValue.newHighValue();
      if (!this.emissionValue.isRelative())
        this.emissionDiff -= this.emission;
      this.life = (int)this.lifeValue.newLowValue();
      this.lifeDiff = (int)this.lifeValue.newHighValue();
      if (!this.lifeValue.isRelative())
        this.lifeDiff -= this.life;
      if (!this.lifeOffsetValue.active)
        break label216;
    }
    label216: for (int i = (int)this.lifeOffsetValue.newLowValue(); ; i = 0)
    {
      this.lifeOffset = i;
      this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
      if (!this.lifeOffsetValue.isRelative())
        this.lifeOffsetDiff -= this.lifeOffset;
      return;
      f = 0.0F;
      break;
    }
  }

  public void update()
  {
    int i = 0;
    int j = (int)(1000.0F * this.controller.deltaTime);
    int m;
    int n;
    if (this.delayTimer < this.delay)
    {
      this.delayTimer += j;
      m = this.controller.particles.size;
      n = 0;
    }
    while (true)
    {
      if (n >= this.controller.particles.size)
        break label420;
      float[] arrayOfFloat = this.lifeChannel.data;
      float f2 = arrayOfFloat[i] - j;
      arrayOfFloat[i] = f2;
      if (f2 <= 0.0F)
      {
        this.controller.particles.removeElement(n);
        continue;
        int k;
        if (this.emissionMode != RegularEmitter.EmissionMode.Disabled)
        {
          k = 1;
          label125: if (this.durationTimer >= this.duration)
            break label334;
          this.durationTimer += j;
          this.percent = (this.durationTimer / this.duration);
        }
        while (true)
        {
          if (k == 0)
            break label368;
          this.emissionDelta = (j + this.emissionDelta);
          float f1 = this.emission + this.emissionDiff * this.emissionValue.getScale(this.percent);
          if (f1 > 0.0F)
          {
            float f3 = 1000.0F / f1;
            if (this.emissionDelta >= f3)
            {
              int i1 = Math.min((int)(this.emissionDelta / f3), this.maxParticleCount - this.controller.particles.size);
              this.emissionDelta = (int)(this.emissionDelta - f3 * i1);
              this.emissionDelta = (int)(this.emissionDelta % f3);
              addParticles(i1);
            }
          }
          if (this.controller.particles.size >= this.minParticleCount)
            break;
          addParticles(this.minParticleCount - this.controller.particles.size);
          break;
          k = 0;
          break label125;
          label334: if ((this.continuous) && (k != 0) && (this.emissionMode == RegularEmitter.EmissionMode.Enabled))
          {
            this.controller.start();
            continue;
          }
          k = 0;
        }
        label368: break;
      }
      this.lifeChannel.data[(i + 2)] = (1.0F - this.lifeChannel.data[i] / this.lifeChannel.data[(i + 1)]);
      n++;
      i += this.lifeChannel.strideSize;
    }
    label420: if (this.controller.particles.size < m)
      this.controller.killParticles(this.controller.particles.size, m - this.controller.particles.size);
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("continous", Boolean.valueOf(this.continuous));
    paramJson.writeValue("emission", this.emissionValue);
    paramJson.writeValue("delay", this.delayValue);
    paramJson.writeValue("duration", this.durationValue);
    paramJson.writeValue("life", this.lifeValue);
    paramJson.writeValue("lifeOffset", this.lifeOffsetValue);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.emitters.RegularEmitter
 * JD-Core Version:    0.6.0
 */