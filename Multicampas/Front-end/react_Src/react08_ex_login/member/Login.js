//외부파일을 스타일 적용시 import
import './loginStyle.css';

//  usestate사용시 importt
import React, {useState} from 'react';

function Login(){
    const divHeight = {
        height:'20px',
        color:'#f00'
    }

    //  아이디 유효성 검사 결과를 저장할 hook변수
    const [logIdErrorMessage, setLogIDErrorMessage] = useState('');
    //  비밀번호 유효성 검사 결과를 저장할 hook변수
    const [logPwdErrorMessage, setLogPwdErrorMessage] = useState('');
    
    //  form의 데이터(아이디, 비밀번호)를 담은 hook변수
    const [logFormData, setLogFormData] = useState({
        userid:'',
        userpwd:''

    });

    //  아이디와 비밀번호의 입력변경이 있을 경우, hook의 값을 바꿀 함수
    //                      방금 이벤트가 발생한 객체
    const loginDataChange = (event)=>{
        //  기존의 에러메세지 지우기
        setLogIDErrorMessage('');
        setLogPwdErrorMessage('');

        //  이벤트가 발생한 객체에서 name 속성의 값 가져오기
        const name = event.target.name; //  userid, userpwd   -> key로 사용
        const value = event.target.value; //    입력데이터     -> value로 사용
        //                         name의 문자 []내에 표기하여 key사용
        setLogFormData(logValue=>({...logValue, [name]:value}));
        console.log(logFormData);
    }
    
    //  폼이 submit이 발생하면 유효성 검사하기
    const loginSubmit = (event)=>{
        //  form의 기본 이벤트를 해제... action에 표기한 곳으로 이동하는 것을 막는다.
        event.preventDefault();

        //   아이디 입력 유무 확인
        if(logFormData.userid == ''){
            setLogIDErrorMessage("아이디를 입력하세요.")
            return false;
        }

        //  아이디-정규식표현 유효성 검사하기
        //  아이디 : 영대소문자, _, 6~12까지허용
        const useridReg = /^[a-zA-Z0-9_]{6,12}$/;   //  /^\w[6,12]$/ 
        if(!useridReg.test(logFormData.userid)){
            setLogIDErrorMessage("영대소문자 , _ , 글자수는 6~12자까지 가능합니다.");
            return false;
        }

        //  비밀번호 입력 유무 확인
        if(logFormData.userpwd ==''){
            setLogPwdErrorMessage("비밀번호를 입력하세요.")
            return false;
        }

        //  백엔드.....
    
    }

    return(
        <div className="loginFormCenter">
            <h1 className="txtCenter">로그인</h1>
            <form onSubmit = {loginSubmit}>
                <div className="form-group">
                    <label>아이디</label>
                    <input type="text" name="userid" id="userid" placeholder="아이디 입력" 
                            className='form-control' onChange={loginDataChange}/>
                    <div style={divHeight}>{logIdErrorMessage}</div>
                </div>
                <div className="form-group">
                    <label>비밀번호</label>
                    <input type="password" name="userpwd" id="userpwd" placeholder="비밀번호 입력" 
                            className='form-control' onChange={loginDataChange}/>
                    <div style={divHeight}>{logPwdErrorMessage}</div>
                </div>
                <input type="submit" value="로그인" className="form-control btn btn-secondary"/>
            </form>


        </div>
    );
}

export default Login;