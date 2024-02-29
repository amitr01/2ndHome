import React from "react";
import "../css/PropertyDetails.css"
import { useNavigate } from "react-router-dom"
const PropertyDetails = (props) => {
    console.log(props.property)
  const navigate=useNavigate();
    function showPropertyDetails(){
      navigate(`/showPropertyDetails/${props.property.id}`)
    }
    return (
           <div className="row bs">
            <div className="col-md-4">
            <img src={require("../Property.jpg")} className="smallimg"/>
            </div>
            <div className="col-md-7">
                    <h1>Property Name:{props.property.name}</h1>
                   <b>
                   <p>Price:{props.property.rentPrice}</p>
                    <p>Type:{props.property.type}</p>
                    <p>Status:{props.property.status}</p>
                   </b>
                    <div style={{float:'right'}}>
                      <button className="btn btn-primary" onClick={showPropertyDetails}>View Details</button>
                    </div>
                    
            </div>

           </div>
  
    );
  };
  
  export default PropertyDetails;
  