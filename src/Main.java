
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Collez votre puzzle input ci-dessous.");
        System.out.println("Appuyez sur Entrée, puis tapez FIN et appuyez sur Entrée pour voir le résultat.\n");

        try {
            Scanner scanner = new Scanner(System.in);
            List<String> lines = new ArrayList<>();

            // Je lit les lignes jusqu'à "END"
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Je vérifie  si c'est la commande de fin
                if (line.trim().equalsIgnoreCase("FIN")) {
                    break;
                }

                // Il faut les lignes vides
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Ajouter la ligne
                lines.add(line.trim());
            }

            scanner.close();

            if (lines.isEmpty()) {
                System.out.println("\n Aucune donnée reçue. Programme terminé.");
                return;
            }

            // Calculer le résultat
            int safeReports = countSafeReports(lines);


            System.out.println("RÉSULTAT FINAL:\n");
            System.out.println("Nombre total de rapports: " + lines.size());
            System.out.println("Nombre de rapports SAFE: " + safeReports);
            System.out.println("Nombre de rapports UNSAFE: " + (lines.size() - safeReports));


        } catch (Exception e) {
            System.err.println("\nErreur: " + e.getMessage());
            e.printStackTrace();
        }
    }


      //Ici j'ai implémenté une méthode qui compte le nombre de rapports safe

    private static int countSafeReports(List<String> lines) {
        int count = 0;

        for (String line : lines) {
            if (isReportSafe(line)) {
                count++;
            }
        }

        return count;
    }


      //Ici j'ai implémenté une méthode qui vérifie si un rapport est safe

    private static boolean isReportSafe(String reportLine) {
        String[] parts = reportLine.trim().split("\\s+");
        int[] levels = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            levels[i] = Integer.parseInt(parts[i]);
        }

        return isSafe(levels);
    }


      //Ici j'ai implémenté une méthode qui vérifie si un tableau de niveaux est safe

    private static boolean isSafe(int[] levels) {
        if (levels.length < 2) {
            return true;
        }

        // Je Détermine si la séquence devrait être croissante ou décroissante
        boolean shouldIncrease = levels[1] > levels[0];
        boolean shouldDecrease = levels[1] < levels[0];

        // Si les deux premiers éléments sont égaux, c'est unsafe
        if (levels[0] == levels[1]) {
            return false;
        }

        // Je vérifie toutes les paires adjacentes
        for (int i = 0; i < levels.length - 1; i++) {
            int diff = levels[i + 1] - levels[i];
            int absDiff = Math.abs(diff);

            // La différence doit être entre 1 et 3
            if (absDiff < 1 || absDiff > 3) {
                return false;
            }

            // Il faut vérifier la direction (croissant ou décroissant)
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