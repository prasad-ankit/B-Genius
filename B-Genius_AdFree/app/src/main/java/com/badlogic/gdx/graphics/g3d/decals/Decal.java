package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;

public class Decal
{
  public static final int C1 = 3;
  public static final int C2 = 9;
  public static final int C3 = 15;
  public static final int C4 = 21;
  public static final int SIZE = 24;
  public static final int U1 = 4;
  public static final int U2 = 10;
  public static final int U3 = 16;
  public static final int U4 = 22;
  public static final int V1 = 5;
  public static final int V2 = 11;
  public static final int V3 = 17;
  public static final int V4 = 23;
  private static final int VERTEX_SIZE = 6;
  public static final int X1 = 0;
  public static final int X2 = 6;
  public static final int X3 = 12;
  public static final int X4 = 18;
  public static final int Y1 = 1;
  public static final int Y2 = 7;
  public static final int Y3 = 13;
  public static final int Y4 = 19;
  public static final int Z1 = 2;
  public static final int Z2 = 8;
  public static final int Z3 = 14;
  public static final int Z4 = 20;
  static final Vector3 dir;
  protected static Quaternion rotator;
  private static Vector3 tmp = new Vector3();
  private static Vector3 tmp2 = new Vector3();
  protected Color color = new Color();
  protected Vector2 dimensions = new Vector2();
  protected DecalMaterial material;
  protected Vector3 position = new Vector3();
  protected Quaternion rotation = new Quaternion();
  protected Vector2 scale = new Vector2(1.0F, 1.0F);
  public Vector2 transformationOffset = null;
  protected boolean updated = false;
  public int value;
  protected float[] vertices = new float[24];

  static
  {
    dir = new Vector3();
    rotator = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
  }

  public Decal()
  {
    this.material = new DecalMaterial();
  }

  public Decal(DecalMaterial paramDecalMaterial)
  {
    this.material = paramDecalMaterial;
  }

  public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion)
  {
    return newDecal(paramFloat1, paramFloat2, paramTextureRegion, -1, -1);
  }

  public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, int paramInt1, int paramInt2)
  {
    Decal localDecal = new Decal();
    localDecal.setTextureRegion(paramTextureRegion);
    localDecal.setBlending(paramInt1, paramInt2);
    localDecal.dimensions.x = paramFloat1;
    localDecal.dimensions.y = paramFloat2;
    localDecal.setColor(1.0F, 1.0F, 1.0F, 1.0F);
    return localDecal;
  }

  public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, int paramInt1, int paramInt2, DecalMaterial paramDecalMaterial)
  {
    Decal localDecal = new Decal(paramDecalMaterial);
    localDecal.setTextureRegion(paramTextureRegion);
    localDecal.setBlending(paramInt1, paramInt2);
    localDecal.dimensions.x = paramFloat1;
    localDecal.dimensions.y = paramFloat2;
    localDecal.setColor(1.0F, 1.0F, 1.0F, 1.0F);
    return localDecal;
  }

  public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, boolean paramBoolean)
  {
    int i = -1;
    if (paramBoolean);
    for (int j = 770; ; j = i)
    {
      if (paramBoolean)
        i = 771;
      return newDecal(paramFloat1, paramFloat2, paramTextureRegion, j, i);
    }
  }

  public static Decal newDecal(TextureRegion paramTextureRegion)
  {
    return newDecal(paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight(), paramTextureRegion, -1, -1);
  }

  public static Decal newDecal(TextureRegion paramTextureRegion, boolean paramBoolean)
  {
    int i = -1;
    float f1 = paramTextureRegion.getRegionWidth();
    float f2 = paramTextureRegion.getRegionHeight();
    if (paramBoolean);
    for (int j = 770; ; j = i)
    {
      if (paramBoolean)
        i = 771;
      return newDecal(f1, f2, paramTextureRegion, j, i);
    }
  }

  public Color getColor()
  {
    return this.color;
  }

  public float getHeight()
  {
    return this.dimensions.y;
  }

  public DecalMaterial getMaterial()
  {
    return this.material;
  }

  public Vector3 getPosition()
  {
    return this.position;
  }

  public Quaternion getRotation()
  {
    return this.rotation;
  }

  public float getScaleX()
  {
    return this.scale.x;
  }

  public float getScaleY()
  {
    return this.scale.y;
  }

  public TextureRegion getTextureRegion()
  {
    return this.material.textureRegion;
  }

  public float[] getVertices()
  {
    return this.vertices;
  }

  public float getWidth()
  {
    return this.dimensions.x;
  }

  public float getX()
  {
    return this.position.x;
  }

  public float getY()
  {
    return this.position.y;
  }

  public float getZ()
  {
    return this.position.z;
  }

  public void lookAt(Vector3 paramVector31, Vector3 paramVector32)
  {
    dir.set(paramVector31).sub(this.position).nor();
    setRotation(dir, paramVector32);
  }

  protected void resetVertices()
  {
    float f1 = -this.dimensions.x / 2.0F;
    float f2 = f1 + this.dimensions.x;
    float f3 = this.dimensions.y / 2.0F;
    float f4 = f3 - this.dimensions.y;
    this.vertices[0] = f1;
    this.vertices[1] = f3;
    this.vertices[2] = 0.0F;
    this.vertices[6] = f2;
    this.vertices[7] = f3;
    this.vertices[8] = 0.0F;
    this.vertices[12] = f1;
    this.vertices[13] = f4;
    this.vertices[14] = 0.0F;
    this.vertices[18] = f2;
    this.vertices[19] = f4;
    this.vertices[20] = 0.0F;
    this.updated = false;
  }

  public void rotateX(float paramFloat)
  {
    rotator.set(Vector3.X, paramFloat);
    this.rotation.mul(rotator);
    this.updated = false;
  }

  public void rotateY(float paramFloat)
  {
    rotator.set(Vector3.Y, paramFloat);
    this.rotation.mul(rotator);
    this.updated = false;
  }

  public void rotateZ(float paramFloat)
  {
    rotator.set(Vector3.Z, paramFloat);
    this.rotation.mul(rotator);
    this.updated = false;
  }

  public void setBlending(int paramInt1, int paramInt2)
  {
    this.material.srcBlendFactor = paramInt1;
    this.material.dstBlendFactor = paramInt2;
  }

  public void setColor(float paramFloat)
  {
    this.color.set(NumberUtils.floatToIntColor(paramFloat));
    this.vertices[3] = paramFloat;
    this.vertices[9] = paramFloat;
    this.vertices[15] = paramFloat;
    this.vertices[21] = paramFloat;
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    float f = NumberUtils.intToFloatColor((int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
    this.vertices[3] = f;
    this.vertices[9] = f;
    this.vertices[15] = f;
    this.vertices[21] = f;
  }

  public void setColor(Color paramColor)
  {
    this.color.set(paramColor);
    float f = paramColor.toFloatBits();
    this.vertices[3] = f;
    this.vertices[9] = f;
    this.vertices[15] = f;
    this.vertices[21] = f;
  }

  public void setDimensions(float paramFloat1, float paramFloat2)
  {
    this.dimensions.set(paramFloat1, paramFloat2);
    this.updated = false;
  }

  public void setHeight(float paramFloat)
  {
    this.dimensions.y = paramFloat;
    this.updated = false;
  }

  public void setMaterial(DecalMaterial paramDecalMaterial)
  {
    this.material = paramDecalMaterial;
  }

  public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.position.set(paramFloat1, paramFloat2, paramFloat3);
    this.updated = false;
  }

  public void setPosition(Vector3 paramVector3)
  {
    this.position.set(paramVector3);
    this.updated = false;
  }

  public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.rotation.setEulerAngles(paramFloat1, paramFloat2, paramFloat3);
    this.updated = false;
  }

  public void setRotation(Quaternion paramQuaternion)
  {
    this.rotation.set(paramQuaternion);
    this.updated = false;
  }

  public void setRotation(Vector3 paramVector31, Vector3 paramVector32)
  {
    tmp.set(paramVector32).crs(paramVector31).nor();
    tmp2.set(paramVector31).crs(tmp).nor();
    this.rotation.setFromAxes(tmp.x, tmp2.x, paramVector31.x, tmp.y, tmp2.y, paramVector31.y, tmp.z, tmp2.z, paramVector31.z);
    this.updated = false;
  }

  public void setRotationX(float paramFloat)
  {
    this.rotation.set(Vector3.X, paramFloat);
    this.updated = false;
  }

  public void setRotationY(float paramFloat)
  {
    this.rotation.set(Vector3.Y, paramFloat);
    this.updated = false;
  }

  public void setRotationZ(float paramFloat)
  {
    this.rotation.set(Vector3.Z, paramFloat);
    this.updated = false;
  }

  public void setScale(float paramFloat)
  {
    this.scale.set(paramFloat, paramFloat);
    this.updated = false;
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scale.set(paramFloat1, paramFloat2);
    this.updated = false;
  }

  public void setScaleX(float paramFloat)
  {
    this.scale.x = paramFloat;
    this.updated = false;
  }

  public void setScaleY(float paramFloat)
  {
    this.scale.y = paramFloat;
    this.updated = false;
  }

  public void setTextureRegion(TextureRegion paramTextureRegion)
  {
    this.material.textureRegion = paramTextureRegion;
    updateUVs();
  }

  public void setWidth(float paramFloat)
  {
    this.dimensions.x = paramFloat;
    this.updated = false;
  }

  public void setX(float paramFloat)
  {
    this.position.x = paramFloat;
    this.updated = false;
  }

  public void setY(float paramFloat)
  {
    this.position.y = paramFloat;
    this.updated = false;
  }

  public void setZ(float paramFloat)
  {
    this.position.z = paramFloat;
    this.updated = false;
  }

  protected void transformVertices()
  {
    float f2;
    float f1;
    if (this.transformationOffset != null)
    {
      f2 = -this.transformationOffset.x;
      f1 = -this.transformationOffset.y;
    }
    while (true)
    {
      float f3 = (f2 + this.vertices[0]) * this.scale.x;
      float f4 = (f1 + this.vertices[1]) * this.scale.y;
      float f5 = this.vertices[2];
      this.vertices[0] = (f3 * this.rotation.w + f5 * this.rotation.y - f4 * this.rotation.z);
      this.vertices[1] = (f4 * this.rotation.w + f3 * this.rotation.z - f5 * this.rotation.x);
      this.vertices[2] = (f5 * this.rotation.w + f4 * this.rotation.x - f3 * this.rotation.y);
      float f6 = f3 * -this.rotation.x - f4 * this.rotation.y - f5 * this.rotation.z;
      this.rotation.conjugate();
      float f7 = this.vertices[0];
      float f8 = this.vertices[1];
      float f9 = this.vertices[2];
      this.vertices[0] = (f6 * this.rotation.x + f7 * this.rotation.w + f8 * this.rotation.z - f9 * this.rotation.y);
      this.vertices[1] = (f6 * this.rotation.y + f8 * this.rotation.w + f9 * this.rotation.x - f7 * this.rotation.z);
      this.vertices[2] = (f6 * this.rotation.z + f9 * this.rotation.w + f7 * this.rotation.y - f8 * this.rotation.x);
      this.rotation.conjugate();
      float[] arrayOfFloat1 = this.vertices;
      arrayOfFloat1[0] += this.position.x - f2;
      float[] arrayOfFloat2 = this.vertices;
      arrayOfFloat2[1] += this.position.y - f1;
      float[] arrayOfFloat3 = this.vertices;
      arrayOfFloat3[2] += this.position.z;
      float f10 = (f2 + this.vertices[6]) * this.scale.x;
      float f11 = (f1 + this.vertices[7]) * this.scale.y;
      float f12 = this.vertices[8];
      this.vertices[6] = (f10 * this.rotation.w + f12 * this.rotation.y - f11 * this.rotation.z);
      this.vertices[7] = (f11 * this.rotation.w + f10 * this.rotation.z - f12 * this.rotation.x);
      this.vertices[8] = (f12 * this.rotation.w + f11 * this.rotation.x - f10 * this.rotation.y);
      float f13 = f10 * -this.rotation.x - f11 * this.rotation.y - f12 * this.rotation.z;
      this.rotation.conjugate();
      float f14 = this.vertices[6];
      float f15 = this.vertices[7];
      float f16 = this.vertices[8];
      this.vertices[6] = (f13 * this.rotation.x + f14 * this.rotation.w + f15 * this.rotation.z - f16 * this.rotation.y);
      this.vertices[7] = (f13 * this.rotation.y + f15 * this.rotation.w + f16 * this.rotation.x - f14 * this.rotation.z);
      this.vertices[8] = (f13 * this.rotation.z + f16 * this.rotation.w + f14 * this.rotation.y - f15 * this.rotation.x);
      this.rotation.conjugate();
      float[] arrayOfFloat4 = this.vertices;
      arrayOfFloat4[6] += this.position.x - f2;
      float[] arrayOfFloat5 = this.vertices;
      arrayOfFloat5[7] += this.position.y - f1;
      float[] arrayOfFloat6 = this.vertices;
      arrayOfFloat6[8] += this.position.z;
      float f17 = (f2 + this.vertices[12]) * this.scale.x;
      float f18 = (f1 + this.vertices[13]) * this.scale.y;
      float f19 = this.vertices[14];
      this.vertices[12] = (f17 * this.rotation.w + f19 * this.rotation.y - f18 * this.rotation.z);
      this.vertices[13] = (f18 * this.rotation.w + f17 * this.rotation.z - f19 * this.rotation.x);
      this.vertices[14] = (f19 * this.rotation.w + f18 * this.rotation.x - f17 * this.rotation.y);
      float f20 = f17 * -this.rotation.x - f18 * this.rotation.y - f19 * this.rotation.z;
      this.rotation.conjugate();
      float f21 = this.vertices[12];
      float f22 = this.vertices[13];
      float f23 = this.vertices[14];
      this.vertices[12] = (f20 * this.rotation.x + f21 * this.rotation.w + f22 * this.rotation.z - f23 * this.rotation.y);
      this.vertices[13] = (f20 * this.rotation.y + f22 * this.rotation.w + f23 * this.rotation.x - f21 * this.rotation.z);
      this.vertices[14] = (f20 * this.rotation.z + f23 * this.rotation.w + f21 * this.rotation.y - f22 * this.rotation.x);
      this.rotation.conjugate();
      float[] arrayOfFloat7 = this.vertices;
      arrayOfFloat7[12] += this.position.x - f2;
      float[] arrayOfFloat8 = this.vertices;
      arrayOfFloat8[13] += this.position.y - f1;
      float[] arrayOfFloat9 = this.vertices;
      arrayOfFloat9[14] += this.position.z;
      float f24 = (f2 + this.vertices[18]) * this.scale.x;
      float f25 = (f1 + this.vertices[19]) * this.scale.y;
      float f26 = this.vertices[20];
      this.vertices[18] = (f24 * this.rotation.w + f26 * this.rotation.y - f25 * this.rotation.z);
      this.vertices[19] = (f25 * this.rotation.w + f24 * this.rotation.z - f26 * this.rotation.x);
      this.vertices[20] = (f26 * this.rotation.w + f25 * this.rotation.x - f24 * this.rotation.y);
      float f27 = f24 * -this.rotation.x - f25 * this.rotation.y - f26 * this.rotation.z;
      this.rotation.conjugate();
      float f28 = this.vertices[18];
      float f29 = this.vertices[19];
      float f30 = this.vertices[20];
      this.vertices[18] = (f27 * this.rotation.x + f28 * this.rotation.w + f29 * this.rotation.z - f30 * this.rotation.y);
      this.vertices[19] = (f27 * this.rotation.y + f29 * this.rotation.w + f30 * this.rotation.x - f28 * this.rotation.z);
      this.vertices[20] = (f27 * this.rotation.z + f30 * this.rotation.w + f28 * this.rotation.y - f29 * this.rotation.x);
      this.rotation.conjugate();
      float[] arrayOfFloat10 = this.vertices;
      arrayOfFloat10[18] += this.position.x - f2;
      float[] arrayOfFloat11 = this.vertices;
      arrayOfFloat11[19] += this.position.y - f1;
      float[] arrayOfFloat12 = this.vertices;
      arrayOfFloat12[20] += this.position.z;
      this.updated = true;
      return;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }

  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.position.add(paramFloat1, paramFloat2, paramFloat3);
    this.updated = false;
  }

  public void translate(Vector3 paramVector3)
  {
    this.position.add(paramVector3);
    this.updated = false;
  }

  public void translateX(float paramFloat)
  {
    Vector3 localVector3 = this.position;
    localVector3.x = (paramFloat + localVector3.x);
    this.updated = false;
  }

  public void translateY(float paramFloat)
  {
    Vector3 localVector3 = this.position;
    localVector3.y = (paramFloat + localVector3.y);
    this.updated = false;
  }

  public void translateZ(float paramFloat)
  {
    Vector3 localVector3 = this.position;
    localVector3.z = (paramFloat + localVector3.z);
    this.updated = false;
  }

  protected void update()
  {
    if (!this.updated)
    {
      resetVertices();
      transformVertices();
    }
  }

  protected void updateUVs()
  {
    TextureRegion localTextureRegion = this.material.textureRegion;
    this.vertices[4] = localTextureRegion.getU();
    this.vertices[5] = localTextureRegion.getV();
    this.vertices[10] = localTextureRegion.getU2();
    this.vertices[11] = localTextureRegion.getV();
    this.vertices[16] = localTextureRegion.getU();
    this.vertices[17] = localTextureRegion.getV2();
    this.vertices[22] = localTextureRegion.getU2();
    this.vertices[23] = localTextureRegion.getV2();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.decals.Decal
 * JD-Core Version:    0.6.0
 */