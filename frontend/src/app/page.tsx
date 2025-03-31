"use client"

import React, { useEffect, useState } from 'react';
import { getAllProducts } from './services/ProductsService';
import ProductList from './components/Products/ProductList';
import RecipeList from './components/Recipes/RecipeList';
import ShoppingList from './components/ShoppingList/ShoppingList';
import { getUserId } from './userInfo';
import { findShoppingList } from './services/Shopping_ListService';


export default function Home() {
  const [shoppingListId, setShoppingListId] = useState<number>(0);

  useEffect(() => {
    const fetchShoppingList = async () => {
      console.log("USER ID PAGE: ", getUserId());
      const shoppingListId = await findShoppingList(getUserId());
      setShoppingListId(shoppingListId.id);
    }

    fetchShoppingList();
  }, []);


  return (
    <div className="layout-container">
      <div className="section recipes">
        <RecipeList />
      </div>

      <div className="section products">
        <ProductList />
      </div>

      <div className="section shopping-list">
        <ShoppingList shoppingListId={shoppingListId} />
      </div>
    </div>
  );
}
