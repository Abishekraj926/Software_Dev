import React from 'react'
import './style.css'
import { Link } from 'react-router-dom'


function SignIn() {
  return (
    <div className='main-container__sign-in'>
      <div className='sign-in'>

        <h2 className='sign-up__title'>Sign In</h2>
        <span className='sign-up__text'>Welcome to ABC vehicle workshop</span>

        <form className='form'>

            <div class="form__input-group form__input-group--mb-0">
                <label for="email">Email</label>
                <input id="email" class="form__input"  />
            </div>
            <div class="form__input-group form__input-group--mb-0">
                <div  class="form__input-wrapper">
                    <label for="password">Password</label>
                </div>
                <input  id="password" class="form__input" type="password"  />
            </div>
           <div className='form__input-group pt-1'>
                <button class="btn-signup" >
                    <span class="btn__text">Sign In</span>
                </button>
           </div>

           <span class="form__divider">Or sign in with</span>

           <div  class="login-socials">
                <div class="login-socials__btn login-socials__btn--google">
                    <span class="login-socials__icon login-socials__icon--google" ></span>
                    <span class="login-socials__text">Google</span>
                </div>
                <div  class="login-socials__btn login-socials__btn--facebook">
                    <spann  class="login-socials__icon login-socials__icon--facebook"></spann>
                    <span class="login-socials__text">Facebook</span>
                </div>
                <div class="login-socials__btn login-socials__btn--apple">
                    <span  class="login-socials__icon login-socials__icon--apple"></span>
                    <span class="login-socials__text">Apple</span>
                </div>
            </div>

            <p  class="agreement">By continuing, you agree to our  
                <a class="underline" href=""> Privacy Policy </a> 
                    Sign in 
                <a class="underline" href=""> Terms of Service </a>. 
            </p>


            <div class="sign-up__footer">
                <p>Don't have an account?
                    <Link to={'/signup'}>
                    <a  href="#" class="underline">  Sign Up</a> 
                    </Link>
                </p>
            </div>
           
        </form>


      </div>
    </div>
  )
}

export default SignIn
