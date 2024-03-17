package com.github.BeadiestStar64.JNI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DynamicJNIDescription {

    // Native library load
    static {
        String libFolderName = "lib"; // With a name of your choice.
        String libFile = "library"; // With a name of your choice.

        if (checkLib("native")) {
            copyResource(libFolderName, libFile);

            // load library
            try {
                System.loadLibrary(libFile);
            } catch (UnsatisfiedLinkError error) {
                System.err.println("Cannot load library file.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Check if the library can be loaded here in advance.
    // If it cannot be loaded, it is assumed that the file is missing.
    private static boolean checkLib(String libName) {
        try {
            System.loadLibrary(libName);
            return false;
        } catch (UnsatisfiedLinkError error) {
            return true;
        }
    }

    // Copy the dll from the resource and paste it into the lib folder.
    private static void copyResource(String libFolderPath, String libFile) {
        String libFileName = System.mapLibraryName(libFile);

        File libFolder = new File(libFolderPath);
        if (!libFolder.exists()) {
            libFolder.mkdir();
        }

        Path libPath = Paths.get(libFolderPath, libFileName);
        if (!Files.exists(libPath)) {
            try (InputStream input = DynamicJNIDescription.class.getResourceAsStream(File.separator + libFileName)) {
                if (input != null) {
                    Files.copy(input, libPath, StandardCopyOption.REPLACE_EXISTING);
                } else {
                    System.err.println("Failed to find the library in resource!");
                }
            } catch (IOException e) {
                System.err.println("Failed to copy the library from resources : " + e.getMessage());
            }
        }
    }
}