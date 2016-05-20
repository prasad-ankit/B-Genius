package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnGenericMotionListener;
import com.badlogic.gdx.Application;
import java.util.ArrayList;

public class AndroidInputThreePlus extends AndroidInput
  implements View.OnGenericMotionListener
{
  ArrayList genericMotionListeners = new ArrayList();
  private final AndroidMouseHandler mouseHandler;

  public AndroidInputThreePlus(Application paramApplication, Context paramContext, Object paramObject, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    super(paramApplication, paramContext, paramObject, paramAndroidApplicationConfiguration);
    if ((paramObject instanceof View))
      ((View)paramObject).setOnGenericMotionListener(this);
    this.mouseHandler = new AndroidMouseHandler();
  }

  public void addGenericMotionListener(View.OnGenericMotionListener paramOnGenericMotionListener)
  {
    this.genericMotionListeners.add(paramOnGenericMotionListener);
  }

  public boolean onGenericMotion(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mouseHandler.onGenericMotion(paramMotionEvent, this))
      return true;
    int i = this.genericMotionListeners.size();
    for (int j = 0; j < i; j++)
      if (((View.OnGenericMotionListener)this.genericMotionListeners.get(j)).onGenericMotion(paramView, paramMotionEvent))
        return true;
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidInputThreePlus
 * JD-Core Version:    0.6.0
 */