# Family

1. Zastosowane technologie:

   - Java 11
   - Spring Boot 2.7.4
   - Docker v20.10.17
   - MySQL 8.0

2. Instrukcja uruchomienia:

   - [ ] Dla każdego komponentu aplikacyjnego należy uruchomić w terminalu polecenie 

     ```
     mvn clean install
     ```

     w celu przekonwertowania źródeł projektu na plik wykonywalny **.jar**.

   - [ ] Następnie dla każdego komponentu wykonać następujące polecenie (kolejno FamilyApp i FamilyMemberApp):

     ```
     docker build . -t family-app
     
     docker build . -t family-member-app
     ```

   - [ ] W ścieżce projektu FamilyApp należy wykonać w terminalu następujące polecenie:

     ```
     docker compose up
     ```

   - [ ] Sprawdzić działanie aplikacji z użyciem poniższych przykładowych danych w formacie JSON

   ​	

### POST - stwórz rodzinę

http://localhost:8020/createFamily

```json
{
    "familyName": "Glik",
    "nrOfAdults": 2,
    "nrOfChildren": 1,
    "nrOfInfants": 1,
    "familyMemberList": [
        {
            "familyName": "Glik",
            "givenName": "Kamil",
            "age": 34
        },
        {
            "familyName": "Glik",
            "givenName": "Marta",
            "age": 34
        },
                {
            "familyName": "Glik",
            "givenName": "Victoria",
            "age": 9
        },
                {
            "familyName": "Glik",
            "givenName": "Valentina",
            "age": 3
        }
    ]
}
```



### GET - pobierz rodzinę

http://localhost:8020/getFamily/{numer rodziny}