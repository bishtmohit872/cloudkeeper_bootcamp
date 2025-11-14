import { Navigate, Outlet } from "react-router-dom";

export default function ProtectedRoute({ isLogin }) {
  return isLogin ? <Outlet /> : <Navigate to="/login" />;
}
