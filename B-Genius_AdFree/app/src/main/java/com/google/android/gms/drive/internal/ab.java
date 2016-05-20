package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ab
  implements Parcelable.Creator
{
  static void a(UpdateMetadataRequest paramUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramUpdateMetadataRequest.a);
    j.a(paramParcel, 2, paramUpdateMetadataRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramUpdateMetadataRequest.c, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ab
 * JD-Core Version:    0.6.0
 */