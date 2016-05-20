package com.badlogic.gdx.utils;

import java.util.Iterator;

public class XmlReader$Element
{
  private ObjectMap attributes;
  private Array children;
  private final String name;
  private Element parent;
  private String text;

  public XmlReader$Element(String paramString, Element paramElement)
  {
    this.name = paramString;
    this.parent = paramElement;
  }

  private void getChildrenByNameRecursively(String paramString, Array paramArray)
  {
    if (this.children == null);
    while (true)
    {
      return;
      for (int i = 0; i < this.children.size; i++)
      {
        Element localElement = (Element)this.children.get(i);
        if (localElement.name.equals(paramString))
          paramArray.add(localElement);
        localElement.getChildrenByNameRecursively(paramString, paramArray);
      }
    }
  }

  public void addChild(Element paramElement)
  {
    if (this.children == null)
      this.children = new Array(8);
    this.children.add(paramElement);
  }

  public String get(String paramString)
  {
    String str = get(paramString, null);
    if (str == null)
      throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + paramString);
    return str;
  }

  public String get(String paramString1, String paramString2)
  {
    if (this.attributes != null)
    {
      String str2 = (String)this.attributes.get(paramString1);
      if (str2 != null)
        paramString2 = str2;
    }
    String str1;
    do
    {
      Element localElement;
      do
      {
        return paramString2;
        localElement = getChildByName(paramString1);
      }
      while (localElement == null);
      str1 = localElement.getText();
    }
    while (str1 == null);
    return str1;
  }

  public String getAttribute(String paramString)
  {
    if (this.attributes == null)
      throw new GdxRuntimeException("Element " + paramString + " doesn't have attribute: " + paramString);
    String str = (String)this.attributes.get(paramString);
    if (str == null)
      throw new GdxRuntimeException("Element " + paramString + " doesn't have attribute: " + paramString);
    return str;
  }

  public String getAttribute(String paramString1, String paramString2)
  {
    if (this.attributes == null);
    String str;
    do
    {
      return paramString2;
      str = (String)this.attributes.get(paramString1);
    }
    while (str == null);
    return str;
  }

  public ObjectMap getAttributes()
  {
    return this.attributes;
  }

  public boolean getBoolean(String paramString)
  {
    String str = get(paramString, null);
    if (str == null)
      throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + paramString);
    return Boolean.parseBoolean(str);
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    String str = get(paramString, null);
    if (str == null)
      return paramBoolean;
    return Boolean.parseBoolean(str);
  }

  public boolean getBooleanAttribute(String paramString)
  {
    return Boolean.parseBoolean(getAttribute(paramString));
  }

  public boolean getBooleanAttribute(String paramString, boolean paramBoolean)
  {
    String str = getAttribute(paramString, null);
    if (str == null)
      return paramBoolean;
    return Boolean.parseBoolean(str);
  }

  public Element getChild(int paramInt)
  {
    if (this.children == null)
      throw new GdxRuntimeException("Element has no children: " + this.name);
    return (Element)this.children.get(paramInt);
  }

  public Element getChildByName(String paramString)
  {
    Element localElement;
    if (this.children == null)
    {
      localElement = null;
      return localElement;
    }
    for (int i = 0; ; i++)
    {
      if (i >= this.children.size)
        break label53;
      localElement = (Element)this.children.get(i);
      if (localElement.name.equals(paramString))
        break;
    }
    label53: return null;
  }

  public Element getChildByNameRecursive(String paramString)
  {
    Element localElement;
    if (this.children == null)
    {
      localElement = null;
      return localElement;
    }
    for (int i = 0; ; i++)
    {
      if (i >= this.children.size)
        break label63;
      localElement = (Element)this.children.get(i);
      if (localElement.name.equals(paramString))
        break;
      localElement = localElement.getChildByNameRecursive(paramString);
      if (localElement != null)
        break;
    }
    label63: return null;
  }

  public int getChildCount()
  {
    if (this.children == null)
      return 0;
    return this.children.size;
  }

  public Array getChildrenByName(String paramString)
  {
    Array localArray = new Array();
    if (this.children == null)
      return localArray;
    for (int i = 0; i < this.children.size; i++)
    {
      Element localElement = (Element)this.children.get(i);
      if (!localElement.name.equals(paramString))
        continue;
      localArray.add(localElement);
    }
    return localArray;
  }

  public Array getChildrenByNameRecursively(String paramString)
  {
    Array localArray = new Array();
    getChildrenByNameRecursively(paramString, localArray);
    return localArray;
  }

  public float getFloat(String paramString)
  {
    String str = get(paramString, null);
    if (str == null)
      throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + paramString);
    return Float.parseFloat(str);
  }

  public float getFloat(String paramString, float paramFloat)
  {
    String str = get(paramString, null);
    if (str == null)
      return paramFloat;
    return Float.parseFloat(str);
  }

  public float getFloatAttribute(String paramString)
  {
    return Float.parseFloat(getAttribute(paramString));
  }

  public float getFloatAttribute(String paramString, float paramFloat)
  {
    String str = getAttribute(paramString, null);
    if (str == null)
      return paramFloat;
    return Float.parseFloat(str);
  }

  public int getInt(String paramString)
  {
    String str = get(paramString, null);
    if (str == null)
      throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + paramString);
    return Integer.parseInt(str);
  }

  public int getInt(String paramString, int paramInt)
  {
    String str = get(paramString, null);
    if (str == null)
      return paramInt;
    return Integer.parseInt(str);
  }

  public int getIntAttribute(String paramString)
  {
    return Integer.parseInt(getAttribute(paramString));
  }

  public int getIntAttribute(String paramString, int paramInt)
  {
    String str = getAttribute(paramString, null);
    if (str == null)
      return paramInt;
    return Integer.parseInt(str);
  }

  public String getName()
  {
    return this.name;
  }

  public Element getParent()
  {
    return this.parent;
  }

  public String getText()
  {
    return this.text;
  }

  public void remove()
  {
    this.parent.removeChild(this);
  }

  public void removeChild(int paramInt)
  {
    if (this.children != null)
      this.children.removeIndex(paramInt);
  }

  public void removeChild(Element paramElement)
  {
    if (this.children != null)
      this.children.removeValue(paramElement, true);
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    if (this.attributes == null)
      this.attributes = new ObjectMap(8);
    this.attributes.put(paramString1, paramString2);
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public String toString()
  {
    return toString("");
  }

  public String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramString);
    localStringBuilder.append('<');
    localStringBuilder.append(this.name);
    if (this.attributes != null)
    {
      ObjectMap.Entries localEntries = this.attributes.entries().iterator();
      while (localEntries.hasNext())
      {
        ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
        localStringBuilder.append(' ');
        localStringBuilder.append((String)localEntry.key);
        localStringBuilder.append("=\"");
        localStringBuilder.append((String)localEntry.value);
        localStringBuilder.append('"');
      }
    }
    if ((this.children == null) && ((this.text == null) || (this.text.length() == 0)))
      localStringBuilder.append("/>");
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(">\n");
      String str = paramString + '\t';
      if ((this.text != null) && (this.text.length() > 0))
      {
        localStringBuilder.append(str);
        localStringBuilder.append(this.text);
        localStringBuilder.append('\n');
      }
      if (this.children != null)
      {
        Iterator localIterator = this.children.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append(((Element)localIterator.next()).toString(str));
          localStringBuilder.append('\n');
        }
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("</");
      localStringBuilder.append(this.name);
      localStringBuilder.append('>');
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.XmlReader.Element
 * JD-Core Version:    0.6.0
 */