package com.badlogic.gdx.physics.box2d.utils;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;
import java.io.File;

public class Box2DBuild
{
  public static void main(String[] paramArrayOfString)
  {
    BuildTarget localBuildTarget1 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Windows, false);
    BuildTarget localBuildTarget2 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Windows, true);
    BuildTarget localBuildTarget3 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Linux, false);
    BuildTarget localBuildTarget4 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Linux, true);
    BuildTarget localBuildTarget5 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Android, false);
    BuildTarget localBuildTarget6 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.MacOsX, false);
    BuildTarget localBuildTarget7 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.MacOsX, true);
    BuildTarget localBuildTarget8 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.IOS, false);
    new NativeCodeGenerator().generate("src", "bin" + File.pathSeparator + "../../../gdx/bin", "jni");
    new AntScriptGenerator().generate(new BuildConfig("gdx-box2d"), new BuildTarget[] { localBuildTarget1, localBuildTarget2, localBuildTarget3, localBuildTarget4, localBuildTarget6, localBuildTarget7, localBuildTarget5, localBuildTarget8 });
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.utils.Box2DBuild
 * JD-Core Version:    0.6.0
 */