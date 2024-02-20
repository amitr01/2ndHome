import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import "../css/Navbar.css"; // Import CSS file for component styling

const Navbar = () => {
  const navigate = useNavigate();

  const handleExplore = () => {
    navigate('/login');
  };

  return (
    <div className="navbar-background">
      <nav className="navbar-container">
    
        <ul className="nav-links">
          <li>
            <Link to="/login">Login</Link>
          </li>
          <li>
            <Link to="/addUser">UserSignup</Link>
          </li>
          <li>
            <Link to="/addowner">OwnerSignup</Link>
          </li>
          <li>
            <Link to="/contact">Contact Us</Link>
          </li>
        </ul>
      </nav>
      <div className="main-screen">
        <h1>2ndHome</h1>
        <h2>A complete solution for PG finding</h2>
        
        <button onClick={handleExplore}>Explore</button>
      </div>
    </div>
  );
};

export default Navbar;
