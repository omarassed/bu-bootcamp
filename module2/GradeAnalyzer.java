import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        String filename = "numbers.txt";
        String report = "report.txt";
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(filename);
        // Step 2: calculate statistics
        double average = calculateAverage(scores);
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }
        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, report);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line.trim());
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score: " + line);
                }

            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) return 0.0;
        double sumScores = 0;
        for (int i = 0; i < scores.size(); i++) {
            sumScores += scores.get(i);
        }
        double average = sumScores / scores.size();
        return average;
    } 
 
    // Writes and prints the report
    // Writes and prints the report
public static void writeReport(ArrayList<Integer> scores,
    double avg, int high, int low,
    String outputFile) {
// Count the grade bands
int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

for (int score : scores) {
if (score >= 90) {
countA++;
} else if (score >= 80) {
countB++;
} else if (score >= 70) {
countC++;
} else if (score >= 60) {
countD++;
} else {
countF++;
}
}

// Write the report to the file
try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
writer.write("Grade Report:");
writer.newLine();
writer.write("-------------");
writer.newLine();
writer.write(String.format("Scores: %s%n", scores));
writer.write(String.format("Average score: %.2f%n", avg));
writer.write(String.format("Highest score: %d%n", high));
writer.write(String.format("Lowest score: %d%n", low));
writer.newLine();
writer.write("Grade Bands:");
writer.newLine();
writer.write(String.format("A (90+): %d%n", countA));
writer.write(String.format("B (80-89): %d%n", countB));
writer.write(String.format("C (70-79): %d%n", countC));
writer.write(String.format("D (60-69): %d%n", countD));
writer.write(String.format("F (<60): %d%n", countF));
writer.newLine();
System.out.println("Report written to " + outputFile);

// Print the same lines to the terminal
System.out.println("Grade Report:");
System.out.println("-------------");
System.out.printf("Scores: %s%n", scores);
System.out.printf("Average score: %.2f%n", avg);
System.out.printf("Highest score: %d%n", high);
System.out.printf("Lowest score: %d%n", low);
System.out.println("Grade Bands:");
System.out.printf("A (90+): %d%n", countA);
System.out.printf("B (80-89): %d%n", countB);
System.out.printf("C (70-79): %d%n", countC);
System.out.printf("D (60-69): %d%n", countD);
System.out.printf("F (<60): %d%n", countF);
} catch (IOException e) {
System.out.println("Error writing report: " + e.getMessage());
}
}
} 