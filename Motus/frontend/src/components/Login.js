import React,{useState} from 'react';import api from '../api';
export default function Login({setToken}){
  const [pseudo,pw]=[...Array(2)].map(()=>useState(''));
  const handle=async()=>{
    const res=await api.post('/auth/login',{username:pseudo[0],password:pw[0]});
    setToken(res.data);
  };
  return <div><h3>Login</h3>
    <input placeholder="pseudo" onChange={e=>pseudo[1](e.target.value)}/>
    <input type="password" placeholder="mdp" onChange={e=>pw[1](e.target.value)}/>
    <button onClick={handle}>Se connecter</button>
  </div>;
}