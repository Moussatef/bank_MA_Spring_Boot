# BAMCoReport [Back-end] - Habilitations

BAMCoReport est une solution à mettre en place pour faire la liaison entre la banque centrale (BAM) et une banque fils, afin de corriger les rejets hebdomadaires et visualiser les reports par agence.

## Contexte du projet

  Dans le cadre de sa mission de supervision bancaire, et de sa protection des intérêts des entreprises grâce à la sécurisation des moyens de paiement. La banque centrale du Maroc (BANK AL-MAGHRIB) / BAM a publié une circulaire en vertu de laquelle elle fixe les informations devant être communiquées par les banques au sujet des comptes bancaires qu’elles détiennent.

​

  Les informations portent sur les données permettant d’identifier les titulaires de comptes bancaires et aussi sur toutes les ouvertures, les mises à jour et les clôtures de ces comptes. Elles sont conservées par le Service de centralisation des comptes bancaires.

​

  A base des fichiers DATA (csv), un workflow Data s’exécute pour charger les données depuis la banque fils vers BAM, et cette dernière renvoie des rejets à corriger par un opérateur dans une agence filiale de la banque fils. Après la déclaration d’un nouveau rejet, et suivant le système (PAPS), un superviseur peut l’affecter à un opérateur ou à lui-même, et par la suite une fois le rejet est traité, l’employeur peut s’occuper par autre rejets. Un mail sera envoyé à chaque traitement d’un rejet.

​

### Besoin :

  Le système BAMCoReport est la solution qu’on doit mettre en place pour corriger et visualiser les rejets sui viennent de la part du BAM, cette application doit englober un service de gestionnaire d'habilitations qui permet de créer des groupes / rôles / utilisateurs (veuillez consulter le diagramme en Ressource 1).

​

### Partie 1 :

  En commençant par un web service sous forme d’une API REST pour créer et gérer les habilitations dans l’application. Une implémentation d’un ORM (JPA / Hibernate) est obligatoire, et vous devez suivre une architecture bien détaillée et bien claire durant la réalisation de l’API.

​

  Vous devez mettre en place un plan de test JUnit pour tester les fonctionnalités, essayer d’utiliser un Mock pour pas impacter la base de données.

​

  L’échange du Data entre la partie Backend et les end points doit être sous format JSON.

​

  Pour requêter les ressources/end points de l’API, vous pouvez travailler avec Postman.

​

  
  Suite à la première partie du brief BAMCoReport, et après la mise en place du système d’habilitation, vous êtes sur le point de rajouter une autre partie fonctionnelle dans l’application.

### Création / Correction des rejets :
Une table Rejet est présenté par les attributs suivants :

​

private type flowType
private type rejectNature
private type entity
private type declarationDate
private type agencyCode
private type userRegistrationNumber
private type bu
private type su
private type regionalDelegation
private type subDelegationType
private type subDelegationName
private type cliFileCode
private type clientCode or Rib
private type gravity
private type zoneCode
private type isWrongField
private type errorCode
private type errorLabel
private type isRequestTaken
private type actionDetail
private type file
private type TakenBy

Le besoin aujourd’hui, c’est d’ajouter une route qui permet à un admin de créer un nouveau rejet.

###Process :

   - Un admin peut créer un nouveau rejet.
   - Un super admin / admin fonctionnel peut affecter un rejet à un utilisateur.
   - Un super admin / admin fonctionnel peut corriger le rejet lui-même.
   - Un utilisateur peut prendre le rejet en charge, et le corriger.
   - Un utilisateur peut changer son mot de passe.

Une route pour le Dashboard (Tableau de bord) à faire, qui renvoie des informations genres :
•	Nombre des rejets par utilisateur.
•	Nombre des rejets total
•	Nombre des rejets par type / date.

L’échange du Data entre la partie Backend et les end points doit être sous format JSON.

Pour requêter les ressources/end points de l’API, vous pouvez travailler avec Postman.
Veuillez également documenter votre API utilisant Swagger.

  

## Critères de performance

      Les classes sont bien structuré.
      L'architecture des entités fait le mapping selon le diagramme partagé.
      Le code source est complété selon les consignes et respecte les bonne pratique du développement Java.
      Le code de doit être bien organisé.
      
      

      
      
