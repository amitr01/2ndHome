import React, { useState } from 'react';
import axios from 'axios';
import owner_service from '../services/owner_service'
import { Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import '../App.css'; // Import CSS file for styling

const AddProperty = () => {
  const [name,setName]=useState(' ')
  const [type,setType]=useState('')
  const [noOfBedrooms,setNoOfBedrooms]=useState('')
  const [rentPrice,setRentPrice]=useState('')
  const [status,setStatus]=useState('')
  const [ownerId,setOwnerId]=useState('')
  const [image1,setImage1]=useState('')
  const [image2,setImage2]=useState('')
  const [image3,setImage3]=useState('')

  const property={
    name,
    type,
    noOfBedrooms,
    rentPrice,
    status,
    ownerId,
    image1,
    image2,
    image3,
  };

  const navigate = useNavigate();
  const [selectedImages, setSelectedImages] = useState({
    image1: null,
    image2: null,
    image3: null,
  });
  // const [imagePaths, setImagePaths] = useState({
  //   image1: '',
  //   image2: '',
  //   image3: '',
  // });
  // const [formData, setFormData] = useState({
  //   name: '',
  //   type: '',
  //   noOfBedrooms: '',
  //   rentPrice: '',
  //   status: '',
  //   ownerId: '',
  // });

  // const handleInputChange = (event) => {
  //   const { name, value } = event.target;
  //   setFormData({ ...formData, [name]: value });
  // };

  const handleImageChange1 = (event) => {
    const file = event.target.files[0];
    setSelectedImages({ ...selectedImages, image1: file });
  };

  const handleImageChange2 = (event) => {
    const file = event.target.files[0];
    setSelectedImages({ ...selectedImages, image2: file });
  };

  const handleImageChange3 = (event) => {
    const file = event.target.files[0];
    setSelectedImages({ ...selectedImages, image3: file });
  };

  const uploadImage1 = async () => {
    const imageFormData = new FormData();
    imageFormData.append('image', selectedImages.image1);

    try {
      const response = await axios.post('http://localhost:8081/owner/addProperty/r1images', imageFormData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      console.log(response.data)
     setImage1(response.data);
    } catch (error) {
      console.error('Error uploading image 1:', error);
    }
  };

  const uploadImage2 = async () => {
    const imageFormData = new FormData();
    imageFormData.append('image', selectedImages.image2);

    try {
      const response = await axios.post('http://localhost:8081/owner/addProperty/r2images', imageFormData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      setImage2(response.data);
    } catch (error) {
      console.error('Error uploading image 2:', error);
    }
  };

  const uploadImage3 = async () => {
    const imageFormData = new FormData();
    imageFormData.append('image', selectedImages.image3);

    try {
      const response = await axios.post('http://localhost:8081/owner/addProperty/r3images', imageFormData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      setImage3(response.data);
    } catch (error) {
      console.error('Error uploading image 3:', error);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    await Promise.all([uploadImage1(), uploadImage2(), uploadImage3()]);

    // const fullFormData = new FormData();
    // Object.entries(formData).forEach(([key, value]) => {
    //   fullFormData.append(key, value);
    // });
    // fullFormData.append('imagePaths', JSON.stringify(imagePaths));

   const response= await owner_service
    .addProperty(property)
    .then((response) => {
      console.log('Property added successfully', response.data);
      navigate('/login');
    })
    .catch((error) => {
      console.log('something went wroing' + error.response);
    });
  };

  return (
    <div className="add-property-container">
      <h2>Add Property Information</h2>
      <form onSubmit={handleSubmit} className="property-form">
        <div className="form-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={name}
            onChange={(e)=>setName(e.target.value)}
            className="form-control"
            placeholder='Enter Full Name'
          />
        </div>
        <div className="form-group">
  <label htmlFor="type">Type:</label>
  <select
    id="type"
    name="type"
    value={type}
    onChange={(e)=>setType(e.target.value)}
    className="form-control"
  >
    <option value="">Select type</option>
    <option value="FURNISHED">FURNISHED</option>
    <option value="SEMIFURNISHED">SEMIFURNISHED</option>
    <option value="UNFURNISHED">UNFURNISHED</option>
  </select>
</div>
        <div className="form-group">
          <label htmlFor="noOfBedrooms">Number of Bedrooms:</label>
          <input
            type="number"
            id="noOfBedrooms"
            name="noOfBedrooms"
            value={noOfBedrooms}
            onChange={(e)=>setNoOfBedrooms(e.target.value)}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="rentPrice">Rent Price:</label>
          <input
            type="number"
            id="rentPrice"
            name="rentPrice"
            value={rentPrice}
            onChange={(e)=>setRentPrice(e.target.value)}
            className="form-control"
          />
        </div>
        <div className="form-group">
  <label htmlFor="status">Status:</label>
  <select
    id="status"
    name="status"
    value={status}
    onChange={(e)=>setStatus(e.target.value)}
    className="form-control"
  >
    <option value="">Select status</option>
    <option value="AVAILABLE">AVAILABLE</option>
    <option value="NOTAVAILABLE">NOTAVAILABLE</option>
  </select>
</div>
        <div className="form-group">
          <label htmlFor="ownerId">Owner ID:</label>
          <input
            type="text"
            id="ownerId"
            name="ownerId"
            value={ownerId}
            onChange={(e)=>setOwnerId(e.target.value)}
            className="form-control"
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="image1">Image 1:</label>
          <input
            type="file"
            id="image1"
            name="image1"
            accept="image/*"
            onChange={handleImageChange1}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="image2">Image 2:</label>
          <input
            type="file"
            id="image2"
            name="image2"
            accept="image/*"
            onChange={handleImageChange2}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="image3">Image 3:</label>
          <input
            type="file"
            id="image3"
            name="image3"
            accept="image/*"
            onChange={handleImageChange3}
            className="form-control"
          />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
        </form>
    </div>
  );
};

export default AddProperty;
