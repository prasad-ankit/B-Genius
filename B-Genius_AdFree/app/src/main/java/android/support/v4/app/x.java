package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.b.k;
import android.support.v4.b.l;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class x extends v
{
  final Context a;
  final A b = new A();
  private final Activity c;
  private final Handler d;
  private int e;
  private k f;
  private Q g;
  private boolean h;
  private boolean i;

  private x(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.c = paramActivity;
    this.a = paramContext;
    this.d = paramHandler;
    this.e = 0;
  }

  x(r paramr)
  {
    this(paramr, paramr, paramr.a, 0);
  }

  final Q a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f == null)
      this.f = new k();
    Q localQ = (Q)this.f.get(paramString);
    if (localQ == null)
    {
      if (paramBoolean2)
      {
        localQ = new Q(paramString, this, paramBoolean1);
        this.f.put(paramString, localQ);
      }
      return localQ;
    }
    localQ.a(this);
    return localQ;
  }

  public View a(int paramInt)
  {
    return null;
  }

  public void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt != -1)
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    this.a.startActivity(paramIntent);
  }

  public void a(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
  }

  final void a(k paramk)
  {
    this.f = paramk;
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  final void a(boolean paramBoolean)
  {
    if (this.g == null);
    do
      return;
    while (!this.i);
    this.i = false;
    if (paramBoolean)
    {
      this.g.d();
      return;
    }
    this.g.c();
  }

  public boolean a()
  {
    return true;
  }

  public boolean a(String paramString)
  {
    return false;
  }

  final void b(String paramString)
  {
    if (this.f != null)
    {
      Q localQ = (Q)this.f.get(paramString);
      if ((localQ != null) && (!localQ.e))
      {
        localQ.g();
        this.f.remove(paramString);
      }
    }
  }

  final void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.i);
    if (this.g != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.g)));
      paramPrintWriter.println(":");
      this.g.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  public boolean b()
  {
    return true;
  }

  public LayoutInflater c()
  {
    return (LayoutInflater)this.a.getSystemService("layout_inflater");
  }

  public void d()
  {
  }

  public boolean e()
  {
    return true;
  }

  public int f()
  {
    return this.e;
  }

  public abstract Object g();

  final Activity h()
  {
    return this.c;
  }

  final Handler i()
  {
    return this.d;
  }

  final void j()
  {
    if (this.i)
      return;
    this.i = true;
    if (this.g != null)
      this.g.b();
    while (true)
    {
      this.h = true;
      return;
      if (this.h)
        continue;
      this.g = a("(root)", this.i, false);
      if ((this.g == null) || (this.g.d))
        continue;
      this.g.b();
    }
  }

  final void k()
  {
    if (this.g == null)
      return;
    this.g.g();
  }

  final void l()
  {
    if (this.f != null)
    {
      int j = this.f.size();
      Q[] arrayOfQ = new Q[j];
      for (int k = j - 1; k >= 0; k--)
        arrayOfQ[k] = ((Q)this.f.c(k));
      for (int m = 0; m < j; m++)
      {
        Q localQ = arrayOfQ[m];
        if (localQ.e)
        {
          localQ.e = false;
          for (int n = -1 + localQ.b.a(); n >= 0; n--)
          {
            R localR = (R)localQ.b.b(n);
            if (!localR.f)
              continue;
            localR.f = false;
            if ((localR.e == localR.g) || (localR.e))
              continue;
            localR.a();
          }
        }
        localQ.f();
      }
    }
  }

  final k m()
  {
    int j = 0;
    int k;
    if (this.f != null)
    {
      int m = this.f.size();
      Q[] arrayOfQ = new Q[m];
      for (int n = m - 1; n >= 0; n--)
        arrayOfQ[n] = ((Q)this.f.c(n));
      k = 0;
      if (j < m)
      {
        Q localQ = arrayOfQ[j];
        if (localQ.e)
          k = 1;
        while (true)
        {
          j++;
          break;
          localQ.g();
          this.f.remove(localQ.c);
        }
      }
    }
    else
    {
      k = 0;
    }
    if (k != 0)
      return this.f;
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.6.0
 */