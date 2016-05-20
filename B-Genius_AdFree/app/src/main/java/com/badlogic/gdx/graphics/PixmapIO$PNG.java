package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ByteArray;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PixmapIO$PNG
  implements Disposable
{
  private static final byte COLOR_ARGB = 6;
  private static final byte COMPRESSION_DEFLATE = 0;
  private static final byte FILTER_NONE = 0;
  private static final int IDAT = 1229209940;
  private static final int IEND = 1229278788;
  private static final int IHDR = 1229472850;
  private static final byte INTERLACE_NONE = 0;
  private static final byte PAETH = 4;
  private static final byte[] SIGNATURE = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private final PixmapIO.PNG.ChunkBuffer buffer;
  private ByteArray curLineBytes;
  private final Deflater deflater;
  private boolean flipY = true;
  private int lastLineLen;
  private ByteArray lineOutBytes;
  private ByteArray prevLineBytes;

  public PixmapIO$PNG()
  {
    this(16384);
  }

  public PixmapIO$PNG(int paramInt)
  {
    this.buffer = new PixmapIO.PNG.ChunkBuffer(paramInt);
    this.deflater = new Deflater();
  }

  public void dispose()
  {
    this.deflater.end();
  }

  public void setCompression(int paramInt)
  {
    this.deflater.setLevel(paramInt);
  }

  public void setFlipY(boolean paramBoolean)
  {
    this.flipY = paramBoolean;
  }

  public void write(FileHandle paramFileHandle, Pixmap paramPixmap)
  {
    OutputStream localOutputStream = paramFileHandle.write(false);
    try
    {
      write(localOutputStream, paramPixmap);
      return;
    }
    finally
    {
      StreamUtils.closeQuietly(localOutputStream);
    }
    throw localObject;
  }

  public void write(OutputStream paramOutputStream, Pixmap paramPixmap)
  {
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(this.buffer, this.deflater);
    DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
    localDataOutputStream.write(SIGNATURE);
    this.buffer.writeInt(1229472850);
    this.buffer.writeInt(paramPixmap.getWidth());
    this.buffer.writeInt(paramPixmap.getHeight());
    this.buffer.writeByte(8);
    this.buffer.writeByte(6);
    this.buffer.writeByte(0);
    this.buffer.writeByte(0);
    this.buffer.writeByte(0);
    this.buffer.endChunk(localDataOutputStream);
    this.buffer.writeInt(1229209940);
    this.deflater.reset();
    int i = paramPixmap.getWidth() << 2;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    ByteBuffer localByteBuffer;
    int j;
    int k;
    label251: int m;
    Object localObject1;
    Object localObject2;
    label268: int i1;
    label291: label318: int i8;
    label377: int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    if (this.lineOutBytes == null)
    {
      ByteArray localByteArray1 = new ByteArray(i);
      this.lineOutBytes = localByteArray1;
      arrayOfByte1 = localByteArray1.items;
      ByteArray localByteArray2 = new ByteArray(i);
      this.curLineBytes = localByteArray2;
      arrayOfByte2 = localByteArray2.items;
      ByteArray localByteArray3 = new ByteArray(i);
      this.prevLineBytes = localByteArray3;
      arrayOfByte3 = localByteArray3.items;
      this.lastLineLen = i;
      localByteBuffer = paramPixmap.getPixels();
      j = localByteBuffer.position();
      if (paramPixmap.getFormat() != Pixmap.Format.RGBA8888)
        break label577;
      k = 1;
      m = 0;
      int n = paramPixmap.getHeight();
      localObject1 = arrayOfByte3;
      localObject2 = arrayOfByte2;
      if (m >= n)
        break label732;
      if (!this.flipY)
        break label583;
      i1 = -1 + (n - m);
      if (k == 0)
        break label590;
      localByteBuffer.position(i1 * i);
      localByteBuffer.get(localObject2, 0, i);
      arrayOfByte1[0] = (byte)(localObject2[0] - localObject1[0]);
      arrayOfByte1[1] = (byte)(localObject2[1] - localObject1[1]);
      arrayOfByte1[2] = (byte)(localObject2[2] - localObject1[2]);
      arrayOfByte1[3] = (byte)(localObject2[3] - localObject1[3]);
      i8 = 4;
      if (i8 >= i)
        break label700;
      i9 = 0xFF & localObject2[(i8 - 4)];
      i10 = 0xFF & localObject1[i8];
      i11 = 0xFF & localObject1[(i8 - 4)];
      i12 = i9 + i10 - i11;
      i13 = i12 - i9;
      if (i13 >= 0)
        break label790;
    }
    label790: for (int i14 = -i13; ; i14 = i13)
    {
      int i15 = i12 - i10;
      if (i15 < 0);
      for (int i16 = -i15; ; i16 = i15)
      {
        int i17 = i12 - i11;
        if (i17 < 0)
          i17 = -i17;
        if ((i14 <= i16) && (i14 <= i17));
        while (true)
        {
          arrayOfByte1[i8] = (byte)(localObject2[i8] - i9);
          i8++;
          break label377;
          arrayOfByte1 = this.lineOutBytes.ensureCapacity(i);
          arrayOfByte2 = this.curLineBytes.ensureCapacity(i);
          arrayOfByte3 = this.prevLineBytes.ensureCapacity(i);
          int i18 = 0;
          int i19 = this.lastLineLen;
          while (i18 < i19)
          {
            arrayOfByte3[i18] = 0;
            i18++;
          }
          break;
          label577: k = 0;
          break label251;
          label583: i1 = m;
          break label291;
          label590: int i2 = 0;
          int i3 = 0;
          while (i2 < paramPixmap.getWidth())
          {
            int i4 = paramPixmap.getPixel(i2, i1);
            int i5 = i3 + 1;
            localObject2[i3] = (byte)(i4 >>> 24);
            int i6 = i5 + 1;
            localObject2[i5] = (byte)(i4 >> 16);
            int i7 = i6 + 1;
            localObject2[i6] = (byte)(i4 >> 8);
            i3 = i7 + 1;
            localObject2[i7] = (byte)i4;
            i2++;
          }
          break label318;
          if (i16 <= i17)
          {
            i9 = i10;
            continue;
            label700: localDeflaterOutputStream.write(4);
            localDeflaterOutputStream.write(arrayOfByte1, 0, i);
            m++;
            Object localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label268;
            label732: localByteBuffer.position(j);
            localDeflaterOutputStream.finish();
            this.buffer.endChunk(localDataOutputStream);
            this.buffer.writeInt(1229278788);
            this.buffer.endChunk(localDataOutputStream);
            paramOutputStream.flush();
            return;
          }
          i9 = i11;
        }
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.PixmapIO.PNG
 * JD-Core Version:    0.6.0
 */