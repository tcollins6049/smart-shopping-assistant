"use client"
import axios from 'axios';
import { RecipeItem } from '../types';

const API_BASE_URL = 'http://localhost:8080/api/recipe_items';

export const getNextId = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error("Error getting next recipe item id:", error);
        throw error;
    }
}

export const findAllRecipeItems = async (recipe_id: number) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/recipe/${recipe_id}`);
        return response.data;
    } catch (error) {
        console.error("Error finding all user recipes:", error);
        throw error;
    }
}

export const insertRecipeItem = async (recipe_id: number, product_id: number, quantity: number) => {
    try {
        const recipe_item: RecipeItem = {
            id: await getNextId(),
            recipe_id: recipe_id,
            product_id: product_id,
            quantity: quantity
        };

        await axios.post(API_BASE_URL, recipe_item);
    } catch (error) {
        console.error("Error inserting recipe item:", error);
        throw error;
    }
}

export const deleteRecipeItem = async (recipe_item_id: number) => {
    try {
        await axios.delete(`${API_BASE_URL}/${recipe_item_id}`);
    } catch (error) {
        console.error("Error deleting recipe item:", error);
        throw error;
    }
}
