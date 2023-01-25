import java.io.*;

class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                calculateAndPrint(line);
                saveToResults(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToResults(String line) {
        String[] numbersAndOperator = line.split(" ");
        double a = Double.parseDouble(numbersAndOperator[0]);
        double b = Double.parseDouble(numbersAndOperator[2]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
            switch (numbersAndOperator[1]) {
                case "+" -> writer.write(line + " = " + (a + b) + "\n");
                case "-" -> writer.write(line + " = " + (a - b) + "\n");
                case "*" -> writer.write(line + " = " + (a * b) + "\n");
                case "/" -> writer.write(line + " = " + (a / b) + "\n");
                default -> writer.write("nieprawidłowe dane" + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateAndPrint(String line) {
        String[] numbersAndOperator = line.split(" ");
        double a = Double.parseDouble(numbersAndOperator[0]);
        double b = Double.parseDouble(numbersAndOperator[2]);

        switch (numbersAndOperator[1]) {
            case "+" -> System.out.println(a + " + " + b + " = " + (a + b));
            case "-" -> System.out.println(a + " - " + b + " = " + (a - b));
            case "*" -> System.out.println(a + " * " + b + " = " + (a * b));
            case "/" -> System.out.println(a + " / " + b + " = " + (a / b));
            default -> System.out.println("nieprawidłowe dane");
        }
    }
}