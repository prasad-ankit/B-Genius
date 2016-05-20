package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public final class EllipseSpawnShapeValue extends PrimitiveSpawnShapeValue
{
  PrimitiveSpawnShapeValue.SpawnSide side = PrimitiveSpawnShapeValue.SpawnSide.both;

  public EllipseSpawnShapeValue()
  {
  }

  public EllipseSpawnShapeValue(EllipseSpawnShapeValue paramEllipseSpawnShapeValue)
  {
    super(paramEllipseSpawnShapeValue);
    load(paramEllipseSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new EllipseSpawnShapeValue(this);
  }

  public final PrimitiveSpawnShapeValue.SpawnSide getSide()
  {
    return this.side;
  }

  public final void load(ParticleValue paramParticleValue)
  {
    super.load(paramParticleValue);
    this.side = ((EllipseSpawnShapeValue)paramParticleValue).side;
  }

  public final void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.side = ((PrimitiveSpawnShapeValue.SpawnSide)paramJson.readValue("side", PrimitiveSpawnShapeValue.SpawnSide.class, paramJsonValue));
  }

  public final void setSide(PrimitiveSpawnShapeValue.SpawnSide paramSpawnSide)
  {
    this.side = paramSpawnSide;
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
    float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
    float f3 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
    float f4 = 6.283186F;
    if (this.side == PrimitiveSpawnShapeValue.SpawnSide.top)
      f4 = 3.141593F;
    float f5;
    float f6;
    float f7;
    float f8;
    while (true)
    {
      f5 = MathUtils.random(0.0F, f4);
      if (!this.edges)
        break;
      if (f1 == 0.0F)
      {
        paramVector3.set(0.0F, f2 / 2.0F * MathUtils.sin(f5), f3 / 2.0F * MathUtils.cos(f5));
        return;
        if (this.side != PrimitiveSpawnShapeValue.SpawnSide.bottom)
          continue;
        f4 = -3.141593F;
        continue;
      }
      if (f2 == 0.0F)
      {
        paramVector3.set(f1 / 2.0F * MathUtils.cos(f5), 0.0F, f3 / 2.0F * MathUtils.sin(f5));
        return;
      }
      if (f3 == 0.0F)
      {
        paramVector3.set(f1 / 2.0F * MathUtils.cos(f5), f2 / 2.0F * MathUtils.sin(f5), 0.0F);
        return;
      }
      f6 = f1 / 2.0F;
      f7 = f2 / 2.0F;
      f8 = f3 / 2.0F;
    }
    while (true)
    {
      float f9 = MathUtils.random(-1.0F, 1.0F);
      float f10 = (float)Math.sqrt(1.0F - f9 * f9);
      paramVector3.set(f6 * f10 * MathUtils.cos(f5), f7 * f10 * MathUtils.sin(f5), f8 * f9);
      return;
      f6 = MathUtils.random(f1 / 2.0F);
      f7 = MathUtils.random(f2 / 2.0F);
      f8 = MathUtils.random(f3 / 2.0F);
    }
  }

  public final void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("side", this.side);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.EllipseSpawnShapeValue
 * JD-Core Version:    0.6.0
 */