#include <iostream>
#include <jni.h>
#include "DynamicH.h"

using namespace std;

void sayHello() {
    cout << "Hello World!\nWelcome to JNI!\n" << endl;
}

JNIEXPORT void JNICALL Java_com_github_BeadiestStar64_JNI_DynamicJNIDescription_sayHello (
    JNIEnv* env, jobject object) {
        sayHello();
    }