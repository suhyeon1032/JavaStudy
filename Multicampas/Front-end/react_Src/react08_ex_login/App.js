import './App.css';

import Login from './member/Login';

function App() {
  //  background-color
  //  document.getElementById("a").style.backgroundColor="red"
  const loginStyle = {
    height:'100px',
    backgroundColor:'#04a',
    fontSize:'3em',
    textAlign:'center',
    color:'#fff',
    lineHeight:'100px'
    }
  return (
    <div>
      <div style={loginStyle}>리액트로 만든 로그인</div>
      {<Login/>}
    </div>
  );
}

export default App;