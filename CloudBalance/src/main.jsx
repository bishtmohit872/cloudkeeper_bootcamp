import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { Toaster } from 'react-hot-toast'

import { RouterProvider } from 'react-router-dom'
import routes from './Routes/routes.jsx'

import store,{persistor} from './redux/store.js'
import { Provider } from 'react-redux' //this package is used for providing the store to whole scope of out application
import { PersistGate } from 'redux-persist/integration/react'



createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Toaster/>
    <Provider store={store}>
      <PersistGate persistor={persistor}>
        <RouterProvider router={routes}/>
      </PersistGate>
    </Provider>
  </StrictMode>,
)
