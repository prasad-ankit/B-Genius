package com.google.android.gms.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class hw extends BroadcastReceiver
{
  private hw(hu paramhu)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
      hu.a(this.a, true);
    do
      return;
    while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
    hu.a(this.a, false);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hw
 * JD-Core Version:    0.6.0
 */