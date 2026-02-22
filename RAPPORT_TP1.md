# Rapport TP1 - RepIt Beta

## Objectif
Poser les bases d'une application Android Kotlin pour gérer des routines sportives simples.

## Fonctionnalités implémentées
1. **Configuration initiale**
   - Projet Android créé avec Kotlin + Jetpack Compose.
   - Structure Gradle minimale pour compiler l'application.

2. **Interface utilisateur**
   - Page d'accueil avec un en-tête "défi du jour".
   - Section "Mes défis" listant les routines.
   - Cartes avec titre, description, catégorie, fréquence et progression.

3. **Gestion des routines**
   - Données stockées dans un fichier utilitaire `RoutineUtil.kt`.
   - Affichage direct de ces données dans la page d'accueil.
   - Bouton simple pour ajouter une routine de test.

## Tests réalisés
- Vérification de la compilation via Gradle (`assembleDebug`).
- Vérification de lint Android (`lint`).

## Remarques
- Le code est volontairement basique (niveau junior), sans API externe ni logique complexe.
- Le style visuel s'inspire de la maquette cible, sans chercher une reproduction parfaite à ce stade.
