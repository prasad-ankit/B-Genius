package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;

public class DefaultShader$Inputs
{
  public static final BaseShader.Uniform alphaTest;
  public static final BaseShader.Uniform ambientCube;
  public static final BaseShader.Uniform ambientTexture;
  public static final BaseShader.Uniform ambientUVTransform;
  public static final BaseShader.Uniform bones;
  public static final BaseShader.Uniform cameraDirection;
  public static final BaseShader.Uniform cameraPosition;
  public static final BaseShader.Uniform cameraUp;
  public static final BaseShader.Uniform diffuseColor;
  public static final BaseShader.Uniform diffuseTexture;
  public static final BaseShader.Uniform diffuseUVTransform;
  public static final BaseShader.Uniform dirLights;
  public static final BaseShader.Uniform emissiveColor;
  public static final BaseShader.Uniform emissiveTexture;
  public static final BaseShader.Uniform emissiveUVTransform;
  public static final BaseShader.Uniform environmentCubemap;
  public static final BaseShader.Uniform normalMatrix;
  public static final BaseShader.Uniform normalTexture;
  public static final BaseShader.Uniform normalUVTransform;
  public static final BaseShader.Uniform opacity;
  public static final BaseShader.Uniform pointLights;
  public static final BaseShader.Uniform projTrans = new BaseShader.Uniform("u_projTrans");
  public static final BaseShader.Uniform projViewTrans;
  public static final BaseShader.Uniform projViewWorldTrans;
  public static final BaseShader.Uniform reflectionColor;
  public static final BaseShader.Uniform reflectionTexture;
  public static final BaseShader.Uniform reflectionUVTransform;
  public static final BaseShader.Uniform shininess;
  public static final BaseShader.Uniform specularColor;
  public static final BaseShader.Uniform specularTexture;
  public static final BaseShader.Uniform specularUVTransform;
  public static final BaseShader.Uniform spotLights;
  public static final BaseShader.Uniform viewTrans = new BaseShader.Uniform("u_viewTrans");
  public static final BaseShader.Uniform viewWorldTrans;
  public static final BaseShader.Uniform worldTrans;

  static
  {
    projViewTrans = new BaseShader.Uniform("u_projViewTrans");
    cameraPosition = new BaseShader.Uniform("u_cameraPosition");
    cameraDirection = new BaseShader.Uniform("u_cameraDirection");
    cameraUp = new BaseShader.Uniform("u_cameraUp");
    worldTrans = new BaseShader.Uniform("u_worldTrans");
    viewWorldTrans = new BaseShader.Uniform("u_viewWorldTrans");
    projViewWorldTrans = new BaseShader.Uniform("u_projViewWorldTrans");
    normalMatrix = new BaseShader.Uniform("u_normalMatrix");
    bones = new BaseShader.Uniform("u_bones");
    shininess = new BaseShader.Uniform("u_shininess", FloatAttribute.Shininess);
    opacity = new BaseShader.Uniform("u_opacity", BlendingAttribute.Type);
    diffuseColor = new BaseShader.Uniform("u_diffuseColor", ColorAttribute.Diffuse);
    diffuseTexture = new BaseShader.Uniform("u_diffuseTexture", TextureAttribute.Diffuse);
    diffuseUVTransform = new BaseShader.Uniform("u_diffuseUVTransform", TextureAttribute.Diffuse);
    specularColor = new BaseShader.Uniform("u_specularColor", ColorAttribute.Specular);
    specularTexture = new BaseShader.Uniform("u_specularTexture", TextureAttribute.Specular);
    specularUVTransform = new BaseShader.Uniform("u_specularUVTransform", TextureAttribute.Specular);
    emissiveColor = new BaseShader.Uniform("u_emissiveColor", ColorAttribute.Emissive);
    emissiveTexture = new BaseShader.Uniform("u_emissiveTexture", TextureAttribute.Emissive);
    emissiveUVTransform = new BaseShader.Uniform("u_emissiveUVTransform", TextureAttribute.Emissive);
    reflectionColor = new BaseShader.Uniform("u_reflectionColor", ColorAttribute.Reflection);
    reflectionTexture = new BaseShader.Uniform("u_reflectionTexture", TextureAttribute.Reflection);
    reflectionUVTransform = new BaseShader.Uniform("u_reflectionUVTransform", TextureAttribute.Reflection);
    normalTexture = new BaseShader.Uniform("u_normalTexture", TextureAttribute.Normal);
    normalUVTransform = new BaseShader.Uniform("u_normalUVTransform", TextureAttribute.Normal);
    ambientTexture = new BaseShader.Uniform("u_ambientTexture", TextureAttribute.Ambient);
    ambientUVTransform = new BaseShader.Uniform("u_ambientUVTransform", TextureAttribute.Ambient);
    alphaTest = new BaseShader.Uniform("u_alphaTest");
    ambientCube = new BaseShader.Uniform("u_ambientCubemap");
    dirLights = new BaseShader.Uniform("u_dirLights");
    pointLights = new BaseShader.Uniform("u_pointLights");
    spotLights = new BaseShader.Uniform("u_spotLights");
    environmentCubemap = new BaseShader.Uniform("u_environmentCubemap");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs
 * JD-Core Version:    0.6.0
 */