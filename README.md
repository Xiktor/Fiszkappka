Readme w wersji pdf: [README.pdf](https://github.com/Xiktor/Fiszkappka/files/11833006/README.pdf)

# Cel projektu 
Celem projektu było utworzenie prototypu aplikacji MVC w języku Java z zastosowaniem freamworka Spring Boot. Aplikacja miała komunikować się z relacyjną bazą danych oraz spełniać minimum 5 wymagań funkcjonalnych i 5 niefunkcjonalnych.


# Stack technologiczny
„Fiszkappka” to prosta aplikacja klient-server, zbudowana w oparciu o wzorzec architektury **MVC** oraz **RESTful** **API**. Jako system zarządzania bazą danych wykorzystano **MySQL**. W projekcie wykorzystano liczne narzędzia i biblioteki z ekosystemu Java:

•	**Hibernate** – narzędzie ORM do mapowania obiektowo-relacyjnego oraz zarządzania dostępem do bazy danych

•	**Meaven** – do zarządzania zależnościami w projekcie

•	**Lombok** – do generowania rutynowego kodu i zwiększenia czytelności kodu

•	**Spring** **Web** – do implementacji warstwy kontrolerów i obsługi HTTP

•	**Spring** **Validation** – do walidacji danych wprowadzanych przez użytkownika

•	**Thymeleaf** – do tworzenia dynamicznych, interaktywnych, responsywnych stron HTML

•	**Flyway** – do zarządzania migracjami bazy danych

•	**MapStruct** – do automatyzacji mapowania obiektów na DTO

•	**Mockito** – do tworzenia testów jednostkowych oraz atrap obiektów

•	**Bootstrap** – do tworzenia atrakcyjnego interfejsu użytkownika

# Uruchomienie projektu
Upewnij się, że dane w application.properties umożliwiają Ci połączyć się z bazą danych MySQL lub zmień url, username i password według potrzeb. W projekcie wygląda to następująco:

spring.datasource.url=jdbc:mysql://localhost:3306/spring

spring.datasource.username=root

spring.datasource.password=

Upewnij się, że IDE zainstalowało wszystkie zależności zdefiniowane w pliku pom.xml.
Upewnij się, że Maven jest skonfigurowany i uruchom automatyczne budowanie projektu.

Wprowadź adres URL: http://localhost:8080/language/

Osobiście korzystałem z IDE IntelJJ.

# Zrzuty ekranu

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/7e86fc76-e99f-4790-b38e-ea182f091970)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/666268ef-db30-4d0a-a0c4-ab3c92dcdde0)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/28e7206e-07f5-45d1-93e1-6b0614aafe74)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/b4560310-8c58-41ef-95ee-de762cbd04d3)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/23b33635-9efb-41a9-bc95-1faff374af9e)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/9e032fe0-0349-40e5-a3b0-a5ce8fc2ca2d)

![image](https://github.com/Xiktor/Fiszkappka/assets/62425432/95fafd66-e067-4b89-87e4-3ba92dbc956d)


