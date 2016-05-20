package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonReader
  implements BaseJsonReader
{
  private static final byte[] _json_actions = init__json_actions_0();
  private static final byte[] _json_eof_actions;
  private static final short[] _json_index_offsets;
  private static final byte[] _json_indicies;
  private static final short[] _json_key_offsets = init__json_key_offsets_0();
  private static final byte[] _json_range_lengths;
  private static final byte[] _json_single_lengths;
  private static final byte[] _json_trans_actions;
  private static final char[] _json_trans_keys = init__json_trans_keys_0();
  private static final byte[] _json_trans_targs;
  static final int json_en_array = 23;
  static final int json_en_main = 1;
  static final int json_en_object = 5;
  static final int json_error = 0;
  static final int json_first_final = 35;
  static final int json_start = 1;
  private JsonValue current;
  private final Array elements = new Array(8);
  private final Array lastChild = new Array(8);
  private JsonValue root;

  static
  {
    _json_single_lengths = init__json_single_lengths_0();
    _json_range_lengths = init__json_range_lengths_0();
    _json_index_offsets = init__json_index_offsets_0();
    _json_indicies = init__json_indicies_0();
    _json_trans_targs = init__json_trans_targs_0();
    _json_trans_actions = init__json_trans_actions_0();
    _json_eof_actions = init__json_eof_actions_0();
  }

  private void addChild(String paramString, JsonValue paramJsonValue)
  {
    paramJsonValue.setName(paramString);
    if (this.current == null)
    {
      this.current = paramJsonValue;
      this.root = paramJsonValue;
      return;
    }
    if ((this.current.isArray()) || (this.current.isObject()))
    {
      if (this.current.size == 0)
        this.current.child = paramJsonValue;
      while (true)
      {
        this.lastChild.add(paramJsonValue);
        JsonValue localJsonValue2 = this.current;
        localJsonValue2.size = (1 + localJsonValue2.size);
        return;
        JsonValue localJsonValue1 = (JsonValue)this.lastChild.pop();
        localJsonValue1.next = paramJsonValue;
        paramJsonValue.prev = localJsonValue1;
      }
    }
    this.root = this.current;
  }

  private static byte[] init__json_actions_0()
  {
    return new byte[] { 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5 };
  }

  private static byte[] init__json_eof_actions_0()
  {
    return new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 };
  }

  private static short[] init__json_index_offsets_0()
  {
    return new short[] { 0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207 };
  }

  private static byte[] init__json_indicies_0()
  {
    return new byte[] { 1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 28, 28, 30, 31, 32, 3, 33, 34, 33, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 54, 54, 56, 57, 58, 3, 59, 60, 59, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0 };
  }

  private static short[] init__json_key_offsets_0()
  {
    return new short[] { 0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184 };
  }

  private static byte[] init__json_range_lengths_0()
  {
    return new byte[] { 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 };
  }

  private static byte[] init__json_single_lengths_0()
  {
    return new byte[] { 0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0 };
  }

  private static byte[] init__json_trans_actions_0()
  {
    return new byte[] { 13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0 };
  }

  private static char[] init__json_trans_keys_0()
  {
    return new char[] { 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 42, 47, 34, 42, 47, 13, 32, 34, 44, 47, 58, 125, 9, 10, 13, 32, 47, 58, 9, 10, 13, 32, 47, 58, 9, 10, 42, 47, 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 9, 10, 13, 32, 44, 47, 125, 9, 10, 13, 32, 44, 47, 125, 13, 32, 34, 44, 47, 58, 125, 9, 10, 34, 13, 32, 34, 44, 47, 58, 125, 9, 10, 42, 47, 42, 47, 13, 32, 34, 44, 47, 58, 125, 9, 10, 42, 47, 42, 47, 34, 42, 47, 42, 47, 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 9, 10, 13, 32, 44, 47, 93, 9, 10, 13, 32, 44, 47, 93, 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 34, 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 42, 47, 42, 47, 13, 32, 34, 44, 47, 58, 91, 93, 123, 9, 10, 42, 47, 42, 47, 42, 47, 13, 32, 47, 9, 10, 13, 32, 47, 9, 10, 0 };
  }

  private static byte[] init__json_trans_targs_0()
  {
    return new byte[] { 35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2 };
  }

  private String unescape(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i + 16);
    int j = 0;
    while (j < i)
    {
      int k = j + 1;
      char c1 = paramString.charAt(j);
      if (c1 != '\\')
      {
        localStringBuilder.append(c1);
        j = k;
        continue;
      }
      if (k == i)
        break;
      int m = k + 1;
      char c2 = paramString.charAt(k);
      if (c2 == 'u')
      {
        localStringBuilder.append(Character.toChars(Integer.parseInt(paramString.substring(m, m + 4), 16)));
        j = m + 4;
        continue;
      }
      switch (c2)
      {
      default:
        throw new SerializationException("Illegal escaped character: \\" + c2);
      case 'b':
        c2 = '\b';
      case '"':
      case '/':
      case '\\':
      case 'f':
      case 'n':
      case 'r':
      case 't':
      }
      while (true)
      {
        localStringBuilder.append(c2);
        j = m;
        break;
        c2 = '\f';
        continue;
        c2 = '\n';
        continue;
        c2 = '\r';
        continue;
        c2 = '\t';
      }
    }
    return localStringBuilder.toString();
  }

  protected void bool(String paramString, boolean paramBoolean)
  {
    addChild(paramString, new JsonValue(paramBoolean));
  }

  protected void number(String paramString1, double paramDouble, String paramString2)
  {
    addChild(paramString1, new JsonValue(paramDouble, paramString2));
  }

  protected void number(String paramString1, long paramLong, String paramString2)
  {
    addChild(paramString1, new JsonValue(paramLong, paramString2));
  }

  public JsonValue parse(FileHandle paramFileHandle)
  {
    try
    {
      JsonValue localJsonValue = parse(paramFileHandle.reader("UTF-8"));
      return localJsonValue;
    }
    catch (Exception localException)
    {
    }
    throw new SerializationException("Error parsing file: " + paramFileHandle, localException);
  }

  public JsonValue parse(InputStream paramInputStream)
  {
    try
    {
      JsonValue localJsonValue = parse(new InputStreamReader(paramInputStream, "UTF-8"));
      return localJsonValue;
    }
    catch (IOException localIOException)
    {
      throw new SerializationException(localIOException);
    }
    finally
    {
      StreamUtils.closeQuietly(paramInputStream);
    }
    throw localObject;
  }

  public JsonValue parse(Reader paramReader)
  {
    int i = 0;
    while (true)
    {
      int j;
      try
      {
        Object localObject2 = new char[1024];
        j = paramReader.read(localObject2, i, localObject2.length - i);
        if (j == -1)
          continue;
        if (j == 0)
        {
          char[] arrayOfChar = new char[localObject2.length << 1];
          System.arraycopy(localObject2, 0, arrayOfChar, 0, localObject2.length);
          localObject2 = arrayOfChar;
          continue;
          JsonValue localJsonValue = parse(localObject2, 0, i);
          return localJsonValue;
        }
      }
      catch (IOException localIOException)
      {
        throw new SerializationException(localIOException);
      }
      finally
      {
        StreamUtils.closeQuietly(paramReader);
      }
      i += j;
    }
  }

  public JsonValue parse(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    return parse(arrayOfChar, 0, arrayOfChar.length);
  }

  // ERROR //
  public JsonValue parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray int
    //   3: astore 4
    //   5: iconst_0
    //   6: istore 5
    //   8: new 97	com/badlogic/gdx/utils/Array
    //   11: dup
    //   12: bipush 8
    //   14: invokespecial 100	com/badlogic/gdx/utils/Array:<init>	(I)V
    //   17: astore 6
    //   19: iconst_0
    //   20: istore 7
    //   22: iconst_0
    //   23: istore 8
    //   25: iconst_0
    //   26: istore 9
    //   28: iload_2
    //   29: istore 10
    //   31: iconst_0
    //   32: istore 11
    //   34: iconst_1
    //   35: istore 12
    //   37: iconst_0
    //   38: istore 13
    //   40: iload 13
    //   42: tableswitch	default:+34 -> 76, 0:+97->139, 1:+120->162, 2:+1701->1743, 3:+34->76, 4:+1727->1769
    //   77: astore 16
    //   79: aload_0
    //   80: getfield 116	com/badlogic/gdx/utils/JsonReader:root	Lcom/badlogic/gdx/utils/JsonValue;
    //   83: astore 17
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 116	com/badlogic/gdx/utils/JsonReader:root	Lcom/badlogic/gdx/utils/JsonValue;
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 114	com/badlogic/gdx/utils/JsonReader:current	Lcom/badlogic/gdx/utils/JsonValue;
    //   95: aload_0
    //   96: getfield 104	com/badlogic/gdx/utils/JsonReader:lastChild	Lcom/badlogic/gdx/utils/Array;
    //   99: invokevirtual 395	com/badlogic/gdx/utils/Array:clear	()V
    //   102: iload 10
    //   104: iload_3
    //   105: if_icmpge +2201 -> 2306
    //   108: iconst_1
    //   109: istore 19
    //   111: iconst_0
    //   112: istore 20
    //   114: iload 20
    //   116: iload 10
    //   118: if_icmpge +2131 -> 2249
    //   121: aload_1
    //   122: iload 20
    //   124: caload
    //   125: bipush 10
    //   127: if_icmpne +6 -> 133
    //   130: iinc 19 1
    //   133: iinc 20 1
    //   136: goto -22 -> 114
    //   139: iload 10
    //   141: iload_3
    //   142: if_icmpne +9 -> 151
    //   145: iconst_4
    //   146: istore 13
    //   148: goto -108 -> 40
    //   151: iload 12
    //   153: ifne +9 -> 162
    //   156: iconst_5
    //   157: istore 13
    //   159: goto -119 -> 40
    //   162: getstatic 51	com/badlogic/gdx/utils/JsonReader:_json_key_offsets	[S
    //   165: iload 12
    //   167: saload
    //   168: istore 43
    //   170: getstatic 72	com/badlogic/gdx/utils/JsonReader:_json_index_offsets	[S
    //   173: iload 12
    //   175: saload
    //   176: istore 44
    //   178: getstatic 62	com/badlogic/gdx/utils/JsonReader:_json_single_lengths	[B
    //   181: iload 12
    //   183: baload
    //   184: istore 45
    //   186: iload 45
    //   188: ifle +285 -> 473
    //   191: iconst_m1
    //   192: iload 43
    //   194: iload 45
    //   196: iadd
    //   197: iadd
    //   198: istore 102
    //   200: iload 43
    //   202: istore 103
    //   204: iload 102
    //   206: iload 103
    //   208: if_icmplt +251 -> 459
    //   211: iload 103
    //   213: iload 102
    //   215: iload 103
    //   217: isub
    //   218: iconst_1
    //   219: ishr
    //   220: iadd
    //   221: istore 104
    //   223: aload_1
    //   224: iload 10
    //   226: caload
    //   227: getstatic 57	com/badlogic/gdx/utils/JsonReader:_json_trans_keys	[C
    //   230: iload 104
    //   232: caload
    //   233: if_icmpge +12 -> 245
    //   236: iload 104
    //   238: iconst_1
    //   239: isub
    //   240: istore 102
    //   242: goto -38 -> 204
    //   245: aload_1
    //   246: iload 10
    //   248: caload
    //   249: getstatic 57	com/badlogic/gdx/utils/JsonReader:_json_trans_keys	[C
    //   252: iload 104
    //   254: caload
    //   255: if_icmple +2241 -> 2496
    //   258: iload 104
    //   260: iconst_1
    //   261: iadd
    //   262: istore 103
    //   264: goto -60 -> 204
    //   267: getstatic 77	com/badlogic/gdx/utils/JsonReader:_json_indicies	[B
    //   270: iload 47
    //   272: baload
    //   273: istore 48
    //   275: getstatic 82	com/badlogic/gdx/utils/JsonReader:_json_trans_targs	[B
    //   278: iload 48
    //   280: baload
    //   281: istore 49
    //   283: getstatic 87	com/badlogic/gdx/utils/JsonReader:_json_trans_actions	[B
    //   286: iload 48
    //   288: baload
    //   289: ifeq +2193 -> 2482
    //   292: getstatic 87	com/badlogic/gdx/utils/JsonReader:_json_trans_actions	[B
    //   295: iload 48
    //   297: baload
    //   298: istore 50
    //   300: getstatic 45	com/badlogic/gdx/utils/JsonReader:_json_actions	[B
    //   303: astore 51
    //   305: iload 50
    //   307: iconst_1
    //   308: iadd
    //   309: istore 52
    //   311: aload 51
    //   313: iload 50
    //   315: baload
    //   316: istore 53
    //   318: iload 5
    //   320: istore 54
    //   322: iload 10
    //   324: istore 55
    //   326: iload 8
    //   328: istore 56
    //   330: iload 7
    //   332: istore 57
    //   334: iload 11
    //   336: istore 58
    //   338: iload 53
    //   340: istore 59
    //   342: iload 59
    //   344: iconst_1
    //   345: isub
    //   346: istore 60
    //   348: iload 59
    //   350: ifle +1369 -> 1719
    //   353: getstatic 45	com/badlogic/gdx/utils/JsonReader:_json_actions	[B
    //   356: astore 61
    //   358: iload 52
    //   360: iconst_1
    //   361: iadd
    //   362: istore 62
    //   364: aload 61
    //   366: iload 52
    //   368: baload
    //   369: istore 63
    //   371: iload 63
    //   373: tableswitch	default:+51 -> 424, 0:+230->603, 1:+244->617, 2:+620->993, 3:+723->1096, 4:+774->1147, 5:+878->1251, 6:+929->1302, 7:+1025->1398, 8:+1260->1633
    //   425: fstore 54
    //   427: fstore_2
    //   428: iload 54
    //   430: istore 70
    //   432: iload 58
    //   434: istore 68
    //   436: iload 62
    //   438: istore 52
    //   440: iload 68
    //   442: istore 58
    //   444: iload 70
    //   446: istore 54
    //   448: iload 69
    //   450: istore 56
    //   452: iload 60
    //   454: istore 59
    //   456: goto -114 -> 342
    //   459: iload 43
    //   461: iload 45
    //   463: iadd
    //   464: istore 43
    //   466: iload 44
    //   468: iload 45
    //   470: iadd
    //   471: istore 44
    //   473: getstatic 67	com/badlogic/gdx/utils/JsonReader:_json_range_lengths	[B
    //   476: iload 12
    //   478: baload
    //   479: istore 46
    //   481: iload 46
    //   483: ifle +2006 -> 2489
    //   486: bipush 254
    //   488: iload 43
    //   490: iload 46
    //   492: iconst_1
    //   493: ishl
    //   494: iadd
    //   495: iadd
    //   496: istore 97
    //   498: iload 43
    //   500: istore 98
    //   502: iload 97
    //   504: iload 98
    //   506: if_icmplt +87 -> 593
    //   509: iload 98
    //   511: bipush 254
    //   513: iload 97
    //   515: iload 98
    //   517: isub
    //   518: iconst_1
    //   519: ishr
    //   520: iand
    //   521: iadd
    //   522: istore 99
    //   524: aload_1
    //   525: iload 10
    //   527: caload
    //   528: getstatic 57	com/badlogic/gdx/utils/JsonReader:_json_trans_keys	[C
    //   531: iload 99
    //   533: caload
    //   534: if_icmpge +12 -> 546
    //   537: iload 99
    //   539: iconst_2
    //   540: isub
    //   541: istore 97
    //   543: goto -41 -> 502
    //   546: aload_1
    //   547: iload 10
    //   549: caload
    //   550: istore 100
    //   552: getstatic 57	com/badlogic/gdx/utils/JsonReader:_json_trans_keys	[C
    //   555: iload 99
    //   557: iconst_1
    //   558: iadd
    //   559: caload
    //   560: istore 101
    //   562: iload 100
    //   564: iload 101
    //   566: if_icmple +12 -> 578
    //   569: iload 99
    //   571: iconst_2
    //   572: iadd
    //   573: istore 98
    //   575: goto -73 -> 502
    //   578: iload 44
    //   580: iload 99
    //   582: iload 43
    //   584: isub
    //   585: iconst_1
    //   586: ishr
    //   587: iadd
    //   588: istore 47
    //   590: goto -323 -> 267
    //   593: iload 44
    //   595: iload 46
    //   597: iadd
    //   598: istore 47
    //   600: goto -333 -> 267
    //   603: iconst_1
    //   604: istore 57
    //   606: iload 60
    //   608: istore 59
    //   610: iload 62
    //   612: istore 52
    //   614: goto -272 -> 342
    //   617: new 262	java/lang/String
    //   620: dup
    //   621: aload_1
    //   622: iload 54
    //   624: iload 55
    //   626: iload 54
    //   628: isub
    //   629: invokespecial 398	java/lang/String:<init>	([CII)V
    //   632: astore 87
    //   634: iload 58
    //   636: ifeq +1839 -> 2475
    //   639: aload_0
    //   640: aload 87
    //   642: invokespecial 400	com/badlogic/gdx/utils/JsonReader:unescape	(Ljava/lang/String;)Ljava/lang/String;
    //   645: astore 88
    //   647: iload 57
    //   649: ifeq +16 -> 665
    //   652: aload 6
    //   654: aload 88
    //   656: invokevirtual 133	com/badlogic/gdx/utils/Array:add	(Ljava/lang/Object;)V
    //   659: iconst_0
    //   660: istore 89
    //   662: goto +1847 -> 2509
    //   665: aload 6
    //   667: getfield 401	com/badlogic/gdx/utils/Array:size	I
    //   670: ifle +1861 -> 2531
    //   673: aload 6
    //   675: invokevirtual 137	com/badlogic/gdx/utils/Array:pop	()Ljava/lang/Object;
    //   678: checkcast 262	java/lang/String
    //   681: astore 90
    //   683: iload 56
    //   685: ifeq +293 -> 978
    //   688: aload 88
    //   690: ldc_w 403
    //   693: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifeq +17 -> 713
    //   699: aload_0
    //   700: aload 90
    //   702: iconst_1
    //   703: invokevirtual 409	com/badlogic/gdx/utils/JsonReader:bool	(Ljava/lang/String;Z)V
    //   706: iload 57
    //   708: istore 89
    //   710: goto +1799 -> 2509
    //   713: aload 88
    //   715: ldc_w 411
    //   718: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   721: ifeq +17 -> 738
    //   724: aload_0
    //   725: aload 90
    //   727: iconst_0
    //   728: invokevirtual 409	com/badlogic/gdx/utils/JsonReader:bool	(Ljava/lang/String;Z)V
    //   731: iload 57
    //   733: istore 89
    //   735: goto +1774 -> 2509
    //   738: aload 88
    //   740: ldc_w 413
    //   743: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   746: ifeq +1791 -> 2537
    //   749: aload_0
    //   750: aload 90
    //   752: aconst_null
    //   753: invokevirtual 417	com/badlogic/gdx/utils/JsonReader:string	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: iload 57
    //   758: istore 89
    //   760: goto +1749 -> 2509
    //   763: iload 91
    //   765: iload 55
    //   767: if_icmpge +147 -> 914
    //   770: aload_1
    //   771: iload 91
    //   773: caload
    //   774: istore 94
    //   776: iload 94
    //   778: lookupswitch	default:+130->908, 43:+167->945, 45:+167->945, 46:+161->939, 48:+167->945, 49:+167->945, 50:+167->945, 51:+167->945, 52:+167->945, 53:+167->945, 54:+167->945, 55:+167->945, 56:+167->945, 57:+167->945, 69:+161->939, 101:+161->939
    //   909: istore 93
    //   911: iconst_0
    //   912: istore 92
    //   914: iload 93
    //   916: ifeq +35 -> 951
    //   919: aload_0
    //   920: aload 90
    //   922: aload 88
    //   924: invokestatic 423	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   927: aload 88
    //   929: invokevirtual 425	com/badlogic/gdx/utils/JsonReader:number	(Ljava/lang/String;DLjava/lang/String;)V
    //   932: iload 57
    //   934: istore 89
    //   936: goto +1573 -> 2509
    //   939: iconst_1
    //   940: istore 93
    //   942: iconst_0
    //   943: istore 92
    //   945: iinc 91 1
    //   948: goto -185 -> 763
    //   951: iload 92
    //   953: ifeq +25 -> 978
    //   956: aload_0
    //   957: aload 90
    //   959: aload 88
    //   961: invokestatic 431	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   964: aload 88
    //   966: invokevirtual 433	com/badlogic/gdx/utils/JsonReader:number	(Ljava/lang/String;JLjava/lang/String;)V
    //   969: iload 57
    //   971: istore 89
    //   973: goto +1536 -> 2509
    //   976: astore 95
    //   978: aload_0
    //   979: aload 90
    //   981: aload 88
    //   983: invokevirtual 417	com/badlogic/gdx/utils/JsonReader:string	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: iload 57
    //   988: istore 89
    //   990: goto +1519 -> 2509
    //   993: aload 6
    //   995: getfield 401	com/badlogic/gdx/utils/Array:size	I
    //   998: ifle +1552 -> 2550
    //   1001: aload 6
    //   1003: invokevirtual 137	com/badlogic/gdx/utils/Array:pop	()Ljava/lang/Object;
    //   1006: checkcast 262	java/lang/String
    //   1009: astore 84
    //   1011: aload_0
    //   1012: aload 84
    //   1014: invokevirtual 436	com/badlogic/gdx/utils/JsonReader:startObject	(Ljava/lang/String;)V
    //   1017: iload 9
    //   1019: aload 4
    //   1021: arraylength
    //   1022: if_icmpne +28 -> 1050
    //   1025: aload 4
    //   1027: arraylength
    //   1028: iconst_1
    //   1029: ishl
    //   1030: newarray int
    //   1032: astore 86
    //   1034: aload 4
    //   1036: iconst_0
    //   1037: aload 86
    //   1039: iconst_0
    //   1040: aload 4
    //   1042: arraylength
    //   1043: invokestatic 381	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1046: aload 86
    //   1048: astore 4
    //   1050: iload 9
    //   1052: iconst_1
    //   1053: iadd
    //   1054: istore 85
    //   1056: aload 4
    //   1058: iload 9
    //   1060: iload 49
    //   1062: iastore
    //   1063: iload 85
    //   1065: istore 9
    //   1067: iconst_2
    //   1068: istore 13
    //   1070: iload 58
    //   1072: istore 11
    //   1074: iload 57
    //   1076: istore 7
    //   1078: iload 56
    //   1080: istore 8
    //   1082: iload 55
    //   1084: istore 10
    //   1086: iload 54
    //   1088: istore 5
    //   1090: iconst_5
    //   1091: istore 12
    //   1093: goto -1053 -> 40
    //   1096: aload_0
    //   1097: invokevirtual 438	com/badlogic/gdx/utils/JsonReader:pop	()V
    //   1100: iload 9
    //   1102: iconst_1
    //   1103: isub
    //   1104: istore 82
    //   1106: aload 4
    //   1108: iload 82
    //   1110: iaload
    //   1111: istore 83
    //   1113: iload 82
    //   1115: istore 9
    //   1117: iconst_2
    //   1118: istore 13
    //   1120: iload 58
    //   1122: istore 11
    //   1124: iload 57
    //   1126: istore 7
    //   1128: iload 56
    //   1130: istore 8
    //   1132: iload 55
    //   1134: istore 10
    //   1136: iload 54
    //   1138: istore 5
    //   1140: iload 83
    //   1142: istore 12
    //   1144: goto -1104 -> 40
    //   1147: aload 6
    //   1149: getfield 401	com/badlogic/gdx/utils/Array:size	I
    //   1152: ifle +1404 -> 2556
    //   1155: aload 6
    //   1157: invokevirtual 137	com/badlogic/gdx/utils/Array:pop	()Ljava/lang/Object;
    //   1160: checkcast 262	java/lang/String
    //   1163: astore 79
    //   1165: aload_0
    //   1166: aload 79
    //   1168: invokevirtual 441	com/badlogic/gdx/utils/JsonReader:startArray	(Ljava/lang/String;)V
    //   1171: iload 9
    //   1173: aload 4
    //   1175: arraylength
    //   1176: if_icmpne +1292 -> 2468
    //   1179: aload 4
    //   1181: arraylength
    //   1182: iconst_1
    //   1183: ishl
    //   1184: newarray int
    //   1186: astore 80
    //   1188: aload 4
    //   1190: iconst_0
    //   1191: aload 80
    //   1193: iconst_0
    //   1194: aload 4
    //   1196: arraylength
    //   1197: invokestatic 381	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1200: iload 9
    //   1202: iconst_1
    //   1203: iadd
    //   1204: istore 81
    //   1206: aload 80
    //   1208: iload 9
    //   1210: iload 49
    //   1212: iastore
    //   1213: iconst_2
    //   1214: istore 13
    //   1216: iload 81
    //   1218: istore 9
    //   1220: aload 80
    //   1222: astore 4
    //   1224: iload 58
    //   1226: istore 11
    //   1228: iload 57
    //   1230: istore 7
    //   1232: iload 56
    //   1234: istore 8
    //   1236: iload 55
    //   1238: istore 10
    //   1240: iload 54
    //   1242: istore 5
    //   1244: bipush 23
    //   1246: istore 12
    //   1248: goto -1208 -> 40
    //   1251: aload_0
    //   1252: invokevirtual 438	com/badlogic/gdx/utils/JsonReader:pop	()V
    //   1255: iload 9
    //   1257: iconst_1
    //   1258: isub
    //   1259: istore 77
    //   1261: aload 4
    //   1263: iload 77
    //   1265: iaload
    //   1266: istore 78
    //   1268: iload 77
    //   1270: istore 9
    //   1272: iconst_2
    //   1273: istore 13
    //   1275: iload 58
    //   1277: istore 11
    //   1279: iload 57
    //   1281: istore 7
    //   1283: iload 56
    //   1285: istore 8
    //   1287: iload 55
    //   1289: istore 10
    //   1291: iload 54
    //   1293: istore 5
    //   1295: iload 78
    //   1297: istore 12
    //   1299: goto -1259 -> 40
    //   1302: iload 55
    //   1304: iconst_1
    //   1305: iadd
    //   1306: istore 74
    //   1308: aload_1
    //   1309: iload 55
    //   1311: caload
    //   1312: istore 75
    //   1314: iload 75
    //   1316: bipush 47
    //   1318: if_icmpne +1143 -> 2461
    //   1321: iload 74
    //   1323: istore 55
    //   1325: iload 55
    //   1327: iload_3
    //   1328: if_icmpeq +1234 -> 2562
    //   1331: aload_1
    //   1332: iload 55
    //   1334: caload
    //   1335: bipush 10
    //   1337: if_icmpeq +1225 -> 2562
    //   1340: iinc 55 1
    //   1343: goto -18 -> 1325
    //   1346: iload 55
    //   1348: iconst_1
    //   1349: iadd
    //   1350: iload_3
    //   1351: if_icmpge +12 -> 1363
    //   1354: aload_1
    //   1355: iload 55
    //   1357: caload
    //   1358: bipush 42
    //   1360: if_icmpne +18 -> 1378
    //   1363: aload_1
    //   1364: iload 55
    //   1366: iconst_1
    //   1367: iadd
    //   1368: caload
    //   1369: istore 76
    //   1371: iload 76
    //   1373: bipush 47
    //   1375: if_icmpeq +9 -> 1384
    //   1378: iinc 55 1
    //   1381: goto -35 -> 1346
    //   1384: iinc 55 1
    //   1387: iload 60
    //   1389: istore 59
    //   1391: iload 62
    //   1393: istore 52
    //   1395: goto -1053 -> 342
    //   1398: iconst_0
    //   1399: istore 68
    //   1401: iconst_1
    //   1402: istore 69
    //   1404: iload 57
    //   1406: ifeq +1192 -> 2598
    //   1409: iload 55
    //   1411: istore 10
    //   1413: aload_1
    //   1414: iload 10
    //   1416: caload
    //   1417: lookupswitch	default:+1163->2580, 10:+51->1468, 13:+51->1468, 47:+78->1495, 58:+51->1468, 92:+1175->2592
    //   1469: lconst_1
    //   1470: impdep2
    //   1471: aload_1
    //   1472: iload 10
    //   1474: caload
    //   1475: bipush 32
    //   1477: if_icmpeq -9 -> 1468
    //   1480: iload 55
    //   1482: istore 72
    //   1484: iload 10
    //   1486: istore 55
    //   1488: iload 72
    //   1490: istore 70
    //   1492: goto -1056 -> 436
    //   1495: iload 10
    //   1497: iconst_1
    //   1498: iadd
    //   1499: iload_3
    //   1500: if_icmpeq +1080 -> 2580
    //   1503: aload_1
    //   1504: iload 10
    //   1506: iconst_1
    //   1507: iadd
    //   1508: caload
    //   1509: istore 73
    //   1511: iload 73
    //   1513: bipush 47
    //   1515: if_icmpeq -47 -> 1468
    //   1518: iload 73
    //   1520: bipush 42
    //   1522: if_icmpne +1058 -> 2580
    //   1525: goto -57 -> 1468
    //   1528: aload_1
    //   1529: iload 10
    //   1531: caload
    //   1532: lookupswitch	default:+1076->2608, 10:+-64->1468, 13:+-64->1468, 44:+-64->1468, 47:+68->1600, 92:+1088->2620, 93:+-64->1468, 125:+-64->1468
    //   1601: lconst_1
    //   1602: iconst_1
    //   1603: iadd
    //   1604: iload_3
    //   1605: if_icmpeq +1003 -> 2608
    //   1608: aload_1
    //   1609: iload 10
    //   1611: iconst_1
    //   1612: iadd
    //   1613: caload
    //   1614: istore 71
    //   1616: iload 71
    //   1618: bipush 47
    //   1620: if_icmpeq -152 -> 1468
    //   1623: iload 71
    //   1625: bipush 42
    //   1627: if_icmpne +981 -> 2608
    //   1630: goto -162 -> 1468
    //   1633: iload 55
    //   1635: iconst_1
    //   1636: iadd
    //   1637: istore 64
    //   1639: iconst_0
    //   1640: istore 65
    //   1642: iload 64
    //   1644: istore 66
    //   1646: aload_1
    //   1647: iload 66
    //   1649: caload
    //   1650: istore 67
    //   1652: iload 67
    //   1654: lookupswitch	default:+26->1680, 34:+35->1689, 92:+56->1710
    //   1681: lstore_3
    //   1682: aconst_null
    //   1683: iload 66
    //   1685: iload_3
    //   1686: if_icmpne -40 -> 1646
    //   1689: iload 66
    //   1691: iconst_1
    //   1692: isub
    //   1693: istore 55
    //   1695: iload 65
    //   1697: istore 68
    //   1699: iload 56
    //   1701: istore 69
    //   1703: iload 64
    //   1705: istore 70
    //   1707: goto -1271 -> 436
    //   1710: iconst_1
    //   1711: istore 65
    //   1713: iinc 66 1
    //   1716: goto -36 -> 1680
    //   1719: iload 58
    //   1721: istore 11
    //   1723: iload 57
    //   1725: istore 7
    //   1727: iload 56
    //   1729: istore 8
    //   1731: iload 55
    //   1733: istore 10
    //   1735: iload 54
    //   1737: istore 5
    //   1739: iload 49
    //   1741: istore 12
    //   1743: iload 12
    //   1745: ifne +9 -> 1754
    //   1748: iconst_5
    //   1749: istore 13
    //   1751: goto -1711 -> 40
    //   1754: iinc 10 1
    //   1757: iload 10
    //   1759: iload_3
    //   1760: if_icmpeq +9 -> 1769
    //   1763: iconst_1
    //   1764: istore 13
    //   1766: goto -1726 -> 40
    //   1769: iload 11
    //   1771: istore 14
    //   1773: iload 12
    //   1775: istore 15
    //   1777: iload 10
    //   1779: iload_3
    //   1780: if_icmpne -1704 -> 76
    //   1783: getstatic 92	com/badlogic/gdx/utils/JsonReader:_json_eof_actions	[B
    //   1786: iload 15
    //   1788: baload
    //   1789: istore 21
    //   1791: getstatic 45	com/badlogic/gdx/utils/JsonReader:_json_actions	[B
    //   1794: astore 22
    //   1796: iload 21
    //   1798: iconst_1
    //   1799: iadd
    //   1800: istore 23
    //   1802: aload 22
    //   1804: iload 21
    //   1806: baload
    //   1807: istore 24
    //   1809: iload 8
    //   1811: istore 25
    //   1813: iload 7
    //   1815: istore 26
    //   1817: iload 5
    //   1819: istore 27
    //   1821: iload 23
    //   1823: istore 28
    //   1825: iload 24
    //   1827: iconst_1
    //   1828: isub
    //   1829: istore 29
    //   1831: iload 24
    //   1833: ifle -1757 -> 76
    //   1836: getstatic 45	com/badlogic/gdx/utils/JsonReader:_json_actions	[B
    //   1839: astore 30
    //   1841: iload 28
    //   1843: iconst_1
    //   1844: iadd
    //   1845: istore 31
    //   1847: aload 30
    //   1849: iload 28
    //   1851: baload
    //   1852: tableswitch	default:+774 -> 2626, 1:+20->1872
    //   1873: aconst_null
    //   1874: iconst_3
    //   1875: dup
    //   1876: aload_1
    //   1877: iload 27
    //   1879: iload 10
    //   1881: iload 27
    //   1883: isub
    //   1884: invokespecial 398	java/lang/String:<init>	([CII)V
    //   1887: astore 32
    //   1889: iload 14
    //   1891: ifeq +563 -> 2454
    //   1894: aload_0
    //   1895: aload 32
    //   1897: invokespecial 400	com/badlogic/gdx/utils/JsonReader:unescape	(Ljava/lang/String;)Ljava/lang/String;
    //   1900: astore 33
    //   1902: iload 26
    //   1904: ifeq +16 -> 1920
    //   1907: aload 6
    //   1909: aload 33
    //   1911: invokevirtual 133	com/badlogic/gdx/utils/Array:add	(Ljava/lang/Object;)V
    //   1914: iconst_0
    //   1915: istore 34
    //   1917: goto +736 -> 2653
    //   1920: aload 6
    //   1922: getfield 401	com/badlogic/gdx/utils/Array:size	I
    //   1925: ifle +742 -> 2667
    //   1928: aload 6
    //   1930: invokevirtual 137	com/badlogic/gdx/utils/Array:pop	()Ljava/lang/Object;
    //   1933: checkcast 262	java/lang/String
    //   1936: astore 37
    //   1938: iload 25
    //   1940: ifeq +294 -> 2234
    //   1943: aload 33
    //   1945: ldc_w 403
    //   1948: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1951: ifeq +17 -> 1968
    //   1954: aload_0
    //   1955: aload 37
    //   1957: iconst_1
    //   1958: invokevirtual 409	com/badlogic/gdx/utils/JsonReader:bool	(Ljava/lang/String;Z)V
    //   1961: iload 26
    //   1963: istore 34
    //   1965: goto +688 -> 2653
    //   1968: aload 33
    //   1970: ldc_w 411
    //   1973: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1976: ifeq +17 -> 1993
    //   1979: aload_0
    //   1980: aload 37
    //   1982: iconst_0
    //   1983: invokevirtual 409	com/badlogic/gdx/utils/JsonReader:bool	(Ljava/lang/String;Z)V
    //   1986: iload 26
    //   1988: istore 34
    //   1990: goto +663 -> 2653
    //   1993: aload 33
    //   1995: ldc_w 413
    //   1998: invokevirtual 407	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2001: ifeq +672 -> 2673
    //   2004: aload_0
    //   2005: aload 37
    //   2007: aconst_null
    //   2008: invokevirtual 417	com/badlogic/gdx/utils/JsonReader:string	(Ljava/lang/String;Ljava/lang/String;)V
    //   2011: iload 26
    //   2013: istore 34
    //   2015: goto +638 -> 2653
    //   2018: iload 27
    //   2020: iload 10
    //   2022: if_icmpge +148 -> 2170
    //   2025: aload_1
    //   2026: iload 27
    //   2028: caload
    //   2029: istore 40
    //   2031: iload 40
    //   2033: lookupswitch	default:+131->2164, 43:+168->2201, 45:+168->2201, 46:+162->2195, 48:+168->2201, 49:+168->2201, 50:+168->2201, 51:+168->2201, 52:+168->2201, 53:+168->2201, 54:+168->2201, 55:+168->2201, 56:+168->2201, 57:+168->2201, 69:+162->2195, 101:+162->2195
    //   2165: istore 39
    //   2167: iconst_0
    //   2168: istore 38
    //   2170: iload 39
    //   2172: ifeq +35 -> 2207
    //   2175: aload_0
    //   2176: aload 37
    //   2178: aload 33
    //   2180: invokestatic 423	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   2183: aload 33
    //   2185: invokevirtual 425	com/badlogic/gdx/utils/JsonReader:number	(Ljava/lang/String;DLjava/lang/String;)V
    //   2188: iload 26
    //   2190: istore 34
    //   2192: goto +461 -> 2653
    //   2195: iconst_1
    //   2196: istore 39
    //   2198: iconst_0
    //   2199: istore 38
    //   2201: iinc 27 1
    //   2204: goto -186 -> 2018
    //   2207: iload 38
    //   2209: ifeq +25 -> 2234
    //   2212: aload_0
    //   2213: aload 37
    //   2215: aload 33
    //   2217: invokestatic 431	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2220: aload 33
    //   2222: invokevirtual 433	com/badlogic/gdx/utils/JsonReader:number	(Ljava/lang/String;JLjava/lang/String;)V
    //   2225: iload 26
    //   2227: istore 34
    //   2229: goto +424 -> 2653
    //   2232: astore 41
    //   2234: aload_0
    //   2235: aload 37
    //   2237: aload 33
    //   2239: invokevirtual 417	com/badlogic/gdx/utils/JsonReader:string	(Ljava/lang/String;Ljava/lang/String;)V
    //   2242: iload 26
    //   2244: istore 34
    //   2246: goto +407 -> 2653
    //   2249: new 298	com/badlogic/gdx/utils/SerializationException
    //   2252: dup
    //   2253: new 300	java/lang/StringBuilder
    //   2256: dup
    //   2257: ldc_w 443
    //   2260: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2263: iload 19
    //   2265: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2268: ldc_w 448
    //   2271: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: new 262	java/lang/String
    //   2277: dup
    //   2278: aload_1
    //   2279: iload 10
    //   2281: sipush 256
    //   2284: iload_3
    //   2285: iload 10
    //   2287: isub
    //   2288: invokestatic 457	java/lang/Math:min	(II)I
    //   2291: invokespecial 398	java/lang/String:<init>	([CII)V
    //   2294: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2300: aload 16
    //   2302: invokespecial 352	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2305: athrow
    //   2306: aload_0
    //   2307: getfield 102	com/badlogic/gdx/utils/JsonReader:elements	Lcom/badlogic/gdx/utils/Array;
    //   2310: getfield 401	com/badlogic/gdx/utils/Array:size	I
    //   2313: ifeq +57 -> 2370
    //   2316: aload_0
    //   2317: getfield 102	com/badlogic/gdx/utils/JsonReader:elements	Lcom/badlogic/gdx/utils/Array;
    //   2320: invokevirtual 460	com/badlogic/gdx/utils/Array:peek	()Ljava/lang/Object;
    //   2323: checkcast 108	com/badlogic/gdx/utils/JsonValue
    //   2326: astore 18
    //   2328: aload_0
    //   2329: getfield 102	com/badlogic/gdx/utils/JsonReader:elements	Lcom/badlogic/gdx/utils/Array;
    //   2332: invokevirtual 395	com/badlogic/gdx/utils/Array:clear	()V
    //   2335: aload 18
    //   2337: ifnull +22 -> 2359
    //   2340: aload 18
    //   2342: invokevirtual 123	com/badlogic/gdx/utils/JsonValue:isObject	()Z
    //   2345: ifeq +14 -> 2359
    //   2348: new 298	com/badlogic/gdx/utils/SerializationException
    //   2351: dup
    //   2352: ldc_w 462
    //   2355: invokespecial 312	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/String;)V
    //   2358: athrow
    //   2359: new 298	com/badlogic/gdx/utils/SerializationException
    //   2362: dup
    //   2363: ldc_w 464
    //   2366: invokespecial 312	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/String;)V
    //   2369: athrow
    //   2370: aload 16
    //   2372: ifnull +37 -> 2409
    //   2375: new 298	com/badlogic/gdx/utils/SerializationException
    //   2378: dup
    //   2379: new 300	java/lang/StringBuilder
    //   2382: dup
    //   2383: ldc_w 466
    //   2386: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2389: new 262	java/lang/String
    //   2392: dup
    //   2393: aload_1
    //   2394: invokespecial 469	java/lang/String:<init>	([C)V
    //   2397: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2400: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2403: aload 16
    //   2405: invokespecial 352	com/badlogic/gdx/utils/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2408: athrow
    //   2409: aload 17
    //   2411: areturn
    //   2412: astore 16
    //   2414: goto -2335 -> 79
    //   2417: astore 16
    //   2419: iload 55
    //   2421: istore 10
    //   2423: goto -2344 -> 79
    //   2426: astore 16
    //   2428: iload 74
    //   2430: istore 10
    //   2432: goto -2353 -> 79
    //   2435: astore 16
    //   2437: iload 66
    //   2439: istore 10
    //   2441: goto -2362 -> 79
    //   2444: astore 42
    //   2446: goto -212 -> 2234
    //   2449: astore 96
    //   2451: goto -1473 -> 978
    //   2454: aload 32
    //   2456: astore 33
    //   2458: goto -556 -> 1902
    //   2461: iload 74
    //   2463: istore 55
    //   2465: goto -1119 -> 1346
    //   2468: aload 4
    //   2470: astore 80
    //   2472: goto -1272 -> 1200
    //   2475: aload 87
    //   2477: astore 88
    //   2479: goto -1832 -> 647
    //   2482: iload 49
    //   2484: istore 12
    //   2486: goto -743 -> 1743
    //   2489: iload 44
    //   2491: istore 47
    //   2493: goto -2226 -> 267
    //   2496: iload 44
    //   2498: iload 104
    //   2500: iload 43
    //   2502: isub
    //   2503: iadd
    //   2504: istore 47
    //   2506: goto -2239 -> 267
    //   2509: iload 62
    //   2511: istore 52
    //   2513: iload 89
    //   2515: istore 57
    //   2517: iload 55
    //   2519: istore 54
    //   2521: iload 60
    //   2523: istore 59
    //   2525: iconst_0
    //   2526: istore 56
    //   2528: goto -2186 -> 342
    //   2531: aconst_null
    //   2532: astore 90
    //   2534: goto -1851 -> 683
    //   2537: iload 54
    //   2539: istore 91
    //   2541: iconst_1
    //   2542: istore 92
    //   2544: iconst_0
    //   2545: istore 93
    //   2547: goto -1784 -> 763
    //   2550: aconst_null
    //   2551: astore 84
    //   2553: goto -1542 -> 1011
    //   2556: aconst_null
    //   2557: astore 79
    //   2559: goto -1394 -> 1165
    //   2562: iinc 55 255
    //   2565: iload 56
    //   2567: istore 69
    //   2569: iload 54
    //   2571: istore 70
    //   2573: iload 58
    //   2575: istore 68
    //   2577: goto -2141 -> 436
    //   2580: iinc 10 1
    //   2583: iload 10
    //   2585: iload_3
    //   2586: if_icmpne -1173 -> 1413
    //   2589: goto -1121 -> 1468
    //   2592: iconst_1
    //   2593: istore 68
    //   2595: goto -15 -> 2580
    //   2598: iload 55
    //   2600: istore 10
    //   2602: iconst_0
    //   2603: istore 68
    //   2605: goto -1077 -> 1528
    //   2608: iinc 10 1
    //   2611: iload 10
    //   2613: iload_3
    //   2614: if_icmpne -1086 -> 1528
    //   2617: goto -1149 -> 1468
    //   2620: iconst_1
    //   2621: istore 68
    //   2623: goto -15 -> 2608
    //   2626: iload 25
    //   2628: istore 36
    //   2630: iload 27
    //   2632: istore 35
    //   2634: iload 31
    //   2636: istore 28
    //   2638: iload 35
    //   2640: istore 27
    //   2642: iload 36
    //   2644: istore 25
    //   2646: iload 29
    //   2648: istore 24
    //   2650: goto -825 -> 1825
    //   2653: iload 34
    //   2655: istore 26
    //   2657: iload 10
    //   2659: istore 35
    //   2661: iconst_0
    //   2662: istore 36
    //   2664: goto -30 -> 2634
    //   2667: aconst_null
    //   2668: astore 37
    //   2670: goto -732 -> 1938
    //   2673: iconst_1
    //   2674: istore 38
    //   2676: iconst_0
    //   2677: istore 39
    //   2679: goto -661 -> 2018
    //
    // Exception table:
    //   from	to	target	type
    //   956	969	976	java/lang/NumberFormatException
    //   2212	2225	2232	java/lang/NumberFormatException
    //   162	186	2412	java/lang/RuntimeException
    //   223	236	2412	java/lang/RuntimeException
    //   245	258	2412	java/lang/RuntimeException
    //   267	305	2412	java/lang/RuntimeException
    //   311	318	2412	java/lang/RuntimeException
    //   473	481	2412	java/lang/RuntimeException
    //   524	537	2412	java/lang/RuntimeException
    //   546	562	2412	java/lang/RuntimeException
    //   1413	1468	2412	java/lang/RuntimeException
    //   1471	1480	2412	java/lang/RuntimeException
    //   1503	1511	2412	java/lang/RuntimeException
    //   1528	1600	2412	java/lang/RuntimeException
    //   1608	1616	2412	java/lang/RuntimeException
    //   1783	1796	2412	java/lang/RuntimeException
    //   1802	1809	2412	java/lang/RuntimeException
    //   1836	1841	2412	java/lang/RuntimeException
    //   1847	1872	2412	java/lang/RuntimeException
    //   1872	1889	2412	java/lang/RuntimeException
    //   1894	1902	2412	java/lang/RuntimeException
    //   1907	1914	2412	java/lang/RuntimeException
    //   1920	1938	2412	java/lang/RuntimeException
    //   1943	1961	2412	java/lang/RuntimeException
    //   1968	1986	2412	java/lang/RuntimeException
    //   1993	2011	2412	java/lang/RuntimeException
    //   2025	2031	2412	java/lang/RuntimeException
    //   2175	2188	2412	java/lang/RuntimeException
    //   2212	2225	2412	java/lang/RuntimeException
    //   2234	2242	2412	java/lang/RuntimeException
    //   353	358	2417	java/lang/RuntimeException
    //   364	371	2417	java/lang/RuntimeException
    //   617	634	2417	java/lang/RuntimeException
    //   639	647	2417	java/lang/RuntimeException
    //   652	659	2417	java/lang/RuntimeException
    //   665	683	2417	java/lang/RuntimeException
    //   688	706	2417	java/lang/RuntimeException
    //   713	731	2417	java/lang/RuntimeException
    //   738	756	2417	java/lang/RuntimeException
    //   770	776	2417	java/lang/RuntimeException
    //   919	932	2417	java/lang/RuntimeException
    //   956	969	2417	java/lang/RuntimeException
    //   978	986	2417	java/lang/RuntimeException
    //   993	1011	2417	java/lang/RuntimeException
    //   1011	1046	2417	java/lang/RuntimeException
    //   1056	1063	2417	java/lang/RuntimeException
    //   1096	1100	2417	java/lang/RuntimeException
    //   1106	1113	2417	java/lang/RuntimeException
    //   1147	1165	2417	java/lang/RuntimeException
    //   1165	1200	2417	java/lang/RuntimeException
    //   1206	1213	2417	java/lang/RuntimeException
    //   1251	1255	2417	java/lang/RuntimeException
    //   1261	1268	2417	java/lang/RuntimeException
    //   1331	1340	2417	java/lang/RuntimeException
    //   1354	1363	2417	java/lang/RuntimeException
    //   1363	1371	2417	java/lang/RuntimeException
    //   1308	1314	2426	java/lang/RuntimeException
    //   1646	1652	2435	java/lang/RuntimeException
    //   2175	2188	2444	java/lang/NumberFormatException
    //   919	932	2449	java/lang/NumberFormatException
  }

  protected void pop()
  {
    this.root = ((JsonValue)this.elements.pop());
    if (this.current.size > 0)
      this.lastChild.pop();
    if (this.elements.size > 0);
    for (JsonValue localJsonValue = (JsonValue)this.elements.peek(); ; localJsonValue = null)
    {
      this.current = localJsonValue;
      return;
    }
  }

  protected void startArray(String paramString)
  {
    JsonValue localJsonValue = new JsonValue(JsonValue.ValueType.array);
    if (this.current != null)
      addChild(paramString, localJsonValue);
    this.elements.add(localJsonValue);
    this.current = localJsonValue;
  }

  protected void startObject(String paramString)
  {
    JsonValue localJsonValue = new JsonValue(JsonValue.ValueType.object);
    if (this.current != null)
      addChild(paramString, localJsonValue);
    this.elements.add(localJsonValue);
    this.current = localJsonValue;
  }

  protected void string(String paramString1, String paramString2)
  {
    addChild(paramString1, new JsonValue(paramString2));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonReader
 * JD-Core Version:    0.6.0
 */