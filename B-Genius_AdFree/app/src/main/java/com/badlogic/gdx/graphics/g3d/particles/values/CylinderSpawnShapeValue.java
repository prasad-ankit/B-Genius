package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class CylinderSpawnShapeValue extends PrimitiveSpawnShapeValue
{
  public CylinderSpawnShapeValue()
  {
  }

  public CylinderSpawnShapeValue(CylinderSpawnShapeValue paramCylinderSpawnShapeValue)
  {
    super(paramCylinderSpawnShapeValue);
    load(paramCylinderSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new CylinderSpawnShapeValue(this);
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
    float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
    float f3 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
    float f4 = f2 / 2.0F;
    float f5 = MathUtils.random(f2) - f4;
    float f7;
    float f8;
    int i;
    label107: int j;
    float f9;
    if (this.edges)
    {
      float f10 = f1 / 2.0F;
      f7 = f3 / 2.0F;
      f8 = f10;
      if (f8 != 0.0F)
        break label189;
      i = 1;
      boolean bool = f7 < 0.0F;
      j = 0;
      if (!bool)
        j = 1;
      if ((i != 0) || (j != 0))
        break label195;
      f9 = MathUtils.random(360.0F);
    }
    while (true)
    {
      paramVector3.set(f8 * MathUtils.cosDeg(f9), f5, f7 * MathUtils.sinDeg(f9));
      return;
      float f6 = MathUtils.random(f1) / 2.0F;
      f7 = MathUtils.random(f3) / 2.0F;
      f8 = f6;
      break;
      label189: i = 0;
      break label107;
      label195: if (i != 0)
      {
        if (MathUtils.random(1) == 0)
        {
          f9 = -90.0F;
          continue;
        }
        f9 = 90.0F;
        continue;
      }
      f9 = 0.0F;
      if (j == 0)
        continue;
      int k = MathUtils.random(1);
      f9 = 0.0F;
      if (k == 0)
        continue;
      f9 = 180.0F;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.CylinderSpawnShapeValue
 * JD-Core Version:    0.6.0
 */