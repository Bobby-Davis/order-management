import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import  axios from 'axios';

const ItemFormPage = () => {
    const { itemId } = useParams();
    const navigate = useNavigate();

    const [itemData, setItemData] = useState({
        itemName: '',
        description: '',
        imageUrl: '',
        price: '',
        sku: '',
});

// Get existing item if editing
    useEffect(() => {
        if (itemId) {
            axios.get(`http://localhost:8080/api/items/${itemId}`)
                .then(response => setItemData(response.data))
                .catch(error => console.error('Error fetching item:', error));
        }
    }, [itemId]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setItemData(prevData => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Validate form data
        if (itemId) {
            // Update existing item
            axios.put(`http://localhost:8080/api/items/${itemId}`, itemData)
                .then(() => navigate('/shop'))
                .catch(error => console.error('Error updating item:', error));
        } else {
            // Create new item
            axios.post('http://localhost:8080/api/items', itemData)
                .then(() => navigate('/shop'))
                .catch(error => console.error('Error creating item:', error));
        }
    };

    return (
        <div className="flex justify-center items-center flex-col p-4">
            <div className="w-full max-w-md bg-white shadow-md rounded-lg p-6">
                {/*Title based on whether editing or adding*/}
                <h2 className="text-2xl font-bold mb-6 text-center">
                    {itemId ? 'Edit Item' : 'Add New Item'}
                </h2>
                {/*Form to add or edit item*/}
                <form onSubmit={handleSubmit} className="flex flex-col space-y-4">
                    <input type="text" name="itemName" value={itemData.itemName} onChange={handleChange} placeholder="Item Name" required />
                    <textarea name="description" value={itemData.description} onChange={handleChange} placeholder="Description" required />
                    <input type="text" name="imageUrl" value={itemData.imageUrl} onChange={handleChange} placeholder="Image URL" required />
                    <input type="number" name="price" value={itemData.price} onChange={handleChange} placeholder="Price" required />
                    <input type="text" name="sku" value={itemData.sku} onChange={handleChange} placeholder="SKU" required />
                    <button type="submit">{itemId ? 'Update Item' : 'Add Item'}</button>
                </form>
            </div>
        </div>
    );
};

export default ItemFormPage;
