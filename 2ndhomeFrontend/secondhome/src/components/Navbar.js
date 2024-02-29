import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import App from '../App';
import "../css/Navbar.css"; // Import CSS file for component styling


const Navbar = () => {


  return (
    // <div className="navbar-background">
    //   <nav className="navbar-container">
    
    //     <ul className="nav-links">
    //       <li>
    //         <Link to="/login">Login</Link>
    //       </li>
    //       <li>
    //         <Link to="/addUser">UserSignup</Link>
    //       </li>
    //       <li>
    //         <Link to="/addowner">OwnerSignup</Link>
    //       </li>
    //       <li>
    //         <Link to="/contact">Contact Us</Link>
    //       </li>
    //     </ul>
    //   </nav>
     
    // </div>
    <div className='navbar-container'>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <b><a className="navbar-brand" href="/">2ndHome</a></b>
  <button className="navbar-toggler" type="button" data-toggle="collapse" 
  data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span className="navbar-toggler-icon"></span>
  </button>
  <div className="collapse navbar-collapse" id="navbarNav">
    <ul className="navbar-nav nav-links">
      <li className="nav-item active">
      <Link to="/login">Login</Link>
      </li>
      <li className="nav-item">
      <Link to="/addUser">UserSignup</Link>
      </li>
      <li className="nav-item">
      <Link to="/addowner">OwnerSignup</Link>
      </li>
      <li className="nav-item">
      <Link to="/contact">Contact Us</Link>
      </li>
    </ul>
  </div>
</nav>
</div>
  );
};

export default Navbar;
