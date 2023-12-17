Feature: Vérification format liste de tâches
  Vérifier que les tâches ajoutées à la liste correspondent au format REGEX :
    ^.*\S*\s\(.*\S*,\s{0,1}\d{1,2}\/\d{1,2}\)$

  Scenario: Respect du format
    Given la liste de tâches à faire
    Given le format à respecter
    Given la tâche "Terminer TP#3 (QualDev, 24/12)"
    When la tâche est ajoutée à la liste
    Then la liste est mise à jour sans erreur

  Scenario: Format non respecté
    Given la liste de tâches à faire
    Given le format à respecter
    Given la tâche "Finir le projet Symfony en Programmation Avancée pour le 7 janvier."
    When la tâche est ajoutée à la liste
    Then une erreur est renvoyée