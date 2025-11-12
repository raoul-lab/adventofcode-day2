import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(" ANALYSEUR DE RAPPORTS (Partie 1 & 2)\n");
        System.out.println("1 - Partie 1 : Règles strictes (aucune tolérance)");
        System.out.println("2 - Partie 2 : Règles avec tolérance (on peut retirer un niveau)");
        System.out.print("\nEntrez votre choix (1 ou 2) : ");

        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        // Lecture du choix de l’utilisateur
        try {
            choix = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("\nChoix invalide. Programme terminé.");
            return;
        }

        if (choix != 1 && choix != 2) {
            System.out.println("\nChoix invalide. Programme terminé.");
            return;
        }

        System.out.println("\nCollez votre puzzle input ci-dessous.");
        System.out.println("Appuyez sur Entrée, puis tapez FIN et appuyez sur Entrée pour voir le résultat.\n");

        try {
            List<String> lines = new ArrayList<>();

            // Lecture des lignes jusqu’à “FIN”
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().equalsIgnoreCase("FIN")) {
                    break;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                lines.add(line.trim());
            }

            scanner.close();

            if (lines.isEmpty()) {
                System.out.println("\nAucune donnée reçue. Programme terminé.");
                return;
            }

            int safeReports;

            if (choix == 1) {
                safeReports = countSafeReports(lines);
                System.out.println("\n RÉSULTAT FINAL (Partie 1)\n");
            } else {
                safeReports = countSafeReportsWithTolerance(lines);
                System.out.println("\n RÉSULTAT FINAL (Partie 2)\n");
            }

            System.out.println("Nombre total de rapports : " + lines.size());
            System.out.println("Nombre de rapports SAFE : " + safeReports);
            System.out.println("Nombre de rapports UNSAFE : " + (lines.size() - safeReports));

        } catch (Exception e) {
            System.err.println("\nErreur: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //  Partie 1
    private static int countSafeReports(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            if (isReportSafe(line)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isReportSafe(String reportLine) {
        String[] parts = reportLine.trim().split("\\s+");
        int[] levels = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            levels[i] = Integer.parseInt(parts[i]);
        }
        return isSafe(levels);
    }

    // Partie 2
    private static int countSafeReportsWithTolerance(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            if (isReportSafeWithTolerance(line)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isReportSafeWithTolerance(String reportLine) {
        String[] parts = reportLine.trim().split("\\s+");
        int[] levels = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            levels[i] = Integer.parseInt(parts[i]);
        }

        // Si déjà safe c'est OK
        if (isSafe(levels)) {
            return true;
        }

        // Sinon, tester sans un élément à la fois
        for (int i = 0; i < levels.length; i++) {
            int[] reduced = removeIndex(levels, i);
            if (isSafe(reduced)) {
                return true;
            }
        }

        return false;
    }

    private static int[] removeIndex(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                result[pos++] = arr[i];
            }
        }
        return result;
    }

    //Règle de sécurité commune (identique à la Partie 1)
    private static boolean isSafe(int[] levels) {
        if (levels.length < 2) {
            return true;
        }

        boolean shouldIncrease = levels[1] > levels[0];
        boolean shouldDecrease = levels[1] < levels[0];

        if (levels[0] == levels[1]) {
            return false;
        }

        for (int i = 0; i < levels.length - 1; i++) {
            int diff = levels[i + 1] - levels[i];
            int absDiff = Math.abs(diff);

            // Différence invalide
            if (absDiff < 1 || absDiff > 3) {
                return false;
            }

            // Direction incohérente
            if (shouldIncrease && diff <= 0) {
                return false;
            }
            if (shouldDecrease && diff >= 0) {
                return false;
            }
        }

        return true;
    }
}
