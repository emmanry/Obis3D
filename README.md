# Obis3D

<p float="left">
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/>
</p>
## Contexte

OBIS (Ocean Biodiversity Information System) est un centre mondial d'échange de données et d'informations en libre accès sur la biodiversité marine 
pour la science, la conservation et le développement durable. Plus de 20 nœuds OBIS dans le monde relient 500 institutions de 56 pays. 
Collectivement, ils ont fourni plus de 45 millions d'observations de près de 120 000 espèces marines, des bactéries aux baleines, de la surface 
à 10 900 mètres de profondeur, et des tropiques aux pôles. Il est possible de rechercher de manière transparente par nom d'espèce, zone géographique, 
profondeur, temps, paramètres environnementaux... 

Le but du projet est de réaliser une application permettant de visualiser ces observations sur un globe terrestre en 3D. Cette application 
permet de visualiser pour une espèce donnée le nombre d’observations par zone géographique, en faisant des 
requêtes à cette base de données.  

Nous avons utiliser les données de l'API suivante: https://api.obis.org/  

## Fonctionnalités applicatives

- Charger un fichier Json local avec le nombre de signalements pour une espèce par zone et mettre à disposition les coordonnées de chaque zone ainsi que le nombre d'occurrences;
- Récupérer le nombre de signalement par région pour un nom d’espèce passé en paramètre;
- Récupérer le nombre de signalement par région pour un nom d’espèce et entre deux dates passé en paramètre;
- Récupérer les détails d’enregistrement pour un nom d’espèce passé en paramètre et un GeoHash;
- Récupérer les 20 premiers noms scientifiques d’espèce commençant par une chaîne de caractères passée en paramètre;
- Afficher l’évolution du nombre d'occurrences d’une espèce. Les requêtes sont faites une par une de manière asynchrone;
- Convertir une coordonnée GPS en GeoHash.

## Fonctionnalités graphiques
- Afficher un globe en 3D et permettre à l’utilisateur de tourner autour grâce à la souris;
- Au démarrage, l’application affiche les zones comportant des signalements d’une espèce à partir du fichier inclus. Ces zones sont de différentes couleurs en fonction du nombre de signalements. La  légende comporte 8 couleurs et indique le nombre minimal et le nombre maximal d’occurrences pour chaque couleur;
- Afficher les occurrences d’une espèce en passant le nom scientifique exact saisi par l’utilisateur. Si le nom n’est pas reconnu, l’utilisateur est averti;
- Possibilité de saisir deux années pour n’afficher que le nombre d'occurrences d’une espèce entre ces deux  années;
- Afficher l’évolution du nombre de signalements d’une espèce entre deux années à l’aide d’une interface permettant de démarrer, mettre en pause et stopper (avec un pas fixe de 5 ans, pour ne pas faire trop de requêtes sur le serveur);
- Au lieu de saisir un nom d’espèce, l’utilisateur peut cliquer sur le globe pour faire apparaître la liste des espèces relevées sur ce GeoHash. Un clic dans cette liste démarre la requête comme si l’utilisateur avait saisi ce nom d’espèce;
- Ajouter une liste de noms scientifiques qui s’affichera au fur et à mesure que l’utilisateur saisit des caractères dans le champ de saisie;
- Afficher le nombre d'occurrences sous forme d’histogramme 3D, dont la hauteur et la couleur sera fonction de ce nombre.

## Résultats

![obis3Dview](https://user-images.githubusercontent.com/82103105/185962715-a4de2a5d-5466-4980-b0fa-04a06bf2a423.png)
Voici une capture d'écran de l'interface développée

## Installation

Ajout du module suivants dans les configurations de la classe Main de l'application :
```
--module-path PATH\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml 
```

