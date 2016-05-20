package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class t extends x
{
  public t(r paramr)
  {
    super(paramr);
  }

  public final View a(int paramInt)
  {
    return this.c.findViewById(paramInt);
  }

  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.c.a(paramFragment, paramIntent, paramInt);
  }

  public final void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    r.a(this.c, paramFragment, paramArrayOfString, paramInt);
  }

  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.c.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }

  public final boolean a()
  {
    Window localWindow = this.c.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }

  public final boolean a(String paramString)
  {
    r localr = this.c;
    if (Build.VERSION.SDK_INT >= 23)
      return localr.shouldShowRequestPermissionRationale(paramString);
    return false;
  }

  public final boolean b()
  {
    return !this.c.isFinishing();
  }

  public final LayoutInflater c()
  {
    return this.c.getLayoutInflater().cloneInContext(this.c);
  }

  public final void d()
  {
    r localr = this.c;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localr.invalidateOptionsMenu();
      return;
    }
    localr.d = true;
  }

  public final boolean e()
  {
    return this.c.getWindow() != null;
  }

  public final int f()
  {
    Window localWindow = this.c.getWindow();
    if (localWindow == null)
      return 0;
    return localWindow.getAttributes().windowAnimations;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.6.0
 */