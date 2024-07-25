import React, { useRef,useState } from 'react'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Typography } from '@mui/material';

function Login() {
    let name = useRef(null)
    let password = useRef(null)
    const [error,setError] = useState({name:false,password:false})
    const handleSubmit =(e)=>{
        e.preventDefault();
        if(name.current.value && password.current.value)
            {
        console.log(name.current.value)
        console.log(password.current.value)
            }
            else {
                if(!name.current.value && !password.current.value)
                  setError((prev)=>{
                  return{...prev,name:true,password:true};
                })
                else if(!name.current.value)
                  setError((prev)=>{
                  return{...prev,name:true,};
                })
                else if(!password.current.value)
                  setError((prev)=>{
                  return{...prev,password:true,};
                })
            }
    }
    return(<Box
    component="form"
    sx={{
      '& > :not(style)': { m: 1, width: '25ch' },
      display:"flex",
      justifyContent:"center",
      allignitems:"center",
      flexDirection:"column",
      width:"100%",
      height:"100vh",
    }}
    noValidate
    autoComplete="off"
  >
   
    <TextField inputRef={name} id="filled-basic" label="USER_NAME" variant="filled" />
    <br></br>
    {error.name&&(<Typography color="red" fontSize={"10px"}>FILL THE NAME</Typography>)}
    <TextField inputRef={password} id="filled-basic" label="PASSWORD" type="password" variant="filled" />
    {error.password&&(<Typography color="red" fontSize={"10px"}>FILL THE PASSWORD</Typography>)}
    <Button variant="contained" onClick={handleSubmit}>Submit</Button>
  </Box>
    
);
}

export default Login
