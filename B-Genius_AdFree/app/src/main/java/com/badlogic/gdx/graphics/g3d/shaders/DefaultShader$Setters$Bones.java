package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;

public class DefaultShader$Setters$Bones extends BaseShader.LocalSetter
{
  private static final Matrix4 idtMatrix = new Matrix4();
  public final float[] bones;

  public DefaultShader$Setters$Bones(int paramInt)
  {
    this.bones = new float[paramInt << 4];
  }

  public void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    int i = 0;
    if (i < this.bones.length)
    {
      int j = i / 16;
      float[] arrayOfFloat = this.bones;
      float f;
      if ((paramRenderable.bones == null) || (j >= paramRenderable.bones.length) || (paramRenderable.bones[j] == null))
        f = idtMatrix.val[(i % 16)];
      while (true)
      {
        arrayOfFloat[i] = f;
        i++;
        break;
        f = paramRenderable.bones[j].val[(i % 16)];
      }
    }
    paramBaseShader.program.setUniformMatrix4fv(paramBaseShader.loc(paramInt), this.bones, 0, this.bones.length);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.Bones
 * JD-Core Version:    0.6.0
 */