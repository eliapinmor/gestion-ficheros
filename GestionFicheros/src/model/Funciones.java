/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author eliapinmor
 */
public class Funciones {

    public static void createFolder(String folderName) {
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = path + separador + folderName;
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

    }

    public static void createFile(String path, String fileName, String content) throws IOException {

        String separador = File.separator;

        File carpeta = new File(path);

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        File fichero = new File(carpeta, fileName);

        FileWriter fw = new FileWriter(fichero, true);

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.newLine();
        bw.flush();
        bw.close();

    }

    public static String[] showListFiles(String path) {
        File carpeta = new File(path);
        String[] list = carpeta.list();

        return list;

    }

    public static String showFile(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;

        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\Z");
        String contenido = scan.next();
        return contenido;
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        String separador = File.separator;

        File carpeta = new File(path);

        if (!carpeta.exists()) {
            return false;
        }
        File fichero = new File(carpeta, fileName);

        FileWriter fw = new FileWriter(fichero, true);

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(newContent);
        bw.newLine();
        bw.flush();
        bw.close();

        return true;
    }

    public static void deleteFile(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        fichero.delete();

    }

    public static int countChars(String path, String fileName) throws FileNotFoundException, IOException {
        FileReader fr = null;
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        fr = new FileReader(fichero);
        int caract = fr.read();
        int numChars = 0;
        while (caract != -1) {
            numChars ++;
            caract = fr.read();
        }

        return numChars;
    }

    public static int countWords(String path, String fileName) throws FileNotFoundException  {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\s+");
        int numWords = 0;
        while (scan.hasNext()) {
            scan.next();
            numWords ++;
        }

        return numWords;
    }

    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws FileNotFoundException, IOException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        Scanner scan = new Scanner(fichero);
        
        FileWriter fw = new FileWriter(fichero, false);

        BufferedWriter bw = new BufferedWriter(fw);
        
        scan.useDelimiter("\\s+");
        int numWords = 0;
        while (scan.hasNext()) {
            System.out.println("hemos entrado en el bucle");
            String palabra = scan.next(); // Captura la palabra
            if (palabra.equals(oldWord)) {
                System.out.println("hemos encontrado una coincidencia");
                palabra = palabra.replace(oldWord, newWord);
            }
             bw.write(palabra + " ");

            
        }
                     bw.flush();
        bw.close();
        return null;

    }
}
