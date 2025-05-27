import React,{useState} from 'react';import api from '../api';
export default function Game({token}){
  const [guess,setGuess]=useState('');
  const [rows,setRows]=useState([]);
  const handleStart=async()=>{
    const m=await api.post('/game/start?longueur=5&difficulte=facile',{},
      {headers:{Authorization:token}});
    setRows([ [m.data.word] ]);
  };
  const handlePlay=async()=>{
    const res=await api.post(`/game/play?guess=${guess}`,{},
      {headers:{Authorization:token}});
    setRows(r=>[...r,res.data]);
  };
  return <div>
    <button onClick={handleStart}>Start</button>
    <div>{rows.map((r,i)=><div key={i}>{r.map((c,j)=><span key={j} style={{padding:'5px'}}>{c}</span>)}</div>)}</div>
    <input onChange={e=>setGuess(e.target.value)}/><button onClick={handlePlay}>Jouer</button>
  </div>;
}