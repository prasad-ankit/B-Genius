package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;

public class BaseShader$Uniform
  implements BaseShader.Validator
{
  public final String alias;
  public final long environmentMask;
  public final long materialMask;
  public final long overallMask;

  public BaseShader$Uniform(String paramString)
  {
    this(paramString, 0L, 0L);
  }

  public BaseShader$Uniform(String paramString, long paramLong)
  {
    this(paramString, 0L, 0L, paramLong);
  }

  public BaseShader$Uniform(String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, paramLong1, paramLong2, 0L);
  }

  public BaseShader$Uniform(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.alias = paramString;
    this.materialMask = paramLong1;
    this.environmentMask = paramLong2;
    this.overallMask = paramLong3;
  }

  public boolean validate(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable)
  {
    long l1 = 0L;
    long l2;
    if ((paramRenderable != null) && (paramRenderable.material != null))
      l2 = paramRenderable.material.getMask();
    while (true)
    {
      if ((paramRenderable != null) && (paramRenderable.environment != null))
        l1 = paramRenderable.environment.getMask();
      if (((l2 & this.materialMask) != this.materialMask) || ((l1 & this.environmentMask) != this.environmentMask) || (((l1 | l2) & this.overallMask) != this.overallMask))
        break;
      return true;
      l2 = l1;
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform
 * JD-Core Version:    0.6.0
 */