

# Projekt końcowy kursu Java Developer

## Temat: Proces rezerwacji kortów tenisowych

Wprowadzone uproszczenia:
1. Obsługa trzech kortów tenisowych,
2. Zakres godzin rezerwacji od 8:00 do 16:00,
3. Dwa rodzaje ról: ROLE_USER, ROLE_ADMIN.

## Zrealizowane założenia (must have):

1. Rejestracja nowego konta przy pomocy uwierzytelnienia e-mail (token).
2. Walidacja pól podczas rejestracji konta.
3. Zmiana zapopanianego hasła przy pomocy linku aktywacyjnego wysłanego na adres email.
4. Logowanie do systemu rezerwacji za pomocą adresu email.
5. Kontrola unikalności adresu email.
6. Przechowywanie haseł w bazie danych w postaci zaszyfrowanej.
7. W panelu administratora przeglądanie użytkowników oraz nadwanie praw do rezerwacji.
Dostęp do panelu admina tylko dla roli ROLE_ADMIN. Użytkownik: admin@gmail.com, hasło: pass, zostanie załadowany do bazy podczas startu aplikacji.
8. Dostęp do przeglądania grafika rezerwacji oraz możliwości rezerwowania kortów po zalogowaniu się (ROLE_USER).
9. Przeglądanie własnych rezerwacji oraz możliwość anulowania wprowdzonych rezerwacji.
10. Widok rezerwacji kortów na wybrany dzień. Domyślnym dniem jest bieżący dzień kalendarzowy.
11. Przeglądanie oraz zmiana własnych danych osobowych.
12. Strona startowa: localhost:8080.

## Wykorzystane technologie

* Spring Boot
* Spring Data
* Spring Security
* Spring Boot Mail
* Hibernate Validator
* Project Lombok
* Javax Servlet (jstl)
* Baza danych MySql