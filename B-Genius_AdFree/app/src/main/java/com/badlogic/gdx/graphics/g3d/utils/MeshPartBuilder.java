package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract interface MeshPartBuilder
{
  public abstract void addMesh(Mesh paramMesh);

  public abstract void addMesh(Mesh paramMesh, int paramInt1, int paramInt2);

  public abstract void addMesh(MeshPart paramMeshPart);

  public abstract void arrow(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt);

  public abstract void box(float paramFloat1, float paramFloat2, float paramFloat3);

  public abstract void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);

  public abstract void box(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, MeshPartBuilder.VertexInfo paramVertexInfo5, MeshPartBuilder.VertexInfo paramVertexInfo6, MeshPartBuilder.VertexInfo paramVertexInfo7, MeshPartBuilder.VertexInfo paramVertexInfo8);

  public abstract void box(Matrix4 paramMatrix4);

  public abstract void box(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, Vector3 paramVector36, Vector3 paramVector37, Vector3 paramVector38);

  public abstract void capsule(float paramFloat1, float paramFloat2, int paramInt);

  public abstract void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);

  public abstract void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9);

  public abstract void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13);

  public abstract void circle(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15);

  public abstract void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32);

  public abstract void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat2, float paramFloat3);

  public abstract void circle(float paramFloat, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34);

  public abstract void circle(float paramFloat1, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat2, float paramFloat3);

  public abstract void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);

  public abstract void cone(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5);

  public abstract void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);

  public abstract void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5);

  public abstract void cylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5, boolean paramBoolean);

  public abstract void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10);

  public abstract void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12);

  public abstract void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18);

  public abstract void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Vector3 paramVector31, Vector3 paramVector32);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, float paramFloat3, float paramFloat4);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34);

  public abstract void ellipse(float paramFloat1, float paramFloat2, int paramInt, Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, float paramFloat3, float paramFloat4);

  public abstract VertexAttributes getAttributes();

  public abstract MeshPart getMeshPart();

  public abstract Matrix4 getVertexTransform(Matrix4 paramMatrix4);

  public abstract void index(short paramShort);

  public abstract void index(short paramShort1, short paramShort2);

  public abstract void index(short paramShort1, short paramShort2, short paramShort3);

  public abstract void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4);

  public abstract void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6);

  public abstract void index(short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5, short paramShort6, short paramShort7, short paramShort8);

  public abstract boolean isVertexTransformationEnabled();

  public abstract short lastIndex();

  public abstract void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);

  public abstract void line(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2);

  public abstract void line(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2);

  public abstract void line(Vector3 paramVector31, Vector3 paramVector32);

  public abstract void line(short paramShort1, short paramShort2);

  public abstract void patch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, int paramInt1, int paramInt2);

  public abstract void patch(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4, int paramInt1, int paramInt2);

  public abstract void patch(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35, int paramInt1, int paramInt2);

  public abstract void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15);

  public abstract void rect(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3, MeshPartBuilder.VertexInfo paramVertexInfo4);

  public abstract void rect(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33, Vector3 paramVector34, Vector3 paramVector35);

  public abstract void rect(short paramShort1, short paramShort2, short paramShort3, short paramShort4);

  public abstract void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void setColor(Color paramColor);

  public abstract void setUVRange(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public abstract void setUVRange(TextureRegion paramTextureRegion);

  public abstract void setVertexTransform(Matrix4 paramMatrix4);

  public abstract void setVertexTransformationEnabled(boolean paramBoolean);

  public abstract void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);

  public abstract void sphere(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);

  public abstract void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);

  public abstract void sphere(Matrix4 paramMatrix4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);

  public abstract void triangle(MeshPartBuilder.VertexInfo paramVertexInfo1, MeshPartBuilder.VertexInfo paramVertexInfo2, MeshPartBuilder.VertexInfo paramVertexInfo3);

  public abstract void triangle(Vector3 paramVector31, Color paramColor1, Vector3 paramVector32, Color paramColor2, Vector3 paramVector33, Color paramColor3);

  public abstract void triangle(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33);

  public abstract void triangle(short paramShort1, short paramShort2, short paramShort3);

  public abstract short vertex(MeshPartBuilder.VertexInfo paramVertexInfo);

  public abstract short vertex(Vector3 paramVector31, Vector3 paramVector32, Color paramColor, Vector2 paramVector2);

  public abstract short vertex(float[] paramArrayOfFloat);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder
 * JD-Core Version:    0.6.0
 */