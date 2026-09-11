import java.util.Arrays;

public class PlacementRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        // Encapsulated fields
        private String name;
        private double cgpa;
        private int codingScore;

        // Constructor
        public Candidate(String name, double cgpa, int codingScore) {

            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        // Composite score
        public double getCompositeScore() {

            return cgpa * 10 + codingScore;
        }

        // Overloaded method 1
        static boolean isEligible(double cgpa) {

            return cgpa >= 7.0;
        }

        // Overloaded method 2
        static boolean isEligible(double cgpa, int codingScore) {

            return cgpa >= 6.5 && codingScore >= 60;
        }

        // Comparable
        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        // Count eligible candidates first
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.getCgpa()) ||
                    Candidate.isEligible(
                            candidate.getCgpa(),
                            candidate.getCodingScore()
                    )) {

                count++;
            }
        }

        // Create shortlisted array
        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.getCgpa()) ||
                    Candidate.isEligible(
                            candidate.getCgpa(),
                            candidate.getCodingScore()
                    )) {

                shortlisted[index] = candidate;
                index++;
            }
        }

        // Sort using Candidate's compareTo()
        Arrays.sort(shortlisted);

        // Build output
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (")
                    .append(shortlisted[i].getCompositeScore())
                    .append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

                new Candidate("Aisha", 8.2, 40),

                new Candidate("Rohit", 6.8, 65),

                new Candidate("Meena", 6.0, 90),

                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}