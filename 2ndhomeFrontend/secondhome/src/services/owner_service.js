import httpClient from '../http-common';

const addOwner=(ownerdata)=>{
    return httpClient.post("owner/addOwner",ownerdata);
}

const addProperty=(propertyData)=>{
    return httpClient.post("/owner/addProperty",propertyData);
}

const getOwner=(id)=>{
     return httpClient.get(`/owner/ownerDetails/${id}`)
}

const updateOwner=(id,ownerdata)=>{
    return httpClient.put(`/owner/updateOwner/${id}`,ownerdata);
}


export default {addOwner,addProperty ,getOwner,updateOwner};