package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.H;

public abstract class n extends Binder
  implements m
{
  public static m a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof m)))
      return (m)localIInterface;
    return new o(paramIBinder);
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i13 = paramParcel1.readInt();
      OnDownloadProgressResponse localOnDownloadProgressResponse = null;
      if (i13 != 0)
        localOnDownloadProgressResponse = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnDownloadProgressResponse);
      paramParcel2.writeNoException();
      return true;
    case 2:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i12 = paramParcel1.readInt();
      OnListEntriesResponse localOnListEntriesResponse = null;
      if (i12 != 0)
        localOnListEntriesResponse = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnListEntriesResponse);
      paramParcel2.writeNoException();
      return true;
    case 3:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i11 = paramParcel1.readInt();
      OnDriveIdResponse localOnDriveIdResponse = null;
      if (i11 != 0)
        localOnDriveIdResponse = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnDriveIdResponse);
      paramParcel2.writeNoException();
      return true;
    case 4:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i10 = paramParcel1.readInt();
      OnMetadataResponse localOnMetadataResponse = null;
      if (i10 != 0)
        localOnMetadataResponse = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnMetadataResponse);
      paramParcel2.writeNoException();
      return true;
    case 5:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i9 = paramParcel1.readInt();
      OnContentsResponse localOnContentsResponse = null;
      if (i9 != 0)
        localOnContentsResponse = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnContentsResponse);
      paramParcel2.writeNoException();
      return true;
    case 6:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i8 = paramParcel1.readInt();
      Status localStatus = null;
      if (i8 != 0)
        localStatus = (Status)Status.CREATOR.createFromParcel(paramParcel1);
      a(localStatus);
      paramParcel2.writeNoException();
      return true;
    case 7:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      a();
      paramParcel2.writeNoException();
      return true;
    case 8:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i7 = paramParcel1.readInt();
      OnListParentsResponse localOnListParentsResponse = null;
      if (i7 != 0)
        localOnListParentsResponse = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnListParentsResponse);
      paramParcel2.writeNoException();
      return true;
    case 9:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i6 = paramParcel1.readInt();
      OnSyncMoreResponse localOnSyncMoreResponse = null;
      if (i6 != 0)
        localOnSyncMoreResponse = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnSyncMoreResponse);
      paramParcel2.writeNoException();
      return true;
    case 11:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i5 = paramParcel1.readInt();
      OnLoadRealtimeResponse localOnLoadRealtimeResponse = null;
      if (i5 != 0)
        localOnLoadRealtimeResponse = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnLoadRealtimeResponse, H.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 12:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i4 = paramParcel1.readInt();
      OnResourceIdSetResponse localOnResourceIdSetResponse = null;
      if (i4 != 0)
        localOnResourceIdSetResponse = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnResourceIdSetResponse);
      paramParcel2.writeNoException();
      return true;
    case 13:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i3 = paramParcel1.readInt();
      OnPinnedDownloadPreferencesResponse localOnPinnedDownloadPreferencesResponse = null;
      if (i3 != 0)
        localOnPinnedDownloadPreferencesResponse = (OnPinnedDownloadPreferencesResponse)OnPinnedDownloadPreferencesResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnPinnedDownloadPreferencesResponse);
      paramParcel2.writeNoException();
      return true;
    case 14:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i2 = paramParcel1.readInt();
      OnDeviceUsagePreferenceResponse localOnDeviceUsagePreferenceResponse = null;
      if (i2 != 0)
        localOnDeviceUsagePreferenceResponse = (OnDeviceUsagePreferenceResponse)OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnDeviceUsagePreferenceResponse);
      paramParcel2.writeNoException();
      return true;
    case 15:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        a(bool);
        paramParcel2.writeNoException();
        return true;
      }
    case 16:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int i1 = paramParcel1.readInt();
      OnFetchThumbnailResponse localOnFetchThumbnailResponse = null;
      if (i1 != 0)
        localOnFetchThumbnailResponse = (OnFetchThumbnailResponse)OnFetchThumbnailResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnFetchThumbnailResponse);
      paramParcel2.writeNoException();
      return true;
    case 17:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int n = paramParcel1.readInt();
      ChangeSequenceNumber localChangeSequenceNumber = null;
      if (n != 0)
        localChangeSequenceNumber = (ChangeSequenceNumber)ChangeSequenceNumber.CREATOR.createFromParcel(paramParcel1);
      a(localChangeSequenceNumber);
      paramParcel2.writeNoException();
      return true;
    case 18:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int m = paramParcel1.readInt();
      OnChangesResponse localOnChangesResponse = null;
      if (m != 0)
        localOnChangesResponse = (OnChangesResponse)OnChangesResponse.CREATOR.createFromParcel(paramParcel1);
      a(localOnChangesResponse);
      paramParcel2.writeNoException();
      return true;
    case 20:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int k = paramParcel1.readInt();
      GetPermissionsResponse localGetPermissionsResponse = null;
      if (k != 0)
        localGetPermissionsResponse = (GetPermissionsResponse)GetPermissionsResponse.CREATOR.createFromParcel(paramParcel1);
      a(localGetPermissionsResponse);
      paramParcel2.writeNoException();
      return true;
    case 21:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      int j = paramParcel1.readInt();
      StringListResponse localStringListResponse = null;
      if (j != 0)
        localStringListResponse = (StringListResponse)StringListResponse.CREATOR.createFromParcel(paramParcel1);
      a(localStringListResponse);
      paramParcel2.writeNoException();
      return true;
    case 22:
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    int i = paramParcel1.readInt();
    OnStartStreamSession localOnStartStreamSession = null;
    if (i != 0)
      localOnStartStreamSession = (OnStartStreamSession)OnStartStreamSession.CREATOR.createFromParcel(paramParcel1);
    a(localOnStartStreamSession);
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.n
 * JD-Core Version:    0.6.0
 */