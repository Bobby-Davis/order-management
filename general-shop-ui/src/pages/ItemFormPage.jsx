import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import  axios from 'axios';

const ItemFormPage = () => {

    const navigate = useNavigate();

    const [searchTerms, setSearchTerms] = useState('');
    const [itemData, setItemData] = useState({});
    const [notFound, setNotFound] = useState(false);
    const [formVisible, setFormVisible] = useState(false);
    const [isEditMode, setIsEditMode] = useState(false);

    const emptyForm = {
        itemName: '',
        description: '',
        imageUrl: '',
        price: '',
        sku: '',
        availableQuantity: ''
};

    const handleSearch = async () => {
        setNotFound(false);
        setFormVisible(false);
        setItemData(null);
        setIsEditMode(false);
        
        try {
            const response = await axios.get(`http://localhost:8080/api/items/sku/${searchTerms}`);
            setItemData(response.data);
            setFormVisible(true);
            setIsEditMode(true);
        } catch (error) {
            setItemData({ ...emptyForm, sku: searchTerms });
            setNotFound(true);
            setFormVisible(true);
            setIsEditMode(false);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setItemData(prevData => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Validate form data
        if (itemData.itemId) {
            // Update existing item
            axios.put(`http://localhost:8080/api/items/${itemData.itemId}`, itemData)
                .then(() => navigate('/shop'))
                .catch(error => console.error('Error updating item:', error));
        } else {
            // Create new item
            axios.post('http://localhost:8080/api/items', itemData)
                .then(() => navigate('/shop'))
                .catch(error => console.error('Error creating item:', error));
        }
    };

    const handleDelete = () => {
        axios.delete(`http://localhost:8080/api/items/${itemData.itemId}`)
            .then(() => navigate('/shop'))
            .catch(error => console.error('Error deleting item:', error));
    };

    return (
        <div className="flex justify-center items-center min-h-screen bg-gray-100 p-4">
            <div className="w-full max-w-md bg-white shadow-lg rounded-lg p-6">
                <h2 className="text-2xl font-bold mb-6 text-center">
                    Enter SKU
                </h2>
                <div className="flex space-x-2">
                    <input
                        type="text"
                        placeholder="Enter SKU"
                        value={searchTerms}
                        onChange={(e) => setSearchTerms(e.target.value)}
                        className="w-full p-2 border border-gray-300 rounded mb-4"
                    />
                    <button
                        onClick={handleSearch}
                        className="w-full bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition-colors duration-200 mb-4"
                    >
                        Search Item
                    </button>
                </div>

                {notFound && (
                    <div className="text-red-500 text-center mb-4">
                        Item not found. You can add item below.
                    </div>
                    )}
            </div>

            {formVisible && itemData && (
                <div className="w-full max-w-md bg-white shadow-lg rounded-lg p-6 mt-4">
                    <h2 className="text-2xl font-bold mb-6 text-center">
                        {itemData.itemId ? 'Update Item' : 'Add New Item'}
                    </h2>
                    <form onSubmit={handleSubmit} className="flex flex-col items-center space-y-4">

                        <input 
                            type="text" 
                            name="itemName" 
                            value={itemData.itemName} 
                            onChange={handleChange} 
                            placeholder="Item Name" 
                            required
                            className="w-80 border border-gray-300 p-2 rounded"
                        />

                        <textarea 
                            name="description" 
                            value={itemData.description} 
                            onChange={handleChange} 
                            placeholder="Description" 
                            required
                            className="w-80 border border-gray-300 p-2 rounded resize-none"
                        />

                        <input 
                            type="text" 
                            name="imageUrl" 
                            value={itemData.imageUrl} 
                            onChange={handleChange} 
                            placeholder="Image URL" 
                            required
                            className="w-80 border border-gray-300 p-2 rounded" 
                        />

                        <input 
                            type="number" 
                            name="price" 
                            value={itemData.price} 
                            onChange={handleChange} 
                            placeholder="Price" 
                            required
                            className="w-80 border border-gray-300 p-2 rounded"
                        />

                        <input 
                            type="text" 
                            name="sku" 
                            value={itemData.sku} 
                            onChange={handleChange} 
                            placeholder="SKU" 
                            required
                            className="w-80 border border-gray-300 p-2 rounded" 
                        />

                        <input 
                        type="number" 
                        name="availableQuantity" 
                        value={itemData.availableQuantity || ''} 
                        onChange={handleChange} 
                        placeholder="Available Quantity" 
                        required
                        className="w-80 border border-gray-300 p-2 rounded" 
                        />

                        <div className="flex space-x-2 w-full justify-center">
                            {isEditMode ? (
                                <>
                                    <button
                                        type="submit"
                                        className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600 transition-colors duration-200"
                                    >
                                        Update Item
                                    </button>
                                    <button
                                        type="button"
                                        onClick={handleDelete}
                                        className="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition-colors duration-200"
                                    >
                                        Delete Item
                                    </button>
                                </>
                            ) : (
                                <button
                                    type="submit"
                                    className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition-colors duration-200"
                                >
                                    Add Item
                                </button>
                            )}
                        </div>
                    </form>
            </div>
            )}
        </div>
    );
};

export default ItemFormPage;
