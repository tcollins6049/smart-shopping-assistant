# Smart Shopping Assistant

**Smart Shopping Assistant** is a full-stack web application designed to simplify grocery shopping and meal planning. Users can create custom recipes and generate shopping lists based on those recipes, streamlining the shopping process. This project combines thoughtful UX with solid backend architecture to demonstrate real-world application of software development practices.

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



* **Backend**: Java, Spring Boot, REST API
* **Frontend**: TypeScript, React
* **Database**: SQL (Relational Database)
* **Testing**: Unit tests for backend functionality
* **Development Approach**: Simulated Agile development using a Kanban board

## Getting Started
1. Clone repository to your local machine
   ```
   git clone https://github.com/tcollins6049/smart-shopping-assistant.git
   ```

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


## Agile Development Process:**
* The project was developed while trying to simulate an Agile workflow, with tasks being tracked on a physical Kanban board for better project management.

## Future Enhancements
* User authentication and account management
* Better UI design
* Database updates with more products and more information for each product. Maybe integration with externam grocery API.



     
