import { useState } from "react"
import { Outlet } from "react-router-dom"
import Navbar from "../components/Navbar"
import SideMenuBar from "./pages/SideMenuBar"

const Layout = () =>{

    const [openSidebar, setOpenSideBar] = useState(false)

    return(
        <div className="h-screen w-screen relative flex flex-col items-center">
            <Navbar state={openSidebar} setState={setOpenSideBar}/>

            <main className="flex-1 w-screen relative">
                <SideMenuBar state={openSidebar}/>
                <Outlet/>
            </main>

            <footer>
                <div className="h-max w-screen shadow-lg p-4 text-gray-500">
                    <p>Cloudkeeper 2025 | All Right Reserved</p>
                </div>
            </footer>
        </div>
    )
}

export default Layout