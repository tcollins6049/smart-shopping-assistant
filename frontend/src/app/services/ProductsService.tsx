import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/products';

export const getAllProducts = async () => {
    try {
        const response = await axios.get(API_BASE_URL);
        return response.data;
    } catch (error) {
        console.error('Error fetching products:', error);
        throw error;
    }
}

export const getProductById = async (product_id: number) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${product_id}`);
        return response.data;
    } catch (error) {
        console.error("Error getting product off id:", error);
        throw error;
    }
}