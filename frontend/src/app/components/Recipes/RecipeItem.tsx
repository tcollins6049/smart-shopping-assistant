"use client"
import React, { useState, useEffect } from 'react';
import { findAllRecipeItems, insertRecipeItem } from '../../services/Recipe_ItemsService';
import { getProductById } from '../../services/ProductsService';

type Recipe_Items = {
    id: number;
    recipe_id: number;
    product_id: number;
    quantity: number;
}

type Product = {
    id: number;
    name: string;
    descritpion: string;
}

type RecipeProps = {
    recipe: {
        id: number;
        name: string;
        description: string;
        user_id: number;
    }
}

export default function RecipeItem({ recipe }: RecipeProps) {
    const [recipe_items, set_recipe_items] = useState<Recipe_Items[]>([]);
    const [products, setProducts] = useState<{ [key: number]: Product }>({});
    
    const fetchItemsProducts = async () => {
        // Get recipe items
        const items = await findAllRecipeItems(recipe.id);
        set_recipe_items(items);

        // Get product details for each item
        const productDetails = items.map((item: Recipe_Items) => getProductById(item.product_id));
        const productResults = await Promise.all(productDetails);

        const productsMap = productResults.reduce((acc: { [key: number]: Product }, product: Product) => {
            acc[product.id] = product;
            return acc;
        }, {});

        setProducts(productsMap);
    }

    useEffect(() => {
        fetchItemsProducts();
    }, [recipe.id]);

    // Handle drop
    const handleDrop = async (event: React.DragEvent<HTMLLIElement>) => {
        // Get dropped data
        event.preventDefault();
        const productData = event.dataTransfer.getData('text/plain');
        const product: Product = JSON.parse(productData);

        // Insert product into recipe items
        await insertRecipeItem(recipe.id, product.id, 1);

        // Update recipe items and products
        fetchItemsProducts();

    }

    // Handle drag over to allow drop
    const handleDragOver = (event: React.DragEvent<HTMLLIElement>) => {
        event.preventDefault();
    }

    return (
        <li className="recipe-card" onDrop={handleDrop} onDragOver={handleDragOver}>
            <div className="recipe-details">
                <h2 className="recipe-name">{recipe.name}</h2>
                <p className="recipe-description">{recipe.description}</p>

                <ul className="recipe-list">
                    {recipe_items.map((item) => (
                        <li key={item.id} className="recipe-list-item">
                            {products[item.product_id]?.name}
                        </li>
                    ))}
                </ul>
            </div>
        </li>
    );
}
