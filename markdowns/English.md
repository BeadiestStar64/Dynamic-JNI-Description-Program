# ENGLISH Help
## Language used
<img src="https://img.shields.io/badge/-C++-blue?logo=cplusplus"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">

Java handles the front and C++ runs in the back.

## Overview
I was interested in JNI, but when I looked into it, I couldn't find much information.  
So I decided to research everything I could find about JNI and make it available to everyone on GitHub.  
Now there is no need to fear JNI!

## What is JNI?
JNA (Java Native Interface) can use C/C++ code by dynamic library.  
But, **this explanation does not accurate.**  
Please check [wikipedia](https://en.wikipedia.org/wiki/Java_Native_Interface), or you could search by Google.

## How to use?
1. **Make sure Java and G++ are installed**.  
Without them, nothing can be done. Yes, If you don't have these, you are wasting your time looking at this repository.  
   This time, since we will be operating manually from the command line.  
**Don't forget to check your pc's Java and G++ path**.
2. **Use native modifiers to define methods and libraries to be used**.  
See the code below.  
> [!TIP]
> If you are using a Mac, the extension of the dynamic library is .dylib. Linux would be .so.

```java
public class HelloWorldJNI {
    // Load library file
    static {
        System.loadLibrary("Your library file name");
    }
    
    public static void main(String[] args) {
        new HelloWorldJNI().hello();
    }
    
    // Native method
    public native void hello();
}
```

## Reference
- [Guide to JNI(Java Native Interface)](https://medium.com/nerd-for-tech/guide-to-jni-java-native-interface-5b63fea01828)
- [Translate by DeepL](https://www.deepl.com/translator)

## Licence
This repository uses the [MIT license](../LICENSE).