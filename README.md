Advent of Code - Day 2 (2024)

# Objectif de l’exercice
Cet exercice est issu du site https://adventofcode.com/2024/day/2
L’objectif est de déterminer combien de rapports sont sûrs (SAFE) selon des règles de variations numériques, en deux étapes :

Partie 1 : analyse stricte, sans tolérance.

Partie 2 : un rapport peut être considéré comme SAFE même s’il devient sûr après suppression d’un seul élément problématique.


# Langage utilisé
Le projet est entièrement réalisé en Java l’IDE IntelliJ IDEA.


# Approche de la solution

1. Lecture du puzzle input :  
   Le programme lit les lignes saisies par l’utilisateur jusqu’à ce qu’il tape FIN.
   Chaque ligne correspond à un rapport contenant une série de nombres.

L’utilisateur choisit au lancement :

1 pour Partie 1 : règles strictes

2 pour Partie 2 : règles avec tolérance (on peut retirer un niveau)

2. Partie 1 - Règles strictes :  
   Pour chaque rapport, le programme vérifie :

      - que les valeurs sont soit toutes croissantes, soit toutes décroissantes ;

      - que la différence entre deux valeurs successives est comprise entre 1 et 3 inclus ;

      - qu’il n’y a aucune égalité entre deux valeurs consécutives.

   Les rapports qui respectent ces règles sont comptés comme SAFE.

3. Partie 2 - Règles avec tolérance :
   Si un rapport n’est pas SAFE selon les règles de la Partie 1, le programme teste toutes les versions possibles du rapport après suppression d’un élément.
   Si au moins une de ces versions devient SAFE, alors le rapport est considéré comme SAFE pour la Partie 2.

4. Méthodes principales :
   - isSafe(int[] levels) : vérifie si un rapport est strictement sûr (Partie 1)
   - isReportSafeWithTolerance(String reportLine) : vérifie la sécurité avec suppression possible d’un élément (Partie 2)
   - countSafeReports() / countSafeReportsWithTolerance() : comptent le nombre de rapports sûrs selon la partie choisie.

5. Affichage du résultat :
   À la fin, le programme affiche :
    - le nombre total de rapports analysés ;
    - le nombre de rapports SAFE ;
    - le nombre de rapports UNSAFE.

# RESULTATS :
RÉSULTAT FINAL (Partie 1):

Nombre total de rapports: 1000
Nombre de rapports SAFE: 326
Nombre de rapports UNSAFE: 674

RÉSULTAT FINAL (Partie 2):
Nombre total de rapports : 1000
Nombre de rapports SAFE : 381
Nombre de rapports UNSAFE : 619




