import { getLoginStatus } from "./utils/Utils"
import { Navigate } from "react-router-dom"

function App() {

  if(getLoginStatus()){
    return <Navigate to="/dashboard"/>
  }
  else{
    return <Navigate to="/login"/>
  }

}

export default App
