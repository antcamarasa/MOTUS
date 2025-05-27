import React, {useState} from 'react';
import Login from './components/Login';
import Register from './components/Register';
import Game from './components/Game';
import Ranking from './components/Ranking';

export default function App(){
  const [token,setToken]=useState(null);
  if(!token) return <><Register setToken={setToken}/><Login setToken={setToken}/></>;
  return <><Game token={token}/><Ranking token={token}/></>;
}