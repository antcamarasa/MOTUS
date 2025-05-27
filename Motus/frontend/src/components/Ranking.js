import React,{useState,useEffect} from 'react';import api from '../api';
export default function Ranking({token}){
  const [list,setList]=useState([]);
  useEffect(()=>{
    api.get('/ranking',{headers:{Authorization:token}})
      .then(r=>setList(r.data));
  },[]);
  return <div><h3>Classement</h3>
    <ul>{list.map(s=><li key={s.id}>{s.user.pseudo}: {s.score}</li>)}</ul>
  </div>;
}