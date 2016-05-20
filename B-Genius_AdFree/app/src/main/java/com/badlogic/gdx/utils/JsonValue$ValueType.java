package com.badlogic.gdx.utils;

public enum JsonValue$ValueType
{
  static
  {
    array = new ValueType("array", 1);
    stringValue = new ValueType("stringValue", 2);
    doubleValue = new ValueType("doubleValue", 3);
    longValue = new ValueType("longValue", 4);
    booleanValue = new ValueType("booleanValue", 5);
    nullValue = new ValueType("nullValue", 6);
    ValueType[] arrayOfValueType = new ValueType[7];
    arrayOfValueType[0] = object;
    arrayOfValueType[1] = array;
    arrayOfValueType[2] = stringValue;
    arrayOfValueType[3] = doubleValue;
    arrayOfValueType[4] = longValue;
    arrayOfValueType[5] = booleanValue;
    arrayOfValueType[6] = nullValue;
    $VALUES = arrayOfValueType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonValue.ValueType
 * JD-Core Version:    0.6.0
 */