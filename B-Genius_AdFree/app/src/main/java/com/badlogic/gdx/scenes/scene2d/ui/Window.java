package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Window extends Table
{
  private static final int MOVE = 32;
  private static final Vector2 tmpPosition = new Vector2();
  private static final Vector2 tmpSize = new Vector2();
  boolean dragging;
  boolean drawTitleTable;
  boolean isModal;
  boolean isMovable = true;
  boolean isResizable;
  boolean keepWithinStage = true;
  int resizeBorder = 8;
  private Window.WindowStyle style;
  Label titleLabel;
  Table titleTable;

  public Window(String paramString, Skin paramSkin)
  {
    this(paramString, (Window.WindowStyle)paramSkin.get(Window.WindowStyle.class));
    setSkin(paramSkin);
  }

  public Window(String paramString1, Skin paramSkin, String paramString2)
  {
    this(paramString1, (Window.WindowStyle)paramSkin.get(paramString2, Window.WindowStyle.class));
    setSkin(paramSkin);
  }

  public Window(String paramString, Window.WindowStyle paramWindowStyle)
  {
    if (paramString == null)
      throw new IllegalArgumentException("title cannot be null.");
    setTouchable(Touchable.enabled);
    setClip(true);
    this.titleLabel = new Label(paramString, new Label.LabelStyle(paramWindowStyle.titleFont, paramWindowStyle.titleFontColor));
    this.titleLabel.setEllipsis(true);
    this.titleTable = new Window.1(this);
    this.titleTable.add(this.titleLabel).expandX().fillX().minWidth(0.0F);
    addActor(this.titleTable);
    setStyle(paramWindowStyle);
    setWidth(150.0F);
    setHeight(150.0F);
    addCaptureListener(new Window.2(this));
    addListener(new Window.3(this));
  }

  public void draw(Batch paramBatch, float paramFloat)
  {
    Stage localStage = getStage();
    if (localStage.getKeyboardFocus() == null)
      localStage.setKeyboardFocus(this);
    keepWithinStage();
    if (this.style.stageBackground != null)
    {
      stageToLocalCoordinates(tmpPosition.set(0.0F, 0.0F));
      stageToLocalCoordinates(tmpSize.set(localStage.getWidth(), localStage.getHeight()));
      drawStageBackground(paramBatch, paramFloat, getX() + tmpPosition.x, getY() + tmpPosition.y, getX() + tmpSize.x, getY() + tmpSize.y);
    }
    super.draw(paramBatch, paramFloat);
  }

  protected void drawBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super.drawBackground(paramBatch, paramFloat1, paramFloat2, paramFloat3);
    this.titleTable.getColor().a = getColor().a;
    float f1 = getPadTop();
    float f2 = getPadLeft();
    this.titleTable.setSize(getWidth() - f2 - getPadRight(), f1);
    this.titleTable.setPosition(f2, getHeight() - f1);
    this.drawTitleTable = true;
    this.titleTable.draw(paramBatch, paramFloat1);
    this.drawTitleTable = false;
  }

  protected void drawStageBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    Color localColor = getColor();
    paramBatch.setColor(localColor.r, localColor.g, localColor.b, paramFloat1 * localColor.a);
    this.style.stageBackground.draw(paramBatch, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
  }

  public float getPrefWidth()
  {
    return Math.max(super.getPrefWidth(), this.titleLabel.getPrefWidth() + getPadLeft() + getPadRight());
  }

  public Window.WindowStyle getStyle()
  {
    return this.style;
  }

  public Label getTitleLabel()
  {
    return this.titleLabel;
  }

  public Table getTitleTable()
  {
    return this.titleTable;
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    Actor localActor = super.hit(paramFloat1, paramFloat2, paramBoolean);
    if ((localActor == null) && (this.isModal) && ((!paramBoolean) || (getTouchable() == Touchable.enabled)));
    Object localObject;
    do
    {
      return this;
      float f = getHeight();
      if ((localActor == null) || (localActor == this))
        return localActor;
      if ((paramFloat2 > f) || (paramFloat2 < f - getPadTop()) || (paramFloat1 < 0.0F) || (paramFloat1 > getWidth()))
        break;
      for (localObject = localActor; ((Actor)localObject).getParent() != this; localObject = ((Actor)localObject).getParent());
    }
    while (getCell((Actor)localObject) != null);
    return (Actor)localActor;
  }

  public boolean isDragging()
  {
    return this.dragging;
  }

  public boolean isModal()
  {
    return this.isModal;
  }

  public boolean isMovable()
  {
    return this.isMovable;
  }

  public boolean isResizable()
  {
    return this.isResizable;
  }

  void keepWithinStage()
  {
    if (!this.keepWithinStage);
    float f2;
    do
    {
      Stage localStage;
      do
        while (true)
        {
          return;
          localStage = getStage();
          Camera localCamera = localStage.getCamera();
          if (!(localCamera instanceof OrthographicCamera))
            break;
          OrthographicCamera localOrthographicCamera = (OrthographicCamera)localCamera;
          float f3 = localStage.getWidth();
          float f4 = localStage.getHeight();
          if (getX(16) - localCamera.position.x > f3 / 2.0F / localOrthographicCamera.zoom)
            setPosition(localCamera.position.x + f3 / 2.0F / localOrthographicCamera.zoom, getY(16), 16);
          if (getX(8) - localCamera.position.x < -f3 / 2.0F / localOrthographicCamera.zoom)
            setPosition(localCamera.position.x - f3 / 2.0F / localOrthographicCamera.zoom, getY(8), 8);
          if (getY(2) - localCamera.position.y > f4 / 2.0F / localOrthographicCamera.zoom)
            setPosition(getX(2), localCamera.position.y + f4 / 2.0F / localOrthographicCamera.zoom, 2);
          if (getY(4) - localCamera.position.y >= -f4 / 2.0F / localOrthographicCamera.zoom)
            continue;
          setPosition(getX(4), localCamera.position.y - f4 / 2.0F / localOrthographicCamera.zoom, 4);
          return;
        }
      while (getParent() != localStage.getRoot());
      float f1 = localStage.getWidth();
      f2 = localStage.getHeight();
      if (getX() < 0.0F)
        setX(0.0F);
      if (getRight() > f1)
        setX(f1 - getWidth());
      if (getY() >= 0.0F)
        continue;
      setY(0.0F);
    }
    while (getTop() <= f2);
    setY(f2 - getHeight());
  }

  public void setKeepWithinStage(boolean paramBoolean)
  {
    this.keepWithinStage = paramBoolean;
  }

  public void setModal(boolean paramBoolean)
  {
    this.isModal = paramBoolean;
  }

  public void setMovable(boolean paramBoolean)
  {
    this.isMovable = paramBoolean;
  }

  public void setResizable(boolean paramBoolean)
  {
    this.isResizable = paramBoolean;
  }

  public void setResizeBorder(int paramInt)
  {
    this.resizeBorder = paramInt;
  }

  public void setStyle(Window.WindowStyle paramWindowStyle)
  {
    if (paramWindowStyle == null)
      throw new IllegalArgumentException("style cannot be null.");
    this.style = paramWindowStyle;
    setBackground(paramWindowStyle.background);
    this.titleLabel.setStyle(new Label.LabelStyle(paramWindowStyle.titleFont, paramWindowStyle.titleFontColor));
    invalidateHierarchy();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Window
 * JD-Core Version:    0.6.0
 */