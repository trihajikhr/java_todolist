package todolist;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;

class mark {
    public String colname;
    public Color color;

    mark(){};

    mark(String colname, Color color){
        this.colname = colname;
        this.color = color;
    }
}

public class Workspace {
    public String label;
    public String description;
    public LocalDate dateCreated;
    ArrayList<Project> projek = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Helper help = new Helper();

    Workspace(String label, String description) {
        this.label = label;
        this.description = description;
        this.dateCreated = LocalDate.now();
    }

    Workspace(){}

    public void mainMenu() {
        int a;
        do {
            System.out.println("===== WORKSPACE " + label + " =====");
            System.out.println("1. Menuju Project");
            System.out.println("2. Daftar Project");
            System.out.println("3. Tambah Project");
            System.out.println("0. Keluar");
            a = help.safeInput("Pilihan Anda: ", 0, 3);

            switch (a) {
                case 1:
                    if(projek.isEmpty()){
                        System.out.println("Projek Kosong!");
                        help.skip();
                        continue;
                    }
                    //TODO: PR disini
                    printProject();
                    break;
                case 2:
                    if(projek.isEmpty()){
                        System.out.println("Projek Kosong!");
                        help.skip();
                        continue;
                    }
                    projectDetail();
                    break;
                case 3:
                    addPProject();
                    break;
            }
        } while(a != 0);
        help.skip();
    }

    public void printProject(){
        for(int i=0; i< projek.size(); i++){
            System.out.println((i+1) + ") " + projek.get(i).label);
        }
        help.skip();;
    }

    public void projectDetail(){
        System.out.println("\n============= PROJECT DETAIL =============");
        for(int i=0; i< projek.size(); i++){
            System.out.println((i+1) + ") Project -> [" + projek.get(i).label + "]");
            System.out.println("Description : " +  projek.get(i).description);
            System.out.println("Priority    : " +   projek.get(i).prior);
            System.out.println("Start Time  : " +  projek.get(i).startTime);
            System.out.println("End Time    : " +  projek.get(i).endTime);
            help.skip();
        }
    }

    public void addPProject(){
        Project temp = new Project();
        temp.label = help.safeStringInput("Nama Project                 : ", 20);
        System.out.print("Masukan deskripsi            : ");
        temp.description = scan.nextLine();
        System.out.print("Masukan skala prioritas      : ");
        temp.prior = scan.nextInt();
        temp.startTime = help.safeDateInput("Tanggal mulai (dd/mm/yyyy )  : ");
        temp.endTime = help.safeDateInput("Tanggal selesai (dd/mm/yyyy ): ");

        int a = help.safeInput("\nTerapkan penambahan (1:ya, 0:batal): ", 0, 1);
        switch (a) {
            case 1:
                System.out.println("Project [" + temp.label + "] added successfully!");
                projek.add(temp);
                break;
            case 0:
                System.out.println("Penambahan dibatalkan!");
        }
        help.skip();
    }
}
