package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class ShapeRenderer
  implements Disposable
{
  private boolean autoShapeType;
  private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  private final Matrix4 combinedMatrix = new Matrix4();
  private float defaultRectLineWidth = 0.75F;
  private boolean matrixDirty = false;
  private final Matrix4 projectionMatrix = new Matrix4();
  private final ImmediateModeRenderer renderer;
  private ShapeRenderer.ShapeType shapeType;
  private final Vector2 tmp = new Vector2();
  private final Matrix4 transformMatrix = new Matrix4();

  public ShapeRenderer()
  {
    this(5000);
  }

  public ShapeRenderer(int paramInt)
  {
    this(paramInt, null);
  }

  public ShapeRenderer(int paramInt, ShaderProgram paramShaderProgram)
  {
    if (paramShaderProgram == null);
    for (this.renderer = new ImmediateModeRenderer20(paramInt, false, true, 0); ; this.renderer = new ImmediateModeRenderer20(paramInt, false, true, 0, paramShaderProgram))
    {
      this.projectionMatrix.setToOrtho2D(0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
      this.matrixDirty = true;
      return;
    }
  }

  private void check(ShapeRenderer.ShapeType paramShapeType1, ShapeRenderer.ShapeType paramShapeType2, int paramInt)
  {
    if (this.shapeType == null)
      throw new IllegalStateException("begin must be called first.");
    if ((this.shapeType != paramShapeType1) && (this.shapeType != paramShapeType2))
    {
      if (!this.autoShapeType)
      {
        if (paramShapeType2 == null)
          throw new IllegalStateException("Must call begin(ShapeType." + paramShapeType1 + ").");
        throw new IllegalStateException("Must call begin(ShapeType." + paramShapeType1 + ") or begin(ShapeType." + paramShapeType2 + ").");
      }
      end();
      begin(paramShapeType1);
    }
    do
    {
      return;
      if (!this.matrixDirty)
        continue;
      ShapeRenderer.ShapeType localShapeType2 = this.shapeType;
      end();
      begin(localShapeType2);
      return;
    }
    while (this.renderer.getMaxVertices() - this.renderer.getNumVertices() >= paramInt);
    ShapeRenderer.ShapeType localShapeType1 = this.shapeType;
    end();
    begin(localShapeType1);
  }

  public void arc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    arc(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Math.max(1, (int)(6.0F * (float)Math.cbrt(paramFloat3) * (paramFloat5 / 360.0F))));
  }

  public void arc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("segments must be > 0.");
    float f1 = this.color.toFloatBits();
    float f2 = 6.283186F * (paramFloat5 / 360.0F) / paramInt;
    float f3 = MathUtils.cos(f2);
    float f4 = MathUtils.sin(f2);
    float f5 = paramFloat3 * MathUtils.cos(0.01745329F * paramFloat4);
    float f6 = paramFloat3 * MathUtils.sin(0.01745329F * paramFloat4);
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 2 + (paramInt << 1));
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + f5, paramFloat2 + f6, 0.0F);
      float f9 = f6;
      int j = 0;
      while (j < paramInt)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f5, paramFloat2 + f9, 0.0F);
        float f10 = f3 * f5 - f4 * f9;
        f9 = f5 * f4 + f9 * f3;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f10, paramFloat2 + f9, 0.0F);
        j++;
        f5 = f10;
      }
      this.renderer.color(f1);
      this.renderer.vertex(f5 + paramFloat1, paramFloat2 + f9, 0.0F);
    }
    while (true)
    {
      this.renderer.color(f1);
      this.renderer.vertex(0.0F + paramFloat1, 0.0F + paramFloat2, 0.0F);
      return;
      check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 3 + paramInt * 3);
      float f7 = f6;
      int i = 0;
      while (i < paramInt)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f5, paramFloat2 + f7, 0.0F);
        float f8 = f3 * f5 - f4 * f7;
        f7 = f5 * f4 + f7 * f3;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f8, paramFloat2 + f7, 0.0F);
        i++;
        f5 = f8;
      }
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(f5 + paramFloat1, paramFloat2 + f7, 0.0F);
    }
  }

  public void begin()
  {
    if (!this.autoShapeType)
      throw new IllegalStateException("autoShapeType must be true to use this method.");
    begin(ShapeRenderer.ShapeType.Line);
  }

  public void begin(ShapeRenderer.ShapeType paramShapeType)
  {
    if (this.shapeType != null)
      throw new IllegalStateException("Call end() before beginning a new shape batch.");
    this.shapeType = paramShapeType;
    if (this.matrixDirty)
    {
      this.combinedMatrix.set(this.projectionMatrix);
      Matrix4.mul(this.combinedMatrix.val, this.transformMatrix.val);
      this.matrixDirty = false;
    }
    this.renderer.begin(this.combinedMatrix, this.shapeType.getGlType());
  }

  public void box(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = -paramFloat6;
    float f2 = this.color.toFloatBits();
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 24);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
      this.renderer.color(f2);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, f1 + paramFloat3);
      return;
    }
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 36);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat5, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3 + f1);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, f1 + paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1 + paramFloat4, paramFloat2, paramFloat3);
    this.renderer.color(f2);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
  }

  public void circle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    circle(paramFloat1, paramFloat2, paramFloat3, Math.max(1, (int)(6.0F * (float)Math.cbrt(paramFloat3))));
  }

  public void circle(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    int i = 0;
    if (paramInt <= 0)
      throw new IllegalArgumentException("segments must be > 0.");
    float f1 = this.color.toFloatBits();
    float f2 = 6.283186F / paramInt;
    float f3 = MathUtils.cos(f2);
    float f4 = MathUtils.sin(f2);
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 2 + (paramInt << 1));
      float f8 = 0.0F;
      float f9 = paramFloat3;
      while (i < paramInt)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f9, paramFloat2 + f8, 0.0F);
        float f10 = f3 * f9 - f4 * f8;
        f8 = f9 * f4 + f8 * f3;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f10, paramFloat2 + f8, 0.0F);
        i++;
        f9 = f10;
      }
      this.renderer.color(f1);
      this.renderer.vertex(f9 + paramFloat1, f8 + paramFloat2, 0.0F);
    }
    while (true)
    {
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + 0.0F, 0.0F);
      return;
      check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 3 + paramInt * 3);
      int j = paramInt - 1;
      float f5 = 0.0F;
      float f6 = paramFloat3;
      while (i < j)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, 0.0F);
        float f7 = f3 * f6 - f4 * f5;
        f5 = f6 * f4 + f5 * f3;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f7, paramFloat2 + f5, 0.0F);
        i++;
        f6 = f7;
      }
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(f6 + paramFloat1, f5 + paramFloat2, 0.0F);
    }
  }

  public void cone(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    cone(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, Math.max(1, (int)(4.0F * (float)Math.sqrt(paramFloat4))));
  }

  public void cone(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("segments must be > 0.");
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 2 + (paramInt << 2));
    float f1 = this.color.toFloatBits();
    float f2 = 6.283186F / paramInt;
    float f3 = MathUtils.cos(f2);
    float f4 = MathUtils.sin(f2);
    float f5;
    float f6;
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      int k = 0;
      f5 = 0.0F;
      f6 = paramFloat4;
      while (k < paramInt)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, paramFloat3);
        float f9 = f3 * f6 - f4 * f5;
        float f10 = f6 * f4 + f5 * f3;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f9, paramFloat2 + f10, paramFloat3);
        k++;
        f5 = f10;
        f6 = f9;
      }
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, paramFloat3);
    }
    while (true)
    {
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + paramFloat4, 0.0F + paramFloat2, paramFloat3);
      if (this.shapeType != ShapeRenderer.ShapeType.Line)
      {
        this.renderer.color(f1);
        this.renderer.vertex(f6 + paramFloat1, f5 + paramFloat2, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + paramFloat4, 0.0F + paramFloat2, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
      }
      return;
      int i = paramInt - 1;
      int j = 0;
      f5 = 0.0F;
      f6 = paramFloat4;
      while (j < i)
      {
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, paramFloat3);
        float f7 = f3 * f6 - f4 * f5;
        float f8 = f4 * f6 + f3 * f5;
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f7, paramFloat2 + f8, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(f6 + paramFloat1, f5 + paramFloat2, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1 + f7, paramFloat2 + f8, paramFloat3);
        this.renderer.color(f1);
        this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3 + paramFloat5);
        j++;
        f6 = f7;
        f5 = f8;
      }
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + f6, paramFloat2 + f5, paramFloat3);
    }
  }

  public void curve(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, int paramInt)
  {
    check(ShapeRenderer.ShapeType.Line, null, 2 + (paramInt << 1));
    float f1 = this.color.toFloatBits();
    float f2 = 1.0F / paramInt;
    float f3 = f2 * f2;
    float f4 = f3 * f2;
    float f5 = f2 * 3.0F;
    float f6 = 3.0F * f3;
    float f7 = 6.0F * f3;
    float f8 = 6.0F * f4;
    float f9 = paramFloat5 + (paramFloat1 - 2.0F * paramFloat3);
    float f10 = paramFloat6 + (paramFloat2 - 2.0F * paramFloat4);
    float f11 = paramFloat7 + (3.0F * (paramFloat3 - paramFloat5) - paramFloat1);
    float f12 = paramFloat8 + (3.0F * (paramFloat4 - paramFloat6) - paramFloat2);
    float f13 = f5 * (paramFloat3 - paramFloat1) + f9 * f6 + f11 * f4;
    float f14 = f5 * (paramFloat4 - paramFloat2) + f6 * f10 + f4 * f12;
    float f15 = f9 * f7 + f11 * f8;
    float f16 = f10 * f7 + f12 * f8;
    float f17 = f11 * f8;
    float f18 = f8 * f12;
    float f19 = f13;
    float f20 = f14;
    float f21 = f15;
    float f22 = f16;
    while (true)
    {
      int i = paramInt - 1;
      if (paramInt <= 0)
        break;
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      paramFloat1 += f19;
      paramFloat2 += f20;
      f19 += f21;
      f20 += f22;
      f21 += f17;
      f22 += f18;
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      paramInt = i;
    }
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat7, paramFloat8, 0.0F);
  }

  public void dispose()
  {
    this.renderer.dispose();
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ellipse(paramFloat1, paramFloat2, paramFloat3, paramFloat4, Math.max(1, (int)(12.0F * (float)Math.cbrt(Math.max(paramFloat3 * 0.5F, 0.5F * paramFloat4)))));
  }

  public void ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("segments must be > 0.");
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, paramInt * 3);
    float f1 = this.color.toFloatBits();
    float f2 = 6.283186F / paramInt;
    float f3 = paramFloat1 + paramFloat3 / 2.0F;
    float f4 = paramFloat2 + paramFloat4 / 2.0F;
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
      for (int j = 0; j < paramInt; j++)
      {
        this.renderer.color(f1);
        this.renderer.vertex(f3 + 0.5F * paramFloat3 * MathUtils.cos(f2 * j), f4 + 0.5F * paramFloat4 * MathUtils.sin(f2 * j), 0.0F);
        this.renderer.color(f1);
        this.renderer.vertex(f3 + 0.5F * paramFloat3 * MathUtils.cos(f2 * (j + 1)), f4 + 0.5F * paramFloat4 * MathUtils.sin(f2 * (j + 1)), 0.0F);
      }
    for (int i = 0; i < paramInt; i++)
    {
      this.renderer.color(f1);
      this.renderer.vertex(f3 + 0.5F * paramFloat3 * MathUtils.cos(f2 * i), f4 + 0.5F * paramFloat4 * MathUtils.sin(f2 * i), 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(f3, f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(f3 + 0.5F * paramFloat3 * MathUtils.cos(f2 * (i + 1)), f4 + 0.5F * paramFloat4 * MathUtils.sin(f2 * (i + 1)), 0.0F);
    }
  }

  public void end()
  {
    this.renderer.end();
    this.shapeType = null;
  }

  public void flush()
  {
    ShapeRenderer.ShapeType localShapeType = this.shapeType;
    end();
    begin(localShapeType);
  }

  public Color getColor()
  {
    return this.color;
  }

  public ShapeRenderer.ShapeType getCurrentType()
  {
    return this.shapeType;
  }

  public Matrix4 getProjectionMatrix()
  {
    return this.projectionMatrix;
  }

  public ImmediateModeRenderer getRenderer()
  {
    return this.renderer;
  }

  public Matrix4 getTransformMatrix()
  {
    return this.transformMatrix;
  }

  public void identity()
  {
    this.transformMatrix.idt();
    this.matrixDirty = true;
  }

  public boolean isDrawing()
  {
    return this.shapeType != null;
  }

  public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    line(paramFloat1, paramFloat2, 0.0F, paramFloat3, paramFloat4, 0.0F, this.color, this.color);
  }

  public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    line(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, this.color, this.color);
  }

  public void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2)
  {
    if (this.shapeType == ShapeRenderer.ShapeType.Filled)
    {
      rectLine(paramFloat1, paramFloat2, paramFloat4, paramFloat5, this.defaultRectLineWidth);
      return;
    }
    check(ShapeRenderer.ShapeType.Line, null, 2);
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
    this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
    this.renderer.vertex(paramFloat4, paramFloat5, paramFloat6);
  }

  public final void line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor1, Color paramColor2)
  {
    line(paramFloat1, paramFloat2, 0.0F, paramFloat3, paramFloat4, 0.0F, paramColor1, paramColor2);
  }

  public final void line(Vector2 paramVector21, Vector2 paramVector22)
  {
    line(paramVector21.x, paramVector21.y, 0.0F, paramVector22.x, paramVector22.y, 0.0F, this.color, this.color);
  }

  public final void line(Vector3 paramVector31, Vector3 paramVector32)
  {
    line(paramVector31.x, paramVector31.y, paramVector31.z, paramVector32.x, paramVector32.y, paramVector32.z, this.color, this.color);
  }

  public void point(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      float f2 = 0.5F * this.defaultRectLineWidth;
      line(paramFloat1 - f2, paramFloat2 - f2, paramFloat3, paramFloat1 + f2, paramFloat2 + f2, paramFloat3);
      return;
    }
    if (this.shapeType == ShapeRenderer.ShapeType.Filled)
    {
      float f1 = 0.5F * this.defaultRectLineWidth;
      box(paramFloat1 - f1, paramFloat2 - f1, paramFloat3 - f1, this.defaultRectLineWidth, this.defaultRectLineWidth, this.defaultRectLineWidth);
      return;
    }
    check(ShapeRenderer.ShapeType.Point, null, 1);
    this.renderer.color(this.color);
    this.renderer.vertex(paramFloat1, paramFloat2, paramFloat3);
  }

  public void polygon(float[] paramArrayOfFloat)
  {
    polygon(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public void polygon(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 6)
      throw new IllegalArgumentException("Polygons must contain at least 3 points.");
    if (paramInt2 % 2 != 0)
      throw new IllegalArgumentException("Polygons must have an even number of vertices.");
    check(ShapeRenderer.ShapeType.Line, null, paramInt2);
    float f1 = this.color.toFloatBits();
    float f2 = paramArrayOfFloat[0];
    float f3 = paramArrayOfFloat[1];
    int i = paramInt1 + paramInt2;
    if (paramInt1 < i)
    {
      float f4 = paramArrayOfFloat[paramInt1];
      float f5 = paramArrayOfFloat[(paramInt1 + 1)];
      float f7;
      float f6;
      if (paramInt1 + 2 >= paramInt2)
      {
        f7 = f3;
        f6 = f2;
      }
      while (true)
      {
        this.renderer.color(f1);
        this.renderer.vertex(f4, f5, 0.0F);
        this.renderer.color(f1);
        this.renderer.vertex(f6, f7, 0.0F);
        paramInt1 += 2;
        break;
        f6 = paramArrayOfFloat[(paramInt1 + 2)];
        f7 = paramArrayOfFloat[(paramInt1 + 3)];
      }
    }
  }

  public void polyline(float[] paramArrayOfFloat)
  {
    polyline(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public void polyline(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 4)
      throw new IllegalArgumentException("Polylines must contain at least 2 points.");
    if (paramInt2 % 2 != 0)
      throw new IllegalArgumentException("Polylines must have an even number of vertices.");
    check(ShapeRenderer.ShapeType.Line, null, paramInt2);
    float f1 = this.color.toFloatBits();
    int i = -2 + (paramInt1 + paramInt2);
    while (paramInt1 < i)
    {
      float f2 = paramArrayOfFloat[paramInt1];
      float f3 = paramArrayOfFloat[(paramInt1 + 1)];
      float f4 = paramArrayOfFloat[(paramInt1 + 2)];
      float f5 = paramArrayOfFloat[(paramInt1 + 3)];
      this.renderer.color(f1);
      this.renderer.vertex(f2, f3, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(f4, f5, 0.0F);
      paramInt1 += 2;
    }
  }

  public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 8);
    float f = this.color.toFloatBits();
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      return;
    }
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
  }

  public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    rect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, this.color, this.color, this.color, this.color);
  }

  public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 8);
    float f1 = MathUtils.cosDeg(paramFloat9);
    float f2 = MathUtils.sinDeg(paramFloat9);
    float f3 = -paramFloat3;
    float f4 = -paramFloat4;
    float f5 = paramFloat5 - paramFloat3;
    float f6 = paramFloat6 - paramFloat4;
    if ((paramFloat7 != 1.0F) || (paramFloat8 != 1.0F))
    {
      f3 *= paramFloat7;
      f4 *= paramFloat8;
      f5 *= paramFloat7;
      f6 *= paramFloat8;
    }
    float f7 = paramFloat1 + paramFloat3;
    float f8 = paramFloat2 + paramFloat4;
    float f9 = f7 + (f1 * f3 - f2 * f4);
    float f10 = f8 + (f3 * f2 + f1 * f4);
    float f11 = f7 + (f1 * f5 - f2 * f4);
    float f12 = f8 + (f2 * f5 + f4 * f1);
    float f13 = f7 + (f1 * f5 - f2 * f6);
    float f14 = f8 + (f5 * f2 + f6 * f1);
    float f15 = f9 + (f13 - f11);
    float f16 = f14 - (f12 - f10);
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(f9, f10, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(f11, f12, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(f11, f12, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(f13, f14, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(f13, f14, 0.0F);
      this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
      this.renderer.vertex(f15, f16, 0.0F);
      this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
      this.renderer.vertex(f15, f16, 0.0F);
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(f9, f10, 0.0F);
      return;
    }
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(f9, f10, 0.0F);
    this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
    this.renderer.vertex(f11, f12, 0.0F);
    this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
    this.renderer.vertex(f13, f14, 0.0F);
    this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
    this.renderer.vertex(f13, f14, 0.0F);
    this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
    this.renderer.vertex(f15, f16, 0.0F);
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(f9, f10, 0.0F);
  }

  public void rect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor1, Color paramColor2, Color paramColor3, Color paramColor4)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 8);
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
      this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      return;
    }
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
    this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2, 0.0F);
    this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
    this.renderer.vertex(paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
    this.renderer.vertex(paramFloat1, paramFloat2 + paramFloat4, 0.0F);
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
  }

  public void rectLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 8);
    float f1 = this.color.toFloatBits();
    Vector2 localVector2 = this.tmp.set(paramFloat4 - paramFloat2, paramFloat1 - paramFloat3).nor();
    float f2 = 0.5F * paramFloat5;
    float f3 = f2 * localVector2.x;
    float f4 = f2 * localVector2.y;
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + f3, paramFloat2 + f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 - f3, paramFloat2 - f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat3 + f3, paramFloat4 + f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat3 - f3, paramFloat4 - f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat3 + f3, paramFloat4 + f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 + f3, paramFloat2 + f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat3 - f3, paramFloat4 - f4, 0.0F);
      this.renderer.color(f1);
      this.renderer.vertex(paramFloat1 - f3, paramFloat2 - f4, 0.0F);
      return;
    }
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat1 + f3, paramFloat2 + f4, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat1 - f3, paramFloat2 - f4, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat3 + f3, paramFloat4 + f4, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat3 - f3, paramFloat4 - f4, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat3 + f3, paramFloat4 + f4, 0.0F);
    this.renderer.color(f1);
    this.renderer.vertex(paramFloat1 - f3, paramFloat2 - f4, 0.0F);
  }

  public void rectLine(Vector2 paramVector21, Vector2 paramVector22, float paramFloat)
  {
    rectLine(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramFloat);
  }

  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.transformMatrix.rotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.matrixDirty = true;
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.transformMatrix.scale(paramFloat1, paramFloat2, paramFloat3);
    this.matrixDirty = true;
  }

  public void set(ShapeRenderer.ShapeType paramShapeType)
  {
    if (this.shapeType == paramShapeType)
      return;
    if (this.shapeType == null)
      throw new IllegalStateException("begin must be called first.");
    if (!this.autoShapeType)
      throw new IllegalStateException("autoShapeType must be enabled.");
    end();
    begin(paramShapeType);
  }

  public void setAutoShapeType(boolean paramBoolean)
  {
    this.autoShapeType = paramBoolean;
  }

  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void setColor(Color paramColor)
  {
    this.color.set(paramColor);
  }

  public void setProjectionMatrix(Matrix4 paramMatrix4)
  {
    this.projectionMatrix.set(paramMatrix4);
    this.matrixDirty = true;
  }

  public void setTransformMatrix(Matrix4 paramMatrix4)
  {
    this.transformMatrix.set(paramMatrix4);
    this.matrixDirty = true;
  }

  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.transformMatrix.translate(paramFloat1, paramFloat2, paramFloat3);
    this.matrixDirty = true;
  }

  public void triangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 6);
    float f = this.color.toFloatBits();
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
      this.renderer.color(f);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      return;
    }
    this.renderer.color(f);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
    this.renderer.color(f);
    this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
  }

  public void triangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2, Color paramColor3)
  {
    check(ShapeRenderer.ShapeType.Line, ShapeRenderer.ShapeType.Filled, 6);
    if (this.shapeType == ShapeRenderer.ShapeType.Line)
    {
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
      this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
      this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
      this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
      this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
      this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
      this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
      return;
    }
    this.renderer.color(paramColor1.r, paramColor1.g, paramColor1.b, paramColor1.a);
    this.renderer.vertex(paramFloat1, paramFloat2, 0.0F);
    this.renderer.color(paramColor2.r, paramColor2.g, paramColor2.b, paramColor2.a);
    this.renderer.vertex(paramFloat3, paramFloat4, 0.0F);
    this.renderer.color(paramColor3.r, paramColor3.g, paramColor3.b, paramColor3.a);
    this.renderer.vertex(paramFloat5, paramFloat6, 0.0F);
  }

  public void updateMatrices()
  {
    this.matrixDirty = true;
  }

  public void x(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    line(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3);
    line(paramFloat1 - paramFloat3, paramFloat2 + paramFloat3, paramFloat1 + paramFloat3, paramFloat2 - paramFloat3);
  }

  public void x(Vector2 paramVector2, float paramFloat)
  {
    x(paramVector2.x, paramVector2.y, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.ShapeRenderer
 * JD-Core Version:    0.6.0
 */