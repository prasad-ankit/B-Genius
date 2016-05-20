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

public class PolygonSpriteBatch
  implements Batch
{
  private int blendDstFunc = 771;
  private int blendSrcFunc = 770;
  private boolean blendingDisabled;
  float color = Color.WHITE.toFloatBits();
  private final Matrix4 combinedMatrix = new Matrix4();
  private ShaderProgram customShader;
  private boolean drawing;
  private float invTexHeight = 0.0F;
  private float invTexWidth = 0.0F;
  private Texture lastTexture;
  public int maxTrianglesInBatch = 0;
  private Mesh mesh;
  private boolean ownsShader;
  private final Matrix4 projectionMatrix = new Matrix4();
  public int renderCalls = 0;
  private final ShaderProgram shader;
  private Color tempColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public int totalRenderCalls = 0;
  private final Matrix4 transformMatrix = new Matrix4();
  private int triangleIndex;
  private final short[] triangles;
  private int vertexIndex;
  private final float[] vertices;

  public PolygonSpriteBatch()
  {
    this(2000, null);
  }

  public PolygonSpriteBatch(int paramInt)
  {
    this(paramInt, null);
  }

  public PolygonSpriteBatch(int paramInt, ShaderProgram paramShaderProgram)
  {
    if (paramInt > 10920)
      throw new IllegalArgumentException("Can't have more than 10920 triangles per batch: " + paramInt);
    Mesh.VertexDataType localVertexDataType = Mesh.VertexDataType.VertexArray;
    if (Gdx.gl30 != null)
      localVertexDataType = Mesh.VertexDataType.VertexBufferObjectWithVAO;
    int i = paramInt * 3;
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[3];
    arrayOfVertexAttribute[0] = new VertexAttribute(1, 2, "a_position");
    arrayOfVertexAttribute[1] = new VertexAttribute(4, 4, "a_color");
    arrayOfVertexAttribute[2] = new VertexAttribute(16, 2, "a_texCoord0");
    this.mesh = new Mesh(localVertexDataType, false, paramInt, i, arrayOfVertexAttribute);
    this.vertices = new float[paramInt * 5];
    this.triangles = new short[paramInt * 3];
    if (paramShaderProgram == null)
    {
      this.shader = SpriteBatch.createDefaultShader();
      this.ownsShader = true;
    }
    while (true)
    {
      this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
      return;
      this.shader = paramShaderProgram;
    }
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

  private void switchTexture(Texture paramTexture)
  {
    flush();
    this.lastTexture = paramTexture;
    this.invTexWidth = (1.0F / paramTexture.getWidth());
    this.invTexHeight = (1.0F / paramTexture.getHeight());
  }

  public void begin()
  {
    if (this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.end must be called before begin.");
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
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = this.color;
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = paramFloat1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = paramFloat2;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f3;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = 0.0F;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = 1.0F;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = paramFloat1;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f2;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f3;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = 0.0F;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = 0.0F;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f1;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f2;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f3;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = 1.0F;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = 0.0F;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f1;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = paramFloat2;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f3;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = 1.0F;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = 1.0F;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = this.color;
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = paramFloat1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = paramFloat2;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f3;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = paramFloat5;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = paramFloat6;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = paramFloat1;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f2;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f3;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = paramFloat5;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = paramFloat8;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f1;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f2;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f3;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = paramFloat7;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = paramFloat8;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f1;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = paramFloat2;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f3;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = paramFloat7;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = paramFloat6;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
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
    label363: float f16;
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
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
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
        break label787;
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
        break label841;
    }
    while (true)
    {
      if (paramBoolean2);
      while (true)
      {
        float f30 = this.color;
        int i4 = this.vertexIndex;
        int i5 = i4 + 1;
        arrayOfFloat[i4] = f16;
        int i6 = i5 + 1;
        arrayOfFloat[i5] = f17;
        int i7 = i6 + 1;
        arrayOfFloat[i6] = f30;
        int i8 = i7 + 1;
        arrayOfFloat[i7] = f26;
        int i9 = i8 + 1;
        arrayOfFloat[i8] = f27;
        int i10 = i9 + 1;
        arrayOfFloat[i9] = f18;
        int i11 = i10 + 1;
        arrayOfFloat[i10] = f19;
        int i12 = i11 + 1;
        arrayOfFloat[i11] = f30;
        int i13 = i12 + 1;
        arrayOfFloat[i12] = f26;
        int i14 = i13 + 1;
        arrayOfFloat[i13] = f25;
        int i15 = i14 + 1;
        arrayOfFloat[i14] = f20;
        int i16 = i15 + 1;
        arrayOfFloat[i15] = f21;
        int i17 = i16 + 1;
        arrayOfFloat[i16] = f30;
        int i18 = i17 + 1;
        arrayOfFloat[i17] = f24;
        int i19 = i18 + 1;
        arrayOfFloat[i18] = f25;
        int i20 = i19 + 1;
        arrayOfFloat[i19] = f22;
        int i21 = i20 + 1;
        arrayOfFloat[i20] = f23;
        int i22 = i21 + 1;
        arrayOfFloat[i21] = f30;
        int i23 = i22 + 1;
        arrayOfFloat[i22] = f24;
        int i24 = i23 + 1;
        arrayOfFloat[i23] = f27;
        this.vertexIndex = i24;
        return;
        if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
          break;
        flush();
        break;
        label787: f7 = f3;
        f8 = f4;
        f9 = f6;
        f10 = f6;
        f11 = f5;
        float f12 = f5;
        f13 = f3;
        f14 = f4;
        f15 = f12;
        break label363;
        float f29 = f25;
        f25 = f27;
        f27 = f29;
      }
      label841: float f28 = f24;
      f24 = f26;
      f26 = f28;
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
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
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
      f1 = paramInt1 * this.invTexWidth;
      f2 = (paramInt2 + paramInt4) * this.invTexHeight;
      f3 = (paramInt1 + paramInt3) * this.invTexWidth;
      f4 = paramInt2 * this.invTexHeight;
      f5 = paramFloat1 + paramFloat3;
      f6 = paramFloat2 + paramFloat4;
      if (!paramBoolean1)
        break label545;
    }
    while (true)
    {
      if (paramBoolean2);
      while (true)
      {
        float f9 = this.color;
        int i4 = this.vertexIndex;
        int i5 = i4 + 1;
        arrayOfFloat[i4] = paramFloat1;
        int i6 = i5 + 1;
        arrayOfFloat[i5] = paramFloat2;
        int i7 = i6 + 1;
        arrayOfFloat[i6] = f9;
        int i8 = i7 + 1;
        arrayOfFloat[i7] = f3;
        int i9 = i8 + 1;
        arrayOfFloat[i8] = f4;
        int i10 = i9 + 1;
        arrayOfFloat[i9] = paramFloat1;
        int i11 = i10 + 1;
        arrayOfFloat[i10] = f6;
        int i12 = i11 + 1;
        arrayOfFloat[i11] = f9;
        int i13 = i12 + 1;
        arrayOfFloat[i12] = f3;
        int i14 = i13 + 1;
        arrayOfFloat[i13] = f2;
        int i15 = i14 + 1;
        arrayOfFloat[i14] = f5;
        int i16 = i15 + 1;
        arrayOfFloat[i15] = f6;
        int i17 = i16 + 1;
        arrayOfFloat[i16] = f9;
        int i18 = i17 + 1;
        arrayOfFloat[i17] = f1;
        int i19 = i18 + 1;
        arrayOfFloat[i18] = f2;
        int i20 = i19 + 1;
        arrayOfFloat[i19] = f5;
        int i21 = i20 + 1;
        arrayOfFloat[i20] = paramFloat2;
        int i22 = i21 + 1;
        arrayOfFloat[i21] = f9;
        int i23 = i22 + 1;
        arrayOfFloat[i22] = f1;
        int i24 = i23 + 1;
        arrayOfFloat[i23] = f4;
        this.vertexIndex = i24;
        return;
        if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
          break;
        flush();
        break;
        float f8 = f2;
        f2 = f4;
        f4 = f8;
      }
      label545: float f7 = f3;
      f3 = f1;
      f1 = f7;
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    while (true)
    {
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
      float f1 = paramInt1 * this.invTexWidth;
      float f2 = (paramInt2 + paramInt4) * this.invTexHeight;
      float f3 = (paramInt1 + paramInt3) * this.invTexWidth;
      float f4 = paramInt2 * this.invTexHeight;
      float f5 = paramFloat1 + paramInt3;
      float f6 = paramFloat2 + paramInt4;
      float f7 = this.color;
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = paramFloat1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = paramFloat2;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f7;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f1;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f2;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = paramFloat1;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f6;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f7;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f1;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f4;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f5;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f6;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f7;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = f3;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = f4;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f5;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = paramFloat2;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f7;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = f3;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = f2;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
  }

  public void draw(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    int i = 6 * (paramInt2 / 20);
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    int j;
    int k;
    while (true)
    {
      j = this.vertexIndex;
      k = this.triangleIndex;
      int m = (short)(j / 5);
      int n = i + k;
      while (k < n)
      {
        arrayOfShort[k] = m;
        arrayOfShort[(k + 1)] = (short)(m + 1);
        arrayOfShort[(k + 2)] = (short)(m + 2);
        arrayOfShort[(k + 3)] = (short)(m + 2);
        arrayOfShort[(k + 4)] = (short)(m + 3);
        arrayOfShort[(k + 5)] = m;
        k += 6;
        m = (short)(m + 4);
      }
      if ((i + this.triangleIndex <= arrayOfShort.length) && (paramInt2 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
    this.triangleIndex = k;
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, j, paramInt2);
    this.vertexIndex = (paramInt2 + this.vertexIndex);
  }

  public void draw(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, short[] paramArrayOfShort, int paramInt3, int paramInt4)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    int i;
    int j;
    while (true)
    {
      i = this.triangleIndex;
      j = this.vertexIndex;
      int k = j / 5;
      int m = paramInt3 + paramInt4;
      while (paramInt3 < m)
      {
        int n = i + 1;
        arrayOfShort[i] = (short)(k + paramArrayOfShort[paramInt3]);
        paramInt3++;
        i = n;
      }
      if ((paramInt4 + this.triangleIndex <= arrayOfShort.length) && (paramInt2 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
    this.triangleIndex = i;
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, j, paramInt2);
    this.vertexIndex = (paramInt2 + this.vertexIndex);
  }

  public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort1 = this.triangles;
    short[] arrayOfShort2 = paramPolygonRegion.triangles;
    int j = arrayOfShort2.length;
    float[] arrayOfFloat1 = paramPolygonRegion.vertices;
    int k = arrayOfFloat1.length;
    Texture localTexture = paramPolygonRegion.region.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    int n;
    int i2;
    while (true)
    {
      int m = this.triangleIndex;
      n = this.vertexIndex;
      int i1 = n / 5;
      i2 = m;
      int i3 = 0;
      while (i3 < j)
      {
        int i8 = i2 + 1;
        arrayOfShort1[i2] = (short)(i1 + arrayOfShort2[i3]);
        i3++;
        i2 = i8;
      }
      if ((j + this.triangleIndex <= arrayOfShort1.length) && (k + this.vertexIndex <= this.vertices.length))
        continue;
      flush();
    }
    this.triangleIndex = i2;
    float[] arrayOfFloat2 = this.vertices;
    float f = this.color;
    float[] arrayOfFloat3 = paramPolygonRegion.textureCoords;
    while (i < k)
    {
      int i4 = n + 1;
      arrayOfFloat2[n] = (paramFloat1 + arrayOfFloat1[i]);
      int i5 = i4 + 1;
      arrayOfFloat2[i4] = (paramFloat2 + arrayOfFloat1[(i + 1)]);
      int i6 = i5 + 1;
      arrayOfFloat2[i5] = f;
      int i7 = i6 + 1;
      arrayOfFloat2[i6] = arrayOfFloat3[i];
      n = i7 + 1;
      arrayOfFloat2[i7] = arrayOfFloat3[(i + 1)];
      i += 2;
    }
    this.vertexIndex = n;
  }

  public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort1 = this.triangles;
    short[] arrayOfShort2 = paramPolygonRegion.triangles;
    int i = arrayOfShort2.length;
    float[] arrayOfFloat1 = paramPolygonRegion.vertices;
    int j = arrayOfFloat1.length;
    TextureRegion localTextureRegion = paramPolygonRegion.region;
    Texture localTexture = localTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    int k;
    int m;
    while (true)
    {
      k = this.triangleIndex;
      m = this.vertexIndex;
      int n = m / 5;
      int i1 = 0;
      int i2 = arrayOfShort2.length;
      while (i1 < i2)
      {
        int i8 = k + 1;
        arrayOfShort1[k] = (short)(n + arrayOfShort2[i1]);
        i1++;
        k = i8;
      }
      if ((i + this.triangleIndex <= arrayOfShort1.length) && (j + this.vertexIndex <= this.vertices.length))
        continue;
      flush();
    }
    this.triangleIndex = k;
    float[] arrayOfFloat2 = this.vertices;
    float f1 = this.color;
    float[] arrayOfFloat3 = paramPolygonRegion.textureCoords;
    float f2 = paramFloat3 / localTextureRegion.regionWidth;
    float f3 = paramFloat4 / localTextureRegion.regionHeight;
    for (int i3 = 0; i3 < j; i3 += 2)
    {
      int i4 = m + 1;
      arrayOfFloat2[m] = (paramFloat1 + f2 * arrayOfFloat1[i3]);
      int i5 = i4 + 1;
      arrayOfFloat2[i4] = (paramFloat2 + f3 * arrayOfFloat1[(i3 + 1)]);
      int i6 = i5 + 1;
      arrayOfFloat2[i5] = f1;
      int i7 = i6 + 1;
      arrayOfFloat2[i6] = arrayOfFloat3[i3];
      m = i7 + 1;
      arrayOfFloat2[i7] = arrayOfFloat3[(i3 + 1)];
    }
    this.vertexIndex = m;
  }

  public void draw(PolygonRegion paramPolygonRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort1 = this.triangles;
    short[] arrayOfShort2 = paramPolygonRegion.triangles;
    int i = arrayOfShort2.length;
    float[] arrayOfFloat1 = paramPolygonRegion.vertices;
    int j = arrayOfFloat1.length;
    TextureRegion localTextureRegion = paramPolygonRegion.region;
    Texture localTexture = localTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    int k;
    int m;
    while (true)
    {
      k = this.triangleIndex;
      m = this.vertexIndex;
      int n = m / 5;
      int i1 = 0;
      while (i1 < i)
      {
        int i7 = k + 1;
        arrayOfShort1[k] = (short)(n + arrayOfShort2[i1]);
        i1++;
        k = i7;
      }
      if ((i + this.triangleIndex <= arrayOfShort1.length) && (j + this.vertexIndex <= this.vertices.length))
        continue;
      flush();
    }
    this.triangleIndex = k;
    float[] arrayOfFloat2 = this.vertices;
    float f1 = this.color;
    float[] arrayOfFloat3 = paramPolygonRegion.textureCoords;
    float f2 = paramFloat1 + paramFloat3;
    float f3 = paramFloat2 + paramFloat4;
    float f4 = paramFloat5 / localTextureRegion.regionWidth;
    float f5 = paramFloat6 / localTextureRegion.regionHeight;
    float f6 = MathUtils.cosDeg(paramFloat9);
    float f7 = MathUtils.sinDeg(paramFloat9);
    for (int i2 = 0; i2 < j; i2 += 2)
    {
      float f8 = paramFloat7 * (f4 * arrayOfFloat1[i2] - paramFloat3);
      float f9 = paramFloat8 * (f5 * arrayOfFloat1[(i2 + 1)] - paramFloat4);
      int i3 = m + 1;
      arrayOfFloat2[m] = (f2 + (f6 * f8 - f7 * f9));
      int i4 = i3 + 1;
      arrayOfFloat2[i3] = (f3 + (f8 * f7 + f9 * f6));
      int i5 = i4 + 1;
      arrayOfFloat2[i4] = f1;
      int i6 = i5 + 1;
      arrayOfFloat2[i5] = arrayOfFloat3[i2];
      m = i6 + 1;
      arrayOfFloat2[i6] = arrayOfFloat3[(i2 + 1)];
    }
    this.vertexIndex = m;
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2)
  {
    draw(paramTextureRegion, paramFloat1, paramFloat2, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    while (true)
    {
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
      float f1 = paramFloat1 + paramFloat3;
      float f2 = paramFloat2 + paramFloat4;
      float f3 = paramTextureRegion.u;
      float f4 = paramTextureRegion.v2;
      float f5 = paramTextureRegion.u2;
      float f6 = paramTextureRegion.v;
      float f7 = this.color;
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = paramFloat1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = paramFloat2;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f7;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f3;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f4;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = paramFloat1;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f2;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f7;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f3;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f6;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f1;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f2;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f7;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = f5;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = f6;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f1;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = paramFloat2;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f7;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = f5;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = f4;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
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
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
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
        break label771;
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
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f14;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f15;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f26;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f22;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f23;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f16;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f17;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f26;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f22;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f25;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f18;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f19;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f26;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = f24;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = f25;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f20;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = f21;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f26;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = f24;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = f23;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        break;
      flush();
      break;
      label771: f7 = f3;
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
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
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
    label379: float f14;
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
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
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
        break label800;
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
        break label831;
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
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f14;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f15;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f30;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f22;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f23;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f16;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f17;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f30;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f24;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f25;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f18;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f19;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f30;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = f26;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = f27;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f20;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = f21;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f30;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = f28;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = f29;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        break;
      flush();
      break;
      label800: f7 = f3;
      f8 = f3;
      f9 = f6;
      f10 = f5;
      f11 = f5;
      f12 = f6;
      f13 = f4;
      break label379;
      label831: f22 = paramTextureRegion.u;
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
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before draw.");
    short[] arrayOfShort = this.triangles;
    float[] arrayOfFloat = this.vertices;
    Texture localTexture = paramTextureRegion.texture;
    if (localTexture != this.lastTexture)
      switchTexture(localTexture);
    while (true)
    {
      int i = this.triangleIndex;
      int j = this.vertexIndex / 5;
      int k = i + 1;
      arrayOfShort[i] = (short)j;
      int m = k + 1;
      arrayOfShort[k] = (short)(j + 1);
      int n = m + 1;
      arrayOfShort[m] = (short)(j + 2);
      int i1 = n + 1;
      arrayOfShort[n] = (short)(j + 2);
      int i2 = i1 + 1;
      arrayOfShort[i1] = (short)(j + 3);
      int i3 = i2 + 1;
      arrayOfShort[i2] = (short)j;
      this.triangleIndex = i3;
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
      int i4 = this.vertexIndex;
      int i5 = i4 + 1;
      arrayOfFloat[i4] = f1;
      int i6 = i5 + 1;
      arrayOfFloat[i5] = f2;
      int i7 = i6 + 1;
      arrayOfFloat[i6] = f13;
      int i8 = i7 + 1;
      arrayOfFloat[i7] = f9;
      int i9 = i8 + 1;
      arrayOfFloat[i8] = f10;
      int i10 = i9 + 1;
      arrayOfFloat[i9] = f3;
      int i11 = i10 + 1;
      arrayOfFloat[i10] = f4;
      int i12 = i11 + 1;
      arrayOfFloat[i11] = f13;
      int i13 = i12 + 1;
      arrayOfFloat[i12] = f9;
      int i14 = i13 + 1;
      arrayOfFloat[i13] = f12;
      int i15 = i14 + 1;
      arrayOfFloat[i14] = f5;
      int i16 = i15 + 1;
      arrayOfFloat[i15] = f6;
      int i17 = i16 + 1;
      arrayOfFloat[i16] = f13;
      int i18 = i17 + 1;
      arrayOfFloat[i17] = f11;
      int i19 = i18 + 1;
      arrayOfFloat[i18] = f12;
      int i20 = i19 + 1;
      arrayOfFloat[i19] = f7;
      int i21 = i20 + 1;
      arrayOfFloat[i20] = f8;
      int i22 = i21 + 1;
      arrayOfFloat[i21] = f13;
      int i23 = i22 + 1;
      arrayOfFloat[i22] = f11;
      int i24 = i23 + 1;
      arrayOfFloat[i23] = f10;
      this.vertexIndex = i24;
      return;
      if ((6 + this.triangleIndex <= arrayOfShort.length) && (20 + this.vertexIndex <= arrayOfFloat.length))
        continue;
      flush();
    }
  }

  public void enableBlending()
  {
    flush();
    this.blendingDisabled = false;
  }

  public void end()
  {
    if (!this.drawing)
      throw new IllegalStateException("PolygonSpriteBatch.begin must be called before end.");
    if (this.vertexIndex > 0)
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
    if (this.vertexIndex == 0)
      return;
    this.renderCalls = (1 + this.renderCalls);
    this.totalRenderCalls = (1 + this.totalRenderCalls);
    int i = this.triangleIndex;
    if (i > this.maxTrianglesInBatch)
      this.maxTrianglesInBatch = i;
    this.lastTexture.bind();
    Mesh localMesh = this.mesh;
    localMesh.setVertices(this.vertices, 0, this.vertexIndex);
    localMesh.setIndices(this.triangles, 0, this.triangleIndex);
    if (this.blendingDisabled)
    {
      Gdx.gl.glDisable(3042);
      if (this.customShader == null)
        break label175;
    }
    label175: for (ShaderProgram localShaderProgram = this.customShader; ; localShaderProgram = this.shader)
    {
      localMesh.render(localShaderProgram, 4, 0, i);
      this.vertexIndex = 0;
      this.triangleIndex = 0;
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
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
 * JD-Core Version:    0.6.0
 */