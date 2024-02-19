import React, { useState } from 'react';
import '../css/AddressForm.css'; // Import CSS file for styling
import user_service from '../services/user_service';
import owner_service from '../services/owner_service';
import { Navigate, useNavigate } from 'react-router-dom';

const AddressForm = () => {
  const [formData, setFormData] = useState({
    street: '',
    city: '',
    state: '',
    zipCode: ''
  });

  const navigate = useNavigate();
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit =async (e) => {
    e.preventDefault();
    const response = await owner_service.assignAddress(formData);
    if(response.data){
      navigate("/owner/:pid/property")
    }
    console.log('Form submitted:', formData);
  };

  return (
    <div className="address-form-container">
      <h2>Assign Address</h2>
      <form onSubmit={handleSubmit} className="address-form">
        <div className="form-group">
          <label>Street:</label>
          <input type="text" name="street" value={formData.street} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>City:</label>
          <input type="text" name="city" value={formData.city} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>State:</label>
          <input type="text" name="state" value={formData.state} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>Zip Code:</label>
          <input type="text" name="zipCode" value={formData.zipCode} onChange={handleChange} required />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
};

export default AddressForm;
