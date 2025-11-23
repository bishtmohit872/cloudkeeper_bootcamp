import { Link, NavLink } from "react-router-dom"
import MenuList from "./MenuList"

const SideMenuBar =({state})=>{
    return(
        <div className={`h-full w-2/12 p-4 transition-transform transform absolute z-30  duration-700 -translate-x-[400px] shadow-lg ${state?'translate-x-0':'-translate-x-[400px]'} bg-white`}>
                
                <div className="h-max py-4">
                    {
                        MenuList.map((menu)=>(
                            <NavLink key={menu.id} to={menu.path} className={({isActive})=>`${isActive ? " bg-blue-950 rounded-md text-white shadow-lg":""} p-4 w-full flex items-center justify-start text-blue-950 overflow-hidden`}>
                                <span>{menu.logo}</span>
                                <p className="ml-2 text-lg text-nowrap">{menu.name}</p>
                            </NavLink>
                        ))
                    }
                </div>
        </div>
    )
}

export default SideMenuBar