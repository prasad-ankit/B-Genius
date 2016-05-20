package com.badlogic.gdx.backends.android;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.EditText;
import com.badlogic.gdx.Input.TextInputListener;

class AndroidInput$3
  implements Runnable
{
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.this$0.context);
    localBuilder.setTitle(this.val$title);
    EditText localEditText = new EditText(this.this$0.context);
    localEditText.setHint(this.val$hint);
    localEditText.setText(this.val$text);
    localEditText.setSingleLine();
    localBuilder.setView(localEditText);
    localBuilder.setPositiveButton(this.this$0.context.getString(17039370), new AndroidInput.3.1(this, localEditText));
    localBuilder.setNegativeButton(this.this$0.context.getString(17039360), new AndroidInput.3.2(this));
    localBuilder.setOnCancelListener(new AndroidInput.3.3(this));
    localBuilder.show();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidInput.3
 * JD-Core Version:    0.6.0
 */