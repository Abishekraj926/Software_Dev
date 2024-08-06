import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import SignUp_Confirm from './components/SignUp/SignUp_Confirm'
import SignUp from './components/SignUp/SignUp'
import SignIn from './components/SignIn/SignIn'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import NavBar from './components/NavBar/NavBar'

function App() {

  return (
    <BrowserRouter>
      <NavBar></NavBar>
      <Routes>
        <Route path="/"  element={<SignUp_Confirm/>} />
        <Route path="/signup"  element={<SignUp/>} />
        <Route path="/signin"  element={<SignIn/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
