package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.ShadowMap;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class DefaultShader extends BaseShader
{
  public static int defaultCullFace;
  public static int defaultDepthFunc;
  private static String defaultFragmentShader;
  private static String defaultVertexShader = null;
  protected static long implementedFlags;
  private static final long optionalAttributes;
  private static final Attributes tmpAttributes;
  protected final AmbientCubemap ambientCubemap = new AmbientCubemap();
  protected final long attributesMask;
  private Camera camera;
  protected final DefaultShader.Config config;
  protected int dirLightsColorOffset;
  protected int dirLightsDirectionOffset;
  protected int dirLightsLoc;
  protected int dirLightsSize;
  protected final DirectionalLight[] directionalLights;
  protected final boolean environmentCubemap;
  protected final boolean lighting;
  private boolean lightsSet;
  private Matrix3 normalMatrix = new Matrix3();
  protected final PointLight[] pointLights;
  protected int pointLightsColorOffset;
  protected int pointLightsIntensityOffset;
  protected int pointLightsLoc;
  protected int pointLightsPositionOffset;
  protected int pointLightsSize;
  private Renderable renderable;
  protected final boolean shadowMap;
  protected final SpotLight[] spotLights;
  protected int spotLightsColorOffset;
  protected int spotLightsCutoffAngleOffset;
  protected int spotLightsDirectionOffset;
  protected int spotLightsExponentOffset;
  protected int spotLightsIntensityOffset;
  protected int spotLightsLoc;
  protected int spotLightsPositionOffset;
  protected int spotLightsSize;
  private float time;
  private final Vector3 tmpV1 = new Vector3();
  public final int u_alphaTest;
  protected final int u_ambientCubemap;
  public final int u_ambientTexture;
  public final int u_ambientUVTransform;
  public final int u_bones;
  public final int u_cameraDirection;
  public final int u_cameraPosition;
  public final int u_cameraUp;
  public final int u_diffuseColor;
  public final int u_diffuseTexture;
  public final int u_diffuseUVTransform;
  protected final int u_dirLights0color = register(new BaseShader.Uniform("u_dirLights[0].color"));
  protected final int u_dirLights0direction = register(new BaseShader.Uniform("u_dirLights[0].direction"));
  protected final int u_dirLights1color = register(new BaseShader.Uniform("u_dirLights[1].color"));
  public final int u_emissiveColor;
  public final int u_emissiveTexture;
  public final int u_emissiveUVTransform;
  protected final int u_environmentCubemap;
  protected final int u_fogColor = register(new BaseShader.Uniform("u_fogColor"));
  public final int u_normalMatrix;
  public final int u_normalTexture;
  public final int u_normalUVTransform;
  public final int u_opacity;
  protected final int u_pointLights0color = register(new BaseShader.Uniform("u_pointLights[0].color"));
  protected final int u_pointLights0intensity = register(new BaseShader.Uniform("u_pointLights[0].intensity"));
  protected final int u_pointLights0position = register(new BaseShader.Uniform("u_pointLights[0].position"));
  protected final int u_pointLights1color = register(new BaseShader.Uniform("u_pointLights[1].color"));
  public final int u_projTrans;
  public final int u_projViewTrans;
  public final int u_projViewWorldTrans;
  public final int u_reflectionColor;
  public final int u_reflectionTexture;
  public final int u_reflectionUVTransform;
  protected final int u_shadowMapProjViewTrans = register(new BaseShader.Uniform("u_shadowMapProjViewTrans"));
  protected final int u_shadowPCFOffset = register(new BaseShader.Uniform("u_shadowPCFOffset"));
  protected final int u_shadowTexture = register(new BaseShader.Uniform("u_shadowTexture"));
  public final int u_shininess;
  public final int u_specularColor;
  public final int u_specularTexture;
  public final int u_specularUVTransform;
  protected final int u_spotLights0color = register(new BaseShader.Uniform("u_spotLights[0].color"));
  protected final int u_spotLights0cutoffAngle = register(new BaseShader.Uniform("u_spotLights[0].cutoffAngle"));
  protected final int u_spotLights0direction = register(new BaseShader.Uniform("u_spotLights[0].direction"));
  protected final int u_spotLights0exponent = register(new BaseShader.Uniform("u_spotLights[0].exponent"));
  protected final int u_spotLights0intensity = register(new BaseShader.Uniform("u_spotLights[0].intensity"));
  protected final int u_spotLights0position = register(new BaseShader.Uniform("u_spotLights[0].position"));
  protected final int u_spotLights1color = register(new BaseShader.Uniform("u_spotLights[1].color"));
  public final int u_time;
  public final int u_viewTrans;
  public final int u_viewWorldTrans;
  public final int u_worldTrans;
  private long vertexMask;

  static
  {
    defaultFragmentShader = null;
    implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse | ColorAttribute.Diffuse | ColorAttribute.Specular | FloatAttribute.Shininess;
    defaultCullFace = 1029;
    defaultDepthFunc = 515;
    optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type;
    tmpAttributes = new Attributes();
  }

  public DefaultShader(Renderable paramRenderable)
  {
    this(paramRenderable, new DefaultShader.Config());
  }

  public DefaultShader(Renderable paramRenderable, DefaultShader.Config paramConfig)
  {
    this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
  }

  public DefaultShader(Renderable paramRenderable, DefaultShader.Config paramConfig, ShaderProgram paramShaderProgram)
  {
    Attributes localAttributes = combineAttributes(paramRenderable);
    this.config = paramConfig;
    this.program = paramShaderProgram;
    boolean bool2;
    boolean bool3;
    if (paramRenderable.environment != null)
    {
      bool2 = bool1;
      this.lighting = bool2;
      if ((!localAttributes.has(CubemapAttribute.EnvironmentMap)) && ((!this.lighting) || (!localAttributes.has(CubemapAttribute.EnvironmentMap))))
        break label550;
      bool3 = bool1;
      label418: this.environmentCubemap = bool3;
      if ((!this.lighting) || (paramRenderable.environment.shadowMap == null))
        break label556;
      label441: this.shadowMap = bool1;
      this.renderable = paramRenderable;
      this.attributesMask = (localAttributes.getMask() | optionalAttributes);
      this.vertexMask = paramRenderable.meshPart.mesh.getVertexAttributes().getMask();
      if ((!this.lighting) || (paramConfig.numDirectionalLights <= 0))
        break label562;
    }
    label550: label556: label562: for (int k = paramConfig.numDirectionalLights; ; k = 0)
    {
      this.directionalLights = new DirectionalLight[k];
      for (int m = 0; m < this.directionalLights.length; m++)
        this.directionalLights[m] = new DirectionalLight();
      bool2 = false;
      break;
      bool3 = false;
      break label418;
      bool1 = false;
      break label441;
    }
    if ((this.lighting) && (paramConfig.numPointLights > 0));
    for (int n = paramConfig.numPointLights; ; n = 0)
    {
      this.pointLights = new PointLight[n];
      for (int i1 = 0; i1 < this.pointLights.length; i1++)
        this.pointLights[i1] = new PointLight();
    }
    if ((this.lighting) && (paramConfig.numSpotLights > 0));
    for (int i2 = paramConfig.numSpotLights; ; i2 = 0)
    {
      this.spotLights = new SpotLight[i2];
      while (j < this.spotLights.length)
      {
        this.spotLights[j] = new SpotLight();
        j++;
      }
    }
    if ((!paramConfig.ignoreUnimplemented) && ((implementedFlags & this.attributesMask) != this.attributesMask))
      throw new GdxRuntimeException("Some attributes not implemented yet (" + this.attributesMask + ")");
    this.u_projTrans = register(DefaultShader.Inputs.projTrans, DefaultShader.Setters.projTrans);
    this.u_viewTrans = register(DefaultShader.Inputs.viewTrans, DefaultShader.Setters.viewTrans);
    this.u_projViewTrans = register(DefaultShader.Inputs.projViewTrans, DefaultShader.Setters.projViewTrans);
    this.u_cameraPosition = register(DefaultShader.Inputs.cameraPosition, DefaultShader.Setters.cameraPosition);
    this.u_cameraDirection = register(DefaultShader.Inputs.cameraDirection, DefaultShader.Setters.cameraDirection);
    this.u_cameraUp = register(DefaultShader.Inputs.cameraUp, DefaultShader.Setters.cameraUp);
    this.u_time = register(new BaseShader.Uniform("u_time"));
    this.u_worldTrans = register(DefaultShader.Inputs.worldTrans, DefaultShader.Setters.worldTrans);
    this.u_viewWorldTrans = register(DefaultShader.Inputs.viewWorldTrans, DefaultShader.Setters.viewWorldTrans);
    this.u_projViewWorldTrans = register(DefaultShader.Inputs.projViewWorldTrans, DefaultShader.Setters.projViewWorldTrans);
    this.u_normalMatrix = register(DefaultShader.Inputs.normalMatrix, DefaultShader.Setters.normalMatrix);
    int i3;
    if ((paramRenderable.bones != null) && (paramConfig.numBones > 0))
    {
      i3 = register(DefaultShader.Inputs.bones, new DefaultShader.Setters.Bones(paramConfig.numBones));
      this.u_bones = i3;
      this.u_shininess = register(DefaultShader.Inputs.shininess, DefaultShader.Setters.shininess);
      this.u_opacity = register(DefaultShader.Inputs.opacity);
      this.u_diffuseColor = register(DefaultShader.Inputs.diffuseColor, DefaultShader.Setters.diffuseColor);
      this.u_diffuseTexture = register(DefaultShader.Inputs.diffuseTexture, DefaultShader.Setters.diffuseTexture);
      this.u_diffuseUVTransform = register(DefaultShader.Inputs.diffuseUVTransform, DefaultShader.Setters.diffuseUVTransform);
      this.u_specularColor = register(DefaultShader.Inputs.specularColor, DefaultShader.Setters.specularColor);
      this.u_specularTexture = register(DefaultShader.Inputs.specularTexture, DefaultShader.Setters.specularTexture);
      this.u_specularUVTransform = register(DefaultShader.Inputs.specularUVTransform, DefaultShader.Setters.specularUVTransform);
      this.u_emissiveColor = register(DefaultShader.Inputs.emissiveColor, DefaultShader.Setters.emissiveColor);
      this.u_emissiveTexture = register(DefaultShader.Inputs.emissiveTexture, DefaultShader.Setters.emissiveTexture);
      this.u_emissiveUVTransform = register(DefaultShader.Inputs.emissiveUVTransform, DefaultShader.Setters.emissiveUVTransform);
      this.u_reflectionColor = register(DefaultShader.Inputs.reflectionColor, DefaultShader.Setters.reflectionColor);
      this.u_reflectionTexture = register(DefaultShader.Inputs.reflectionTexture, DefaultShader.Setters.reflectionTexture);
      this.u_reflectionUVTransform = register(DefaultShader.Inputs.reflectionUVTransform, DefaultShader.Setters.reflectionUVTransform);
      this.u_normalTexture = register(DefaultShader.Inputs.normalTexture, DefaultShader.Setters.normalTexture);
      this.u_normalUVTransform = register(DefaultShader.Inputs.normalUVTransform, DefaultShader.Setters.normalUVTransform);
      this.u_ambientTexture = register(DefaultShader.Inputs.ambientTexture, DefaultShader.Setters.ambientTexture);
      this.u_ambientUVTransform = register(DefaultShader.Inputs.ambientUVTransform, DefaultShader.Setters.ambientUVTransform);
      this.u_alphaTest = register(DefaultShader.Inputs.alphaTest);
      if (!this.lighting)
        break label1286;
    }
    label1286: for (int i4 = register(DefaultShader.Inputs.ambientCube, new DefaultShader.Setters.ACubemap(paramConfig.numDirectionalLights, paramConfig.numPointLights)); ; i4 = i)
    {
      this.u_ambientCubemap = i4;
      if (this.environmentCubemap)
        i = register(DefaultShader.Inputs.environmentCubemap, DefaultShader.Setters.environmentCubemap);
      this.u_environmentCubemap = i;
      return;
      i3 = i;
      break;
    }
  }

  public DefaultShader(Renderable paramRenderable, DefaultShader.Config paramConfig, String paramString)
  {
  }

  public DefaultShader(Renderable paramRenderable, DefaultShader.Config paramConfig, String paramString1, String paramString2, String paramString3)
  {
    this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
  }

  private static final boolean and(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) == paramLong2;
  }

  private static final Attributes combineAttributes(Renderable paramRenderable)
  {
    tmpAttributes.clear();
    if (paramRenderable.environment != null)
      tmpAttributes.set(paramRenderable.environment);
    if (paramRenderable.material != null)
      tmpAttributes.set(paramRenderable.material);
    return tmpAttributes;
  }

  public static String createPrefix(Renderable paramRenderable, DefaultShader.Config paramConfig)
  {
    Attributes localAttributes = combineAttributes(paramRenderable);
    String str1 = "";
    long l1 = localAttributes.getMask();
    long l2 = paramRenderable.meshPart.mesh.getVertexAttributes().getMask();
    if (and(l2, 1L))
      str1 = str1 + "#define positionFlag\n";
    if (or(l2, 6L))
      str1 = str1 + "#define colorFlag\n";
    if (and(l2, 256L))
      str1 = str1 + "#define binormalFlag\n";
    if (and(l2, 128L))
      str1 = str1 + "#define tangentFlag\n";
    if (and(l2, 8L))
      str1 = str1 + "#define normalFlag\n";
    if (((and(l2, 8L)) || (and(l2, 384L))) && (paramRenderable.environment != null))
    {
      String str8 = str1 + "#define lightingFlag\n";
      String str9 = str8 + "#define ambientCubemapFlag\n";
      String str10 = str9 + "#define numDirectionalLights " + paramConfig.numDirectionalLights + "\n";
      String str11 = str10 + "#define numPointLights " + paramConfig.numPointLights + "\n";
      str1 = str11 + "#define numSpotLights " + paramConfig.numSpotLights + "\n";
      if (localAttributes.has(ColorAttribute.Fog))
        str1 = str1 + "#define fogFlag\n";
      if (paramRenderable.environment.shadowMap != null)
        str1 = str1 + "#define shadowMapFlag\n";
      if (localAttributes.has(CubemapAttribute.EnvironmentMap))
        str1 = str1 + "#define environmentCubemapFlag\n";
    }
    int i = paramRenderable.meshPart.mesh.getVertexAttributes().size();
    int j = 0;
    if (j < i)
    {
      VertexAttribute localVertexAttribute = paramRenderable.meshPart.mesh.getVertexAttributes().get(j);
      if (localVertexAttribute.usage == 64)
        str1 = str1 + "#define boneWeight" + localVertexAttribute.unit + "Flag\n";
      while (true)
      {
        j++;
        break;
        if (localVertexAttribute.usage != 16)
          continue;
        str1 = str1 + "#define texCoord" + localVertexAttribute.unit + "Flag\n";
      }
    }
    if ((l1 & BlendingAttribute.Type) == BlendingAttribute.Type)
      str1 = str1 + "#define blendedFlag\n";
    if ((l1 & TextureAttribute.Diffuse) == TextureAttribute.Diffuse)
    {
      String str7 = str1 + "#define diffuseTextureFlag\n";
      str1 = str7 + "#define diffuseTextureCoord texCoord0\n";
    }
    if ((l1 & TextureAttribute.Specular) == TextureAttribute.Specular)
    {
      String str6 = str1 + "#define specularTextureFlag\n";
      str1 = str6 + "#define specularTextureCoord texCoord0\n";
    }
    if ((l1 & TextureAttribute.Normal) == TextureAttribute.Normal)
    {
      String str5 = str1 + "#define normalTextureFlag\n";
      str1 = str5 + "#define normalTextureCoord texCoord0\n";
    }
    if ((l1 & TextureAttribute.Emissive) == TextureAttribute.Emissive)
    {
      String str4 = str1 + "#define emissiveTextureFlag\n";
      str1 = str4 + "#define emissiveTextureCoord texCoord0\n";
    }
    if ((l1 & TextureAttribute.Reflection) == TextureAttribute.Reflection)
    {
      String str3 = str1 + "#define reflectionTextureFlag\n";
      str1 = str3 + "#define reflectionTextureCoord texCoord0\n";
    }
    if ((l1 & TextureAttribute.Ambient) == TextureAttribute.Ambient)
    {
      String str2 = str1 + "#define ambientTextureFlag\n";
      str1 = str2 + "#define ambientTextureCoord texCoord0\n";
    }
    if ((l1 & ColorAttribute.Diffuse) == ColorAttribute.Diffuse)
      str1 = str1 + "#define diffuseColorFlag\n";
    if ((l1 & ColorAttribute.Specular) == ColorAttribute.Specular)
      str1 = str1 + "#define specularColorFlag\n";
    if ((l1 & ColorAttribute.Emissive) == ColorAttribute.Emissive)
      str1 = str1 + "#define emissiveColorFlag\n";
    if ((l1 & ColorAttribute.Reflection) == ColorAttribute.Reflection)
      str1 = str1 + "#define reflectionColorFlag\n";
    if ((l1 & FloatAttribute.Shininess) == FloatAttribute.Shininess)
      str1 = str1 + "#define shininessFlag\n";
    if ((l1 & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest)
      str1 = str1 + "#define alphaTestFlag\n";
    if ((paramRenderable.bones != null) && (paramConfig.numBones > 0))
      str1 = str1 + "#define numBones " + paramConfig.numBones + "\n";
    return str1;
  }

  public static String getDefaultFragmentShader()
  {
    if (defaultFragmentShader == null)
      defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.fragment.glsl").readString();
    return defaultFragmentShader;
  }

  public static String getDefaultVertexShader()
  {
    if (defaultVertexShader == null)
      defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.vertex.glsl").readString();
    return defaultVertexShader;
  }

  private static final boolean or(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) != 0L;
  }

  public void begin(Camera paramCamera, RenderContext paramRenderContext)
  {
    super.begin(paramCamera, paramRenderContext);
    DirectionalLight[] arrayOfDirectionalLight = this.directionalLights;
    int i = arrayOfDirectionalLight.length;
    for (int j = 0; j < i; j++)
      arrayOfDirectionalLight[j].set(0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    PointLight[] arrayOfPointLight = this.pointLights;
    int k = arrayOfPointLight.length;
    for (int m = 0; m < k; m++)
      arrayOfPointLight[m].set(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    SpotLight[] arrayOfSpotLight = this.spotLights;
    int n = arrayOfSpotLight.length;
    for (int i1 = 0; i1 < n; i1++)
      arrayOfSpotLight[i1].set(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.lightsSet = false;
    if (has(this.u_time))
    {
      int i2 = this.u_time;
      float f = this.time + Gdx.graphics.getDeltaTime();
      this.time = f;
      set(i2, f);
    }
  }

  protected void bindLights(Renderable paramRenderable, Attributes paramAttributes)
  {
    Environment localEnvironment = paramRenderable.environment;
    DirectionalLightsAttribute localDirectionalLightsAttribute = (DirectionalLightsAttribute)paramAttributes.get(DirectionalLightsAttribute.class, DirectionalLightsAttribute.Type);
    Array localArray1;
    PointLightsAttribute localPointLightsAttribute;
    Array localArray2;
    label51: SpotLightsAttribute localSpotLightsAttribute;
    Array localArray3;
    label74: int n;
    if (localDirectionalLightsAttribute == null)
    {
      localArray1 = null;
      localPointLightsAttribute = (PointLightsAttribute)paramAttributes.get(PointLightsAttribute.class, PointLightsAttribute.Type);
      if (localPointLightsAttribute != null)
        break label331;
      localArray2 = null;
      localSpotLightsAttribute = (SpotLightsAttribute)paramAttributes.get(SpotLightsAttribute.class, SpotLightsAttribute.Type);
      if (localSpotLightsAttribute != null)
        break label341;
      localArray3 = null;
      if (this.dirLightsLoc < 0)
        break label405;
      n = 0;
      label84: if (n >= this.directionalLights.length)
        break label405;
      if ((localArray1 != null) && (n < localArray1.size))
        break label351;
      if ((!this.lightsSet) || (this.directionalLights[n].color.r != 0.0F) || (this.directionalLights[n].color.g != 0.0F) || (this.directionalLights[n].color.b != 0.0F))
        this.directionalLights[n].color.set(0.0F, 0.0F, 0.0F, 1.0F);
    }
    while (true)
    {
      int i1 = this.dirLightsLoc + n * this.dirLightsSize;
      this.program.setUniformf(i1 + this.dirLightsColorOffset, this.directionalLights[n].color.r, this.directionalLights[n].color.g, this.directionalLights[n].color.b);
      this.program.setUniformf(i1 + this.dirLightsDirectionOffset, this.directionalLights[n].direction.x, this.directionalLights[n].direction.y, this.directionalLights[n].direction.z);
      if (this.dirLightsSize <= 0)
        break label405;
      label331: label341: label351: 
      do
      {
        n++;
        break label84;
        localArray1 = localDirectionalLightsAttribute.lights;
        break;
        localArray2 = localPointLightsAttribute.lights;
        break label51;
        localArray3 = localSpotLightsAttribute.lights;
        break label74;
      }
      while ((this.lightsSet) && (this.directionalLights[n].equals((DirectionalLight)localArray1.get(n))));
      this.directionalLights[n].set((DirectionalLight)localArray1.get(n));
    }
    label405: if (this.pointLightsLoc >= 0)
    {
      int k = 0;
      if (k < this.pointLights.length)
      {
        if ((localArray2 == null) || (k >= localArray2.size))
          if ((!this.lightsSet) || (this.pointLights[k].intensity != 0.0F))
            this.pointLights[k].intensity = 0.0F;
        while (true)
        {
          int m = this.pointLightsLoc + k * this.pointLightsSize;
          this.program.setUniformf(m + this.pointLightsColorOffset, this.pointLights[k].color.r * this.pointLights[k].intensity, this.pointLights[k].color.g * this.pointLights[k].intensity, this.pointLights[k].color.b * this.pointLights[k].intensity);
          this.program.setUniformf(m + this.pointLightsPositionOffset, this.pointLights[k].position.x, this.pointLights[k].position.y, this.pointLights[k].position.z);
          if (this.pointLightsIntensityOffset >= 0)
            this.program.setUniformf(m + this.pointLightsIntensityOffset, this.pointLights[k].intensity);
          if (this.pointLightsSize <= 0)
            break label724;
          do
          {
            k++;
            break;
          }
          while ((this.lightsSet) && (this.pointLights[k].equals((PointLight)localArray2.get(k))));
          this.pointLights[k].set((PointLight)localArray2.get(k));
        }
      }
    }
    label724: if (this.spotLightsLoc >= 0)
    {
      int i = 0;
      if (i < this.spotLights.length)
      {
        if ((localArray3 == null) || (i >= localArray3.size))
          if ((!this.lightsSet) || (this.spotLights[i].intensity != 0.0F))
            this.spotLights[i].intensity = 0.0F;
        while (true)
        {
          int j = this.spotLightsLoc + i * this.spotLightsSize;
          this.program.setUniformf(j + this.spotLightsColorOffset, this.spotLights[i].color.r * this.spotLights[i].intensity, this.spotLights[i].color.g * this.spotLights[i].intensity, this.spotLights[i].color.b * this.spotLights[i].intensity);
          this.program.setUniformf(j + this.spotLightsPositionOffset, this.spotLights[i].position);
          this.program.setUniformf(j + this.spotLightsDirectionOffset, this.spotLights[i].direction);
          this.program.setUniformf(j + this.spotLightsCutoffAngleOffset, this.spotLights[i].cutoffAngle);
          this.program.setUniformf(j + this.spotLightsExponentOffset, this.spotLights[i].exponent);
          if (this.spotLightsIntensityOffset >= 0)
            this.program.setUniformf(j + this.spotLightsIntensityOffset, this.spotLights[i].intensity);
          if (this.spotLightsSize <= 0)
            break label1086;
          do
          {
            i++;
            break;
          }
          while ((this.lightsSet) && (this.spotLights[i].equals((SpotLight)localArray3.get(i))));
          this.spotLights[i].set((SpotLight)localArray3.get(i));
        }
      }
    }
    label1086: if (paramAttributes.has(ColorAttribute.Fog))
      set(this.u_fogColor, ((ColorAttribute)paramAttributes.get(ColorAttribute.Fog)).color);
    if ((localEnvironment != null) && (localEnvironment.shadowMap != null))
    {
      set(this.u_shadowMapProjViewTrans, localEnvironment.shadowMap.getProjViewTrans());
      set(this.u_shadowTexture, localEnvironment.shadowMap.getDepthMap());
      set(this.u_shadowPCFOffset, 1.0F / (2.0F * localEnvironment.shadowMap.getDepthMap().texture.getWidth()));
    }
    this.lightsSet = true;
  }

  protected void bindMaterial(Attributes paramAttributes)
  {
    int i;
    int j;
    label30: float f1;
    float f2;
    boolean bool1;
    Iterator localIterator;
    int k;
    int m;
    if (this.config.defaultCullFace == -1)
    {
      i = defaultCullFace;
      if (this.config.defaultDepthFunc != -1)
        break label143;
      j = defaultDepthFunc;
      f1 = 0.0F;
      f2 = 1.0F;
      bool1 = true;
      localIterator = paramAttributes.iterator();
      k = j;
      m = i;
    }
    Attribute localAttribute;
    label143: label280: 
    do
      while (true)
      {
        if (!localIterator.hasNext())
          break label319;
        localAttribute = (Attribute)localIterator.next();
        long l = localAttribute.type;
        if (BlendingAttribute.is(l))
        {
          this.context.setBlending(true, ((BlendingAttribute)localAttribute).sourceFunction, ((BlendingAttribute)localAttribute).destFunction);
          set(this.u_opacity, ((BlendingAttribute)localAttribute).opacity);
          continue;
          i = this.config.defaultCullFace;
          break;
          j = this.config.defaultDepthFunc;
          break label30;
        }
        if ((l & IntAttribute.CullFace) == IntAttribute.CullFace)
        {
          m = ((IntAttribute)localAttribute).value;
          continue;
        }
        if ((l & FloatAttribute.AlphaTest) == FloatAttribute.AlphaTest)
        {
          set(this.u_alphaTest, ((FloatAttribute)localAttribute).value);
          continue;
        }
        if ((l & DepthTestAttribute.Type) != DepthTestAttribute.Type)
          break label280;
        DepthTestAttribute localDepthTestAttribute = (DepthTestAttribute)localAttribute;
        int n = localDepthTestAttribute.depthFunc;
        float f3 = localDepthTestAttribute.depthRangeNear;
        float f4 = localDepthTestAttribute.depthRangeFar;
        boolean bool2 = localDepthTestAttribute.depthMask;
        f1 = f3;
        k = n;
        bool1 = bool2;
        f2 = f4;
      }
    while (this.config.ignoreUnimplemented);
    throw new GdxRuntimeException("Unknown material attribute: " + localAttribute.toString());
    label319: this.context.setCullFace(m);
    this.context.setDepthTest(k, f1, f2);
    this.context.setDepthMask(bool1);
  }

  public boolean canRender(Renderable paramRenderable)
  {
    Attributes localAttributes = combineAttributes(paramRenderable);
    if ((this.attributesMask == (localAttributes.getMask() | optionalAttributes)) && (this.vertexMask == paramRenderable.meshPart.mesh.getVertexAttributes().getMask()))
    {
      if (paramRenderable.environment != null);
      for (int i = 1; i == this.lighting; i = 0)
        return true;
    }
    return false;
  }

  public int compareTo(Shader paramShader)
  {
    int i;
    if (paramShader == null)
      i = -1;
    do
    {
      return i;
      i = 0;
    }
    while (paramShader != this);
    return 0;
  }

  public void dispose()
  {
    this.program.dispose();
    super.dispose();
  }

  public void end()
  {
    super.end();
  }

  public boolean equals(DefaultShader paramDefaultShader)
  {
    return paramDefaultShader == this;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DefaultShader))
      return equals((DefaultShader)paramObject);
    return false;
  }

  public int getDefaultCullFace()
  {
    if (this.config.defaultCullFace == -1)
      return defaultCullFace;
    return this.config.defaultCullFace;
  }

  public int getDefaultDepthFunc()
  {
    if (this.config.defaultDepthFunc == -1)
      return defaultDepthFunc;
    return this.config.defaultDepthFunc;
  }

  public void init()
  {
    int i = -1;
    ShaderProgram localShaderProgram = this.program;
    this.program = null;
    init(localShaderProgram, this.renderable);
    this.renderable = null;
    this.dirLightsLoc = loc(this.u_dirLights0color);
    this.dirLightsColorOffset = (loc(this.u_dirLights0color) - this.dirLightsLoc);
    this.dirLightsDirectionOffset = (loc(this.u_dirLights0direction) - this.dirLightsLoc);
    this.dirLightsSize = (loc(this.u_dirLights1color) - this.dirLightsLoc);
    if (this.dirLightsSize < 0)
      this.dirLightsSize = 0;
    this.pointLightsLoc = loc(this.u_pointLights0color);
    this.pointLightsColorOffset = (loc(this.u_pointLights0color) - this.pointLightsLoc);
    this.pointLightsPositionOffset = (loc(this.u_pointLights0position) - this.pointLightsLoc);
    if (has(this.u_pointLights0intensity));
    for (int j = loc(this.u_pointLights0intensity) - this.pointLightsLoc; ; j = i)
    {
      this.pointLightsIntensityOffset = j;
      this.pointLightsSize = (loc(this.u_pointLights1color) - this.pointLightsLoc);
      if (this.pointLightsSize < 0)
        this.pointLightsSize = 0;
      this.spotLightsLoc = loc(this.u_spotLights0color);
      this.spotLightsColorOffset = (loc(this.u_spotLights0color) - this.spotLightsLoc);
      this.spotLightsPositionOffset = (loc(this.u_spotLights0position) - this.spotLightsLoc);
      this.spotLightsDirectionOffset = (loc(this.u_spotLights0direction) - this.spotLightsLoc);
      if (has(this.u_spotLights0intensity))
        i = loc(this.u_spotLights0intensity) - this.spotLightsLoc;
      this.spotLightsIntensityOffset = i;
      this.spotLightsCutoffAngleOffset = (loc(this.u_spotLights0cutoffAngle) - this.spotLightsLoc);
      this.spotLightsExponentOffset = (loc(this.u_spotLights0exponent) - this.spotLightsLoc);
      this.spotLightsSize = (loc(this.u_spotLights1color) - this.spotLightsLoc);
      if (this.spotLightsSize < 0)
        this.spotLightsSize = 0;
      return;
    }
  }

  public void render(Renderable paramRenderable, Attributes paramAttributes)
  {
    if (!paramAttributes.has(BlendingAttribute.Type))
      this.context.setBlending(false, 770, 771);
    bindMaterial(paramAttributes);
    if (this.lighting)
      bindLights(paramRenderable, paramAttributes);
    super.render(paramRenderable, paramAttributes);
  }

  public void setDefaultCullFace(int paramInt)
  {
    this.config.defaultCullFace = paramInt;
  }

  public void setDefaultDepthFunc(int paramInt)
  {
    this.config.defaultDepthFunc = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DefaultShader
 * JD-Core Version:    0.6.0
 */