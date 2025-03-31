export interface ShoppingListItem {
    id?: number;
    shopping_list_id: number;
    product_id: number;
    quantity: number;
}

export interface Recipes {
    id: number;
    name: string;
    description: string;
    user_id: number;
}

export interface RecipeItem {
    id: number;
    recipe_id: number;
    product_id: number;
    quantity: number;
}