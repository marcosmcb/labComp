#include <stdio.h>
#include <stdlib.h>

typedef int boolean;
#define true 1
#define false 0

typedef void(*Func)();

typedef struct _St_A {
   Func *vt;
} _class_A;

_class_A*new_A(void);
    void _A_m (_class_A *this) { 
}
Func VTclass_A[] = {
( void (*)() ) _A_m

};

_class_A *new_A()
{
_class_A*t;
if ( (t = malloc(sizeof(_class_A))) != NULL )
t->vt = VTclass_A;
return t;
}

typedef struct _St_Program {
      Func *vt;
} _class_Program;

_class_Program*new_Program(void);
       void _Program_run (_class_Program *this) { 
_class_A *_a;
int _i;
_a = new_A();
_i = ( (void (*) (_class_A *) ) _a->vt[0]) (_a);
}
Func VTclass_Program[] = {
( void (*)() ) _Program_run

};

_class_Program *new_Program()
{
_class_Program*t;
if ( (t = malloc(sizeof(_class_Program))) != NULL )
t->vt = VTclass_Program;
return t;
}

int main() {
      _class_Program *program;
      program = new_Program();
      ( ( void (*)(_class_Program *) ) program->vt[0]) (program);
      return 0;
}
