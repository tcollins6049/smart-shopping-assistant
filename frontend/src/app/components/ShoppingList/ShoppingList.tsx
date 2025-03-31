import React, {useEffect, useState} from 'react';
import { findAllSListItems } from '../../services/Shopping_List_ItemsService';
import ShoppingListItem from './ShoppingListItem';
import { addShoppingListItem } from '../../services/Shopping_List_ItemsService';

type ShoppingListProps = {
    shoppingListId: number;
}

export default function ShoppingList({ shoppingListId }: ShoppingListProps) {
    const [listItems, setListItems] = useState<any[]>([]);
    
    useEffect(() => {
        if (shoppingListId) {
            const fetchItems = async () => {
                console.log("Shop id: ", shoppingListId);
                const data = await findAllSListItems(shoppingListId);
                setListItems(data);
            }

            fetchItems();
        }
    }, [shoppingListId]);

    const handleDrop = async (event: React.DragEvent<HTMLDivElement>) => {
        event.preventDefault();
        const productData = event.dataTransfer.getData('text/plain');
        const product = JSON.parse(productData);

        // Insert product into shopping list
        await addShoppingListItem(product.id, shoppingListId);

        // Refresh the list
        const data = await findAllSListItems(shoppingListId);
        setListItems(data);
    }

    const handleDragOver = (event: React.DragEvent<HTMLDivElement>) => {
        event.preventDefault();
    }

    return (
        <div onDrop={handleDrop} onDragOver={handleDragOver}>
            <h1>Shopping List</h1>
            <ul>
                {listItems.map((item) => (
                    <ShoppingListItem key={item.id} shoppingItem={item} />
                ))}
            </ul>
        </div>
    )
}