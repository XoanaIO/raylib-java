/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package raylib;

public class Font {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Font(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Font obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RaylibJNI.delete_Font(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTexture(Texture2D value) {
    RaylibJNI.Font_texture_set(swigCPtr, this, Texture2D.getCPtr(value), value);
  }

  public Texture2D getTexture() {
    long cPtr = RaylibJNI.Font_texture_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Texture2D(cPtr, false);
  }

  public void setBaseSize(int value) {
    RaylibJNI.Font_baseSize_set(swigCPtr, this, value);
  }

  public int getBaseSize() {
    return RaylibJNI.Font_baseSize_get(swigCPtr, this);
  }

  public void setCharsCount(int value) {
    RaylibJNI.Font_charsCount_set(swigCPtr, this, value);
  }

  public int getCharsCount() {
    return RaylibJNI.Font_charsCount_get(swigCPtr, this);
  }

  public void setChars(CharInfo value) {
    RaylibJNI.Font_chars_set(swigCPtr, this, CharInfo.getCPtr(value), value);
  }

  public CharInfo getChars() {
    long cPtr = RaylibJNI.Font_chars_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CharInfo(cPtr, false);
  }

  public Font() {
    this(RaylibJNI.new_Font(), true);
  }

}