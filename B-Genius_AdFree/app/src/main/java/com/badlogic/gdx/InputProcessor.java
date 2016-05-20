package com.badlogic.gdx;

public abstract interface InputProcessor
{
  public abstract boolean keyDown(int paramInt);

  public abstract boolean keyTyped(char paramChar);

  public abstract boolean keyUp(int paramInt);

  public abstract boolean mouseMoved(int paramInt1, int paramInt2);

  public abstract boolean scrolled(int paramInt);

  public abstract boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract boolean touchDragged(int paramInt1, int paramInt2, int paramInt3);

  public abstract boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.InputProcessor
 * JD-Core Version:    0.6.0
 */