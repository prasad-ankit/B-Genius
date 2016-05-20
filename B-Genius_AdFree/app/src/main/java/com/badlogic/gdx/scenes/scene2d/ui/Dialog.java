package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.ObjectMap;

public class Dialog extends Window
{
  Table buttonTable;
  boolean cancelHide;
  Table contentTable;
  FocusListener focusListener;
  protected InputListener ignoreTouchDown = new Dialog.1(this);
  Actor previousKeyboardFocus;
  Actor previousScrollFocus;
  private Skin skin;
  ObjectMap values = new ObjectMap();

  public Dialog(String paramString, Skin paramSkin)
  {
    super(paramString, (Window.WindowStyle)paramSkin.get(Window.WindowStyle.class));
    setSkin(paramSkin);
    this.skin = paramSkin;
    initialize();
  }

  public Dialog(String paramString1, Skin paramSkin, String paramString2)
  {
    super(paramString1, (Window.WindowStyle)paramSkin.get(paramString2, Window.WindowStyle.class));
    setSkin(paramSkin);
    this.skin = paramSkin;
    initialize();
  }

  public Dialog(String paramString, Window.WindowStyle paramWindowStyle)
  {
    super(paramString, paramWindowStyle);
    initialize();
  }

  private void initialize()
  {
    setModal(true);
    defaults().space(6.0F);
    Table localTable1 = new Table(this.skin);
    this.contentTable = localTable1;
    add(localTable1).expand().fill();
    row();
    Table localTable2 = new Table(this.skin);
    this.buttonTable = localTable2;
    add(localTable2);
    this.contentTable.defaults().space(6.0F);
    this.buttonTable.defaults().space(6.0F);
    this.buttonTable.addListener(new Dialog.2(this));
    this.focusListener = new Dialog.3(this);
  }

  public Dialog button(Button paramButton)
  {
    return button(paramButton, null);
  }

  public Dialog button(Button paramButton, Object paramObject)
  {
    this.buttonTable.add(paramButton);
    setObject(paramButton, paramObject);
    return this;
  }

  public Dialog button(String paramString)
  {
    return button(paramString, null);
  }

  public Dialog button(String paramString, Object paramObject)
  {
    if (this.skin == null)
      throw new IllegalStateException("This method may only be used if the dialog was constructed with a Skin.");
    return button(paramString, paramObject, (TextButton.TextButtonStyle)this.skin.get(TextButton.TextButtonStyle.class));
  }

  public Dialog button(String paramString, Object paramObject, TextButton.TextButtonStyle paramTextButtonStyle)
  {
    return button(new TextButton(paramString, paramTextButtonStyle), paramObject);
  }

  public void cancel()
  {
    this.cancelHide = true;
  }

  public Table getButtonTable()
  {
    return this.buttonTable;
  }

  public Table getContentTable()
  {
    return this.contentTable;
  }

  public void hide()
  {
    hide(Actions.sequence(Actions.fadeOut(0.4F, Interpolation.fade), Actions.removeListener(this.ignoreTouchDown, true), Actions.removeActor()));
  }

  public void hide(Action paramAction)
  {
    Stage localStage = getStage();
    if (localStage != null)
    {
      removeListener(this.focusListener);
      if ((this.previousKeyboardFocus != null) && (this.previousKeyboardFocus.getStage() == null))
        this.previousKeyboardFocus = null;
      Actor localActor1 = localStage.getKeyboardFocus();
      if ((localActor1 == null) || (localActor1.isDescendantOf(this)))
        localStage.setKeyboardFocus(this.previousKeyboardFocus);
      if ((this.previousScrollFocus != null) && (this.previousScrollFocus.getStage() == null))
        this.previousScrollFocus = null;
      Actor localActor2 = localStage.getScrollFocus();
      if ((localActor2 == null) || (localActor2.isDescendantOf(this)))
        localStage.setScrollFocus(this.previousScrollFocus);
    }
    if (paramAction != null)
    {
      addCaptureListener(this.ignoreTouchDown);
      addAction(Actions.sequence(paramAction, Actions.removeListener(this.ignoreTouchDown, true), Actions.removeActor()));
      return;
    }
    remove();
  }

  public Dialog key(int paramInt, Object paramObject)
  {
    addListener(new Dialog.4(this, paramInt, paramObject));
    return this;
  }

  protected void result(Object paramObject)
  {
  }

  public void setObject(Actor paramActor, Object paramObject)
  {
    this.values.put(paramActor, paramObject);
  }

  protected void setStage(Stage paramStage)
  {
    if (paramStage == null)
      addListener(this.focusListener);
    while (true)
    {
      super.setStage(paramStage);
      return;
      removeListener(this.focusListener);
    }
  }

  public Dialog show(Stage paramStage)
  {
    show(paramStage, Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(0.4F, Interpolation.fade)));
    setPosition(Math.round((paramStage.getWidth() - getWidth()) / 2.0F), Math.round((paramStage.getHeight() - getHeight()) / 2.0F));
    return this;
  }

  public Dialog show(Stage paramStage, Action paramAction)
  {
    clearActions();
    removeCaptureListener(this.ignoreTouchDown);
    this.previousKeyboardFocus = null;
    Actor localActor1 = paramStage.getKeyboardFocus();
    if ((localActor1 != null) && (!localActor1.isDescendantOf(this)))
      this.previousKeyboardFocus = localActor1;
    this.previousScrollFocus = null;
    Actor localActor2 = paramStage.getScrollFocus();
    if ((localActor2 != null) && (!localActor2.isDescendantOf(this)))
      this.previousScrollFocus = localActor2;
    pack();
    paramStage.addActor(this);
    paramStage.setKeyboardFocus(this);
    paramStage.setScrollFocus(this);
    if (paramAction != null)
      addAction(paramAction);
    return this;
  }

  public Dialog text(Label paramLabel)
  {
    this.contentTable.add(paramLabel);
    return this;
  }

  public Dialog text(String paramString)
  {
    if (this.skin == null)
      throw new IllegalStateException("This method may only be used if the dialog was constructed with a Skin.");
    return text(paramString, (Label.LabelStyle)this.skin.get(Label.LabelStyle.class));
  }

  public Dialog text(String paramString, Label.LabelStyle paramLabelStyle)
  {
    return text(new Label(paramString, paramLabelStyle));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Dialog
 * JD-Core Version:    0.6.0
 */