package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.SnapshotArray;

public class Table extends WidgetGroup
{
  public static Value backgroundBottom;
  public static Value backgroundLeft;
  public static Value backgroundRight;
  public static Value backgroundTop;
  static final Pool cellPool;
  private static float[] columnWeightedWidth;
  public static Color debugActorColor;
  public static Color debugCellColor;
  public static Color debugTableColor = new Color(0.0F, 0.0F, 1.0F, 1.0F);
  private static float[] rowWeightedHeight;
  int align = 1;
  Drawable background;
  private final Cell cellDefaults;
  private final Array cells = new Array(4);
  private boolean clip;
  private final Array columnDefaults = new Array(2);
  private float[] columnMinWidth;
  private float[] columnPrefWidth;
  private float[] columnWidth;
  private int columns;
  Table.Debug debug = Table.Debug.none;
  Array debugRects;
  private float[] expandHeight;
  private float[] expandWidth;
  private boolean implicitEndRow;
  Value padBottom = backgroundBottom;
  Value padLeft = backgroundLeft;
  Value padRight = backgroundRight;
  Value padTop = backgroundTop;
  boolean round = true;
  private Cell rowDefaults;
  private float[] rowHeight;
  private float[] rowMinHeight;
  private float[] rowPrefHeight;
  private int rows;
  private boolean sizeInvalid = true;
  private Skin skin;
  private float tableMinHeight;
  private float tableMinWidth;
  private float tablePrefHeight;
  private float tablePrefWidth;

  static
  {
    debugCellColor = new Color(1.0F, 0.0F, 0.0F, 1.0F);
    debugActorColor = new Color(0.0F, 1.0F, 0.0F, 1.0F);
    cellPool = new Table.1();
    backgroundTop = new Table.2();
    backgroundLeft = new Table.3();
    backgroundBottom = new Table.4();
    backgroundRight = new Table.5();
  }

  public Table()
  {
    this(null);
  }

  public Table(Skin paramSkin)
  {
    this.skin = paramSkin;
    this.cellDefaults = obtainCell();
    setTransform(false);
    setTouchable(Touchable.childrenOnly);
  }

  private void addDebugRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor)
  {
    if (this.debugRects == null)
      this.debugRects = new Array();
    Table.DebugRect localDebugRect = (Table.DebugRect)Table.DebugRect.pool.obtain();
    localDebugRect.color = paramColor;
    localDebugRect.set(paramFloat1, getHeight() - paramFloat2 - paramFloat4, paramFloat3, paramFloat4);
    this.debugRects.add(localDebugRect);
  }

  private void clearDebugRects()
  {
    if (this.debugRects == null)
      return;
    Table.DebugRect.pool.freeAll(this.debugRects);
    this.debugRects.clear();
  }

  private void computeSize()
  {
    this.sizeInvalid = false;
    Array localArray = this.cells;
    int i = localArray.size;
    int j;
    int k;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    float[] arrayOfFloat5;
    float f1;
    int m;
    label190: Cell localCell5;
    int i19;
    int i20;
    int i21;
    Actor localActor2;
    float f28;
    label334: float f30;
    label454: float f32;
    label488: float f33;
    float f34;
    float f35;
    float f36;
    float f37;
    float f38;
    if ((i > 0) && (!((Cell)localArray.peek()).endRow))
    {
      endRow();
      this.implicitEndRow = true;
      j = this.columns;
      k = this.rows;
      arrayOfFloat1 = ensureSize(this.columnMinWidth, j);
      this.columnMinWidth = arrayOfFloat1;
      arrayOfFloat2 = ensureSize(this.rowMinHeight, k);
      this.rowMinHeight = arrayOfFloat2;
      arrayOfFloat3 = ensureSize(this.columnPrefWidth, j);
      this.columnPrefWidth = arrayOfFloat3;
      arrayOfFloat4 = ensureSize(this.rowPrefHeight, k);
      this.rowPrefHeight = arrayOfFloat4;
      this.columnWidth = ensureSize(this.columnWidth, j);
      this.rowHeight = ensureSize(this.rowHeight, k);
      arrayOfFloat5 = ensureSize(this.expandWidth, j);
      this.expandWidth = arrayOfFloat5;
      float[] arrayOfFloat6 = ensureSize(this.expandHeight, k);
      this.expandHeight = arrayOfFloat6;
      f1 = 0.0F;
      m = 0;
      if (m >= i)
        break label786;
      localCell5 = (Cell)localArray.get(m);
      i19 = localCell5.column;
      i20 = localCell5.row;
      i21 = localCell5.colspan.intValue();
      localActor2 = localCell5.actor;
      if ((localCell5.expandY.intValue() != 0) && (arrayOfFloat6[i20] == 0.0F))
        arrayOfFloat6[i20] = localCell5.expandY.intValue();
      if ((i21 == 1) && (localCell5.expandX.intValue() != 0) && (arrayOfFloat5[i19] == 0.0F))
        arrayOfFloat5[i19] = localCell5.expandX.intValue();
      float f27 = localCell5.padLeft.get(localActor2);
      if (i19 != 0)
        break label742;
      f28 = 0.0F;
      localCell5.computedPadLeft = (f28 + f27);
      localCell5.computedPadTop = localCell5.padTop.get(localActor2);
      if (localCell5.cellAboveIndex != -1)
      {
        Cell localCell6 = (Cell)localArray.get(localCell5.cellAboveIndex);
        localCell5.computedPadTop += Math.max(0.0F, localCell5.spaceTop.get(localActor2) - localCell6.spaceBottom.get(localActor2));
      }
      f1 = localCell5.spaceRight.get(localActor2);
      float f29 = localCell5.padRight.get(localActor2);
      if (i19 + i21 != j)
        break label764;
      f30 = 0.0F;
      localCell5.computedPadRight = (f30 + f29);
      float f31 = localCell5.padBottom.get(localActor2);
      if (i20 != k - 1)
        break label771;
      f32 = 0.0F;
      localCell5.computedPadBottom = (f32 + f31);
      f33 = localCell5.prefWidth.get(localActor2);
      f34 = localCell5.prefHeight.get(localActor2);
      f35 = localCell5.minWidth.get(localActor2);
      f36 = localCell5.minHeight.get(localActor2);
      f37 = localCell5.maxWidth.get(localActor2);
      f38 = localCell5.maxHeight.get(localActor2);
      if (f33 < f35)
        f33 = f35;
      if (f34 < f36)
        f34 = f36;
      if ((f37 <= 0.0F) || (f33 <= f37))
        break label1822;
    }
    while (true)
    {
      if ((f38 > 0.0F) && (f34 > f38));
      while (true)
      {
        if (i21 == 1)
        {
          float f40 = localCell5.computedPadLeft + localCell5.computedPadRight;
          arrayOfFloat3[i19] = Math.max(arrayOfFloat3[i19], f37 + f40);
          arrayOfFloat1[i19] = Math.max(arrayOfFloat1[i19], f40 + f35);
        }
        float f39 = localCell5.computedPadTop + localCell5.computedPadBottom;
        arrayOfFloat4[i20] = Math.max(arrayOfFloat4[i20], f38 + f39);
        arrayOfFloat2[i20] = Math.max(arrayOfFloat2[i20], f39 + f36);
        m++;
        break label190;
        this.implicitEndRow = false;
        break;
        label742: f28 = Math.max(0.0F, localCell5.spaceLeft.get(localActor2) - f1);
        break label334;
        label764: f30 = f1;
        break label454;
        label771: f32 = localCell5.spaceBottom.get(localActor2);
        break label488;
        label786: for (int n = 0; n < i; n++)
        {
          Cell localCell4 = (Cell)localArray.get(n);
          int i14 = localCell4.expandX.intValue();
          if (i14 == 0)
            continue;
          int i15 = localCell4.column;
          int i16 = i15 + localCell4.colspan.intValue();
          int i17 = i15;
          while (true)
            if (i17 < i16)
            {
              if (arrayOfFloat5[i17] != 0.0F)
                break;
              i17++;
              continue;
            }
            else
            {
              for (int i18 = i15; i18 < i16; i18++)
                arrayOfFloat5[i18] = i14;
            }
        }
        float f2 = 0.0F;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        int i1 = 0;
        float f22;
        float f23;
        if (i1 < i)
        {
          Cell localCell3 = (Cell)localArray.get(i1);
          if ((localCell3.uniformX == Boolean.TRUE) && (localCell3.colspan.intValue() == 1))
          {
            float f26 = localCell3.computedPadLeft + localCell3.computedPadRight;
            f2 = Math.max(f2, arrayOfFloat1[localCell3.column] - f26);
            f4 = Math.max(f4, arrayOfFloat3[localCell3.column] - f26);
          }
          if (localCell3.uniformY != Boolean.TRUE)
            break label1804;
          float f24 = localCell3.computedPadTop + localCell3.computedPadBottom;
          float f25 = Math.max(f3, arrayOfFloat2[localCell3.row] - f24);
          f22 = Math.max(f5, arrayOfFloat4[localCell3.row] - f24);
          f23 = f25;
        }
        while (true)
        {
          i1++;
          f3 = f23;
          f5 = f22;
          break;
          if ((f4 > 0.0F) || (f5 > 0.0F))
            for (int i2 = 0; i2 < i; i2++)
            {
              Cell localCell2 = (Cell)localArray.get(i2);
              if ((f4 > 0.0F) && (localCell2.uniformX == Boolean.TRUE) && (localCell2.colspan.intValue() == 1))
              {
                float f21 = localCell2.computedPadLeft + localCell2.computedPadRight;
                arrayOfFloat1[localCell2.column] = (f2 + f21);
                arrayOfFloat3[localCell2.column] = (f21 + f4);
              }
              if ((f5 <= 0.0F) || (localCell2.uniformY != Boolean.TRUE))
                continue;
              float f20 = localCell2.computedPadTop + localCell2.computedPadBottom;
              arrayOfFloat2[localCell2.row] = (f3 + f20);
              arrayOfFloat4[localCell2.row] = (f20 + f5);
            }
          int i3 = 0;
          Cell localCell1;
          int i6;
          int i7;
          float f8;
          float f9;
          float f10;
          if (i3 < i)
          {
            localCell1 = (Cell)localArray.get(i3);
            i6 = localCell1.colspan.intValue();
            if (i6 != 1)
            {
              i7 = localCell1.column;
              Actor localActor1 = localCell1.actor;
              f8 = localCell1.minWidth.get(localActor1);
              f9 = localCell1.prefWidth.get(localActor1);
              f10 = localCell1.maxWidth.get(localActor1);
              if (f9 < f8)
                f9 = f8;
              if ((f10 <= 0.0F) || (f9 <= f10))
                break label1797;
            }
          }
          while (true)
          {
            float f11 = -(localCell1.computedPadLeft + localCell1.computedPadRight);
            int i8 = i7 + i6;
            float f12 = f11;
            float f13 = f11;
            int i9 = i7;
            while (i9 < i8)
            {
              float f18 = f13 + arrayOfFloat1[i9];
              float f19 = f12 + arrayOfFloat3[i9];
              int i13 = i9 + 1;
              f13 = f18;
              i9 = i13;
              f12 = f19;
            }
            int i10 = i7 + i6;
            float f14 = 0.0F;
            for (int i11 = i7; i11 < i10; i11++)
              f14 += arrayOfFloat5[i11];
            float f15 = Math.max(0.0F, f8 - f13);
            float f16 = Math.max(0.0F, f10 - f12);
            int i12 = i7 + i6;
            if (i7 < i12)
            {
              float f17;
              if (f14 == 0.0F)
                f17 = 1.0F / i6;
              while (true)
              {
                arrayOfFloat1[i7] += f15 * f17;
                arrayOfFloat3[i7] += f17 * f16;
                i7++;
                break;
                f17 = arrayOfFloat5[i7] / f14;
              }
            }
            i3++;
            break;
            this.tableMinWidth = 0.0F;
            this.tableMinHeight = 0.0F;
            this.tablePrefWidth = 0.0F;
            this.tablePrefHeight = 0.0F;
            for (int i4 = 0; i4 < j; i4++)
            {
              this.tableMinWidth += arrayOfFloat1[i4];
              this.tablePrefWidth += arrayOfFloat3[i4];
            }
            for (int i5 = 0; i5 < k; i5++)
            {
              this.tableMinHeight += arrayOfFloat2[i5];
              this.tablePrefHeight += Math.max(arrayOfFloat2[i5], arrayOfFloat4[i5]);
            }
            float f6 = this.padLeft.get(this) + this.padRight.get(this);
            float f7 = this.padTop.get(this) + this.padBottom.get(this);
            this.tableMinWidth = (f6 + this.tableMinWidth);
            this.tableMinHeight = (f7 + this.tableMinHeight);
            this.tablePrefWidth = Math.max(f6 + this.tablePrefWidth, this.tableMinWidth);
            this.tablePrefHeight = Math.max(f7 + this.tablePrefHeight, this.tableMinHeight);
            return;
            label1797: f10 = f9;
          }
          label1804: f22 = f5;
          f23 = f3;
        }
        f38 = f34;
      }
      label1822: f37 = f33;
    }
  }

  private void drawDebugRects(ShapeRenderer paramShapeRenderer)
  {
    if ((this.debugRects == null) || (!getDebug()))
      return;
    paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
    paramShapeRenderer.setColor(getStage().getDebugColor());
    float f2;
    float f1;
    if (!isTransform())
    {
      float f3 = getX();
      float f4 = getY();
      f2 = f3;
      f1 = f4;
    }
    while (true)
    {
      int i = this.debugRects.size;
      for (int j = 0; j < i; j++)
      {
        Table.DebugRect localDebugRect = (Table.DebugRect)this.debugRects.get(j);
        paramShapeRenderer.setColor(localDebugRect.color);
        paramShapeRenderer.rect(f2 + localDebugRect.x, f1 + localDebugRect.y, localDebugRect.width, localDebugRect.height);
      }
      break;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }

  private void endRow()
  {
    Array localArray = this.cells;
    int i = -1 + localArray.size;
    int j = 0;
    for (int k = i; k >= 0; k--)
    {
      Cell localCell = (Cell)localArray.get(k);
      if (localCell.endRow)
        break;
      j += localCell.colspan.intValue();
    }
    this.columns = Math.max(this.columns, j);
    this.rows = (1 + this.rows);
    ((Cell)localArray.peek()).endRow = true;
  }

  private float[] ensureSize(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < paramInt))
      paramArrayOfFloat = new float[paramInt];
    while (true)
    {
      return paramArrayOfFloat;
      int i = 0;
      int j = paramArrayOfFloat.length;
      while (i < j)
      {
        paramArrayOfFloat[i] = 0.0F;
        i++;
      }
    }
  }

  private void layout(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Array localArray = this.cells;
    int i = localArray.size;
    if (this.sizeInvalid)
      computeSize();
    float f1 = this.padLeft.get(this);
    float f2 = f1 + this.padRight.get(this);
    float f3 = this.padTop.get(this);
    float f4 = f3 + this.padBottom.get(this);
    int j = this.columns;
    int k = this.rows;
    float[] arrayOfFloat1 = this.expandWidth;
    float[] arrayOfFloat2 = this.expandHeight;
    float[] arrayOfFloat3 = this.columnWidth;
    float[] arrayOfFloat4 = this.rowHeight;
    int m = 0;
    float f5 = 0.0F;
    while (m < j)
    {
      float f61 = f5 + arrayOfFloat1[m];
      m++;
      f5 = f61;
    }
    int n = 0;
    float f6 = 0.0F;
    while (n < k)
    {
      float f60 = f6 + arrayOfFloat2[n];
      n++;
      f6 = f60;
    }
    float f7 = this.tablePrefWidth - this.tableMinWidth;
    if (f7 == 0.0F);
    float[] arrayOfFloat5;
    for (Object localObject1 = this.columnMinWidth; ; localObject1 = arrayOfFloat5)
    {
      float f9 = this.tablePrefHeight - this.tableMinHeight;
      if (f9 == 0.0F);
      float[] arrayOfFloat8;
      for (Object localObject2 = this.rowMinHeight; ; localObject2 = arrayOfFloat8)
      {
        int i3 = 0;
        Cell localCell4;
        int i26;
        int i27;
        int i28;
        float f49;
        float f50;
        float f51;
        float f52;
        float f53;
        float f54;
        float f55;
        float f56;
        if (i3 < i)
        {
          localCell4 = (Cell)localArray.get(i3);
          i26 = localCell4.column;
          i27 = localCell4.row;
          Actor localActor = localCell4.actor;
          i28 = localCell4.colspan.intValue();
          int i29 = i26 + i28;
          f49 = 0.0F;
          int i30 = i26;
          while (i30 < i29)
          {
            float f57 = f49 + localObject1[i30];
            i30++;
            f49 = f57;
            continue;
            float f8 = Math.min(f7, Math.max(0.0F, paramFloat3 - this.tableMinWidth));
            arrayOfFloat5 = ensureSize(columnWeightedWidth, j);
            columnWeightedWidth = arrayOfFloat5;
            float[] arrayOfFloat6 = this.columnMinWidth;
            float[] arrayOfFloat7 = this.columnPrefWidth;
            for (int i1 = 0; i1 < j; i1++)
            {
              float f59 = (arrayOfFloat7[i1] - arrayOfFloat6[i1]) / f7;
              arrayOfFloat6[i1] += f59 * f8;
            }
            arrayOfFloat8 = ensureSize(rowWeightedHeight, k);
            rowWeightedHeight = arrayOfFloat8;
            float f10 = Math.min(f9, Math.max(0.0F, paramFloat4 - this.tableMinHeight));
            float[] arrayOfFloat9 = this.rowMinHeight;
            float[] arrayOfFloat10 = this.rowPrefHeight;
            for (int i2 = 0; i2 < k; i2++)
            {
              float f58 = (arrayOfFloat10[i2] - arrayOfFloat9[i2]) / f9;
              arrayOfFloat9[i2] += f58 * f10;
            }
          }
          f50 = localObject2[i27];
          f51 = localCell4.prefWidth.get(localActor);
          f52 = localCell4.prefHeight.get(localActor);
          f53 = localCell4.minWidth.get(localActor);
          f54 = localCell4.minHeight.get(localActor);
          f55 = localCell4.maxWidth.get(localActor);
          f56 = localCell4.maxHeight.get(localActor);
          if (f51 >= f53)
            break label2182;
        }
        while (true)
        {
          if (f52 < f54);
          while (true)
          {
            if ((f55 > 0.0F) && (f53 > f55));
            while (true)
            {
              if ((f56 > 0.0F) && (f54 > f56));
              while (true)
              {
                localCell4.actorWidth = Math.min(f49 - localCell4.computedPadLeft - localCell4.computedPadRight, f55);
                localCell4.actorHeight = Math.min(f50 - localCell4.computedPadTop - localCell4.computedPadBottom, f56);
                if (i28 == 1)
                  arrayOfFloat3[i26] = Math.max(arrayOfFloat3[i26], f49);
                arrayOfFloat4[i27] = Math.max(arrayOfFloat4[i27], f50);
                i3++;
                break;
                if (f5 > 0.0F)
                {
                  float f44 = paramFloat3 - f2;
                  int i23 = 0;
                  float f45 = f44;
                  while (i23 < j)
                  {
                    float f48 = f45 - arrayOfFloat3[i23];
                    i23++;
                    f45 = f48;
                  }
                  float f46 = 0.0F;
                  int i24 = 0;
                  for (int i25 = 0; i25 < j; i25++)
                  {
                    if (arrayOfFloat1[i25] == 0.0F)
                      continue;
                    float f47 = f45 * arrayOfFloat1[i25] / f5;
                    arrayOfFloat3[i25] = (f47 + arrayOfFloat3[i25]);
                    f46 = f47 + f46;
                    i24 = i25;
                  }
                  arrayOfFloat3[i24] += f45 - f46;
                }
                if (f6 > 0.0F)
                {
                  float f39 = paramFloat4 - f4;
                  int i20 = 0;
                  float f40 = f39;
                  while (i20 < k)
                  {
                    float f43 = f40 - arrayOfFloat4[i20];
                    i20++;
                    f40 = f43;
                  }
                  float f41 = 0.0F;
                  int i21 = 0;
                  for (int i22 = 0; i22 < k; i22++)
                  {
                    if (arrayOfFloat2[i22] == 0.0F)
                      continue;
                    float f42 = f40 * arrayOfFloat2[i22] / f6;
                    arrayOfFloat4[i22] = (f42 + arrayOfFloat4[i22]);
                    f41 = f42 + f41;
                    i21 = i22;
                  }
                  arrayOfFloat4[i21] += f40 - f41;
                }
                for (int i4 = 0; i4 < i; i4++)
                {
                  Cell localCell3 = (Cell)localArray.get(i4);
                  int i15 = localCell3.colspan.intValue();
                  if (i15 == 1)
                    continue;
                  float f37 = 0.0F;
                  int i16 = localCell3.column;
                  int i17 = i16 + i15;
                  while (i16 < i17)
                  {
                    f37 += localObject1[i16] - arrayOfFloat3[i16];
                    i16++;
                  }
                  float f38 = (f37 - Math.max(0.0F, localCell3.computedPadLeft + localCell3.computedPadRight)) / i15;
                  if (f38 <= 0.0F)
                    continue;
                  int i18 = localCell3.column;
                  int i19 = i18 + i15;
                  while (i18 < i19)
                  {
                    arrayOfFloat3[i18] = (f38 + arrayOfFloat3[i18]);
                    i18++;
                  }
                }
                int i5 = 0;
                float f11 = f2;
                while (i5 < j)
                {
                  float f36 = f11 + arrayOfFloat3[i5];
                  i5++;
                  f11 = f36;
                }
                int i6 = 0;
                float f12 = f4;
                while (i6 < k)
                {
                  float f35 = f12 + arrayOfFloat4[i6];
                  i6++;
                  f12 = f35;
                }
                int i7 = this.align;
                float f13 = paramFloat1 + f1;
                float f14;
                float f15;
                if ((i7 & 0x10) != 0)
                {
                  f13 += paramFloat3 - f11;
                  f14 = paramFloat2 + f3;
                  if ((i7 & 0x4) == 0)
                    break label1360;
                  f15 = f14 + (paramFloat4 - f12);
                }
                while (true)
                {
                  label1262: int i8 = 0;
                  float f16 = f13;
                  float f17 = f15;
                  if (i8 < i)
                  {
                    Cell localCell2 = (Cell)localArray.get(i8);
                    float f27 = 0.0F;
                    int i12 = localCell2.column;
                    int i13 = i12 + localCell2.colspan.intValue();
                    while (true)
                      if (i12 < i13)
                      {
                        f27 += arrayOfFloat3[i12];
                        i12++;
                        continue;
                        if ((i7 & 0x8) != 0)
                          break;
                        f13 += (paramFloat3 - f11) / 2.0F;
                        break;
                        label1360: if ((i7 & 0x2) != 0)
                          break label2154;
                        f15 = f14 + (paramFloat4 - f12) / 2.0F;
                        break label1262;
                      }
                    float f28 = f27 - (localCell2.computedPadLeft + localCell2.computedPadRight);
                    float f29 = f16 + localCell2.computedPadLeft;
                    float f30 = localCell2.fillX.floatValue();
                    float f31 = localCell2.fillY.floatValue();
                    if (f30 > 0.0F)
                    {
                      localCell2.actorWidth = Math.max(f30 * f28, localCell2.minWidth.get(localCell2.actor));
                      float f34 = localCell2.maxWidth.get(localCell2.actor);
                      if (f34 > 0.0F)
                        localCell2.actorWidth = Math.min(localCell2.actorWidth, f34);
                    }
                    if (f31 > 0.0F)
                    {
                      localCell2.actorHeight = Math.max(f31 * arrayOfFloat4[localCell2.row] - localCell2.computedPadTop - localCell2.computedPadBottom, localCell2.minHeight.get(localCell2.actor));
                      float f33 = localCell2.maxHeight.get(localCell2.actor);
                      if (f33 > 0.0F)
                        localCell2.actorHeight = Math.min(localCell2.actorHeight, f33);
                    }
                    int i14 = localCell2.align.intValue();
                    label1611: label1631: float f32;
                    if ((i14 & 0x8) != 0)
                    {
                      localCell2.actorX = f29;
                      if ((i14 & 0x2) == 0)
                        break label1714;
                      localCell2.actorY = (f17 + localCell2.computedPadTop);
                      if (!localCell2.endRow)
                        break label1791;
                      f17 += arrayOfFloat4[localCell2.row];
                      f32 = f13;
                    }
                    while (true)
                    {
                      i8++;
                      f16 = f32;
                      break;
                      if ((i14 & 0x10) != 0)
                      {
                        localCell2.actorX = (f29 + f28 - localCell2.actorWidth);
                        break label1611;
                      }
                      localCell2.actorX = (f29 + (f28 - localCell2.actorWidth) / 2.0F);
                      break label1611;
                      label1714: if ((i14 & 0x4) != 0)
                      {
                        localCell2.actorY = (f17 + arrayOfFloat4[localCell2.row] - localCell2.actorHeight - localCell2.computedPadBottom);
                        break label1631;
                      }
                      localCell2.actorY = (f17 + (arrayOfFloat4[localCell2.row] - localCell2.actorHeight + localCell2.computedPadTop - localCell2.computedPadBottom) / 2.0F);
                      break label1631;
                      label1791: f32 = f29 + (f28 + localCell2.computedPadRight);
                    }
                  }
                  if (this.debug == Table.Debug.none)
                    return;
                  clearDebugRects();
                  if ((this.debug == Table.Debug.table) || (this.debug == Table.Debug.all))
                  {
                    addDebugRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, debugTableColor);
                    float f18 = f11 - f2;
                    float f19 = f12 - f4;
                    Color localColor = debugTableColor;
                    addDebugRect(f13, f15, f18, f19, localColor);
                  }
                  int i9 = 0;
                  float f20 = f13;
                  float f21 = f15;
                  label1898: Cell localCell1;
                  float f23;
                  float f24;
                  float f26;
                  float f25;
                  if (i9 < i)
                  {
                    localCell1 = (Cell)localArray.get(i9);
                    if ((this.debug == Table.Debug.actor) || (this.debug == Table.Debug.all))
                      addDebugRect(localCell1.actorX, localCell1.actorY, localCell1.actorWidth, localCell1.actorHeight, debugActorColor);
                    float f22 = 0.0F;
                    int i10 = localCell1.column;
                    int i11 = i10 + localCell1.colspan.intValue();
                    while (i10 < i11)
                    {
                      f22 += arrayOfFloat3[i10];
                      i10++;
                    }
                    f23 = f22 - (localCell1.computedPadLeft + localCell1.computedPadRight);
                    f24 = f20 + localCell1.computedPadLeft;
                    if ((this.debug == Table.Debug.cell) || (this.debug == Table.Debug.all))
                      addDebugRect(f24, f21 + localCell1.computedPadTop, f23, arrayOfFloat4[localCell1.row] - localCell1.computedPadTop - localCell1.computedPadBottom, debugCellColor);
                    if (!localCell1.endRow)
                      break label2134;
                    f26 = f21 + arrayOfFloat4[localCell1.row];
                    f25 = f13;
                  }
                  while (true)
                  {
                    i9++;
                    f20 = f25;
                    f21 = f26;
                    break label1898;
                    break;
                    label2134: f25 = f24 + (f23 + localCell1.computedPadRight);
                    f26 = f21;
                  }
                  label2154: f15 = f14;
                }
                f56 = f54;
              }
              f55 = f53;
            }
            f54 = f52;
          }
          label2182: f53 = f51;
        }
      }
    }
  }

  private Cell obtainCell()
  {
    Cell localCell = (Cell)cellPool.obtain();
    localCell.setLayout(this);
    return localCell;
  }

  public Cell add()
  {
    return add(null);
  }

  public Cell add(Actor paramActor)
  {
    Cell localCell1 = obtainCell();
    localCell1.actor = paramActor;
    if (this.implicitEndRow)
    {
      this.implicitEndRow = false;
      this.rows = (-1 + this.rows);
      ((Cell)this.cells.peek()).endRow = false;
    }
    Array localArray = this.cells;
    int i = localArray.size;
    Cell localCell3;
    int j;
    label119: int n;
    if (i > 0)
    {
      localCell3 = (Cell)localArray.peek();
      if (!localCell3.endRow)
      {
        localCell3.column += localCell3.colspan.intValue();
        localCell1.row = localCell3.row;
        if (localCell1.row > 0)
        {
          j = i - 1;
          if (j >= 0)
          {
            Cell localCell4 = (Cell)localArray.get(j);
            int k = localCell4.column;
            int m = k + localCell4.colspan.intValue();
            n = k;
            label159: if (n >= m)
              break label279;
            if (n != localCell1.column)
              break label273;
            localCell1.cellAboveIndex = j;
          }
        }
      }
    }
    while (true)
    {
      localArray.add(localCell1);
      localCell1.set(this.cellDefaults);
      if (localCell1.column < this.columnDefaults.size)
      {
        Cell localCell2 = (Cell)this.columnDefaults.get(localCell1.column);
        if (localCell2 != null)
          localCell1.merge(localCell2);
      }
      localCell1.merge(this.rowDefaults);
      if (paramActor != null)
        addActor(paramActor);
      return localCell1;
      localCell1.column = 0;
      localCell1.row = (1 + localCell3.row);
      break;
      label273: n++;
      break label159;
      label279: j--;
      break label119;
      localCell1.column = 0;
      localCell1.row = 0;
    }
  }

  public Cell add(CharSequence paramCharSequence)
  {
    if (this.skin == null)
      throw new IllegalStateException("Table must have a skin set to use this method.");
    return add(new Label(paramCharSequence, this.skin));
  }

  public Cell add(CharSequence paramCharSequence, String paramString)
  {
    if (this.skin == null)
      throw new IllegalStateException("Table must have a skin set to use this method.");
    return add(new Label(paramCharSequence, (Label.LabelStyle)this.skin.get(paramString, Label.LabelStyle.class)));
  }

  public Cell add(CharSequence paramCharSequence, String paramString, Color paramColor)
  {
    if (this.skin == null)
      throw new IllegalStateException("Table must have a skin set to use this method.");
    return add(new Label(paramCharSequence, new Label.LabelStyle(this.skin.getFont(paramString), paramColor)));
  }

  public Cell add(CharSequence paramCharSequence, String paramString1, String paramString2)
  {
    if (this.skin == null)
      throw new IllegalStateException("Table must have a skin set to use this method.");
    return add(new Label(paramCharSequence, new Label.LabelStyle(this.skin.getFont(paramString1), this.skin.getColor(paramString2))));
  }

  public void add(Actor[] paramArrayOfActor)
  {
    int i = 0;
    int j = paramArrayOfActor.length;
    while (i < j)
    {
      add(paramArrayOfActor[i]);
      i++;
    }
  }

  public Table align(int paramInt)
  {
    this.align = paramInt;
    return this;
  }

  public Table background(Drawable paramDrawable)
  {
    setBackground(paramDrawable);
    return this;
  }

  public Table background(String paramString)
  {
    setBackground(paramString);
    return this;
  }

  public Table bottom()
  {
    this.align = (0x4 | this.align);
    this.align = (0xFFFFFFFD & this.align);
    return this;
  }

  public Table center()
  {
    this.align = 1;
    return this;
  }

  public void clearChildren()
  {
    Array localArray = this.cells;
    for (int i = -1 + localArray.size; i >= 0; i--)
    {
      Actor localActor = ((Cell)localArray.get(i)).actor;
      if (localActor == null)
        continue;
      localActor.remove();
    }
    cellPool.freeAll(localArray);
    localArray.clear();
    this.rows = 0;
    this.columns = 0;
    if (this.rowDefaults != null)
      cellPool.free(this.rowDefaults);
    this.rowDefaults = null;
    this.implicitEndRow = false;
    super.clearChildren();
  }

  public Cell columnDefaults(int paramInt)
  {
    Cell localCell;
    if (this.columnDefaults.size > paramInt)
      localCell = (Cell)this.columnDefaults.get(paramInt);
    while (localCell == null)
    {
      localCell = obtainCell();
      localCell.clear();
      if (paramInt < this.columnDefaults.size)
        break label89;
      int i = this.columnDefaults.size;
      while (true)
        if (i < paramInt)
        {
          this.columnDefaults.add(null);
          i++;
          continue;
          localCell = null;
          break;
        }
      this.columnDefaults.add(localCell);
    }
    return localCell;
    label89: this.columnDefaults.set(paramInt, localCell);
    return localCell;
  }

  public Table debug()
  {
    super.debug();
    return this;
  }

  public Table debug(Table.Debug paramDebug)
  {
    if (paramDebug != Table.Debug.none);
    for (boolean bool = true; ; bool = false)
    {
      super.setDebug(bool);
      if (this.debug != paramDebug)
      {
        this.debug = paramDebug;
        if (paramDebug != Table.Debug.none)
          break;
        clearDebugRects();
      }
      return this;
    }
    invalidate();
    return this;
  }

  public Table debugActor()
  {
    super.setDebug(true);
    if (this.debug != Table.Debug.actor)
    {
      this.debug = Table.Debug.actor;
      invalidate();
    }
    return this;
  }

  public Table debugAll()
  {
    super.debugAll();
    return this;
  }

  public Table debugCell()
  {
    super.setDebug(true);
    if (this.debug != Table.Debug.cell)
    {
      this.debug = Table.Debug.cell;
      invalidate();
    }
    return this;
  }

  public Table debugTable()
  {
    super.setDebug(true);
    if (this.debug != Table.Debug.table)
    {
      this.debug = Table.Debug.table;
      invalidate();
    }
    return this;
  }

  public Cell defaults()
  {
    return this.cellDefaults;
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    if (isTransform())
    {
      applyTransform(paramBatch, computeTransform());
      drawBackground(paramBatch, paramFloat, 0.0F, 0.0F);
      if (this.clip)
      {
        paramBatch.flush();
        float f1 = this.padLeft.get(this);
        float f2 = this.padBottom.get(this);
        if (clipBegin(f1, f2, getWidth() - f1 - this.padRight.get(this), getHeight() - f2 - this.padTop.get(this)))
        {
          drawChildren(paramBatch, paramFloat);
          paramBatch.flush();
          clipEnd();
        }
      }
      while (true)
      {
        resetTransform(paramBatch);
        return;
        drawChildren(paramBatch, paramFloat);
      }
    }
    drawBackground(paramBatch, paramFloat, getX(), getY());
    super.draw(paramBatch, paramFloat);
  }

  protected void drawBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.background == null)
      return;
    Color localColor = getColor();
    paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat1 * localColor.a);
    this.background.draw(paramBatch, paramFloat2, paramFloat3, getWidth(), getHeight());
  }

  public void drawDebug(ShapeRenderer paramShapeRenderer)
  {
    float f1;
    float f2;
    float f4;
    float f3;
    if (isTransform())
    {
      applyTransform(paramShapeRenderer, computeTransform());
      drawDebugRects(paramShapeRenderer);
      if (this.clip)
      {
        paramShapeRenderer.flush();
        f1 = getWidth();
        f2 = getHeight();
        if (this.background == null)
          break label144;
        f4 = this.padLeft.get(this);
        f3 = this.padBottom.get(this);
        f1 -= f4 + this.padRight.get(this);
        f2 -= f3 + this.padTop.get(this);
      }
    }
    while (true)
    {
      if (clipBegin(f4, f3, f1, f2))
      {
        drawDebugChildren(paramShapeRenderer);
        clipEnd();
      }
      while (true)
      {
        resetTransform(paramShapeRenderer);
        return;
        drawDebugChildren(paramShapeRenderer);
      }
      drawDebugRects(paramShapeRenderer);
      super.drawDebug(paramShapeRenderer);
      return;
      label144: f3 = 0.0F;
      f4 = 0.0F;
    }
  }

  protected void drawDebugBounds(ShapeRenderer paramShapeRenderer)
  {
  }

  public int getAlign()
  {
    return this.align;
  }

  public Drawable getBackground()
  {
    return this.background;
  }

  public Cell getCell(Actor paramActor)
  {
    Array localArray = this.cells;
    int i = localArray.size;
    for (int j = 0; j < i; j++)
    {
      Cell localCell = (Cell)localArray.get(j);
      if (localCell.actor == paramActor)
        return localCell;
    }
    return null;
  }

  public Array getCells()
  {
    return this.cells;
  }

  public boolean getClip()
  {
    return this.clip;
  }

  public float getColumnWidth(int paramInt)
  {
    return this.columnWidth[paramInt];
  }

  public int getColumns()
  {
    return this.columns;
  }

  public float getMinHeight()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.tableMinHeight;
  }

  public float getMinWidth()
  {
    if (this.sizeInvalid)
      computeSize();
    return this.tableMinWidth;
  }

  public float getPadBottom()
  {
    return this.padBottom.get(this);
  }

  public Value getPadBottomValue()
  {
    return this.padBottom;
  }

  public float getPadLeft()
  {
    return this.padLeft.get(this);
  }

  public Value getPadLeftValue()
  {
    return this.padLeft;
  }

  public float getPadRight()
  {
    return this.padRight.get(this);
  }

  public Value getPadRightValue()
  {
    return this.padRight;
  }

  public float getPadTop()
  {
    return this.padTop.get(this);
  }

  public Value getPadTopValue()
  {
    return this.padTop;
  }

  public float getPadX()
  {
    return this.padLeft.get(this) + this.padRight.get(this);
  }

  public float getPadY()
  {
    return this.padTop.get(this) + this.padBottom.get(this);
  }

  public float getPrefHeight()
  {
    if (this.sizeInvalid)
      computeSize();
    float f = this.tablePrefHeight;
    if (this.background != null)
      f = Math.max(f, this.background.getMinHeight());
    return f;
  }

  public float getPrefWidth()
  {
    if (this.sizeInvalid)
      computeSize();
    float f = this.tablePrefWidth;
    if (this.background != null)
      f = Math.max(f, this.background.getMinWidth());
    return f;
  }

  public int getRow(float paramFloat)
  {
    Array localArray = this.cells;
    float f = paramFloat + getPadTop();
    int i = localArray.size;
    int j;
    if (i == 0)
      j = -1;
    int k;
    label41: int m;
    while (true)
    {
      return j;
      j = 0;
      if (i == 1)
        continue;
      k = 0;
      if (k >= i)
        break;
      m = k + 1;
      Cell localCell = (Cell)localArray.get(k);
      if (localCell.actorY + localCell.computedPadTop < f)
        continue;
      if (!localCell.endRow)
        break label106;
    }
    label106: for (int n = j + 1; ; n = j)
    {
      j = n;
      k = m;
      break label41;
      break;
    }
  }

  public float getRowHeight(int paramInt)
  {
    return this.rowHeight[paramInt];
  }

  public int getRows()
  {
    return this.rows;
  }

  public Skin getSkin()
  {
    return this.skin;
  }

  public Table.Debug getTableDebug()
  {
    return this.debug;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.clip)
    {
      if ((paramBoolean) && (getTouchable() == Touchable.disabled));
      do
        return null;
      while ((paramFloat1 < 0.0F) || (paramFloat1 >= getWidth()) || (paramFloat2 < 0.0F) || (paramFloat2 >= getHeight()));
    }
    return super.hit(paramFloat1, paramFloat2, paramBoolean);
  }

  public void invalidate()
  {
    this.sizeInvalid = true;
    super.invalidate();
  }

  public void layout()
  {
    int i = 0;
    float f1 = getWidth();
    float f2 = getHeight();
    layout(0.0F, 0.0F, f1, f2);
    Array localArray = this.cells;
    if (this.round)
    {
      int n = localArray.size;
      for (int i1 = 0; i1 < n; i1++)
      {
        Cell localCell2 = (Cell)localArray.get(i1);
        float f5 = Math.round(localCell2.actorWidth);
        float f6 = Math.round(localCell2.actorHeight);
        float f7 = Math.round(localCell2.actorX);
        float f8 = f2 - Math.round(localCell2.actorY) - f6;
        localCell2.setActorBounds(f7, f8, f5, f6);
        Actor localActor3 = localCell2.actor;
        if (localActor3 == null)
          continue;
        localActor3.setBounds(f7, f8, f5, f6);
      }
    }
    int j = localArray.size;
    for (int k = 0; k < j; k++)
    {
      Cell localCell1 = (Cell)localArray.get(k);
      float f3 = localCell1.actorHeight;
      float f4 = f2 - localCell1.actorY - f3;
      localCell1.setActorY(f4);
      Actor localActor2 = localCell1.actor;
      if (localActor2 == null)
        continue;
      localActor2.setBounds(localCell1.actorX, f4, localCell1.actorWidth, f3);
    }
    SnapshotArray localSnapshotArray = getChildren();
    int m = localSnapshotArray.size;
    while (i < m)
    {
      Actor localActor1 = (Actor)localSnapshotArray.get(i);
      if ((localActor1 instanceof Layout))
        ((Layout)localActor1).validate();
      i++;
    }
  }

  public Table left()
  {
    this.align = (0x8 | this.align);
    this.align = (0xFFFFFFEF & this.align);
    return this;
  }

  public Table pad(float paramFloat)
  {
    pad(new Value.Fixed(paramFloat));
    return this;
  }

  public Table pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.padTop = new Value.Fixed(paramFloat1);
    this.padLeft = new Value.Fixed(paramFloat2);
    this.padBottom = new Value.Fixed(paramFloat3);
    this.padRight = new Value.Fixed(paramFloat4);
    this.sizeInvalid = true;
    return this;
  }

  public Table pad(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("pad cannot be null.");
    this.padTop = paramValue;
    this.padLeft = paramValue;
    this.padBottom = paramValue;
    this.padRight = paramValue;
    this.sizeInvalid = true;
    return this;
  }

  public Table pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("top cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("left cannot be null.");
    if (paramValue3 == null)
      throw new IllegalArgumentException("bottom cannot be null.");
    if (paramValue4 == null)
      throw new IllegalArgumentException("right cannot be null.");
    this.padTop = paramValue1;
    this.padLeft = paramValue2;
    this.padBottom = paramValue3;
    this.padRight = paramValue4;
    this.sizeInvalid = true;
    return this;
  }

  public Table padBottom(float paramFloat)
  {
    this.padBottom = new Value.Fixed(paramFloat);
    this.sizeInvalid = true;
    return this;
  }

  public Table padBottom(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padBottom cannot be null.");
    this.padBottom = paramValue;
    this.sizeInvalid = true;
    return this;
  }

  public Table padLeft(float paramFloat)
  {
    this.padLeft = new Value.Fixed(paramFloat);
    this.sizeInvalid = true;
    return this;
  }

  public Table padLeft(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padLeft cannot be null.");
    this.padLeft = paramValue;
    this.sizeInvalid = true;
    return this;
  }

  public Table padRight(float paramFloat)
  {
    this.padRight = new Value.Fixed(paramFloat);
    this.sizeInvalid = true;
    return this;
  }

  public Table padRight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padRight cannot be null.");
    this.padRight = paramValue;
    this.sizeInvalid = true;
    return this;
  }

  public Table padTop(float paramFloat)
  {
    this.padTop = new Value.Fixed(paramFloat);
    this.sizeInvalid = true;
    return this;
  }

  public Table padTop(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padTop cannot be null.");
    this.padTop = paramValue;
    this.sizeInvalid = true;
    return this;
  }

  public boolean removeActor(Actor paramActor)
  {
    return removeActor(paramActor, true);
  }

  public boolean removeActor(Actor paramActor, boolean paramBoolean)
  {
    if (!super.removeActor(paramActor, paramBoolean))
      return false;
    Cell localCell = getCell(paramActor);
    if (localCell != null)
      localCell.actor = null;
    return true;
  }

  public void reset()
  {
    clear();
    this.padTop = backgroundTop;
    this.padLeft = backgroundLeft;
    this.padBottom = backgroundBottom;
    this.padRight = backgroundRight;
    this.align = 1;
    debug(Table.Debug.none);
    this.cellDefaults.reset();
    int i = this.columnDefaults.size;
    for (int j = 0; j < i; j++)
    {
      Cell localCell = (Cell)this.columnDefaults.get(j);
      if (localCell == null)
        continue;
      cellPool.free(localCell);
    }
    this.columnDefaults.clear();
  }

  public Table right()
  {
    this.align = (0x10 | this.align);
    this.align = (0xFFFFFFF7 & this.align);
    return this;
  }

  public Cell row()
  {
    if (this.cells.size > 0)
    {
      endRow();
      invalidate();
    }
    if (this.rowDefaults != null)
      cellPool.free(this.rowDefaults);
    this.rowDefaults = obtainCell();
    this.rowDefaults.clear();
    return this.rowDefaults;
  }

  public void setBackground(Drawable paramDrawable)
  {
    if (this.background == paramDrawable);
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f8;
    do
    {
      return;
      f1 = getPadTop();
      f2 = getPadLeft();
      f3 = getPadBottom();
      f4 = getPadRight();
      this.background = paramDrawable;
      f5 = getPadTop();
      f6 = getPadLeft();
      f7 = getPadBottom();
      f8 = getPadRight();
      if ((f1 + f3 == f5 + f7) && (f2 + f4 == f6 + f8))
        continue;
      invalidateHierarchy();
      return;
    }
    while ((f1 == f5) && (f2 == f6) && (f3 == f7) && (f4 == f8));
    invalidate();
  }

  public void setBackground(String paramString)
  {
    if (this.skin == null)
      throw new IllegalStateException("Table must have a skin set to use this method.");
    setBackground(this.skin.getDrawable(paramString));
  }

  public void setClip(boolean paramBoolean)
  {
    this.clip = paramBoolean;
    setTransform(paramBoolean);
    invalidate();
  }

  public void setDebug(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Table.Debug localDebug = Table.Debug.all; ; localDebug = Table.Debug.none)
    {
      debug(localDebug);
      return;
    }
  }

  public void setRound(boolean paramBoolean)
  {
    this.round = paramBoolean;
  }

  public void setSkin(Skin paramSkin)
  {
    this.skin = paramSkin;
  }

  public Cell stack(Actor[] paramArrayOfActor)
  {
    Stack localStack = new Stack();
    if (paramArrayOfActor != null)
    {
      int i = 0;
      int j = paramArrayOfActor.length;
      while (i < j)
      {
        localStack.addActor(paramArrayOfActor[i]);
        i++;
      }
    }
    return add(localStack);
  }

  public Table top()
  {
    this.align = (0x2 | this.align);
    this.align = (0xFFFFFFFB & this.align);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Table
 * JD-Core Version:    0.6.0
 */