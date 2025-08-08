import React from 'react';
import { Link } from 'react-router-dom';

function HomePage() {
    return (
        <div className="p-8 bg-gray-100 flex flex-col items-center justify-center min-h-screen">
            <h1 className="text-3xl font-bold mb-2">Welcome to General Shop!</h1>
            <p className="text-lg mb-4">Shop high quality items at the best prices.</p>
            <Link to="/shop">
                <button className="bg-blue-500 text-white px-6 py-3 rounded hover:bg-blue-600 transition duration-300">
                    Start Shopping
                </button>
            </Link>
        </div>
    );
}

export default HomePage;