import { useNavigate } from "react-router-dom";

export default function Login({ setIsLogin }) {
  const navigate = useNavigate();

  const handleLogin = () => {
    setIsLogin(true);
    navigate("/dashboard");
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Login Page</h1>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}
