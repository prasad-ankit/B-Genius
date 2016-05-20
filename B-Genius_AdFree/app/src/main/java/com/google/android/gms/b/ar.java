package com.google.android.gms.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.app.w;
import java.util.List;

public final class ar
{
  private final Context a;

  public ar(Context paramContext)
  {
    w.a(paramContext, "Context can not be null");
    this.a = paramContext;
  }

  private boolean a(Intent paramIntent)
  {
    w.a(paramIntent, "Intent can not be null");
    boolean bool = this.a.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
    int i = 0;
    if (!bool)
      i = 1;
    return i;
  }

  public final boolean a()
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:"));
    return a(localIntent);
  }

  public final boolean b()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("sms:"));
    return a(localIntent);
  }

  public final boolean c()
  {
    return ("mounted".equals(Environment.getExternalStorageState())) && (this.a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }

  public final boolean d()
  {
    Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
    return (Build.VERSION.SDK_INT >= 14) && (a(localIntent));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ar
 * JD-Core Version:    0.6.0
 */