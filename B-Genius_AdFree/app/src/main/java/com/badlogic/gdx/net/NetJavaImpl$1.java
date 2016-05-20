package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.utils.async.AsyncTask;
import java.net.HttpURLConnection;

class NetJavaImpl$1
  implements AsyncTask
{
  // ERROR //
  public java.lang.Void call()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/badlogic/gdx/net/NetJavaImpl$1:val$doingOutPut	Z
    //   4: ifeq +45 -> 49
    //   7: aload_0
    //   8: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   11: invokevirtual 44	com/badlogic/gdx/Net$HttpRequest:getContent	()Ljava/lang/String;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +139 -> 157
    //   21: new 46	java/io/OutputStreamWriter
    //   24: dup
    //   25: aload_0
    //   26: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   29: invokevirtual 52	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   32: invokespecial 55	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 7
    //   37: aload 7
    //   39: aload 6
    //   41: invokevirtual 59	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   44: aload 7
    //   46: invokestatic 65	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   53: invokevirtual 68	java/net/HttpURLConnection:connect	()V
    //   56: new 70	com/badlogic/gdx/net/NetJavaImpl$HttpClientResponse
    //   59: dup
    //   60: aload_0
    //   61: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   64: invokespecial 73	com/badlogic/gdx/net/NetJavaImpl$HttpClientResponse:<init>	(Ljava/net/HttpURLConnection;)V
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 20	com/badlogic/gdx/net/NetJavaImpl$1:this$0	Lcom/badlogic/gdx/net/NetJavaImpl;
    //   72: aload_0
    //   73: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   76: invokevirtual 79	com/badlogic/gdx/net/NetJavaImpl:getFromListeners	(Lcom/badlogic/gdx/Net$HttpRequest;)Lcom/badlogic/gdx/Net$HttpResponseListener;
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +11 -> 94
    //   86: aload 5
    //   88: aload_3
    //   89: invokeinterface 85 2 0
    //   94: aload_0
    //   95: getfield 20	com/badlogic/gdx/net/NetJavaImpl$1:this$0	Lcom/badlogic/gdx/net/NetJavaImpl;
    //   98: aload_0
    //   99: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   102: invokevirtual 89	com/badlogic/gdx/net/NetJavaImpl:removeFromConnectionsAndListeners	(Lcom/badlogic/gdx/Net$HttpRequest;)V
    //   105: aload_0
    //   106: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   109: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   112: goto +119 -> 231
    //   115: astore 8
    //   117: aload 7
    //   119: invokestatic 65	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   122: aload 8
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   130: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   133: aload_0
    //   134: getfield 28	com/badlogic/gdx/net/NetJavaImpl$1:val$httpResponseListener	Lcom/badlogic/gdx/Net$HttpResponseListener;
    //   137: aload_1
    //   138: invokeinterface 96 2 0
    //   143: aload_0
    //   144: getfield 20	com/badlogic/gdx/net/NetJavaImpl$1:this$0	Lcom/badlogic/gdx/net/NetJavaImpl;
    //   147: aload_0
    //   148: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   151: invokevirtual 89	com/badlogic/gdx/net/NetJavaImpl:removeFromConnectionsAndListeners	(Lcom/badlogic/gdx/Net$HttpRequest;)V
    //   154: goto +77 -> 231
    //   157: aload_0
    //   158: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   161: invokevirtual 100	com/badlogic/gdx/Net$HttpRequest:getContentStream	()Ljava/io/InputStream;
    //   164: astore 9
    //   166: aload 9
    //   168: ifnull -119 -> 49
    //   171: aload_0
    //   172: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   175: invokevirtual 52	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   178: astore 10
    //   180: aload 9
    //   182: aload 10
    //   184: invokestatic 104	com/badlogic/gdx/utils/StreamUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   187: aload 10
    //   189: invokestatic 65	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   192: goto -143 -> 49
    //   195: astore 11
    //   197: aload 10
    //   199: invokestatic 65	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   202: aload 11
    //   204: athrow
    //   205: astore 4
    //   207: aload_0
    //   208: getfield 26	com/badlogic/gdx/net/NetJavaImpl$1:val$connection	Ljava/net/HttpURLConnection;
    //   211: invokevirtual 92	java/net/HttpURLConnection:disconnect	()V
    //   214: aload 4
    //   216: athrow
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 20	com/badlogic/gdx/net/NetJavaImpl$1:this$0	Lcom/badlogic/gdx/net/NetJavaImpl;
    //   222: aload_0
    //   223: getfield 24	com/badlogic/gdx/net/NetJavaImpl$1:val$httpRequest	Lcom/badlogic/gdx/Net$HttpRequest;
    //   226: invokevirtual 89	com/badlogic/gdx/net/NetJavaImpl:removeFromConnectionsAndListeners	(Lcom/badlogic/gdx/Net$HttpRequest;)V
    //   229: aload_2
    //   230: athrow
    //   231: aconst_null
    //   232: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   37	44	115	finally
    //   0	16	125	java/lang/Exception
    //   21	37	125	java/lang/Exception
    //   44	49	125	java/lang/Exception
    //   49	68	125	java/lang/Exception
    //   105	112	125	java/lang/Exception
    //   117	125	125	java/lang/Exception
    //   157	166	125	java/lang/Exception
    //   171	180	125	java/lang/Exception
    //   187	192	125	java/lang/Exception
    //   197	205	125	java/lang/Exception
    //   207	217	125	java/lang/Exception
    //   180	187	195	finally
    //   68	81	205	finally
    //   86	94	205	finally
    //   94	105	205	finally
    //   133	143	217	finally
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.NetJavaImpl.1
 * JD-Core Version:    0.6.0
 */