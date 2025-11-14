import { Link, Outlet } from "react-router-dom";

export default function Layout() {
  return (
    <div>
      <nav style={{ 
        display: "flex", 
        gap: "20px", 
        background: "#eee", 
        padding: "10px" 
      }}>
        <Link to="/dashboard">Dashboard</Link>
        <Link to="/counter">Counter</Link>
        <Link to="/watch">Digital Watch</Link>
      </nav>

      <main style={{ marginTop: "20px" }}>
        <Outlet />
      </main>
    </div>
  );
}
