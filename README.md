## Word-Correction

This project aims to autocorrect some wrongly typed turkish words with high accuracy.

In order to run this project, you need maven. At the time of writing this I used version 3.5.3 since I don't know if it is compatible with earlier versions I thought it is worth to mention.

This project is dependent to :

- [zemberek](github.com/ahmetaa/zemberek-nlp)
- [gson](github.com/google/gson)
- [maven-shade-plugin](maven.apache.org/plugins/maven-shade-plugin/)
- [Google Cloud Translation API](github.com/GoogleCloudPlatform/java-docs-samples/tree/master/translate)(I am not sure if we gonna use this)

the **pom.xml** file contains all necessary dependencies so you should be able to clone this repo and run the main function.
