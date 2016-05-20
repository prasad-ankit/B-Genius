package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  final int b;
  final boolean c;
  final List d;
  private final Set e;

  ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List paramList)
  {
  }

  private ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List paramList, Set paramSet)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
    this.d = paramList;
    this.e = paramSet;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      i = 0;
    ChangesAvailableOptions localChangesAvailableOptions;
    do
    {
      do
        return i;
      while (paramObject == this);
      localChangesAvailableOptions = (ChangesAvailableOptions)paramObject;
    }
    while ((f.a(this.e, localChangesAvailableOptions.e)) && (this.b == localChangesAvailableOptions.b) && (this.c == localChangesAvailableOptions.c));
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = Integer.valueOf(this.b);
    arrayOfObject[2] = Boolean.valueOf(this.c);
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = Boolean.valueOf(this.c);
    arrayOfObject[2] = this.d;
    return String.format(localLocale, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangesAvailableOptions
 * JD-Core Version:    0.6.0
 */