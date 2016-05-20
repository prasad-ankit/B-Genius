package com.badlogic.gdx.utils;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;

public class GdxBuild
{
  public static void main(String[] paramArrayOfString)
  {
    new NativeCodeGenerator().generate("src", "bin", "jni", new String[] { "**/*" }, null);
    String[] arrayOfString = { "android/**", "iosgl/**" };
    BuildTarget localBuildTarget1 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Windows, false);
    localBuildTarget1.compilerPrefix = "";
    localBuildTarget1.buildFileName = "build-windows32home.xml";
    localBuildTarget1.excludeFromMasterBuildFile = true;
    localBuildTarget1.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget2 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Windows, false);
    localBuildTarget2.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget3 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Windows, true);
    localBuildTarget3.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget4 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Linux, false);
    localBuildTarget4.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget5 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Linux, true);
    localBuildTarget5.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget6 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.Android, false);
    localBuildTarget6.linkerFlags += " -lGLESv2 -llog";
    localBuildTarget6.cppExcludes = new String[] { "iosgl/**" };
    BuildTarget localBuildTarget7 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.MacOsX, false);
    localBuildTarget7.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget8 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.MacOsX, true);
    localBuildTarget8.cppExcludes = arrayOfString;
    BuildTarget localBuildTarget9 = BuildTarget.newDefaultTarget(BuildTarget.TargetOs.IOS, false);
    localBuildTarget9.cppExcludes = new String[] { "android/**" };
    localBuildTarget9.headerDirs = new String[] { "iosgl" };
    new AntScriptGenerator().generate(new BuildConfig("gdx", "../target/native", "libs", "jni"), new BuildTarget[] { localBuildTarget7, localBuildTarget8, localBuildTarget1, localBuildTarget2, localBuildTarget3, localBuildTarget4, localBuildTarget5, localBuildTarget6, localBuildTarget9 });
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.GdxBuild
 * JD-Core Version:    0.6.0
 */