var insertupdatestatus=0;
    // 0 非新增 非修改
    // 1 新增
    // 2 修改
var newbrand=document.getElementById("newbrand");
var editdata=document.getElementById("editdata");
var submitBrand=document.getElementById("submitBrand");
var cancleedit=document.getElementById("cancleedit");
var edittypetitle=document.getElementById("edittypetitle");
window.onload=showalldata;

newbrand.onclick=function (){
    // location.href="./insertNewBrand.jsp"
    editdata.style.display="";
    insertupdatestatus=1;
    edittypetitle.innerHTML="新增數據";
}


cancleedit.onclick=function (){
    clearedit.click();
    editdata.style.display="none";
    insertupdatestatus=0;
    edittypetitle.innerHTML="";

}



function showalldata(){

    axios.get("http://localhost:8080/FilterListenerAjax_practice_war/Brand/selectAllServlet").then(
        function (resp){
            let brands=resp.data;
            let tableData="<tr>\n"+
         "      <th>序號</th>\n"+
         "      <th>品牌名稱</th>\n"+
         "      <th>企業名稱</th>\n"+
         "      <th>訂單</th>\n"+
         "      <th>品牌介紹</th>\n"+
         "      <th>狀態</th>\n"+
         "      <th>操作</th>\n"+
         "  </tr>\n";

            for (i=0;i<brands.length;i++){

                tableData+=             "\n"+
                    "<tr align=\"center\">\n"+
                       " <td>"+  (i+1)  +     "</td>\n"+
                       " <td>"+  brands[i].brandName  +     "</td>\n"+
                       " <td>"+  brands[i].companyName  +     "</td>\n"+
                       " <td>"+  brands[i].ordered  +     "</td>\n"+
                       " <td>"+  brands[i].description  +     "</td>\n"+
                    " <td>"+ (brands[i].status==1?"啟用":"禁用")+    "</td>\n"+

                       "<td><input type=\"button\" value=\"修改\"  name=\"Update\" id=\"UpdateId_"+brands[i].id+
                    "\" onClick=\"Updatedata(this.id)\"> " +
                    "<input type=\"button\" value=\"刪除\"  name=\"Delete\" id=\"DeleteId_"+brands[i].id+
                    "\" onClick=\"DeleteData(this.id)\"></td>\n" +
                    "</tr>";
            }
            document.getElementById("brandtable").innerHTML=tableData;
        }
    )
}

function DeleteData(clicked_id)
{
    let id=parseInt(clicked_id.toString().substring(9));
    axios.post("http://localhost:8080/FilterListenerAjax_practice_war/Brand/DeleteByIdServlet",id).then(
        function (resp){
            if(resp.data=="success"){
                alert("刪除成功");
                showalldata();
            }
        }
    )
}

function Updatedata(clicked_id)
{
    insertupdatestatus=2;
    edittypetitle.innerHTML="修改數據";
    let id=parseInt(clicked_id.toString().substring(9));
    axios.post("http://localhost:8080/FilterListenerAjax_practice_war/Brand/selectByIdServlet",id).then(
        function (resp){
            let brand=resp.data;
            document.getElementById("id").value=brand.id;
            document.getElementById("brandName").value=brand.brandName;
            document.getElementById("companyName").value=brand.companyName;
            document.getElementById("ordered").value=brand.ordered;
            document.getElementById("description").value=brand.description;
            let status_item=document.getElementsByName("status");
            for(i=0;i<status_item.length;i++){
                if(brand.status==i){
                    status_item[i].checked=true;
                }
            }
        }
    )
    editdata.style.display="";
}


submitBrand.onclick=function (){
        let id=document.getElementById("id").value;
        let brandName=document.getElementById("brandName").value.trim();
        let companyName=document.getElementById("companyName").value.trim();
        let ordered=document.getElementById("ordered").value.trim();
        let description=document.getElementById("description").value.trim();
        let status;
        let status_item=document.getElementsByName("status");
        for(i=0;i<status_item.length;i++){
            if(status_item[i].checked){
                status=i;
            }
        }
        let  brand={
            "id":id,
            "brandName":brandName,
            "companyName":companyName,
            "ordered":ordered,
            "description":description,
            "status":status
        }
    if(insertupdatestatus==1){
        brand.id=null;

        axios.post("http://localhost:8080/FilterListenerAjax_practice_war/Brand/InsertServlet",brand).then(
            function (resp){
                if(resp.data=="success"){
                    alert("新增成功");
                    clearedit.click();
                    showalldata();
                }
            }
        )
    }
    if (insertupdatestatus==2){
        axios.post("http://localhost:8080/FilterListenerAjax_practice_war/Brand/UpdateServlet",brand).then(
            function (resp){
                if(resp.data=="success"){
                    alert("修改成功");
                    clearedit.click();
                    showalldata();
                }
            }
        )
    }

}





