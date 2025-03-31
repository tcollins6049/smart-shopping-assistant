import axios from 'axios';
import { ShoppingListItem } from '../types';
import { getShoppingListId } from '../userInfo';

const API_BASE_URL = 'http://localhost:8080/api/shopping_list_items';

export const getNextId = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching next shopping list item id");
        throw error;
    }
}

export const findAllSListItems = async (shoppingListId: number) => {
    try {
        console.log("SHOPPING_LIST_ID SERVICE: ", shoppingListId);
        const response = await axios.get(`${API_BASE_URL}/${shoppingListId}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching shopping list items:', error);
        throw error;
    }
}

export const addShoppingListItem = async (product_id: number, shopping_list_id: number) => {
    try {
        const shoppingListItem: ShoppingListItem = {
            id: await getNextId(),
            shopping_list_id: shopping_list_id,
            product_id: product_id,
            quantity: 1
        };

        await axios.post(API_BASE_URL, shoppingListItem);
    } catch (error) {
        console.error('Error adding shopping list item:', error);
        throw error;
    }
}

export const deleteShoppingListItem = async (id: number) => {
    try {
        await axios.delete(`${API_BASE_URL}/${id}`);
    } catch (error) {
        console.error('Error deleting shopping list item:', error);
        throw error;
    }
}
