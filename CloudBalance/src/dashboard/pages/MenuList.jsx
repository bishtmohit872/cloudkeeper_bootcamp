import { LuUsers } from "react-icons/lu"
import { BiSolidUserBadge } from "react-icons/bi"
import { FaAws } from "react-icons/fa"
import { FaMoneyBillTrendUp } from "react-icons/fa6"

const MenuList = [
    {
        id:1,
        name:"User Management",
        logo:<LuUsers className="size-7"/>,
        path:"user"
    },
    {
        id:2,
        name:"Onboarding",
        logo:<BiSolidUserBadge className="size-7"/>,
        path:"/onboarding"
    },
    {
        id:3,
        name:"Aws Service",
        logo:<FaAws className="size-7"/>,
        path:"aws-cloud"
    },
    {
        id:4,
        name:"Cost Explorer",
        logo:<FaMoneyBillTrendUp className="size-7"/>,
        path:"cost-explorer"
    },
]

export default MenuList
