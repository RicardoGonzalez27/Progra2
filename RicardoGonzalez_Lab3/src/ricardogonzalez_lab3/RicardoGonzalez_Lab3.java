package ricardogonzalez_lab3;

import java.util.*;
import javax.swing.JOptionPane;

public class RicardoGonzalez_Lab3 {

    static ArrayList Detectives = new ArrayList();
    static ArrayList Casos = new ArrayList();
    static ArrayList Evidencias = new ArrayList();

    public static void main(String[] args) {
        String op = "0";
        while (!op.equals("5")) {
            op = JOptionPane.showInputDialog(
                    null, "Bienvenido a SILLA\n"
                    + "Eliga su opcion.\n"
                    + "1. Log In.\n"
                    + "2. Agregar Detective.\n"
                    + "3. Modificar Detective.\n"
                    + "4. Eliminar Detective.\n"
                    + "5. Salir del Sistema (Advertencia, guardado no disponible.)", "SILLA", JOptionPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

            if (op.equals("1")) {
                String User = "";
                String Pass = "";
                do {
                    User = JOptionPane.showInputDialog("Usuario: ");
                } while (User.equalsIgnoreCase(""));
                do {
                    Pass = JOptionPane.showInputDialog("Contraseña: ");
                } while (Pass.equalsIgnoreCase(""));
                if (Detectives.contains(User) && Detectives.contains(Pass)) {
                    LogIn(User);
                } else {
                    JOptionPane.showMessageDialog(null, "No Existe.");
                }
            }
            if (op.equals("2")) {
                Add();
            }
            if (op.equals("3")) {
                String Use = "";
                do {
                    Use = JOptionPane.showInputDialog("Usuario: ");
                } while (Use.equalsIgnoreCase(""));
                if (Detectives.contains(Use)) {
                    int send = Detectives.indexOf(Use);
                    Mod(send);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no Encontrado.");
                }
            }
            if (op.equals("4")) {
                String delete = "";
                delete = JOptionPane.showInputDialog(null, "Ingrese Usuario a Eliminar.", "Eliminacion", JOptionPane.WARNING_MESSAGE);

                if (Detectives.contains(delete)) {
                    int savepos = Detectives.indexOf(delete);
                    for (int i = savepos; i < savepos + 7; i++) {
                        Detectives.remove(savepos);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(null, "No Existe.");
                }
            }
        }
    }

    public static void LogIn(String User) {
        String exe;
        do {
            exe = JOptionPane.showInputDialog(null, "Bienvenido\n " + User + "\n"
                    + "Que accion desea realizar?\n"
                    + "1. Revision de Datos.\n"
                    + "2. Revision de Casos.\n"
                    + "3. Registrar un Caso.\n"
                    + "4. Modificar Caso.\n"
                    + "5. Enviar Mensaje.\n"
                    + "6. Ver Mensajes.\n"
                    + "7. Log Out.\n", "Log In", JOptionPane.QUESTION_MESSAGE);
            if (exe.equals("1")) {
                String salida = "";
                for (int i = Detectives.indexOf(User); i < Detectives.indexOf(User) + 7; i++) {
                    salida += Detectives.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, salida, User, JOptionPane.QUESTION_MESSAGE);
            }
            if (exe.equals("2")) {
                String salida = "";
                for (int i = 0; i < Casos.size(); i++) {
                    if (Casos.get(i) == User) {
                        salida += Detectives.get(i+1) + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, salida, "Casos de "+User, JOptionPane.QUESTION_MESSAGE);
            }
        } while (!exe.equals("7"));
        if(exe.equals("3")){
            AddCaso(User);
        }
        if (exe.equals("4")) {
            ModCaso(User);
        }
    }
    
    public static void AddEvidencias(String Use, String Nombre){
        Evidencias.add(Nombre);
        String Ev;
        do{
        Ev = JOptionPane.showInputDialog("Ingrese Evidencia, ingrese nada para salir.");
        if(!Ev.equals("")){
            Evidencias.add(Ev);
        }
        }while(!Ev.equals(""));
    }
    
    public static void ModCaso(String Use) {
        String Nombre, Lugar, Des, Tipo, Det, Estado;
        do {
            Nombre = JOptionPane.showInputDialog(null, "Nombre del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Nombre.equalsIgnoreCase(""));
        Casos.add(Nombre);
        do {
            Lugar = JOptionPane.showInputDialog(null, "Lugar del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Lugar.equalsIgnoreCase(""));
        Casos.add(Lugar);
        do {
            Des = JOptionPane.showInputDialog(null, "Descripcion del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Des.equalsIgnoreCase(""));
        Casos.add(Des);
        do {
            Tipo = JOptionPane.showInputDialog(null, "Tipo de Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (!Tipo.equalsIgnoreCase("homicidio") || !Tipo.equalsIgnoreCase("robo") || !Tipo.equalsIgnoreCase("secuestro") || !Tipo.equalsIgnoreCase("violacion"));
        Casos.add(Tipo);
        Casos.add(Use);
        do {
            Estado = JOptionPane.showInputDialog(null, "Estado del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (!Estado.equalsIgnoreCase("proceso") || !Tipo.equalsIgnoreCase("en proceso") || !Tipo.equalsIgnoreCase("resuelto") || !Tipo.equalsIgnoreCase("ya resuelto"));
        Casos.add(Estado);
        AddEvidencias(Use, Nombre);
    }
    
    public static void AddCaso(String Use) {
        String Nombre, Lugar, Des, Tipo, Det, Estado;
        do {
            Nombre = JOptionPane.showInputDialog(null, "Nombre del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Nombre.equalsIgnoreCase(""));
        Casos.add(Nombre);
        do {
            Lugar = JOptionPane.showInputDialog(null, "Lugar del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Lugar.equalsIgnoreCase(""));
        Casos.add(Lugar);
        do {
            Des = JOptionPane.showInputDialog(null, "Descripcion del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (Des.equalsIgnoreCase(""));
        Casos.add(Des);
        do {
            Tipo = JOptionPane.showInputDialog(null, "Tipo de Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (!Tipo.equalsIgnoreCase("homicidio") || !Tipo.equalsIgnoreCase("robo") || !Tipo.equalsIgnoreCase("secuestro") || !Tipo.equalsIgnoreCase("violacion"));
        Casos.add(Tipo);
        Casos.add(Use);
        do {
            Estado = JOptionPane.showInputDialog(null, "Estado del Caso: ", "Agregar Caso", JOptionPane.QUESTION_MESSAGE);
        } while (!Estado.equalsIgnoreCase("proceso") || !Tipo.equalsIgnoreCase("en proceso") || !Tipo.equalsIgnoreCase("resuelto") || !Tipo.equalsIgnoreCase("ya resuelto"));
        Casos.add(Estado);
        AddEvidencias(Use, Nombre);
    }

    public static void Add() {
        String Nombre, Edad, Nacio, Años, Nivel, User, Contra;
        do {
            User = JOptionPane.showInputDialog(null, "Usuario del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (User.equalsIgnoreCase(""));
        Detectives.add(User);
        do {
            Nombre = JOptionPane.showInputDialog(null, "Nombre del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nombre.equalsIgnoreCase(""));
        Detectives.add(Nombre);
        do {
            Edad = JOptionPane.showInputDialog(null, "Edad del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Edad.equalsIgnoreCase(""));
        Detectives.add(Edad);
        do {
            Nacio = JOptionPane.showInputDialog(null, "Fecha de Nacimiento del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nacio.equalsIgnoreCase(""));
        Detectives.add(Nacio);
        do {
            Años = JOptionPane.showInputDialog(null, "Años Laborales del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Años.equalsIgnoreCase(""));
        Detectives.add(Años);
        do {
            Nivel = JOptionPane.showInputDialog(null, "Nivel del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nivel.equalsIgnoreCase(""));
        Detectives.add(Nivel);
        do {
            Contra = JOptionPane.showInputDialog(null, "Contraseña del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Contra.equalsIgnoreCase(""));
        Detectives.add(Contra);
    }

    public static void Mod(int Use) {
        String Nombre, Edad, Nacio, Años, Nivel, User, Contra;
        do {
            User = JOptionPane.showInputDialog(null, "Usuario del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (User.equalsIgnoreCase(""));
        Detectives.set(Use, User);
        do {
            Nombre = JOptionPane.showInputDialog(null, "Nombre del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nombre.equalsIgnoreCase(""));
        Detectives.set(Use + 1, Nombre);
        do {
            Edad = JOptionPane.showInputDialog(null, "Edad del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Edad.equalsIgnoreCase(""));
        Detectives.set(Use + 2, Edad);
        do {
            Nacio = JOptionPane.showInputDialog(null, "Fecha de Nacimiento del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nacio.equalsIgnoreCase(""));
        Detectives.set(Use + 3, Nacio);
        do {
            Años = JOptionPane.showInputDialog(null, "Años Laborales del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Años.equalsIgnoreCase(""));
        Detectives.set(Use + 4, Años);
        do {
            Nivel = JOptionPane.showInputDialog(null, "Nivel del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Nivel.equalsIgnoreCase(""));
        Detectives.set(Use + 5, Nivel);
        do {
            Contra = JOptionPane.showInputDialog(null, "Contraseña del Detective: ", "Agregar Detective", JOptionPane.QUESTION_MESSAGE);
        } while (Contra.equalsIgnoreCase(""));
        Detectives.set(Use + 6, Contra);
    }

}
