# 🚀 Motus
**Auteur : antcamarasa**

> **Motus** est une implémentation moderne du jeu de lettres *Motus*, avec :
> - Authentification sécurisée
> - Grille interactive avec indices colorés
> - API RESTive et UI réactive
> - Classement des meilleurs joueurs

---

## 🎯 Fonctionnalités principales

- 🔐 **Inscription / connexion** via nom d’utilisateur et mot de passe (BCrypt)
- 🎮 **Démarrage de partie** : choix de la longueur et du niveau de difficulté
- 🟥🟡🔵 **Affichage de la grille** :
  - **Rouge** : lettre bien placée
  - **Jaune** : lettre présente mais mal placée
  - **Bleu** : lettre absente
- 🏆 **Classement** : top 10 des joueurs selon leurs scores
- 📱 **Responsive** : UI adaptée mobile et desktop

---

## 📦 Structure du projet

```
Motus/
├── backend/       # API Spring Boot
│   ├── src/main/java/com/motus
│   ├── src/main/resources
│   └── pom.xml
├── frontend/      # Application React
│   ├── public/
│   └── src/
│       ├── components/
│       └── api.js
├── .gitignore
└── README.md      # Documentation du projet
```

---

## 🔧 Prérequis

- Java 11+ & Maven
- Node.js 14+ & npm
- Git (pour le contrôle de version)

---

## 🚀 Installation & lancement

### 1. Cloner le dépôt
```bash
git clone https://github.com/antcamarasa/Motus.git
cd Motus
```

### 2. Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
> L’API tourne par défaut sur `http://localhost:8080/api`

### 3. Frontend (React)
```bash
cd ../frontend
npm install
npm start
```
> L’application démarre sur `http://localhost:3000`

---

## 🧩 Endpoints clés

| Route                       | Méthode | Description                         |
|-----------------------------|---------|-------------------------------------|
| `/api/auth/register`        | POST    | Créer un compte (pseudo, mot de passe) |
| `/api/auth/login`           | POST    | Authentification (basic auth ou JWT) |
| `/api/game/start`           | POST    | Démarrer une partie (longueur, difficulté) |
| `/api/game/play`            | POST    | Soumettre une proposition (guess)   |
| `/api/ranking`              | GET     | Récupérer le top 10 des scores      |

---
