package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.math.Matrix4;

final class ParticleShader$Setters$6
  implements BaseShader.Setter
{
  final Matrix4 temp = new Matrix4();

  public final boolean isGlobal(BaseShader paramBaseShader, int paramInt)
  {
    return false;
  }

  public final void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    paramBaseShader.set(paramInt, this.temp.set(paramBaseShader.camera.view).mul(paramRenderable.worldTransform));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Setters.6
 * JD-Core Version:    0.6.0
 */