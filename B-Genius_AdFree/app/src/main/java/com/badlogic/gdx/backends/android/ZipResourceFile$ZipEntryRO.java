package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class ZipResourceFile$ZipEntryRO
{
  public long mCRC32;
  public long mCompressedLength;
  public final File mFile;
  public final String mFileName;
  public long mLocalHdrOffset;
  public int mMethod;
  public long mOffset = -1L;
  public long mUncompressedLength;
  public long mWhenModified;
  public final String mZipFileName;

  public ZipResourceFile$ZipEntryRO(String paramString1, File paramFile, String paramString2)
  {
    this.mFileName = paramString2;
    this.mZipFileName = paramString1;
    this.mFile = paramFile;
  }

  public final AssetFileDescriptor getAssetFileDescriptor()
  {
    if (this.mMethod == 0)
      try
      {
        AssetFileDescriptor localAssetFileDescriptor = new AssetFileDescriptor(ParcelFileDescriptor.open(this.mFile, 268435456), getOffset(), this.mUncompressedLength);
        return localAssetFileDescriptor;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    return null;
  }

  public final long getOffset()
  {
    return this.mOffset;
  }

  public final File getZipFile()
  {
    return this.mFile;
  }

  public final String getZipFileName()
  {
    return this.mZipFileName;
  }

  public final boolean isUncompressed()
  {
    return this.mMethod == 0;
  }

  public final void setOffsetFromFile(RandomAccessFile paramRandomAccessFile, ByteBuffer paramByteBuffer)
  {
    long l = this.mLocalHdrOffset;
    try
    {
      paramRandomAccessFile.seek(l);
      paramRandomAccessFile.readFully(paramByteBuffer.array());
      if (paramByteBuffer.getInt(0) != 67324752)
      {
        Log.w("zipro", "didn't find signature at start of lfh");
        throw new IOException();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
      int i = 0xFFFF & paramByteBuffer.getShort(26);
      int j = 0xFFFF & paramByteBuffer.getShort(28);
      this.mOffset = (l + 30L + i + j);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO
 * JD-Core Version:    0.6.0
 */