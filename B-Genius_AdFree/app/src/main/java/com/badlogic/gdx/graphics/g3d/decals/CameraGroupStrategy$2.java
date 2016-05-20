package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import java.util.Comparator;

class CameraGroupStrategy$2
  implements Comparator
{
  public int compare(Decal paramDecal1, Decal paramDecal2)
  {
    float f = this.val$camera.position.dst(paramDecal1.position);
    return (int)Math.signum(this.val$camera.position.dst(paramDecal2.position) - f);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy.2
 * JD-Core Version:    0.6.0
 */