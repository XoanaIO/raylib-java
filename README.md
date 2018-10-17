
# Raylib-Java

A thin (not yet ergonomic) Java Wrapper for [Raylib](https://github.com/raysan5/raylib).

---

### Release Notes:
#### 2018.10.11
Raylib-Java is not yet production ready or battle hardened.  The current release, 2018.10, most closely matches a 0.0.1-alpha build.  It is available here only as proof that things are moving forward. 

### Download:

If you don't much care for warnings and scoff at the idea of heeding common sense, you can download the initial 0.0.1 release here for Windows64 machines.

### Usage:

Raylib-Java is not yet hosted in Maven Central, but you can use it in your project like so:

1) Inside your project folder at the top level (next to src), create a folder named 'libs'.
2) Download raylib-java-xxxx.xx.jar and place it in this folder.
3) Update your build.gradle file to include the following: 
```
repositories {
	...
	flatDir {
		dirs 'libs'
	}
}

dependencies {
   compile name: 'raylib-java-xxxx.xx' // Note that this does not end in .jar!
}
``` 

### TODO:

- [ ] Convert RaylibConstants from method calls to Java types. (Performance)
- [ ] Make sure NATIVE_INT_SIZE is automatically generated. (Build)
- [ ] Make sure that build process is reproducible and doesn't obliterate work on headers.  (Build)
- [ ] AWT robot testing. (Build)
- [ ] Automatically load for all native platforms. (Usability)
- [ ] Javadoc/Inline doc for IDE completion. (Usability)
- [ ] Helper methods on vectors like sum/product. (Usability)  
- [x] Extra methods on Material to get/set specific map types. (Usability)
- [ ] Update LoadFontEx so that String is properly converted to an int array of Unicode points. (Usability)
- [ ] A method that will first search for files on-drive, then check JAR resources. (Usability)

### License and Legal Nonsense:
Raylib is Copyright (c) 2013-2018 Ramon Santamaria (@raysan5).

The Raylib-Java is Copyright (c) 2018 Xoana LTD. 

Raylib-Java is offered under the MIT License.
