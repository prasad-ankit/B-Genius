package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Orientation;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Pool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndroidInput
  implements View.OnKeyListener, View.OnTouchListener, Input
{
  public static final int NUM_TOUCHES = 20;
  public static final int SUPPORTED_KEYS = 260;
  final float[] R = new float[9];
  public boolean accelerometerAvailable = false;
  private SensorEventListener accelerometerListener;
  private final float[] accelerometerValues = new float[3];
  final Application app;
  private float azimuth = 0.0F;
  int[] button = new int[20];
  private boolean catchBack = false;
  private boolean catchMenu = false;
  private boolean compassAvailable = false;
  private SensorEventListener compassListener;
  private final AndroidApplicationConfiguration config;
  final Context context;
  private long currentEventTimeStamp = System.nanoTime();
  int[] deltaX = new int[20];
  int[] deltaY = new int[20];
  private Handler handle;
  final boolean hasMultitouch;
  private float inclination = 0.0F;
  private boolean[] justPressedKeys = new boolean[260];
  private boolean justTouched = false;
  private int keyCount = 0;
  ArrayList keyEvents = new ArrayList();
  private boolean keyJustPressed = false;
  ArrayList keyListeners = new ArrayList();
  boolean keyboardAvailable;
  private boolean[] keys = new boolean[260];
  private final float[] magneticFieldValues = new float[3];
  private SensorManager manager;
  private final Input.Orientation nativeOrientation;
  private final AndroidOnscreenKeyboard onscreenKeyboard;
  final float[] orientation = new float[3];
  private float pitch = 0.0F;
  private InputProcessor processor;
  int[] realId = new int[20];
  boolean requestFocus = true;
  private float roll = 0.0F;
  private int sleepTime = 0;
  private String text = null;
  private Input.TextInputListener textListener = null;
  ArrayList touchEvents = new ArrayList();
  private final AndroidTouchHandler touchHandler;
  int[] touchX = new int[20];
  int[] touchY = new int[20];
  boolean[] touched = new boolean[20];
  Pool usedKeyEvents = new AndroidInput.1(this, 16, 1000);
  Pool usedTouchEvents = new AndroidInput.2(this, 16, 1000);
  protected final Vibrator vibrator;

  public AndroidInput(Application paramApplication, Context paramContext, Object paramObject, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      localView.setOnKeyListener(this);
      localView.setOnTouchListener(this);
      localView.setFocusable(true);
      localView.setFocusableInTouchMode(true);
      localView.requestFocus();
    }
    this.config = paramAndroidApplicationConfiguration;
    this.onscreenKeyboard = new AndroidOnscreenKeyboard(paramContext, new Handler(), this);
    while (i < this.realId.length)
    {
      this.realId[i] = -1;
      i++;
    }
    this.handle = new Handler();
    this.app = paramApplication;
    this.context = paramContext;
    this.sleepTime = paramAndroidApplicationConfiguration.touchSleepTime;
    this.touchHandler = new AndroidMultiTouchHandler();
    this.hasMultitouch = this.touchHandler.supportsMultitouch(paramContext);
    this.vibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    int j = getRotation();
    Graphics.DisplayMode localDisplayMode = this.app.getGraphics().getDesktopDisplayMode();
    if (((j != 0) && (j != 180)) || ((localDisplayMode.width >= localDisplayMode.height) || (((j == 90) || (j == 270)) && (localDisplayMode.width <= localDisplayMode.height))))
    {
      this.nativeOrientation = Input.Orientation.Landscape;
      return;
    }
    this.nativeOrientation = Input.Orientation.Portrait;
  }

  private int[] resize(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[2 + paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }

  private boolean[] resize(boolean[] paramArrayOfBoolean)
  {
    boolean[] arrayOfBoolean = new boolean[2 + paramArrayOfBoolean.length];
    System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, paramArrayOfBoolean.length);
    return arrayOfBoolean;
  }

  private void updateOrientation()
  {
    if (SensorManager.getRotationMatrix(this.R, null, this.accelerometerValues, this.magneticFieldValues))
    {
      SensorManager.getOrientation(this.R, this.orientation);
      this.azimuth = (float)Math.toDegrees(this.orientation[0]);
      this.pitch = (float)Math.toDegrees(this.orientation[1]);
      this.roll = (float)Math.toDegrees(this.orientation[2]);
    }
  }

  public void addKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    this.keyListeners.add(paramOnKeyListener);
  }

  public void cancelVibrate()
  {
    this.vibrator.cancel();
  }

  public float getAccelerometerX()
  {
    return this.accelerometerValues[0];
  }

  public float getAccelerometerY()
  {
    return this.accelerometerValues[1];
  }

  public float getAccelerometerZ()
  {
    return this.accelerometerValues[2];
  }

  public float getAzimuth()
  {
    if (!this.compassAvailable)
      return 0.0F;
    updateOrientation();
    return this.azimuth;
  }

  public long getCurrentEventTime()
  {
    return this.currentEventTimeStamp;
  }

  public int getDeltaX()
  {
    return this.deltaX[0];
  }

  public int getDeltaX(int paramInt)
  {
    return this.deltaX[paramInt];
  }

  public int getDeltaY()
  {
    return this.deltaY[0];
  }

  public int getDeltaY(int paramInt)
  {
    return this.deltaY[paramInt];
  }

  public int getFreePointerIndex()
  {
    int i = this.realId.length;
    for (int j = 0; j < i; j++)
      if (this.realId[j] == -1)
        return j;
    this.realId = resize(this.realId);
    this.touchX = resize(this.touchX);
    this.touchY = resize(this.touchY);
    this.deltaX = resize(this.deltaX);
    this.deltaY = resize(this.deltaY);
    this.touched = resize(this.touched);
    this.button = resize(this.button);
    return i;
  }

  public InputProcessor getInputProcessor()
  {
    return this.processor;
  }

  public Input.Orientation getNativeOrientation()
  {
    return this.nativeOrientation;
  }

  public float getPitch()
  {
    if (!this.compassAvailable)
      return 0.0F;
    updateOrientation();
    return this.pitch;
  }

  public float getRoll()
  {
    if (!this.compassAvailable)
      return 0.0F;
    updateOrientation();
    return this.roll;
  }

  public int getRotation()
  {
    if ((this.context instanceof Activity));
    for (int i = ((Activity)this.context).getWindowManager().getDefaultDisplay().getRotation(); ; i = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getRotation())
      switch (i)
      {
      default:
        return 0;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return 0;
    return 90;
    return 180;
    return 270;
  }

  public void getRotationMatrix(float[] paramArrayOfFloat)
  {
    SensorManager.getRotationMatrix(paramArrayOfFloat, null, this.accelerometerValues, this.magneticFieldValues);
  }

  public void getTextInput(Input.TextInputListener paramTextInputListener, String paramString1, String paramString2, String paramString3)
  {
    this.handle.post(new AndroidInput.3(this, paramString1, paramString3, paramString2, paramTextInputListener));
  }

  public int getX()
  {
    monitorenter;
    try
    {
      int i = this.touchX[0];
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int getX(int paramInt)
  {
    monitorenter;
    try
    {
      int i = this.touchX[paramInt];
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int getY()
  {
    monitorenter;
    try
    {
      int i = this.touchY[0];
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int getY(int paramInt)
  {
    monitorenter;
    try
    {
      int i = this.touchY[paramInt];
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean isButtonPressed(int paramInt)
  {
    int i = 1;
    monitorenter;
    while (true)
    {
      int j;
      try
      {
        if (!this.hasMultitouch)
          continue;
        j = 0;
        if (j >= 20)
          continue;
        if ((this.touched[j] == 0) || (this.button[j] != paramInt))
          break label79;
        return i;
        if ((this.touched[0] != 0) && (this.button[0] == paramInt))
          return i;
      }
      finally
      {
        monitorexit;
      }
      i = 0;
      continue;
      label79: j++;
    }
  }

  public boolean isCatchBackKey()
  {
    return this.catchBack;
  }

  public boolean isCatchMenuKey()
  {
    return this.catchMenu;
  }

  public boolean isCursorCatched()
  {
    return false;
  }

  public boolean isKeyJustPressed(int paramInt)
  {
    monitorenter;
    if (paramInt == -1);
    try
    {
      boolean bool = this.keyJustPressed;
      while (true)
      {
        return bool;
        if ((paramInt < 0) || (paramInt >= 260))
        {
          bool = false;
          continue;
        }
        int i = this.justPressedKeys[paramInt];
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean isKeyPressed(int paramInt)
  {
    monitorenter;
    if (paramInt == -1);
    try
    {
      int j = this.keyCount;
      int i = 0;
      if (j > 0)
        i = 1;
      while (true)
      {
        return i;
        i = 0;
        if (paramInt < 0)
          continue;
        i = 0;
        if (paramInt >= 260)
          continue;
        i = this.keys[paramInt];
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean isPeripheralAvailable(Input.Peripheral paramPeripheral)
  {
    boolean bool = true;
    if (paramPeripheral == Input.Peripheral.Accelerometer)
      bool = this.accelerometerAvailable;
    while (true)
    {
      return bool;
      if (paramPeripheral == Input.Peripheral.Compass)
        return this.compassAvailable;
      if (paramPeripheral == Input.Peripheral.HardwareKeyboard)
        return this.keyboardAvailable;
      if (paramPeripheral == Input.Peripheral.OnscreenKeyboard)
        continue;
      if (paramPeripheral != Input.Peripheral.Vibrator)
        break;
      if ((Build.VERSION.SDK_INT >= 11) && (this.vibrator != null))
        return this.vibrator.hasVibrator();
      if (this.vibrator == null)
        return false;
    }
    if (paramPeripheral == Input.Peripheral.MultitouchScreen)
      return this.hasMultitouch;
    return false;
  }

  public boolean isTouched()
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        boolean bool = this.hasMultitouch;
        i = 0;
        if ((!bool) || (i >= 20))
          continue;
        if (this.touched[i] != 0)
        {
          return true;
          int j = this.touched[0];
          return j;
        }
      }
      finally
      {
        monitorexit;
      }
      i++;
    }
  }

  public boolean isTouched(int paramInt)
  {
    monitorenter;
    try
    {
      int i = this.touched[paramInt];
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean justTouched()
  {
    return this.justTouched;
  }

  public int lookUpPointerIndex(int paramInt)
  {
    int i = this.realId.length;
    for (int j = 0; j < i; j++)
      if (this.realId[j] == paramInt)
        return j;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int k = 0; k < i; k++)
      localStringBuffer.append(k + ":" + this.realId[k] + " ");
    Gdx.app.log("AndroidInput", "Pointer ID lookup failed: " + paramInt + ", " + localStringBuffer.toString());
    return -1;
  }

  public void onDrop(int paramInt1, int paramInt2)
  {
    postTap(paramInt1, paramInt2);
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = this.keyListeners.size();
    for (int j = 0; j < i; j++)
      if (((Input)this.keyListeners.get(j)).onKey(paramView, paramInt, paramKeyEvent))
        return true;
    monitorenter;
    while (true)
    {
      char c1;
      try
      {
        if ((paramKeyEvent.getKeyCode() != 0) || (paramKeyEvent.getAction() != 2))
          continue;
        String str = paramKeyEvent.getCharacters();
        int k = 0;
        if (k >= str.length())
          continue;
        AndroidInput.KeyEvent localKeyEvent4 = (AndroidInput.KeyEvent)this.usedKeyEvents.obtain();
        localKeyEvent4.timeStamp = System.nanoTime();
        localKeyEvent4.keyCode = 0;
        localKeyEvent4.keyChar = str.charAt(k);
        localKeyEvent4.type = 2;
        this.keyEvents.add(localKeyEvent4);
        k++;
        continue;
        return false;
        c1 = (char)paramKeyEvent.getUnicodeChar();
        if (paramInt != 67)
          break label593;
        c2 = '\b';
        if ((paramKeyEvent.getKeyCode() < 0) || (paramKeyEvent.getKeyCode() >= 260))
          return false;
        switch (paramKeyEvent.getAction())
        {
        default:
          this.app.getGraphics().requestRendering();
          monitorexit;
          if (paramInt != 255)
            break;
          return true;
        case 0:
          AndroidInput.KeyEvent localKeyEvent3 = (AndroidInput.KeyEvent)this.usedKeyEvents.obtain();
          localKeyEvent3.timeStamp = System.nanoTime();
          localKeyEvent3.keyChar = '\000';
          localKeyEvent3.keyCode = paramKeyEvent.getKeyCode();
          localKeyEvent3.type = 0;
          if ((paramInt != 4) || (!paramKeyEvent.isAltPressed()))
            continue;
          localKeyEvent3.keyCode = 255;
          paramInt = 255;
          this.keyEvents.add(localKeyEvent3);
          if (this.keys[localKeyEvent3.keyCode] != 0)
            continue;
          this.keyCount = (1 + this.keyCount);
          this.keys[localKeyEvent3.keyCode] = true;
          continue;
        case 1:
        }
      }
      finally
      {
        monitorexit;
      }
      long l = System.nanoTime();
      AndroidInput.KeyEvent localKeyEvent1 = (AndroidInput.KeyEvent)this.usedKeyEvents.obtain();
      localKeyEvent1.timeStamp = l;
      localKeyEvent1.keyChar = '\000';
      localKeyEvent1.keyCode = paramKeyEvent.getKeyCode();
      localKeyEvent1.type = 1;
      if ((paramInt == 4) && (paramKeyEvent.isAltPressed()))
      {
        localKeyEvent1.keyCode = 255;
        paramInt = 255;
      }
      this.keyEvents.add(localKeyEvent1);
      AndroidInput.KeyEvent localKeyEvent2 = (AndroidInput.KeyEvent)this.usedKeyEvents.obtain();
      localKeyEvent2.timeStamp = l;
      localKeyEvent2.keyChar = c2;
      localKeyEvent2.keyCode = 0;
      localKeyEvent2.type = 2;
      this.keyEvents.add(localKeyEvent2);
      if (paramInt == 255)
      {
        if (this.keys['ÿ'] == 0)
          continue;
        this.keyCount = (-1 + this.keyCount);
        this.keys['ÿ'] = false;
        continue;
      }
      if (this.keys[paramKeyEvent.getKeyCode()] == 0)
        continue;
      this.keyCount = (-1 + this.keyCount);
      this.keys[paramKeyEvent.getKeyCode()] = false;
      continue;
      if ((this.catchBack) && (paramInt == 4))
        return true;
      return (this.catchMenu) && (paramInt == 82);
      label593: char c2 = c1;
    }
  }

  public void onPause()
  {
    unregisterSensorListeners();
    Arrays.fill(this.realId, -1);
    Arrays.fill(this.touched, false);
  }

  public void onResume()
  {
    registerSensorListeners();
  }

  public void onTap(int paramInt1, int paramInt2)
  {
    postTap(paramInt1, paramInt2);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.requestFocus) && (paramView != null))
    {
      paramView.setFocusableInTouchMode(true);
      paramView.requestFocus();
      this.requestFocus = false;
    }
    this.touchHandler.onTouch(paramMotionEvent, this);
    if (this.sleepTime != 0);
    try
    {
      Thread.sleep(this.sleepTime);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    return true;
  }

  protected void postTap(int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      AndroidInput.TouchEvent localTouchEvent1 = (AndroidInput.TouchEvent)this.usedTouchEvents.obtain();
      localTouchEvent1.timeStamp = System.nanoTime();
      localTouchEvent1.pointer = 0;
      localTouchEvent1.x = paramInt1;
      localTouchEvent1.y = paramInt2;
      localTouchEvent1.type = 0;
      this.touchEvents.add(localTouchEvent1);
      AndroidInput.TouchEvent localTouchEvent2 = (AndroidInput.TouchEvent)this.usedTouchEvents.obtain();
      localTouchEvent2.timeStamp = System.nanoTime();
      localTouchEvent2.pointer = 0;
      localTouchEvent2.x = paramInt1;
      localTouchEvent2.y = paramInt2;
      localTouchEvent2.type = 1;
      this.touchEvents.add(localTouchEvent2);
      monitorexit;
      Gdx.app.getGraphics().requestRendering();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void processEvents()
  {
    monitorenter;
    InputProcessor localInputProcessor;
    while (true)
    {
      AndroidInput.KeyEvent localKeyEvent;
      try
      {
        this.justTouched = false;
        if (!this.keyJustPressed)
          continue;
        this.keyJustPressed = false;
        int i5 = 0;
        if (i5 >= this.justPressedKeys.length)
          continue;
        this.justPressedKeys[i5] = false;
        i5++;
        continue;
        if (this.processor == null)
          break label441;
        localInputProcessor = this.processor;
        int i1 = this.keyEvents.size();
        int i2 = 0;
        if (i2 >= i1)
          break;
        localKeyEvent = (AndroidInput.KeyEvent)this.keyEvents.get(i2);
        this.currentEventTimeStamp = localKeyEvent.timeStamp;
        switch (localKeyEvent.type)
        {
        default:
          this.usedKeyEvents.free(localKeyEvent);
          i2++;
          break;
        case 0:
          localInputProcessor.keyDown(localKeyEvent.keyCode);
          this.keyJustPressed = true;
          this.justPressedKeys[localKeyEvent.keyCode] = true;
          continue;
        case 1:
        case 2:
        }
      }
      finally
      {
        monitorexit;
      }
      localInputProcessor.keyUp(localKeyEvent.keyCode);
      continue;
      localInputProcessor.keyTyped(localKeyEvent.keyChar);
    }
    int i3 = this.touchEvents.size();
    int i4 = 0;
    if (i4 < i3)
    {
      AndroidInput.TouchEvent localTouchEvent2 = (AndroidInput.TouchEvent)this.touchEvents.get(i4);
      this.currentEventTimeStamp = localTouchEvent2.timeStamp;
      switch (localTouchEvent2.type)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 4:
      case 3:
      }
      while (true)
      {
        this.usedTouchEvents.free(localTouchEvent2);
        i4++;
        break;
        localInputProcessor.touchDown(localTouchEvent2.x, localTouchEvent2.y, localTouchEvent2.pointer, localTouchEvent2.button);
        this.justTouched = true;
        continue;
        localInputProcessor.touchUp(localTouchEvent2.x, localTouchEvent2.y, localTouchEvent2.pointer, localTouchEvent2.button);
        continue;
        localInputProcessor.touchDragged(localTouchEvent2.x, localTouchEvent2.y, localTouchEvent2.pointer);
        continue;
        localInputProcessor.mouseMoved(localTouchEvent2.x, localTouchEvent2.y);
        continue;
        localInputProcessor.scrolled(localTouchEvent2.scrollAmount);
      }
      label441: int i = this.touchEvents.size();
      for (int j = 0; j < i; j++)
      {
        AndroidInput.TouchEvent localTouchEvent1 = (AndroidInput.TouchEvent)this.touchEvents.get(j);
        if (localTouchEvent1.type == 0)
          this.justTouched = true;
        this.usedTouchEvents.free(localTouchEvent1);
      }
      int k = this.keyEvents.size();
      for (int m = 0; m < k; m++)
        this.usedKeyEvents.free(this.keyEvents.get(m));
    }
    if (this.touchEvents.size() == 0)
      for (int n = 0; n < this.deltaX.length; n++)
      {
        this.deltaX[0] = 0;
        this.deltaY[0] = 0;
      }
    this.keyEvents.clear();
    this.touchEvents.clear();
    monitorexit;
  }

  void registerSensorListeners()
  {
    if (this.config.useAccelerometer)
    {
      this.manager = ((SensorManager)this.context.getSystemService("sensor"));
      if (this.manager.getSensorList(1).size() != 0)
      {
        Sensor localSensor2 = (Sensor)this.manager.getSensorList(1).get(0);
        this.accelerometerListener = new AndroidInput.SensorListener(this, this.nativeOrientation, this.accelerometerValues, this.magneticFieldValues);
        this.accelerometerAvailable = this.manager.registerListener(this.accelerometerListener, localSensor2, 1);
        if (!this.config.useCompass)
          break label236;
        if (this.manager == null)
          this.manager = ((SensorManager)this.context.getSystemService("sensor"));
        Sensor localSensor1 = this.manager.getDefaultSensor(2);
        if (localSensor1 == null)
          break label228;
        this.compassAvailable = this.accelerometerAvailable;
        if (this.compassAvailable)
        {
          this.compassListener = new AndroidInput.SensorListener(this, this.nativeOrientation, this.accelerometerValues, this.magneticFieldValues);
          this.compassAvailable = this.manager.registerListener(this.compassListener, localSensor1, 1);
        }
      }
    }
    while (true)
    {
      Gdx.app.log("AndroidInput", "sensor listener setup");
      return;
      this.accelerometerAvailable = false;
      break;
      label228: this.compassAvailable = false;
      continue;
      label236: this.compassAvailable = false;
    }
  }

  public void setCatchBackKey(boolean paramBoolean)
  {
    this.catchBack = paramBoolean;
  }

  public void setCatchMenuKey(boolean paramBoolean)
  {
    this.catchMenu = paramBoolean;
  }

  public void setCursorCatched(boolean paramBoolean)
  {
  }

  public void setCursorPosition(int paramInt1, int paramInt2)
  {
  }

  public void setInputProcessor(InputProcessor paramInputProcessor)
  {
    monitorenter;
    try
    {
      this.processor = paramInputProcessor;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void setOnscreenKeyboardVisible(boolean paramBoolean)
  {
    this.handle.post(new AndroidInput.4(this, paramBoolean));
  }

  void unregisterSensorListeners()
  {
    if (this.manager != null)
    {
      if (this.accelerometerListener != null)
      {
        this.manager.unregisterListener(this.accelerometerListener);
        this.accelerometerListener = null;
      }
      if (this.compassListener != null)
      {
        this.manager.unregisterListener(this.compassListener);
        this.compassListener = null;
      }
      this.manager = null;
    }
    Gdx.app.log("AndroidInput", "sensor listener tear down");
  }

  public void vibrate(int paramInt)
  {
    this.vibrator.vibrate(paramInt);
  }

  public void vibrate(long[] paramArrayOfLong, int paramInt)
  {
    this.vibrator.vibrate(paramArrayOfLong, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidInput
 * JD-Core Version:    0.6.0
 */