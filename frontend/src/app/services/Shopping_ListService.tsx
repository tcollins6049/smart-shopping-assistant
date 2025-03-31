import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/shopping-list';

export const findShoppingList = async (user_id: number) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${user_id}`);
        return response.data;
    } catch (error) {
        console.error("Failed fetching shopping list:", error);
        throw error;
    }
}
