

import React from 'react'
import "../css/Navbar.css"
import { useNavigate } from 'react-router-dom';
import '../css/Home.css';
export default function MainPage() {

    const navigate = useNavigate();

    const handleExplore = () => {
      navigate('/propertyList');
    };
  return (
  
    <div className="main-screen">
        <h1>2ndHome</h1>
        <h2>A complete solution for PG finding</h2>
        
        <button onClick={handleExplore}>Explore</button>
      </div>
      
  )
}
