package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.os.Build.VERSION;
import com.badlogic.gdx.Application;
import java.lang.reflect.Constructor;

public class AndroidInputFactory
{
  public static AndroidInput newAndroidInput(Application paramApplication, Context paramContext, Object paramObject, AndroidApplicationConfiguration paramAndroidApplicationConfiguration)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 12);
      Class localClass;
      for (Object localObject = Class.forName("com.badlogic.gdx.backends.android.AndroidInputThreePlus"); ; localObject = localClass)
      {
        return (AndroidInput)((Class)localObject).getConstructor(new Class[] { Application.class, Context.class, Object.class, AndroidApplicationConfiguration.class }).newInstance(new Object[] { paramApplication, paramContext, paramObject, paramAndroidApplicationConfiguration });
        localClass = Class.forName("com.badlogic.gdx.backends.android.AndroidInput");
      }
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException("Couldn't construct AndroidInput, this should never happen", localException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidInputFactory
 * JD-Core Version:    0.6.0
 */