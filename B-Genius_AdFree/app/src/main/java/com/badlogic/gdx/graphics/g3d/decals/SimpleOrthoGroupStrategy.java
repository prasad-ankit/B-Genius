package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Sort;

public class SimpleOrthoGroupStrategy
  implements GroupStrategy
{
  private static final int GROUP_BLEND = 1;
  private static final int GROUP_OPAQUE;
  private SimpleOrthoGroupStrategy.Comparator comparator = new SimpleOrthoGroupStrategy.Comparator(this);

  public void afterGroup(int paramInt)
  {
    if (paramInt == 1)
    {
      Gdx.gl.glDepthMask(true);
      Gdx.gl.glDisable(3042);
    }
  }

  public void afterGroups()
  {
    Gdx.gl.glDisable(3553);
  }

  public void beforeGroup(int paramInt, Array paramArray)
  {
    if (paramInt == 1)
    {
      Sort.instance().sort(paramArray, this.comparator);
      Gdx.gl.glEnable(3042);
      Gdx.gl.glDepthMask(false);
    }
  }

  public void beforeGroups()
  {
    Gdx.gl.glEnable(3553);
  }

  public int decideGroup(Decal paramDecal)
  {
    if (paramDecal.getMaterial().isOpaque())
      return 0;
    return 1;
  }

  public ShaderProgram getGroupShader(int paramInt)
  {
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.decals.SimpleOrthoGroupStrategy
 * JD-Core Version:    0.6.0
 */