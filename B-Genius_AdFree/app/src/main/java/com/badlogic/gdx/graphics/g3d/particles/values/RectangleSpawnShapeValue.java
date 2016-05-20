package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class RectangleSpawnShapeValue extends PrimitiveSpawnShapeValue
{
  public RectangleSpawnShapeValue()
  {
  }

  public RectangleSpawnShapeValue(RectangleSpawnShapeValue paramRectangleSpawnShapeValue)
  {
    super(paramRectangleSpawnShapeValue);
    load(paramRectangleSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new RectangleSpawnShapeValue(this);
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
    float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
    float f3 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
    if (this.edges)
    {
      int i = MathUtils.random(-1, 1);
      float f13;
      float f9;
      label113: float f16;
      label127: float f8;
      float f5;
      if (i == -1)
        if (MathUtils.random(1) == 0)
        {
          f13 = -f1 / 2.0F;
          if (f13 != 0.0F)
            break label184;
          if (MathUtils.random(1) != 0)
            break label166;
          f9 = -f2 / 2.0F;
          if (MathUtils.random(1) != 0)
            break label175;
          f16 = -f3 / 2.0F;
          float f17 = f13;
          f8 = f16;
          f5 = f17;
        }
      while (true)
      {
        paramVector3.x = f5;
        paramVector3.y = f9;
        paramVector3.z = f8;
        return;
        f13 = f1 / 2.0F;
        break;
        label166: f9 = f2 / 2.0F;
        break label113;
        label175: f16 = f3 / 2.0F;
        break label127;
        label184: f9 = MathUtils.random(f2) - f2 / 2.0F;
        float f14 = MathUtils.random(f3) - f3 / 2.0F;
        float f15 = f13;
        f8 = f14;
        f5 = f15;
        continue;
        if (i == 0)
        {
          if (MathUtils.random(1) == 0)
          {
            f8 = -f3 / 2.0F;
            label242: if (f8 != 0.0F)
              break label305;
            if (MathUtils.random(1) != 0)
              break label288;
            f9 = -f2 / 2.0F;
          }
          while (true)
          {
            if (MathUtils.random(1) != 0)
              break label297;
            f5 = -f1 / 2.0F;
            break;
            f8 = f3 / 2.0F;
            break label242;
            label288: f9 = f2 / 2.0F;
          }
          label297: f5 = f1 / 2.0F;
          continue;
          label305: f9 = MathUtils.random(f2) - f2 / 2.0F;
          f5 = MathUtils.random(f1) - f1 / 2.0F;
          continue;
        }
        float f4;
        label344: float f10;
        label364: float f11;
        if (MathUtils.random(1) == 0)
        {
          f4 = -f2 / 2.0F;
          if (f4 != 0.0F)
            break label423;
          if (MathUtils.random(1) != 0)
            break label406;
          f10 = -f1 / 2.0F;
          if (MathUtils.random(1) != 0)
            break label414;
          f11 = -f3 / 2.0F;
        }
        while (true)
        {
          float f12 = f4;
          f8 = f11;
          f5 = f10;
          f9 = f12;
          break;
          f4 = f2 / 2.0F;
          break label344;
          label406: f10 = f1 / 2.0F;
          break label364;
          label414: f11 = f3 / 2.0F;
        }
        label423: f5 = MathUtils.random(f1) - f1 / 2.0F;
        float f6 = MathUtils.random(f3) - f3 / 2.0F;
        float f7 = f4;
        f8 = f6;
        f9 = f7;
      }
    }
    paramVector3.x = (MathUtils.random(f1) - f1 / 2.0F);
    paramVector3.y = (MathUtils.random(f2) - f2 / 2.0F);
    paramVector3.z = (MathUtils.random(f3) - f3 / 2.0F);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.RectangleSpawnShapeValue
 * JD-Core Version:    0.6.0
 */