function validateForm(){
    var name=document.getElementById("name").value;
    var email=document.getElementById("email").value;
    var phonenumber=document.getElementById("phonenumber").value;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const mobileRegex = /^\+?[0-9\s-]{10}$/;
    if(name==""){
        alert("Name is not given");
        return false;
    }
    if(email==""){
        alert("Email is not given");
        return false;
    }
    else if(!emailRegex.test(email)){
        alert("invalid email address");
        return false;
    }
    if(phonenumber==""){
        alert("Phone Number is not given");
        return false;
    }
    else if(!mobileRegex.test(phonenumber)){
        alert("Phone Number is invalid");
        return false;
    }
    return true;
    
}


function showData(){
    var empdata;
    if(localStorage.getItem("empdata")==null){
        empdata=[];
    }
    else{
        empdata=JSON.parse(localStorage.getItem("empdata"));
    }
    var html="";
    empdata.forEach(function(element,index){
        html+="<tr>";
        html+="<td>"+(index+1)+"</td>";
        html+="<td>"+element.name+"</td>";
        html+="<td>"+element.email+"</td>";
        html+="<td>"+element.phonenumber+"</td>";
        html+='<td><button onclick="deleteData('+index+')" class="btn btn-danger">Delete</button><button onclick="updateData('+index+')" class="btn btn-success">Update</button>';
        html+="</tr>";
    });
    document.querySelector("#crudTable tbody").innerHTML=html;
}
document.onload=showData();

function AddData(){
    if(validateForm()==true){
        var name=document.getElementById("name").value;
        var email=document.getElementById("email").value;
        var phonenumber=document.getElementById("phonenumber").value;

        var empdata;
        if(localStorage.getItem("empdata")==null){
        empdata=[];
        }
        else{
        empdata=JSON.parse(localStorage.getItem("empdata"));
        }

        empdata.push({
            name:name,
            email:email,
            phonenumber:phonenumber
        });

        localStorage.setItem("empdata", JSON.stringify(empdata));
        showData();
        document.getElementById("name").value="";
        document.getElementById("email").value="";
        document.getElementById("phonenumber").value="";

    }
}

function deleteData(index){
    var empdata;
    if(localStorage.getItem("empdata")==null){
        empdata=[];
    }
    else{
        empdata=JSON.parse(localStorage.getItem("empdata"));
    }
    empdata.splice(index,1);
    localStorage.setItem("empdata", JSON.stringify(empdata));
    showData();
}

function updateData(index){
    document.getElementById("submit").style.display="none";
    document.getElementById("update").style.display="block";

    var empdata;
    if(localStorage.getItem("empdata")==null){
        empdata=[];
    }
    else{
        empdata=JSON.parse(localStorage.getItem("empdata"));
    }
    document.getElementById("name").value=empdata[index].name;
    document.getElementById("email").value=empdata[index].email;
    document.getElementById("phonenumber").value=empdata[index].phonenumber;

    document.querySelector("#update").onclick=function(){
        if(validateForm()==true){
            empdata[index].name=document.getElementById("name").value;
            empdata[index].email=document.getElementById("email").value;
            empdata[index].phonenumber=document.getElementById("phonenumber").value;

            localStorage.setItem("empdata", JSON.stringify(empdata));
            showData();
        }
    }
}