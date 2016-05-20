package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Disposable;

public abstract interface Batch extends Disposable
{
  public static final int C1 = 2;
  public static final int C2 = 7;
  public static final int C3 = 12;
  public static final int C4 = 17;
  public static final int U1 = 3;
  public static final int U2 = 8;
  public static final int U3 = 13;
  public static final int U4 = 18;
  public static final int V1 = 4;
  public static final int V2 = 9;
  public static final int V3 = 14;
  public static final int V4 = 19;
  public static final int X1 = 0;
  public static final int X2 = 5;
  public static final int X3 = 10;
  public static final int X4 = 15;
  public static final int Y1 = 1;
  public static final int Y2 = 6;
  public static final int Y3 = 11;
  public static final int Y4 = 16;

  public abstract void begin();

  public abstract void disableBlending();

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2);

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void draw(Texture paramTexture, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract void draw(Texture paramTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2);

  public abstract void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2);

  public abstract void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);

  public abstract void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, boolean paramBoolean);

  public abstract void draw(TextureRegion paramTextureRegion, float paramFloat1, float paramFloat2, Affine2 paramAffine2);

  public abstract void enableBlending();

  public abstract void end();

  public abstract void flush();

  public abstract int getBlendDstFunc();

  public abstract int getBlendSrcFunc();

  public abstract Color getColor();

  public abstract float getPackedColor();

  public abstract Matrix4 getProjectionMatrix();

  public abstract ShaderProgram getShader();

  public abstract Matrix4 getTransformMatrix();

  public abstract boolean isBlendingEnabled();

  public abstract boolean isDrawing();

  public abstract void setBlendFunction(int paramInt1, int paramInt2);

  public abstract void setColor(float paramFloat);

  public abstract void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void setColor(Color paramColor);

  public abstract void setProjectionMatrix(Matrix4 paramMatrix4);

  public abstract void setShader(ShaderProgram paramShaderProgram);

  public abstract void setTransformMatrix(Matrix4 paramMatrix4);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.Batch
 * JD-Core Version:    0.6.0
 */