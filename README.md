# Smart Shopping Assistant

**Smart Shopping Assistant** is a full-stack web application designed to simplify grocery shopping and meal planning. Users can create custom recipes and generate shopping lists based on those recipes, streamlining the shopping process. This project combines thoughtful UX with solid backend architecture to demonstrate real-world application of software development practices.

## Application Preview
// TODO: Images showing main application screen. Maybe also recipe creation.

## Features
### Product Management
* Browse and select froma list of products.
* Add individual products to your shopping list by dragging and dropping them in.
### Recipe Builder
* Create, edit, and save custom recipes.
* Add multiple products as ingredients by also just dragging and dropping them in.
* Reuse recipes in future shopping trips.
### Smart Shopping List
* Instantly populate your shopping list by dragging one or more saved recipes in.
* Prevents duplicates and manages quantities (future improvement planned)

## Tech Stack

| Layer      | Technology                                   |
| :--------: | :--------------                              |
| Frontend   | **React**, **TypeScript**                    |
| Backend    | **Java**, **Spring Boot**, REST API          |
| Database   | **SQL**                                      |
| Testing    | **JUnit** for backend unit testing           |
| Dev Tools  | Git, Github, Kanban board for Agile workflow |

## Agile-Inspired Development
While working on the project, I followed an **Agile-inspired approach** to manage features and development tasks.
* A **physical Kanban board** was created to visually track progress.
* Features were broken down into smaller tasks for better organization using color coded sticky notes depending on what the feature was for, either frontend, backend, database, or testing.
* Backend includes tests for core functionality and database communication.

// TODO; Image of physical Kanban board

## Database Schema
The backend relies on a **relational SQL database**. Below is a high-level view of the schema used in the project:

// TODO: Image of database diagram

## Getting Started
### 1. Clone the Repository
```
git clone https://github.com/tcollins6049/smart-shopping-assistant.git
cd smart-shopping-assistant
```
### 1.5. Database Setup
A mock database has been provided so this step may be skipped unless you would like to setup your own database. 

In this case, follow the provided database schema to create one and also modify the following line in the file located at 'backend/src/main/resources/application.properties':
```
database.type=mock
```
change to:
```
database.type=real
```

### 2. Backend Setup
* Install **Java 17+** and **Spring Boot**

2. **Backend setup:**
   * Ensure you have Java and Spring Boot installed.
   * A local SQL database will need to be setup based on the tables in the image below. This is not ideal but a mock database is being setup to make things easier to run in the future.

3. **Frontend Setup:**
   * Install dependencies
     ```
     npm install
     ```

4. **Run Application:**
   * First navigate to the "backend" directory and start up the backend:
     ```
     ./gradlew bootrun
     ```

   * In a seperate terminal, navigate to the "frontend" directory and start up the frontend:
     ```
     npm run dev
     ```

5. In your browser, navigate to "http://localhost:3000" to interact with the application.

## Future Enhancements
* User authentication and account management
* Better UI design
* Database updates with more products and more information for each product. Maybe integration with externam grocery API.



     
