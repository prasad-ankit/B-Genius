package com.google.android.gms.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class hj extends hm
{
  hj(Context paramContext, hn paramhn)
  {
    super(0);
  }

  public final void a()
  {
    SharedPreferences localSharedPreferences = d.a(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("content_url_opted_out", localSharedPreferences.getBoolean("content_url_opted_out", true));
    if (this.b != null)
      this.b.a(localBundle);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hj
 * JD-Core Version:    0.6.0
 */