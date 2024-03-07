import React from 'react';
import { useNavigate } from 'react-router-dom';
import backgroundImage from '../images/OverAllBackground.jpg'; // Import background image
 // Import CSS file for component styling

const Home = () => {
  const navigate = useNavigate();

  // Function to handle redirection to login page
  const handleExplore = () => {
    navigate("/login"); // Redirect to the login page
  };

  return (
    <div
      className="home-container" >
      <div className="content">
        <h1 className="title">Welcome to <span className="highlight">2ndHome</span></h1>
        <p className="subtitle">Find your perfect PG/Hostel accommodation</p>
        <button className="explore-button" onClick={handleExplore}>Explore</button>
        <div className="contact-info">
          <h3>Contact Us</h3>
          <p>Email: t.wankhede1705@gmail.com</p>
          <p>Phone: +919370589290</p>
        </div>
      </div>
    </div>
  );
};

export default Home;
