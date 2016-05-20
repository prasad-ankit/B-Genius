package com.badlogic.gdx;

import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.TimeUtils;

public class InputProcessorQueue
  implements InputProcessor
{
  private static final int KEY_DOWN = 0;
  private static final int KEY_TYPED = 2;
  private static final int KEY_UP = 1;
  private static final int MOUSE_MOVED = 6;
  private static final int SCROLLED = 7;
  private static final int TOUCH_DOWN = 3;
  private static final int TOUCH_DRAGGED = 5;
  private static final int TOUCH_UP = 4;
  private long currentEventTime;
  private final IntArray processingQueue = new IntArray();
  private InputProcessor processor;
  private final IntArray queue = new IntArray();

  public InputProcessorQueue()
  {
  }

  public InputProcessorQueue(InputProcessor paramInputProcessor)
  {
    this.processor = paramInputProcessor;
  }

  private void queueTime()
  {
    long l = TimeUtils.nanoTime();
    this.queue.add((int)(l >> 32));
    this.queue.add((int)l);
  }

  public void drain()
  {
    IntArray localIntArray = this.processingQueue;
    monitorenter;
    while (true)
    {
      int n;
      try
      {
        if (this.processor != null)
          continue;
        this.queue.clear();
        return;
        localIntArray.addAll(this.queue);
        this.queue.clear();
        monitorexit;
        i = 0;
        int j = localIntArray.size;
        if (i >= j)
          break;
        int k = i + 1;
        long l = localIntArray.get(i) << 32;
        int m = k + 1;
        this.currentEventTime = (l | 0xFFFFFFFF & localIntArray.get(k));
        n = m + 1;
        switch (localIntArray.get(m))
        {
        default:
          i = n;
          continue;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        }
      }
      finally
      {
        monitorexit;
      }
      InputProcessor localInputProcessor8 = this.processor;
      int i = n + 1;
      localInputProcessor8.keyDown(localIntArray.get(n));
      continue;
      InputProcessor localInputProcessor7 = this.processor;
      i = n + 1;
      localInputProcessor7.keyUp(localIntArray.get(n));
      continue;
      InputProcessor localInputProcessor6 = this.processor;
      i = n + 1;
      localInputProcessor6.keyTyped((char)localIntArray.get(n));
      continue;
      InputProcessor localInputProcessor5 = this.processor;
      int i13 = n + 1;
      int i14 = localIntArray.get(n);
      int i15 = i13 + 1;
      int i16 = localIntArray.get(i13);
      int i17 = i15 + 1;
      int i18 = localIntArray.get(i15);
      i = i17 + 1;
      localInputProcessor5.touchDown(i14, i16, i18, localIntArray.get(i17));
      continue;
      InputProcessor localInputProcessor4 = this.processor;
      int i7 = n + 1;
      int i8 = localIntArray.get(n);
      int i9 = i7 + 1;
      int i10 = localIntArray.get(i7);
      int i11 = i9 + 1;
      int i12 = localIntArray.get(i9);
      i = i11 + 1;
      localInputProcessor4.touchUp(i8, i10, i12, localIntArray.get(i11));
      continue;
      InputProcessor localInputProcessor3 = this.processor;
      int i3 = n + 1;
      int i4 = localIntArray.get(n);
      int i5 = i3 + 1;
      int i6 = localIntArray.get(i3);
      i = i5 + 1;
      localInputProcessor3.touchDragged(i4, i6, localIntArray.get(i5));
      continue;
      InputProcessor localInputProcessor2 = this.processor;
      int i1 = n + 1;
      int i2 = localIntArray.get(n);
      i = i1 + 1;
      localInputProcessor2.mouseMoved(i2, localIntArray.get(i1));
      continue;
      InputProcessor localInputProcessor1 = this.processor;
      i = n + 1;
      localInputProcessor1.scrolled(localIntArray.get(n));
    }
    localIntArray.clear();
  }

  public long getCurrentEventTime()
  {
    return this.currentEventTime;
  }

  public InputProcessor getProcessor()
  {
    return this.processor;
  }

  public boolean keyDown(int paramInt)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(0);
      this.queue.add(paramInt);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean keyTyped(char paramChar)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(2);
      this.queue.add(paramChar);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean keyUp(int paramInt)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(1);
      this.queue.add(paramInt);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean mouseMoved(int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(6);
      this.queue.add(paramInt1);
      this.queue.add(paramInt2);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean scrolled(int paramInt)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(7);
      this.queue.add(paramInt);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setProcessor(InputProcessor paramInputProcessor)
  {
    this.processor = paramInputProcessor;
  }

  public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(3);
      this.queue.add(paramInt1);
      this.queue.add(paramInt2);
      this.queue.add(paramInt3);
      this.queue.add(paramInt4);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(5);
      this.queue.add(paramInt1);
      this.queue.add(paramInt2);
      this.queue.add(paramInt3);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    monitorenter;
    try
    {
      queueTime();
      this.queue.add(4);
      this.queue.add(paramInt1);
      this.queue.add(paramInt2);
      this.queue.add(paramInt3);
      this.queue.add(paramInt4);
      monitorexit;
      return false;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.InputProcessorQueue
 * JD-Core Version:    0.6.0
 */