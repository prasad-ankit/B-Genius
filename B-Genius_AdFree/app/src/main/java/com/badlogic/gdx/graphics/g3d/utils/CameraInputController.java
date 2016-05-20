package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class CameraInputController extends GestureDetector
{
  public int activateKey = 0;
  protected boolean activatePressed;
  public boolean alwaysScroll = true;
  public boolean autoUpdate = true;
  public int backwardKey = 47;
  protected boolean backwardPressed;
  protected int button = -1;
  public Camera camera;
  public int forwardButton = 2;
  public int forwardKey = 51;
  protected boolean forwardPressed;
  public boolean forwardTarget = true;
  protected final CameraInputController.CameraGestureListener gestureListener;
  private boolean multiTouch;
  public float pinchZoomFactor = 10.0F;
  public float rotateAngle = 360.0F;
  public int rotateButton = 0;
  public int rotateLeftKey = 32;
  protected boolean rotateLeftPressed;
  public int rotateRightKey = 29;
  protected boolean rotateRightPressed;
  public float scrollFactor = -0.1F;
  public boolean scrollTarget = false;
  private float startX;
  private float startY;
  public Vector3 target = new Vector3();
  private final Vector3 tmpV1 = new Vector3();
  private final Vector3 tmpV2 = new Vector3();
  private int touched;
  public int translateButton = 1;
  public boolean translateTarget = true;
  public float translateUnits = 10.0F;

  public CameraInputController(Camera paramCamera)
  {
    this(new CameraInputController.CameraGestureListener(), paramCamera);
  }

  protected CameraInputController(CameraInputController.CameraGestureListener paramCameraGestureListener, Camera paramCamera)
  {
    super(paramCameraGestureListener);
    this.gestureListener = paramCameraGestureListener;
    this.gestureListener.controller = this;
    this.camera = paramCamera;
  }

  public boolean keyDown(int paramInt)
  {
    if (paramInt == this.activateKey)
      this.activatePressed = true;
    if (paramInt == this.forwardKey)
      this.forwardPressed = true;
    while (true)
    {
      return false;
      if (paramInt == this.backwardKey)
      {
        this.backwardPressed = true;
        continue;
      }
      if (paramInt == this.rotateRightKey)
      {
        this.rotateRightPressed = true;
        continue;
      }
      if (paramInt != this.rotateLeftKey)
        continue;
      this.rotateLeftPressed = true;
    }
  }

  public boolean keyUp(int paramInt)
  {
    if (paramInt == this.activateKey)
    {
      this.activatePressed = false;
      this.button = -1;
    }
    if (paramInt == this.forwardKey)
      this.forwardPressed = false;
    do
    {
      return false;
      if (paramInt == this.backwardKey)
      {
        this.backwardPressed = false;
        return false;
      }
      if (paramInt != this.rotateRightKey)
        continue;
      this.rotateRightPressed = false;
      return false;
    }
    while (paramInt != this.rotateLeftKey);
    this.rotateLeftPressed = false;
    return false;
  }

  protected boolean pinchZoom(float paramFloat)
  {
    return zoom(paramFloat * this.pinchZoomFactor);
  }

  protected boolean process(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt == this.rotateButton)
    {
      this.tmpV1.set(this.camera.direction).crs(this.camera.up).y = 0.0F;
      this.camera.rotateAround(this.target, this.tmpV1.nor(), paramFloat2 * this.rotateAngle);
      this.camera.rotateAround(this.target, Vector3.Y, paramFloat1 * -this.rotateAngle);
    }
    while (true)
    {
      if (this.autoUpdate)
        this.camera.update();
      return true;
      if (paramInt == this.translateButton)
      {
        this.camera.translate(this.tmpV1.set(this.camera.direction).crs(this.camera.up).nor().scl(-paramFloat1 * this.translateUnits));
        this.camera.translate(this.tmpV2.set(this.camera.up).scl(-paramFloat2 * this.translateUnits));
        if (!this.translateTarget)
          continue;
        this.target.add(this.tmpV1).add(this.tmpV2);
        continue;
      }
      if (paramInt != this.forwardButton)
        continue;
      this.camera.translate(this.tmpV1.set(this.camera.direction).scl(paramFloat2 * this.translateUnits));
      if (!this.forwardTarget)
        continue;
      this.target.add(this.tmpV1);
    }
  }

  public boolean scrolled(int paramInt)
  {
    return zoom(paramInt * this.scrollFactor * this.translateUnits);
  }

  public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.touched |= 1 << paramInt3;
    boolean bool1;
    if (!MathUtils.isPowerOfTwo(this.touched))
    {
      bool1 = true;
      this.multiTouch = bool1;
      if (!this.multiTouch)
        break label88;
    }
    for (this.button = -1; ; this.button = paramInt4)
    {
      label88: 
      do
      {
        int i;
        if ((!super.touchDown(paramInt1, paramInt2, paramInt3, paramInt4)) && (this.activateKey != 0))
        {
          boolean bool2 = this.activatePressed;
          i = 0;
          if (!bool2);
        }
        else
        {
          i = 1;
        }
        return i;
        bool1 = false;
        break;
      }
      while ((this.button >= 0) || ((this.activateKey != 0) && (!this.activatePressed)));
      this.startX = paramInt1;
      this.startY = paramInt2;
    }
  }

  public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = super.touchDragged(paramInt1, paramInt2, paramInt3);
    if ((bool) || (this.button < 0))
      return bool;
    float f1 = (paramInt1 - this.startX) / Gdx.graphics.getWidth();
    float f2 = (this.startY - paramInt2) / Gdx.graphics.getHeight();
    this.startX = paramInt1;
    this.startY = paramInt2;
    return process(f1, f2, this.button);
  }

  public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.touched &= (0xFFFFFFFF ^ 1 << paramInt3);
    if (!MathUtils.isPowerOfTwo(this.touched));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.multiTouch = bool1;
      if (paramInt4 == this.button)
        this.button = -1;
      int i;
      if (!super.touchUp(paramInt1, paramInt2, paramInt3, paramInt4))
      {
        boolean bool2 = this.activatePressed;
        i = 0;
        if (!bool2);
      }
      else
      {
        i = 1;
      }
      return i;
    }
  }

  public void update()
  {
    if ((this.rotateRightPressed) || (this.rotateLeftPressed) || (this.forwardPressed) || (this.backwardPressed))
    {
      float f = Gdx.graphics.getDeltaTime();
      if (this.rotateRightPressed)
        this.camera.rotate(this.camera.up, -f * this.rotateAngle);
      if (this.rotateLeftPressed)
        this.camera.rotate(this.camera.up, f * this.rotateAngle);
      if (this.forwardPressed)
      {
        this.camera.translate(this.tmpV1.set(this.camera.direction).scl(f * this.translateUnits));
        if (this.forwardTarget)
          this.target.add(this.tmpV1);
      }
      if (this.backwardPressed)
      {
        this.camera.translate(this.tmpV1.set(this.camera.direction).scl(-f * this.translateUnits));
        if (this.forwardTarget)
          this.target.add(this.tmpV1);
      }
      if (this.autoUpdate)
        this.camera.update();
    }
  }

  public boolean zoom(float paramFloat)
  {
    if ((!this.alwaysScroll) && (this.activateKey != 0) && (!this.activatePressed))
      return false;
    this.camera.translate(this.tmpV1.set(this.camera.direction).scl(paramFloat));
    if (this.scrollTarget)
      this.target.add(this.tmpV1);
    if (this.autoUpdate)
      this.camera.update();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.CameraInputController
 * JD-Core Version:    0.6.0
 */