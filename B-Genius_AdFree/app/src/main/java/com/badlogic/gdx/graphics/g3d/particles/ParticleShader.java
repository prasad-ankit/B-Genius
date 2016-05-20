package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ParticleShader extends BaseShader
{
  static final Vector3 TMP_VECTOR3;
  private static String defaultFragmentShader;
  private static String defaultVertexShader = null;
  protected static long implementedFlags;
  private static final long optionalAttributes;
  protected final ParticleShader.Config config;
  Material currentMaterial;
  private long materialMask;
  private Renderable renderable;
  private long vertexMask;

  static
  {
    defaultFragmentShader = null;
    implementedFlags = BlendingAttribute.Type | TextureAttribute.Diffuse;
    TMP_VECTOR3 = new Vector3();
    optionalAttributes = IntAttribute.CullFace | DepthTestAttribute.Type;
  }

  public ParticleShader(Renderable paramRenderable)
  {
    this(paramRenderable, new ParticleShader.Config());
  }

  public ParticleShader(Renderable paramRenderable, ParticleShader.Config paramConfig)
  {
    this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
  }

  public ParticleShader(Renderable paramRenderable, ParticleShader.Config paramConfig, ShaderProgram paramShaderProgram)
  {
    this.config = paramConfig;
    this.program = paramShaderProgram;
    this.renderable = paramRenderable;
    this.materialMask = (paramRenderable.material.getMask() | optionalAttributes);
    this.vertexMask = paramRenderable.meshPart.mesh.getVertexAttributes().getMask();
    if ((!paramConfig.ignoreUnimplemented) && ((implementedFlags & this.materialMask) != this.materialMask))
      throw new GdxRuntimeException("Some attributes not implemented yet (" + this.materialMask + ")");
    register(DefaultShader.Inputs.viewTrans, DefaultShader.Setters.viewTrans);
    register(DefaultShader.Inputs.projViewTrans, DefaultShader.Setters.projViewTrans);
    register(DefaultShader.Inputs.projTrans, DefaultShader.Setters.projTrans);
    register(ParticleShader.Inputs.screenWidth, ParticleShader.Setters.screenWidth);
    register(DefaultShader.Inputs.cameraUp, ParticleShader.Setters.cameraUp);
    register(ParticleShader.Inputs.cameraRight, ParticleShader.Setters.cameraRight);
    register(ParticleShader.Inputs.cameraInvDirection, ParticleShader.Setters.cameraInvDirection);
    register(DefaultShader.Inputs.cameraPosition, ParticleShader.Setters.cameraPosition);
    register(DefaultShader.Inputs.diffuseTexture, DefaultShader.Setters.diffuseTexture);
  }

  public ParticleShader(Renderable paramRenderable, ParticleShader.Config paramConfig, String paramString)
  {
  }

  public ParticleShader(Renderable paramRenderable, ParticleShader.Config paramConfig, String paramString1, String paramString2, String paramString3)
  {
    this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
  }

  public static String createPrefix(Renderable paramRenderable, ParticleShader.Config paramConfig)
  {
    String str;
    if (Gdx.app.getType() == Application.ApplicationType.Desktop)
    {
      str = "" + "#version 120\n";
      if (paramConfig.type == ParticleShader.ParticleType.Billboard)
      {
        str = str + "#define billboard\n";
        if (paramConfig.align != ParticleShader.AlignMode.Screen)
          break label123;
        str = str + "#define screenFacing\n";
      }
    }
    label123: 
    do
    {
      return str;
      str = "" + "#version 100\n";
      break;
    }
    while (paramConfig.align != ParticleShader.AlignMode.ViewPoint);
    return str + "#define viewPointFacing\n";
  }

  public static String getDefaultFragmentShader()
  {
    if (defaultFragmentShader == null)
      defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.fragment.glsl").readString();
    return defaultFragmentShader;
  }

  public static String getDefaultVertexShader()
  {
    if (defaultVertexShader == null)
      defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.vertex.glsl").readString();
    return defaultVertexShader;
  }

  public void begin(Camera paramCamera, RenderContext paramRenderContext)
  {
    super.begin(paramCamera, paramRenderContext);
  }

  protected void bindMaterial(Renderable paramRenderable)
  {
    if (this.currentMaterial == paramRenderable.material)
      return;
    int i;
    int j;
    label42: Iterator localIterator;
    float f1;
    float f2;
    int k;
    boolean bool1;
    if (this.config.defaultCullFace == -1)
    {
      i = 1029;
      if (this.config.defaultDepthFunc != -1)
        break label146;
      j = 515;
      this.currentMaterial = paramRenderable.material;
      localIterator = this.currentMaterial.iterator();
      f1 = 1.0F;
      f2 = 0.0F;
      k = j;
      bool1 = true;
    }
    Attribute localAttribute;
    label146: label224: 
    do
      while (true)
      {
        if (!localIterator.hasNext())
          break label263;
        localAttribute = (Attribute)localIterator.next();
        long l = localAttribute.type;
        if (BlendingAttribute.is(l))
        {
          this.context.setBlending(true, ((BlendingAttribute)localAttribute).sourceFunction, ((BlendingAttribute)localAttribute).destFunction);
          continue;
          i = this.config.defaultCullFace;
          break;
          j = this.config.defaultDepthFunc;
          break label42;
        }
        if ((l & DepthTestAttribute.Type) != DepthTestAttribute.Type)
          break label224;
        DepthTestAttribute localDepthTestAttribute = (DepthTestAttribute)localAttribute;
        int m = localDepthTestAttribute.depthFunc;
        float f3 = localDepthTestAttribute.depthRangeNear;
        float f4 = localDepthTestAttribute.depthRangeFar;
        boolean bool2 = localDepthTestAttribute.depthMask;
        f2 = f3;
        k = m;
        bool1 = bool2;
        f1 = f4;
      }
    while (this.config.ignoreUnimplemented);
    throw new GdxRuntimeException("Unknown material attribute: " + localAttribute.toString());
    label263: this.context.setCullFace(i);
    this.context.setDepthTest(k, f2, f1);
    this.context.setDepthMask(bool1);
  }

  public boolean canRender(Renderable paramRenderable)
  {
    return (this.materialMask == (paramRenderable.material.getMask() | optionalAttributes)) && (this.vertexMask == paramRenderable.meshPart.mesh.getVertexAttributes().getMask());
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
    this.currentMaterial = null;
    super.end();
  }

  public boolean equals(ParticleShader paramParticleShader)
  {
    return paramParticleShader == this;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ParticleShader))
      return equals((ParticleShader)paramObject);
    return false;
  }

  public int getDefaultCullFace()
  {
    if (this.config.defaultCullFace == -1)
      return 1029;
    return this.config.defaultCullFace;
  }

  public int getDefaultDepthFunc()
  {
    if (this.config.defaultDepthFunc == -1)
      return 515;
    return this.config.defaultDepthFunc;
  }

  public void init()
  {
    ShaderProgram localShaderProgram = this.program;
    this.program = null;
    init(localShaderProgram, this.renderable);
    this.renderable = null;
  }

  public void render(Renderable paramRenderable)
  {
    if (!paramRenderable.material.has(BlendingAttribute.Type))
      this.context.setBlending(false, 770, 771);
    bindMaterial(paramRenderable);
    super.render(paramRenderable);
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
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ParticleShader
 * JD-Core Version:    0.6.0
 */