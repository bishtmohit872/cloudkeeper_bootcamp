import { Navigate } from "react-router-dom";
import { getLoginStatus } from "../utils/Utils";

const Protectedroute = ({children})=>{
    const isLogin = getLoginStatus()
    return isLogin?children:<Navigate to="/login"/>
}


export default Protectedroute