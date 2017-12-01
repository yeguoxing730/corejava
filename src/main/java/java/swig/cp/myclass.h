/*myclass.h*/
#define MYCLASS_H
#ifndef MYCLASS_H
#include <vector>
#include <iostream>

class myClass
{
private:
    int ID;
    std::vector<int> vector;

public:
    myClass();
    myClass(int id, std::vector<int> v);

    void setID(int id);
    int getID();

    void setVector(std::vector<int> v);
    std::vector<int> getVector();

    void insertIntoVector(int num);
    void printVector();
};

#endif // MYCLASS_H