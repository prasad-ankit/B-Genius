package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ac
  implements Parcelable.Creator
{
  static void a(UpdatePermissionRequest paramUpdatePermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramUpdatePermissionRequest.a);
    j.a(paramParcel, 2, paramUpdatePermissionRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramUpdatePermissionRequest.c, false);
    j.a(paramParcel, 4, paramUpdatePermissionRequest.d);
    j.a(paramParcel, 5, paramUpdatePermissionRequest.e);
    j.a(paramParcel, 6, paramUpdatePermissionRequest.f, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ac
 * JD-Core Version:    0.6.0
 */