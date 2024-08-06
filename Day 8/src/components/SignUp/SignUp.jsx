import React from 'react'
import './SignUp.css'
import { Link } from 'react-router-dom'
function SignUp() {
  return (
    <div className='main-container'>
      <div className='sign-up'>

        <h2 className='sign-up__title'>Create an account</h2>
        <span className='sign-up__text'>Welcome to ABC vehicle workshop! Let’s get you set up!</span>

        <form className='form'>

            <div class="form__input-group form__input-group--mb-0">
                <label for="name">Full Name</label>
                <input  id="name" class="form__input"  />
            </div>
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
                    <span class="btn__text">Create an account</span>
                </button>
           </div>

           <span class="form__divider">Or sign up with</span>

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
                <a class="underline" href=""> Privacy Policy</a> 
                     Sign in 
                <a class="underline" href=""> Terms of Service </a>. 
            </p>

            <div class="sign-up__footer">
                <p>Already have an account?
                    <Link to={'/signin'}>
                    <a  href="#" class="underline">  Sign in</a>
                    </Link> 
                </p>
                <p>You can also use your <strong>credentials</strong> to login!</p>
            </div>
           
        </form>


      </div>
    </div>
  )
}

export default SignUp
