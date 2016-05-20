package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

public final class fm extends Handler
{
  private final fk a;

  public fm(Context paramContext)
  {
    this(new fn(paramContext));
  }

  private fm(fk paramfk)
  {
    this.a = paramfk;
  }

  public final void handleMessage(Message paramMessage)
  {
    try
    {
      Bundle localBundle = paramMessage.getData();
      if (localBundle == null)
        return;
      JSONObject localJSONObject = new JSONObject(localBundle.getString("data"));
      boolean bool = "fetch_html".equals(localJSONObject.getString("message_name"));
      if (bool)
        try
        {
          fk localfk = this.a;
          localJSONObject.getString("request_id");
          localfk.a(localJSONObject.getString("base_url"), localJSONObject.getString("html"));
          return;
        }
        catch (Exception localException2)
        {
          return;
        }
    }
    catch (Exception localException1)
    {
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fm
 * JD-Core Version:    0.6.0
 */