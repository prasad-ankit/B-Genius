package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntIntMap;

public abstract class BaseShader
  implements Shader
{
  private final IntIntMap attributes = new IntIntMap();
  public Camera camera;
  private Attributes combinedAttributes = new Attributes();
  public RenderContext context;
  private Mesh currentMesh;
  private final IntArray globalUniforms = new IntArray();
  private final IntArray localUniforms = new IntArray();
  private int[] locations;
  public ShaderProgram program;
  private final Array setters = new Array();
  private final IntArray tempArray = new IntArray();
  private final Array uniforms = new Array();
  private final Array validators = new Array();

  private final int[] getAttributeLocations(VertexAttributes paramVertexAttributes)
  {
    this.tempArray.clear();
    int i = paramVertexAttributes.size();
    for (int j = 0; j < i; j++)
      this.tempArray.add(this.attributes.get(paramVertexAttributes.get(j).getKey(), -1));
    return this.tempArray.items;
  }

  public void begin(Camera paramCamera, RenderContext paramRenderContext)
  {
    this.camera = paramCamera;
    this.context = paramRenderContext;
    this.program.begin();
    this.currentMesh = null;
    for (int i = 0; i < this.globalUniforms.size; i++)
    {
      Array localArray = this.setters;
      int j = this.globalUniforms.get(i);
      if (localArray.get(j) == null)
        continue;
      ((BaseShader.Setter)this.setters.get(j)).set(this, j, null, null);
    }
  }

  public void dispose()
  {
    this.program = null;
    this.uniforms.clear();
    this.validators.clear();
    this.setters.clear();
    this.localUniforms.clear();
    this.globalUniforms.clear();
    this.locations = null;
  }

  public void end()
  {
    if (this.currentMesh != null)
    {
      this.currentMesh.unbind(this.program, this.tempArray.items);
      this.currentMesh = null;
    }
    this.program.end();
  }

  public String getUniformAlias(int paramInt)
  {
    return (String)this.uniforms.get(paramInt);
  }

  public int getUniformID(String paramString)
  {
    int i = this.uniforms.size;
    for (int j = 0; j < i; j++)
      if (((String)this.uniforms.get(j)).equals(paramString))
        return j;
    return -1;
  }

  public final boolean has(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.locations.length) && (this.locations[paramInt] >= 0);
  }

  public void init(ShaderProgram paramShaderProgram, Renderable paramRenderable)
  {
    if (this.locations != null)
      throw new GdxRuntimeException("Already initialized");
    if (!paramShaderProgram.isCompiled())
      throw new GdxRuntimeException(paramShaderProgram.getLog());
    this.program = paramShaderProgram;
    int i = this.uniforms.size;
    this.locations = new int[i];
    int j = 0;
    if (j < i)
    {
      String str = (String)this.uniforms.get(j);
      BaseShader.Validator localValidator = (BaseShader.Validator)this.validators.get(j);
      BaseShader.Setter localSetter = (BaseShader.Setter)this.setters.get(j);
      if ((localValidator != null) && (!localValidator.validate(this, j, paramRenderable)))
        this.locations[j] = -1;
      while (true)
      {
        if (this.locations[j] < 0)
        {
          this.validators.set(j, null);
          this.setters.set(j, null);
        }
        j++;
        break;
        this.locations[j] = paramShaderProgram.fetchUniformLocation(str, false);
        if ((this.locations[j] < 0) || (localSetter == null))
          continue;
        if (localSetter.isGlobal(this, j))
        {
          this.globalUniforms.add(j);
          continue;
        }
        this.localUniforms.add(j);
      }
    }
    if (paramRenderable != null)
    {
      VertexAttributes localVertexAttributes = paramRenderable.meshPart.mesh.getVertexAttributes();
      int k = localVertexAttributes.size();
      for (int m = 0; m < k; m++)
      {
        VertexAttribute localVertexAttribute = localVertexAttributes.get(m);
        int n = paramShaderProgram.getAttributeLocation(localVertexAttribute.alias);
        if (n < 0)
          continue;
        this.attributes.put(localVertexAttribute.getKey(), n);
      }
    }
  }

  public final int loc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.locations.length))
      return this.locations[paramInt];
    return -1;
  }

  public int register(BaseShader.Uniform paramUniform)
  {
    return register(paramUniform, null);
  }

  public int register(BaseShader.Uniform paramUniform, BaseShader.Setter paramSetter)
  {
    return register(paramUniform.alias, paramUniform, paramSetter);
  }

  public int register(String paramString)
  {
    return register(paramString, null, null);
  }

  public int register(String paramString, BaseShader.Setter paramSetter)
  {
    return register(paramString, null, paramSetter);
  }

  public int register(String paramString, BaseShader.Validator paramValidator)
  {
    return register(paramString, paramValidator, null);
  }

  public int register(String paramString, BaseShader.Validator paramValidator, BaseShader.Setter paramSetter)
  {
    if (this.locations != null)
      throw new GdxRuntimeException("Cannot register an uniform after initialization");
    int i = getUniformID(paramString);
    if (i >= 0)
    {
      this.validators.set(i, paramValidator);
      this.setters.set(i, paramSetter);
      return i;
    }
    this.uniforms.add(paramString);
    this.validators.add(paramValidator);
    this.setters.add(paramSetter);
    return -1 + this.uniforms.size;
  }

  public void render(Renderable paramRenderable)
  {
    if (paramRenderable.worldTransform.det3x3() == 0.0F)
      return;
    this.combinedAttributes.clear();
    if (paramRenderable.environment != null)
      this.combinedAttributes.set(paramRenderable.environment);
    if (paramRenderable.material != null)
      this.combinedAttributes.set(paramRenderable.material);
    render(paramRenderable, this.combinedAttributes);
  }

  public void render(Renderable paramRenderable, Attributes paramAttributes)
  {
    for (int i = 0; i < this.localUniforms.size; i++)
    {
      Array localArray = this.setters;
      int j = this.localUniforms.get(i);
      if (localArray.get(j) == null)
        continue;
      ((BaseShader.Setter)this.setters.get(j)).set(this, j, paramRenderable, paramAttributes);
    }
    if (this.currentMesh != paramRenderable.meshPart.mesh)
    {
      if (this.currentMesh != null)
        this.currentMesh.unbind(this.program, this.tempArray.items);
      this.currentMesh = paramRenderable.meshPart.mesh;
      this.currentMesh.bind(this.program, getAttributeLocations(paramRenderable.meshPart.mesh.getVertexAttributes()));
    }
    paramRenderable.meshPart.render(this.program, false);
  }

  public final boolean set(int paramInt, float paramFloat)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramFloat);
    return true;
  }

  public final boolean set(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2);
    return true;
  }

  public final boolean set(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2, paramFloat3);
    return true;
  }

  public final boolean set(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return true;
  }

  public final boolean set(int paramInt1, int paramInt2)
  {
    if (this.locations[paramInt1] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt1], paramInt2);
    return true;
  }

  public final boolean set(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.locations[paramInt1] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3);
    return true;
  }

  public final boolean set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.locations[paramInt1] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3, paramInt4);
    return true;
  }

  public final boolean set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.locations[paramInt1] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt1], paramInt2, paramInt3, paramInt4, paramInt5);
    return true;
  }

  public final boolean set(int paramInt, Color paramColor)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramColor);
    return true;
  }

  public final boolean set(int paramInt, GLTexture paramGLTexture)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt], this.context.textureBinder.bind(paramGLTexture));
    return true;
  }

  public final boolean set(int paramInt, TextureDescriptor paramTextureDescriptor)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformi(this.locations[paramInt], this.context.textureBinder.bind(paramTextureDescriptor));
    return true;
  }

  public final boolean set(int paramInt, Matrix3 paramMatrix3)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformMatrix(this.locations[paramInt], paramMatrix3);
    return true;
  }

  public final boolean set(int paramInt, Matrix4 paramMatrix4)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformMatrix(this.locations[paramInt], paramMatrix4);
    return true;
  }

  public final boolean set(int paramInt, Vector2 paramVector2)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramVector2);
    return true;
  }

  public final boolean set(int paramInt, Vector3 paramVector3)
  {
    if (this.locations[paramInt] < 0)
      return false;
    this.program.setUniformf(this.locations[paramInt], paramVector3);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.shaders.BaseShader
 * JD-Core Version:    0.6.0
 */