import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { Toaster } from 'react-hot-toast'

import { RouterProvider } from 'react-router-dom'
import routes from './Routes/routes.jsx'

import store from './redux/store.js'
import { Provider } from 'react-redux' //this package is used for providing the store to whole scope of out application



createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Toaster/>
    <Provider store={store}>
      <RouterProvider router={routes}/>
    </Provider>
  </StrictMode>,
)
