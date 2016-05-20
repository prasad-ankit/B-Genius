package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class b
  implements Runnable
{
  b(String[] paramArrayOfString, Activity paramActivity, int paramInt)
  {
  }

  public final void run()
  {
    int[] arrayOfInt = new int[this.a.length];
    PackageManager localPackageManager = this.b.getPackageManager();
    String str = this.b.getPackageName();
    int i = this.a.length;
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = localPackageManager.checkPermission(this.a[j], str);
    ((c)this.b).onRequestPermissionsResult(this.c, this.a, arrayOfInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.b
 * JD-Core Version:    0.6.0
 */