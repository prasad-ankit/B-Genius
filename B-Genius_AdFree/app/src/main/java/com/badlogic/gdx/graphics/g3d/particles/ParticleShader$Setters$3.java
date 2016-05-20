package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.math.Vector3;

final class ParticleShader$Setters$3
  implements BaseShader.Setter
{
  public final boolean isGlobal(BaseShader paramBaseShader, int paramInt)
  {
    return true;
  }

  public final void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    paramBaseShader.set(paramInt, ParticleShader.TMP_VECTOR3.set(-paramBaseShader.camera.direction.x, -paramBaseShader.camera.direction.y, -paramBaseShader.camera.direction.z).nor());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader.Setters.3
 * JD-Core Version:    0.6.0
 */