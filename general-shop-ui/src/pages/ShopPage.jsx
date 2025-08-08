import React, { useEffect, useState} from 'react';
import ItemCard from '../components/ItemCard';
import axios from 'axios';

function ShopPage() {
    const [items, setItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/items')
            .then(response => setItems(response.data))
            .catch(error => console.error('Error fetching items:', error));
    }, []);

    return (
        <div>
            <h2 className="text-3xl font-bold tracking-wide items-center text-center my-4">
                Shop with Us!!
            </h2>
            <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px' }}>
                {items.map(item => (
                    <ItemCard key={item.itemId} item={item} />
                ))}
            </div>
        </div>
    );
}

export default ShopPage;