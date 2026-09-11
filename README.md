Objectif et mise en œuvre
Implémentation des opérations arithmétiques fondamentales ( add, sub, mul, div).

Gestion défensive de la division : détection explicite d'un dénominateur nul et levée d'une ArithmeticException( décochée ).

Capture ciblée de l'exception dans MainCalcavec un bloc try-catch-finallydémontrant que le bloc finallys'exécute systématiquement pour terminer le flux.


https://github.com/user-attachments/assets/40a61887-ad33-476f-864b-8e3a4de3ebda


Exercice 2 — Lecture d'un Fichier de Nombres
Objectif et mise en œuvre
Lecture séquentielle ligne par ligne d'un fichier plat ( numbers.txt) via BufferedReaderet FileReader.

Utilisation du patron try-with-resourcesassurant la fermeture automatique du système de flux ( AutoCloseable).

Gestion différenciée de multiples exceptions :

IOException: fichier manquant, chemin incorrect ou droits d'accès insuffisants.

NumberFormatException: ligne contenant des caractères non convertibles en entier via Integer.parseInt().


https://github.com/user-attachments/assets/ad4e494c-3f54-4049-a9a9-08145d93a6ce


Exercice 3 — Validation d'Utilisateur
Objectif et mise en œuvre
Création d'une exception personnalisée contrôlée InvalidUserExceptionhéritant directement de java.lang.Exception.

Définition d'une méthode métier validate()dans la classe Userdéclarée la clause throws InvalidUserException.

Règles de validation appliquées :

Rejeter des chaînes nulles, vides ou composées uniquement d'espaces pour le nom.

Rejeter les utilisateurs mineurs ( age < 18).

Capture de l'exception métier sans interruption du traitement du lot d'utilisateurs.

https://github.com/user-attachments/assets/be220df2-7db8-486f-84c6-c1342cfdbc09

Exercice 4 — Journalisation des erreurs
Objectif et mise en œuvre
Remplacement des sorties console standard d'erreur ( System.err) par une écriture persistante dans le fichier error.log.

Ouverture de flux en mode ajouté : new FileWriter("error.log", true).

Association avec PrintWriterpour consigner le message d'erreur contextualisé ainsi que l'intégralité de la trace d'exécution ( e.printStackTrace(pw)).

Encapsulation complète de la chaîne d'écriture dans un try-with-resources.

Synthèse Technique & Bonnes Pratiques
Coché vs non coché :

Checked( Exception) : oblige le compilateur à vérifier la présence d'un bloc try-catchou d'une clause throws. Utilisé pour des situations imprévisibles mais récupérables ( IOException, InvalidUserException).

Unchecked( RuntimeException) : facultatif au niveau du compilateur. Révèle des anomalies de conception ou d'état logique ( ArithmeticException, NumberFormatException).

Try-with-resources : À privilégier exclusivement face à la structure historique try-finallypour éliminer les fuites de descripteurs de fichiers sous le système d'exploitation.

Granularité des captures : Ne pas intercepter génériquement catch (Exception e)trop tôt si la méthode appelante doit prendre une décision métier.

https://github.com/user-attachments/assets/a5d1ae09-662d-4172-9a16-965b715540b0





