import javax.swing.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

class data{
     public String label;
     public int prior;
     public LocalDateTime createDate;
}

public class Inbox {
    ArrayList<data> inbox = new ArrayList<>();

    Inbox() {
        data temp = new data();
        System.out.println("=== MEMBUAT INBOX BARU ===");
        System.out.print("Masukan nama      : ");
        temp.label =
        System.out.print("Masukan prioritas : ");
    }
}