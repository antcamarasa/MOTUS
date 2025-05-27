# 📦 Projet Motus — Application Complète

Ce projet se compose de deux parties :

1. **Backend Spring Boot (Java 17)** : API REST pour gérer le jeu Motus (authentification, mots, scores).
2. **Frontend React (Node.js / npm)** : SPA pour jouer, s'inscrire, se connecter et consulter le classement.

---

## 🛠 Prérequis

* **Java 17** (Testé avec OpenJDK 17)
* **Maven 3.8+**
* **Node.js 16+** et **npm 8+**
* **Git** (pour cloner le dépôt)

Vérifiez vos versions :

```bash
java -version   # doit afficher 17.x
mvn -v          # doit afficher Maven 3.x
node -v         # doit afficher Node.js >=16.x
npm -v          # doit afficher npm >=8.x
```

---

## 📂 Structure du projet

```text
motus/
├── backend/      # Application Spring Boot
│   ├── pom.xml
│   └── src/
└── frontend/     # Application React
    ├── package.json
    └── src/
```

---

## 🚀 Démarrer le Backend

1. Placez-vous dans `backend/` :

   ```bash
   cd motus/backend
   ```
2. Compilez et installez :

   ```bash
   mvn clean install
   ```
3. Lancez l'API :

   ```bash
   mvn spring-boot:run
   ```

* L'application écoute sur le port **8080**.
* Console H2 : `http://localhost:8080/h2-console`.

### ⚙️ Configuration CORS (optionnel)

En cas d’erreur CORS, ajoutez dans `SecurityConfig` :

```java
http.cors();

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(List.of("http://localhost:3000"));
    config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    return source;
}
```

---

## 🚀 Démarrer le Frontend

1. Placez-vous dans `frontend/` :

   ```bash
   cd motus/frontend
   ```
2. Installez les dépendances :

   ```bash
   npm install
   ```
3. En cas d’erreur `ERR_OSSL_EVP_UNSUPPORTED` :

   ```bash
   export NODE_OPTIONS=--openssl-legacy-provider
   ```
4. Lancez l’application React :

   ```bash
   npm start
   ```

* L’interface est accessible sur le port **3000**.
* Les appels API pointent vers `http://localhost:8080/api`.

---

## 🔗 Intégration Front/Back

* Le front communique avec l’API en `http://localhost:8080/api` (cf. `src/api.js`).
* Les routes protégées nécessitent une authentification HTTP Basic.

---

## 🧪 Tests & Vérification

* **Backend** : testez via Postman ou `curl`.
* **Frontend** : naviguez, inscrivez-vous, connectez-vous et jouez.

---

## 📁 À Rendre

* Le dossier complet `motus/` (backend + frontend).
* Ce fichier `README.md`.

> **Bonne évaluation !**
