package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

abstract class ModelCache$FlushablePool extends Pool
{
  protected Array obtained = new Array();

  public void flush()
  {
    super.freeAll(this.obtained);
    this.obtained.clear();
  }

  public void free(Object paramObject)
  {
    this.obtained.removeValue(paramObject, true);
    super.free(paramObject);
  }

  public void freeAll(Array paramArray)
  {
    this.obtained.removeAll(paramArray, true);
    super.freeAll(paramArray);
  }

  public Object obtain()
  {
    Object localObject = super.obtain();
    this.obtained.add(localObject);
    return localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelCache.FlushablePool
 * JD-Core Version:    0.6.0
 */