package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.math.Vector2;

public class InputListener
  implements EventListener
{
  private static final Vector2 tmpCoords = new Vector2();

  public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
  }

  public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
  }

  public boolean handle(Event paramEvent)
  {
    if (!(paramEvent instanceof InputEvent))
      return false;
    InputEvent localInputEvent = (InputEvent)paramEvent;
    switch (InputListener.1.$SwitchMap$com$badlogic$gdx$scenes$scene2d$InputEvent$Type[localInputEvent.getType().ordinal()])
    {
    default:
      localInputEvent.toCoordinates(localInputEvent.getListenerActor(), tmpCoords);
      switch (InputListener.1.$SwitchMap$com$badlogic$gdx$scenes$scene2d$InputEvent$Type[localInputEvent.getType().ordinal()])
      {
      default:
        return false;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      }
    case 1:
      return keyDown(localInputEvent, localInputEvent.getKeyCode());
    case 2:
      return keyUp(localInputEvent, localInputEvent.getKeyCode());
    case 3:
    }
    return keyTyped(localInputEvent, localInputEvent.getCharacter());
    return touchDown(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getPointer(), localInputEvent.getButton());
    touchUp(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getPointer(), localInputEvent.getButton());
    return true;
    touchDragged(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getPointer());
    return true;
    return mouseMoved(localInputEvent, tmpCoords.x, tmpCoords.y);
    return scrolled(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getScrollAmount());
    enter(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getPointer(), localInputEvent.getRelatedActor());
    return false;
    exit(localInputEvent, tmpCoords.x, tmpCoords.y, localInputEvent.getPointer(), localInputEvent.getRelatedActor());
    return false;
  }

  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    return false;
  }

  public boolean keyTyped(InputEvent paramInputEvent, char paramChar)
  {
    return false;
  }

  public boolean keyUp(InputEvent paramInputEvent, int paramInt)
  {
    return false;
  }

  public boolean mouseMoved(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean scrolled(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    return false;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    return false;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.InputListener
 * JD-Core Version:    0.6.0
 */