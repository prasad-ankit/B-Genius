package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import java.nio.ByteBuffer;

public final class ETC1$ETC1Data
  implements Disposable
{
  public final ByteBuffer compressedData;
  public final int dataOffset;
  public final int height;
  public final int width;

  public ETC1$ETC1Data(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.compressedData = paramByteBuffer;
    this.dataOffset = paramInt3;
    checkNPOT();
  }

  // ERROR //
  public ETC1$ETC1Data(com.badlogic.gdx.files.FileHandle paramFileHandle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 17	java/lang/Object:<init>	()V
    //   4: sipush 10240
    //   7: newarray byte
    //   9: astore_2
    //   10: new 33	java/io/DataInputStream
    //   13: dup
    //   14: new 35	java/io/BufferedInputStream
    //   17: dup
    //   18: new 37	java/util/zip/GZIPInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokevirtual 43	com/badlogic/gdx/files/FileHandle:read	()Ljava/io/InputStream;
    //   26: invokespecial 46	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: invokespecial 47	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: invokespecial 48	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 52	java/io/DataInputStream:readInt	()I
    //   41: invokestatic 58	com/badlogic/gdx/utils/BufferUtils:newUnsafeByteBuffer	(I)Ljava/nio/ByteBuffer;
    //   44: putfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 61	java/io/DataInputStream:read	([B)I
    //   52: istore 6
    //   54: iload 6
    //   56: iconst_m1
    //   57: if_icmpeq +60 -> 117
    //   60: aload_0
    //   61: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   64: aload_2
    //   65: iconst_0
    //   66: iload 6
    //   68: invokevirtual 67	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   71: pop
    //   72: goto -25 -> 47
    //   75: astore 5
    //   77: new 69	com/badlogic/gdx/utils/GdxRuntimeException
    //   80: dup
    //   81: new 71	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 73
    //   87: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: ldc 82
    //   96: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload 5
    //   104: invokespecial 92	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: athrow
    //   108: astore 4
    //   110: aload_3
    //   111: invokestatic 98	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   114: aload 4
    //   116: athrow
    //   117: aload_0
    //   118: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   121: iconst_0
    //   122: invokevirtual 102	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   125: pop
    //   126: aload_0
    //   127: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   130: aload_0
    //   131: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   134: invokevirtual 105	java/nio/ByteBuffer:capacity	()I
    //   137: invokevirtual 108	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   140: pop
    //   141: aload_3
    //   142: invokestatic 98	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   150: iconst_0
    //   151: invokestatic 114	com/badlogic/gdx/graphics/glutils/ETC1:getWidthPKM	(Ljava/nio/ByteBuffer;I)I
    //   154: putfield 19	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:width	I
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   162: iconst_0
    //   163: invokestatic 117	com/badlogic/gdx/graphics/glutils/ETC1:getHeightPKM	(Ljava/nio/ByteBuffer;I)I
    //   166: putfield 21	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:height	I
    //   169: aload_0
    //   170: getstatic 120	com/badlogic/gdx/graphics/glutils/ETC1:PKM_HEADER_SIZE	I
    //   173: putfield 25	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:dataOffset	I
    //   176: aload_0
    //   177: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   180: aload_0
    //   181: getfield 25	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:dataOffset	I
    //   184: invokevirtual 102	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   187: pop
    //   188: aload_0
    //   189: invokespecial 28	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:checkNPOT	()V
    //   192: return
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_3
    //   197: goto -87 -> 110
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_3
    //   204: goto -127 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   36	47	75	java/lang/Exception
    //   47	54	75	java/lang/Exception
    //   60	72	75	java/lang/Exception
    //   117	141	75	java/lang/Exception
    //   36	47	108	finally
    //   47	54	108	finally
    //   60	72	108	finally
    //   77	108	108	finally
    //   117	141	108	finally
    //   10	36	193	finally
    //   10	36	200	java/lang/Exception
  }

  private void checkNPOT()
  {
    if ((!MathUtils.isPowerOfTwo(this.width)) || (!MathUtils.isPowerOfTwo(this.height)))
      Gdx.app.debug("ETC1Data", "warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
  }

  public final void dispose()
  {
    BufferUtils.disposeUnsafeByteBuffer(this.compressedData);
  }

  public final boolean hasPKMHeader()
  {
    return this.dataOffset == 16;
  }

  public final String toString()
  {
    if (hasPKMHeader())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (ETC1.isValidPKM(this.compressedData, 0));
      for (String str = "valid"; ; str = "invalid")
        return str + " pkm [" + ETC1.getWidthPKM(this.compressedData, 0) + "x" + ETC1.getHeightPKM(this.compressedData, 0) + "], compressed: " + (this.compressedData.capacity() - ETC1.PKM_HEADER_SIZE);
    }
    return "raw [" + this.width + "x" + this.height + "], compressed: " + (this.compressedData.capacity() - ETC1.PKM_HEADER_SIZE);
  }

  // ERROR //
  public final void write(com.badlogic.gdx.files.FileHandle paramFileHandle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: sipush 10240
    //   5: newarray byte
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   12: iconst_0
    //   13: invokevirtual 102	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   16: pop
    //   17: aload_0
    //   18: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   21: aload_0
    //   22: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   25: invokevirtual 105	java/nio/ByteBuffer:capacity	()I
    //   28: invokevirtual 108	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   31: pop
    //   32: new 174	java/io/DataOutputStream
    //   35: dup
    //   36: new 176	java/util/zip/GZIPOutputStream
    //   39: dup
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 179	com/badlogic/gdx/files/FileHandle:write	(Z)Ljava/io/OutputStream;
    //   45: invokespecial 182	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: invokespecial 183	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: astore 6
    //   53: aload 6
    //   55: aload_0
    //   56: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   59: invokevirtual 105	java/nio/ByteBuffer:capacity	()I
    //   62: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   65: iload_2
    //   66: aload_0
    //   67: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   70: invokevirtual 105	java/nio/ByteBuffer:capacity	()I
    //   73: if_icmpeq +47 -> 120
    //   76: aload_0
    //   77: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   80: invokevirtual 190	java/nio/ByteBuffer:remaining	()I
    //   83: sipush 10240
    //   86: invokestatic 196	java/lang/Math:min	(II)I
    //   89: istore 11
    //   91: aload_0
    //   92: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   95: aload_3
    //   96: iconst_0
    //   97: iload 11
    //   99: invokevirtual 199	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   102: pop
    //   103: aload 6
    //   105: aload_3
    //   106: iconst_0
    //   107: iload 11
    //   109: invokevirtual 202	java/io/DataOutputStream:write	([BII)V
    //   112: iload_2
    //   113: iload 11
    //   115: iadd
    //   116: istore_2
    //   117: goto -52 -> 65
    //   120: aload 6
    //   122: invokestatic 98	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   125: aload_0
    //   126: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   129: aload_0
    //   130: getfield 25	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:dataOffset	I
    //   133: invokevirtual 102	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   136: pop
    //   137: aload_0
    //   138: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   141: aload_0
    //   142: getfield 23	com/badlogic/gdx/graphics/glutils/ETC1$ETC1Data:compressedData	Ljava/nio/ByteBuffer;
    //   145: invokevirtual 105	java/nio/ByteBuffer:capacity	()I
    //   148: invokevirtual 108	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   151: pop
    //   152: return
    //   153: astore 7
    //   155: aconst_null
    //   156: astore 6
    //   158: new 69	com/badlogic/gdx/utils/GdxRuntimeException
    //   161: dup
    //   162: new 71	java/lang/StringBuilder
    //   165: dup
    //   166: ldc 204
    //   168: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_1
    //   172: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: ldc 82
    //   177: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload 7
    //   185: invokespecial 92	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore 8
    //   191: aload 6
    //   193: invokestatic 98	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   196: aload 8
    //   198: athrow
    //   199: astore 8
    //   201: aconst_null
    //   202: astore 6
    //   204: goto -13 -> 191
    //   207: astore 7
    //   209: goto -51 -> 158
    //
    // Exception table:
    //   from	to	target	type
    //   32	53	153	java/lang/Exception
    //   53	65	189	finally
    //   65	112	189	finally
    //   158	189	189	finally
    //   32	53	199	finally
    //   53	65	207	java/lang/Exception
    //   65	112	207	java/lang/Exception
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data
 * JD-Core Version:    0.6.0
 */