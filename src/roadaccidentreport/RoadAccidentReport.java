/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roadaccidentreport;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */


public class RoadAccidentReport {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner input = new Scanner(System.in);

        // Array to store the names of the cities
        String[] cities = {"Cape Town", "Johannesburg", "Port Elizabeth"};
        
        // Two-dimensional array to store accidents data
        // Rows represent cities, columns represent [0]: car accidents, [1]: motorbike accidents
        int[][] accidents = new int[3][2];

        // Input accidents for each city
        for (int i = 0; i < cities.length; i++) {
            System.out.print("Enter the number of car accidents for " + cities[i] + ": ");
            accidents[i][0] = input.nextInt();
            
            System.out.print("Enter the number of motor bike accidents for " + cities[i] + ": ");
            accidents[i][1] = input.nextInt();
        }

        // Generate and display the accident report
        generateReport(cities, accidents);
        
        // Close the scanner
        input.close();
    }

    // Method to generate and display the accident report
    public static void generateReport(String[] cities, int[][] accidents) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("           ROAD ACCIDENT REPORT          ");
        System.out.println("------------------------------------------------------------------------");
        // Print table header
        System.out.printf("%-20s %-15s %-15s %n", "City", "Car Accidents", "Motorbike Accidents");
        System.out.println("------------------------------------------------------------------------");

        // Display accidents for each city in table format
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-20s %-15d %-15d %n", cities[i], accidents[i][0], accidents[i][1]);
        }

        System.out.println("------------------------------------------------------------------------");

        // Calculate and display total accidents per city
        System.out.println("------------------------------------------------------------------------");
        System.out.println("       ROAD ACCIDENT TOTALS PER CITY     ");
        System.out.println("------------------------------------------------------------------------");
        int maxAccidents = 0;
        String cityWithMostAccidents = "";
        for (int i = 0; i < cities.length; i++) {
            int totalAccidents = accidents[i][0] + accidents[i][1];
            System.out.printf("%-20s %d %n", cities[i], totalAccidents);
            
            // Find the city with the most accidents
            if (totalAccidents > maxAccidents) {
                maxAccidents = totalAccidents;
                cityWithMostAccidents = cities[i];
            }
        }

        // Display the city with the most vehicle accidents
        System.out.println("------------------------------------------------------------------------");
        System.out.println("CITY WITH THE MOST VEHICLE ACCIDENTS: " + cityWithMostAccidents);
        System.out.println("------------------------------------------------------------------------");
    }
}