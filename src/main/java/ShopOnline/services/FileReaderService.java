package ShopOnline.services;

import ShopOnline.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
    public static void main(String[] args) {
        String file1Path = "ListOfProducts.txt";
        String file2Path = "ListOfCategories.txt";
        String file3Path = "ListOfOrders.txt";

        Product[] products = readProductsFromFile(file1Path);

        readFile(file1Path);
        readFile(file2Path);
        readFile(file3Path);
    }

    public static Product[] readProductsFromFile(String filePath) {
        Product[] products = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int numOfLines = 0;
            while ((line = br.readLine()) != null) {
                numOfLines++;
            }
            products = new Product[numOfLines];

            br.close();
            br = new BufferedReader(new FileReader(filePath));
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    String category = parts[2];
                    int quantity = Integer.parseInt(parts[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
