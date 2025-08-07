import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import CartPage from './pages/CartPage';
import ShopPage from './pages/ShopPage';
import ItemFormPage from './pages/ItemFormPage';

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/shop" element={<ShopPage />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/item-form/:id?" element={<ItemFormPage />} />
      </Routes>
    </Router>
  );
}

export default App;
