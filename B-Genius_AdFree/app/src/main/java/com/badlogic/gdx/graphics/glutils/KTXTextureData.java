package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class KTXTextureData
  implements CubemapData, TextureData
{
  private static final int GL_TEXTURE_1D = 4660;
  private static final int GL_TEXTURE_1D_ARRAY_EXT = 4660;
  private static final int GL_TEXTURE_2D_ARRAY_EXT = 4660;
  private static final int GL_TEXTURE_3D = 4660;
  private ByteBuffer compressedData;
  private FileHandle file;
  private int glBaseInternalFormat;
  private int glFormat;
  private int glInternalFormat;
  private int glType;
  private int glTypeSize;
  private int imagePos;
  private int numberOfArrayElements;
  private int numberOfFaces;
  private int numberOfMipmapLevels;
  private int pixelDepth = -1;
  private int pixelHeight = -1;
  private int pixelWidth = -1;
  private boolean useMipMaps;

  public KTXTextureData(FileHandle paramFileHandle, boolean paramBoolean)
  {
    this.file = paramFileHandle;
    this.useMipMaps = paramBoolean;
  }

  public void consumeCubemapData()
  {
    consumeCustomData(34067);
  }

  public void consumeCustomData(int paramInt)
  {
    if (this.compressedData == null)
      throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
    IntBuffer localIntBuffer = BufferUtils.newIntBuffer(16);
    if ((this.glType == 0) || (this.glFormat == 0))
      if (this.glType + this.glFormat != 0)
        throw new GdxRuntimeException("either both or none of glType, glFormat must be zero");
    for (int i = 1; ; i = 0)
    {
      int j = 1;
      int k = 4660;
      if (this.pixelHeight > 0)
      {
        j = 2;
        k = 3553;
      }
      if (this.pixelDepth > 0)
      {
        j = 3;
        k = 4660;
      }
      int i19;
      label138: int m;
      if (this.numberOfFaces == 6)
        if (j == 2)
        {
          k = 34067;
          if (this.numberOfArrayElements <= 0)
            break label872;
          if (k != 4660)
            break label194;
          i19 = 4660;
          m = j + 1;
        }
      for (int n = i19; ; n = k)
      {
        if (n == 4660)
        {
          throw new GdxRuntimeException("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
          throw new GdxRuntimeException("cube map needs 2D faces");
          if (this.numberOfFaces == 1)
            break;
          throw new GdxRuntimeException("numberOfFaces must be either 1 or 6");
          label194: if (k == 3553)
          {
            i19 = 4660;
            break label138;
          }
          throw new GdxRuntimeException("No API for 3D and cube arrays yet");
        }
        int i1;
        if ((this.numberOfFaces == 6) && (paramInt != 34067))
        {
          if ((34069 > paramInt) || (paramInt > 34074))
            throw new GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
          int i18 = paramInt - 34069;
          paramInt = 34069;
          i1 = i18;
        }
        while (true)
        {
          Gdx.gl.glGetIntegerv(3317, localIntBuffer);
          int i2 = localIntBuffer.get(0);
          if (i2 != 4)
            Gdx.gl.glPixelStorei(3317, 4);
          int i3 = this.glInternalFormat;
          int i4 = this.glFormat;
          int i5 = this.imagePos;
          int i6 = 0;
          label328: int i7;
          int i8;
          int i9;
          int i12;
          label416: int i14;
          ByteBuffer localByteBuffer;
          if (i6 < this.numberOfMipmapLevels)
          {
            i7 = Math.max(1, this.pixelWidth >> i6);
            i8 = Math.max(1, this.pixelHeight >> i6);
            Math.max(1, this.pixelDepth >> i6);
            this.compressedData.position(i5);
            i9 = this.compressedData.getInt();
            int i10 = 0xFFFFFFFC & i9 + 3;
            int i11 = i5 + 4;
            i12 = 0;
            i5 = i11;
            int i13 = this.numberOfFaces;
            if (i12 < i13)
            {
              this.compressedData.position(i5);
              i14 = i5 + i10;
              if ((i1 == -1) || (i1 == i12))
              {
                localByteBuffer = this.compressedData.slice();
                localByteBuffer.limit(i10);
                if ((m != 1) && (m == 2))
                  if (this.numberOfArrayElements <= 0)
                    break label859;
              }
            }
          }
          label859: for (int i15 = this.numberOfArrayElements; ; i15 = i8)
          {
            if (i != 0)
              if (i3 == ETC1.ETC1_RGB8_OES)
                if (!Gdx.graphics.supportsExtension("GL_OES_compressed_ETC1_RGB8_texture"))
                {
                  Pixmap localPixmap = ETC1.decodeImage(new ETC1.ETC1Data(i7, i15, localByteBuffer, 0), Pixmap.Format.RGB888);
                  Gdx.gl.glTexImage2D(paramInt + i12, i6, localPixmap.getGLInternalFormat(), localPixmap.getWidth(), localPixmap.getHeight(), 0, localPixmap.getGLFormat(), localPixmap.getGLType(), localPixmap.getPixels());
                  localPixmap.dispose();
                  i8 = i15;
                }
            while (true)
            {
              i12++;
              i5 = i14;
              break label416;
              if ((this.numberOfFaces == 6) && (paramInt == 34067))
              {
                paramInt = 34069;
                i1 = -1;
                break;
              }
              if ((paramInt == n) || ((34069 <= paramInt) && (paramInt <= 34074) && (paramInt == 3553)))
                break label866;
              throw new GdxRuntimeException("Invalid target requested : 0x" + Integer.toHexString(paramInt) + ", expecting : 0x" + Integer.toHexString(n));
              Gdx.gl.glCompressedTexImage2D(paramInt + i12, i6, i3, i7, i15, 0, i9, localByteBuffer);
              i8 = i15;
              continue;
              Gdx.gl.glCompressedTexImage2D(paramInt + i12, i6, i3, i7, i15, 0, i9, localByteBuffer);
              i8 = i15;
              continue;
              GL20 localGL20 = Gdx.gl;
              int i16 = paramInt + i12;
              int i17 = this.glType;
              localGL20.glTexImage2D(i16, i6, i3, i7, i15, 0, i4, i17, localByteBuffer);
              i8 = i15;
            }
            i6++;
            break label328;
            if (i2 != 4)
              Gdx.gl.glPixelStorei(3317, i2);
            if (useMipMaps())
              Gdx.gl.glGenerateMipmap(paramInt);
            disposePreparedData();
            return;
          }
          label866: i1 = -1;
        }
        label872: m = j;
      }
    }
  }

  public Pixmap consumePixmap()
  {
    throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
  }

  public boolean disposePixmap()
  {
    throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
  }

  public void disposePreparedData()
  {
    if (this.compressedData != null)
      BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
    this.compressedData = null;
  }

  public ByteBuffer getData(int paramInt1, int paramInt2)
  {
    int i = this.imagePos;
    int j = 0;
    if (j < this.numberOfMipmapLevels)
    {
      int k = 0xFFFFFFFC & 3 + this.compressedData.getInt(i);
      int m = i + 4;
      int n;
      if (j == paramInt1)
      {
        n = m;
        for (int i1 = 0; i1 < this.numberOfFaces; i1++)
        {
          if (i1 == paramInt2)
          {
            this.compressedData.position(n);
            ByteBuffer localByteBuffer = this.compressedData.slice();
            localByteBuffer.limit(k);
            return localByteBuffer;
          }
          n += k;
        }
      }
      for (i = n; ; i = m + k * this.numberOfFaces)
      {
        j++;
        break;
      }
    }
    return null;
  }

  public Pixmap.Format getFormat()
  {
    throw new GdxRuntimeException("This TextureData implementation directly handles texture formats.");
  }

  public int getGlInternalFormat()
  {
    return this.glInternalFormat;
  }

  public int getHeight()
  {
    return this.pixelHeight;
  }

  public int getNumberOfFaces()
  {
    return this.numberOfFaces;
  }

  public int getNumberOfMipMapLevels()
  {
    return this.numberOfMipmapLevels;
  }

  public TextureData.TextureDataType getType()
  {
    return TextureData.TextureDataType.Custom;
  }

  public int getWidth()
  {
    return this.pixelWidth;
  }

  public boolean isManaged()
  {
    return true;
  }

  public boolean isPrepared()
  {
    return this.compressedData != null;
  }

  // ERROR //
  public void prepare()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   4: ifnull +14 -> 18
    //   7: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   10: dup
    //   11: ldc_w 269
    //   14: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: getfield 45	com/badlogic/gdx/graphics/glutils/KTXTextureData:file	Lcom/badlogic/gdx/files/FileHandle;
    //   22: ifnonnull +14 -> 36
    //   25: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   28: dup
    //   29: ldc_w 271
    //   32: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: aload_0
    //   37: getfield 45	com/badlogic/gdx/graphics/glutils/KTXTextureData:file	Lcom/badlogic/gdx/files/FileHandle;
    //   40: invokevirtual 276	com/badlogic/gdx/files/FileHandle:name	()Ljava/lang/String;
    //   43: ldc_w 278
    //   46: invokevirtual 283	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   49: ifeq +191 -> 240
    //   52: sipush 10240
    //   55: newarray byte
    //   57: astore 12
    //   59: new 285	java/io/DataInputStream
    //   62: dup
    //   63: new 287	java/io/BufferedInputStream
    //   66: dup
    //   67: new 289	java/util/zip/GZIPInputStream
    //   70: dup
    //   71: aload_0
    //   72: getfield 45	com/badlogic/gdx/graphics/glutils/KTXTextureData:file	Lcom/badlogic/gdx/files/FileHandle;
    //   75: invokevirtual 293	com/badlogic/gdx/files/FileHandle:read	()Ljava/io/InputStream;
    //   78: invokespecial 296	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: invokespecial 297	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 298	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore 13
    //   89: aload_0
    //   90: aload 13
    //   92: invokevirtual 301	java/io/DataInputStream:readInt	()I
    //   95: invokestatic 305	com/badlogic/gdx/utils/BufferUtils:newUnsafeByteBuffer	(I)Ljava/nio/ByteBuffer;
    //   98: putfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   101: aload 13
    //   103: aload 12
    //   105: invokevirtual 308	java/io/DataInputStream:read	([B)I
    //   108: istore 17
    //   110: iload 17
    //   112: iconst_m1
    //   113: if_icmpeq +75 -> 188
    //   116: aload_0
    //   117: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   120: aload 12
    //   122: iconst_0
    //   123: iload 17
    //   125: invokevirtual 312	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   128: pop
    //   129: goto -28 -> 101
    //   132: astore 15
    //   134: aload 13
    //   136: astore 16
    //   138: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   141: dup
    //   142: new 202	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 314
    //   149: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield 45	com/badlogic/gdx/graphics/glutils/KTXTextureData:file	Lcom/badlogic/gdx/files/FileHandle;
    //   156: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 319
    //   162: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload 15
    //   170: invokespecial 322	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: athrow
    //   174: astore 14
    //   176: aload 16
    //   178: astore 13
    //   180: aload 13
    //   182: invokestatic 328	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   185: aload 14
    //   187: athrow
    //   188: aload_0
    //   189: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   192: iconst_0
    //   193: invokevirtual 130	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   196: pop
    //   197: aload_0
    //   198: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   201: aload_0
    //   202: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   205: invokevirtual 331	java/nio/ByteBuffer:capacity	()I
    //   208: invokevirtual 141	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   211: pop
    //   212: aload 13
    //   214: invokestatic 328	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   217: aload_0
    //   218: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   221: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   224: bipush 171
    //   226: if_icmpeq +31 -> 257
    //   229: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   232: dup
    //   233: ldc_w 336
    //   236: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   239: athrow
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 45	com/badlogic/gdx/graphics/glutils/KTXTextureData:file	Lcom/badlogic/gdx/files/FileHandle;
    //   245: invokevirtual 340	com/badlogic/gdx/files/FileHandle:readBytes	()[B
    //   248: invokestatic 344	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: putfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   254: goto -37 -> 217
    //   257: aload_0
    //   258: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   261: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   264: bipush 75
    //   266: if_icmpeq +14 -> 280
    //   269: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   272: dup
    //   273: ldc_w 336
    //   276: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   279: athrow
    //   280: aload_0
    //   281: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   284: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   287: bipush 84
    //   289: if_icmpeq +14 -> 303
    //   292: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   295: dup
    //   296: ldc_w 336
    //   299: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   302: athrow
    //   303: aload_0
    //   304: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   307: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   310: bipush 88
    //   312: if_icmpeq +14 -> 326
    //   315: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   318: dup
    //   319: ldc_w 336
    //   322: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   325: athrow
    //   326: aload_0
    //   327: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   330: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   333: bipush 32
    //   335: if_icmpeq +14 -> 349
    //   338: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   341: dup
    //   342: ldc_w 336
    //   345: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   348: athrow
    //   349: aload_0
    //   350: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   353: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   356: bipush 49
    //   358: if_icmpeq +14 -> 372
    //   361: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   364: dup
    //   365: ldc_w 336
    //   368: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   371: athrow
    //   372: aload_0
    //   373: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   376: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   379: bipush 49
    //   381: if_icmpeq +14 -> 395
    //   384: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   387: dup
    //   388: ldc_w 336
    //   391: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   394: athrow
    //   395: aload_0
    //   396: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   399: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   402: bipush 187
    //   404: if_icmpeq +14 -> 418
    //   407: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   410: dup
    //   411: ldc_w 336
    //   414: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   417: athrow
    //   418: aload_0
    //   419: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   422: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   425: bipush 13
    //   427: if_icmpeq +14 -> 441
    //   430: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   433: dup
    //   434: ldc_w 336
    //   437: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   440: athrow
    //   441: aload_0
    //   442: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   445: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   448: bipush 10
    //   450: if_icmpeq +14 -> 464
    //   453: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   456: dup
    //   457: ldc_w 336
    //   460: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   463: athrow
    //   464: aload_0
    //   465: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   468: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   471: bipush 26
    //   473: if_icmpeq +14 -> 487
    //   476: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   479: dup
    //   480: ldc_w 336
    //   483: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   486: athrow
    //   487: aload_0
    //   488: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   491: invokevirtual 334	java/nio/ByteBuffer:get	()B
    //   494: bipush 10
    //   496: if_icmpeq +14 -> 510
    //   499: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   502: dup
    //   503: ldc_w 336
    //   506: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   509: athrow
    //   510: aload_0
    //   511: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   514: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   517: istore_1
    //   518: iload_1
    //   519: ldc_w 345
    //   522: if_icmpeq +21 -> 543
    //   525: iload_1
    //   526: ldc_w 346
    //   529: if_icmpeq +14 -> 543
    //   532: new 57	com/badlogic/gdx/utils/GdxRuntimeException
    //   535: dup
    //   536: ldc_w 336
    //   539: invokespecial 62	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;)V
    //   542: athrow
    //   543: iload_1
    //   544: ldc_w 345
    //   547: if_icmpeq +35 -> 582
    //   550: aload_0
    //   551: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   554: astore 9
    //   556: aload_0
    //   557: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   560: invokevirtual 350	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   563: getstatic 356	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   566: if_acmpne +227 -> 793
    //   569: getstatic 359	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   572: astore 10
    //   574: aload 9
    //   576: aload 10
    //   578: invokevirtual 362	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   581: pop
    //   582: aload_0
    //   583: aload_0
    //   584: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   587: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   590: putfield 70	com/badlogic/gdx/graphics/glutils/KTXTextureData:glType	I
    //   593: aload_0
    //   594: aload_0
    //   595: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   598: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   601: putfield 364	com/badlogic/gdx/graphics/glutils/KTXTextureData:glTypeSize	I
    //   604: aload_0
    //   605: aload_0
    //   606: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   609: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   612: putfield 72	com/badlogic/gdx/graphics/glutils/KTXTextureData:glFormat	I
    //   615: aload_0
    //   616: aload_0
    //   617: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   620: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   623: putfield 114	com/badlogic/gdx/graphics/glutils/KTXTextureData:glInternalFormat	I
    //   626: aload_0
    //   627: aload_0
    //   628: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   631: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   634: putfield 366	com/badlogic/gdx/graphics/glutils/KTXTextureData:glBaseInternalFormat	I
    //   637: aload_0
    //   638: aload_0
    //   639: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   642: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   645: putfield 39	com/badlogic/gdx/graphics/glutils/KTXTextureData:pixelWidth	I
    //   648: aload_0
    //   649: aload_0
    //   650: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   653: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   656: putfield 41	com/badlogic/gdx/graphics/glutils/KTXTextureData:pixelHeight	I
    //   659: aload_0
    //   660: aload_0
    //   661: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   664: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   667: putfield 43	com/badlogic/gdx/graphics/glutils/KTXTextureData:pixelDepth	I
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   675: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   678: putfield 78	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfArrayElements	I
    //   681: aload_0
    //   682: aload_0
    //   683: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   686: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   689: putfield 76	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfFaces	I
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   697: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   700: putfield 118	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfMipmapLevels	I
    //   703: aload_0
    //   704: getfield 118	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfMipmapLevels	I
    //   707: ifne +13 -> 720
    //   710: aload_0
    //   711: iconst_1
    //   712: putfield 118	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfMipmapLevels	I
    //   715: aload_0
    //   716: iconst_1
    //   717: putfield 47	com/badlogic/gdx/graphics/glutils/KTXTextureData:useMipMaps	Z
    //   720: aload_0
    //   721: aload_0
    //   722: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   725: invokevirtual 134	java/nio/ByteBuffer:getInt	()I
    //   728: aload_0
    //   729: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   732: invokevirtual 368	java/nio/ByteBuffer:position	()I
    //   735: iadd
    //   736: putfield 116	com/badlogic/gdx/graphics/glutils/KTXTextureData:imagePos	I
    //   739: aload_0
    //   740: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   743: invokevirtual 371	java/nio/ByteBuffer:isDirect	()Z
    //   746: ifne +108 -> 854
    //   749: aload_0
    //   750: getfield 116	com/badlogic/gdx/graphics/glutils/KTXTextureData:imagePos	I
    //   753: istore_2
    //   754: iconst_0
    //   755: istore_3
    //   756: iload_3
    //   757: aload_0
    //   758: getfield 118	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfMipmapLevels	I
    //   761: if_icmpge +40 -> 801
    //   764: iload_2
    //   765: iconst_4
    //   766: bipush 252
    //   768: iconst_3
    //   769: aload_0
    //   770: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   773: iload_2
    //   774: invokevirtual 247	java/nio/ByteBuffer:getInt	(I)I
    //   777: iadd
    //   778: iand
    //   779: aload_0
    //   780: getfield 76	com/badlogic/gdx/graphics/glutils/KTXTextureData:numberOfFaces	I
    //   783: imul
    //   784: iadd
    //   785: iadd
    //   786: istore_2
    //   787: iinc 3 1
    //   790: goto -34 -> 756
    //   793: getstatic 356	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   796: astore 10
    //   798: goto -224 -> 574
    //   801: aload_0
    //   802: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   805: iload_2
    //   806: invokevirtual 141	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   809: pop
    //   810: aload_0
    //   811: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   814: iconst_0
    //   815: invokevirtual 130	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   818: pop
    //   819: iload_2
    //   820: invokestatic 305	com/badlogic/gdx/utils/BufferUtils:newUnsafeByteBuffer	(I)Ljava/nio/ByteBuffer;
    //   823: astore 6
    //   825: aload 6
    //   827: aload_0
    //   828: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   831: invokevirtual 350	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   834: invokevirtual 362	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   837: pop
    //   838: aload 6
    //   840: aload_0
    //   841: getfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   844: invokevirtual 374	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   847: pop
    //   848: aload_0
    //   849: aload 6
    //   851: putfield 55	com/badlogic/gdx/graphics/glutils/KTXTextureData:compressedData	Ljava/nio/ByteBuffer;
    //   854: return
    //   855: astore 14
    //   857: aconst_null
    //   858: astore 13
    //   860: goto -680 -> 180
    //   863: astore 14
    //   865: goto -685 -> 180
    //   868: astore 15
    //   870: aconst_null
    //   871: astore 16
    //   873: goto -735 -> 138
    //
    // Exception table:
    //   from	to	target	type
    //   89	101	132	java/lang/Exception
    //   101	110	132	java/lang/Exception
    //   116	129	132	java/lang/Exception
    //   188	212	132	java/lang/Exception
    //   138	174	174	finally
    //   59	89	855	finally
    //   89	101	863	finally
    //   101	110	863	finally
    //   116	129	863	finally
    //   188	212	863	finally
    //   59	89	868	java/lang/Exception
  }

  public boolean useMipMaps()
  {
    return this.useMipMaps;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.KTXTextureData
 * JD-Core Version:    0.6.0
 */