package com.google.a.a.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import com.google.android.gms.games.i;
import com.google.android.gms.games.multiplayer.Invitation;
import java.util.ArrayList;

public final class a
  implements com.google.android.gms.common.api.j, k
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private Activity e = null;
  private Context f = null;
  private h g = null;
  private i h = i.a().a();
  private g i = null;
  private int j = 0;
  private boolean k = true;
  private boolean l = false;
  private ConnectionResult m = null;
  private d n = null;
  private boolean o = true;
  private boolean p = false;
  private Handler q;
  private Invitation r;
  private ArrayList s;
  private c t = null;
  private int u = 3;

  public a(Activity paramActivity, int paramInt)
  {
    this.e = paramActivity;
    this.f = paramActivity.getApplicationContext();
    this.j = 1;
    this.q = new Handler();
  }

  private static Dialog a(Activity paramActivity, String paramString)
  {
    return new AlertDialog.Builder(paramActivity).setMessage(paramString).setNeutralButton(17039370, null).create();
  }

  private void a(d paramd)
  {
    this.k = false;
    h();
    this.n = paramd;
    if (paramd.b == 10004)
      e.a(this.f);
    int i1;
    int i2;
    Activity localActivity;
    if (this.n != null)
    {
      i1 = this.n.a;
      i2 = this.n.b;
      if (!this.o)
        break label239;
      localActivity = this.e;
      if (localActivity != null)
        break label91;
      Log.e("GameHelper", "*** No Activity. Can't show failure dialog!");
    }
    while (true)
    {
      this.b = false;
      b(false);
      return;
      label91: Dialog localDialog;
      switch (i2)
      {
      default:
        localDialog = com.google.android.gms.common.e.a(i1, localActivity, 9002, null);
        if (localDialog != null)
          break;
        Log.e("GameHelper", "No standard error dialog available. Making fallback dialog.");
        localDialog = a(localActivity, e.a(localActivity, 0) + " " + e.b(i1));
      case 10004:
      case 10002:
      case 10003:
      }
      while (true)
      {
        localDialog.show();
        break;
        localDialog = a(localActivity, e.a(localActivity, 2));
        continue;
        localDialog = a(localActivity, e.a(localActivity, 1));
        continue;
        localDialog = a(localActivity, e.a(localActivity, 3));
      }
      label239: b("Not showing error dialog because mShowErrorDialogs==false. Error was: " + this.n);
    }
  }

  private void a(String paramString)
  {
    if (!this.a)
    {
      String str = "GameHelper error: Operation attempted without setup: " + paramString + ". The setup() method must be called before attempting any other operation.";
      d(str);
      throw new IllegalStateException(str);
    }
  }

  private void b(String paramString)
  {
    if (this.p)
      Log.d("GameHelper", "GameHelper: " + paramString);
  }

  private static void c(String paramString)
  {
    Log.w("GameHelper", "!!! GameHelper WARNING: " + paramString);
  }

  private static void d(String paramString)
  {
    Log.e("GameHelper", "*** GameHelper ERROR: " + paramString);
  }

  private void e()
  {
    if (this.i.d())
    {
      b("Already connected.");
      return;
    }
    b("Starting connection.");
    this.b = true;
    this.r = null;
    this.i.b();
  }

  private int f()
  {
    return this.f.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).getInt("KEY_SIGN_IN_CANCELLATIONS", 0);
  }

  private void g()
  {
    if (this.c)
    {
      b("We're already expecting the result of a previous resolution.");
      return;
    }
    if (this.e == null)
    {
      b("No need to resolve issue, activity does not exist anymore");
      return;
    }
    b("resolveConnectionResult: trying to resolve result: " + this.m);
    if (this.m.a())
    {
      b("Result has resolution. Starting it.");
      try
      {
        this.c = true;
        this.m.a(this.e, 9001);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        b("SendIntentException, so connecting again.");
        e();
        return;
      }
    }
    b("resolveConnectionResult: result has no resolution. Giving up.");
    a(new d(this.m.c()));
  }

  private void h()
  {
    if (this.i.d())
    {
      b("Disconnecting client.");
      this.i.c();
      return;
    }
    Log.w("GameHelper", "disconnect() called when client was already disconnected.");
  }

  public final g a()
  {
    if (this.i == null)
      throw new IllegalStateException("No GoogleApiClient. Did you call setup()?");
    return this.i;
  }

  public final void a(int paramInt)
  {
    b("onConnectionSuspended, cause=" + paramInt);
    h();
    this.n = null;
    b("Making extraordinary call to onSignInFailed callback");
    this.b = false;
    b(false);
  }

  public final void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult: req=");
    if (paramInt1 == 9001);
    for (String str = "RC_RESOLVE"; ; str = String.valueOf(paramInt1))
    {
      b(str + ", resp=" + e.a(paramInt2));
      if (paramInt1 == 9001)
        break;
      b("onActivityResult: request code not meant for us. Ignoring.");
      return;
    }
    this.c = false;
    if (!this.b)
    {
      b("onActivityResult: ignoring because we are not connecting.");
      return;
    }
    if (paramInt2 == -1)
    {
      b("onAR: Resolution was RESULT_OK, so connecting current client again.");
      e();
      return;
    }
    if (paramInt2 == 10001)
    {
      b("onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
      e();
      return;
    }
    if (paramInt2 == 0)
    {
      b("onAR: Got a cancellation result, so disconnecting.");
      this.d = true;
      this.k = false;
      this.l = false;
      this.n = null;
      this.b = false;
      this.i.c();
      int i1 = f();
      int i2 = f();
      SharedPreferences.Editor localEditor = this.f.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
      localEditor.putInt("KEY_SIGN_IN_CANCELLATIONS", i2 + 1);
      localEditor.commit();
      int i3 = i2 + 1;
      b("onAR: # of cancellations " + i1 + " --> " + i3 + ", max " + this.u);
      b(false);
      return;
    }
    b("onAR: responseCode=" + e.a(paramInt2) + ", so giving up.");
    a(new d(this.m.c(), paramInt2));
  }

  public final void a(Activity paramActivity)
  {
    this.e = paramActivity;
    this.f = paramActivity.getApplicationContext();
    b("onStart");
    a("onStart");
    if (this.k)
    {
      if (this.i.d())
      {
        Log.w("GameHelper", "GameHelper: client was already connected on onStart()");
        return;
      }
      b("Connecting client.");
      this.b = true;
      this.i.b();
      return;
    }
    b("Not attempting to connect becase mConnectOnStart=false");
    b("Instead, reporting a sign-in failure.");
    this.q.postDelayed(new b(this), 1000L);
  }

  public final void a(Bundle paramBundle)
  {
    b("onConnected: connected!");
    if (paramBundle != null)
    {
      b("onConnected: connection hint provided. Checking for invite.");
      Invitation localInvitation = (Invitation)paramBundle.getParcelable("invitation");
      if ((localInvitation != null) && (localInvitation.e() != null))
      {
        b("onConnected: connection hint has a room invite!");
        this.r = localInvitation;
        b("Invitation ID: " + this.r.e());
      }
      this.s = com.google.android.gms.games.c.f.a(paramBundle);
      if (!this.s.isEmpty())
        b("onConnected: connection hint has " + this.s.size() + " request(s)");
      b("onConnected: connection hint provided. Checking for TBMP game.");
      paramBundle.getParcelable("turn_based_match");
    }
    b("succeedSignIn");
    this.n = null;
    this.k = true;
    this.l = false;
    this.b = false;
    b(true);
  }

  public final void a(c paramc)
  {
    if (this.a)
    {
      d("GameHelper: you cannot call GameHelper.setup() more than once!");
      throw new IllegalStateException("GameHelper: you cannot call GameHelper.setup() more than once!");
    }
    this.t = paramc;
    b("Setup: requested clients: " + this.j);
    if (this.g == null)
    {
      if (this.a)
      {
        d("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
        throw new IllegalStateException("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
      }
      h localh = new h(this.e, this, this);
      if ((0x1 & this.j) != 0)
      {
        localh.a(com.google.android.gms.games.c.c, this.h);
        localh.a(com.google.android.gms.games.c.b);
      }
      if ((0x2 & this.j) != 0)
      {
        localh.a(com.google.android.gms.plus.d.a);
        localh.a(com.google.android.gms.plus.d.b);
      }
      if ((0x8 & this.j) != 0)
      {
        localh.a(com.google.android.gms.drive.a.a);
        localh.a(com.google.android.gms.drive.a.b);
      }
      this.g = localh;
    }
    this.i = this.g.b();
    this.g = null;
    this.a = true;
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    int i1 = 1;
    b("onConnectionFailed");
    this.m = paramConnectionResult;
    b("Connection failure:");
    b("   - code: " + e.b(this.m.c()));
    b("   - resolvable: " + this.m.a());
    b("   - details: " + this.m.toString());
    int i2 = f();
    if (this.l)
      b("onConnectionFailed: WILL resolve because user initiated sign-in.");
    while (i1 == 0)
    {
      b("onConnectionFailed: since we won't resolve, failing now.");
      this.m = paramConnectionResult;
      this.b = false;
      b(false);
      return;
      if (this.d)
      {
        b("onConnectionFailed WILL NOT resolve (user already cancelled once).");
        i1 = 0;
        continue;
      }
      if (i2 < this.u)
      {
        b("onConnectionFailed: WILL resolve because we have below the max# of attempts, " + i2 + " < " + this.u);
        continue;
      }
      b("onConnectionFailed: Will NOT resolve; not user-initiated and max attempts reached: " + i2 + " >= " + this.u);
      i1 = 0;
    }
    b("onConnectionFailed: resolving problem...");
    g();
  }

  public final void a(boolean paramBoolean)
  {
    this.p = false;
  }

  public final void b()
  {
    b("onStop");
    a("onStop");
    if (this.i.d())
    {
      b("Disconnecting client due to onStop");
      this.i.c();
    }
    while (true)
    {
      this.b = false;
      this.c = false;
      this.e = null;
      return;
      b("Client already disconnected when we got onStop.");
    }
  }

  public final void b(int paramInt)
  {
    this.u = 0;
  }

  final void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("Notifying LISTENER of sign-in ");
    String str;
    if (paramBoolean)
      str = "SUCCESS";
    while (true)
    {
      b(str);
      if (this.t != null)
      {
        if (!paramBoolean)
          break;
        this.t.b();
      }
      return;
      if (this.n != null)
      {
        str = "FAILURE (error)";
        continue;
      }
      str = "FAILURE (no error)";
    }
    this.t.a();
  }

  public final void c()
  {
    if (!this.i.d())
    {
      b("signOut: was already disconnected, ignoring.");
      return;
    }
    if ((0x2 & this.j) != 0)
    {
      b("Clearing default account on PlusClient.");
      com.google.android.gms.plus.d.c.a(this.i);
    }
    if ((0x1 & this.j) != 0)
    {
      b("Signing out from the Google API Client.");
      com.google.android.gms.games.c.b(this.i);
    }
    b("Disconnecting client.");
    this.k = false;
    this.b = false;
    this.i.c();
  }

  public final void d()
  {
    b("beginUserInitiatedSignIn: resetting attempt count.");
    SharedPreferences.Editor localEditor = this.f.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
    localEditor.putInt("KEY_SIGN_IN_CANCELLATIONS", 0);
    localEditor.commit();
    this.d = false;
    this.k = true;
    if (this.i.d())
    {
      c("beginUserInitiatedSignIn() called when already connected. Calling listener directly to notify of success.");
      b(true);
      return;
    }
    if (this.b)
    {
      c("beginUserInitiatedSignIn() called when already connecting. Be patient! You can only call this method after you get an onSignInSucceeded() or onSignInFailed() callback. Suggestion: disable the sign-in button on startup and also when it's clicked, and re-enable when you get the callback.");
      return;
    }
    b("Starting USER-INITIATED sign-in flow.");
    this.l = true;
    if (this.m != null)
    {
      b("beginUserInitiatedSignIn: continuing pending sign-in flow.");
      this.b = true;
      g();
      return;
    }
    b("beginUserInitiatedSignIn: starting new sign-in flow.");
    this.b = true;
    e();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.a.a.a.a
 * JD-Core Version:    0.6.0
 */