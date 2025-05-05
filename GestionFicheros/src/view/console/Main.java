/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funciones;

/**
 *
 * @author eliapinmor
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion = "";
        scan.useDelimiter("\n");

        do {
            System.out.println("MENU");
            System.out.println("1. - crear carpeta");
            System.out.println("2. - crear archivo");
            System.out.println("3. - listar archivos");
            System.out.println("4. - mostrar archivo");
            System.out.println("5. - sobreeescribir archivo");
            System.out.println("6. - eliminar archivo");
            System.out.println("7. - contar char de archivo");
            System.out.println("8. - contar palabras de archivo");
            System.out.println("9. - reemplazar palabras de archivo");
            System.out.println("Z. - salir");
            System.out.println("Opcion: ");
            opcion = scan.next();
            switch (opcion) {
                case "1":
                    testCreateFolder();
                    break;
                case "2":
                    testCreateFile();
                    break;
                case "3":
                    testShowListFiles();
                    break;
                case "4":
                    testShowFile();
                    break;
                case "5":
                    testOverWriteFile();
                    break;
                case "6":
                    testDeleteFile();
                    break;
                case "7":
                    testCountChars();
                    break;
                case "8":
                    testCountWords();
                    break;
                case "9":
                    testSwapWords();
                    break;
                case "Z":
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }

        } while (!opcion.equals("Z"));
    }

    static void testCreateFolder() {
        System.out.println("introduce el nombre de la carpeta: ");
        String folderName = scan.next();
        Funciones.createFolder(folderName);
        System.out.println("carpeta creada correctamente");
    }

    static void testCreateFile() {
        try {
            System.out.println("introduce el nombre de la ruta donde crear el archivo: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            System.out.println("introduce el contenido del archivo: ");
            String content = scan.next();
            Funciones.createFile(path, fileName, content);
            System.out.println("carpeta creada correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void testShowListFiles() {
        System.out.println("Introduce el nombre de la ruta: ");
        String path = scan.next();
        String[] list = Funciones.showListFiles(path);
        System.out.println(Arrays.toString(list));
    }

    static void testShowFile() {

        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            String contenido = Funciones.showFile(path, fileName);
            System.out.println(contenido);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    static void testOverWriteFile() {
        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            System.out.println("introduce el nuevo contenido: ");
            String newContent = scan.next();
            Boolean modifyOk = Funciones.overWriteFile(path, fileName, newContent);

            if (modifyOk) {
                System.out.println("fichero modificado correctamente, si quiere ver el contenido del fichero pulse 1, si desea salir pulse cualquier otra tecla");
                String verFichero = scan.next();
                switch (verFichero) {
                    case "1":
                        String contenido = Funciones.showFile(path, fileName);
                        System.out.println(contenido);
                        break;
                    default:
                        System.out.println("saliendo...");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static void testDeleteFile() {
        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            Funciones.deleteFile(path, fileName);
            System.out.println("fichero eliminado correctamente");
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static void testCountChars() {
        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            int resultado = Funciones.countChars(path, fileName);
            System.out.println("El numero de caracteres es: " + resultado);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void testCountWords() {
        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            int resultado = Funciones.countWords(path, fileName);
            System.out.println("El numero de palabras es: " + resultado);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void testSwapWords() {
        try {
            System.out.println("Introduce la ruta: ");
            String path = scan.next();
            System.out.println("introduce el nombre del archivo: ");
            String fileName = scan.next();
            System.out.println("Introduce la palabra a sustituir: ");
            String oldWord = scan.next();
            System.out.println("introduce la nueva palabra: ");
            String newWord = scan.next();
            String resultado = Funciones.swapWords(path, fileName, oldWord, newWord);
            System.out.println("Fichero modificado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
