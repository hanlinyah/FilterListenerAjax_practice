//檢查username
var usernameInput=document.getElementById("username");
usernameInput.onblur=checkUsername;

function checkUsername(){

    var username=usernameInput.value.trim();
    registercheckusername(username);
    var reg=/^\w{6,12}$/;
    var flag=reg.test(username);

    if(flag){
        document.getElementById("username_err").style.display="none";
    }else {
        document.getElementById("username_err").style.display="";
    }
    return flag;
}

//檢查password
var passwordInput=document.getElementById("password");
passwordInput.onblur=checkPassword;

function checkPassword(){
    var password=passwordInput.value;
    var reg=/^[\S\s]{6,12}$/;
    var flag=reg.test(password);
    if(flag){
        document.getElementById("password_err").style.display="none";
    }else {
        document.getElementById("password_err").style.display="";
    }
    return flag;
}


//提交表單
var regFrom=document.getElementById("reg-form");
regFrom.onsubmit=submitForm;
function submitForm(){
    var flag=!!(checkUsername() * checkPassword() );
    return flag;
}

var verifyCodeImg=document.getElementById("verifyCodeImg");
var changeVerifyCodeImg=document.getElementById("changeVerifyCodeImg");
changeVerifyCodeImg.onclick=changeCode;
function changeCode(){
    verifyCodeImg.src="./verifyCode?"+new Date().getMilliseconds();
}

//ajax獲取用戶名稱是否重複
// function registercheckusername(username){
//     var xhttp;
//     if(window.XMLHttpRequest){
//         xhttp=new XMLHttpRequest();
//     }else{
//         xhttp=new ActiveXObject("Microsoft.XMLHTTP");
//     }
//
//
//     xhttp.open("GET","http://localhost:8080/FilterListenerAjax_practice_war/User/registerCheckNameServlet?username="+username);
//     xhttp.send();
//
//     xhttp.onreadystatechange=function (){
//         if(this.readyState===4 && this.status===200){
//             document.getElementById("username_repeat").innerText=this.responseText;
//         }
//     }
// }

//使用axios進行簡化
function registercheckusername(username){
    //GET方法
    // axios({
    //     method:"get",
    //     url:"http://localhost:8080/FilterListenerAjax_practice_war/User/registerCheckNameServlet?username="+username
    // }).then(
    //     function (resp){
    //         document.getElementById("username_repeat").innerText=resp.data;
    //     }
    // )

    //POST方法
    axios({
        method:"post",
        url:"http://localhost:8080/FilterListenerAjax_practice_war/User/registerCheckNameServlet",
        data:"username="+username
    }).then(
        function (resp){
            document.getElementById("username_repeat").innerText=resp.data;
        }
    )

    //別名GET方法
    // axios.get("http://localhost:8080/FilterListenerAjax_practice_war/User/registerCheckNameServlet?username="+username).then(
    //     function (resp){
    //         document.getElementById("username_repeat").innerText=resp.data;
    //     }
    // )

    //別名POST方法
    // axios.post("http://localhost:8080/FilterListenerAjax_practice_war/User/registerCheckNameServlet","username="+username).then(
    //     function (resp){
    //         document.getElementById("username_repeat").innerText=resp.data;
    //     }
    // )

}