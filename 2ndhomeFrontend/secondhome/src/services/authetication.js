import httpClient from "../http-common"

const sigin=(SignData)=>{
    return httpClient.post("/login/signIn",SignData);
}



export default {sigin}