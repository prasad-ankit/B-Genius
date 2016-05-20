package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final a CREATOR = new a();
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  public final String e;
  public final String f;
  public final boolean g;
  public final String h;
  public final boolean i;
  public final int j;

  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramBoolean1;
    this.h = paramString4;
    this.i = paramBoolean2;
    this.j = paramInt4;
  }

  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.a = 1;
    this.b = ((String)w.a(paramString1));
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.g = bool;
      this.i = paramBoolean;
      this.j = paramInt3;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    while (true)
    {
      return true;
      if (!(paramObject instanceof PlayLoggerContext))
        break;
      PlayLoggerContext localPlayLoggerContext = (PlayLoggerContext)paramObject;
      if ((this.a != localPlayLoggerContext.a) || (!this.b.equals(localPlayLoggerContext.b)) || (this.c != localPlayLoggerContext.c) || (this.d != localPlayLoggerContext.d) || (!f.a(this.h, localPlayLoggerContext.h)) || (!f.a(this.e, localPlayLoggerContext.e)) || (!f.a(this.f, localPlayLoggerContext.f)) || (this.g != localPlayLoggerContext.g) || (this.i != localPlayLoggerContext.i) || (this.j != localPlayLoggerContext.j))
        return false;
    }
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = Integer.valueOf(this.c);
    arrayOfObject[3] = Integer.valueOf(this.d);
    arrayOfObject[4] = this.h;
    arrayOfObject[5] = this.e;
    arrayOfObject[6] = this.f;
    arrayOfObject[7] = Boolean.valueOf(this.g);
    arrayOfObject[8] = Boolean.valueOf(this.i);
    arrayOfObject[9] = Integer.valueOf(this.j);
    return Arrays.hashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(this.a).append(',');
    localStringBuilder.append("package=").append(this.b).append(',');
    localStringBuilder.append("packageVersionCode=").append(this.c).append(',');
    localStringBuilder.append("logSource=").append(this.d).append(',');
    localStringBuilder.append("logSourceName=").append(this.h).append(',');
    localStringBuilder.append("uploadAccount=").append(this.e).append(',');
    localStringBuilder.append("loggingId=").append(this.f).append(',');
    localStringBuilder.append("logAndroidId=").append(this.g).append(',');
    localStringBuilder.append("isAnonymous=").append(this.i).append(',');
    localStringBuilder.append("qosTier=").append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.playlog.internal.PlayLoggerContext
 * JD-Core Version:    0.6.0
 */