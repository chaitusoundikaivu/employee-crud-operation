import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import Employees from './employees/Employees.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
   
    <Employees />
  </StrictMode>,
)
