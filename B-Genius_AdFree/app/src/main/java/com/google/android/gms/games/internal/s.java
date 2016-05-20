package com.google.android.gms.games.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.video.VideoConfiguration;
import java.util.ArrayList;
import java.util.List;

final class s
  implements q
{
  private IBinder a;

  s(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public final Intent A()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(16001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Intent B()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(19002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Account C()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(21001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localAccount = (Account)Account.CREATOR.createFromParcel(localParcel2);
        return localAccount;
      }
      Account localAccount = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final List D()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(21010, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int a(k paramk, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeByteArray(paramArrayOfByte);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(5033, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeByteArray(paramArrayOfByte);
      localParcel1.writeString(paramString);
      localParcel1.writeStringArray(paramArrayOfString);
      this.a.transact(5034, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(9008, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0);
      for (Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2); ; localIntent = null)
        return localIntent;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeByteArray(paramArrayOfByte);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeString(paramString);
      this.a.transact(10012, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Intent a(PlayerEntity paramPlayerEntity)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramPlayerEntity == null)
          continue;
        localParcel1.writeInt(1);
        paramPlayerEntity.writeToParcel(localParcel1, 0);
        this.a.transact(15503, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      Intent localIntent = null;
    }
  }

  public final Intent a(AchievementEntity paramAchievementEntity)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramAchievementEntity == null)
          continue;
        localParcel1.writeInt(1);
        paramAchievementEntity.writeToParcel(localParcel1, 0);
        this.a.transact(13005, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      Intent localIntent = null;
    }
  }

  public final Intent a(ZInvitationCluster paramZInvitationCluster, Account paramAccount, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramZInvitationCluster == null)
          continue;
        localParcel1.writeInt(1);
        paramZInvitationCluster.writeToParcel(localParcel1, 0);
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString);
          this.a.transact(21006, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() == 0)
            break label149;
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label149: Intent localIntent = null;
    }
  }

  public final Intent a(ZInvitationCluster paramZInvitationCluster, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramZInvitationCluster == null)
          continue;
        localParcel1.writeInt(1);
        paramZInvitationCluster.writeToParcel(localParcel1, 0);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(10021, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      Intent localIntent = null;
    }
  }

  public final Intent a(GameRequestCluster paramGameRequestCluster, Account paramAccount)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramGameRequestCluster == null)
          continue;
        localParcel1.writeInt(1);
        paramGameRequestCluster.writeToParcel(localParcel1, 0);
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          this.a.transact(21005, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() == 0)
            break label132;
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label132: Intent localIntent = null;
    }
  }

  public final Intent a(GameRequestCluster paramGameRequestCluster, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramGameRequestCluster == null)
          continue;
        localParcel1.writeInt(1);
        paramGameRequestCluster.writeToParcel(localParcel1, 0);
        localParcel1.writeString(paramString);
        this.a.transact(10022, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      Intent localIntent = null;
    }
  }

  public final Intent a(RoomEntity paramRoomEntity, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramRoomEntity == null)
          continue;
        localParcel1.writeInt(1);
        paramRoomEntity.writeToParcel(localParcel1, 0);
        localParcel1.writeInt(paramInt);
        this.a.transact(9011, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      Intent localIntent = null;
    }
  }

  public final Intent a(String paramString, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.a.transact(18001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      int j;
      if (paramBoolean1)
      {
        j = i;
        localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label124;
        label45: localParcel1.writeInt(i);
        localParcel1.writeInt(paramInt);
        this.a.transact(12001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() == 0)
          break label130;
      }
      label130: for (Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2); ; localIntent = null)
      {
        return localIntent;
        j = 0;
        break;
        label124: i = 0;
        break label45;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent a(int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeIntArray(paramArrayOfInt);
      this.a.transact(12030, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, Account paramAccount, String paramString1, Uri paramUri1, Uri paramUri2, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        localParcel1.writeTypedArray(paramArrayOfParticipantEntity, 0);
        if (paramAccount == null)
          continue;
        localParcel1.writeInt(1);
        paramAccount.writeToParcel(localParcel1, 0);
        localParcel1.writeString(paramString1);
        if (paramUri1 != null)
        {
          localParcel1.writeInt(1);
          paramUri1.writeToParcel(localParcel1, 0);
          if (paramUri2 == null)
            break label184;
          localParcel1.writeInt(1);
          paramUri2.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString2);
          this.a.transact(21004, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() == 0)
            break label193;
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label184: localParcel1.writeInt(0);
      continue;
      label193: Intent localIntent = null;
    }
  }

  public final Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        localParcel1.writeTypedArray(paramArrayOfParticipantEntity, 0);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramUri1 == null)
          continue;
        localParcel1.writeInt(1);
        paramUri1.writeToParcel(localParcel1, 0);
        if (paramUri2 != null)
        {
          localParcel1.writeInt(1);
          paramUri2.writeToParcel(localParcel1, 0);
          this.a.transact(9031, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() == 0)
            break label166;
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label166: Intent localIntent = null;
    }
  }

  public final Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, String paramString3)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        localParcel1.writeTypedArray(paramArrayOfParticipantEntity, 0);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramUri1 == null)
          continue;
        localParcel1.writeInt(1);
        paramUri1.writeToParcel(localParcel1, 0);
        if (paramUri2 != null)
        {
          localParcel1.writeInt(1);
          paramUri2.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString3);
          this.a.transact(14003, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() == 0)
            break label173;
          localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
          return localIntent;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label173: Intent localIntent = null;
    }
  }

  public final ParcelFileDescriptor a(Uri paramUri)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramUri == null)
          continue;
        localParcel1.writeInt(1);
        paramUri.writeToParcel(localParcel1, 0);
        this.a.transact(6507, localParcel1, localParcel2, 0);
        localParcel2.readException();
        if (localParcel2.readInt() != 0)
        {
          localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(localParcel2);
          return localParcelFileDescriptor;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      ParcelFileDescriptor localParcelFileDescriptor = null;
    }
  }

  public final String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5003, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final String a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(5064, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeInt(paramInt);
      this.a.transact(5036, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(5001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.a.transact(8019, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeStrongBinder(paramIBinder);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5005, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(Contents paramContents)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramContents != null)
      {
        localParcel1.writeInt(1);
        paramContents.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(12019, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        this.a.transact(10016, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt1, int paramInt2, int paramInt3)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        this.a.transact(10009, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5044, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt1, int paramInt2, String[] paramArrayOfString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeStringArray(paramArrayOfString);
        if (paramBundle == null)
          break label114;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(8004, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label114: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt, String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString);
        localParcel1.writeStringArray(paramArrayOfString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(14002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label112;
        j = i;
        label53: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label118;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5015, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label112: j = 0;
        break label53;
        label118: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int paramInt, int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.a.transact(10018, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        this.a.transact(5058, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString);
        this.a.transact(8018, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        if (paramBundle == null)
          break label106;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        this.a.transact(5021, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label106: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, IBinder paramIBinder, int paramInt, String[] paramArrayOfString, Bundle paramBundle, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramk == null)
          continue;
        IBinder localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStrongBinder(paramIBinder);
        localParcel1.writeInt(paramInt);
        localParcel1.writeStringArray(paramArrayOfString);
        if (paramBundle == null)
          continue;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
        break label164;
        localParcel1.writeInt(i);
        localParcel1.writeLong(paramLong);
        this.a.transact(5030, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        continue;
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      label164: 
      do
      {
        i = 0;
        break;
      }
      while (!paramBoolean);
    }
  }

  public final void a(k paramk, IBinder paramIBinder, String paramString, boolean paramBoolean, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStrongBinder(paramIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        localParcel1.writeLong(paramLong);
        this.a.transact(5031, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5014, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        this.a.transact(10011, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(5019, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        localParcel1.writeStrongBinder(paramIBinder);
        if (paramBundle == null)
          break label114;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5025, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label114: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(8023, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5045, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      label60: int k;
      label76: int m;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label151;
        j = i;
        localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label157;
        k = i;
        localParcel1.writeInt(k);
        if (!paramBoolean3)
          break label163;
        m = i;
        label92: localParcel1.writeInt(m);
        if (!paramBoolean4)
          break label169;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(6501, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label151: j = 0;
        break label60;
        label157: k = 0;
        break label76;
        label163: m = 0;
        break label92;
        label169: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.a.transact(10019, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeLong(paramLong);
        this.a.transact(5016, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, long paramLong, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString2);
        this.a.transact(7002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeStrongBinder(paramIBinder);
        if (paramBundle == null)
          break label107;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5023, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label107: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Contents paramContents)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramk == null)
          continue;
        IBinder localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        if (paramSnapshotMetadataChangeEntity == null)
          continue;
        localParcel1.writeInt(1);
        paramSnapshotMetadataChangeEntity.writeToParcel(localParcel1, 0);
        if (paramContents != null)
        {
          localParcel1.writeInt(1);
          paramContents.writeToParcel(localParcel1, 0);
          this.a.transact(12007, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public final void a(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(5038, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        this.a.transact(8001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        this.a.transact(10010, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(5039, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label126;
        j = i;
        label67: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label132;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(9028, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label126: j = 0;
        break label67;
        label132: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Contents paramContents)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
        if (paramk == null)
          continue;
        IBinder localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramSnapshotMetadataChangeEntity == null)
          continue;
        localParcel1.writeInt(1);
        paramSnapshotMetadataChangeEntity.writeToParcel(localParcel1, 0);
        if (paramContents != null)
        {
          localParcel1.writeInt(1);
          paramContents.writeToParcel(localParcel1, 0);
          this.a.transact(12033, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
          localIBinder = null;
          continue;
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }

  public final void a(k paramk, String paramString1, String paramString2, VideoConfiguration paramVideoConfiguration)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramVideoConfiguration == null)
          break label107;
        localParcel1.writeInt(1);
        paramVideoConfiguration.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(19003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label107: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeIntArray(paramArrayOfInt);
        localParcel1.writeInt(paramInt);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12015, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeStringArray(paramArrayOfString);
        this.a.transact(10008, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeStringArray(paramArrayOfString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12028, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(5054, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, boolean paramBoolean, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        localParcel1.writeInt(paramInt);
        this.a.transact(15001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeByteArray(paramArrayOfByte);
        localParcel1.writeString(paramString2);
        localParcel1.writeTypedArray(paramArrayOfParticipantResult, 0);
        this.a.transact(8007, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeByteArray(paramArrayOfByte);
        localParcel1.writeTypedArray(paramArrayOfParticipantResult, 0);
        this.a.transact(8008, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.a.transact(8017, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeStringArray(paramArrayOfString);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeByteArray(paramArrayOfByte);
        localParcel1.writeInt(paramInt2);
        this.a.transact(10005, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        if (!paramBoolean)
          break label107;
        label43: localParcel1.writeInt(i);
        if (paramBundle == null)
          break label113;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5063, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label107: i = 0;
        break label43;
        label113: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, boolean paramBoolean, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        localParcel1.writeStringArray(paramArrayOfString);
        this.a.transact(12031, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int[] paramArrayOfInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.a.transact(8003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeIntArray(paramArrayOfInt);
        localParcel1.writeInt(paramInt);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12010, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStringArray(paramArrayOfString);
        this.a.transact(10006, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(k paramk, String[] paramArrayOfString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStringArray(paramArrayOfString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12029, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(n paramn, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramn != null);
      for (IBinder localIBinder = paramn.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        this.a.transact(15501, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(5028, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString, Account paramAccount)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      if (paramAccount != null)
      {
        localParcel1.writeInt(1);
        paramAccount.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(21003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString, IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeStrongBinder(paramIBinder);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(13002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString, k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(20001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(5065, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String paramString1, String paramString2, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt);
      this.a.transact(5051, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(5068, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void a(String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeStringArray(paramArrayOfString);
      this.a.transact(15002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final IBinder asBinder()
  {
    return this.a;
  }

  public final Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(9009, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0);
      for (Intent localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2); ; localIntent = null)
        return localIntent;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Bundle b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5004, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
        return localBundle;
      }
      Bundle localBundle = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final String b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(5035, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(5059, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.a.transact(8021, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5017, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label112;
        j = i;
        label53: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label118;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5046, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label112: j = 0;
        break label53;
        label118: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        this.a.transact(8012, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString);
        this.a.transact(8020, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5018, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        this.a.transact(12023, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(5020, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        localParcel1.writeStrongBinder(paramIBinder);
        if (paramBundle == null)
          break label114;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(7003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label114: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, int paramInt, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(10017, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5501, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, IBinder paramIBinder, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeStrongBinder(paramIBinder);
        if (paramBundle == null)
          break label107;
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      while (true)
      {
        this.a.transact(5024, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label107: localParcel1.writeInt(0);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(5041, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(5040, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label126;
        j = i;
        label67: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label132;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(12018, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label126: j = 0;
        break label67;
        label132: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString1, String paramString2, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6506, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6502, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6503, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(k paramk, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStringArray(paramArrayOfString);
        this.a.transact(10007, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(5029, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(8025, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(String paramString1, String paramString2, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt);
      this.a.transact(8026, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void b(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(12026, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5006, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(8013, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.a.transact(10004, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5022, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label112;
        j = i;
        label53: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label118;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(5048, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label112: j = 0;
        break label53;
        label118: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        this.a.transact(10001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString);
        this.a.transact(10003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5032, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        this.a.transact(12024, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(9001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(8011, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString1, String paramString2, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6504, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(8027, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(k paramk, String[] paramArrayOfString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeStringArray(paramArrayOfString);
        this.a.transact(10020, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(5050, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(5055, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void c(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      int i = 0;
      if (paramBoolean)
        i = 1;
      localParcel1.writeInt(i);
      this.a.transact(13001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int d(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(5060, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final String d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5007, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(10002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
      this.a.transact(12014, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5026, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label112;
        j = i;
        label53: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label118;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(6003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label112: j = 0;
        break label53;
        label118: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        this.a.transact(12011, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString);
        this.a.transact(12013, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5037, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(9020, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(8015, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(6505, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void d(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(10014, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Uri e(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(5066, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localUri = (Uri)Uri.CREATOR.createFromParcel(localParcel2);
        return localUri;
      }
      Uri localUri = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final String e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5012, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(12012, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5027, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label112;
        j = i;
        label53: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label118;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(6004, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label112: j = 0;
        break label53;
        label118: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5042, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(12021, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(8016, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12006, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12032, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void e(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(12017, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent f(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(14001, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final DataHolder f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5013, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        DataHolder localDataHolder2 = i.a(localParcel2);
        localDataHolder1 = localDataHolder2;
        return localDataHolder1;
      }
      DataHolder localDataHolder1 = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void f(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeLong(paramLong);
      this.a.transact(15502, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5047, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5043, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      IBinder localIBinder;
      int j;
      if (paramk != null)
      {
        localIBinder = paramk.asBinder();
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (!paramBoolean1)
          break label119;
        j = i;
        label60: localParcel1.writeInt(j);
        if (!paramBoolean2)
          break label125;
      }
      while (true)
      {
        localParcel1.writeInt(i);
        this.a.transact(12022, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
        localIBinder = null;
        break;
        label119: j = 0;
        break label60;
        label125: i = 0;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.a.transact(12009, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk, String paramString, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(13006, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(12016, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void f(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(8002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent g(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(9004, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void g(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5049, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void g(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5052, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void g(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(13003, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final boolean g()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5067, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      int j = 0;
      if (i != 0)
        j = 1;
      return j;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final ParcelFileDescriptor h(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(9030, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(localParcel2);
        return localParcelFileDescriptor;
      }
      ParcelFileDescriptor localParcelFileDescriptor = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final DataHolder h()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(5502, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        DataHolder localDataHolder2 = i.a(localParcel2);
        localDataHolder1 = localDataHolder2;
        return localDataHolder1;
      }
      DataHolder localDataHolder1 = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final RoomEntity h(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5053, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        RoomEntity localRoomEntity = null;
        if (i != 0)
          localRoomEntity = (RoomEntity)RoomEntity.CREATOR.createFromParcel(localParcel2);
        return localRoomEntity;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void h(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5056, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void h(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(13004, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int i()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(8024, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent i(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(12034, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void i(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(5062, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void i(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5061, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void i(k paramk, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        int i = 0;
        if (paramBoolean)
          i = 1;
        localParcel1.writeInt(i);
        this.a.transact(17001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Account j(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      localParcel1.writeString(paramString);
      this.a.transact(21002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localAccount = (Account)Account.CREATOR.createFromParcel(localParcel2);
        return localAccount;
      }
      Account localAccount = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void j()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(8022, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void j(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(11001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void j(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(5057, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent k()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9003, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void k(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(19001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void k(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(7001, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent l()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9005, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void l(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(19004, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void l(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(8005, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent m()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9006, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void m(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(21007, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void m(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(8006, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent n()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9007, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void n(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(21008, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void n(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(8009, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent o()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9010, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void o(k paramk)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        this.a.transact(21009, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void o(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(8010, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent p()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9012, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void p(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(8014, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent q()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9013, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void q(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(9002, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int r()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(9019, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void r(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(12020, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int s()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(10013, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void s(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(12005, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int t()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(10023, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void t(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(12027, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final Intent u()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(10015, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
        return localIntent;
      }
      Intent localIntent = null;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }

  public final void u(k paramk, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      if (paramk != null);
      for (IBinder localIBinder = paramk.asBinder(); ; localIBinder = null)
      {
        localParcel1.writeStrongBinder(localIBinder);
        localParcel1.writeString(paramString);
        this.a.transact(12008, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void v()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(11002, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int w()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(12035, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final int x()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(12036, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final boolean y()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(12025, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      int j = 0;
      if (i != 0)
        j = 1;
      return j;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }

  public final void z()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
      this.a.transact(15504, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.s
 * JD-Core Version:    0.6.0
 */