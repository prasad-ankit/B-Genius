package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class XmlReader
{
  private static final byte[] _xml_actions = init__xml_actions_0();
  private static final short[] _xml_index_offsets;
  private static final byte[] _xml_indicies;
  private static final byte[] _xml_key_offsets = init__xml_key_offsets_0();
  private static final byte[] _xml_range_lengths;
  private static final byte[] _xml_single_lengths;
  private static final byte[] _xml_trans_actions;
  private static final char[] _xml_trans_keys = init__xml_trans_keys_0();
  private static final byte[] _xml_trans_targs;
  static final int xml_en_elementBody = 15;
  static final int xml_en_main = 1;
  static final int xml_error = 0;
  static final int xml_first_final = 34;
  static final int xml_start = 1;
  private XmlReader.Element current;
  private final Array elements = new Array(8);
  private XmlReader.Element root;
  private final StringBuilder textBuffer = new StringBuilder(64);

  static
  {
    _xml_single_lengths = init__xml_single_lengths_0();
    _xml_range_lengths = init__xml_range_lengths_0();
    _xml_index_offsets = init__xml_index_offsets_0();
    _xml_indicies = init__xml_indicies_0();
    _xml_trans_targs = init__xml_trans_targs_0();
    _xml_trans_actions = init__xml_trans_actions_0();
  }

  private static byte[] init__xml_actions_0()
  {
    return new byte[] { 0, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 2, 0, 6, 2, 1, 4, 2, 2, 4 };
  }

  private static short[] init__xml_index_offsets_0()
  {
    return new short[] { 0, 0, 4, 9, 14, 20, 26, 30, 35, 37, 39, 44, 48, 52, 54, 56, 60, 62, 67, 72, 78, 84, 88, 93, 95, 97, 102, 106, 110, 112, 116, 118, 120, 122, 124, 127 };
  }

  private static byte[] init__xml_indicies_0()
  {
    return new byte[] { 0, 2, 0, 1, 2, 1, 1, 2, 3, 5, 6, 7, 5, 4, 9, 10, 1, 11, 9, 8, 13, 1, 14, 1, 13, 12, 15, 16, 15, 1, 16, 17, 18, 16, 1, 20, 19, 22, 21, 9, 10, 11, 9, 1, 23, 24, 23, 1, 25, 11, 25, 1, 20, 26, 22, 27, 29, 30, 29, 28, 32, 31, 30, 34, 1, 30, 33, 36, 37, 38, 36, 35, 40, 41, 1, 42, 40, 39, 44, 1, 45, 1, 44, 43, 46, 47, 46, 1, 47, 48, 49, 47, 1, 51, 50, 53, 52, 40, 41, 42, 40, 1, 54, 55, 54, 1, 56, 42, 56, 1, 57, 1, 57, 34, 57, 1, 1, 58, 59, 58, 51, 60, 53, 61, 62, 62, 1, 1, 0 };
  }

  private static byte[] init__xml_key_offsets_0()
  {
    return new byte[] { 0, 0, 4, 9, 14, 20, 26, 30, 35, 36, 37, 42, 46, 50, 51, 52, 56, 57, 62, 67, 73, 79, 83, 88, 89, 90, 95, 99, 103, 104, 108, 109, 110, 111, 112, 115 };
  }

  private static byte[] init__xml_range_lengths_0()
  {
    return new byte[] { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0 };
  }

  private static byte[] init__xml_single_lengths_0()
  {
    return new byte[] { 0, 2, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 1, 2, 1, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 2, 1, 1, 1, 1, 1, 0 };
  }

  private static byte[] init__xml_trans_actions_0()
  {
    return new byte[] { 0, 0, 0, 1, 0, 3, 3, 20, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 17, 0, 13, 5, 23, 0, 1, 0, 1, 0, 0, 0, 15, 1, 0, 0, 3, 3, 20, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 17, 0, 13, 5, 23, 0, 0, 0, 7, 1, 0, 0 };
  }

  private static char[] init__xml_trans_keys_0()
  {
    return new char[] { 32, 60, 9, 13, 32, 47, 62, 9, 13, 32, 47, 62, 9, 13, 32, 47, 61, 62, 9, 13, 32, 47, 61, 62, 9, 13, 32, 61, 9, 13, 32, 34, 39, 9, 13, 34, 34, 32, 47, 62, 9, 13, 32, 62, 9, 13, 32, 62, 9, 13, 39, 39, 32, 60, 9, 13, 60, 32, 47, 62, 9, 13, 32, 47, 62, 9, 13, 32, 47, 61, 62, 9, 13, 32, 47, 61, 62, 9, 13, 32, 61, 9, 13, 32, 34, 39, 9, 13, 34, 34, 32, 47, 62, 9, 13, 32, 62, 9, 13, 32, 62, 9, 13, 60, 32, 47, 9, 13, 62, 62, 39, 39, 32, 9, 13, 0 };
  }

  private static byte[] init__xml_trans_targs_0()
  {
    return new byte[] { 1, 0, 2, 3, 3, 4, 11, 34, 5, 4, 11, 34, 5, 6, 7, 6, 7, 8, 13, 9, 10, 9, 10, 12, 34, 12, 14, 14, 16, 15, 17, 16, 17, 18, 30, 18, 19, 26, 28, 20, 19, 26, 28, 20, 21, 22, 21, 22, 23, 32, 24, 25, 24, 25, 27, 28, 27, 29, 31, 35, 33, 33, 34 };
  }

  protected void attribute(String paramString1, String paramString2)
  {
    this.current.setAttribute(paramString1, paramString2);
  }

  protected void close()
  {
    this.root = ((XmlReader.Element)this.elements.pop());
    if (this.elements.size > 0);
    for (XmlReader.Element localElement = (XmlReader.Element)this.elements.peek(); ; localElement = null)
    {
      this.current = localElement;
      return;
    }
  }

  protected String entity(String paramString)
  {
    if (paramString.equals("lt"))
      return "<";
    if (paramString.equals("gt"))
      return ">";
    if (paramString.equals("amp"))
      return "&";
    if (paramString.equals("apos"))
      return "'";
    if (paramString.equals("quot"))
      return "\"";
    if (paramString.startsWith("#x"))
      return Character.toString((char)Integer.parseInt(paramString.substring(2), 16));
    return null;
  }

  protected void open(String paramString)
  {
    XmlReader.Element localElement1 = new XmlReader.Element(paramString, this.current);
    XmlReader.Element localElement2 = this.current;
    if (localElement2 != null)
      localElement2.addChild(localElement1);
    this.elements.add(localElement1);
    this.current = localElement1;
  }

  public XmlReader.Element parse(FileHandle paramFileHandle)
  {
    try
    {
      XmlReader.Element localElement = parse(paramFileHandle.reader("UTF-8"));
      return localElement;
    }
    catch (Exception localException)
    {
    }
    throw new SerializationException("Error parsing file: " + paramFileHandle, localException);
  }

  public XmlReader.Element parse(InputStream paramInputStream)
  {
    try
    {
      XmlReader.Element localElement = parse(new InputStreamReader(paramInputStream, "UTF-8"));
      return localElement;
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

  public XmlReader.Element parse(Reader paramReader)
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
          XmlReader.Element localElement = parse(localObject2, 0, i);
          return localElement;
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

  public XmlReader.Element parse(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    return parse(arrayOfChar, 0, arrayOfChar.length);
  }

  public XmlReader.Element parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = paramInt1;
    int n = 1;
    Object localObject1 = null;
    label48: int i5;
    label223: int i15;
    int i21;
    label294: int i33;
    int i34;
    label709: int i31;
    label836: int i27;
    label1099: int i28;
    label1125: int i29;
    label1218: label1238: int i1;
    label1326: int i2;
    int i3;
    Object localObject2;
    while (true)
    {
      int i6;
      switch (k)
      {
      default:
        if (m >= paramInt2)
          break;
        i5 = 1;
        i6 = 0;
      case 0:
      case 1:
        while (true)
          if (i6 < m)
          {
            if (paramArrayOfChar[i6] == '\n')
              i5++;
            i6++;
            continue;
            if (m == paramInt2)
            {
              k = 4;
              break;
            }
            if (n == 0)
            {
              k = 5;
              break;
            }
            int i8 = _xml_key_offsets[n];
            int i9 = _xml_index_offsets[n];
            int i10 = _xml_single_lengths[n];
            int i18;
            Object localObject3;
            int i20;
            int i22;
            int i23;
            int i24;
            if (i10 > 0)
            {
              int i42 = -1 + (i8 + i10);
              int i43 = i8;
              while (i42 >= i43)
              {
                int i44 = i43 + (i42 - i43 >> 1);
                if (paramArrayOfChar[m] < _xml_trans_keys[i44])
                {
                  i42 = i44 - 1;
                  continue;
                }
                if (paramArrayOfChar[m] > _xml_trans_keys[i44])
                {
                  i43 = i44 + 1;
                  continue;
                }
                i9 += i44 - i8;
                int i14 = _xml_indicies[i9];
                i15 = _xml_trans_targs[i14];
                if (_xml_trans_actions[i14] == 0)
                  break label1577;
                int i16 = _xml_trans_actions[i14];
                byte[] arrayOfByte1 = _xml_actions;
                int i17 = i16 + 1;
                i18 = arrayOfByte1[i16];
                localObject3 = localObject1;
                int i19 = j;
                i20 = i17;
                i21 = i;
                i22 = i19;
                i23 = i18 - 1;
                if (i18 <= 0)
                  break label1326;
                byte[] arrayOfByte2 = _xml_actions;
                i24 = i20 + 1;
                switch (arrayOfByte2[i20])
                {
                default:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                }
              }
            }
            while (true)
            {
              i18 = i23;
              i20 = i24;
              break label294;
              i8 += i10;
              i9 += i10;
              int i11 = _xml_range_lengths[n];
              if (i11 <= 0)
                break label223;
              int i12 = -2 + (i8 + (i11 << 1));
              int i13 = i8;
              while (true)
                if (i12 >= i13)
                {
                  int i41 = i13 + (0xFFFFFFFE & i12 - i13 >> 1);
                  if (paramArrayOfChar[m] < _xml_trans_keys[i41])
                  {
                    i12 = i41 - 2;
                    continue;
                  }
                  if (paramArrayOfChar[m] > _xml_trans_keys[(i41 + 1)])
                  {
                    i13 = i41 + 2;
                    continue;
                  }
                  i9 += (i41 - i8 >> 1);
                  break;
                }
              i9 += i11;
              break label223;
              i18 = i23;
              i20 = i24;
              i21 = m;
              break label294;
              int i30 = paramArrayOfChar[i21];
              if ((i30 == 63) || (i30 == 33))
              {
                int i39;
                if ((paramArrayOfChar[(i21 + 1)] == '[') && (paramArrayOfChar[(i21 + 2)] == 'C') && (paramArrayOfChar[(i21 + 3)] == 'D') && (paramArrayOfChar[(i21 + 4)] == 'A') && (paramArrayOfChar[(i21 + 5)] == 'T') && (paramArrayOfChar[(i21 + 6)] == 'A') && (paramArrayOfChar[(i21 + 7)] == '['))
                {
                  i39 = i21 + 8;
                  for (int i40 = i39 + 2; (paramArrayOfChar[(i40 - 2)] != ']') || (paramArrayOfChar[(i40 - 1)] != ']') || (paramArrayOfChar[i40] != '>'); i40++);
                  text(new String(paramArrayOfChar, i39, -2 + (i40 - i39)));
                  i33 = i40;
                }
                int i38;
                for (i34 = i39; ; i34 = i38)
                {
                  m = i33;
                  int i35 = i22;
                  i = i34;
                  k = 2;
                  j = i35;
                  Object localObject7 = localObject3;
                  n = 15;
                  localObject1 = localObject7;
                  break;
                  if ((i30 != 33) || (paramArrayOfChar[(i21 + 1)] != '-') || (paramArrayOfChar[(i21 + 2)] != '-'))
                    break label1549;
                  for (int i36 = i21 + 3; (paramArrayOfChar[i36] != '-') || (paramArrayOfChar[(i36 + 1)] != '-') || (paramArrayOfChar[(i36 + 2)] != '>'); i36++);
                  int i37 = i36 + 2;
                  i38 = i21;
                  i33 = i37;
                }
                while (paramArrayOfChar[i31] != '>')
                  i31++;
              }
              i22 = 1;
              open(new String(paramArrayOfChar, i21, m - i21));
              i18 = i23;
              i20 = i24;
              break label294;
              close();
              k = 2;
              i = i21;
              Object localObject6 = localObject3;
              n = 15;
              localObject1 = localObject6;
              j = 0;
              break;
              close();
              k = 2;
              j = i22;
              i = i21;
              Object localObject5 = localObject3;
              n = 15;
              localObject1 = localObject5;
              break;
              if (i22 == 0)
                continue;
              k = 2;
              j = i22;
              i = i21;
              Object localObject4 = localObject3;
              n = 15;
              localObject1 = localObject4;
              break;
              localObject3 = new String(paramArrayOfChar, i21, m - i21);
              i18 = i23;
              i20 = i24;
              break label294;
              attribute((String)localObject3, new String(paramArrayOfChar, i21, m - i21));
              i18 = i23;
              i20 = i24;
              break label294;
              int i25 = m;
              if (i25 != i21);
              int i26;
              String str1;
              String str2;
              StringBuilder localStringBuilder;
              switch (paramArrayOfChar[(i25 - 1)])
              {
              default:
                i26 = 0;
                i27 = i21;
                if (i21 == i25)
                  break label1238;
                i28 = i21 + 1;
                if (paramArrayOfChar[i21] != '&')
                  break label1556;
                i21 = i28;
                if (i21 == i25)
                  break label1570;
                i29 = i21 + 1;
                if (paramArrayOfChar[i21] != ';')
                  break label1563;
                this.textBuffer.append(paramArrayOfChar, i27, -1 + (i28 - i27));
                str1 = new String(paramArrayOfChar, i28, -1 + (i29 - i28));
                str2 = entity(str1);
                localStringBuilder = this.textBuffer;
                if (str2 == null)
                  break;
              case '\t':
              case '\n':
              case '\r':
              case ' ':
              }
              while (true)
              {
                localStringBuilder.append(str2);
                i26 = 1;
                i21 = i29;
                i27 = i29;
                break label1099;
                i25--;
                break;
                str2 = str1;
              }
              if (i26 != 0)
              {
                if (i27 < i25)
                  this.textBuffer.append(paramArrayOfChar, i27, i25 - i27);
                text(this.textBuffer.toString());
                this.textBuffer.setLength(0);
                i18 = i23;
                i20 = i24;
                i21 = i27;
                break label294;
              }
              text(new String(paramArrayOfChar, i27, i25 - i27));
              i21 = i27;
            }
            i1 = i22;
            i2 = i21;
            i3 = i15;
            localObject2 = localObject3;
          }
      case 2:
      }
    }
    while (true)
    {
      if (i3 == 0)
      {
        n = i3;
        localObject1 = localObject2;
        int i7 = i1;
        k = 5;
        i = i2;
        j = i7;
        break;
      }
      m++;
      if (m == paramInt2)
        break label48;
      n = i3;
      localObject1 = localObject2;
      int i4 = i1;
      k = 1;
      i = i2;
      j = i4;
      break;
      throw new SerializationException("Error parsing XML on line " + i5 + " near: " + new String(paramArrayOfChar, m, Math.min(32, paramInt2 - m)));
      if (this.elements.size != 0)
      {
        XmlReader.Element localElement2 = (XmlReader.Element)this.elements.peek();
        this.elements.clear();
        throw new SerializationException("Error parsing XML, unclosed element: " + localElement2.getName());
      }
      XmlReader.Element localElement1 = this.root;
      this.root = null;
      return localElement1;
      int i32 = i21;
      i33 = i31;
      i34 = i32;
      break label709;
      label1549: i31 = m;
      break label836;
      label1556: i21 = i28;
      break label1099;
      label1563: i21 = i29;
      break label1125;
      label1570: i29 = i27;
      break label1218;
      label1577: i1 = j;
      localObject2 = localObject1;
      i2 = i;
      i3 = i15;
      continue;
      i1 = j;
      localObject2 = localObject1;
      i2 = i;
      i3 = n;
    }
  }

  protected void text(String paramString)
  {
    String str = this.current.getText();
    XmlReader.Element localElement = this.current;
    if (str != null)
      paramString = str + paramString;
    localElement.setText(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.XmlReader
 * JD-Core Version:    0.6.0
 */