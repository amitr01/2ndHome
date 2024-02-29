import React, { useState, useEffect } from "react";
import user_service from "../services/user_service";
import PropertyDetails from "./PropertyDetails";
import "../css/propertyList.css";

const PropertyList = (props) => {
  const [propaddr, setPropArr] = useState([]);
  const[city,setCity]=useState('');

  const fetchdata = () => {
    user_service
      .getAll()
      .then((result) => {
        setPropArr([...result.data]);
      })
      .catch((err) => {
        console.log("error occurrence", err);
      });
  };

  useEffect(() => {
    console.log("in list initialization useEffect");
    fetchdata();
  }, []);

  const handleSortByType = () => {
    user_service
      .getAllByType()
      .then((result) => {
        setPropArr([...result.data]);
      })
      .catch((err) => {
        console.log("error occurrence", err);
      });
  };

  const handleSortByCity = (city) => {
    user_service
      .getAllByCity(city)
      .then((result) => {
        setPropArr([...result.data]);
      })
      .catch((err) => {
        console.log("error occurrence", err);
      });
  };

  return (
//     <div className="property-list-container">
//       <div className="sorting-options">
//         <div>
//           <label>Sort by Type:</label>
//           <button onClick={handleSortByType}>Sort</button>
//         </div>
//         <div>
//           <label>Sort by Name:</label>
//           <button onClick={handleSortByName}>Sort</button>
//         </div>
//       </div>
//       <div className="elements-above-list">
//   {/* Elements above the list */}
// </div>
<div className="container">
<div className=" mt-3 bs">
<div className="row justify-content-center">
      <div className="col-md-6">
        <input type="text" placeholder="Sort By City" onChange={(e)=>{setCity(e.target.value)}} onKeyUp={handleSortByCity} />
      </div>
      <div className="col-md-6">
        <select className="form-select" onChange={handleSortByType}>
          <option value="">Sort By Type</option>
          <option value="Furnished">Furnished</option>
          <option value="SemiFurnished">SemiFurnished</option>
          <option value="NonFurnished">NonFurnished</option>
        </select>
      </div>
      </div>
    </div>


      <div className="row justify-content-center mt-5" >
        {propaddr.map((property) => {
          return <div className="col-md-9 mt-2">
                 <PropertyDetails
                   key={property.pid}
                   getData={fetchdata}

                  property={property}
                       />
          </div>
        }
      
        )}
      </div>
    </div>
  );
};


export default PropertyList;
