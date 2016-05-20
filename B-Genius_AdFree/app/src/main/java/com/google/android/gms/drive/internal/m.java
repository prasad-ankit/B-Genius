package com.google.android.gms.drive.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.G;

public abstract interface m extends IInterface
{
  public abstract void a();

  public abstract void a(Status paramStatus);

  public abstract void a(ChangeSequenceNumber paramChangeSequenceNumber);

  public abstract void a(GetPermissionsResponse paramGetPermissionsResponse);

  public abstract void a(OnChangesResponse paramOnChangesResponse);

  public abstract void a(OnContentsResponse paramOnContentsResponse);

  public abstract void a(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse);

  public abstract void a(OnDownloadProgressResponse paramOnDownloadProgressResponse);

  public abstract void a(OnDriveIdResponse paramOnDriveIdResponse);

  public abstract void a(OnFetchThumbnailResponse paramOnFetchThumbnailResponse);

  public abstract void a(OnListEntriesResponse paramOnListEntriesResponse);

  public abstract void a(OnListParentsResponse paramOnListParentsResponse);

  public abstract void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, G paramG);

  public abstract void a(OnMetadataResponse paramOnMetadataResponse);

  public abstract void a(OnPinnedDownloadPreferencesResponse paramOnPinnedDownloadPreferencesResponse);

  public abstract void a(OnResourceIdSetResponse paramOnResourceIdSetResponse);

  public abstract void a(OnStartStreamSession paramOnStartStreamSession);

  public abstract void a(OnSyncMoreResponse paramOnSyncMoreResponse);

  public abstract void a(StringListResponse paramStringListResponse);

  public abstract void a(boolean paramBoolean);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.m
 * JD-Core Version:    0.6.0
 */