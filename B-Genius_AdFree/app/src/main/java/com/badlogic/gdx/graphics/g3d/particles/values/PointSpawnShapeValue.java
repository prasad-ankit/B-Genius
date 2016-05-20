package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.Vector3;

public final class PointSpawnShapeValue extends PrimitiveSpawnShapeValue
{
  public PointSpawnShapeValue()
  {
  }

  public PointSpawnShapeValue(PointSpawnShapeValue paramPointSpawnShapeValue)
  {
    super(paramPointSpawnShapeValue);
    load(paramPointSpawnShapeValue);
  }

  public final SpawnShapeValue copy()
  {
    return new PointSpawnShapeValue(this);
  }

  public final void spawnAux(Vector3 paramVector3, float paramFloat)
  {
    paramVector3.x = (this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat));
    paramVector3.y = (this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat));
    paramVector3.z = (this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue
 * JD-Core Version:    0.6.0
 */