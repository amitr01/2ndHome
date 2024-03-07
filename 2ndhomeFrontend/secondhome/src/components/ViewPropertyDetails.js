import React, { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import user_service from '../services/user_service';
import { useState } from 'react';
import { Collapse } from 'bootstrap';
export default function ViewPropertyDetails() {
   

    const [propDetails,setpropDetails]=useState([]);
    const id=useParams();
    const fetchdata=()=>{
        console.log(id);
        user_service.
        getPropertyDetailsById(id)
        .then((result)=>{
              setpropDetails([...result.data]);
        })
        .catch((err) => {
          console.log("error occurrence", err);
        });
    }

   
    useEffect(()=>{
        console.log("in use Effect")
     
     
       fetchdata();
    },[])

    
  return (
    <div className="row bs">
    <div className="col-md-4">
    <img src={require("../Property.jpg")} className="largeimg"/>
    </div>
    <div className="col-md-7">
            <h1>Property Name:{propDetails.name}</h1>
           <b>
           <p>Price:{propDetails.rentPrice}</p>
            <p>Type:{propDetails.type}</p>
            <p>Status:{propDetails.status}</p>
            <p>Description:{propDetails.Description}</p>
            <p>Owner Contact Number:{propDetails.Number}</p>
            <p>Owner Whatsapp Number:{propDetails.WhatsappNumber}</p>
           </b>
          
            
    </div>

   </div>
  )
}
