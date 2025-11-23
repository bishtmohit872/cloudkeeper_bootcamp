import { useSelector } from "react-redux"
import { setLoginStatus } from "../utils/Utils"
import { useNavigate } from "react-router-dom"

const Navbar = ({state,setState}) =>{

    const navigate = useNavigate()
    const loginUser = useSelector((store)=>store.loginUserInfo)
    
    const handleSideBarState=()=>{
        setState(!state)
    }

    const handleLogout=()=>{
        setLoginStatus(false)
        navigate("/login")
    }

    return(
        <div className="h-max w-screen py-4 px-4 flex items-center justify-between shadow-md bg-color-white relative z-11">
            <div className="h-max w-[250px] flex items-end justify-between">
                <img className="h-full w-[200px]" src="/assets/cloudbalance.png" />
                <img className="size-6 cursor-pointer" src="/assets/menu.png" alt="menu" onClick={handleSideBarState}/>
            </div>

            <div className="h-max w-max  flex items-center justify-center">
                <div className="h-max w-[180px] flex items-center justify-evenly border-r-2 border-gray-400">
                    <img className="size-12 shadow-md shadow-gray-400 rounded-full" src="/assets/user.png" alt="user"/>

                    <div className="text-sm">
                        <p className="text-blue-950 font-bold">Welcome</p>
                        <p>{loginUser.name}</p>
                    </div>
                </div>

                <div className="flex items-center ml-2 justify-evenly rounded-md">
                    <img className="size-8" src="/assets/logout.png" alt="logout"/>
                    <button className="ml-2 px-4 py-2 outline-none bg-blue-950 text-white rounded-md cursor-pointer hover:bg-blue-900" onClick={handleLogout}>Logout</button>
                </div>
            </div>


        </div>
    )
}


export default Navbar