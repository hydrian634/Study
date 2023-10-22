window.addEventListener("load", function(){
    let edit = document.querySelector(".edit");
    let idQuery = edit.querySelector(".id")
    let editBtn = edit.querySelector(".store-edit-button");
 	let inputAlias = document.getElementById("alias");
 	let inputEmail = document.getElementById("email");
 	let inputPwd = document.getElementById("pwd");
    
    editBtn.onclick = async function(e){
		e.preventDefault();
		
        let id = idQuery.value;
  		let aliasValue = inputAlias.value;
  		let emailValue = inputEmail.value;
  		let pwdValue = inputPwd.value;
  		
        console.log("test");
        console.log(id);	
   	 	console.log(inputAlias);
    	console.log(aliasValue);
  		
	  	let data = { id : id, 
			  		 alias : aliasValue,
			  		 email : emailValue,
			  		 pwd : inputPwd
			  		 };
	  	let url = `/admin/api/users/${id}`;
	  	
	  	let response = await fetch(url, {
			method: "PUT",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(data)
			
	  	});
			console.log(response);
			
  	}	

})