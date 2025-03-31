"use client"
import React, {useState, useEffect } from 'react';
import { addShoppingListItem } from '../../services/Shopping_List_ItemsService';
import { getProductById } from '../../services/ProductsService';

type ShoppingListItemProps = {
    shoppingItem: {
        id: number;
        shopping_list_id: number;
        product_id: number;
        quantity: number;
    }
}

export default function ShoppingListItem({ shoppingItem }: ShoppingListItemProps) {
    const [productName, setProductName] = useState('');


    useEffect(() => {
        const fetchProductData = async () => {
            const data = await getProductById(shoppingItem.product_id);
            setProductName(data.name);
        }
        
        fetchProductData();
    })

    return (
        <li className="shopping-list-item">
            <div>
                <h2 className="shopping-item-name">{productName}</h2>
                <p className="shopping-item-quantity">{shoppingItem.quantity}</p>
            </div>
        </li>
    );
}
