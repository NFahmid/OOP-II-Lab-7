package utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVUtils {

    public static List<String[]> readCSV(String filePath) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return rows;
    }

    public static void appendToCSV(String filePath, String[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("filePath", true))) {
            bw.write(String.join(",", data));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static boolean updateCSV(String filePath, String username, String[] newData) {
        boolean found = false;
        List<String[]> rows = readCSV(filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : rows) {
                if (row[0].equals(username)) {
                    bw.write(String.join(",", newData));
                    found = true;
                } else {
                    bw.write(String.join(",", row));
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
        return found;
    }

    public static boolean isDuplicate(String filePath, String username, String email) {
        List<String[]> rows = readCSV(filePath);
        for (String[] row : rows) {
            if (row[0].equals(username) || row[1].equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean renameFile(String oldPath, String newPath) {
        try {
            Files.move(Paths.get(oldPath), Paths.get(newPath), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.out.println("Error renaming file: " + e.getMessage());
            return false;
        }
    }
}
