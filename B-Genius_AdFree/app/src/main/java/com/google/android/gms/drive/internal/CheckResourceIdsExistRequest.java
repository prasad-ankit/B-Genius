package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new af();
  private final int a;
  private final List b;

  CheckResourceIdsExistRequest(int paramInt, List paramList)
  {
    this.a = paramInt;
    this.b = paramList;
  }

  public final int a()
  {
    return this.a;
  }

  public final List b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    af.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CheckResourceIdsExistRequest
 * JD-Core Version:    0.6.0
 */