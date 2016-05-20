package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public final class LineSpawnShapeValue extends PrimitiveSpawnShapeValue
{
  public LineSpawnShapeValue()
  {
  }

  public LineSpawnShapeValue(LineSpawnShapeValue paramLineSpawnShapeValue)
  {
    super(paramLineSpawnShapeValue);
    load(paramLineSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new LineSpawnShapeValue(this);
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
    float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
    float f3 = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
    float f4 = MathUtils.random();
    paramVector3.x = (f1 * f4);
    paramVector3.y = (f4 * f2);
    paramVector3.z = (f4 * f3);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.LineSpawnShapeValue
 * JD-Core Version:    0.6.0
 */