package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

public class SelectBox extends Widget
  implements Disableable
{
  static final Vector2 temp = new Vector2();
  private ClickListener clickListener;
  boolean disabled;
  final Array items = new Array();
  private GlyphLayout layout = new GlyphLayout();
  private float prefHeight;
  private float prefWidth;
  SelectBox.SelectBoxList selectBoxList;
  final ArraySelection selection = new ArraySelection(this.items);
  SelectBox.SelectBoxStyle style;

  public SelectBox(SelectBox.SelectBoxStyle paramSelectBoxStyle)
  {
    setStyle(paramSelectBoxStyle);
    setSize(getPrefWidth(), getPrefHeight());
    this.selection.setActor(this);
    this.selection.setRequired(true);
    this.selectBoxList = new SelectBox.SelectBoxList(this);
    SelectBox.1 local1 = new SelectBox.1(this);
    this.clickListener = local1;
    addListener(local1);
  }

  public SelectBox(Skin paramSkin)
  {
    this((SelectBox.SelectBoxStyle)paramSkin.get(SelectBox.SelectBoxStyle.class));
  }

  public SelectBox(Skin paramSkin, String paramString)
  {
    this((SelectBox.SelectBoxStyle)paramSkin.get(paramString, SelectBox.SelectBoxStyle.class));
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
    Drawable localDrawable;
    BitmapFont localBitmapFont;
    Color localColor1;
    label64: float f1;
    float f2;
    float f3;
    float f4;
    String str;
    float f6;
    float f7;
    float f8;
    if ((this.disabled) && (this.style.backgroundDisabled != null))
    {
      localDrawable = this.style.backgroundDisabled;
      localBitmapFont = this.style.font;
      if ((!this.disabled) || (this.style.disabledFontColor == null))
        break label406;
      localColor1 = this.style.disabledFontColor;
      Color localColor2 = getColor();
      f1 = getX();
      f2 = getY();
      f3 = getWidth();
      f4 = getHeight();
      paramBatch.setColor(localColor2.r, localColor2.g, localColor2.b, paramFloat * localColor2.a);
      if (localDrawable != null)
        localDrawable.draw(paramBatch, f1, f2, f3, f4);
      Object localObject = this.selection.first();
      if (localObject != null)
      {
        str = toString(localObject);
        if (localDrawable == null)
          break label418;
        f6 = f3 - (localDrawable.getLeftWidth() + localDrawable.getRightWidth());
        float f9 = f4 - (localDrawable.getBottomHeight() + localDrawable.getTopHeight());
        float f10 = f1 + localDrawable.getLeftWidth();
        f7 = f2 + (int)(f9 / 2.0F + localDrawable.getBottomHeight() + localBitmapFont.getData().capHeight / 2.0F);
        f8 = f10;
      }
    }
    while (true)
    {
      localBitmapFont.setColor(localColor1.r, localColor1.g, localColor1.b, paramFloat * localColor1.a);
      this.layout.setText(localBitmapFont, str, 0, str.length(), localBitmapFont.getColor(), f6, 8, false, "...");
      localBitmapFont.draw(paramBatch, this.layout, f8, f7);
      return;
      if ((this.selectBoxList.hasParent()) && (this.style.backgroundOpen != null))
      {
        localDrawable = this.style.backgroundOpen;
        break;
      }
      if ((this.clickListener.isOver()) && (this.style.backgroundOver != null))
      {
        localDrawable = this.style.backgroundOver;
        break;
      }
      if (this.style.background != null)
      {
        localDrawable = this.style.background;
        break;
      }
      localDrawable = null;
      break;
      label406: localColor1 = this.style.fontColor;
      break label64;
      label418: float f5 = f2 + (int)(f4 / 2.0F + localBitmapFont.getData().capHeight / 2.0F);
      f6 = f3;
      f7 = f5;
      f8 = f1;
    }
  }

  public Array getItems()
  {
    return this.items;
  }

  public List getList()
  {
    return this.selectBoxList.list;
  }

  public int getMaxListCount()
  {
    return this.selectBoxList.maxListCount;
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

  public ScrollPane getScrollPane()
  {
    return this.selectBoxList;
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

  public SelectBox.SelectBoxStyle getStyle()
  {
    return this.style;
  }

  public void hideList()
  {
    this.selectBoxList.hide();
  }

  public boolean isDisabled()
  {
    return this.disabled;
  }

  public void layout()
  {
    Drawable localDrawable1 = this.style.background;
    BitmapFont localBitmapFont = this.style.font;
    if (localDrawable1 != null);
    Pool localPool;
    GlyphLayout localGlyphLayout;
    float f1;
    for (this.prefHeight = Math.max(localDrawable1.getTopHeight() + localDrawable1.getBottomHeight() + localBitmapFont.getCapHeight() - 2.0F * localBitmapFont.getDescent(), localDrawable1.getMinHeight()); ; this.prefHeight = (localBitmapFont.getCapHeight() - 2.0F * localBitmapFont.getDescent()))
    {
      localPool = Pools.get(GlyphLayout.class);
      localGlyphLayout = (GlyphLayout)localPool.obtain();
      int i = 0;
      f1 = 0.0F;
      while (i < this.items.size)
      {
        localGlyphLayout.setText(localBitmapFont, toString(this.items.get(i)));
        f1 = Math.max(localGlyphLayout.width, f1);
        i++;
      }
    }
    localPool.free(localGlyphLayout);
    this.prefWidth = f1;
    if (localDrawable1 != null)
      this.prefWidth += localDrawable1.getLeftWidth() + localDrawable1.getRightWidth();
    List.ListStyle localListStyle = this.style.listStyle;
    ScrollPane.ScrollPaneStyle localScrollPaneStyle = this.style.scrollStyle;
    float f2 = this.prefWidth;
    float f3;
    float f4;
    float f5;
    if (localScrollPaneStyle.background == null)
    {
      f3 = 0.0F;
      f4 = f3 + f1 + localListStyle.selection.getLeftWidth() + localListStyle.selection.getRightWidth();
      if (this.style.scrollStyle.vScroll == null)
        break label361;
      f5 = this.style.scrollStyle.vScroll.getMinWidth();
    }
    while (true)
    {
      Drawable localDrawable2 = this.style.scrollStyle.vScrollKnob;
      float f6 = 0.0F;
      if (localDrawable2 != null)
        f6 = this.style.scrollStyle.vScrollKnob.getMinWidth();
      this.prefWidth = Math.max(f2, f4 + Math.max(f5, f6));
      return;
      f3 = localScrollPaneStyle.background.getLeftWidth() + localScrollPaneStyle.background.getRightWidth();
      break;
      label361: f5 = 0.0F;
    }
  }

  protected void onHide(Actor paramActor)
  {
    paramActor.getColor().a = 1.0F;
    paramActor.addAction(Actions.sequence(Actions.fadeOut(0.15F, Interpolation.fade), Actions.removeActor()));
  }

  protected void onShow(Actor paramActor, boolean paramBoolean)
  {
    paramActor.getColor().a = 0.0F;
    paramActor.addAction(Actions.fadeIn(0.3F, Interpolation.fade));
  }

  public void setDisabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.disabled))
      hideList();
    this.disabled = paramBoolean;
  }

  public void setItems(Array paramArray)
  {
    if (paramArray == null)
      throw new IllegalArgumentException("newItems cannot be null.");
    float f = getPrefWidth();
    this.items.clear();
    this.items.addAll(paramArray);
    this.selection.validate();
    this.selectBoxList.list.setItems(this.items);
    invalidate();
    if (f != getPrefWidth())
      invalidateHierarchy();
  }

  public void setItems(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      throw new IllegalArgumentException("newItems cannot be null.");
    float f = getPrefWidth();
    this.items.clear();
    this.items.addAll(paramArrayOfObject);
    this.selection.validate();
    this.selectBoxList.list.setItems(this.items);
    invalidate();
    if (f != getPrefWidth())
      invalidateHierarchy();
  }

  public void setMaxListCount(int paramInt)
  {
    this.selectBoxList.maxListCount = paramInt;
  }

  public void setSelected(Object paramObject)
  {
    if (this.items.contains(paramObject, false))
    {
      this.selection.set(paramObject);
      return;
    }
    if (this.items.size > 0)
    {
      this.selection.set(this.items.first());
      return;
    }
    this.selection.clear();
  }

  public void setSelectedIndex(int paramInt)
  {
    this.selection.set(this.items.get(paramInt));
  }

  protected void setStage(Stage paramStage)
  {
    if (paramStage == null)
      this.selectBoxList.hide();
    super.setStage(paramStage);
  }

  public void setStyle(SelectBox.SelectBoxStyle paramSelectBoxStyle)
  {
    if (paramSelectBoxStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramSelectBoxStyle;
    invalidateHierarchy();
  }

  public void showList()
  {
    if (this.items.size == 0)
      return;
    this.selectBoxList.show(getStage());
  }

  protected String toString(Object paramObject)
  {
    return paramObject.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox
 * JD-Core Version:    0.6.0
 */