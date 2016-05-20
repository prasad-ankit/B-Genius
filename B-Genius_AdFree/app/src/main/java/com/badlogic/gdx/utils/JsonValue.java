package com.badlogic.gdx.utils;

import B;
import C;
import D;
import F;
import I;
import J;
import S;
import Z;

public class JsonValue
  implements Iterable
{
  public JsonValue child;
  private double doubleValue;
  private long longValue;
  public String name;
  public JsonValue next;
  public JsonValue prev;
  public int size;
  private String stringValue;
  private JsonValue.ValueType type;

  public JsonValue(double paramDouble)
  {
    set(paramDouble, null);
  }

  public JsonValue(double paramDouble, String paramString)
  {
    set(paramDouble, paramString);
  }

  public JsonValue(long paramLong)
  {
    set(paramLong, null);
  }

  public JsonValue(long paramLong, String paramString)
  {
    set(paramLong, paramString);
  }

  public JsonValue(JsonValue.ValueType paramValueType)
  {
    this.type = paramValueType;
  }

  public JsonValue(String paramString)
  {
    set(paramString);
  }

  public JsonValue(boolean paramBoolean)
  {
    set(paramBoolean);
  }

  private static void indent(int paramInt, StringBuilder paramStringBuilder)
  {
    for (int i = 0; i < paramInt; i++)
      paramStringBuilder.append('\t');
  }

  private static boolean isFlat(JsonValue paramJsonValue)
  {
    for (JsonValue localJsonValue = paramJsonValue.child; localJsonValue != null; localJsonValue = localJsonValue.next)
      if ((localJsonValue.isObject()) || (localJsonValue.isArray()))
        return false;
    return true;
  }

  private static boolean isNumeric(JsonValue paramJsonValue)
  {
    for (JsonValue localJsonValue = paramJsonValue.child; localJsonValue != null; localJsonValue = localJsonValue.next)
      if (!localJsonValue.isNumber())
        return false;
    return true;
  }

  private void prettyPrint(JsonValue paramJsonValue, StringBuilder paramStringBuilder, int paramInt, JsonValue.PrettyPrintSettings paramPrettyPrintSettings)
  {
    JsonWriter.OutputType localOutputType = paramPrettyPrintSettings.outputType;
    if (paramJsonValue.isObject())
    {
      if (paramJsonValue.child == null)
      {
        paramStringBuilder.append("{}");
        return;
      }
      boolean bool2 = isFlat(paramJsonValue);
      int n = 0;
      if (!bool2)
        n = 1;
      int i1 = paramStringBuilder.length();
      int i2 = n;
      String str2;
      if (i2 != 0)
      {
        str2 = "{\n";
        label65: paramStringBuilder.append(str2);
      }
      label217: for (JsonValue localJsonValue2 = paramJsonValue.child; ; localJsonValue2 = localJsonValue2.next)
      {
        if (localJsonValue2 == null)
          break label227;
        if (i2 != 0)
          indent(paramInt, paramStringBuilder);
        paramStringBuilder.append(localOutputType.quoteName(localJsonValue2.name));
        paramStringBuilder.append(": ");
        prettyPrint(localJsonValue2, paramStringBuilder, paramInt + 1, paramPrettyPrintSettings);
        if (((i2 == 0) || (localOutputType != JsonWriter.OutputType.minimal)) && (localJsonValue2.next != null))
          paramStringBuilder.append(',');
        if (i2 != 0);
        for (char c2 = '\n'; ; c2 = ' ')
        {
          paramStringBuilder.append(c2);
          if ((i2 != 0) || (paramStringBuilder.length() - i1 <= paramPrettyPrintSettings.singleLineColumns))
            break label217;
          paramStringBuilder.setLength(i1);
          i2 = 1;
          break;
          str2 = "{ ";
          break label65;
        }
      }
      label227: if (i2 != 0)
        indent(paramInt - 1, paramStringBuilder);
      paramStringBuilder.append('}');
      return;
    }
    if (paramJsonValue.isArray())
    {
      if (paramJsonValue.child == null)
      {
        paramStringBuilder.append("[]");
        return;
      }
      int i;
      int j;
      int k;
      int m;
      label314: String str1;
      if (!isFlat(paramJsonValue))
      {
        i = 1;
        if (!paramPrettyPrintSettings.wrapNumericArrays)
        {
          boolean bool1 = isNumeric(paramJsonValue);
          j = 0;
          if (bool1);
        }
        else
        {
          j = 1;
        }
        k = paramStringBuilder.length();
        m = i;
        if (m == 0)
          break label450;
        str1 = "[\n";
        label323: paramStringBuilder.append(str1);
      }
      label450: label464: for (JsonValue localJsonValue1 = paramJsonValue.child; ; localJsonValue1 = localJsonValue1.next)
      {
        if (localJsonValue1 == null)
          break label474;
        if (m != 0)
          indent(paramInt, paramStringBuilder);
        prettyPrint(localJsonValue1, paramStringBuilder, paramInt + 1, paramPrettyPrintSettings);
        if (((m == 0) || (localOutputType != JsonWriter.OutputType.minimal)) && (localJsonValue1.next != null))
          paramStringBuilder.append(',');
        if (m != 0);
        for (char c1 = '\n'; ; c1 = ' ')
        {
          paramStringBuilder.append(c1);
          if ((j == 0) || (m != 0) || (paramStringBuilder.length() - k <= paramPrettyPrintSettings.singleLineColumns))
            break label464;
          paramStringBuilder.setLength(k);
          m = 1;
          break label314;
          i = 0;
          break;
          str1 = "[ ";
          break label323;
        }
      }
      label474: if (m != 0)
        indent(paramInt - 1, paramStringBuilder);
      paramStringBuilder.append(']');
      return;
    }
    if (paramJsonValue.isString())
    {
      paramStringBuilder.append(localOutputType.quoteValue(paramJsonValue.asString()));
      return;
    }
    if (paramJsonValue.isDouble())
    {
      double d = paramJsonValue.asDouble();
      long l = paramJsonValue.asLong();
      if (d == l)
        d = l;
      paramStringBuilder.append(d);
      return;
    }
    if (paramJsonValue.isLong())
    {
      paramStringBuilder.append(paramJsonValue.asLong());
      return;
    }
    if (paramJsonValue.isBoolean())
    {
      paramStringBuilder.append(paramJsonValue.asBoolean());
      return;
    }
    if (paramJsonValue.isNull())
    {
      paramStringBuilder.append("null");
      return;
    }
    throw new SerializationException("Unknown object type: " + paramJsonValue);
  }

  public boolean asBoolean()
  {
    boolean bool = true;
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to boolean: " + this.type);
    case 1:
      bool = this.stringValue.equalsIgnoreCase("true");
    case 2:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
          return bool;
        while (this.doubleValue != 0.0D);
        return false;
      }
      while (this.longValue != 0L);
      return false;
    }
    while (this.longValue != 0L);
    return false;
  }

  public boolean[] asBooleanArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    boolean[] arrayOfBoolean = new boolean[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      boolean bool;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to boolean: " + ((JsonValue)localObject).type);
      case 1:
        bool = Boolean.parseBoolean(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfBoolean[i] = bool;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue;
        break;
        if (((JsonValue)localObject).doubleValue == 0.0D)
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
        if (((JsonValue)localObject).longValue == 0L)
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          bool = true;
          continue;
        }
        bool = false;
      }
    }
    return (Z)arrayOfBoolean;
  }

  public byte asByte()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to byte: " + this.type);
    case 1:
      return Byte.parseByte(this.stringValue);
    case 2:
      return (byte)(int)this.doubleValue;
    case 3:
      return (byte)(int)this.longValue;
    case 4:
    }
    if (this.longValue != 0L)
      return 1;
    return 0;
  }

  public byte[] asByteArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    byte[] arrayOfByte = new byte[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      int j;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to byte: " + ((JsonValue)localObject).type);
      case 1:
        j = Byte.parseByte(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfByte[i] = j;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue;
        break;
        j = (byte)(int)((JsonValue)localObject).doubleValue;
        continue;
        j = (byte)(int)((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          j = 1;
          continue;
        }
        j = 0;
      }
    }
    return (B)arrayOfByte;
  }

  public char asChar()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to char: " + this.type);
    case 1:
      if (this.stringValue.length() != 0)
        break;
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return '\000';
      return this.stringValue.charAt(0);
      return (char)(int)this.doubleValue;
      return (char)(int)this.longValue;
    }
    while (this.longValue == 0L);
    return '\001';
  }

  public char[] asCharArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    char[] arrayOfChar = new char[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      int j;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to char: " + ((JsonValue)localObject).type);
      case 1:
        if (((JsonValue)localObject).stringValue.length() != 0)
          break;
        j = 0;
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfChar[i] = j;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue;
        break;
        j = ((JsonValue)localObject).stringValue.charAt(0);
        continue;
        j = (char)(int)((JsonValue)localObject).doubleValue;
        continue;
        j = (char)(int)((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          j = 1;
          continue;
        }
        j = 0;
      }
    }
    return (C)arrayOfChar;
  }

  public double asDouble()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to double: " + this.type);
    case 1:
      return Double.parseDouble(this.stringValue);
    case 2:
      return this.doubleValue;
    case 3:
      return this.longValue;
    case 4:
    }
    if (this.longValue != 0L)
      return 1.0D;
    return 0.0D;
  }

  public double[] asDoubleArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    double[] arrayOfDouble = new double[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      double d;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to double: " + ((JsonValue)localObject).type);
      case 1:
        d = Double.parseDouble(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfDouble[i] = d;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        int j = i + 1;
        localObject = localJsonValue;
        i = j;
        break;
        d = ((JsonValue)localObject).doubleValue;
        continue;
        d = ((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          d = 1.0D;
          continue;
        }
        d = 0.0D;
      }
    }
    return (D)arrayOfDouble;
  }

  public float asFloat()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to float: " + this.type);
    case 1:
      return Float.parseFloat(this.stringValue);
    case 2:
      return (float)this.doubleValue;
    case 3:
      return (float)this.longValue;
    case 4:
    }
    if (this.longValue != 0L)
      return 1.0F;
    return 0.0F;
  }

  public float[] asFloatArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    float[] arrayOfFloat = new float[this.size];
    JsonValue localJsonValue1 = this.child;
    int i = 0;
    Object localObject = localJsonValue1;
    if (localObject != null)
    {
      float f;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to float: " + ((JsonValue)localObject).type);
      case 1:
        f = Float.parseFloat(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfFloat[i] = f;
        JsonValue localJsonValue2 = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue2;
        break;
        f = (float)((JsonValue)localObject).doubleValue;
        continue;
        f = (float)((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          f = 1.0F;
          continue;
        }
        f = 0.0F;
      }
    }
    return (F)arrayOfFloat;
  }

  public int asInt()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to int: " + this.type);
    case 1:
      return Integer.parseInt(this.stringValue);
    case 2:
      return (int)this.doubleValue;
    case 3:
      return (int)this.longValue;
    case 4:
    }
    if (this.longValue != 0L)
      return 1;
    return 0;
  }

  public int[] asIntArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    int[] arrayOfInt = new int[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      int j;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to int: " + ((JsonValue)localObject).type);
      case 1:
        j = Integer.parseInt(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfInt[i] = j;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue;
        break;
        j = (int)((JsonValue)localObject).doubleValue;
        continue;
        j = (int)((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          j = 1;
          continue;
        }
        j = 0;
      }
    }
    return (I)arrayOfInt;
  }

  public long asLong()
  {
    long l = 0L;
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to long: " + this.type);
    case 1:
      l = Long.parseLong(this.stringValue);
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return l;
      return ()this.doubleValue;
      return this.longValue;
    }
    while (this.longValue == l);
    return 1L;
  }

  public long[] asLongArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    long[] arrayOfLong = new long[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      long l;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to long: " + ((JsonValue)localObject).type);
      case 1:
        l = Long.parseLong(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfLong[i] = l;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        int j = i + 1;
        localObject = localJsonValue;
        i = j;
        break;
        l = ()((JsonValue)localObject).doubleValue;
        continue;
        l = ((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          l = 1L;
          continue;
        }
        l = 0L;
      }
    }
    return (J)arrayOfLong;
  }

  public short asShort()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to short: " + this.type);
    case 1:
      return Short.parseShort(this.stringValue);
    case 2:
      return (short)(int)this.doubleValue;
    case 3:
      return (short)(int)this.longValue;
    case 4:
    }
    if (this.longValue != 0L)
      return 1;
    return 0;
  }

  public short[] asShortArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    short[] arrayOfShort = new short[this.size];
    Object localObject = this.child;
    int i = 0;
    if (localObject != null)
    {
      int j;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to short: " + ((JsonValue)localObject).type);
      case 1:
        j = Short.parseShort(((JsonValue)localObject).stringValue);
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        arrayOfShort[i] = j;
        JsonValue localJsonValue = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue;
        break;
        j = (short)(int)((JsonValue)localObject).doubleValue;
        continue;
        j = (short)(int)((JsonValue)localObject).longValue;
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          j = 1;
          continue;
        }
        j = 0;
      }
    }
    return (S)arrayOfShort;
  }

  public String asString()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      throw new IllegalStateException("Value cannot be converted to string: " + this.type);
    case 1:
      return this.stringValue;
    case 2:
      if (this.stringValue != null)
        return this.stringValue;
      return Double.toString(this.doubleValue);
    case 3:
      if (this.stringValue != null)
        return this.stringValue;
      return Long.toString(this.longValue);
    case 4:
      if (this.longValue != 0L)
        return "true";
      return "false";
    case 5:
    }
    return null;
  }

  public String[] asStringArray()
  {
    if (this.type != JsonValue.ValueType.array)
      throw new IllegalStateException("Value is not an array: " + this.type);
    String[] arrayOfString = new String[this.size];
    JsonValue localJsonValue1 = this.child;
    int i = 0;
    Object localObject = localJsonValue1;
    if (localObject != null)
    {
      String str;
      switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[localObject.type.ordinal()])
      {
      default:
        throw new IllegalStateException("Value cannot be converted to string: " + ((JsonValue)localObject).type);
      case 1:
        str = ((JsonValue)localObject).stringValue;
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        arrayOfString[i] = str;
        JsonValue localJsonValue2 = ((JsonValue)localObject).next;
        i++;
        localObject = localJsonValue2;
        break;
        if (this.stringValue != null)
        {
          str = this.stringValue;
          continue;
        }
        str = Double.toString(((JsonValue)localObject).doubleValue);
        continue;
        if (this.stringValue != null)
        {
          str = this.stringValue;
          continue;
        }
        str = Long.toString(((JsonValue)localObject).longValue);
        continue;
        if (((JsonValue)localObject).longValue != 0L)
        {
          str = "true";
          continue;
        }
        str = "false";
        continue;
        str = null;
      }
    }
    return (String)arrayOfString;
  }

  public JsonValue child()
  {
    return this.child;
  }

  public JsonValue get(int paramInt)
  {
    for (JsonValue localJsonValue = this.child; (localJsonValue != null) && (paramInt > 0); localJsonValue = localJsonValue.next)
      paramInt--;
    return localJsonValue;
  }

  public JsonValue get(String paramString)
  {
    for (JsonValue localJsonValue = this.child; (localJsonValue != null) && (!localJsonValue.name.equalsIgnoreCase(paramString)); localJsonValue = localJsonValue.next);
    return localJsonValue;
  }

  public boolean getBoolean(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asBoolean();
  }

  public boolean getBoolean(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asBoolean();
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramBoolean;
    return localJsonValue.asBoolean();
  }

  public byte getByte(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asByte();
  }

  public byte getByte(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asByte();
  }

  public byte getByte(String paramString, byte paramByte)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramByte;
    return localJsonValue.asByte();
  }

  public char getChar(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asChar();
  }

  public char getChar(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asChar();
  }

  public char getChar(String paramString, char paramChar)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramChar;
    return localJsonValue.asChar();
  }

  public JsonValue getChild(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      return null;
    return localJsonValue.child;
  }

  public double getDouble(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asDouble();
  }

  public double getDouble(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asDouble();
  }

  public double getDouble(String paramString, double paramDouble)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramDouble;
    return localJsonValue.asDouble();
  }

  public float getFloat(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asFloat();
  }

  public float getFloat(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asFloat();
  }

  public float getFloat(String paramString, float paramFloat)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramFloat;
    return localJsonValue.asFloat();
  }

  public int getInt(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asInt();
  }

  public int getInt(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asInt();
  }

  public int getInt(String paramString, int paramInt)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramInt;
    return localJsonValue.asInt();
  }

  public long getLong(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asLong();
  }

  public long getLong(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asLong();
  }

  public long getLong(String paramString, long paramLong)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramLong;
    return localJsonValue.asLong();
  }

  public short getShort(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asShort();
  }

  public short getShort(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asShort();
  }

  public short getShort(String paramString, short paramShort)
  {
    JsonValue localJsonValue = get(paramString);
    if ((localJsonValue == null) || (!localJsonValue.isValue()))
      return paramShort;
    return localJsonValue.asShort();
  }

  public String getString(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Indexed value not found: " + this.name);
    return localJsonValue.asString();
  }

  public String getString(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Named value not found: " + paramString);
    return localJsonValue.asString();
  }

  public String getString(String paramString1, String paramString2)
  {
    JsonValue localJsonValue = get(paramString1);
    if ((localJsonValue == null) || (!localJsonValue.isValue()) || (localJsonValue.isNull()))
      return paramString2;
    return localJsonValue.asString();
  }

  public boolean has(String paramString)
  {
    return get(paramString) != null;
  }

  public boolean hasChild(String paramString)
  {
    return getChild(paramString) != null;
  }

  public boolean isArray()
  {
    return this.type == JsonValue.ValueType.array;
  }

  public boolean isBoolean()
  {
    return this.type == JsonValue.ValueType.booleanValue;
  }

  public boolean isDouble()
  {
    return this.type == JsonValue.ValueType.doubleValue;
  }

  public boolean isLong()
  {
    return this.type == JsonValue.ValueType.longValue;
  }

  public boolean isNull()
  {
    return this.type == JsonValue.ValueType.nullValue;
  }

  public boolean isNumber()
  {
    return (this.type == JsonValue.ValueType.doubleValue) || (this.type == JsonValue.ValueType.longValue);
  }

  public boolean isObject()
  {
    return this.type == JsonValue.ValueType.object;
  }

  public boolean isString()
  {
    return this.type == JsonValue.ValueType.stringValue;
  }

  public boolean isValue()
  {
    switch (JsonValue.1.$SwitchMap$com$badlogic$gdx$utils$JsonValue$ValueType[this.type.ordinal()])
    {
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    return true;
  }

  public JsonValue.JsonIterator iterator()
  {
    return new JsonValue.JsonIterator(this);
  }

  public String name()
  {
    return this.name;
  }

  public JsonValue next()
  {
    return this.next;
  }

  public String prettyPrint(JsonValue.PrettyPrintSettings paramPrettyPrintSettings)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    prettyPrint(this, localStringBuilder, 0, paramPrettyPrintSettings);
    return localStringBuilder.toString();
  }

  public String prettyPrint(JsonWriter.OutputType paramOutputType, int paramInt)
  {
    JsonValue.PrettyPrintSettings localPrettyPrintSettings = new JsonValue.PrettyPrintSettings();
    localPrettyPrintSettings.outputType = paramOutputType;
    localPrettyPrintSettings.singleLineColumns = paramInt;
    return prettyPrint(localPrettyPrintSettings);
  }

  public JsonValue prev()
  {
    return this.prev;
  }

  public JsonValue remove(int paramInt)
  {
    JsonValue localJsonValue = get(paramInt);
    if (localJsonValue == null)
      return null;
    if (localJsonValue.prev == null)
    {
      this.child = localJsonValue.next;
      if (this.child != null)
        this.child.prev = null;
    }
    while (true)
    {
      this.size = (-1 + this.size);
      return localJsonValue;
      localJsonValue.prev.next = localJsonValue.next;
      if (localJsonValue.next == null)
        continue;
      localJsonValue.next.prev = localJsonValue.prev;
    }
  }

  public JsonValue remove(String paramString)
  {
    JsonValue localJsonValue = get(paramString);
    if (localJsonValue == null)
      return null;
    if (localJsonValue.prev == null)
    {
      this.child = localJsonValue.next;
      if (this.child != null)
        this.child.prev = null;
    }
    while (true)
    {
      this.size = (-1 + this.size);
      return localJsonValue;
      localJsonValue.prev.next = localJsonValue.next;
      if (localJsonValue.next == null)
        continue;
      localJsonValue.next.prev = localJsonValue.prev;
    }
  }

  public JsonValue require(int paramInt)
  {
    for (JsonValue localJsonValue = this.child; (localJsonValue != null) && (paramInt > 0); localJsonValue = localJsonValue.next)
      paramInt--;
    if (localJsonValue == null)
      throw new IllegalArgumentException("Child not found with index: " + paramInt);
    return localJsonValue;
  }

  public JsonValue require(String paramString)
  {
    for (JsonValue localJsonValue = this.child; (localJsonValue != null) && (!localJsonValue.name.equalsIgnoreCase(paramString)); localJsonValue = localJsonValue.next);
    if (localJsonValue == null)
      throw new IllegalArgumentException("Child not found with name: " + paramString);
    return localJsonValue;
  }

  public void set(double paramDouble, String paramString)
  {
    this.doubleValue = paramDouble;
    this.longValue = ()paramDouble;
    this.stringValue = paramString;
    this.type = JsonValue.ValueType.doubleValue;
  }

  public void set(long paramLong, String paramString)
  {
    this.longValue = paramLong;
    this.doubleValue = paramLong;
    this.stringValue = paramString;
    this.type = JsonValue.ValueType.longValue;
  }

  public void set(String paramString)
  {
    this.stringValue = paramString;
    if (paramString == null);
    for (JsonValue.ValueType localValueType = JsonValue.ValueType.nullValue; ; localValueType = JsonValue.ValueType.stringValue)
    {
      this.type = localValueType;
      return;
    }
  }

  public void set(boolean paramBoolean)
  {
    long l;
    if (paramBoolean)
      l = 1L;
    while (true)
    {
      this.longValue = l;
      this.type = JsonValue.ValueType.booleanValue;
      return;
      l = 0L;
    }
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setNext(JsonValue paramJsonValue)
  {
    this.next = paramJsonValue;
  }

  public void setPrev(JsonValue paramJsonValue)
  {
    this.prev = paramJsonValue;
  }

  public void setType(JsonValue.ValueType paramValueType)
  {
    if (paramValueType == null)
      throw new IllegalArgumentException("type cannot be null.");
    this.type = paramValueType;
  }

  public int size()
  {
    return this.size;
  }

  public String toString()
  {
    if (isValue())
    {
      if (this.name == null)
        return asString();
      return this.name + ": " + asString();
    }
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    if (this.name == null);
    for (String str = ""; ; str = this.name + ": ")
      return str + prettyPrint(JsonWriter.OutputType.minimal, 0);
  }

  public JsonValue.ValueType type()
  {
    return this.type;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonValue
 * JD-Core Version:    0.6.0
 */