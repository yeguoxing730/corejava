/*myclass.i*/
%module test
%{
#include "myclass.h"
%}

%include "std_vector.i"
namespace std {
   %template(IntVector) vector<int>;
}

%include "myclass.h"