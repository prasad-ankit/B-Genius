package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.DataInputStream;

public class UBJsonReader
  implements BaseJsonReader
{
  public boolean oldFormat = true;

  public JsonValue parse(FileHandle paramFileHandle)
  {
    try
    {
      JsonValue localJsonValue = parse(paramFileHandle.read(8192));
      return localJsonValue;
    }
    catch (Exception localException)
    {
    }
    throw new SerializationException("Error parsing file: " + paramFileHandle, localException);
  }

  public JsonValue parse(DataInputStream paramDataInputStream)
  {
    try
    {
      JsonValue localJsonValue = parse(paramDataInputStream, paramDataInputStream.readByte());
      return localJsonValue;
    }
    finally
    {
      StreamUtils.closeQuietly(paramDataInputStream);
    }
    throw localObject;
  }

  protected JsonValue parse(DataInputStream paramDataInputStream, byte paramByte)
  {
    if (paramByte == 91)
      return parseArray(paramDataInputStream);
    if (paramByte == 123)
      return parseObject(paramDataInputStream);
    if (paramByte == 90)
      return new JsonValue(JsonValue.ValueType.nullValue);
    if (paramByte == 84)
      return new JsonValue(true);
    if (paramByte == 70)
      return new JsonValue(false);
    if (paramByte == 66)
      return new JsonValue(readUChar(paramDataInputStream));
    if (paramByte == 85)
      return new JsonValue(readUChar(paramDataInputStream));
    if (paramByte == 105)
    {
      long l2;
      if (this.oldFormat)
        l2 = paramDataInputStream.readShort();
      while (true)
      {
        return new JsonValue(l2);
        l2 = paramDataInputStream.readByte();
      }
    }
    if (paramByte == 73)
    {
      long l1;
      if (this.oldFormat)
        l1 = paramDataInputStream.readInt();
      while (true)
      {
        return new JsonValue(l1);
        l1 = paramDataInputStream.readShort();
      }
    }
    if (paramByte == 108)
      return new JsonValue(paramDataInputStream.readInt());
    if (paramByte == 76)
      return new JsonValue(paramDataInputStream.readLong());
    if (paramByte == 100)
      return new JsonValue(paramDataInputStream.readFloat());
    if (paramByte == 68)
      return new JsonValue(paramDataInputStream.readDouble());
    if ((paramByte == 115) || (paramByte == 83))
      return new JsonValue(parseString(paramDataInputStream, paramByte));
    if ((paramByte == 97) || (paramByte == 65))
      return parseData(paramDataInputStream, paramByte);
    throw new GdxRuntimeException("Unrecognized data type");
  }

  // ERROR //
  public JsonValue parse(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 50	java/io/DataInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 131	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_2
    //   9: aload_0
    //   10: aload_2
    //   11: invokevirtual 133	com/badlogic/gdx/utils/UBJsonReader:parse	(Ljava/io/DataInputStream;)Lcom/badlogic/gdx/utils/JsonValue;
    //   14: astore 5
    //   16: aload_2
    //   17: invokestatic 63	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   20: aload 5
    //   22: areturn
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_2
    //   26: new 29	com/badlogic/gdx/utils/SerializationException
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 136	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   34: athrow
    //   35: astore 4
    //   37: aload_2
    //   38: invokestatic 63	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   41: aload 4
    //   43: athrow
    //   44: astore 4
    //   46: aconst_null
    //   47: astore_2
    //   48: goto -11 -> 37
    //   51: astore_3
    //   52: goto -26 -> 26
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	23	java/io/IOException
    //   9	16	35	finally
    //   26	35	35	finally
    //   0	9	44	finally
    //   9	16	51	java/io/IOException
  }

  protected JsonValue parseArray(DataInputStream paramDataInputStream)
  {
    long l1 = -1L;
    JsonValue localJsonValue1 = new JsonValue(JsonValue.ValueType.array);
    byte b1 = paramDataInputStream.readByte();
    byte b2;
    if (b1 == 36)
    {
      b2 = paramDataInputStream.readByte();
      b1 = paramDataInputStream.readByte();
    }
    while (true)
    {
      byte b3;
      Object localObject;
      label102: JsonValue localJsonValue2;
      if (b1 == 35)
      {
        l1 = parseSize(paramDataInputStream, false, l1);
        if (l1 < 0L)
          throw new GdxRuntimeException("Unrecognized data type");
        if (l1 == 0L)
          return localJsonValue1;
        if (b2 == 0)
          b1 = paramDataInputStream.readByte();
      }
      else
      {
        b3 = b1;
        localObject = null;
        long l2 = 0L;
        if ((paramDataInputStream.available() <= 0) || (b3 == 93))
          break label227;
        localJsonValue2 = parse(paramDataInputStream, b3);
        if (localObject == null)
          break label204;
        localJsonValue2.prev = localObject;
        localObject.next = localJsonValue2;
        localJsonValue1.size = (1 + localJsonValue1.size);
        label156: if (l1 > 0L)
        {
          l2 += 1L;
          if (l2 >= l1)
            break label227;
        }
        if (b2 != 0)
          break label220;
      }
      label204: label220: for (byte b4 = paramDataInputStream.readByte(); ; b4 = b2)
      {
        b3 = b4;
        localObject = localJsonValue2;
        break label102;
        b1 = b2;
        break;
        localJsonValue1.child = localJsonValue2;
        localJsonValue1.size = 1;
        break label156;
      }
      label227: return localJsonValue1;
      b2 = 0;
    }
  }

  protected JsonValue parseData(DataInputStream paramDataInputStream, byte paramByte)
  {
    byte b = paramDataInputStream.readByte();
    long l1;
    JsonValue localJsonValue1;
    Object localObject;
    long l2;
    label36: JsonValue localJsonValue2;
    if (paramByte == 65)
    {
      l1 = readUInt(paramDataInputStream);
      localJsonValue1 = new JsonValue(JsonValue.ValueType.array);
      localObject = null;
      l2 = 0L;
      if (l2 >= l1)
        break label116;
      localJsonValue2 = parse(paramDataInputStream, b);
      if (localObject == null)
        break label100;
      localObject.next = localJsonValue2;
    }
    for (localJsonValue1.size = (1 + localJsonValue1.size); ; localJsonValue1.size = 1)
    {
      l2 += 1L;
      localObject = localJsonValue2;
      break label36;
      l1 = readUChar(paramDataInputStream);
      break;
      label100: localJsonValue1.child = localJsonValue2;
    }
    label116: return localJsonValue1;
  }

  protected JsonValue parseObject(DataInputStream paramDataInputStream)
  {
    long l1 = -1L;
    JsonValue localJsonValue1 = new JsonValue(JsonValue.ValueType.object);
    byte b1 = paramDataInputStream.readByte();
    byte b2;
    if (b1 == 36)
    {
      b2 = paramDataInputStream.readByte();
      b1 = paramDataInputStream.readByte();
    }
    while (true)
    {
      if (b1 == 35)
      {
        l1 = parseSize(paramDataInputStream, false, l1);
        if (l1 < 0L)
          throw new GdxRuntimeException("Unrecognized data type");
        if (l1 == 0L)
          return localJsonValue1;
        b1 = paramDataInputStream.readByte();
      }
      Object localObject = null;
      byte b3 = b1;
      long l2 = 0L;
      if ((paramDataInputStream.available() > 0) && (b3 != 125))
      {
        String str = parseString(paramDataInputStream, true, b3);
        byte b4;
        label132: JsonValue localJsonValue2;
        if (b2 == 0)
        {
          b4 = paramDataInputStream.readByte();
          localJsonValue2 = parse(paramDataInputStream, b4);
          localJsonValue2.setName(str);
          if (localObject == null)
            break label218;
          localJsonValue2.prev = localObject;
          localObject.next = localJsonValue2;
        }
        for (localJsonValue1.size = (1 + localJsonValue1.size); ; localJsonValue1.size = 1)
        {
          if (l1 > 0L)
          {
            l2 += 1L;
            if (l2 >= l1)
              break label234;
          }
          b3 = paramDataInputStream.readByte();
          localObject = localJsonValue2;
          break;
          b4 = b2;
          break label132;
          label218: localJsonValue1.child = localJsonValue2;
        }
      }
      label234: return localJsonValue1;
      b2 = 0;
    }
  }

  protected long parseSize(DataInputStream paramDataInputStream, byte paramByte, boolean paramBoolean, long paramLong)
  {
    if (paramByte == 105)
      paramLong = readUChar(paramDataInputStream);
    do
    {
      return paramLong;
      if (paramByte == 73)
        return readUShort(paramDataInputStream);
      if (paramByte == 108)
        return readUInt(paramDataInputStream);
      if (paramByte == 76)
        return paramDataInputStream.readLong();
    }
    while (!paramBoolean);
    return (0xFF & (short)paramByte) << 24 | (0xFF & (short)paramDataInputStream.readByte()) << 16 | (0xFF & (short)paramDataInputStream.readByte()) << 8 | 0xFF & (short)paramDataInputStream.readByte();
  }

  protected long parseSize(DataInputStream paramDataInputStream, boolean paramBoolean, long paramLong)
  {
    return parseSize(paramDataInputStream, paramDataInputStream.readByte(), paramBoolean, paramLong);
  }

  protected String parseString(DataInputStream paramDataInputStream, byte paramByte)
  {
    return parseString(paramDataInputStream, false, paramByte);
  }

  protected String parseString(DataInputStream paramDataInputStream, boolean paramBoolean, byte paramByte)
  {
    long l = -1L;
    if (paramByte == 83)
      l = parseSize(paramDataInputStream, true, l);
    while (l < 0L)
    {
      throw new GdxRuntimeException("Unrecognized data type, string expected");
      if (paramByte == 115)
      {
        l = readUChar(paramDataInputStream);
        continue;
      }
      if (!paramBoolean)
        continue;
      l = parseSize(paramDataInputStream, paramByte, false, l);
    }
    if (l > 0L)
      return readString(paramDataInputStream, l);
    return "";
  }

  protected String readString(DataInputStream paramDataInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[(int)paramLong];
    paramDataInputStream.readFully(arrayOfByte);
    return new String(arrayOfByte, "UTF-8");
  }

  protected short readUChar(DataInputStream paramDataInputStream)
  {
    return (short)(0xFF & (short)paramDataInputStream.readByte());
  }

  protected long readUInt(DataInputStream paramDataInputStream)
  {
    return paramDataInputStream.readInt();
  }

  protected int readUShort(DataInputStream paramDataInputStream)
  {
    return 0xFFFF & paramDataInputStream.readShort();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.UBJsonReader
 * JD-Core Version:    0.6.0
 */