package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;

public final class a extends android.support.v4.a.a
{
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof e))
        ((e)paramActivity).a(paramInt);
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
    }
    do
      return;
    while (!(paramActivity instanceof c));
    new Handler(Looper.getMainLooper()).post(new b(paramArrayOfString, paramActivity, paramInt));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.a
 * JD-Core Version:    0.6.0
 */