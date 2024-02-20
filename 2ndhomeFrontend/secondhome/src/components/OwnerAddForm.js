import React, { useState } from 'react';
import '../css/OwnerAddForm.css'; // Import CSS file for styling
import owner_service from '../services/owner_service';
import { useNavigate } from 'react-router-dom';

const OwnerAddForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
    gender: '',
    mobNumber: '',
    whatsappNumber: '',
    dob: '',
    adharNumber: '',
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await owner_service.addOwner(formData);
    if (response.data) {
      navigate('/login');
    }
    console.log('Form submitted:', formData);
  };

  return (
    
    <div className="owner-form-container">
        <div className="register-owner-heading">
  <h1>Register Owner</h1>
</div>
    
      <div className="column">
        
        <form onSubmit={handleSubmit} className="owner-form">
          <div className="form-group">
            <label>First Name:</label>
            <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Last Name:</label>
            <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Email:</label>
            <input type="email" name="email" value={formData.email} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Password:</label>
            <input type="password" name="password" value={formData.password} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Confirm Password:</label>
            <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required />
          </div>
        </form>
      </div>
      <div className="column">
       
        <form onSubmit={handleSubmit} className="owner-form">
          <div className="form-group">
            <label>Gender:</label>
            <input type="text" name="gender" value={formData.gender} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Mobile Number:</label>
            <input type="text" name="mobNumber" value={formData.mobNumber} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>WhatsApp Number:</label>
            <input type="text" name="whatsappNumber" value={formData.whatsappNumber} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Date of Birth:</label>
            <input type="date" name="dob" value={formData.dob} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Aadhar Number:</label>
            <input type="text" name="adharNumber" value={formData.adharNumber} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Role:</label>
            <input type="text" name="role" value="Owner" readOnly />
          </div>
          <button type="submit" className="submit-btn">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
};

export default OwnerAddForm;
