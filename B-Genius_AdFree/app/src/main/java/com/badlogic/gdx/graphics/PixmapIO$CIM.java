package com.badlogic.gdx.graphics;

class PixmapIO$CIM
{
  private static final int BUFFER_SIZE = 32000;
  private static final byte[] readBuffer;
  private static final byte[] writeBuffer = new byte[32000];

  static
  {
    readBuffer = new byte[32000];
  }

  // ERROR //
  public static Pixmap read(com.badlogic.gdx.files.FileHandle paramFileHandle)
  {
    // Byte code:
    //   0: new 25	java/io/DataInputStream
    //   3: dup
    //   4: new 27	java/util/zip/InflaterInputStream
    //   7: dup
    //   8: new 29	java/io/BufferedInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 34	com/badlogic/gdx/files/FileHandle:read	()Ljava/io/InputStream;
    //   16: invokespecial 37	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: invokespecial 38	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 39	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_1
    //   26: new 41	com/badlogic/gdx/graphics/Pixmap
    //   29: dup
    //   30: aload_1
    //   31: invokevirtual 45	java/io/DataInputStream:readInt	()I
    //   34: aload_1
    //   35: invokevirtual 45	java/io/DataInputStream:readInt	()I
    //   38: aload_1
    //   39: invokevirtual 45	java/io/DataInputStream:readInt	()I
    //   42: invokestatic 51	com/badlogic/gdx/graphics/Pixmap$Format:fromGdx2DPixmapFormat	(I)Lcom/badlogic/gdx/graphics/Pixmap$Format;
    //   45: invokespecial 54	com/badlogic/gdx/graphics/Pixmap:<init>	(IILcom/badlogic/gdx/graphics/Pixmap$Format;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 58	com/badlogic/gdx/graphics/Pixmap:getPixels	()Ljava/nio/ByteBuffer;
    //   53: astore 5
    //   55: aload 5
    //   57: iconst_0
    //   58: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   61: pop
    //   62: aload 5
    //   64: aload 5
    //   66: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   69: invokevirtual 70	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   72: pop
    //   73: getstatic 16	com/badlogic/gdx/graphics/PixmapIO$CIM:readBuffer	[B
    //   76: astore 8
    //   78: aload 8
    //   80: monitorenter
    //   81: aload_1
    //   82: getstatic 16	com/badlogic/gdx/graphics/PixmapIO$CIM:readBuffer	[B
    //   85: invokevirtual 73	java/io/DataInputStream:read	([B)I
    //   88: istore 10
    //   90: iload 10
    //   92: ifle +66 -> 158
    //   95: aload 5
    //   97: getstatic 16	com/badlogic/gdx/graphics/PixmapIO$CIM:readBuffer	[B
    //   100: iconst_0
    //   101: iload 10
    //   103: invokevirtual 77	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   106: pop
    //   107: goto -26 -> 81
    //   110: astore 9
    //   112: aload 8
    //   114: monitorexit
    //   115: aload 9
    //   117: athrow
    //   118: astore 4
    //   120: new 79	com/badlogic/gdx/utils/GdxRuntimeException
    //   123: dup
    //   124: new 81	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 83
    //   130: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: ldc 92
    //   139: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload 4
    //   147: invokespecial 102	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: athrow
    //   151: astore_3
    //   152: aload_1
    //   153: invokestatic 108	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   156: aload_3
    //   157: athrow
    //   158: aload 8
    //   160: monitorexit
    //   161: aload 5
    //   163: iconst_0
    //   164: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   167: pop
    //   168: aload 5
    //   170: aload 5
    //   172: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   175: invokevirtual 70	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   178: pop
    //   179: aload_1
    //   180: invokestatic 108	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   183: aload_2
    //   184: areturn
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -36 -> 152
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_1
    //   195: goto -75 -> 120
    //
    // Exception table:
    //   from	to	target	type
    //   81	90	110	finally
    //   95	107	110	finally
    //   112	115	110	finally
    //   158	161	110	finally
    //   26	81	118	java/lang/Exception
    //   115	118	118	java/lang/Exception
    //   161	179	118	java/lang/Exception
    //   26	81	151	finally
    //   115	118	151	finally
    //   120	151	151	finally
    //   161	179	151	finally
    //   0	26	185	finally
    //   0	26	191	java/lang/Exception
  }

  // ERROR //
  public static void write(com.badlogic.gdx.files.FileHandle paramFileHandle, Pixmap paramPixmap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 112	java/io/DataOutputStream
    //   5: dup
    //   6: new 114	java/util/zip/DeflaterOutputStream
    //   9: dup
    //   10: aload_0
    //   11: iconst_0
    //   12: invokevirtual 117	com/badlogic/gdx/files/FileHandle:write	(Z)Ljava/io/OutputStream;
    //   15: invokespecial 120	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: invokespecial 121	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_3
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 124	com/badlogic/gdx/graphics/Pixmap:getWidth	()I
    //   27: invokevirtual 128	java/io/DataOutputStream:writeInt	(I)V
    //   30: aload_3
    //   31: aload_1
    //   32: invokevirtual 131	com/badlogic/gdx/graphics/Pixmap:getHeight	()I
    //   35: invokevirtual 128	java/io/DataOutputStream:writeInt	(I)V
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 135	com/badlogic/gdx/graphics/Pixmap:getFormat	()Lcom/badlogic/gdx/graphics/Pixmap$Format;
    //   43: invokestatic 139	com/badlogic/gdx/graphics/Pixmap$Format:toGdx2DPixmapFormat	(Lcom/badlogic/gdx/graphics/Pixmap$Format;)I
    //   46: invokevirtual 128	java/io/DataOutputStream:writeInt	(I)V
    //   49: aload_1
    //   50: invokevirtual 58	com/badlogic/gdx/graphics/Pixmap:getPixels	()Ljava/nio/ByteBuffer;
    //   53: astore 6
    //   55: aload 6
    //   57: iconst_0
    //   58: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   61: pop
    //   62: aload 6
    //   64: aload 6
    //   66: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   69: invokevirtual 70	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   72: pop
    //   73: aload 6
    //   75: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   78: sipush 32000
    //   81: irem
    //   82: istore 9
    //   84: aload 6
    //   86: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   89: sipush 32000
    //   92: idiv
    //   93: istore 10
    //   95: getstatic 14	com/badlogic/gdx/graphics/PixmapIO$CIM:writeBuffer	[B
    //   98: astore 11
    //   100: aload 11
    //   102: monitorenter
    //   103: iload_2
    //   104: iload 10
    //   106: if_icmpge +25 -> 131
    //   109: aload 6
    //   111: getstatic 14	com/badlogic/gdx/graphics/PixmapIO$CIM:writeBuffer	[B
    //   114: invokevirtual 143	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   117: pop
    //   118: aload_3
    //   119: getstatic 14	com/badlogic/gdx/graphics/PixmapIO$CIM:writeBuffer	[B
    //   122: invokevirtual 146	java/io/DataOutputStream:write	([B)V
    //   125: iinc 2 1
    //   128: goto -25 -> 103
    //   131: aload 6
    //   133: getstatic 14	com/badlogic/gdx/graphics/PixmapIO$CIM:writeBuffer	[B
    //   136: iconst_0
    //   137: iload 9
    //   139: invokevirtual 148	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   142: pop
    //   143: aload_3
    //   144: getstatic 14	com/badlogic/gdx/graphics/PixmapIO$CIM:writeBuffer	[B
    //   147: iconst_0
    //   148: iload 9
    //   150: invokevirtual 151	java/io/DataOutputStream:write	([BII)V
    //   153: aload 11
    //   155: monitorexit
    //   156: aload 6
    //   158: iconst_0
    //   159: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   162: pop
    //   163: aload 6
    //   165: aload 6
    //   167: invokevirtual 67	java/nio/ByteBuffer:capacity	()I
    //   170: invokevirtual 70	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   173: pop
    //   174: aload_3
    //   175: invokestatic 108	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   178: return
    //   179: astore 12
    //   181: aload 11
    //   183: monitorexit
    //   184: aload 12
    //   186: athrow
    //   187: astore 5
    //   189: new 79	com/badlogic/gdx/utils/GdxRuntimeException
    //   192: dup
    //   193: new 81	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 153
    //   199: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: ldc 92
    //   208: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aload 5
    //   216: invokespecial 102	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: athrow
    //   220: astore 4
    //   222: aload_3
    //   223: invokestatic 108	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   226: aload 4
    //   228: athrow
    //   229: astore 4
    //   231: aconst_null
    //   232: astore_3
    //   233: goto -11 -> 222
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -51 -> 189
    //
    // Exception table:
    //   from	to	target	type
    //   109	125	179	finally
    //   131	156	179	finally
    //   181	184	179	finally
    //   22	103	187	java/lang/Exception
    //   156	174	187	java/lang/Exception
    //   184	187	187	java/lang/Exception
    //   22	103	220	finally
    //   156	174	220	finally
    //   184	187	220	finally
    //   189	220	220	finally
    //   2	22	229	finally
    //   2	22	236	java/lang/Exception
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.PixmapIO.CIM
 * JD-Core Version:    0.6.0
 */