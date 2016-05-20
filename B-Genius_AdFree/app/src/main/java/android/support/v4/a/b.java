package android.support.v4.a;

import android.support.v4.app.j;
import java.io.PrintWriter;

public final class b
{
  private int a;
  private c b;
  private c c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;

  public final void a()
  {
    this.d = true;
    this.f = false;
    this.e = false;
  }

  public final void a(int paramInt, c paramc)
  {
    if (this.b != null)
      throw new IllegalStateException("There is already a listener registered");
    this.b = paramc;
    this.a = paramInt;
  }

  public final void a(c paramc)
  {
    if (this.b == null)
      throw new IllegalStateException("No listener register");
    if (this.b != paramc)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.b = null;
  }

  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if (this.d)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(false);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(false);
    }
    if (this.f)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(false);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.f);
    }
  }

  public final void b()
  {
    this.d = false;
  }

  public final void b(c paramc)
  {
    if (this.c != null)
      throw new IllegalStateException("There is already a listener registered");
    this.c = paramc;
  }

  public final void c()
  {
    this.f = true;
    this.d = false;
    this.e = false;
    this.g = false;
    this.h = false;
  }

  public final void c(c paramc)
  {
    if (this.c == null)
      throw new IllegalStateException("No listener register");
    if (this.c != paramc)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.c = null;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    j.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.a.b
 * JD-Core Version:    0.6.0
 */