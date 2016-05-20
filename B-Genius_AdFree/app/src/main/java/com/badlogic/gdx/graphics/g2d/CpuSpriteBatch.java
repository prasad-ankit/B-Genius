package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CpuSpriteBatch extends SpriteBatch
{
  private final Affine2 adjustAffine = new Affine2();
  private boolean adjustNeeded;
  private boolean haveIdentityRealMatrix = true;
  private final Affine2 tmpAffine = new Affine2();
  private final Matrix4 virtualMatrix = new Matrix4();

  public CpuSpriteBatch()
  {
    this(1000);
  }

  public CpuSpriteBatch(int paramInt)
  {
    this(paramInt, null);
  }

  public CpuSpriteBatch(int paramInt, ShaderProgram paramShaderProgram)
  {
    super(paramInt, paramShaderProgram);
  }

  private static boolean checkEqual(Matrix4 paramMatrix4, Affine2 paramAffine2)
  {
    float[] arrayOfFloat = paramMatrix4.getValues();
    return (arrayOfFloat[0] == paramAffine2.m00) && (arrayOfFloat[1] == paramAffine2.m10) && (arrayOfFloat[4] == paramAffine2.m01) && (arrayOfFloat[5] == paramAffine2.m11) && (arrayOfFloat[12] == paramAffine2.m02) && (arrayOfFloat[13] == paramAffine2.m12);
  }

  private static boolean checkEqual(Matrix4 paramMatrix41, Matrix4 paramMatrix42)
  {
    if (paramMatrix41 == paramMatrix42);
    do
      return true;
    while ((paramMatrix41.val[0] == paramMatrix42.val[0]) && (paramMatrix41.val[1] == paramMatrix42.val[1]) && (paramMatrix41.val[4] == paramMatrix42.val[4]) && (paramMatrix41.val[5] == paramMatrix42.val[5]) && (paramMatrix41.val[12] == paramMatrix42.val[12]) && (paramMatrix41.val[13] == paramMatrix42.val[13]));
    return false;
  }

  private static boolean checkIdt(Matrix4 paramMatrix4)
  {
    float[] arrayOfFloat = paramMatrix4.getValues();
    return (arrayOfFloat[0] == 1.0F) && (arrayOfFloat[1] == 0.0F) && (arrayOfFloat[4] == 0.0F) && (arrayOfFloat[5] == 1.0F) && (arrayOfFloat[12] == 0.0F) && (arrayOfFloat[13] == 0.0F);
  }

  private void drawAdjusted(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = 1.0F / paramTexture.getWidth();
    float f2 = 1.0F / paramTexture.getHeight();
    drawAdjustedUV(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, f1 * paramInt1, f2 * (paramInt2 + paramInt4), f1 * (paramInt1 + paramInt3), f2 * paramInt2, paramBoolean1, paramBoolean2);
  }

  private void drawAdjusted(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (!this.drawing)
      throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    if (paramTexture != this.lastTexture)
      switchTexture(paramTexture);
    Affine2 localAffine2 = this.adjustAffine;
    int i = Math.min(this.vertices.length - this.idx, paramInt2);
    do
    {
      paramInt2 -= i;
      while (i > 0)
      {
        float f1 = paramArrayOfFloat[paramInt1];
        float f2 = paramArrayOfFloat[(paramInt1 + 1)];
        this.vertices[this.idx] = (f1 * localAffine2.m00 + f2 * localAffine2.m01 + localAffine2.m02);
        this.vertices[(1 + this.idx)] = (f1 * localAffine2.m10 + f2 * localAffine2.m11 + localAffine2.m12);
        this.vertices[(2 + this.idx)] = paramArrayOfFloat[(paramInt1 + 2)];
        this.vertices[(3 + this.idx)] = paramArrayOfFloat[(paramInt1 + 3)];
        this.vertices[(4 + this.idx)] = paramArrayOfFloat[(paramInt1 + 4)];
        this.idx = (5 + this.idx);
        paramInt1 += 5;
        i -= 5;
      }
      if (paramInt2 <= 0)
        continue;
      super.flush();
      i = Math.min(this.vertices.length, paramInt2);
    }
    while (paramInt2 > 0);
  }

  private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    drawAdjustedUV(paramTextureRegion.texture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramTextureRegion.u, paramTextureRegion.v2, paramTextureRegion.u2, paramTextureRegion.v, false, false);
  }

  private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean)
  {
    if (!this.drawing)
      throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
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
    label253: float f14;
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
    if (paramTextureRegion.texture != this.lastTexture)
    {
      switchTexture(paramTextureRegion.texture);
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
        break label847;
      float f30 = MathUtils.cosDeg(paramFloat9);
      float f31 = MathUtils.sinDeg(paramFloat9);
      f7 = f30 * f3 - f31 * f4;
      float f32 = f31 * f3 + f4 * f30;
      float f33 = f30 * f3 - f31 * f6;
      float f34 = f31 * f3 + f30 * f6;
      f11 = f30 * f5 - f31 * f6;
      float f35 = f31 * f5 + f30 * f6;
      float f36 = f7 + (f11 - f33);
      f4 = f35 - (f34 - f32);
      f8 = f33;
      f9 = f35;
      f13 = f32;
      f10 = f36;
      f12 = f34;
      f14 = f7 + f1;
      f15 = f13 + f2;
      f16 = f8 + f1;
      f17 = f12 + f2;
      f18 = f11 + f1;
      f19 = f9 + f2;
      f20 = f1 + f10;
      f21 = f2 + f4;
      if (!paramBoolean)
        break label878;
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
      Affine2 localAffine2 = this.adjustAffine;
      this.vertices[this.idx] = (f14 * localAffine2.m00 + f15 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(1 + this.idx)] = (f14 * localAffine2.m10 + f15 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(2 + this.idx)] = this.color;
      this.vertices[(3 + this.idx)] = f22;
      this.vertices[(4 + this.idx)] = f23;
      this.vertices[(5 + this.idx)] = (f16 * localAffine2.m00 + f17 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(6 + this.idx)] = (f16 * localAffine2.m10 + f17 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(7 + this.idx)] = this.color;
      this.vertices[(8 + this.idx)] = f24;
      this.vertices[(9 + this.idx)] = f25;
      this.vertices[(10 + this.idx)] = (f18 * localAffine2.m00 + f19 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(11 + this.idx)] = (f18 * localAffine2.m10 + f19 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(12 + this.idx)] = this.color;
      this.vertices[(13 + this.idx)] = f26;
      this.vertices[(14 + this.idx)] = f27;
      this.vertices[(15 + this.idx)] = (f20 * localAffine2.m00 + f21 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(16 + this.idx)] = (f20 * localAffine2.m10 + f21 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(17 + this.idx)] = this.color;
      this.vertices[(18 + this.idx)] = f28;
      this.vertices[(19 + this.idx)] = f29;
      this.idx = (20 + this.idx);
      return;
      if (this.idx != this.vertices.length)
        break;
      super.flush();
      break;
      label847: f7 = f3;
      f8 = f3;
      f9 = f6;
      f10 = f5;
      f11 = f5;
      f12 = f6;
      f13 = f4;
      break label253;
      label878: f22 = paramTextureRegion.u;
      f23 = paramTextureRegion.v;
      f24 = paramTextureRegion.u2;
      f25 = paramTextureRegion.v;
      f26 = paramTextureRegion.u2;
      f27 = paramTextureRegion.v2;
      f28 = paramTextureRegion.u;
      f29 = paramTextureRegion.v2;
    }
  }

  private void drawAdjusted(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2)
  {
    if (!this.drawing)
      throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
    if (paramTextureRegion.texture != this.lastTexture)
      switchTexture(paramTextureRegion.texture);
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
      Affine2 localAffine2 = this.adjustAffine;
      this.vertices[this.idx] = (f1 * localAffine2.m00 + f2 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(1 + this.idx)] = (f1 * localAffine2.m10 + f2 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(2 + this.idx)] = this.color;
      this.vertices[(3 + this.idx)] = f9;
      this.vertices[(4 + this.idx)] = f10;
      this.vertices[(5 + this.idx)] = (f3 * localAffine2.m00 + f4 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(6 + this.idx)] = (f3 * localAffine2.m10 + f4 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(7 + this.idx)] = this.color;
      this.vertices[(8 + this.idx)] = f9;
      this.vertices[(9 + this.idx)] = f12;
      this.vertices[(10 + this.idx)] = (f5 * localAffine2.m00 + f6 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(11 + this.idx)] = (f5 * localAffine2.m10 + f6 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(12 + this.idx)] = this.color;
      this.vertices[(13 + this.idx)] = f11;
      this.vertices[(14 + this.idx)] = f12;
      this.vertices[(15 + this.idx)] = (f7 * localAffine2.m00 + f8 * localAffine2.m01 + localAffine2.m02);
      this.vertices[(16 + this.idx)] = (f7 * localAffine2.m10 + f8 * localAffine2.m11 + localAffine2.m12);
      this.vertices[(17 + this.idx)] = this.color;
      this.vertices[(18 + this.idx)] = f11;
      this.vertices[(19 + this.idx)] = f10;
      this.idx = (20 + this.idx);
      return;
      if (this.idx != this.vertices.length)
        continue;
      super.flush();
    }
  }

  private void drawAdjustedUV(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.drawing)
      throw new IllegalStateException("CpuSpriteBatch.begin must be called before draw.");
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
    label239: float f16;
    float f17;
    float f18;
    float f19;
    float f20;
    float f21;
    float f22;
    float f23;
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
        break label790;
      float f26 = MathUtils.cosDeg(paramFloat9);
      float f27 = MathUtils.sinDeg(paramFloat9);
      f7 = f26 * f3 - f27 * f4;
      float f28 = f27 * f3 + f4 * f26;
      float f29 = f26 * f3 - f27 * f6;
      f10 = f3 * f27 + f26 * f6;
      f15 = f26 * f5 - f27 * f6;
      float f30 = f27 * f5 + f26 * f6;
      f11 = f7 + (f15 - f29);
      f14 = f30 - (f10 - f28);
      f8 = f28;
      f9 = f30;
      f13 = f29;
      f16 = f7 + f1;
      f17 = f8 + f2;
      f18 = f13 + f1;
      f19 = f10 + f2;
      f20 = f15 + f1;
      f21 = f9 + f2;
      f22 = f11 + f1;
      f23 = f14 + f2;
      if (!paramBoolean1)
        break label844;
    }
    while (true)
    {
      if (paramBoolean2);
      while (true)
      {
        Affine2 localAffine2 = this.adjustAffine;
        this.vertices[this.idx] = (f16 * localAffine2.m00 + f17 * localAffine2.m01 + localAffine2.m02);
        this.vertices[(1 + this.idx)] = (f16 * localAffine2.m10 + f17 * localAffine2.m11 + localAffine2.m12);
        this.vertices[(2 + this.idx)] = this.color;
        this.vertices[(3 + this.idx)] = paramFloat12;
        this.vertices[(4 + this.idx)] = paramFloat13;
        this.vertices[(5 + this.idx)] = (f18 * localAffine2.m00 + f19 * localAffine2.m01 + localAffine2.m02);
        this.vertices[(6 + this.idx)] = (f18 * localAffine2.m10 + f19 * localAffine2.m11 + localAffine2.m12);
        this.vertices[(7 + this.idx)] = this.color;
        this.vertices[(8 + this.idx)] = paramFloat12;
        this.vertices[(9 + this.idx)] = paramFloat11;
        this.vertices[(10 + this.idx)] = (f20 * localAffine2.m00 + f21 * localAffine2.m01 + localAffine2.m02);
        this.vertices[(11 + this.idx)] = (f20 * localAffine2.m10 + f21 * localAffine2.m11 + localAffine2.m12);
        this.vertices[(12 + this.idx)] = this.color;
        this.vertices[(13 + this.idx)] = paramFloat10;
        this.vertices[(14 + this.idx)] = paramFloat11;
        this.vertices[(15 + this.idx)] = (f22 * localAffine2.m00 + f23 * localAffine2.m01 + localAffine2.m02);
        this.vertices[(16 + this.idx)] = (f22 * localAffine2.m10 + f23 * localAffine2.m11 + localAffine2.m12);
        this.vertices[(17 + this.idx)] = this.color;
        this.vertices[(18 + this.idx)] = paramFloat10;
        this.vertices[(19 + this.idx)] = paramFloat13;
        this.idx = (20 + this.idx);
        return;
        if (this.idx != this.vertices.length)
          break;
        super.flush();
        break;
        label790: f7 = f3;
        f8 = f4;
        f9 = f6;
        f10 = f6;
        f11 = f5;
        float f12 = f5;
        f13 = f3;
        f14 = f4;
        f15 = f12;
        break label239;
        float f25 = paramFloat13;
        paramFloat13 = paramFloat11;
        paramFloat11 = f25;
      }
      label844: float f24 = paramFloat12;
      paramFloat12 = paramFloat10;
      paramFloat10 = f24;
    }
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2);
      return;
    }
    drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTexture.getWidth(), paramTexture.getHeight(), 1.0F, 1.0F, 0.0F, 0, 1, 1, 0, false, false);
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      return;
    }
    drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F, 0, 1, 1, 0, false, false);
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
      return;
    }
    drawAdjustedUV(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTexture.getWidth(), paramTexture.getHeight(), 1.0F, 1.0F, 0.0F, paramFloat5, paramFloat6, paramFloat7, paramFloat8, false, false);
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
      return;
    }
    drawAdjusted(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
      return;
    }
    drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
  }

  public void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramFloat1, paramFloat2, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    drawAdjusted(paramTexture, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTexture.getWidth(), paramTexture.getHeight(), 1.0F, 1.0F, 0.0F, paramInt1, paramInt2, paramInt3, paramInt4, false, false);
  }

  public void draw(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 % 20 != 0)
      throw new GdxRuntimeException("invalid vertex count");
    if (!this.adjustNeeded)
    {
      super.draw(paramTexture, paramArrayOfFloat, paramInt1, paramInt2);
      return;
    }
    drawAdjusted(paramTexture, paramArrayOfFloat, paramInt1, paramInt2);
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTextureRegion, paramFloat1, paramFloat2);
      return;
    }
    drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, 0.0F, 0.0F, paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight(), 1.0F, 1.0F, 0.0F);
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      return;
    }
    drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, 0.0F, 0.0F, paramFloat3, paramFloat4, 1.0F, 1.0F, 0.0F);
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
      return;
    }
    drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramBoolean);
      return;
    }
    drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramBoolean);
  }

  public void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2)
  {
    if (!this.adjustNeeded)
    {
      super.draw(paramTextureRegion, paramFloat1, paramFloat2, paramAffine2);
      return;
    }
    drawAdjusted(paramTextureRegion, paramFloat1, paramFloat2, paramAffine2);
  }

  public void flushAndSyncTransformMatrix()
  {
    flush();
    if (this.adjustNeeded)
    {
      this.haveIdentityRealMatrix = checkIdt(this.virtualMatrix);
      if ((!this.haveIdentityRealMatrix) && (this.virtualMatrix.det() == 0.0F))
        throw new GdxRuntimeException("Transform matrix is singular, can't sync");
      this.adjustNeeded = false;
      super.setTransformMatrix(this.virtualMatrix);
    }
  }

  public Matrix4 getTransformMatrix()
  {
    if (this.adjustNeeded)
      return this.virtualMatrix;
    return super.getTransformMatrix();
  }

  public void setTransformMatrix(Affine2 paramAffine2)
  {
    Matrix4 localMatrix4 = super.getTransformMatrix();
    if (checkEqual(localMatrix4, paramAffine2))
    {
      this.adjustNeeded = false;
      return;
    }
    this.virtualMatrix.setAsAffine(paramAffine2);
    if (isDrawing())
    {
      this.adjustNeeded = true;
      if (this.haveIdentityRealMatrix)
      {
        this.adjustAffine.set(paramAffine2);
        return;
      }
      this.adjustAffine.set(localMatrix4).inv().mul(paramAffine2);
      return;
    }
    localMatrix4.setAsAffine(paramAffine2);
    this.haveIdentityRealMatrix = checkIdt(localMatrix4);
  }

  public void setTransformMatrix(Matrix4 paramMatrix4)
  {
    Matrix4 localMatrix4 = super.getTransformMatrix();
    if (checkEqual(localMatrix4, paramMatrix4))
    {
      this.adjustNeeded = false;
      return;
    }
    if (isDrawing())
    {
      this.virtualMatrix.setAsAffine(paramMatrix4);
      this.adjustNeeded = true;
      if (this.haveIdentityRealMatrix)
      {
        this.adjustAffine.set(paramMatrix4);
        return;
      }
      this.tmpAffine.set(paramMatrix4);
      this.adjustAffine.set(localMatrix4).inv().mul(this.tmpAffine);
      return;
    }
    localMatrix4.setAsAffine(paramMatrix4);
    this.haveIdentityRealMatrix = checkIdt(localMatrix4);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.CpuSpriteBatch
 * JD-Core Version:    0.6.0
 */