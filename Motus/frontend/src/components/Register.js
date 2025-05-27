import React,{useState} from 'react';import api from '../api';
export default function Register({setToken}){
  const [pseudo,pw]=[...Array(2)].map(()=>useState(''));
  const handle=async()=>{await api.post('/auth/register',{pseudo:pseudo[0],password:pw[0]});}
  return <div><h3>Inscription</h3>
    <input placeholder="pseudo" onChange={e=>pseudo[1](e.target.value)}/>
    <input type="password" placeholder="mdp" onChange={e=>pw[1](e.target.value)}/>
    <button onClick={handle}>S'inscrire</button>
  </div>;
}