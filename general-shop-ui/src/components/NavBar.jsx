import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
        <nav style={styles.nav}>
            <div style={styles.logo}> GENERAL SHOP </div>
            <ul style={styles.navLinks}>
                <li><Link to="/" style={styles.link}>Home</Link></li>
                <li><Link to="/shop" style={styles.link}>Shop</Link></li>
                <li><Link to="/cart" style={styles.link}>Cart</Link></li>
                <li><Link to="/item-form" style={styles.link}>Item Form</Link></li>
            </ul>
        </nav>
    );
};

const styles = {
    nav : {
        backgroundColor: '#333',
        color: '#fff',
        padding: '10px 20px',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    logo: {
        fontSize: '1.5em',
        fontWeight: 'bold',
    },
    navLinks: {
        display: 'flex',
        gap: '15px',
        listStyle: 'none',
    },
    link: {
        color: '#fff',
        textDecoration: 'none',
        fontSize: '1em',
        transition: 'color 0.3s',
    }

};

export default NavBar;