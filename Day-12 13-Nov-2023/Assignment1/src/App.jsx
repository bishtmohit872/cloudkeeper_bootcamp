import { Routes, Route, Navigate } from "react-router-dom";
import { useEffect, useState } from "react";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import Counter from "./pages/Counter";
import DigitalWatch from "./pages/DigitalWatch";
import NotFound from "./pages/NotFound";
import ProtectedRoute from "./components/ProtectedRoute";
import Layout from "./components/Layout";

function App() {
  
  const [isLogin, setIsLogin] = useState(
    () => JSON.parse(localStorage.getItem("login")) || false
  );

  useEffect(() => {
    localStorage.setItem("login", JSON.stringify(isLogin));
  }, [isLogin]);

  return (
    <Routes>

      <Route 
        path="/login" 
        element={
          isLogin ? <Navigate to="/dashboard" /> : <Login setIsLogin={setIsLogin} />
        } 
      />

      <Route element={<ProtectedRoute isLogin={isLogin} />}>
        
        <Route element={<Layout />}>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/counter" element={<Counter />} />
          <Route path="/watch" element={<DigitalWatch />} />
        </Route>

      </Route>

      <Route path="/" element={<Navigate to="/login" />} />

      <Route path="*" element={<NotFound />} />

    </Routes>
  );
}

export default App;
