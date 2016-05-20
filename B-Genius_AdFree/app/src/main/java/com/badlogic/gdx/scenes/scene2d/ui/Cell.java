package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Pool.Poolable;

public class Cell
  implements Pool.Poolable
{
  private static Application app;
  private static final Integer bottomi;
  private static final Integer centeri;
  private static Cell defaults;
  private static final Integer lefti;
  private static final Float onef;
  private static final Integer onei;
  private static final Integer righti;
  private static final Integer topi;
  private static final Float zerof = Float.valueOf(0.0F);
  private static final Integer zeroi;
  Actor actor;
  float actorHeight;
  float actorWidth;
  float actorX;
  float actorY;
  Integer align;
  int cellAboveIndex;
  Integer colspan;
  int column;
  float computedPadBottom;
  float computedPadLeft;
  float computedPadRight;
  float computedPadTop;
  boolean endRow;
  Integer expandX;
  Integer expandY;
  Float fillX;
  Float fillY;
  Value maxHeight;
  Value maxWidth;
  Value minHeight;
  Value minWidth;
  Value padBottom;
  Value padLeft;
  Value padRight;
  Value padTop;
  Value prefHeight;
  Value prefWidth;
  int row;
  Value spaceBottom;
  Value spaceLeft;
  Value spaceRight;
  Value spaceTop;
  private Table table;
  Boolean uniformX;
  Boolean uniformY;

  static
  {
    onef = Float.valueOf(1.0F);
    zeroi = Integer.valueOf(0);
    Integer localInteger = Integer.valueOf(1);
    onei = localInteger;
    centeri = localInteger;
    topi = Integer.valueOf(2);
    bottomi = Integer.valueOf(4);
    lefti = Integer.valueOf(8);
    righti = Integer.valueOf(16);
  }

  public Cell()
  {
    reset();
  }

  public static Cell defaults()
  {
    if ((app == null) || (app != Gdx.app))
    {
      app = Gdx.app;
      Cell localCell = new Cell();
      defaults = localCell;
      localCell.minWidth = Value.minWidth;
      defaults.minHeight = Value.minHeight;
      defaults.prefWidth = Value.prefWidth;
      defaults.prefHeight = Value.prefHeight;
      defaults.maxWidth = Value.maxWidth;
      defaults.maxHeight = Value.maxHeight;
      defaults.spaceTop = Value.zero;
      defaults.spaceLeft = Value.zero;
      defaults.spaceBottom = Value.zero;
      defaults.spaceRight = Value.zero;
      defaults.padTop = Value.zero;
      defaults.padLeft = Value.zero;
      defaults.padBottom = Value.zero;
      defaults.padRight = Value.zero;
      defaults.fillX = zerof;
      defaults.fillY = zerof;
      defaults.align = centeri;
      defaults.expandX = zeroi;
      defaults.expandY = zeroi;
      defaults.colspan = onei;
      defaults.uniformX = null;
      defaults.uniformY = null;
    }
    return defaults;
  }

  public Cell align(int paramInt)
  {
    this.align = Integer.valueOf(paramInt);
    return this;
  }

  public Cell bottom()
  {
    if (this.align == null)
    {
      this.align = bottomi;
      return this;
    }
    this.align = Integer.valueOf(0xFFFFFFFD & (0x4 | this.align.intValue()));
    return this;
  }

  public Cell center()
  {
    this.align = centeri;
    return this;
  }

  void clear()
  {
    this.minWidth = null;
    this.minHeight = null;
    this.prefWidth = null;
    this.prefHeight = null;
    this.maxWidth = null;
    this.maxHeight = null;
    this.spaceTop = null;
    this.spaceLeft = null;
    this.spaceBottom = null;
    this.spaceRight = null;
    this.padTop = null;
    this.padLeft = null;
    this.padBottom = null;
    this.padRight = null;
    this.fillX = null;
    this.fillY = null;
    this.align = null;
    this.expandX = null;
    this.expandY = null;
    this.colspan = null;
    this.uniformX = null;
    this.uniformY = null;
  }

  public Cell clearActor()
  {
    setActor(null);
    return this;
  }

  public Cell colspan(int paramInt)
  {
    this.colspan = Integer.valueOf(paramInt);
    return this;
  }

  public Cell expand()
  {
    this.expandX = onei;
    this.expandY = onei;
    return this;
  }

  public Cell expand(int paramInt1, int paramInt2)
  {
    this.expandX = Integer.valueOf(paramInt1);
    this.expandY = Integer.valueOf(paramInt2);
    return this;
  }

  public Cell expand(boolean paramBoolean1, boolean paramBoolean2)
  {
    Integer localInteger1;
    if (paramBoolean1)
    {
      localInteger1 = onei;
      this.expandX = localInteger1;
      if (!paramBoolean2)
        break label37;
    }
    label37: for (Integer localInteger2 = onei; ; localInteger2 = zeroi)
    {
      this.expandY = localInteger2;
      return this;
      localInteger1 = zeroi;
      break;
    }
  }

  public Cell expandX()
  {
    this.expandX = onei;
    return this;
  }

  public Cell expandY()
  {
    this.expandY = onei;
    return this;
  }

  public Cell fill()
  {
    this.fillX = onef;
    this.fillY = onef;
    return this;
  }

  public Cell fill(float paramFloat1, float paramFloat2)
  {
    this.fillX = Float.valueOf(paramFloat1);
    this.fillY = Float.valueOf(paramFloat2);
    return this;
  }

  public Cell fill(boolean paramBoolean)
  {
    Float localFloat1;
    if (paramBoolean)
    {
      localFloat1 = onef;
      this.fillX = localFloat1;
      if (!paramBoolean)
        break label35;
    }
    label35: for (Float localFloat2 = onef; ; localFloat2 = zerof)
    {
      this.fillY = localFloat2;
      return this;
      localFloat1 = zerof;
      break;
    }
  }

  public Cell fill(boolean paramBoolean1, boolean paramBoolean2)
  {
    Float localFloat1;
    if (paramBoolean1)
    {
      localFloat1 = onef;
      this.fillX = localFloat1;
      if (!paramBoolean2)
        break label37;
    }
    label37: for (Float localFloat2 = onef; ; localFloat2 = zerof)
    {
      this.fillY = localFloat2;
      return this;
      localFloat1 = zerof;
      break;
    }
  }

  public Cell fillX()
  {
    this.fillX = onef;
    return this;
  }

  public Cell fillY()
  {
    this.fillY = onef;
    return this;
  }

  public Actor getActor()
  {
    return this.actor;
  }

  public float getActorHeight()
  {
    return this.actorHeight;
  }

  public float getActorWidth()
  {
    return this.actorWidth;
  }

  public float getActorX()
  {
    return this.actorX;
  }

  public float getActorY()
  {
    return this.actorY;
  }

  public int getAlign()
  {
    return this.align.intValue();
  }

  public int getColspan()
  {
    return this.colspan.intValue();
  }

  public int getColumn()
  {
    return this.column;
  }

  public float getComputedPadBottom()
  {
    return this.computedPadBottom;
  }

  public float getComputedPadLeft()
  {
    return this.computedPadLeft;
  }

  public float getComputedPadRight()
  {
    return this.computedPadRight;
  }

  public float getComputedPadTop()
  {
    return this.computedPadTop;
  }

  public int getExpandX()
  {
    return this.expandX.intValue();
  }

  public int getExpandY()
  {
    return this.expandY.intValue();
  }

  public float getFillX()
  {
    return this.fillX.floatValue();
  }

  public float getFillY()
  {
    return this.fillY.floatValue();
  }

  public float getMaxHeight()
  {
    return this.maxHeight.get(this.actor);
  }

  public Value getMaxHeightValue()
  {
    return this.maxHeight;
  }

  public float getMaxWidth()
  {
    return this.maxWidth.get(this.actor);
  }

  public Value getMaxWidthValue()
  {
    return this.maxWidth;
  }

  public float getMinHeight()
  {
    return this.minHeight.get(this.actor);
  }

  public Value getMinHeightValue()
  {
    return this.minHeight;
  }

  public float getMinWidth()
  {
    return this.minWidth.get(this.actor);
  }

  public Value getMinWidthValue()
  {
    return this.minWidth;
  }

  public float getPadBottom()
  {
    return this.padBottom.get(this.actor);
  }

  public Value getPadBottomValue()
  {
    return this.padBottom;
  }

  public float getPadLeft()
  {
    return this.padLeft.get(this.actor);
  }

  public Value getPadLeftValue()
  {
    return this.padLeft;
  }

  public float getPadRight()
  {
    return this.padRight.get(this.actor);
  }

  public Value getPadRightValue()
  {
    return this.padRight;
  }

  public float getPadTop()
  {
    return this.padTop.get(this.actor);
  }

  public Value getPadTopValue()
  {
    return this.padTop;
  }

  public float getPadX()
  {
    return this.padLeft.get(this.actor) + this.padRight.get(this.actor);
  }

  public float getPadY()
  {
    return this.padTop.get(this.actor) + this.padBottom.get(this.actor);
  }

  public float getPrefHeight()
  {
    return this.prefHeight.get(this.actor);
  }

  public Value getPrefHeightValue()
  {
    return this.prefHeight;
  }

  public float getPrefWidth()
  {
    return this.prefWidth.get(this.actor);
  }

  public Value getPrefWidthValue()
  {
    return this.prefWidth;
  }

  public int getRow()
  {
    return this.row;
  }

  public float getSpaceBottom()
  {
    return this.spaceBottom.get(this.actor);
  }

  public Value getSpaceBottomValue()
  {
    return this.spaceBottom;
  }

  public float getSpaceLeft()
  {
    return this.spaceLeft.get(this.actor);
  }

  public Value getSpaceLeftValue()
  {
    return this.spaceLeft;
  }

  public float getSpaceRight()
  {
    return this.spaceRight.get(this.actor);
  }

  public Value getSpaceRightValue()
  {
    return this.spaceRight;
  }

  public float getSpaceTop()
  {
    return this.spaceTop.get(this.actor);
  }

  public Value getSpaceTopValue()
  {
    return this.spaceTop;
  }

  public Table getTable()
  {
    return this.table;
  }

  public boolean getUniformX()
  {
    return this.uniformX.booleanValue();
  }

  public boolean getUniformY()
  {
    return this.uniformY.booleanValue();
  }

  public Cell grow()
  {
    this.expandX = onei;
    this.expandY = onei;
    this.fillX = onef;
    this.fillY = onef;
    return this;
  }

  public Cell growX()
  {
    this.expandX = onei;
    this.fillX = onef;
    return this;
  }

  public Cell growY()
  {
    this.expandY = onei;
    this.fillY = onef;
    return this;
  }

  public boolean hasActor()
  {
    return this.actor != null;
  }

  public Cell height(float paramFloat)
  {
    height(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell height(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minHeight = paramValue;
    this.prefHeight = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public boolean isEndRow()
  {
    return this.endRow;
  }

  public Cell left()
  {
    if (this.align == null)
    {
      this.align = lefti;
      return this;
    }
    this.align = Integer.valueOf(0xFFFFFFEF & (0x8 | this.align.intValue()));
    return this;
  }

  public Cell maxHeight(float paramFloat)
  {
    this.maxHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell maxHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("maxHeight cannot be null.");
    this.maxHeight = paramValue;
    return this;
  }

  public Cell maxSize(float paramFloat)
  {
    maxSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell maxSize(float paramFloat1, float paramFloat2)
  {
    maxSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Cell maxSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.maxWidth = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public Cell maxSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.maxWidth = paramValue1;
    this.maxHeight = paramValue2;
    return this;
  }

  public Cell maxWidth(float paramFloat)
  {
    this.maxWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell maxWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("maxWidth cannot be null.");
    this.maxWidth = paramValue;
    return this;
  }

  void merge(Cell paramCell)
  {
    if (paramCell == null);
    do
    {
      return;
      if (paramCell.minWidth != null)
        this.minWidth = paramCell.minWidth;
      if (paramCell.minHeight != null)
        this.minHeight = paramCell.minHeight;
      if (paramCell.prefWidth != null)
        this.prefWidth = paramCell.prefWidth;
      if (paramCell.prefHeight != null)
        this.prefHeight = paramCell.prefHeight;
      if (paramCell.maxWidth != null)
        this.maxWidth = paramCell.maxWidth;
      if (paramCell.maxHeight != null)
        this.maxHeight = paramCell.maxHeight;
      if (paramCell.spaceTop != null)
        this.spaceTop = paramCell.spaceTop;
      if (paramCell.spaceLeft != null)
        this.spaceLeft = paramCell.spaceLeft;
      if (paramCell.spaceBottom != null)
        this.spaceBottom = paramCell.spaceBottom;
      if (paramCell.spaceRight != null)
        this.spaceRight = paramCell.spaceRight;
      if (paramCell.padTop != null)
        this.padTop = paramCell.padTop;
      if (paramCell.padLeft != null)
        this.padLeft = paramCell.padLeft;
      if (paramCell.padBottom != null)
        this.padBottom = paramCell.padBottom;
      if (paramCell.padRight != null)
        this.padRight = paramCell.padRight;
      if (paramCell.fillX != null)
        this.fillX = paramCell.fillX;
      if (paramCell.fillY != null)
        this.fillY = paramCell.fillY;
      if (paramCell.align != null)
        this.align = paramCell.align;
      if (paramCell.expandX != null)
        this.expandX = paramCell.expandX;
      if (paramCell.expandY != null)
        this.expandY = paramCell.expandY;
      if (paramCell.colspan != null)
        this.colspan = paramCell.colspan;
      if (paramCell.uniformX == null)
        continue;
      this.uniformX = paramCell.uniformX;
    }
    while (paramCell.uniformY == null);
    this.uniformY = paramCell.uniformY;
  }

  public Cell minHeight(float paramFloat)
  {
    this.minHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell minHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("minHeight cannot be null.");
    this.minHeight = paramValue;
    return this;
  }

  public Cell minSize(float paramFloat)
  {
    minSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell minSize(float paramFloat1, float paramFloat2)
  {
    minSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Cell minSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.minWidth = paramValue;
    this.minHeight = paramValue;
    return this;
  }

  public Cell minSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minWidth = paramValue1;
    this.minHeight = paramValue2;
    return this;
  }

  public Cell minWidth(float paramFloat)
  {
    this.minWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell minWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("minWidth cannot be null.");
    this.minWidth = paramValue;
    return this;
  }

  public Cell pad(float paramFloat)
  {
    pad(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    pad(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2), new Value.Fixed(paramFloat3), new Value.Fixed(paramFloat4));
    return this;
  }

  public Cell pad(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("pad cannot be null.");
    this.padTop = paramValue;
    this.padLeft = paramValue;
    this.padBottom = paramValue;
    this.padRight = paramValue;
    return this;
  }

  public Cell pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4)
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
    return this;
  }

  public Cell padBottom(float paramFloat)
  {
    this.padBottom = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell padBottom(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padBottom cannot be null.");
    this.padBottom = paramValue;
    return this;
  }

  public Cell padLeft(float paramFloat)
  {
    this.padLeft = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell padLeft(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padLeft cannot be null.");
    this.padLeft = paramValue;
    return this;
  }

  public Cell padRight(float paramFloat)
  {
    this.padRight = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell padRight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padRight cannot be null.");
    this.padRight = paramValue;
    return this;
  }

  public Cell padTop(float paramFloat)
  {
    this.padTop = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell padTop(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("padTop cannot be null.");
    this.padTop = paramValue;
    return this;
  }

  public Cell prefHeight(float paramFloat)
  {
    this.prefHeight = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell prefHeight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("prefHeight cannot be null.");
    this.prefHeight = paramValue;
    return this;
  }

  public Cell prefSize(float paramFloat)
  {
    prefSize(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell prefSize(float paramFloat1, float paramFloat2)
  {
    prefSize(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Cell prefSize(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.prefWidth = paramValue;
    this.prefHeight = paramValue;
    return this;
  }

  public Cell prefSize(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.prefWidth = paramValue1;
    this.prefHeight = paramValue2;
    return this;
  }

  public Cell prefWidth(float paramFloat)
  {
    this.prefWidth = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell prefWidth(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("prefWidth cannot be null.");
    this.prefWidth = paramValue;
    return this;
  }

  public void reset()
  {
    this.actor = null;
    this.table = null;
    this.endRow = false;
    this.cellAboveIndex = -1;
    Cell localCell = defaults();
    if (localCell != null)
      set(localCell);
  }

  public Cell right()
  {
    if (this.align == null)
    {
      this.align = righti;
      return this;
    }
    this.align = Integer.valueOf(0xFFFFFFF7 & (0x10 | this.align.intValue()));
    return this;
  }

  public void row()
  {
    this.table.row();
  }

  void set(Cell paramCell)
  {
    this.minWidth = paramCell.minWidth;
    this.minHeight = paramCell.minHeight;
    this.prefWidth = paramCell.prefWidth;
    this.prefHeight = paramCell.prefHeight;
    this.maxWidth = paramCell.maxWidth;
    this.maxHeight = paramCell.maxHeight;
    this.spaceTop = paramCell.spaceTop;
    this.spaceLeft = paramCell.spaceLeft;
    this.spaceBottom = paramCell.spaceBottom;
    this.spaceRight = paramCell.spaceRight;
    this.padTop = paramCell.padTop;
    this.padLeft = paramCell.padLeft;
    this.padBottom = paramCell.padBottom;
    this.padRight = paramCell.padRight;
    this.fillX = paramCell.fillX;
    this.fillY = paramCell.fillY;
    this.align = paramCell.align;
    this.expandX = paramCell.expandX;
    this.expandY = paramCell.expandY;
    this.colspan = paramCell.colspan;
    this.uniformX = paramCell.uniformX;
    this.uniformY = paramCell.uniformY;
  }

  public Cell setActor(Actor paramActor)
  {
    if (this.actor != paramActor)
    {
      if (this.actor != null)
        this.actor.remove();
      this.actor = paramActor;
      if (paramActor != null)
        this.table.addActor(paramActor);
    }
    return this;
  }

  public void setActorBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.actorX = paramFloat1;
    this.actorY = paramFloat2;
    this.actorWidth = paramFloat3;
    this.actorHeight = paramFloat4;
  }

  public void setActorHeight(float paramFloat)
  {
    this.actorHeight = paramFloat;
  }

  public void setActorWidth(float paramFloat)
  {
    this.actorWidth = paramFloat;
  }

  public void setActorX(float paramFloat)
  {
    this.actorX = paramFloat;
  }

  public void setActorY(float paramFloat)
  {
    this.actorY = paramFloat;
  }

  public void setLayout(Table paramTable)
  {
    this.table = paramTable;
  }

  public Cell size(float paramFloat)
  {
    size(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell size(float paramFloat1, float paramFloat2)
  {
    size(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2));
    return this;
  }

  public Cell size(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("size cannot be null.");
    this.minWidth = paramValue;
    this.minHeight = paramValue;
    this.prefWidth = paramValue;
    this.prefHeight = paramValue;
    this.maxWidth = paramValue;
    this.maxHeight = paramValue;
    return this;
  }

  public Cell size(Value paramValue1, Value paramValue2)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("width cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("height cannot be null.");
    this.minWidth = paramValue1;
    this.minHeight = paramValue2;
    this.prefWidth = paramValue1;
    this.prefHeight = paramValue2;
    this.maxWidth = paramValue1;
    this.maxHeight = paramValue2;
    return this;
  }

  public Cell space(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("space cannot be < 0.");
    space(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell space(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < 0.0F)
      throw new IllegalArgumentException("top cannot be < 0.");
    if (paramFloat2 < 0.0F)
      throw new IllegalArgumentException("left cannot be < 0.");
    if (paramFloat3 < 0.0F)
      throw new IllegalArgumentException("bottom cannot be < 0.");
    if (paramFloat4 < 0.0F)
      throw new IllegalArgumentException("right cannot be < 0.");
    space(new Value.Fixed(paramFloat1), new Value.Fixed(paramFloat2), new Value.Fixed(paramFloat3), new Value.Fixed(paramFloat4));
    return this;
  }

  public Cell space(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("space cannot be null.");
    this.spaceTop = paramValue;
    this.spaceLeft = paramValue;
    this.spaceBottom = paramValue;
    this.spaceRight = paramValue;
    return this;
  }

  public Cell space(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4)
  {
    if (paramValue1 == null)
      throw new IllegalArgumentException("top cannot be null.");
    if (paramValue2 == null)
      throw new IllegalArgumentException("left cannot be null.");
    if (paramValue3 == null)
      throw new IllegalArgumentException("bottom cannot be null.");
    if (paramValue4 == null)
      throw new IllegalArgumentException("right cannot be null.");
    this.spaceTop = paramValue1;
    this.spaceLeft = paramValue2;
    this.spaceBottom = paramValue3;
    this.spaceRight = paramValue4;
    return this;
  }

  public Cell spaceBottom(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("spaceBottom cannot be < 0.");
    this.spaceBottom = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell spaceBottom(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("spaceBottom cannot be null.");
    this.spaceBottom = paramValue;
    return this;
  }

  public Cell spaceLeft(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("spaceLeft cannot be < 0.");
    this.spaceLeft = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell spaceLeft(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("spaceLeft cannot be null.");
    this.spaceLeft = paramValue;
    return this;
  }

  public Cell spaceRight(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("spaceRight cannot be < 0.");
    this.spaceRight = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell spaceRight(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("spaceRight cannot be null.");
    this.spaceRight = paramValue;
    return this;
  }

  public Cell spaceTop(float paramFloat)
  {
    if (paramFloat < 0.0F)
      throw new IllegalArgumentException("spaceTop cannot be < 0.");
    this.spaceTop = new Value.Fixed(paramFloat);
    return this;
  }

  public Cell spaceTop(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("spaceTop cannot be null.");
    this.spaceTop = paramValue;
    return this;
  }

  public String toString()
  {
    if (this.actor != null)
      return this.actor.toString();
    return super.toString();
  }

  public Cell top()
  {
    if (this.align == null)
    {
      this.align = topi;
      return this;
    }
    this.align = Integer.valueOf(0xFFFFFFFB & (0x2 | this.align.intValue()));
    return this;
  }

  public Cell uniform()
  {
    this.uniformX = Boolean.TRUE;
    this.uniformY = Boolean.TRUE;
    return this;
  }

  public Cell uniform(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uniformX = Boolean.valueOf(paramBoolean1);
    this.uniformY = Boolean.valueOf(paramBoolean2);
    return this;
  }

  public Cell uniformX()
  {
    this.uniformX = Boolean.TRUE;
    return this;
  }

  public Cell uniformY()
  {
    this.uniformY = Boolean.TRUE;
    return this;
  }

  public Cell width(float paramFloat)
  {
    width(new Value.Fixed(paramFloat));
    return this;
  }

  public Cell width(Value paramValue)
  {
    if (paramValue == null)
      throw new IllegalArgumentException("width cannot be null.");
    this.minWidth = paramValue;
    this.prefWidth = paramValue;
    this.maxWidth = paramValue;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Cell
 * JD-Core Version:    0.6.0
 */