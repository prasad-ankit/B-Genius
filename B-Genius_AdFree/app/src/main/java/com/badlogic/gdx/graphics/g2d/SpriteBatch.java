package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Mesh.VertexDataType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.NumberUtils;
import java.nio.ShortBuffer;

public class SpriteBatch
  implements Batch
{
  private int blendDstFunc = 771;
  private int blendSrcFunc = 770;
  private boolean blendingDisabled = false;
  float color = Color.WHITE.toFloatBits();
  private final Matrix4 combinedMatrix = new Matrix4();
  private ShaderProgram customShader = null;
  boolean drawing = false;
  int idx = 0;
  float invTexHeight = 0.0F;
  float invTexWidth = 0.0F;
  Texture lastTexture = null;
  public int maxSpritesInBatch = 0;
  private Mesh mesh;
  private boolean ownsShader;
  private final Matrix4 projectionMatrix = new Matrix4();
  public int renderCalls = 0;
  private final ShaderProgram shader;
  private Color tempColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public int totalRenderCalls = 0;
  private final Matrix4 transformMatrix = new Matrix4();
  final float[] vertices;

  public SpriteBatch()
  {
    this(1000, null);
  }

  public SpriteBatch(int paramInt)
  {
    this(paramInt, null);
  }

  public SpriteBatch(int paramInt, ShaderProgram paramShaderProgram)
  {
    if (paramInt > 5460)
      throw new IllegalArgumentException("Can't have more than 5460 sprites per batch: " + paramInt);
    Mesh.VertexDataType localVertexDataType = Mesh.VertexDataType.VertexArray;
    if (Gdx.gl30 != null)
      localVertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
    int j = paramInt << 2;
    int k = paramInt * 6;
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[3];
    arrayOfVertexAttribute[0] = new VertexAttribute(1, 2, "a_position");
    arrayOfVertexAttribute[1] = new VertexAttribute(4, 4, "a_color");
    arrayOfVertexAttribute[2] = new VertexAttribute(16, 2, "a_texCoord0");
    this.mesh = new Mesh(localVertexDataType, false, j, k, arrayOfVertexAttribute);
    this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    this.vertices = new float[paramInt * 20];
    int m = paramInt * 6;
    short[] arrayOfShort = new short[m];
    for (int n = 0; i < m; n = (short)(n + 4))
    {
      arrayOfShort[i] = n;
      arrayOfShort[(i + 1)] = (short)(n + 1);
      arrayOfShort[(i + 2)] = (short)(n + 2);
      arrayOfShort[(i + 3)] = (short)(n + 2);
      arrayOfShort[(i + 4)] = (short)(n + 3);
      arrayOfShort[(i + 5)] = n;
      i += 6;
    }
    this.mesh.setIndices(arrayOfShort);
    if (paramShaderProgram == null)
    {
      this.shader = createDefaultShader();
      this.ownsShader = true;
      return;
    }
    this.shader = paramShaderProgram;
  }

  public static ShaderProgram createDefaultShader()
  {
    ShaderProgram localShaderProgram = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
    if (!localShaderProgram.isCompiled())
      throw new IllegalArgumentException("Error compiling shader: " + localShaderProgram.getLog());
    return localShaderProgram;
  }

  private void setupMatrices()
  {
    this.combinedMatrix.set(this.projectionMatrix).mul(this.transformMatrix);
    if (this.customShader != null)
    {
      this.customShader.setUniformMatrix("u_projTrans", this.combinedMatrix);
      this.customShader.setUniformi("u_texture", 0);
      return;
    }
    this.shader.setUniformMatrix("u_projTrans", this.combinedMatrix);
    this.shader.setUniformi("u_texture", 0);
  }

  public void begin()
  {
    if (this.drawing)
      throw new IllegalStateException("SpriteBatch.end must be called before begin.");
    this.renderCalls = 0;
    Gdx.gl.glDepthMask(false);
    if (this.customShader != null)
      this.customShader.begin();
    while (true)
    {
      setupMatrices();
      this.drawing = true;
      return;
      this.shader.begin();
    }
  }

  public void disableBlending()
  {
    if (this.blendingDisabled)
      return;
    flush();
    this.blendingDisabled = true;
  }

  public void dispose()
  {
    this.mesh.dispose();
    if ((this.ownsShader) && (this.shader != null))
      this.shader.dispose();
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2)
  {
    draw(paramTexture, paramFloat1, paramFloat2, paramTexture.getWidth(), paramTexture.getHeight());
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = paramFloat1;
      int k = j + 1;
      arrayOfFloat[j] = paramFloat2;
      int m = k + 1;
      arrayOfFloat[k] = f3;
      int n = m + 1;
      arrayOfFloat[m] = 0.0F;
      int i1 = n + 1;
      arrayOfFloat[n] = 1.0F;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat1;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f2;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f3;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = 0.0F;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = 0.0F;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f1;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f2;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f3;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = 1.0F;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = 0.0F;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f1;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = paramFloat2;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f3;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = 1.0F;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = 1.0F;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = paramFloat1;
      int k = j + 1;
      arrayOfFloat[j] = paramFloat2;
      int m = k + 1;
      arrayOfFloat[k] = f3;
      int n = m + 1;
      arrayOfFloat[m] = paramFloat5;
      int i1 = n + 1;
      arrayOfFloat[n] = paramFloat6;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat1;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f2;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f3;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = paramFloat5;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = paramFloat8;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f1;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f2;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f3;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = paramFloat7;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = paramFloat8;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f1;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = paramFloat2;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f3;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = paramFloat7;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = paramFloat6;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f10;
    float f15;
    float f11;
    float f14;
    float f8;
    float f9;
    float f13;
    label245: float f16;
    float f17;
    float f18;
    float f19;
    float f20;
    float f21;
    float f22;
    float f23;
    float f24;
    float f25;
    float f26;
    float f27;
    if (paramTexture != this.lastTexture)
    {
      switchTexture(paramTexture);
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      f3 = -paramFloat3;
      f4 = -paramFloat4;
      f5 = paramFloat5 - paramFloat3;
      f6 = paramFloat6 - paramFloat4;
      if ((paramFloat7 != 1.0F) || (paramFloat8 != 1.0F))
      {
        f3 *= paramFloat7;
        f4 *= paramFloat8;
        f5 *= paramFloat7;
        f6 *= paramFloat8;
      }
      if (paramFloat9 == 0.0F)
        break label653;
      float f31 = MathUtils.cosDeg(paramFloat9);
      float f32 = MathUtils.sinDeg(paramFloat9);
      f7 = f31 * f3 - f32 * f4;
      float f33 = f32 * f3 + f4 * f31;
      float f34 = f31 * f3 - f32 * f6;
      f10 = f3 * f32 + f31 * f6;
      f15 = f31 * f5 - f32 * f6;
      float f35 = f32 * f5 + f31 * f6;
      f11 = f7 + (f15 - f34);
      f14 = f35 - (f10 - f33);
      f8 = f33;
      f9 = f35;
      f13 = f34;
      f16 = f7 + f1;
      f17 = f8 + f2;
      f18 = f13 + f1;
      f19 = f10 + f2;
      f20 = f15 + f1;
      f21 = f9 + f2;
      f22 = f11 + f1;
      f23 = f14 + f2;
      f24 = paramInt1 * this.invTexWidth;
      f25 = (paramInt2 + paramInt4) * this.invTexHeight;
      f26 = (paramInt1 + paramInt3) * this.invTexWidth;
      f27 = paramInt2 * this.invTexHeight;
      if (!paramBoolean1)
        break label707;
    }
    while (true)
    {
      if (paramBoolean2);
      while (true)
      {
        float f30 = this.color;
        int i = this.idx;
        int j = i + 1;
        arrayOfFloat[i] = f16;
        int k = j + 1;
        arrayOfFloat[j] = f17;
        int m = k + 1;
        arrayOfFloat[k] = f30;
        int n = m + 1;
        arrayOfFloat[m] = f26;
        int i1 = n + 1;
        arrayOfFloat[n] = f27;
        int i2 = i1 + 1;
        arrayOfFloat[i1] = f18;
        int i3 = i2 + 1;
        arrayOfFloat[i2] = f19;
        int i4 = i3 + 1;
        arrayOfFloat[i3] = f30;
        int i5 = i4 + 1;
        arrayOfFloat[i4] = f26;
        int i6 = i5 + 1;
        arrayOfFloat[i5] = f25;
        int i7 = i6 + 1;
        arrayOfFloat[i6] = f20;
        int i8 = i7 + 1;
        arrayOfFloat[i7] = f21;
        int i9 = i8 + 1;
        arrayOfFloat[i8] = f30;
        int i10 = i9 + 1;
        arrayOfFloat[i9] = f24;
        int i11 = i10 + 1;
        arrayOfFloat[i10] = f25;
        int i12 = i11 + 1;
        arrayOfFloat[i11] = f22;
        int i13 = i12 + 1;
        arrayOfFloat[i12] = f23;
        int i14 = i13 + 1;
        arrayOfFloat[i13] = f30;
        int i15 = i14 + 1;
        arrayOfFloat[i14] = f24;
        int i16 = i15 + 1;
        arrayOfFloat[i15] = f27;
        this.idx = i16;
        return;
        if (this.idx != arrayOfFloat.length)
          break;
        flush();
        break;
        label653: f7 = f3;
        f8 = f4;
        f9 = f6;
        f10 = f6;
        f11 = f5;
        float f12 = f5;
        f13 = f3;
        f14 = f4;
        f15 = f12;
        break label245;
        float f29 = f25;
        f25 = f27;
        f27 = f29;
      }
      label707: float f28 = f24;
      f24 = f26;
      f26 = f28;
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (paramTexture != this.lastTexture)
    {
      switchTexture(paramTexture);
      f1 = paramInt1 * this.invTexWidth;
      f2 = (paramInt2 + paramInt4) * this.invTexHeight;
      f3 = (paramInt1 + paramInt3) * this.invTexWidth;
      f4 = paramInt2 * this.invTexHeight;
      f5 = paramFloat1 + paramFloat3;
      f6 = paramFloat2 + paramFloat4;
      if (!paramBoolean1)
        break label411;
    }
    while (true)
    {
      if (paramBoolean2);
      while (true)
      {
        float f9 = this.color;
        int i = this.idx;
        int j = i + 1;
        arrayOfFloat[i] = paramFloat1;
        int k = j + 1;
        arrayOfFloat[j] = paramFloat2;
        int m = k + 1;
        arrayOfFloat[k] = f9;
        int n = m + 1;
        arrayOfFloat[m] = f3;
        int i1 = n + 1;
        arrayOfFloat[n] = f4;
        int i2 = i1 + 1;
        arrayOfFloat[i1] = paramFloat1;
        int i3 = i2 + 1;
        arrayOfFloat[i2] = f6;
        int i4 = i3 + 1;
        arrayOfFloat[i3] = f9;
        int i5 = i4 + 1;
        arrayOfFloat[i4] = f3;
        int i6 = i5 + 1;
        arrayOfFloat[i5] = f2;
        int i7 = i6 + 1;
        arrayOfFloat[i6] = f5;
        int i8 = i7 + 1;
        arrayOfFloat[i7] = f6;
        int i9 = i8 + 1;
        arrayOfFloat[i8] = f9;
        int i10 = i9 + 1;
        arrayOfFloat[i9] = f1;
        int i11 = i10 + 1;
        arrayOfFloat[i10] = f2;
        int i12 = i11 + 1;
        arrayOfFloat[i11] = f5;
        int i13 = i12 + 1;
        arrayOfFloat[i12] = paramFloat2;
        int i14 = i13 + 1;
        arrayOfFloat[i13] = f9;
        int i15 = i14 + 1;
        arrayOfFloat[i14] = f1;
        int i16 = i15 + 1;
        arrayOfFloat[i15] = f4;
        this.idx = i16;
        return;
        if (this.idx != arrayOfFloat.length)
          break;
        flush();
        break;
        float f8 = f2;
        f2 = f4;
        f4 = f8;
      }
      label411: float f7 = f3;
      f3 = f1;
      f1 = f7;
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      float f1 = paramInt1 * this.invTexWidth;
      float f2 = (paramInt2 + paramInt4) * this.invTexHeight;
      float f3 = (paramInt1 + paramInt3) * this.invTexWidth;
      float f4 = paramInt2 * this.invTexHeight;
      float f5 = paramFloat1 + paramInt3;
      float f6 = paramFloat2 + paramInt4;
      float f7 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = paramFloat1;
      int k = j + 1;
      arrayOfFloat[j] = paramFloat2;
      int m = k + 1;
      arrayOfFloat[k] = f7;
      int n = m + 1;
      arrayOfFloat[m] = f1;
      int i1 = n + 1;
      arrayOfFloat[n] = f2;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat1;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f6;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f7;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f4;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f5;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f6;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f7;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f3;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f4;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f5;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = paramFloat2;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f7;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f3;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f2;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    int i = this.vertices.length;
    int j;
    if (paramTexture != this.lastTexture)
    {
      switchTexture(paramTexture);
      j = i;
    }
    while (true)
    {
      int k = Math.min(j, paramInt2);
      System.arraycopy(paramArrayOfFloat, paramInt1, this.vertices, this.idx, k);
      this.idx = (k + this.idx);
      int m = paramInt2 - k;
      while (m > 0)
      {
        paramInt1 += k;
        flush();
        k = Math.min(i, m);
        System.arraycopy(paramArrayOfFloat, paramInt1, this.vertices, 0, k);
        this.idx = (k + this.idx);
        m -= k;
      }
      j = i - this.idx;
      if (j != 0)
        continue;
      flush();
      j = i;
    }
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2)
  {
    draw(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    while (true)
    {
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = paramTextureRegion.u;
      float f4 = paramTextureRegion.v2;
      float f5 = paramTextureRegion.u2;
      float f6 = paramTextureRegion.v;
      float f7 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = paramFloat1;
      int k = j + 1;
      arrayOfFloat[j] = paramFloat2;
      int m = k + 1;
      arrayOfFloat[k] = f7;
      int n = m + 1;
      arrayOfFloat[m] = f3;
      int i1 = n + 1;
      arrayOfFloat[n] = f4;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = paramFloat1;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f2;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f7;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f3;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f6;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f1;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f2;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f7;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f5;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f6;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f1;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = paramFloat2;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f7;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f5;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f4;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        continue;
      flush();
    }
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f11;
    float f8;
    float f9;
    float f13;
    float f10;
    float f12;
    if (localTexture != this.lastTexture)
    {
      switchTexture(localTexture);
      f1 = paramFloat1 + paramFloat3;
      f2 = paramFloat2 + paramFloat4;
      f3 = -paramFloat3;
      f4 = -paramFloat4;
      f5 = paramFloat5 - paramFloat3;
      f6 = paramFloat6 - paramFloat4;
      if ((paramFloat7 != 1.0F) || (paramFloat8 != 1.0F))
      {
        f3 *= paramFloat7;
        f4 *= paramFloat8;
        f5 *= paramFloat7;
        f6 *= paramFloat8;
      }
      if (paramFloat9 == 0.0F)
        break label637;
      float f27 = MathUtils.cosDeg(paramFloat9);
      float f28 = MathUtils.sinDeg(paramFloat9);
      f7 = f27 * f3 - f28 * f4;
      float f29 = f28 * f3 + f4 * f27;
      float f30 = f27 * f3 - f28 * f6;
      float f31 = f28 * f3 + f27 * f6;
      f11 = f27 * f5 - f28 * f6;
      float f32 = f28 * f5 + f27 * f6;
      float f33 = f7 + (f11 - f30);
      f4 = f32 - (f31 - f29);
      f8 = f30;
      f9 = f32;
      f13 = f29;
      f10 = f33;
      f12 = f31;
    }
    while (true)
    {
      float f14 = f7 + f1;
      float f15 = f13 + f2;
      float f16 = f8 + f1;
      float f17 = f12 + f2;
      float f18 = f11 + f1;
      float f19 = f9 + f2;
      float f20 = f10 + f1;
      float f21 = f4 + f2;
      float f22 = paramTextureRegion.u;
      float f23 = paramTextureRegion.v2;
      float f24 = paramTextureRegion.u2;
      float f25 = paramTextureRegion.v;
      float f26 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = f14;
      int k = j + 1;
      arrayOfFloat[j] = f15;
      int m = k + 1;
      arrayOfFloat[k] = f26;
      int n = m + 1;
      arrayOfFloat[m] = f22;
      int i1 = n + 1;
      arrayOfFloat[n] = f23;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = f16;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f17;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f26;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f22;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f25;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f18;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f19;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f26;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f24;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f25;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f20;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f21;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f26;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f24;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f23;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        break;
      flush();
      break;
      label637: f7 = f3;
      f8 = f3;
      f9 = f6;
      f10 = f5;
      f11 = f5;
      f12 = f6;
      f13 = f4;
    }
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f11;
    float f8;
    float f9;
    float f13;
    float f10;
    float f12;
    label261: float f14;
    float f15;
    float f16;
    float f17;
    float f18;
    float f19;
    float f20;
    float f21;
    float f22;
    float f23;
    float f24;
    float f25;
    float f26;
    float f27;
    float f28;
    float f29;
    if (localTexture != this.lastTexture)
    {
      switchTexture(localTexture);
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      f3 = -paramFloat3;
      f4 = -paramFloat4;
      f5 = paramFloat5 - paramFloat3;
      f6 = paramFloat6 - paramFloat4;
      if ((paramFloat7 != 1.0F) || (paramFloat8 != 1.0F))
      {
        f3 *= paramFloat7;
        f4 *= paramFloat8;
        f5 *= paramFloat7;
        f6 *= paramFloat8;
      }
      if (paramFloat9 == 0.0F)
        break label666;
      float f31 = MathUtils.cosDeg(paramFloat9);
      float f32 = MathUtils.sinDeg(paramFloat9);
      f7 = f31 * f3 - f32 * f4;
      float f33 = f32 * f3 + f4 * f31;
      float f34 = f31 * f3 - f32 * f6;
      float f35 = f32 * f3 + f31 * f6;
      f11 = f31 * f5 - f32 * f6;
      float f36 = f32 * f5 + f31 * f6;
      float f37 = f7 + (f11 - f34);
      f4 = f36 - (f35 - f33);
      f8 = f34;
      f9 = f36;
      f13 = f33;
      f10 = f37;
      f12 = f35;
      f14 = f7 + f1;
      f15 = f13 + f2;
      f16 = f8 + f1;
      f17 = f12 + f2;
      f18 = f11 + f1;
      f19 = f9 + f2;
      f20 = f1 + f10;
      f21 = f2 + f4;
      if (!paramBoolean)
        break label697;
      f22 = paramTextureRegion.u2;
      f23 = paramTextureRegion.v2;
      f24 = paramTextureRegion.u;
      f25 = paramTextureRegion.v2;
      f26 = paramTextureRegion.u;
      f27 = paramTextureRegion.v;
      f28 = paramTextureRegion.u2;
      f29 = paramTextureRegion.v;
    }
    while (true)
    {
      float f30 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = f14;
      int k = j + 1;
      arrayOfFloat[j] = f15;
      int m = k + 1;
      arrayOfFloat[k] = f30;
      int n = m + 1;
      arrayOfFloat[m] = f22;
      int i1 = n + 1;
      arrayOfFloat[n] = f23;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = f16;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f17;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f30;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f24;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f25;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f18;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f19;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f30;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f26;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f27;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f20;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f21;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f30;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f28;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f29;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        break;
      flush();
      break;
      label666: f7 = f3;
      f8 = f3;
      f9 = f6;
      f10 = f5;
      f11 = f5;
      f12 = f6;
      f13 = f4;
      break label261;
      label697: f22 = paramTextureRegion.u;
      f23 = paramTextureRegion.v;
      f24 = paramTextureRegion.u2;
      f25 = paramTextureRegion.v;
      f26 = paramTextureRegion.u2;
      f27 = paramTextureRegion.v2;
      f28 = paramTextureRegion.u;
      f29 = paramTextureRegion.v2;
    }
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2)
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before draw.");
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    while (true)
    {
      float f1 = paramAffine2.m02;
      float f2 = paramAffine2.m12;
      float f3 = paramFloat2 * paramAffine2.m01 + paramAffine2.m02;
      float f4 = paramFloat2 * paramAffine2.m11 + paramAffine2.m12;
      float f5 = paramFloat1 * paramAffine2.m00 + paramFloat2 * paramAffine2.m01 + paramAffine2.m02;
      float f6 = paramFloat1 * paramAffine2.m10 + paramFloat2 * paramAffine2.m11 + paramAffine2.m12;
      float f7 = paramFloat1 * paramAffine2.m00 + paramAffine2.m02;
      float f8 = paramFloat1 * paramAffine2.m10 + paramAffine2.m12;
      float f9 = paramTextureRegion.u;
      float f10 = paramTextureRegion.v2;
      float f11 = paramTextureRegion.u2;
      float f12 = paramTextureRegion.v;
      float f13 = this.color;
      int i = this.idx;
      int j = i + 1;
      arrayOfFloat[i] = f1;
      int k = j + 1;
      arrayOfFloat[j] = f2;
      int m = k + 1;
      arrayOfFloat[k] = f13;
      int n = m + 1;
      arrayOfFloat[m] = f9;
      int i1 = n + 1;
      arrayOfFloat[n] = f10;
      int i2 = i1 + 1;
      arrayOfFloat[i1] = f3;
      int i3 = i2 + 1;
      arrayOfFloat[i2] = f4;
      int i4 = i3 + 1;
      arrayOfFloat[i3] = f13;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f9;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f12;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f5;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f6;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f13;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f11;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f12;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f7;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f8;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f13;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f11;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f10;
      this.idx = i16;
      return;
      if (this.idx != arrayOfFloat.length)
        continue;
      flush();
    }
  }

  public void enableBlending()
  {
    if (!this.blendingDisabled)
      return;
    flush();
    this.blendingDisabled = false;
  }

  public void end()
  {
    if (!this.drawing)
      throw new IllegalStateException("SpriteBatch.begin must be called before end.");
    if (this.idx > 0)
      flush();
    this.lastTexture = null;
    this.drawing = false;
    GL20 localGL20 = Gdx.gl;
    localGL20.glDepthMask(true);
    if (isBlendingEnabled())
      localGL20.glDisable(3042);
    if (this.customShader != null)
    {
      this.customShader.end();
      return;
    }
    this.shader.end();
  }

  public void flush()
  {
    if (this.idx == 0)
      return;
    this.renderCalls = (1 + this.renderCalls);
    this.totalRenderCalls = (1 + this.totalRenderCalls);
    int i = this.idx / 20;
    if (i > this.maxSpritesInBatch)
      this.maxSpritesInBatch = i;
    int j = i * 6;
    this.lastTexture.bind();
    Mesh localMesh = this.mesh;
    localMesh.setVertices(this.vertices, 0, this.idx);
    localMesh.getIndicesBuffer().position(0);
    localMesh.getIndicesBuffer().limit(j);
    if (this.blendingDisabled)
    {
      Gdx.gl.glDisable(3042);
      if (this.customShader == null)
        break label182;
    }
    label182: for (ShaderProgram localShaderProgram = this.customShader; ; localShaderProgram = this.shader)
    {
      localMesh.render(localShaderProgram, 4, 0, j);
      this.idx = 0;
      return;
      Gdx.gl.glEnable(3042);
      if (this.blendSrcFunc == -1)
        break;
      Gdx.gl.glBlendFunc(this.blendSrcFunc, this.blendDstFunc);
      break;
    }
  }

  public int getBlendDstFunc()
  {
    return this.blendDstFunc;
  }

  public int getBlendSrcFunc()
  {
    return this.blendSrcFunc;
  }

  public Color getColor()
  {
    int i = NumberUtils.floatToIntColor(this.color);
    Color localColor = this.tempColor;
    localColor.r = ((i & 0xFF) / 255.0F);
    localColor.g = ((0xFF & i >>> 8) / 255.0F);
    localColor.b = ((0xFF & i >>> 16) / 255.0F);
    localColor.a = ((i >>> 24) / 255.0F);
    return localColor;
  }

  public float getPackedColor()
  {
    return this.color;
  }

  public Matrix4 getProjectionMatrix()
  {
    return this.projectionMatrix;
  }

  public ShaderProgram getShader()
  {
    if (this.customShader == null)
      return this.shader;
    return this.customShader;
  }

  public Matrix4 getTransformMatrix()
  {
    return this.transformMatrix;
  }

  public boolean isBlendingEnabled()
  {
    return !this.blendingDisabled;
  }

  public boolean isDrawing()
  {
    return this.drawing;
  }

  public void setBlendFunction(int paramInt1, int paramInt2)
  {
    if ((this.blendSrcFunc == paramInt1) && (this.blendDstFunc == paramInt2))
      return;
    flush();
    this.blendSrcFunc = paramInt1;
    this.blendDstFunc = paramInt2;
  }

  public void setColor(float paramFloat)
  {
    this.color = paramFloat;
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color = NumberUtils.intToFloatColor((int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
  }

  public void setColor(Color paramColor)
  {
    this.color = paramColor.toFloatBits();
  }

  public void setProjectionMatrix(Matrix4 paramMatrix4)
  {
    if (this.drawing)
      flush();
    this.projectionMatrix.set(paramMatrix4);
    if (this.drawing)
      setupMatrices();
  }

  public void setShader(ShaderProgram paramShaderProgram)
  {
    if (this.drawing)
    {
      flush();
      if (this.customShader != null)
        this.customShader.end();
    }
    else
    {
      this.customShader = paramShaderProgram;
      if (this.drawing)
      {
        if (this.customShader == null)
          break label66;
        this.customShader.begin();
      }
    }
    while (true)
    {
      setupMatrices();
      return;
      this.shader.end();
      break;
      label66: this.shader.begin();
    }
  }

  public void setTransformMatrix(Matrix4 paramMatrix4)
  {
    if (this.drawing)
      flush();
    this.transformMatrix.set(paramMatrix4);
    if (this.drawing)
      setupMatrices();
  }

  protected void switchTexture(Texture paramTexture)
  {
    flush();
    this.lastTexture = paramTexture;
    this.invTexWidth = (1.0F / paramTexture.getWidth());
    this.invTexHeight = (1.0F / paramTexture.getHeight());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.SpriteBatch
 * JD-Core Version:    0.6.0
 */