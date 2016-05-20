package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class DepthShader extends DefaultShader
{
  private static String defaultFragmentShader;
  private static String defaultVertexShader = null;
  private static final Attributes tmpAttributes;
  private final FloatAttribute alphaTestAttribute;
  public final int numBones;
  public final int weights;

  static
  {
    defaultFragmentShader = null;
    tmpAttributes = new Attributes();
  }

  public DepthShader(Renderable paramRenderable)
  {
    this(paramRenderable, new DepthShader.Config());
  }

  public DepthShader(Renderable paramRenderable, DepthShader.Config paramConfig)
  {
    this(paramRenderable, paramConfig, createPrefix(paramRenderable, paramConfig));
  }

  public DepthShader(Renderable paramRenderable, DepthShader.Config paramConfig, ShaderProgram paramShaderProgram)
  {
    super(paramRenderable, paramConfig, paramShaderProgram);
    combineAttributes(paramRenderable);
    if (paramRenderable.bones == null);
    int m;
    for (int j = 0; ; j = paramConfig.numBones)
    {
      this.numBones = j;
      int k = paramRenderable.meshPart.mesh.getVertexAttributes().size();
      m = 0;
      while (i < k)
      {
        VertexAttribute localVertexAttribute = paramRenderable.meshPart.mesh.getVertexAttributes().get(i);
        if (localVertexAttribute.usage == 64)
          m |= 1 << localVertexAttribute.unit;
        i++;
      }
    }
    this.weights = m;
    this.alphaTestAttribute = new FloatAttribute(FloatAttribute.AlphaTest, paramConfig.defaultAlphaTest);
  }

  public DepthShader(Renderable paramRenderable, DepthShader.Config paramConfig, String paramString)
  {
  }

  public DepthShader(Renderable paramRenderable, DepthShader.Config paramConfig, String paramString1, String paramString2, String paramString3)
  {
    this(paramRenderable, paramConfig, new ShaderProgram(paramString1 + paramString2, paramString1 + paramString3));
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

  public static String createPrefix(Renderable paramRenderable, DepthShader.Config paramConfig)
  {
    String str = DefaultShader.createPrefix(paramRenderable, paramConfig);
    if (!paramConfig.depthBufferOnly)
      str = str + "#define PackedDepthFlag\n";
    return str;
  }

  public static final String getDefaultFragmentShader()
  {
    if (defaultFragmentShader == null)
      defaultFragmentShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString();
    return defaultFragmentShader;
  }

  public static final String getDefaultVertexShader()
  {
    if (defaultVertexShader == null)
      defaultVertexShader = Gdx.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString();
    return defaultVertexShader;
  }

  public void begin(Camera paramCamera, RenderContext paramRenderContext)
  {
    super.begin(paramCamera, paramRenderContext);
  }

  public boolean canRender(Renderable paramRenderable)
  {
    Attributes localAttributes = combineAttributes(paramRenderable);
    if (localAttributes.has(BlendingAttribute.Type))
      if ((this.attributesMask & BlendingAttribute.Type) == BlendingAttribute.Type);
    label59: label92: label118: label120: label125: int n;
    label129: label131: 
    do
    {
      while (true)
      {
        return false;
        boolean bool1 = localAttributes.has(TextureAttribute.Diffuse);
        boolean bool2;
        int i;
        if ((this.attributesMask & TextureAttribute.Diffuse) == TextureAttribute.Diffuse)
        {
          bool2 = true;
          if (bool1 != bool2)
            break label118;
          if ((0x40 & paramRenderable.meshPart.mesh.getVertexAttributes().getMask()) != 64L)
            break label120;
          i = 1;
          if (this.numBones <= 0)
            break label125;
        }
        for (int j = 1; ; j = 0)
        {
          if (i != j)
            break label129;
          if (i != 0)
            break label131;
          return true;
          bool2 = false;
          break label59;
          break;
          i = 0;
          break label92;
        }
      }
      int k = paramRenderable.meshPart.mesh.getVertexAttributes().size();
      int m = 0;
      n = 0;
      while (m < k)
      {
        VertexAttribute localVertexAttribute = paramRenderable.meshPart.mesh.getVertexAttributes().get(m);
        if (localVertexAttribute.usage == 64)
          n |= 1 << localVertexAttribute.unit;
        m++;
      }
    }
    while (n != this.weights);
    return true;
  }

  public void end()
  {
    super.end();
  }

  public void render(Renderable paramRenderable, Attributes paramAttributes)
  {
    if (paramAttributes.has(BlendingAttribute.Type))
    {
      BlendingAttribute localBlendingAttribute = (BlendingAttribute)paramAttributes.get(BlendingAttribute.Type);
      paramAttributes.remove(BlendingAttribute.Type);
      boolean bool = paramAttributes.has(FloatAttribute.AlphaTest);
      if (!bool)
        paramAttributes.set(this.alphaTestAttribute);
      if (localBlendingAttribute.opacity >= ((FloatAttribute)paramAttributes.get(FloatAttribute.AlphaTest)).value)
        super.render(paramRenderable, paramAttributes);
      if (!bool)
        paramAttributes.remove(FloatAttribute.AlphaTest);
      paramAttributes.set(localBlendingAttribute);
      return;
    }
    super.render(paramRenderable, paramAttributes);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.DepthShader
 * JD-Core Version:    0.6.0
 */