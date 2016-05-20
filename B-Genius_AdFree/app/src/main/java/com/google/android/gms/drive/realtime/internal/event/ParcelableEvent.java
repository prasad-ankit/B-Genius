package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  final String b;
  final String c;
  final List d;
  final boolean e;
  final boolean f;
  final boolean g;
  final String h;
  final String i;
  final TextInsertedDetails j;
  final TextDeletedDetails k;
  final ValuesAddedDetails l;
  final ValuesRemovedDetails m;
  final ValuesSetDetails n;
  final ValueChangedDetails o;
  final ReferenceShiftedDetails p;
  final ObjectChangedDetails q;
  final FieldChangedDetails r;

  ParcelableEvent(int paramInt, String paramString1, String paramString2, List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails, FieldChangedDetails paramFieldChangedDetails)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramList;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramTextInsertedDetails;
    this.k = paramTextDeletedDetails;
    this.l = paramValuesAddedDetails;
    this.m = paramValuesRemovedDetails;
    this.n = paramValuesSetDetails;
    this.o = paramValueChangedDetails;
    this.p = paramReferenceShiftedDetails;
    this.q = paramObjectChangedDetails;
    this.r = paramFieldChangedDetails;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
 * JD-Core Version:    0.6.0
 */