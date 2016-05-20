package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class List extends Widget
  implements Cullable
{
  private Rectangle cullingArea;
  private float itemHeight;
  private final Array items = new Array();
  private float prefHeight;
  private float prefWidth;
  final ArraySelection selection = new ArraySelection(this.items);
  private List.ListStyle style;
  private float textOffsetX;
  private float textOffsetY;

  public List(List.ListStyle paramListStyle)
  {
    this.selection.setActor(this);
    this.selection.setRequired(true);
    setStyle(paramListStyle);
    setSize(getPrefWidth(), getPrefHeight());
    addListener(new List.1(this));
  }

  public List(Skin paramSkin)
  {
    this((List.ListStyle)paramSkin.get(List.ListStyle.class));
  }

  public List(Skin paramSkin, String paramString)
  {
    this((List.ListStyle)paramSkin.get(paramString, List.ListStyle.class));
  }

  public void clearItems()
  {
    if (this.items.size == 0)
      return;
    this.items.clear();
    this.selection.clear();
    invalidateHierarchy();
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    validate();
    BitmapFont localBitmapFont = this.style.font;
    Drawable localDrawable1 = this.style.selection;
    Color localColor1 = this.style.fontColorSelected;
    Color localColor2 = this.style.fontColorUnselected;
    Color localColor3 = getColor();
    paramBatch.setColor(localColor3.r, localColor3.g, localColor3.b, paramFloat * localColor3.a);
    float f1 = getX();
    float f2 = getY();
    float f3 = getWidth();
    float f4 = getHeight();
    Drawable localDrawable2 = this.style.background;
    float f6;
    float f5;
    if (localDrawable2 != null)
    {
      localDrawable2.draw(paramBatch, f1, f2, f3, f4);
      float f9 = localDrawable2.getLeftWidth();
      f6 = f1 + f9;
      f4 -= localDrawable2.getTopHeight();
      f5 = f3 - (f9 + localDrawable2.getRightWidth());
    }
    while (true)
    {
      localBitmapFont.setColor(localColor2.r, localColor2.g, localColor2.b, paramFloat * localColor2.a);
      int i = 0;
      float f7 = f4;
      if (i < this.items.size)
      {
        if ((this.cullingArea == null) || ((f7 - this.itemHeight <= this.cullingArea.y + this.cullingArea.height) && (f7 >= this.cullingArea.y)))
        {
          Object localObject = this.items.get(i);
          boolean bool = this.selection.contains(localObject);
          if (bool)
          {
            localDrawable1.draw(paramBatch, f6, f2 + f7 - this.itemHeight, f5, this.itemHeight);
            localBitmapFont.setColor(localColor1.r, localColor1.g, localColor1.b, paramFloat * localColor1.a);
          }
          localBitmapFont.draw(paramBatch, toString(localObject), f6 + this.textOffsetX, f2 + f7 - this.textOffsetY);
          if (bool)
            localBitmapFont.setColor(localColor2.r, localColor2.g, localColor2.b, paramFloat * localColor2.a);
        }
        do
        {
          float f8 = f7 - this.itemHeight;
          i++;
          f7 = f8;
          break;
        }
        while (f7 >= this.cullingArea.y);
      }
      return;
      f5 = f3;
      f6 = f1;
    }
  }

  public float getItemHeight()
  {
    return this.itemHeight;
  }

  public Array getItems()
  {
    return this.items;
  }

  public float getPrefHeight()
  {
    validate();
    return this.prefHeight;
  }

  public float getPrefWidth()
  {
    validate();
    return this.prefWidth;
  }

  public Object getSelected()
  {
    return this.selection.first();
  }

  public int getSelectedIndex()
  {
    OrderedSet localOrderedSet = this.selection.items();
    if (localOrderedSet.size == 0)
      return -1;
    return this.items.indexOf(localOrderedSet.first(), false);
  }

  public ArraySelection getSelection()
  {
    return this.selection;
  }

  public List.ListStyle getStyle()
  {
    return this.style;
  }

  public void layout()
  {
    BitmapFont localBitmapFont = this.style.font;
    Drawable localDrawable1 = this.style.selection;
    this.itemHeight = (localBitmapFont.getCapHeight() - 2.0F * localBitmapFont.getDescent());
    this.itemHeight += localDrawable1.getTopHeight() + localDrawable1.getBottomHeight();
    this.textOffsetX = localDrawable1.getLeftWidth();
    this.textOffsetY = (localDrawable1.getTopHeight() - localBitmapFont.getDescent());
    this.prefWidth = 0.0F;
    Pool localPool = Pools.get(GlyphLayout.class);
    GlyphLayout localGlyphLayout = (GlyphLayout)localPool.obtain();
    for (int i = 0; i < this.items.size; i++)
    {
      localGlyphLayout.setText(localBitmapFont, toString(this.items.get(i)));
      this.prefWidth = Math.max(localGlyphLayout.width, this.prefWidth);
    }
    localPool.free(localGlyphLayout);
    this.prefWidth += localDrawable1.getLeftWidth() + localDrawable1.getRightWidth();
    this.prefHeight = (this.items.size * this.itemHeight);
    Drawable localDrawable2 = this.style.background;
    if (localDrawable2 != null)
    {
      this.prefWidth += localDrawable2.getLeftWidth() + localDrawable2.getRightWidth();
      this.prefHeight += localDrawable2.getTopHeight() + localDrawable2.getBottomHeight();
    }
  }

  public void setCullingArea(Rectangle paramRectangle)
  {
    this.cullingArea = paramRectangle;
  }

  public void setItems(Array paramArray)
  {
    if (paramArray == null)
      throw new IllegalArgumentException("newItems cannot be null.");
    float f1 = getPrefWidth();
    float f2 = getPrefHeight();
    this.items.clear();
    this.items.addAll(paramArray);
    this.selection.validate();
    invalidate();
    if ((f1 != getPrefWidth()) || (f2 != getPrefHeight()))
      invalidateHierarchy();
  }

  public void setItems(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      throw new IllegalArgumentException("newItems cannot be null.");
    float f1 = getPrefWidth();
    float f2 = getPrefHeight();
    this.items.clear();
    this.items.addAll(paramArrayOfObject);
    this.selection.validate();
    invalidate();
    if ((f1 != getPrefWidth()) || (f2 != getPrefHeight()))
      invalidateHierarchy();
  }

  public void setSelected(Object paramObject)
  {
    if (this.items.contains(paramObject, false))
    {
      this.selection.set(paramObject);
      return;
    }
    if ((this.selection.getRequired()) && (this.items.size > 0))
    {
      this.selection.set(this.items.first());
      return;
    }
    this.selection.clear();
  }

  public void setSelectedIndex(int paramInt)
  {
    if ((paramInt < -1) || (paramInt >= this.items.size))
      throw new IllegalArgumentException("index must be >= -1 and < " + this.items.size + ": " + paramInt);
    if (paramInt == -1)
    {
      this.selection.clear();
      return;
    }
    this.selection.set(this.items.get(paramInt));
  }

  public void setStyle(List.ListStyle paramListStyle)
  {
    if (paramListStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramListStyle;
    invalidateHierarchy();
  }

  protected String toString(Object paramObject)
  {
    return paramObject.toString();
  }

  void touchDown(float paramFloat)
  {
    if (this.items.size == 0)
      return;
    float f = getHeight();
    if (this.style.background != null)
    {
      f -= this.style.background.getTopHeight() + this.style.background.getBottomHeight();
      paramFloat -= this.style.background.getBottomHeight();
    }
    int i = Math.max(0, (int)((f - paramFloat) / this.itemHeight));
    int j = Math.min(-1 + this.items.size, i);
    this.selection.choose(this.items.get(j));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.List
 * JD-Core Version:    0.6.0
 */