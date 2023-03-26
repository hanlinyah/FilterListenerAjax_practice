var button=document.getElementById("ajaxDemo01Gettime");
button.onclick=function (){
    var xhttp;
    if(window.XMLHttpRequest){
        xhttp=new XMLHttpRequest();
    }else{
        xhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }


    xhttp.open("GET","http://localhost:8080/FilterListenerAjax_practice_war/ServletAjaxDemo01");
    xhttp.send();

    xhttp.onreadystatechange=function (){
        if(this.readyState===4 && this.status===200){
            document.getElementById("ajaxDemo01Text").value=this.responseText;
            // alert(this.responseText);
        }
    }
}

