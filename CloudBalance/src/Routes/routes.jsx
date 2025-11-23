import { createBrowserRouter } from "react-router-dom";

import Login from "../auth/Login";
import App from "../App";
import Protectedroute from "../components/Protectroute";
import Dashboard from "../dashboard/Dashboard";
import User from "../dashboard/pages/UserPages/User";
import UserList from "../dashboard/pages/UserPages/UserList";
import UserForm from "../dashboard/pages/UserPages/UserForm";

const routes = createBrowserRouter([

    {
        path:"/",
        element:<App/>,
    },
    {
        path:"/login",
        element:<Login/>,
    },
    {
        path:"/dashboard",
        element:<Protectedroute><Dashboard/></Protectedroute>,
        children:[
            {
                path:"user",
                element:<User/>,
                children:[
                    {
                        path:"",
                        element:<UserList/>
                    },
                    {
                        path:"addUser",
                        element:<UserForm mode="add"/>,
                    },
                ]
            },
        ],
    }
])


export default routes