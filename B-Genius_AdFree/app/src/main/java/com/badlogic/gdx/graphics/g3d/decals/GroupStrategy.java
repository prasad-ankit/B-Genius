package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;

public abstract interface GroupStrategy
{
  public abstract void afterGroup(int paramInt);

  public abstract void afterGroups();

  public abstract void beforeGroup(int paramInt, Array paramArray);

  public abstract void beforeGroups();

  public abstract int decideGroup(Decal paramDecal);

  public abstract ShaderProgram getGroupShader(int paramInt);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.decals.GroupStrategy
 * JD-Core Version:    0.6.0
 */