package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new aj();
  final int a;
  final int b;

  CreateContentsRequest(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    if ((paramInt2 == 536870912) || (paramInt2 == 805306368));
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool, "Cannot create a new read-only contents!");
      this.b = paramInt2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateContentsRequest
 * JD-Core Version:    0.6.0
 */