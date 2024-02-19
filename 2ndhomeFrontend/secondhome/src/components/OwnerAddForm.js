import React, { useEffect, useState } from 'react';
import '../css/OwnerAddForm.css'; // Import CSS file for styling
import owner_service from '../services/owner_service';
import { useNavigate, useParams } from 'react-router-dom';

const OwnerAddForm = () => {
  
  const [firstName, setFirstname] = useState('');
  const [lastName, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword,setConfirmPassword]=useState('');
  const[gender,setGender]=useState('');
  const[mobNumber,setmobNumber]=useState('');
  const[whatsappNumber,setWhatsappNumber]=useState('');
  const[dob,setDob]=useState('');
  const[cardNumber,setcardNumber]=useState('');
  const[address,setAddress]=useState('');

const navigate=useNavigate();
const {id}=useParams();
 
  const handleSubmit = async (e) => {
    e.preventDefault();
    const ownerData={
   
      firstName,
      lastName,
      email,
      password,
      gender,
      mobNumber,
      whatsappNumber,
      dob,
      cardNumber,
      address,
    };
    if(id){
      //update
      
      owner_service.updateOwner(id,ownerData)
      .then((response)=>{
        console.log("Owner data update successfully")
        navigate("/");
      })
      .catch((error)=>{
       
        console.log('Error Code'+error)
      })
    }else{
      //create

      owner_service.addOwner(ownerData)
      .then((response)=>{
        console.log('Owner Added Successfully');
        navigate('/');
      })
      .catch((error)=>{
        console.log('something went wrong'+error.response);
      });
    }
  };
useEffect(()=>{
  if(id){
    owner_service.getOwner(id).
    then((ownerData)=>{
      
      setFirstname(ownerData.data.firstName);
      setLastname(ownerData.data.lastName);
      setEmail(ownerData.data.email);
      setPassword(ownerData.data.password);
      setGender(ownerData.data.gender);
      setmobNumber(ownerData.data.mobNumber);
      setWhatsappNumber(ownerData.data.whatsappNumber);
      setDob(ownerData.data.dob);
      setcardNumber(ownerData.data.cardNumber);
      setAddress(ownerData.data.address);
    })
    .catch((error)=>{
      console.log('Something went wrong',error);
    });
    
    }
},[]);


  return (
    <div className="owner-form-container">
      <h2>Add Owner</h2>
      <form onSubmit={handleSubmit} className="owner-form">
        <div className="form-group">
          <label>First Name:</label>
          <input type="text" name="firstName" value={firstName} onChange={(e)=>setFirstname(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Last Name:</label>
          <input type="text" name="lastName" value={lastName} onChange={(e)=>setLastname(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Email:</label>
          <input type="email" name="email" value={email} onChange={(e)=>setEmail(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input type="password" name="password" value={password} onChange={(e)=>setPassword(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Confirm Password:</label>
          <input type="password" name="confirmPassword" value={confirmPassword} onChange={(e)=>setConfirmPassword(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Gender:</label>
          <input type="text" name="gender" value={gender} onChange={(e)=>setGender(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Mobile Number:</label>
          <input type="text" name="mobNumber" value={mobNumber} onChange={(e)=>setmobNumber(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>WhatsApp Number:</label>
          <input type="text" name="whatsappNumber" value={whatsappNumber} onChange={(e)=>setWhatsappNumber(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Date of Birth:</label>
          <input type="date" name="dob" value={dob} onChange={(e)=>setDob(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Aadhar Number:</label>
          <input type="text" name="cardNumber" value={cardNumber} onChange={(e)=>setcardNumber(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Address</label>
          <input type="text" name="address" value={address} onChange={(e)=>setAddress(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Role:</label>
          <input type="text" name="role" value="Owner" readOnly />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
  
};

export default OwnerAddForm;
