
# Projet back-end en spring-boot

1. Les outils de developpement nécessaire pour notre projet:
- Moi j'utilise la version 20 de Apache NetBeans IDE.
- La version 17.0.10 du JDK(Java: 17.0.10; OpenJDK 64-Bit Server VM 17.0.10+7-Ubuntu-120.04.1).
- La version Apache Maven 3.6.3 de maven.




## comment le recupérer en local ?
1. cloner le projet depuis github

 ```bash
 git clone https://github.com/ifnti-dev/e-food-spring.git

 ```
>[!NOTE]
>Ouvrez un terminal et lancez la commande ci-dessus à là où vous voulez l'avoir
2. Entrer dans le projet comme suit:

```bash
cd e-food-spring/e-food

```
3. Installation des dépendences

```bash
mvn install

```
Avant d'exécuter l'application créer un utilisateur de base de donné avec le username et le password ci dessous puis donnée lui le droit de creer une base de donnée et de créer un role.
. N'oublier pas de configurer le fichier phba.conf en md5.
Configurez le fichier application.properties avec ces paramètres
- Le port d'écoute c'est le 8081
- Le context-path c'est e-food
- La base de donnée = e_food
- Le username = dev
- Le password = dev_e_food

4. Excécution du projet

- si c'est neetbeans vous utilisez faite ceci:
    . Faite un cliquez droit sur le projet puis choisier clean and build pour construire l'application.
    .Sur le entrypoint de l'application ici nommé: EFOOdApplication.java faite un clique droit  puis choisir Run File pour excécuter l'application.
    
- si c'est vscode excécuter cette commmande:

```bash
mvn spring-boot:run
```

5. Comment y accéder sur un navigateur ?

- Taper l'URL suivant:
  127.0.0.1:8081/e-food

  ```````
