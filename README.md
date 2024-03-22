# Gestion des Patients - Spring MVC, Thymeleaf, et Spring Data JPA

Ce projet est une application Web JEE dédiée à la gestion des patients. Utilisant Spring MVC pour le contrôle de l'application, Thymeleaf pour le rendu des vues, et Spring Data JPA pour la persistance des données, l'application offre une suite complète de fonctionnalités pour faciliter la gestion des patients dans un contexte médical.

## Fonctionnalités

L'application fournit les fonctionnalités suivantes, essentielles à la gestion efficace des patients :

- **Affichage des Patients** : Liste tous les patients enregistrés dans le système.
- **Pagination** : Supporte la pagination des résultats pour une meilleure lisibilité et navigation.
- **Recherche de Patients** : Permet de chercher des patients spécifiques par nom, prénom, ou autres critères.
- **Suppression de Patients** : Offre la possibilité de supprimer les enregistrements de patients.
- **Améliorations Supplémentaires** :
    - **Création d'une Page Template** : Utilise Thymeleaf pour générer des vues basées sur un modèle commun.
    - **Validation des Formulaires** : Assure la validation côté serveur des formulaires de saisie pour garantir la qualité des données.
- **Sécurité** : Intègre Spring Security pour protéger l'accès aux fonctionnalités sensibles de l'application.

## Technologies Utilisées

- **Spring MVC** : Cadre d'application pour le développement de l'application Web.
- **Thymeleaf** : Moteur de template pour le rendu des vues HTML.
- **Spring Data JPA** : Facilite l'accès et la manipulation des données relationnelles.
- **Spring Security** : Ajoute une couche de sécurité pour authentifier et autoriser les utilisateurs.

## Configuration et Installation

### Prérequis

Avant de commencer, assurez-vous que les outils suivants sont installés et configurés :

- JDK 11 ou version supérieure.
- Maven 3.6 ou version supérieure.
- Un IDE (Eclipse, IntelliJ IDEA, VS Code, etc.) avec support pour Lombok.
- Serveur de base de données (H2 pour le développement, MySQL pour la production).

### Installation

1. **Clonez le dépôt GitHub** :

```bash
git clone https://github.com/ELMOUADDIBE/tp3-SpringMVC-JPA.git
