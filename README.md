Advent of Code - Day 2 (2024)

# Objectif de l’exercice
Cet exercice est issu du site [Advent of Code 2024 - Jour 2](https://adventofcode.com/2024/day/2).  
L’objectif est de déterminer combien de "rapports" sont sûrs (SAFE) en respectant certaines règles de variations numériques.


# Langage utilisé
Le projet est entièrement réalisé en Java l’IDE IntelliJ IDEA.


# Approche de la solution

1. Lecture du puzzle input :  
   Le programme lit les lignes saisies par l’utilisateur jusqu’à ce qu’il tape `FIN`.  
   Chaque ligne correspond à un rapport contenant une série de nombres.

2. Traitement des rapports :  
   Pour chaque rapport, j’ai vérifié :
    - que les valeurs sont soit toutes croissantes, soit toutes décroissantes ;
    - que la différence entre deux valeurs successives est comprise entre 1 et 3 inclus ;
    - qu’il n’y a aucune égalité entre deux valeurs consécutives.

3. Comptage des rapports sûrs : 
   La méthode `countSafeReports()` parcourt toutes les lignes et utilise `isReportSafe()` pour vérifier la sécurité de chaque rapport.

4. Affichage du résultat :
   À la fin, le programme affiche :
    - le nombre total de rapports analysés ;
    - le nombre de rapports SAFE ;
    - le nombre de rapports UNSAFE.

# RESULTATS :
RÉSULTAT FINAL:

Nombre total de rapports: 1000
Nombre de rapports SAFE: 326
Nombre de rapports UNSAFE: 674




