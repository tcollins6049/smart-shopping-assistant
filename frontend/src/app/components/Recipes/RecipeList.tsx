"use client"
import React, { useState, useEffect } from 'react';
import RecipeForm from './RecipeForm';
import { getUserId } from '../../userInfo';
import { insertRecipe, getAllUserRecipes } from '../../services/RecipesService';
import RecipeItem from './RecipeItem';

export default function RecipeList() {
    const [showForm, setShowForm] = useState<boolean>(false);
    const [recipes, setRecipes] = useState<any[]>([]);

    useEffect(() => {
        const fetchRecipes = async () => {
            const data = await getAllUserRecipes(getUserId());
            setRecipes(data);
        }

        fetchRecipes();
    })

    const handleFormSubmit = async (name: string, description: string) => {
        console.log("Inserting recipe");
        await insertRecipe(name, description);
        setShowForm(false);
    }

    return (
        <div>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <h1>Recipes</h1>
                <button 
                    onClick={() => setShowForm(!showForm)}
                    className="recipe-button"
                >+</button>
            </div>
            {showForm && <RecipeForm onSubmit={handleFormSubmit} />}

            <ul>
                {recipes.map((recipe) => (
                    <RecipeItem key={recipe.id} recipe={recipe} />
                ))}
            </ul>
        </div>
    )
}