import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Welcome to the metric converter!");
        System.out.println("Please input your query. For example, 1 km = m.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            System.out.print("Input your conversion (e.g., '1 kg = lb'): ");
            input = scanner.nextLine().toLowerCase().trim();
            
            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Process the input and check for valid conversions
            if (input.contains("km = m")) {
                convertKmToM(input);
            } else if (input.contains("kg = lb")) {
                convertKgToLb(input);
            } else if (input.contains("m = ft")) {
                convertMToFt(input);
            } else if (input.contains("cm = in")) {
                convertCmToIn(input);
            } else {
                System.out.println("Your input is not currently handled by this app, please input another query.");
                System.out.println("For example, try: 1 km = m, 1 kg = lb, 1 m = ft, or 1 cm = in.");
            }
        }
        
        scanner.close();
    }

    private static void convertKmToM(String input) {
        try {
            double value = extractValue(input);
            double result = value * 1000;
            System.out.println(value + " km is " + result + " m.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number before 'km = m'.");
        }
    }

    private static void convertKgToLb(String input) {
        try {
            double value = extractValue(input);
            double result = value * 2.20462; // 1 kg = 2.20462 lbs
            System.out.println(value + " kg is " + result + " lbs.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number before 'kg = lb'.");
        }
    }

    private static void convertMToFt(String input) {
        try {
            double value = extractValue(input);
            double result = value * 3.28084; // 1 m = 3.28084 feet
            System.out.println(value + " m is " + result + " feet.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number before 'm = ft'.");
        }
    }

    private static void convertCmToIn(String input) {
        try {
            double value = extractValue(input);
            double result = value * 0.393701; // 1 cm = 0.393701 inches
            System.out.println(value + " cm is " + result + " inches.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number before 'cm = in'.");
        }
    }

    private static double extractValue(String input) throws NumberFormatException {
        String[] parts = input.split(" ");
        return Double.parseDouble(parts[0]);
    }
}
