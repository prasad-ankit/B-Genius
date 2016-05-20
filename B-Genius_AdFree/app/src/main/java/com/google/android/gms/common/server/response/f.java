package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class f
  implements Parcelable.Creator
{
  public static SafeParcelResponse a(Parcel paramParcel)
  {
    FieldMappingDictionary localFieldMappingDictionary = null;
    int i = j.a(paramParcel);
    int j = 0;
    Parcel localParcel = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default:
        j.b(paramParcel, k);
        break;
      case 1:
        j = j.e(paramParcel, k);
        break;
      case 2:
        localParcel = j.v(paramParcel, k);
        break;
      case 3:
        localFieldMappingDictionary = (FieldMappingDictionary)j.a(paramParcel, k, FieldMappingDictionary.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new SafeParcelResponse(j, localParcel, localFieldMappingDictionary);
  }

  static void a(SafeParcelResponse paramSafeParcelResponse, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramSafeParcelResponse.c());
    j.a(paramParcel, 2, paramSafeParcelResponse.e(), false);
    j.a(paramParcel, 3, paramSafeParcelResponse.f(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.f
 * JD-Core Version:    0.6.0
 */