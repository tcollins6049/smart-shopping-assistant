# Smart Shopping Assistant

This web application is a smart shopping assistant to help users manage their shopping lists with ease. The application provides a list of products which the user can add to there shooping lists or recipes.
The user can create custom recipes and add products to them. So the next time when the user is making their shopping list, instead of adding products one by one, they can add an entire recipe instead.
This works to simplify the process of planning meals and purchasing ingredients.

## Key Features
* **Product Management**: Users can browse a list of available products and add them to their shopping list.
* **Recipes**: Create a custom recipe and add products into it. Add full recipe to shopping list.
* **Smart Shopping List**: Automatically update shopping list by adding ingredients from recipe.

## Tech Stack
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



     
