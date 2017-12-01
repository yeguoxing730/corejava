/*myclass.cpp*/
#include "myclass.h"
myClass::myClass()
{
    ID=0;
    vector=std::vector<int>();
}

myClass::myClass(int id, std::vector<int> v)
{
    ID=id;
    vector=v;
}

void myClass::setID(int id)
{
    ID=id;
}

int myClass::getID()
{
    return ID;
}


void myClass::setVector(std::vector<int> v)
{
    vector=v;
}
std::vector<int> myClass::getVector()
{
    return vector;
}

void myClass::insertIntoVector(int num)
{
    std::vector<int>::iterator it;
    it=vector.end();
    vector.insert(it,num);
}

void myClass::printVector()
{
    std::vector<int>::iterator it;
    for (it=vector.begin(); it<vector.end(); it++)
        std::cout << ' ' << *it<< std::endl;
}