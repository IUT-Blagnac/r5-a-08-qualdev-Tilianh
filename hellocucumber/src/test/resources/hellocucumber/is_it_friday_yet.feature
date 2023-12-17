Feature: Est on vendredi ?

#  Scenario: Dimanche n'est pas vendredi
#    Given on est "dimanche"
#    When on demande si on est vendredi
#    Then répondre "Non"
#
#  Scenario: Vendredi est vendredi
#    Given on est "vendredi"
#    When on demande si on est vendredi
#    Then répondre "Oui"

  Scenario Outline: Vendredi est vendredi
    Given on est "<day>"
    When on demande si on est vendredi
    Then répondre "<answer>"

    Examples:
      | day            | answer |
      | vendredi       | Oui    |
      | dimanche       | Non    |
      | anything else! | Non    |