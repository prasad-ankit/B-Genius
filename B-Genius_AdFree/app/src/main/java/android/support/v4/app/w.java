package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.b.k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class w
{
  private final x a;

  private w(x paramx)
  {
    this.a = paramx;
  }

  public static final w a(x paramx)
  {
    return new w(paramx);
  }

  public static Object a(Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException("null reference");
    return paramObject;
  }

  public static Object a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      throw new NullPointerException(String.valueOf(paramObject2));
    return paramObject1;
  }

  // ERROR //
  public static Object a(java.util.concurrent.Callable paramCallable)
  {
    // Byte code:
    //   0: invokestatic 40	android/os/StrictMode:getThreadPolicy	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: getstatic 46	android/os/StrictMode$ThreadPolicy:LAX	Landroid/os/StrictMode$ThreadPolicy;
    //   7: invokestatic 50	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   10: aload_0
    //   11: invokeinterface 56 1 0
    //   16: astore 4
    //   18: aload_1
    //   19: invokestatic 50	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   22: aload 4
    //   24: areturn
    //   25: astore_3
    //   26: aload_1
    //   27: invokestatic 50	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   30: aconst_null
    //   31: areturn
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 50	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   37: aload_2
    //   38: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   4	18	25	java/lang/Throwable
    //   4	18	32	finally
  }

  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Given String is empty or null");
    return paramString;
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void a(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.format(paramString, paramArrayOfObject));
  }

  public static void b(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void c(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public final y a()
  {
    return this.a.b;
  }

  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.b.a(paramView, paramString, paramContext, paramAttributeSet);
  }

  public final List a(List paramList)
  {
    if (this.a.b.b == null)
      return null;
    paramList.addAll(this.a.b.b);
    return paramList;
  }

  public final void a(Configuration paramConfiguration)
  {
    this.a.b.a(paramConfiguration);
  }

  public final void a(Parcelable paramParcelable, List paramList)
  {
    this.a.b.a(paramParcelable, paramList);
  }

  public final void a(Fragment paramFragment)
  {
    this.a.b.a(this.a, this.a, null);
  }

  public final void a(k paramk)
  {
    this.a.a(paramk);
  }

  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.a.b(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public final void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final boolean a(Menu paramMenu)
  {
    return this.a.b.a(paramMenu);
  }

  public final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.a.b.a(paramMenu, paramMenuInflater);
  }

  public final boolean a(MenuItem paramMenuItem)
  {
    return this.a.b.a(paramMenuItem);
  }

  public final int b()
  {
    ArrayList localArrayList = this.a.b.b;
    if (localArrayList == null)
      return 0;
    return localArrayList.size();
  }

  public final void b(Menu paramMenu)
  {
    this.a.b.b(paramMenu);
  }

  public final boolean b(MenuItem paramMenuItem)
  {
    return this.a.b.b(paramMenuItem);
  }

  public final void c()
  {
    this.a.b.j = false;
  }

  public final Parcelable d()
  {
    return this.a.b.g();
  }

  public final List e()
  {
    A localA = this.a.b;
    ArrayList localArrayList1 = localA.b;
    ArrayList localArrayList2 = null;
    if (localArrayList1 != null)
    {
      int i = 0;
      if (i < localA.b.size())
      {
        Fragment localFragment = (Fragment)localA.b.get(i);
        if ((localFragment != null) && (localFragment.mRetainInstance))
        {
          if (localArrayList2 == null)
            localArrayList2 = new ArrayList();
          localArrayList2.add(localFragment);
          localFragment.mRetaining = true;
          if (localFragment.mTarget == null)
            break label117;
        }
        label117: for (int j = localFragment.mTarget.mIndex; ; j = -1)
        {
          localFragment.mTargetIndex = j;
          i++;
          break;
        }
      }
    }
    return localArrayList2;
  }

  public final void f()
  {
    this.a.b.h();
  }

  public final void g()
  {
    this.a.b.i();
  }

  public final void h()
  {
    this.a.b.j();
  }

  public final void i()
  {
    this.a.b.k();
  }

  public final void j()
  {
    this.a.b.a(4, false);
  }

  public final void k()
  {
    this.a.b.l();
  }

  public final void l()
  {
    this.a.b.a(2, false);
  }

  public final void m()
  {
    this.a.b.m();
  }

  public final void n()
  {
    this.a.b.n();
  }

  public final boolean o()
  {
    return this.a.b.f();
  }

  public final void p()
  {
    this.a.j();
  }

  public final void q()
  {
    this.a.k();
  }

  public final void r()
  {
    this.a.l();
  }

  public final k s()
  {
    return this.a.m();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.w
 * JD-Core Version:    0.6.0
 */