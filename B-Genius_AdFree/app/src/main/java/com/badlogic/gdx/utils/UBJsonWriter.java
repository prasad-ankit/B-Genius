package com.badlogic.gdx.utils;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UBJsonWriter
  implements Closeable
{
  private UBJsonWriter.JsonObject current;
  private boolean named;
  final DataOutputStream out;
  private final Array stack = new Array();

  public UBJsonWriter(OutputStream paramOutputStream)
  {
    if (!(paramOutputStream instanceof DataOutputStream));
    for (Object localObject = new DataOutputStream(paramOutputStream); ; localObject = paramOutputStream)
    {
      this.out = ((DataOutputStream)localObject);
      return;
    }
  }

  private void checkName()
  {
    if ((this.current != null) && (!this.current.array))
    {
      if (!this.named)
        throw new IllegalStateException("Name must be set.");
      this.named = false;
    }
  }

  public UBJsonWriter array()
  {
    if ((this.current != null) && (!this.current.array))
    {
      if (!this.named)
        throw new IllegalStateException("Name must be set.");
      this.named = false;
    }
    Array localArray = this.stack;
    UBJsonWriter.JsonObject localJsonObject = new UBJsonWriter.JsonObject(this, true);
    this.current = localJsonObject;
    localArray.add(localJsonObject);
    return this;
  }

  public UBJsonWriter array(String paramString)
  {
    name(paramString).array();
    return this;
  }

  public void close()
  {
    while (this.stack.size > 0)
      pop();
    this.out.close();
  }

  public void flush()
  {
    this.out.flush();
  }

  public UBJsonWriter name(String paramString)
  {
    if ((this.current == null) || (this.current.array))
      throw new IllegalStateException("Current item must be an object.");
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    if (arrayOfByte.length <= 127)
    {
      this.out.writeByte(105);
      this.out.writeByte(arrayOfByte.length);
    }
    while (true)
    {
      this.out.write(arrayOfByte);
      this.named = true;
      return this;
      if (arrayOfByte.length <= 32767)
      {
        this.out.writeByte(73);
        this.out.writeShort(arrayOfByte.length);
        continue;
      }
      this.out.writeByte(108);
      this.out.writeInt(arrayOfByte.length);
    }
  }

  public UBJsonWriter object()
  {
    if ((this.current != null) && (!this.current.array))
    {
      if (!this.named)
        throw new IllegalStateException("Name must be set.");
      this.named = false;
    }
    Array localArray = this.stack;
    UBJsonWriter.JsonObject localJsonObject = new UBJsonWriter.JsonObject(this, false);
    this.current = localJsonObject;
    localArray.add(localJsonObject);
    return this;
  }

  public UBJsonWriter object(String paramString)
  {
    name(paramString).object();
    return this;
  }

  public UBJsonWriter pop()
  {
    return pop(false);
  }

  protected UBJsonWriter pop(boolean paramBoolean)
  {
    if (this.named)
      throw new IllegalStateException("Expected an object, array, or value since a name was set.");
    if (paramBoolean)
    {
      this.stack.pop();
      if (this.stack.size != 0)
        break label64;
    }
    label64: for (UBJsonWriter.JsonObject localJsonObject = null; ; localJsonObject = (UBJsonWriter.JsonObject)this.stack.peek())
    {
      this.current = localJsonObject;
      return this;
      ((UBJsonWriter.JsonObject)this.stack.pop()).close();
      break;
    }
  }

  public UBJsonWriter set(String paramString)
  {
    return name(paramString).value();
  }

  public UBJsonWriter set(String paramString, byte paramByte)
  {
    return name(paramString).value(paramByte);
  }

  public UBJsonWriter set(String paramString, char paramChar)
  {
    return name(paramString).value(paramChar);
  }

  public UBJsonWriter set(String paramString, double paramDouble)
  {
    return name(paramString).value(paramDouble);
  }

  public UBJsonWriter set(String paramString, float paramFloat)
  {
    return name(paramString).value(paramFloat);
  }

  public UBJsonWriter set(String paramString, int paramInt)
  {
    return name(paramString).value(paramInt);
  }

  public UBJsonWriter set(String paramString, long paramLong)
  {
    return name(paramString).value(paramLong);
  }

  public UBJsonWriter set(String paramString1, String paramString2)
  {
    return name(paramString1).value(paramString2);
  }

  public UBJsonWriter set(String paramString, short paramShort)
  {
    return name(paramString).value(paramShort);
  }

  public UBJsonWriter set(String paramString, boolean paramBoolean)
  {
    return name(paramString).value(paramBoolean);
  }

  public UBJsonWriter set(String paramString, byte[] paramArrayOfByte)
  {
    return name(paramString).value(paramArrayOfByte);
  }

  public UBJsonWriter set(String paramString, char[] paramArrayOfChar)
  {
    return name(paramString).value(paramArrayOfChar);
  }

  public UBJsonWriter set(String paramString, double[] paramArrayOfDouble)
  {
    return name(paramString).value(paramArrayOfDouble);
  }

  public UBJsonWriter set(String paramString, float[] paramArrayOfFloat)
  {
    return name(paramString).value(paramArrayOfFloat);
  }

  public UBJsonWriter set(String paramString, int[] paramArrayOfInt)
  {
    return name(paramString).value(paramArrayOfInt);
  }

  public UBJsonWriter set(String paramString, long[] paramArrayOfLong)
  {
    return name(paramString).value(paramArrayOfLong);
  }

  public UBJsonWriter set(String paramString, String[] paramArrayOfString)
  {
    return name(paramString).value(paramArrayOfString);
  }

  public UBJsonWriter set(String paramString, short[] paramArrayOfShort)
  {
    return name(paramString).value(paramArrayOfShort);
  }

  public UBJsonWriter set(String paramString, boolean[] paramArrayOfBoolean)
  {
    return name(paramString).value(paramArrayOfBoolean);
  }

  public UBJsonWriter value()
  {
    checkName();
    this.out.writeByte(90);
    return this;
  }

  public UBJsonWriter value(byte paramByte)
  {
    checkName();
    this.out.writeByte(105);
    this.out.writeByte(paramByte);
    return this;
  }

  public UBJsonWriter value(char paramChar)
  {
    checkName();
    this.out.writeByte(73);
    this.out.writeChar(paramChar);
    return this;
  }

  public UBJsonWriter value(double paramDouble)
  {
    checkName();
    this.out.writeByte(68);
    this.out.writeDouble(paramDouble);
    return this;
  }

  public UBJsonWriter value(float paramFloat)
  {
    checkName();
    this.out.writeByte(100);
    this.out.writeFloat(paramFloat);
    return this;
  }

  public UBJsonWriter value(int paramInt)
  {
    checkName();
    this.out.writeByte(108);
    this.out.writeInt(paramInt);
    return this;
  }

  public UBJsonWriter value(long paramLong)
  {
    checkName();
    this.out.writeByte(76);
    this.out.writeLong(paramLong);
    return this;
  }

  public UBJsonWriter value(JsonValue paramJsonValue)
  {
    if (paramJsonValue.isObject())
    {
      if (paramJsonValue.name != null)
        object(paramJsonValue.name);
      while (true)
      {
        for (JsonValue localJsonValue2 = paramJsonValue.child; localJsonValue2 != null; localJsonValue2 = localJsonValue2.next)
          value(localJsonValue2);
        object();
      }
      pop();
      return this;
    }
    if (paramJsonValue.isArray())
    {
      if (paramJsonValue.name != null)
        array(paramJsonValue.name);
      while (true)
      {
        for (JsonValue localJsonValue1 = paramJsonValue.child; localJsonValue1 != null; localJsonValue1 = localJsonValue1.next)
          value(localJsonValue1);
        array();
      }
      pop();
      return this;
    }
    if (paramJsonValue.isBoolean())
    {
      if (paramJsonValue.name != null)
        name(paramJsonValue.name);
      value(paramJsonValue.asBoolean());
      return this;
    }
    if (paramJsonValue.isDouble())
    {
      if (paramJsonValue.name != null)
        name(paramJsonValue.name);
      value(paramJsonValue.asDouble());
      return this;
    }
    if (paramJsonValue.isLong())
    {
      if (paramJsonValue.name != null)
        name(paramJsonValue.name);
      value(paramJsonValue.asLong());
      return this;
    }
    if (paramJsonValue.isString())
    {
      if (paramJsonValue.name != null)
        name(paramJsonValue.name);
      value(paramJsonValue.asString());
      return this;
    }
    if (paramJsonValue.isNull())
    {
      if (paramJsonValue.name != null)
        name(paramJsonValue.name);
      value();
      return this;
    }
    throw new IOException("Unhandled JsonValue type");
  }

  public UBJsonWriter value(Object paramObject)
  {
    if (paramObject == null)
      this = value();
    while (true)
    {
      return this;
      if (!(paramObject instanceof Number))
        break;
      Number localNumber = (Number)paramObject;
      if ((paramObject instanceof Byte))
        return value(localNumber.byteValue());
      if ((paramObject instanceof Short))
        return value(localNumber.shortValue());
      if ((paramObject instanceof Integer))
        return value(localNumber.intValue());
      if ((paramObject instanceof Long))
        return value(localNumber.longValue());
      if ((paramObject instanceof Float))
        return value(localNumber.floatValue());
      if ((paramObject instanceof Double))
        return value(localNumber.doubleValue());
    }
    if ((paramObject instanceof Character))
      return value(((Character)paramObject).charValue());
    if ((paramObject instanceof CharSequence))
      return value(paramObject.toString());
    throw new IOException("Unknown object type.");
  }

  public UBJsonWriter value(String paramString)
  {
    checkName();
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    this.out.writeByte(83);
    if (arrayOfByte.length <= 127)
    {
      this.out.writeByte(105);
      this.out.writeByte(arrayOfByte.length);
    }
    while (true)
    {
      this.out.write(arrayOfByte);
      return this;
      if (arrayOfByte.length <= 32767)
      {
        this.out.writeByte(73);
        this.out.writeShort(arrayOfByte.length);
        continue;
      }
      this.out.writeByte(108);
      this.out.writeInt(arrayOfByte.length);
    }
  }

  public UBJsonWriter value(short paramShort)
  {
    checkName();
    this.out.writeByte(73);
    this.out.writeShort(paramShort);
    return this;
  }

  public UBJsonWriter value(boolean paramBoolean)
  {
    checkName();
    DataOutputStream localDataOutputStream = this.out;
    if (paramBoolean);
    for (int i = 84; ; i = 70)
    {
      localDataOutputStream.writeByte(i);
      return this;
    }
  }

  public UBJsonWriter value(byte[] paramArrayOfByte)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(105);
    this.out.writeByte(35);
    value(paramArrayOfByte.length);
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      this.out.writeByte(paramArrayOfByte[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(char[] paramArrayOfChar)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(73);
    this.out.writeByte(35);
    value(paramArrayOfChar.length);
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      this.out.writeChar(paramArrayOfChar[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(double[] paramArrayOfDouble)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(100);
    this.out.writeByte(35);
    value(paramArrayOfDouble.length);
    int i = 0;
    int j = paramArrayOfDouble.length;
    while (i < j)
    {
      this.out.writeDouble(paramArrayOfDouble[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(float[] paramArrayOfFloat)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(100);
    this.out.writeByte(35);
    value(paramArrayOfFloat.length);
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      this.out.writeFloat(paramArrayOfFloat[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(int[] paramArrayOfInt)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(108);
    this.out.writeByte(35);
    value(paramArrayOfInt.length);
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      this.out.writeInt(paramArrayOfInt[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(long[] paramArrayOfLong)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(73);
    this.out.writeByte(35);
    value(paramArrayOfLong.length);
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      this.out.writeLong(paramArrayOfLong[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(String[] paramArrayOfString)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(83);
    this.out.writeByte(35);
    value(paramArrayOfString.length);
    int i = 0;
    int j = paramArrayOfString.length;
    if (i < j)
    {
      byte[] arrayOfByte = paramArrayOfString[i].getBytes("UTF-8");
      if (arrayOfByte.length <= 127)
      {
        this.out.writeByte(105);
        this.out.writeByte(arrayOfByte.length);
      }
      while (true)
      {
        this.out.write(arrayOfByte);
        i++;
        break;
        if (arrayOfByte.length <= 32767)
        {
          this.out.writeByte(73);
          this.out.writeShort(arrayOfByte.length);
          continue;
        }
        this.out.writeByte(108);
        this.out.writeInt(arrayOfByte.length);
      }
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(short[] paramArrayOfShort)
  {
    array();
    this.out.writeByte(36);
    this.out.writeByte(73);
    this.out.writeByte(35);
    value(paramArrayOfShort.length);
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      this.out.writeShort(paramArrayOfShort[i]);
      i++;
    }
    pop(true);
    return this;
  }

  public UBJsonWriter value(boolean[] paramArrayOfBoolean)
  {
    array();
    int i = paramArrayOfBoolean.length;
    int j = 0;
    if (j < i)
    {
      DataOutputStream localDataOutputStream = this.out;
      if (paramArrayOfBoolean[j] != 0);
      for (int k = 84; ; k = 70)
      {
        localDataOutputStream.writeByte(k);
        j++;
        break;
      }
    }
    pop();
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.UBJsonWriter
 * JD-Core Version:    0.6.0
 */