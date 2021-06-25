# SpringBootClassifieds

Aplikacja do ogłoszeń lokalnych.

## Dokumentacja
- POST /api/v1/auth/register - Dodaje użytkownika do bazy danych.
```
username:String
password:String
```
- POST /api/v1/auth/login - Loguje użytkownika do systemu.
```
username:String
password:String
```
- GET /api/v1/auth/logout - Wylogowuje użytkownika.
- GET /api/v1/categories - Zwraca wszystkie kategorie.
- GET /api/v1/categories/{id} - Zwraca wszystkie ogłoszenia z danej kategorii.
- GET /api/v1/ads - Zwraca wszystkie ogłoszenia.
- GET /api/v1/ads/{id} - Zwraca konkretne ogłoszenie.
- POST /api/v1/ads - Dodaje nowe ogłoszenie.

```
title:String
description:String
priceInCents:Number
categories:Array
```

- PATCH /api/v1/ads/{id} - Edytuje konkretne ogłoszenie.
```
title:String
description:String
priceInCents:Number
```
- DELETE /api/v1/ads/{id} - Usuwa wybrane ogłoszenie.
- POST /api/v1/favourites - Dodaje ogłoszenie do ulubionych.
```
adID:Number
```
- DELETE /api/v1/favourites/{id} - Usuwa konkretne ogłoszenie z ulubionych.
- GET /api/v1/favourites - Zwraca wszystkie ulubione ogłoszenia.
