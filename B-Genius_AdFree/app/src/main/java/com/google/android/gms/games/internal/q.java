package com.google.android.gms.games.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;
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
import java.util.List;

public abstract interface q extends IInterface
{
  public abstract Intent A();

  public abstract Intent B();

  public abstract Account C();

  public abstract List D();

  public abstract int a(k paramk, byte[] paramArrayOfByte, String paramString1, String paramString2);

  public abstract int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString);

  public abstract Intent a(int paramInt1, int paramInt2, boolean paramBoolean);

  public abstract Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString);

  public abstract Intent a(PlayerEntity paramPlayerEntity);

  public abstract Intent a(AchievementEntity paramAchievementEntity);

  public abstract Intent a(ZInvitationCluster paramZInvitationCluster, Account paramAccount, String paramString);

  public abstract Intent a(ZInvitationCluster paramZInvitationCluster, String paramString1, String paramString2);

  public abstract Intent a(GameRequestCluster paramGameRequestCluster, Account paramAccount);

  public abstract Intent a(GameRequestCluster paramGameRequestCluster, String paramString);

  public abstract Intent a(RoomEntity paramRoomEntity, int paramInt);

  public abstract Intent a(String paramString, int paramInt1, int paramInt2);

  public abstract Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt);

  public abstract Intent a(int[] paramArrayOfInt);

  public abstract Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, Account paramAccount, String paramString1, Uri paramUri1, Uri paramUri2, String paramString2);

  public abstract Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2);

  public abstract Intent a(ParticipantEntity[] paramArrayOfParticipantEntity, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, String paramString3);

  public abstract ParcelFileDescriptor a(Uri paramUri);

  public abstract String a();

  public abstract String a(String paramString);

  public abstract void a(int paramInt);

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, String paramString);

  public abstract void a(IBinder paramIBinder, Bundle paramBundle);

  public abstract void a(Contents paramContents);

  public abstract void a(k paramk);

  public abstract void a(k paramk, int paramInt);

  public abstract void a(k paramk, int paramInt1, int paramInt2, int paramInt3);

  public abstract void a(k paramk, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(k paramk, int paramInt1, int paramInt2, String[] paramArrayOfString, Bundle paramBundle);

  public abstract void a(k paramk, int paramInt, String paramString, String[] paramArrayOfString, boolean paramBoolean);

  public abstract void a(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(k paramk, int paramInt, int[] paramArrayOfInt);

  public abstract void a(k paramk, long paramLong);

  public abstract void a(k paramk, long paramLong, String paramString);

  public abstract void a(k paramk, Bundle paramBundle, int paramInt1, int paramInt2);

  public abstract void a(k paramk, IBinder paramIBinder, int paramInt, String[] paramArrayOfString, Bundle paramBundle, boolean paramBoolean, long paramLong);

  public abstract void a(k paramk, IBinder paramIBinder, String paramString, boolean paramBoolean, long paramLong);

  public abstract void a(k paramk, String paramString);

  public abstract void a(k paramk, String paramString, int paramInt);

  public abstract void a(k paramk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract void a(k paramk, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle);

  public abstract void a(k paramk, String paramString, int paramInt, boolean paramBoolean);

  public abstract void a(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);

  public abstract void a(k paramk, String paramString, int paramInt, int[] paramArrayOfInt);

  public abstract void a(k paramk, String paramString, long paramLong);

  public abstract void a(k paramk, String paramString1, long paramLong, String paramString2);

  public abstract void a(k paramk, String paramString, IBinder paramIBinder, Bundle paramBundle);

  public abstract void a(k paramk, String paramString, SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Contents paramContents);

  public abstract void a(k paramk, String paramString1, String paramString2);

  public abstract void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2);

  public abstract void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);

  public abstract void a(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract void a(k paramk, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void a(k paramk, String paramString1, String paramString2, SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Contents paramContents);

  public abstract void a(k paramk, String paramString1, String paramString2, VideoConfiguration paramVideoConfiguration);

  public abstract void a(k paramk, String paramString1, String paramString2, boolean paramBoolean);

  public abstract void a(k paramk, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean);

  public abstract void a(k paramk, String paramString1, String paramString2, String[] paramArrayOfString);

  public abstract void a(k paramk, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean);

  public abstract void a(k paramk, String paramString, boolean paramBoolean);

  public abstract void a(k paramk, String paramString, boolean paramBoolean, int paramInt);

  public abstract void a(k paramk, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult);

  public abstract void a(k paramk, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult);

  public abstract void a(k paramk, String paramString, int[] paramArrayOfInt);

  public abstract void a(k paramk, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2);

  public abstract void a(k paramk, boolean paramBoolean);

  public abstract void a(k paramk, boolean paramBoolean, Bundle paramBundle);

  public abstract void a(k paramk, boolean paramBoolean, String[] paramArrayOfString);

  public abstract void a(k paramk, int[] paramArrayOfInt);

  public abstract void a(k paramk, int[] paramArrayOfInt, int paramInt, boolean paramBoolean);

  public abstract void a(k paramk, String[] paramArrayOfString);

  public abstract void a(k paramk, String[] paramArrayOfString, boolean paramBoolean);

  public abstract void a(n paramn, long paramLong);

  public abstract void a(String paramString, int paramInt);

  public abstract void a(String paramString, Account paramAccount);

  public abstract void a(String paramString, IBinder paramIBinder, Bundle paramBundle);

  public abstract void a(String paramString, k paramk);

  public abstract void a(String paramString1, String paramString2);

  public abstract void a(String paramString1, String paramString2, int paramInt);

  public abstract void a(boolean paramBoolean);

  public abstract void a(String[] paramArrayOfString);

  public abstract Intent b(int paramInt1, int paramInt2, boolean paramBoolean);

  public abstract Bundle b();

  public abstract String b(String paramString);

  public abstract void b(long paramLong);

  public abstract void b(long paramLong, String paramString);

  public abstract void b(k paramk);

  public abstract void b(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void b(k paramk, long paramLong);

  public abstract void b(k paramk, long paramLong, String paramString);

  public abstract void b(k paramk, String paramString);

  public abstract void b(k paramk, String paramString, int paramInt);

  public abstract void b(k paramk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract void b(k paramk, String paramString, int paramInt, IBinder paramIBinder, Bundle paramBundle);

  public abstract void b(k paramk, String paramString, int paramInt, boolean paramBoolean);

  public abstract void b(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void b(k paramk, String paramString, IBinder paramIBinder, Bundle paramBundle);

  public abstract void b(k paramk, String paramString1, String paramString2);

  public abstract void b(k paramk, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);

  public abstract void b(k paramk, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void b(k paramk, String paramString1, String paramString2, boolean paramBoolean);

  public abstract void b(k paramk, String paramString, boolean paramBoolean);

  public abstract void b(k paramk, boolean paramBoolean);

  public abstract void b(k paramk, String[] paramArrayOfString);

  public abstract void b(String paramString, int paramInt);

  public abstract void b(String paramString1, String paramString2);

  public abstract void b(String paramString1, String paramString2, int paramInt);

  public abstract void b(boolean paramBoolean);

  public abstract void c();

  public abstract void c(long paramLong);

  public abstract void c(long paramLong, String paramString);

  public abstract void c(k paramk);

  public abstract void c(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void c(k paramk, long paramLong);

  public abstract void c(k paramk, long paramLong, String paramString);

  public abstract void c(k paramk, String paramString);

  public abstract void c(k paramk, String paramString, int paramInt);

  public abstract void c(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void c(k paramk, String paramString1, String paramString2);

  public abstract void c(k paramk, String paramString1, String paramString2, boolean paramBoolean);

  public abstract void c(k paramk, String paramString, boolean paramBoolean);

  public abstract void c(k paramk, boolean paramBoolean);

  public abstract void c(k paramk, String[] paramArrayOfString);

  public abstract void c(String paramString);

  public abstract void c(String paramString, int paramInt);

  public abstract void c(boolean paramBoolean);

  public abstract int d(String paramString);

  public abstract String d();

  public abstract void d(long paramLong);

  public abstract void d(long paramLong, String paramString);

  public abstract void d(k paramk);

  public abstract void d(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void d(k paramk, long paramLong);

  public abstract void d(k paramk, long paramLong, String paramString);

  public abstract void d(k paramk, String paramString);

  public abstract void d(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void d(k paramk, String paramString1, String paramString2);

  public abstract void d(k paramk, String paramString, boolean paramBoolean);

  public abstract void d(k paramk, boolean paramBoolean);

  public abstract void d(String paramString, int paramInt);

  public abstract Uri e(String paramString);

  public abstract String e();

  public abstract void e(long paramLong);

  public abstract void e(k paramk);

  public abstract void e(k paramk, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void e(k paramk, String paramString);

  public abstract void e(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void e(k paramk, String paramString1, String paramString2);

  public abstract void e(k paramk, String paramString, boolean paramBoolean);

  public abstract void e(k paramk, boolean paramBoolean);

  public abstract void e(String paramString, int paramInt);

  public abstract Intent f(String paramString, int paramInt);

  public abstract DataHolder f();

  public abstract void f(long paramLong);

  public abstract void f(k paramk);

  public abstract void f(k paramk, String paramString);

  public abstract void f(k paramk, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void f(k paramk, String paramString1, String paramString2);

  public abstract void f(k paramk, String paramString, boolean paramBoolean);

  public abstract void f(k paramk, boolean paramBoolean);

  public abstract void f(String paramString);

  public abstract Intent g(String paramString);

  public abstract void g(k paramk);

  public abstract void g(k paramk, String paramString);

  public abstract void g(k paramk, boolean paramBoolean);

  public abstract boolean g();

  public abstract ParcelFileDescriptor h(String paramString);

  public abstract DataHolder h();

  public abstract RoomEntity h(k paramk, String paramString);

  public abstract void h(k paramk);

  public abstract void h(k paramk, boolean paramBoolean);

  public abstract int i();

  public abstract Intent i(String paramString);

  public abstract void i(k paramk);

  public abstract void i(k paramk, String paramString);

  public abstract void i(k paramk, boolean paramBoolean);

  public abstract Account j(String paramString);

  public abstract void j();

  public abstract void j(k paramk);

  public abstract void j(k paramk, String paramString);

  public abstract Intent k();

  public abstract void k(k paramk);

  public abstract void k(k paramk, String paramString);

  public abstract Intent l();

  public abstract void l(k paramk);

  public abstract void l(k paramk, String paramString);

  public abstract Intent m();

  public abstract void m(k paramk);

  public abstract void m(k paramk, String paramString);

  public abstract Intent n();

  public abstract void n(k paramk);

  public abstract void n(k paramk, String paramString);

  public abstract Intent o();

  public abstract void o(k paramk);

  public abstract void o(k paramk, String paramString);

  public abstract Intent p();

  public abstract void p(k paramk, String paramString);

  public abstract Intent q();

  public abstract void q(k paramk, String paramString);

  public abstract int r();

  public abstract void r(k paramk, String paramString);

  public abstract int s();

  public abstract void s(k paramk, String paramString);

  public abstract int t();

  public abstract void t(k paramk, String paramString);

  public abstract Intent u();

  public abstract void u(k paramk, String paramString);

  public abstract void v();

  public abstract int w();

  public abstract int x();

  public abstract boolean y();

  public abstract void z();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.q
 * JD-Core Version:    0.6.0
 */