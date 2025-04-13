import React, {useEffect, useState} from 'react';
import { findAllSListItems } from '../../services/Shopping_List_ItemsService';
import ShoppingListItem from './ShoppingListItem';
import { addRecipeToList, addShoppingListItem } from '../../services/Shopping_List_ItemsService';

type ShoppingListProps = {
    shoppingListId: number;
}

export default function ShoppingList({ shoppingListId }: ShoppingListProps) {
    const [listItems, setListItems] = useState<any[]>([]);
    
    console.log("ShoppingList Id: ", shoppingListId);
    useEffect(() => {
        if (shoppingListId !== null && shoppingListId !== undefined) {
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
        const droppedData = event.dataTransfer.getData('text/plain');
        console.log("Parsed data: ", droppedData);

        try {
            const parsed = JSON.parse(droppedData);
            if (parsed.type === 'product') {
                await addShoppingListItem(parsed.id, shoppingListId);
            } else if (parsed.type === 'recipe') {
                await addRecipeToList(parsed.id);
            }

            // Refresh the list
            const data = await findAllSListItems(shoppingListId);
            setListItems(data);
        } catch (error) {
            console.error("Failed to process dropped item:", error);
        }
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