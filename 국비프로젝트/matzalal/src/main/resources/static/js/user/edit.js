window.addEventListener("load", function(){
    let edit = document.querySelector(".user-info-edit");
    let checkNickname = edit.querySelector(".nickname-check");
    let inputNickname = edit.querySelector("input[name=nickname]");
    let checkPwd = edit.querySelector(".pwd-check");

    checkNickname.onclick = function(e){
        e.preventDefault();

        let nickname = inputNickname.value;
        console.log(nickname);
        let pwd = checkPwd.value;
        console.log("pwd : " + pwd);
        // 1. 닉네임 있는지 확인 , 있으면 리턴, 없으면 변경 O

        // 1.1 api로 보낸다
        let request = new XMLHttpRequest();
        request.open("PUT", `/api/users?nickname=${nickname}&pwd=${pwd}`, true);
        request.send();
        request.onload = function(){
            alert(request.responseText);
        }

        // 1. 닉네임 있으면 있다고 알림표시 (classList)

        console.log(e.target.value);
    }

})