package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new m();
  final String a;
  final int b;

  static
  {
    new Operator("=");
    new Operator("<");
    new Operator("<=");
    new Operator(">");
    new Operator(">=");
    new Operator("and");
    new Operator("or");
    new Operator("not");
    new Operator("contains");
  }

  Operator(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.a = paramString;
  }

  private Operator(String paramString)
  {
    this(1, paramString);
  }

  public final String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Operator localOperator;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localOperator = (Operator)paramObject;
        if (this.a != null)
          break;
        if (localOperator.a != null)
          return false;
      }
    while (this.a.equals(localOperator.a));
    return false;
  }

  public int hashCode()
  {
    if (this.a == null);
    for (int i = 0; ; i = this.a.hashCode())
      return i + 31;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.Operator
 * JD-Core Version:    0.6.0
 */