import React from 'react';
import { Link } from 'react-router-dom';

function HomePage() {
    return (
        <div style={{ padding: '20px' }}>
            <h1>Welcome to General Shop!</h1>
            <p>Shop high quality items at the best prices.</p>
            <Link to="/shop">
                <button>Start Shopping</button>
            </Link>
        </div>
    );
}

export default HomePage;