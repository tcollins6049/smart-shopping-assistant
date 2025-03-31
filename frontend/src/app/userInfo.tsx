
let user_id: number = 1;
let shopping_list_id: number = 0;

// Getter and setter for user_id
export const getUserId = () => user_id;
export const setUserId = (id: number) => { user_id = id; };

// Getter and setter for shopping_list_id
export const getShoppingListId = () => shopping_list_id;
export const setShoppingListId = (id: number) => { shopping_list_id = id; };
