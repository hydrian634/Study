window.addEventListener("load", function(){
    let listSection = document.querySelector(".listSection");
	let deleteBtn = listSection.querySelector(".deleteBox");
    
    
    deleteBtn.onclick = function(e){
        e.preventDefault();
        console.log("delBtn");
        let deleteValue = deleteBtn.value;
        console.log(deleteValue);
        
        let request = new XMLHttpRequest();
        request.open("DELETE", `admin/api/users/${id}`, true);
        request.send();
        request.onload = function(){
            console.log(request.responseText);
        }
        
        
        
        /*let response = await fetch(`http://localhost:8000/user/edit/{id}`, true);
        let user = await response.json();
        
        let promise = new Promise(resolve=>{
			resolve(user);
		});*/

    }

})