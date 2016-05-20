package com.google.android.gms.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class hg extends hm
{
  hg(Context paramContext, int paramInt)
  {
    super(0);
  }

  public final void a()
  {
    SharedPreferences.Editor localEditor = d.a(this.a).edit();
    localEditor.putInt("webview_cache_version", this.b);
    localEditor.apply();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hg
 * JD-Core Version:    0.6.0
 */