package com.badlogic.gdx.utils;

import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonWriter extends Writer
{
  private JsonWriter.JsonObject current;
  private boolean named;
  private JsonWriter.OutputType outputType = JsonWriter.OutputType.json;
  private boolean quoteLongValues = false;
  private final Array stack = new Array();
  final Writer writer;

  public JsonWriter(Writer paramWriter)
  {
    this.writer = paramWriter;
  }

  private void requireCommaOrName()
  {
    if (this.current == null)
      return;
    if (this.current.array)
    {
      if (!this.current.needsComma)
      {
        this.current.needsComma = true;
        return;
      }
      this.writer.write(44);
      return;
    }
    if (!this.named)
      throw new IllegalStateException("Name must be set.");
    this.named = false;
  }

  public JsonWriter array()
  {
    requireCommaOrName();
    Array localArray = this.stack;
    JsonWriter.JsonObject localJsonObject = new JsonWriter.JsonObject(this, true);
    this.current = localJsonObject;
    localArray.add(localJsonObject);
    return this;
  }

  public JsonWriter array(String paramString)
  {
    return name(paramString).array();
  }

  public void close()
  {
    while (this.stack.size > 0)
      pop();
    this.writer.close();
  }

  public void flush()
  {
    this.writer.flush();
  }

  public Writer getWriter()
  {
    return this.writer;
  }

  public JsonWriter json(String paramString)
  {
    requireCommaOrName();
    this.writer.write(paramString);
    return this;
  }

  public JsonWriter json(String paramString1, String paramString2)
  {
    return name(paramString1).json(paramString2);
  }

  public JsonWriter name(String paramString)
  {
    if ((this.current == null) || (this.current.array))
      throw new IllegalStateException("Current item must be an object.");
    if (!this.current.needsComma)
      this.current.needsComma = true;
    while (true)
    {
      this.writer.write(this.outputType.quoteName(paramString));
      this.writer.write(58);
      this.named = true;
      return this;
      this.writer.write(44);
    }
  }

  public JsonWriter object()
  {
    requireCommaOrName();
    Array localArray = this.stack;
    JsonWriter.JsonObject localJsonObject = new JsonWriter.JsonObject(this, false);
    this.current = localJsonObject;
    localArray.add(localJsonObject);
    return this;
  }

  public JsonWriter object(String paramString)
  {
    return name(paramString).object();
  }

  public JsonWriter pop()
  {
    if (this.named)
      throw new IllegalStateException("Expected an object, array, or value since a name was set.");
    ((JsonWriter.JsonObject)this.stack.pop()).close();
    if (this.stack.size == 0);
    for (JsonWriter.JsonObject localJsonObject = null; ; localJsonObject = (JsonWriter.JsonObject)this.stack.peek())
    {
      this.current = localJsonObject;
      return this;
    }
  }

  public JsonWriter set(String paramString, Object paramObject)
  {
    return name(paramString).value(paramObject);
  }

  public void setOutputType(JsonWriter.OutputType paramOutputType)
  {
    this.outputType = paramOutputType;
  }

  public void setQuoteLongValues(boolean paramBoolean)
  {
    this.quoteLongValues = paramBoolean;
  }

  public JsonWriter value(Object paramObject)
  {
    if ((this.quoteLongValues) && (((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof BigDecimal)) || ((paramObject instanceof BigInteger))))
      paramObject = paramObject.toString();
    while (true)
    {
      requireCommaOrName();
      this.writer.write(this.outputType.quoteValue(paramObject));
      return this;
      if (!(paramObject instanceof Number))
        continue;
      Number localNumber = (Number)paramObject;
      long l = localNumber.longValue();
      if (localNumber.doubleValue() != l)
        continue;
      paramObject = Long.valueOf(l);
    }
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.writer.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonWriter
 * JD-Core Version:    0.6.0
 */