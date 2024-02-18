import React, { useState } from 'react';
import axios from 'axios';

const AddProperty = () => {
  const [selectedImages, setSelectedImages] = useState([]);
  const [formData, setFormData] = useState({
    name: '',
    type: '',
    noOfBedrooms: '',
    rentPrice: '',
    status: '',
    ownerId: '',
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleImageChange = (event) => {
    setSelectedImages([...event.target.files]);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    const imageFormData = new FormData();
    selectedImages.forEach((image) => {
      imageFormData.append('image', image);
    });

    const fullFormData = new FormData();
    Object.entries(formData).forEach(([key, value]) => {
      fullFormData.append(key, value);
    });

    try {
      // Upload images first
      const imageResponse = await axios.post('/owner/addProperty/r', imageFormData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      // Assuming image upload returns the paths of the uploaded images
      const imagePaths = imageResponse.data;

      // Append image paths to form data
      fullFormData.append('imagePaths', JSON.stringify(imagePaths));

      // Send full form data to backend
      const response = await axios.post('/api/your-endpoint', fullFormData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      console.log('Form submission successful!', response.data);
    } catch (error) {
      console.error('Error submitting form:', error);
    }
  };

  return (
    <div>
      <h2>Property Information & Image Upload Form</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="type">Type:</label>
          <input
            type="text"
            id="type"
            name="type"
            value={formData.type}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="noOfBedrooms">Number of Bedrooms:</label>
          <input
            type="number"
            id="noOfBedrooms"
            name="noOfBedrooms"
            value={formData.noOfBedrooms}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="rentPrice">Rent Price:</label>
          <input
            type="number"
            id="rentPrice"
            name="rentPrice"
            value={formData.rentPrice}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="status">Status:</label>
          <input
            type="text"
            id="status"
            name="status"
            value={formData.status}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="ownerId">Owner ID:</label>
          <input
            type="text"
            id="ownerId"
            name="ownerId"
            value={formData.ownerId}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="image">Select Image(s):</label>
          <input
            type="file"
            id="image"
            name="image"
            multiple
            onChange={handleImageChange}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddProperty;
