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

    /**
     * creates a folder in the users path
     *
     * @param folderName name of the folder
     */
    public static void createFolder(String folderName) {
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = path + separador + folderName;
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

    }

    /**
     *
     * creates file on a path, if the folder doesn't exist it creates one
     *
     * @param path the path where the file is created
     * @param fileName the name of the file
     * @param content the content of the file
     * @throws IOException
     *
     */
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

    /**
     * show list of files in the written path
     *
     * @param path
     * @return String[] list of files
     */
    public static String[] showListFiles(String path) {
        File carpeta = new File(path);
        String[] list = carpeta.list();

        return list;

    }

    /**
     * show content of file
     *
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static String showFile(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;

        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\Z");
        String contenido = scan.next();
        return contenido;
    }

    /**
     * add content to a file
     *
     * @param path
     * @param fileName
     * @param newContent
     * @return boolean, false -> folder doesn't exist
     * @throws IOException
     */
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

    /**
     * delete selected file
     *
     * @param path
     * @param fileName
     * @throws FileNotFoundException
     */
    public static void deleteFile(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        fichero.delete();

    }

    /**
     * to count the number of characters of a file
     *
     * @param path
     * @param fileName
     * @return int - num of chars
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int countChars(String path, String fileName) throws FileNotFoundException, IOException {
        FileReader fr = null;
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        fr = new FileReader(fichero);
        int caract = fr.read();
        int numChars = 0;
        while (caract != -1) {
            numChars++;
            caract = fr.read();
        }

        return numChars;
    }

    /**
     * to count the number of words of a file
     *
     * @param path
     * @param fileName
     * @return int - num of words
     * @throws FileNotFoundException
     */
    public static int countWords(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\s+");
        int numWords = 0;
        while (scan.hasNext()) {
            scan.next();
            numWords++;
        }

        return numWords;
    }

    /**
     * reads all the content of the file and then replaces the old word for the
     * new one using java method .replace()
     *
     * @param path
     * @param fileName
     * @param oldWord
     * @param newWord
     * @return String - new file content
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String swapWords(String path, String fileName, String oldWord, String newWord) throws FileNotFoundException, IOException {
        String separador = File.separator;

        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\Z");
        String contenido = scan.next();
        contenido = contenido.replace(oldWord, newWord);
        FileWriter fw = new FileWriter(fichero, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
        return contenido;

    }
}
