import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Task{
    public String name;
    boolean stats;

    public Task(String name, boolean stats){
        this.name = name;
        this.stats = stats;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Belajar Java", false));
        tasks.add(new Task("Ngopi dulu", true));

        // pastikan folder data ada
        new File("data").mkdirs();

        // simpan ke file
        try (FileWriter writer = new FileWriter("data/tasks.json")) {
            new Gson().toJson(tasks, writer); // Gson otomatis bikin file kalau belum ada
            System.out.println("✅ Data berhasil disimpan di data/tasks.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
