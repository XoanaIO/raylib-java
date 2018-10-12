/* raylib.i */
/* Build instructions:
swig -java -package raylib raylib.i
gcc -c raylib_wrap.c -I/c/Program\ Files/Java/jdk1.8.0_131/include -I/c/Program\ Files/Java/jdk1.8.0_131/include/win32
gcc -shared raylib_wrap.o -lraylib -lglfw3 -lgdi32 -lopengl32 -L./ -Wl,--add-stdcall-alias -o raylib.dll
*/
 %module Raylib
 %{
/* Put header files here or function declarations like below */
/* extern bool maybe; */
#include "raylib.h"
%}

%include "raylib.h"
