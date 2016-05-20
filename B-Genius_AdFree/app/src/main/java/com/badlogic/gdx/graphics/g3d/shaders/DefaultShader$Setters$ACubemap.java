package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class DefaultShader$Setters$ACubemap extends BaseShader.LocalSetter
{
  private static final float[] ones = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  private static final Vector3 tmpV1 = new Vector3();
  private final AmbientCubemap cacheAmbientCubemap = new AmbientCubemap();
  public final int dirLightsOffset;
  public final int pointLightsOffset;

  public DefaultShader$Setters$ACubemap(int paramInt1, int paramInt2)
  {
    this.dirLightsOffset = paramInt1;
    this.pointLightsOffset = paramInt2;
  }

  public void set(BaseShader paramBaseShader, int paramInt, Renderable paramRenderable, Attributes paramAttributes)
  {
    if (paramRenderable.environment == null)
    {
      paramBaseShader.program.setUniform3fv(paramBaseShader.loc(paramInt), ones, 0, ones.length);
      return;
    }
    paramRenderable.worldTransform.getTranslation(tmpV1);
    if (paramAttributes.has(ColorAttribute.AmbientLight))
      this.cacheAmbientCubemap.set(((ColorAttribute)paramAttributes.get(ColorAttribute.AmbientLight)).color);
    if (paramAttributes.has(DirectionalLightsAttribute.Type))
    {
      Array localArray2 = ((DirectionalLightsAttribute)paramAttributes.get(DirectionalLightsAttribute.Type)).lights;
      for (int j = this.dirLightsOffset; j < localArray2.size; j++)
        this.cacheAmbientCubemap.add(((DirectionalLight)localArray2.get(j)).color, ((DirectionalLight)localArray2.get(j)).direction);
    }
    if (paramAttributes.has(PointLightsAttribute.Type))
    {
      Array localArray1 = ((PointLightsAttribute)paramAttributes.get(PointLightsAttribute.Type)).lights;
      for (int i = this.pointLightsOffset; i < localArray1.size; i++)
        this.cacheAmbientCubemap.add(((PointLight)localArray1.get(i)).color, ((PointLight)localArray1.get(i)).position, tmpV1, ((PointLight)localArray1.get(i)).intensity);
    }
    this.cacheAmbientCubemap.clamp();
    paramBaseShader.program.setUniform3fv(paramBaseShader.loc(paramInt), this.cacheAmbientCubemap.data, 0, this.cacheAmbientCubemap.data.length);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.ACubemap
 * JD-Core Version:    0.6.0
 */