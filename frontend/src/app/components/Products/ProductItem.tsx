"use client"
import React from 'react';
import { addShoppingListItem } from '../../services/Shopping_List_ItemsService';

type ProductProps = {
    product: {
        id: number;
        name: string;
        description: string;
    }
}

export default function ProductItem({ product }: ProductProps) {

    /*const handleAddToShoppingList = (product_id: number) => {
        addShoppingListItem(product_id);
    }*/

    // Handle drag start
    const handleDragStart = (event: React.DragEvent<HTMLElement>) => {
        event.dataTransfer.setData('text/plain', JSON.stringify(product));
    }

    return (
        <li className="product-item" draggable onDragStart={handleDragStart}>
            <div className="product-card">
                <div className="product-details">
                    <h2 className="product-name">{product.name}</h2>
                    <p className="product-description">{product.description}</p>
                </div>
                {/*<button onClick={() => handleAddToShoppingList(product.id)}>add</button>*/}
            </div>
        </li>
    );
}
