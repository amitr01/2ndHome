import React, { useState } from 'react';
import '../css/RoomAddForm.css'; // Import CSS file for styling

const RoomAddForm = () => {
  const [formData, setFormData] = useState({
    noOfBeds: '',
    hasBathroom: false,
    desc: ''
  });

  const handleChange = (e) => {
    const value = e.target.type === 'checkbox' ? e.target.checked : e.target.value;
    setFormData({
      ...formData,
      [e.target.name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form submitted:', formData);
  };

  return (
    <div className="room-form-container">
      <h2>Add Room</h2>
      <form onSubmit={handleSubmit} className="room-form">
        <div className="form-group">
          <label>Number of Beds:</label>
          <input type="number" name="noOfBeds" value={formData.noOfBeds} onChange={handleChange} required />
        </div>
        <div className="form-group">
          <label>Has Bathroom:</label>
          <input type="checkbox" name="hasBathroom" checked={formData.hasBathroom} onChange={handleChange} />
        </div>
        <div className="form-group">
          <label>Description:</label>
          <textarea name="desc" value={formData.desc} onChange={handleChange} required />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
};

export default RoomAddForm;
