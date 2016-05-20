package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Json
{
  private static final boolean debug;
  private final ObjectMap classToDefaultValues = new ObjectMap();
  private final ObjectMap classToSerializer = new ObjectMap();
  private final ObjectMap classToTag = new ObjectMap();
  private Json.Serializer defaultSerializer;
  private boolean enumNames = true;
  private final Object[] equals1 = { null };
  private final Object[] equals2 = { null };
  private boolean ignoreUnknownFields;
  private JsonWriter.OutputType outputType;
  private boolean quoteLongValues;
  private final ObjectMap tagToClass = new ObjectMap();
  private String typeName = "class";
  private final ObjectMap typeToFields = new ObjectMap();
  private boolean usePrototypes = true;
  private JsonWriter writer;

  public Json()
  {
    this.outputType = JsonWriter.OutputType.minimal;
  }

  public Json(JsonWriter.OutputType paramOutputType)
  {
    this.outputType = paramOutputType;
  }

  private String convertToString(Enum paramEnum)
  {
    if (this.enumNames)
      return paramEnum.name();
    return paramEnum.toString();
  }

  private String convertToString(Object paramObject)
  {
    if ((paramObject instanceof Enum))
      return convertToString((Enum)paramObject);
    if ((paramObject instanceof Class))
      return ((Class)paramObject).getName();
    return String.valueOf(paramObject);
  }

  // ERROR //
  private Object[] getDefaultValues(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/badlogic/gdx/utils/Json:usePrototypes	Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 52	com/badlogic/gdx/utils/Json:classToDefaultValues	Lcom/badlogic/gdx/utils/ObjectMap;
    //   13: aload_1
    //   14: invokevirtual 102	com/badlogic/gdx/utils/ObjectMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +15 -> 32
    //   20: aload_0
    //   21: getfield 52	com/badlogic/gdx/utils/Json:classToDefaultValues	Lcom/badlogic/gdx/utils/ObjectMap;
    //   24: aload_1
    //   25: invokevirtual 106	com/badlogic/gdx/utils/ObjectMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 107	[Ljava/lang/Object;
    //   31: areturn
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 111	com/badlogic/gdx/utils/Json:newInstance	(Ljava/lang/Class;)Ljava/lang/Object;
    //   37: astore 4
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 115	com/badlogic/gdx/utils/Json:getFields	(Ljava/lang/Class;)Lcom/badlogic/gdx/utils/OrderedMap;
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 119	com/badlogic/gdx/utils/ObjectMap:size	I
    //   51: anewarray 4	java/lang/Object
    //   54: astore 6
    //   56: aload_0
    //   57: getfield 52	com/badlogic/gdx/utils/Json:classToDefaultValues	Lcom/badlogic/gdx/utils/ObjectMap;
    //   60: aload_1
    //   61: aload 6
    //   63: invokevirtual 123	com/badlogic/gdx/utils/ObjectMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload 5
    //   69: invokevirtual 127	com/badlogic/gdx/utils/ObjectMap:values	()Lcom/badlogic/gdx/utils/ObjectMap$Values;
    //   72: invokevirtual 132	com/badlogic/gdx/utils/ObjectMap$Values:iterator	()Lcom/badlogic/gdx/utils/ObjectMap$Values;
    //   75: astore 8
    //   77: iconst_0
    //   78: istore 9
    //   80: aload 8
    //   82: invokeinterface 138 1 0
    //   87: ifeq +200 -> 287
    //   90: aload 8
    //   92: invokeinterface 142 1 0
    //   97: checkcast 144	com/badlogic/gdx/utils/Json$FieldMetadata
    //   100: getfield 148	com/badlogic/gdx/utils/Json$FieldMetadata:field	Lcom/badlogic/gdx/utils/reflect/Field;
    //   103: astore 10
    //   105: iload 9
    //   107: iconst_1
    //   108: iadd
    //   109: istore 11
    //   111: aload 6
    //   113: iload 9
    //   115: aload 10
    //   117: aload 4
    //   119: invokevirtual 151	com/badlogic/gdx/utils/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: aastore
    //   123: iload 11
    //   125: istore 9
    //   127: goto -47 -> 80
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 52	com/badlogic/gdx/utils/Json:classToDefaultValues	Lcom/badlogic/gdx/utils/ObjectMap;
    //   135: aload_1
    //   136: aconst_null
    //   137: invokevirtual 123	com/badlogic/gdx/utils/ObjectMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aconst_null
    //   142: areturn
    //   143: astore 15
    //   145: new 96	com/badlogic/gdx/utils/SerializationException
    //   148: dup
    //   149: new 153	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 155
    //   155: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 10
    //   160: invokevirtual 159	com/badlogic/gdx/utils/reflect/Field:getName	()Ljava/lang/String;
    //   163: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 165
    //   168: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 83	java/lang/Class:getName	()Ljava/lang/String;
    //   175: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 167
    //   180: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload 15
    //   188: invokespecial 171	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: athrow
    //   192: astore 14
    //   194: aload 14
    //   196: new 153	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   203: aload 10
    //   205: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: ldc 165
    //   210: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 83	java/lang/Class:getName	()Ljava/lang/String;
    //   217: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 167
    //   222: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 178	com/badlogic/gdx/utils/SerializationException:addTrace	(Ljava/lang/String;)V
    //   231: aload 14
    //   233: athrow
    //   234: astore 12
    //   236: new 96	com/badlogic/gdx/utils/SerializationException
    //   239: dup
    //   240: aload 12
    //   242: invokespecial 181	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   245: astore 13
    //   247: aload 13
    //   249: new 153	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   256: aload 10
    //   258: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   261: ldc 165
    //   263: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 83	java/lang/Class:getName	()Ljava/lang/String;
    //   270: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 167
    //   275: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 178	com/badlogic/gdx/utils/SerializationException:addTrace	(Ljava/lang/String;)V
    //   284: aload 13
    //   286: athrow
    //   287: aload 6
    //   289: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   32	39	130	java/lang/Exception
    //   111	123	143	com/badlogic/gdx/utils/reflect/ReflectionException
    //   111	123	192	com/badlogic/gdx/utils/SerializationException
    //   111	123	234	java/lang/RuntimeException
  }

  private OrderedMap getFields(Class paramClass)
  {
    OrderedMap localOrderedMap1 = (OrderedMap)this.typeToFields.get(paramClass);
    if (localOrderedMap1 != null)
      return localOrderedMap1;
    Array localArray = new Array();
    for (Class localClass = paramClass; localClass != Object.class; localClass = localClass.getSuperclass())
      localArray.add(localClass);
    ArrayList localArrayList = new ArrayList();
    for (int i = -1 + localArray.size; i >= 0; i--)
      Collections.addAll(localArrayList, ClassReflection.getDeclaredFields((Class)localArray.get(i)));
    OrderedMap localOrderedMap2 = new OrderedMap();
    int j = localArrayList.size();
    int k = 0;
    while (true)
    {
      Field localField;
      if (k < j)
      {
        localField = (Field)localArrayList.get(k);
        if ((!localField.isTransient()) && (!localField.isStatic()) && (!localField.isSynthetic()) && (localField.isAccessible()));
      }
      try
      {
        localField.setAccessible(true);
        localOrderedMap2.put(localField.getName(), new Json.FieldMetadata(localField));
        label194: k++;
        continue;
        this.typeToFields.put(paramClass, localOrderedMap2);
        return localOrderedMap2;
      }
      catch (AccessControlException localAccessControlException)
      {
        break label194;
      }
    }
  }

  public void addClassTag(String paramString, Class paramClass)
  {
    this.tagToClass.put(paramString, paramClass);
    this.classToTag.put(paramClass, paramString);
  }

  public Object fromJson(Class paramClass, FileHandle paramFileHandle)
  {
    try
    {
      Object localObject = readValue(paramClass, null, new JsonReader().parse(paramFileHandle));
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new SerializationException("Error reading file: " + paramFileHandle, localException);
  }

  public Object fromJson(Class paramClass, InputStream paramInputStream)
  {
    return readValue(paramClass, null, new JsonReader().parse(paramInputStream));
  }

  public Object fromJson(Class paramClass, Reader paramReader)
  {
    return readValue(paramClass, null, new JsonReader().parse(paramReader));
  }

  public Object fromJson(Class paramClass1, Class paramClass2, FileHandle paramFileHandle)
  {
    try
    {
      Object localObject = readValue(paramClass1, paramClass2, new JsonReader().parse(paramFileHandle));
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new SerializationException("Error reading file: " + paramFileHandle, localException);
  }

  public Object fromJson(Class paramClass1, Class paramClass2, InputStream paramInputStream)
  {
    return readValue(paramClass1, paramClass2, new JsonReader().parse(paramInputStream));
  }

  public Object fromJson(Class paramClass1, Class paramClass2, Reader paramReader)
  {
    return readValue(paramClass1, paramClass2, new JsonReader().parse(paramReader));
  }

  public Object fromJson(Class paramClass1, Class paramClass2, String paramString)
  {
    return readValue(paramClass1, paramClass2, new JsonReader().parse(paramString));
  }

  public Object fromJson(Class paramClass1, Class paramClass2, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return readValue(paramClass1, paramClass2, new JsonReader().parse(paramArrayOfChar, paramInt1, paramInt2));
  }

  public Object fromJson(Class paramClass, String paramString)
  {
    return readValue(paramClass, null, new JsonReader().parse(paramString));
  }

  public Object fromJson(Class paramClass, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return readValue(paramClass, null, new JsonReader().parse(paramArrayOfChar, paramInt1, paramInt2));
  }

  public Class getClass(String paramString)
  {
    return (Class)this.tagToClass.get(paramString);
  }

  public Json.Serializer getSerializer(Class paramClass)
  {
    return (Json.Serializer)this.classToSerializer.get(paramClass);
  }

  public String getTag(Class paramClass)
  {
    return (String)this.classToTag.get(paramClass);
  }

  public JsonWriter getWriter()
  {
    return this.writer;
  }

  protected Object newInstance(Class paramClass)
  {
    try
    {
      Object localObject2 = ClassReflection.newInstance(paramClass);
      return localObject2;
    }
    catch (Exception localException1)
    {
    }
    try
    {
      Constructor localConstructor = ClassReflection.getDeclaredConstructor(paramClass, new Class[0]);
      localConstructor.setAccessible(true);
      Object localObject1 = localConstructor.newInstance(new Object[0]);
      return localObject1;
    }
    catch (ReflectionException localReflectionException)
    {
      if (ClassReflection.isAssignableFrom(Enum.class, paramClass))
      {
        if (paramClass.getEnumConstants() == null)
          paramClass = paramClass.getSuperclass();
        return paramClass.getEnumConstants()[0];
      }
      if (paramClass.isArray())
        throw new SerializationException("Encountered JSON object when expected array of type: " + paramClass.getName(), localException1);
      if ((ClassReflection.isMemberClass(paramClass)) && (!ClassReflection.isStaticClass(paramClass)))
        throw new SerializationException("Class cannot be created (non-static member class): " + paramClass.getName(), localException1);
      throw new SerializationException("Class cannot be created (missing no-arg constructor): " + paramClass.getName(), localException1);
    }
    catch (Exception localException2)
    {
      throw new SerializationException("Error constructing instance of class: " + paramClass.getName(), localException2);
    }
    catch (SecurityException localSecurityException)
    {
      label179: break label179;
    }
  }

  public String prettyPrint(Object paramObject)
  {
    return prettyPrint(paramObject, 0);
  }

  public String prettyPrint(Object paramObject, int paramInt)
  {
    return prettyPrint(toJson(paramObject), paramInt);
  }

  public String prettyPrint(Object paramObject, JsonValue.PrettyPrintSettings paramPrettyPrintSettings)
  {
    return prettyPrint(toJson(paramObject), paramPrettyPrintSettings);
  }

  public String prettyPrint(String paramString)
  {
    return prettyPrint(paramString, 0);
  }

  public String prettyPrint(String paramString, int paramInt)
  {
    return new JsonReader().parse(paramString).prettyPrint(this.outputType, paramInt);
  }

  public String prettyPrint(String paramString, JsonValue.PrettyPrintSettings paramPrettyPrintSettings)
  {
    return new JsonReader().parse(paramString).prettyPrint(paramPrettyPrintSettings);
  }

  public void readField(Object paramObject, Field paramField, String paramString, Class paramClass, JsonValue paramJsonValue)
  {
    JsonValue localJsonValue = paramJsonValue.get(paramString);
    if (localJsonValue == null)
      return;
    SerializationException localSerializationException1;
    try
    {
      paramField.set(paramObject, readValue(paramField.getType(), paramClass, localJsonValue));
      return;
    }
    catch (ReflectionException localReflectionException)
    {
      throw new SerializationException("Error accessing field: " + paramField.getName() + " (" + paramField.getDeclaringClass().getName() + ")", localReflectionException);
    }
    catch (SerializationException localSerializationException2)
    {
      localSerializationException2.addTrace(paramField.getName() + " (" + paramField.getDeclaringClass().getName() + ")");
      throw localSerializationException2;
    }
    catch (RuntimeException localRuntimeException)
    {
      localSerializationException1 = new SerializationException(localRuntimeException);
      localSerializationException1.addTrace(paramField.getName() + " (" + paramField.getDeclaringClass().getName() + ")");
    }
    throw localSerializationException1;
  }

  public void readField(Object paramObject, String paramString, JsonValue paramJsonValue)
  {
    readField(paramObject, paramString, paramString, null, paramJsonValue);
  }

  public void readField(Object paramObject, String paramString, Class paramClass, JsonValue paramJsonValue)
  {
    readField(paramObject, paramString, paramString, paramClass, paramJsonValue);
  }

  public void readField(Object paramObject, String paramString1, String paramString2, JsonValue paramJsonValue)
  {
    readField(paramObject, paramString1, paramString2, null, paramJsonValue);
  }

  public void readField(Object paramObject, String paramString1, String paramString2, Class paramClass, JsonValue paramJsonValue)
  {
    Class localClass1 = paramObject.getClass();
    Json.FieldMetadata localFieldMetadata = (Json.FieldMetadata)getFields(localClass1).get(paramString1);
    if (localFieldMetadata == null)
      throw new SerializationException("Field not found: " + paramString1 + " (" + localClass1.getName() + ")");
    Field localField = localFieldMetadata.field;
    if (paramClass == null);
    for (Class localClass2 = localFieldMetadata.elementType; ; localClass2 = paramClass)
    {
      readField(paramObject, localField, paramString2, localClass2, paramJsonValue);
      return;
    }
  }

  public void readFields(Object paramObject, JsonValue paramJsonValue)
  {
    Class localClass = paramObject.getClass();
    OrderedMap localOrderedMap = getFields(localClass);
    JsonValue localJsonValue = paramJsonValue.child;
    while (localJsonValue != null)
    {
      Json.FieldMetadata localFieldMetadata = (Json.FieldMetadata)localOrderedMap.get(localJsonValue.name());
      Field localField;
      if (localFieldMetadata == null)
      {
        if (!this.ignoreUnknownFields)
          throw new SerializationException("Field not found: " + localJsonValue.name() + " (" + localClass.getName() + ")");
      }
      else
        localField = localFieldMetadata.field;
      try
      {
        localField.set(paramObject, readValue(localField.getType(), localFieldMetadata.elementType, localJsonValue));
        localJsonValue = localJsonValue.next;
      }
      catch (ReflectionException localReflectionException)
      {
        throw new SerializationException("Error accessing field: " + localField.getName() + " (" + localClass.getName() + ")", localReflectionException);
      }
      catch (SerializationException localSerializationException2)
      {
        localSerializationException2.addTrace(localField.getName() + " (" + localClass.getName() + ")");
        throw localSerializationException2;
      }
      catch (RuntimeException localRuntimeException)
      {
        SerializationException localSerializationException1 = new SerializationException(localRuntimeException);
        localSerializationException1.addTrace(localField.getName() + " (" + localClass.getName() + ")");
        throw localSerializationException1;
      }
    }
  }

  public Object readValue(Class paramClass, JsonValue paramJsonValue)
  {
    return readValue(paramClass, null, paramJsonValue);
  }

  public Object readValue(Class paramClass1, Class paramClass2, JsonValue paramJsonValue)
  {
    int i = 0;
    Object localObject3;
    if (paramJsonValue == null)
    {
      localObject3 = null;
      return localObject3;
    }
    Object localObject1;
    label68: label122: JsonValue localJsonValue1;
    if (paramJsonValue.isObject())
    {
      String str2;
      if (this.typeName == null)
        str2 = null;
      while (true)
      {
        if (str2 == null)
          break label1437;
        paramJsonValue.remove(this.typeName);
        localObject1 = getClass(str2);
        if (localObject1 == null);
        try
        {
          Class localClass2 = ClassReflection.forName(str2);
          localObject1 = localClass2;
          if (localObject1 != null)
            break label122;
          if (this.defaultSerializer == null)
            break;
          return this.defaultSerializer.read(this, paramJsonValue, (Class)localObject1);
          str2 = paramJsonValue.getString(this.typeName, null);
        }
        catch (ReflectionException localReflectionException)
        {
          throw new SerializationException(localReflectionException);
        }
      }
      return paramJsonValue;
      if ((this.typeName != null) && (ClassReflection.isAssignableFrom(Collection.class, (Class)localObject1)))
        localJsonValue1 = paramJsonValue.get("items");
    }
    while (true)
    {
      if (localObject1 != null)
      {
        Json.Serializer localSerializer1 = (Json.Serializer)this.classToSerializer.get(localObject1);
        if (localSerializer1 != null)
        {
          return localSerializer1.read(this, localJsonValue1, (Class)localObject1);
          Json.Serializer localSerializer2 = (Json.Serializer)this.classToSerializer.get(localObject1);
          if (localSerializer2 != null)
            return localSerializer2.read(this, paramJsonValue, (Class)localObject1);
          if ((localObject1 == String.class) || (localObject1 == Integer.class) || (localObject1 == Boolean.class) || (localObject1 == Float.class) || (localObject1 == Long.class) || (localObject1 == Double.class) || (localObject1 == Short.class) || (localObject1 == Byte.class) || (localObject1 == Character.class) || (ClassReflection.isAssignableFrom(Enum.class, (Class)localObject1)))
            return readValue("value", (Class)localObject1, paramJsonValue);
          Object localObject5 = newInstance((Class)localObject1);
          if ((localObject5 instanceof Json.Serializable))
          {
            ((Json.Serializable)localObject5).read(this, paramJsonValue);
            return localObject5;
          }
          if ((localObject5 instanceof ObjectMap))
          {
            localObject3 = (ObjectMap)localObject5;
            for (JsonValue localJsonValue9 = paramJsonValue.child; localJsonValue9 != null; localJsonValue9 = localJsonValue9.next)
              ((ObjectMap)localObject3).put(localJsonValue9.name(), readValue(paramClass2, null, localJsonValue9));
            break;
          }
          if ((localObject5 instanceof ArrayMap))
          {
            localObject3 = (ArrayMap)localObject5;
            for (JsonValue localJsonValue8 = paramJsonValue.child; localJsonValue8 != null; localJsonValue8 = localJsonValue8.next)
              ((ArrayMap)localObject3).put(localJsonValue8.name(), readValue(paramClass2, null, localJsonValue8));
            break;
          }
          if ((localObject5 instanceof Map))
          {
            localObject3 = (Map)localObject5;
            for (JsonValue localJsonValue7 = paramJsonValue.child; localJsonValue7 != null; localJsonValue7 = localJsonValue7.next)
              ((Map)localObject3).put(localJsonValue7.name(), readValue(paramClass2, null, localJsonValue7));
            break;
          }
          readFields(localObject5, paramJsonValue);
          return localObject5;
        }
      }
      if (localJsonValue1.isArray())
        if ((localObject1 != null) && (localObject1 != Object.class))
          break label1430;
      label1430: for (Object localObject2 = Array.class; ; localObject2 = localObject1)
      {
        if (ClassReflection.isAssignableFrom(Array.class, (Class)localObject2))
        {
          if (localObject2 == Array.class);
          for (Array localArray = new Array(); ; localArray = (Array)newInstance((Class)localObject2))
            for (JsonValue localJsonValue6 = localJsonValue1.child; localJsonValue6 != null; localJsonValue6 = localJsonValue6.next)
              localArray.add(readValue(paramClass2, null, localJsonValue6));
          return localArray;
        }
        if (ClassReflection.isAssignableFrom(Collection.class, (Class)localObject2))
        {
          if (((Class)localObject2).isInterface());
          for (Object localObject4 = new ArrayList(); ; localObject4 = (Collection)newInstance((Class)localObject2))
            for (JsonValue localJsonValue5 = localJsonValue1.child; localJsonValue5 != null; localJsonValue5 = localJsonValue5.next)
              ((Collection)localObject4).add(readValue(paramClass2, null, localJsonValue5));
          return localObject4;
        }
        if (((Class)localObject2).isArray())
        {
          Class localClass1 = ((Class)localObject2).getComponentType();
          if (paramClass2 == null)
            paramClass2 = localClass1;
          localObject3 = ArrayReflection.newInstance(localClass1, localJsonValue1.size);
          JsonValue localJsonValue4 = localJsonValue1.child;
          while (localJsonValue4 != null)
          {
            int k = i + 1;
            ArrayReflection.set(localObject3, i, readValue(paramClass2, null, localJsonValue4));
            localJsonValue4 = localJsonValue4.next;
            i = k;
          }
          break;
        }
        throw new SerializationException("Unable to convert value to required type: " + localJsonValue1 + " (" + ((Class)localObject2).getName() + ")");
        JsonValue localJsonValue2;
        if (localJsonValue1.isNumber())
        {
          if (localObject1 != null);
          try
          {
            if ((localObject1 == Float.TYPE) || (localObject1 == Float.class))
              return Float.valueOf(localJsonValue1.asFloat());
            if ((localObject1 == Integer.TYPE) || (localObject1 == Integer.class))
              return Integer.valueOf(localJsonValue1.asInt());
            if ((localObject1 == Long.TYPE) || (localObject1 == Long.class))
              return Long.valueOf(localJsonValue1.asLong());
            if ((localObject1 == Double.TYPE) || (localObject1 == Double.class))
              return Double.valueOf(localJsonValue1.asDouble());
            if (localObject1 == String.class)
              return localJsonValue1.asString();
            if ((localObject1 == Short.TYPE) || (localObject1 == Short.class))
              return Short.valueOf(localJsonValue1.asShort());
            if ((localObject1 == Byte.TYPE) || (localObject1 == Byte.class))
            {
              Byte localByte2 = Byte.valueOf(localJsonValue1.asByte());
              return localByte2;
            }
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            localJsonValue2 = new JsonValue(localJsonValue1.asString());
          }
        }
        while (true)
        {
          JsonValue localJsonValue3;
          if (localJsonValue2.isBoolean())
          {
            if (localObject1 != null);
            try
            {
              if ((localObject1 == Boolean.TYPE) || (localObject1 == Boolean.class))
              {
                Boolean localBoolean = Boolean.valueOf(localJsonValue2.asBoolean());
                return localBoolean;
              }
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              localJsonValue3 = new JsonValue(localJsonValue2.asString());
            }
          }
          while (true)
          {
            if (localJsonValue3.isString())
            {
              String str1 = localJsonValue3.asString();
              if ((localObject1 == null) || (localObject1 == String.class))
                return str1;
              try
              {
                if ((localObject1 == Integer.TYPE) || (localObject1 == Integer.class))
                  return Integer.valueOf(str1);
                if ((localObject1 == Float.TYPE) || (localObject1 == Float.class))
                  return Float.valueOf(str1);
                if ((localObject1 == Long.TYPE) || (localObject1 == Long.class))
                  return Long.valueOf(str1);
                if ((localObject1 == Double.TYPE) || (localObject1 == Double.class))
                  return Double.valueOf(str1);
                if ((localObject1 == Short.TYPE) || (localObject1 == Short.class))
                  return Short.valueOf(str1);
                if ((localObject1 == Byte.TYPE) || (localObject1 == Byte.class))
                {
                  Byte localByte1 = Byte.valueOf(str1);
                  return localByte1;
                }
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                if ((localObject1 == Boolean.TYPE) || (localObject1 == Boolean.class))
                  return Boolean.valueOf(str1);
                if ((localObject1 == Character.TYPE) || (localObject1 == Character.class))
                  return Character.valueOf(str1.charAt(0));
                if (ClassReflection.isAssignableFrom(Enum.class, (Class)localObject1))
                {
                  Enum[] arrayOfEnum = (Enum[])((Class)localObject1).getEnumConstants();
                  int j = arrayOfEnum.length;
                  while (i < j)
                  {
                    Enum localEnum = arrayOfEnum[i];
                    if (str1.equals(convertToString(localEnum)))
                      return localEnum;
                    i++;
                  }
                }
                if (localObject1 == CharSequence.class)
                  return str1;
                throw new SerializationException("Unable to convert value to required type: " + localJsonValue3 + " (" + ((Class)localObject1).getName() + ")");
              }
            }
            return null;
            localJsonValue3 = localJsonValue2;
          }
          localJsonValue2 = localJsonValue1;
        }
      }
      label1437: localObject1 = paramClass1;
      break label68;
      localJsonValue1 = paramJsonValue;
      localObject1 = paramClass1;
    }
  }

  public Object readValue(Class paramClass1, Class paramClass2, Object paramObject, JsonValue paramJsonValue)
  {
    if (paramJsonValue == null)
      return paramObject;
    return readValue(paramClass1, paramClass2, paramJsonValue);
  }

  public Object readValue(String paramString, Class paramClass, JsonValue paramJsonValue)
  {
    return readValue(paramClass, null, paramJsonValue.get(paramString));
  }

  public Object readValue(String paramString, Class paramClass1, Class paramClass2, JsonValue paramJsonValue)
  {
    return readValue(paramClass1, paramClass2, paramJsonValue.get(paramString));
  }

  public Object readValue(String paramString, Class paramClass1, Class paramClass2, Object paramObject, JsonValue paramJsonValue)
  {
    return readValue(paramClass1, paramClass2, paramObject, paramJsonValue.get(paramString));
  }

  public Object readValue(String paramString, Class paramClass, Object paramObject, JsonValue paramJsonValue)
  {
    JsonValue localJsonValue = paramJsonValue.get(paramString);
    if (localJsonValue == null)
      return paramObject;
    return readValue(paramClass, null, localJsonValue);
  }

  public void setDefaultSerializer(Json.Serializer paramSerializer)
  {
    this.defaultSerializer = paramSerializer;
  }

  public void setElementType(Class paramClass1, String paramString, Class paramClass2)
  {
    Json.FieldMetadata localFieldMetadata = (Json.FieldMetadata)getFields(paramClass1).get(paramString);
    if (localFieldMetadata == null)
      throw new SerializationException("Field not found: " + paramString + " (" + paramClass1.getName() + ")");
    localFieldMetadata.elementType = paramClass2;
  }

  public void setEnumNames(boolean paramBoolean)
  {
    this.enumNames = paramBoolean;
  }

  public void setIgnoreUnknownFields(boolean paramBoolean)
  {
    this.ignoreUnknownFields = paramBoolean;
  }

  public void setOutputType(JsonWriter.OutputType paramOutputType)
  {
    this.outputType = paramOutputType;
  }

  public void setQuoteLongValues(boolean paramBoolean)
  {
    this.quoteLongValues = paramBoolean;
  }

  public void setSerializer(Class paramClass, Json.Serializer paramSerializer)
  {
    this.classToSerializer.put(paramClass, paramSerializer);
  }

  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }

  public void setUsePrototypes(boolean paramBoolean)
  {
    this.usePrototypes = paramBoolean;
  }

  public void setWriter(Writer paramWriter)
  {
    if (!(paramWriter instanceof JsonWriter));
    for (Object localObject = new JsonWriter(paramWriter); ; localObject = paramWriter)
    {
      this.writer = ((JsonWriter)localObject);
      this.writer.setOutputType(this.outputType);
      this.writer.setQuoteLongValues(this.quoteLongValues);
      return;
    }
  }

  public String toJson(Object paramObject)
  {
    if (paramObject == null);
    for (Class localClass = null; ; localClass = paramObject.getClass())
      return toJson(paramObject, localClass, null);
  }

  public String toJson(Object paramObject, Class paramClass)
  {
    return toJson(paramObject, paramClass, null);
  }

  public String toJson(Object paramObject, Class paramClass1, Class paramClass2)
  {
    StringWriter localStringWriter = new StringWriter();
    toJson(paramObject, paramClass1, paramClass2, localStringWriter);
    return localStringWriter.toString();
  }

  public void toJson(Object paramObject, FileHandle paramFileHandle)
  {
    if (paramObject == null);
    for (Class localClass = null; ; localClass = paramObject.getClass())
    {
      toJson(paramObject, localClass, null, paramFileHandle);
      return;
    }
  }

  public void toJson(Object paramObject, Writer paramWriter)
  {
    if (paramObject == null);
    for (Class localClass = null; ; localClass = paramObject.getClass())
    {
      toJson(paramObject, localClass, null, paramWriter);
      return;
    }
  }

  public void toJson(Object paramObject, Class paramClass, FileHandle paramFileHandle)
  {
    toJson(paramObject, paramClass, null, paramFileHandle);
  }

  public void toJson(Object paramObject, Class paramClass, Writer paramWriter)
  {
    toJson(paramObject, paramClass, null, paramWriter);
  }

  public void toJson(Object paramObject, Class paramClass1, Class paramClass2, FileHandle paramFileHandle)
  {
    Writer localWriter = null;
    try
    {
      localWriter = paramFileHandle.writer(false, "UTF-8");
      toJson(paramObject, paramClass1, paramClass2, localWriter);
      return;
    }
    catch (Exception localException)
    {
      throw new SerializationException("Error writing file: " + paramFileHandle, localException);
    }
    finally
    {
      StreamUtils.closeQuietly(localWriter);
    }
    throw localObject;
  }

  public void toJson(Object paramObject, Class paramClass1, Class paramClass2, Writer paramWriter)
  {
    setWriter(paramWriter);
    try
    {
      writeValue(paramObject, paramClass1, paramClass2);
      return;
    }
    finally
    {
      StreamUtils.closeQuietly(this.writer);
      this.writer = null;
    }
    throw localObject;
  }

  public void writeArrayEnd()
  {
    try
    {
      this.writer.pop();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeArrayStart()
  {
    try
    {
      this.writer.array();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeArrayStart(String paramString)
  {
    try
    {
      this.writer.name(paramString);
      this.writer.array();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeField(Object paramObject, String paramString)
  {
    writeField(paramObject, paramString, paramString, null);
  }

  public void writeField(Object paramObject, String paramString, Class paramClass)
  {
    writeField(paramObject, paramString, paramString, paramClass);
  }

  public void writeField(Object paramObject, String paramString1, String paramString2)
  {
    writeField(paramObject, paramString1, paramString2, null);
  }

  public void writeField(Object paramObject, String paramString1, String paramString2, Class paramClass)
  {
    Class localClass = paramObject.getClass();
    Json.FieldMetadata localFieldMetadata = (Json.FieldMetadata)getFields(localClass).get(paramString1);
    if (localFieldMetadata == null)
      throw new SerializationException("Field not found: " + paramString1 + " (" + localClass.getName() + ")");
    Field localField = localFieldMetadata.field;
    if (paramClass == null)
      paramClass = localFieldMetadata.elementType;
    SerializationException localSerializationException1;
    try
    {
      this.writer.name(paramString2);
      writeValue(localField.get(paramObject), localField.getType(), paramClass);
      return;
    }
    catch (ReflectionException localReflectionException)
    {
      throw new SerializationException("Error accessing field: " + localField.getName() + " (" + localClass.getName() + ")", localReflectionException);
    }
    catch (SerializationException localSerializationException2)
    {
      localSerializationException2.addTrace(localField + " (" + localClass.getName() + ")");
      throw localSerializationException2;
    }
    catch (Exception localException)
    {
      localSerializationException1 = new SerializationException(localException);
      localSerializationException1.addTrace(localField + " (" + localClass.getName() + ")");
    }
    throw localSerializationException1;
  }

  public void writeFields(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    Object[] arrayOfObject = getDefaultValues(localClass);
    ObjectMap.Values localValues = new OrderedMap.OrderedMapValues(getFields(localClass)).iterator();
    int i = 0;
    Json.FieldMetadata localFieldMetadata;
    Field localField;
    if (localValues.hasNext())
    {
      localFieldMetadata = (Json.FieldMetadata)localValues.next();
      localField = localFieldMetadata.field;
    }
    while (true)
    {
      int j;
      try
      {
        Object localObject1 = localField.get(paramObject);
        if (arrayOfObject == null)
          continue;
        j = i + 1;
        Object localObject2 = arrayOfObject[i];
        if ((localObject1 != null) || (localObject2 != null))
          continue;
        i = j;
        break;
        if ((localObject1 == null) || (localObject2 == null))
          break label364;
        if (!localObject1.equals(localObject2))
          continue;
        i = j;
        break;
        if ((!localObject1.getClass().isArray()) || (!localObject2.getClass().isArray()))
          break label364;
        this.equals1[0] = localObject1;
        this.equals2[0] = localObject2;
        if (!Arrays.deepEquals(this.equals1, this.equals2))
          break label364;
        i = j;
        break;
        this.writer.name(localField.getName());
        writeValue(localObject1, localField.getType(), localFieldMetadata.elementType);
      }
      catch (ReflectionException localReflectionException)
      {
        throw new SerializationException("Error accessing field: " + localField.getName() + " (" + localClass.getName() + ")", localReflectionException);
      }
      catch (SerializationException localSerializationException2)
      {
        localSerializationException2.addTrace(localField + " (" + localClass.getName() + ")");
        throw localSerializationException2;
      }
      catch (Exception localException)
      {
        SerializationException localSerializationException1 = new SerializationException(localException);
        localSerializationException1.addTrace(localField + " (" + localClass.getName() + ")");
        throw localSerializationException1;
      }
      return;
      label364: i = j;
    }
  }

  public void writeObjectEnd()
  {
    try
    {
      this.writer.pop();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeObjectStart()
  {
    try
    {
      this.writer.object();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeObjectStart(Class paramClass1, Class paramClass2)
  {
    try
    {
      this.writer.object();
      if ((paramClass2 == null) || (paramClass2 != paramClass1))
        writeType(paramClass1);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeObjectStart(String paramString)
  {
    try
    {
      this.writer.name(paramString);
      writeObjectStart();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeObjectStart(String paramString, Class paramClass1, Class paramClass2)
  {
    try
    {
      this.writer.name(paramString);
      writeObjectStart(paramClass1, paramClass2);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeType(Class paramClass)
  {
    if (this.typeName == null)
      return;
    String str = getTag(paramClass);
    if (str == null)
      str = paramClass.getName();
    try
    {
      this.writer.set(this.typeName, str);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeValue(Object paramObject)
  {
    if (paramObject == null)
    {
      writeValue(paramObject, null, null);
      return;
    }
    writeValue(paramObject, paramObject.getClass(), null);
  }

  public void writeValue(Object paramObject, Class paramClass)
  {
    writeValue(paramObject, paramClass, null);
  }

  public void writeValue(Object paramObject, Class paramClass1, Class paramClass2)
  {
    int i = 0;
    if (paramObject == null);
    while (true)
    {
      try
      {
        this.writer.value(null);
        return;
        if ((paramClass1 != null) && (paramClass1.isPrimitive()))
        {
          this.writer.value(paramObject);
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw new SerializationException(localIOException);
      }
      label916: 
      do
      {
        Class localClass1 = paramObject.getClass();
        if ((localClass1.isPrimitive()) || (localClass1 == String.class) || (localClass1 == Integer.class) || (localClass1 == Boolean.class) || (localClass1 == Float.class) || (localClass1 == Long.class) || (localClass1 == Double.class) || (localClass1 == Short.class) || (localClass1 == Byte.class) || (localClass1 == Character.class))
        {
          writeObjectStart(localClass1, null);
          writeValue("value", paramObject);
          writeObjectEnd();
          return;
        }
        if ((paramObject instanceof Json.Serializable))
        {
          writeObjectStart(localClass1, paramClass1);
          ((Json.Serializable)paramObject).write(this);
          writeObjectEnd();
          return;
        }
        Json.Serializer localSerializer = (Json.Serializer)this.classToSerializer.get(localClass1);
        if (localSerializer != null)
        {
          localSerializer.write(this, paramObject, paramClass1);
          return;
        }
        if ((paramObject instanceof Array))
        {
          if ((paramClass1 != null) && (localClass1 != paramClass1) && (localClass1 != Array.class))
            throw new SerializationException("Serialization of an Array other than the known type is not supported.\nKnown type: " + paramClass1 + "\nActual type: " + localClass1);
          writeArrayStart();
          Array localArray = (Array)paramObject;
          int j = localArray.size;
          while (i < j)
          {
            writeValue(localArray.get(i), paramClass2, null);
            i++;
          }
          writeArrayEnd();
          return;
        }
        if ((paramObject instanceof Collection))
        {
          if ((this.typeName != null) && (localClass1 != ArrayList.class) && ((paramClass1 == null) || (paramClass1 != localClass1)))
          {
            writeObjectStart(localClass1, paramClass1);
            writeArrayStart("items");
            Iterator localIterator3 = ((Collection)paramObject).iterator();
            while (localIterator3.hasNext())
              writeValue(localIterator3.next(), paramClass2, null);
            writeArrayEnd();
            writeObjectEnd();
            return;
          }
          writeArrayStart();
          Iterator localIterator2 = ((Collection)paramObject).iterator();
          while (localIterator2.hasNext())
            writeValue(localIterator2.next(), paramClass2, null);
          writeArrayEnd();
          return;
        }
        if (localClass1.isArray())
        {
          if (paramClass2 == null)
            paramClass2 = localClass1.getComponentType();
          int k = ArrayReflection.getLength(paramObject);
          writeArrayStart();
          while (i < k)
          {
            writeValue(ArrayReflection.get(paramObject, i), paramClass2, null);
            i++;
          }
          writeArrayEnd();
          return;
        }
        if ((paramObject instanceof ObjectMap))
        {
          if (paramClass1 == null)
            paramClass1 = ObjectMap.class;
          writeObjectStart(localClass1, paramClass1);
          ObjectMap.Entries localEntries = ((ObjectMap)paramObject).entries().iterator();
          while (localEntries.hasNext())
          {
            ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
            this.writer.name(convertToString(localEntry.key));
            writeValue(localEntry.value, paramClass2, null);
          }
          writeObjectEnd();
          return;
        }
        if ((paramObject instanceof ArrayMap))
        {
          if (paramClass1 == null)
            paramClass1 = ArrayMap.class;
          writeObjectStart(localClass1, paramClass1);
          ArrayMap localArrayMap = (ArrayMap)paramObject;
          int m = localArrayMap.size;
          for (int n = 0; n < m; n++)
          {
            this.writer.name(convertToString(localArrayMap.keys[n]));
            writeValue(localArrayMap.values[n], paramClass2, null);
          }
          writeObjectEnd();
          return;
        }
        if ((paramObject instanceof Map))
        {
          if (paramClass1 == null)
            paramClass1 = HashMap.class;
          writeObjectStart(localClass1, paramClass1);
          Iterator localIterator1 = ((Map)paramObject).entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
            this.writer.name(convertToString(localEntry1.getKey()));
            writeValue(localEntry1.getValue(), paramClass2, null);
          }
          writeObjectEnd();
          return;
        }
        if (ClassReflection.isAssignableFrom(Enum.class, localClass1))
          if ((this.typeName != null) && ((paramClass1 == null) || (paramClass1 != localClass1)))
            if (localClass1.getEnumConstants() != null)
              break label916;
        for (Class localClass2 = localClass1.getSuperclass(); ; localClass2 = localClass1)
        {
          writeObjectStart(localClass2, null);
          this.writer.name("value");
          this.writer.value(convertToString((Enum)paramObject));
          writeObjectEnd();
          return;
          this.writer.value(convertToString((Enum)paramObject));
          return;
          writeObjectStart(localClass1, paramClass1);
          writeFields(paramObject);
          writeObjectEnd();
          return;
        }
        if ((paramClass1 == String.class) || (paramClass1 == Integer.class) || (paramClass1 == Boolean.class) || (paramClass1 == Float.class) || (paramClass1 == Long.class) || (paramClass1 == Double.class) || (paramClass1 == Short.class) || (paramClass1 == Byte.class))
          break;
      }
      while (paramClass1 != Character.class);
    }
  }

  public void writeValue(String paramString, Object paramObject)
  {
    try
    {
      this.writer.name(paramString);
      if (paramObject == null)
      {
        writeValue(paramObject, null, null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      throw new SerializationException(localIOException);
    }
    writeValue(paramObject, paramObject.getClass(), null);
  }

  public void writeValue(String paramString, Object paramObject, Class paramClass)
  {
    try
    {
      this.writer.name(paramString);
      writeValue(paramObject, paramClass, null);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }

  public void writeValue(String paramString, Object paramObject, Class paramClass1, Class paramClass2)
  {
    try
    {
      this.writer.name(paramString);
      writeValue(paramObject, paramClass1, paramClass2);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new SerializationException(localIOException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Json
 * JD-Core Version:    0.6.0
 */