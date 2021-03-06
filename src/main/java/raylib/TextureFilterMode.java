/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package raylib;

public final class TextureFilterMode {
  public final static TextureFilterMode FILTER_POINT = new TextureFilterMode("FILTER_POINT", RaylibJNI.FILTER_POINT_get());
  public final static TextureFilterMode FILTER_BILINEAR = new TextureFilterMode("FILTER_BILINEAR");
  public final static TextureFilterMode FILTER_TRILINEAR = new TextureFilterMode("FILTER_TRILINEAR");
  public final static TextureFilterMode FILTER_ANISOTROPIC_4X = new TextureFilterMode("FILTER_ANISOTROPIC_4X");
  public final static TextureFilterMode FILTER_ANISOTROPIC_8X = new TextureFilterMode("FILTER_ANISOTROPIC_8X");
  public final static TextureFilterMode FILTER_ANISOTROPIC_16X = new TextureFilterMode("FILTER_ANISOTROPIC_16X");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static TextureFilterMode swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + TextureFilterMode.class + " with value " + swigValue);
  }

  private TextureFilterMode(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private TextureFilterMode(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private TextureFilterMode(String swigName, TextureFilterMode swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static TextureFilterMode[] swigValues = { FILTER_POINT, FILTER_BILINEAR, FILTER_TRILINEAR, FILTER_ANISOTROPIC_4X, FILTER_ANISOTROPIC_8X, FILTER_ANISOTROPIC_16X };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

