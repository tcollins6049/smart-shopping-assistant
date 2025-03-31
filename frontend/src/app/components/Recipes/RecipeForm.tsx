import React, { useState, ChangeEvent, FormEvent } from 'react';

interface RecipeFormProps {
    onSubmit: (name: string, description: string) => void;
}

const RecipeForm: React.FC<RecipeFormProps> = ({ onSubmit }) => {
    const [name, setName] = useState<string>('');
    const [description, setDescription] = useState<string>('');

    const handleNameChange = (e: ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value);
    }

    const handleDescriptionChange = (e: ChangeEvent<HTMLInputElement>) => {
        setDescription(e.target.value);
    }

    const handleSubmit = (e: FormEvent) => {
        e.preventDefault();
        onSubmit(name, description);
        setName('');
        setDescription('');
    }

    return (
        <form onSubmit={handleSubmit} style={{ display: 'flex', alignItems: 'center' }}>
            <div style={{ flexGrow: 1, marginRight: '10px' }}>
                <input
                    type="text"
                    name="name"
                    value={name}
                    onChange={handleNameChange}
                    placeholder="Recipe Name"
                    required
                    style={{ display: 'block', width: '100%', marginBottom: '10px' }}
                />
                <input
                    type="text"
                    name="description"
                    value={description}
                    onChange={handleDescriptionChange}
                    placeholder="Recipe Description"
                    required
                    style={{ display: 'block', width: '100%' }}
                />
            </div>
            <button type="submit">Add Recipe</button>
        </form>
    )
}

export default RecipeForm;
