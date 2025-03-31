"use client"
import axios from 'axios';
import { Recipes } from '../types';
import { getUserId } from '../userInfo';

const API_BASE_URL = 'http://localhost:8080/api/recipes';

export const getNextId = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error("Failed to get next recipe id:", error);
        throw error;
    }
}

export const findRecipe = async (id: number) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error("Error finding recipe:", error);
        throw error;
    }
}

export const getAllUserRecipes = async (user_id: number) => {
    try {
        console.log("Recipe User Id: ", user_id);
        const response = await axios.get(`${API_BASE_URL}/user/${user_id}`);
        return response.data;
    } catch (error) {
        console.error("Error getting user recipes:", error);
        throw error;
    }
}

export const insertRecipe = async (name: string, description: string) => {
    try {
        const recipe: Recipes = {
            id: await getNextId(),
            name: name,
            description: description,
            user_id: getUserId()
        };

        await axios.post(API_BASE_URL, recipe);
    } catch (error) {
        console.error("Error inserting new recipe:", error);
        throw error;
    }
}