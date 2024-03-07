import React, { useState } from 'react';
import '../css/UserAddForm.css'; // Import CSS file for styling
import '../services/user_service';
import user_service from '../services/user_service';
import { useNavigate } from 'react-router-dom';

const UserAddForm = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
    gender: '',
    otp:'',
    role: 'VISITOR' // Set role to 'VISITOR' by default
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const navigate = useNavigate();
  const handleSendOTP = async () => {
    // Send email to the user's email address with the OTP
    // You may call a backend endpoint here to send the OTP to the user's email
    // For simplicity, let's assume this function sends an OTP to the user's email
    const response = await user_service.sendOTP(formData.email);
  
  };
  const handleSubmit =async (e) => {
    e.preventDefault();
    /*const handleSubmit = async (e) => {
    e.preventDefault();
  const response=await owner_service.addOwner(formData);
  if(response.data){
    navigate("/login")
  }
    console.log('Form submitted:', formData);
  }; */
  const response =await  user_service.addUSer(formData);
  if(response.data){
   navigate("/")
  }
    console.log('Form submitted:', formData);
  };

  return (
    <div className="user-form-container">
      <h2>Register User</h2>
      <form onSubmit={handleSubmit} className="user-form">
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
          <label>OTP:</label>
          <input type="text" name="otp" value={formData.otp} onChange={handleChange} required />
          <button type="button" onClick={handleSendOTP}>Send OTP</button>
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input type="password" name="password" value={formData.password} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>Confirm Password:</label>
          <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>Gender:</label>
          <input type="text" name="gender" value={formData.gender} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>Role:</label>
          <select name="role" value={formData.role} onChange={handleChange} disabled>
            <option value="VISITOR">Visitor</option>
          </select>
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
};

export default UserAddForm;
