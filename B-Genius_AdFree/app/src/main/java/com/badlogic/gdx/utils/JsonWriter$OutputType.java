package com.badlogic.gdx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum JsonWriter$OutputType
{
  private static Pattern javascriptPattern;
  private static Pattern minimalNamePattern;
  private static Pattern minimalValuePattern;

  static
  {
    javascript = new OutputType("javascript", 1);
    minimal = new OutputType("minimal", 2);
    OutputType[] arrayOfOutputType = new OutputType[3];
    arrayOfOutputType[0] = json;
    arrayOfOutputType[1] = javascript;
    arrayOfOutputType[2] = minimal;
    $VALUES = arrayOfOutputType;
    javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
    minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
    minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
  }

  public final String quoteName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
    switch (JsonWriter.1.$SwitchMap$com$badlogic$gdx$utils$JsonWriter$OutputType[ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    do
    {
      return "\"" + localStringBuilder.replace('"', "\\\"").toString() + '"';
      if ((!paramString.contains("//")) && (!paramString.contains("/*")) && (minimalNamePattern.matcher(localStringBuilder).matches()))
        return localStringBuilder.toString();
    }
    while (!javascriptPattern.matcher(localStringBuilder).matches());
    return localStringBuilder.toString();
  }

  public final String quoteValue(Object paramObject)
  {
    String str;
    if (paramObject == null)
      str = "null";
    do
    {
      return str;
      str = paramObject.toString();
    }
    while (((paramObject instanceof Number)) || ((paramObject instanceof Boolean)));
    StringBuilder localStringBuilder = new StringBuilder(str);
    localStringBuilder.replace('\\', "\\\\").replace('\r', "\\r").replace('\n', "\\n").replace('\t', "\\t");
    if ((this == minimal) && (!str.equals("true")) && (!str.equals("false")) && (!str.equals("null")) && (!str.contains("//")) && (!str.contains("/*")))
    {
      int i = localStringBuilder.length();
      if ((i > 0) && (localStringBuilder.charAt(i - 1) != ' ') && (minimalValuePattern.matcher(localStringBuilder).matches()))
        return localStringBuilder.toString();
    }
    return "\"" + localStringBuilder.replace('"', "\\\"").toString() + '"';
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.JsonWriter.OutputType
 * JD-Core Version:    0.6.0
 */