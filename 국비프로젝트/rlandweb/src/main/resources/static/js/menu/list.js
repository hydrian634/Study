window.addEventListener("load", function () {
  let categoryFilterSection = document.querySelector(".category-filter");
  let categoryUL = categoryFilterSection.querySelector("ul");
  //get요청 막고 뭘 실행?

  let formSection = document.querySelector(".query-filter");
  let findButton = formSection.querySelector(".btn-find")
  let inputQuery = formSection.querySelector(".input-query");

  let content = document.querySelector(".menu-card-list .content");

  // let clickIcon = document.querySelector(".menu-card");
  // let clickHeart = clickIcon.querySelectorAll(".icon-heart");

 //------------카테고리 클릭----------------
  //첫번 째 li 자식의 a의 객체 대입
  let currentCategory = categoryUL.querySelector("li:first-child a");

  content.onclick = (e)=>{
    e.preventDefault();

    let el = e.target;
    //btn-like가 아니면 return시켜라
    if(!el.classList.contains("btn-like")) //해당 클래스에 btn-like가 없다면~
      return;
  // /api/likes/3
    console.log("heart");
  }

  function bind(list){
    // let list = JSON.parse(json);

    content.innerHTML = "";

    for(let m of list){
      let iconHeart = m.isLike?"icon-heart-fill" : "icon-heart";
      let template = `<section class="menu-card">
<h1>
<a class="heading-3" href="detail.html" >${m.korName}</a></h1>
<h2 class="heading-2 font-weight:normal color:base-5">${m.engName}</h2>
<div class="price-block d:flex align-items:flex-end"><span class="font-weight:bold">${m.price}</span>원<span class="soldout-msg ml:auto mr:auto md:d:none">SOLD OUT</span></div>
<div class="img-block">
<a href="detail?id=${m.id}"><img src="/image/menu/product/${m.img}"></a>
</div>
<div class="like-block d:flex justify-content:flex-end">
<a class="icon icon-color:base-4 ${iconHeart}" href="" ></a>
<span class="font-weight:bold ml:1">${m.likeCount}</span>
</div>
<div class="pay-block d:flex">
<a class="icon md:icon:none icon-cart icon-color:base-0 color:base-0 btn-type:icon btn-cart md:btn-type:text" href="">담기</a>
<a class="icon md:icon:none icon-card icon-color:base-0 color:base-0 btn-type:icon btn-card md:btn-type:text" href="">주문하기</a>
</div>
</section>`;

      content.insertAdjacentHTML("beforeend",template); //얘는 기존에 있던 것에 추가함?
      // content.innerHTML=template; //얘는 기존에 있던걸 지우고 다시 그리는 것.
    }
  } //bind 끝
  //async로 비동기로 만들면서 지역화까지.
  //따라서 해당 지역의 변수를 다 쓸 수 있음.
  categoryUL.onclick = async function (e) {
    e.preventDefault(); //get요청 막아서 페이지 새로고침 되는 것을 막음.

    let el = e.target;

    //DOM강의에 있음. 근데 target으로 대상을 지정? 해줘야 함?
    if (el.tagName !== "A")
      return;
    console.log(el.dataset.id);

    //class=className
    //원리 : class에 current라는 클래스를 넣는 것.
    currentCategory.classList.remove("current");
    el.classList.add("current");
    currentCategory = el;

    let response = await fetch(`/api/menus?c=${el.dataset.id}`);
    if(el.dataset.id === undefined)
      response = await fetch(`/api/menus?`);
    let json = await response.json();
    bind(json);

  //   let request = new XMLHttpRequest();
  //
  //   let url=`/api/menus?c=${el.dataset.id}`;
  //   if(el.dataset.id === undefined){
  //     url = `/api/menus?`;
  //   }
  //
  //   //html에서 기본값을 없애는 방법도 있음
  //
  //   // /api/menus?c=
  //   request.open("GET", url, true);
  //   request.onload=function() {
  //     bind(request.responseText);
  //   }
  //   request.send();
  // };
  };


  // ------------------검색------------------
  findButton.onclick = async function (e) {
    e.preventDefault();

    let query = inputQuery.value;
    // let request = new XMLHttpRequest();
    // //request.open
    // //인자는 ("요청하는 방식", "요청할 주소", 비동기 방식에 대한 참/거짓)
    //
    // request.open("GET", `/api/menus?q=${query}`,true);
    //
    // request.onload=function(){
    //   bind(request.responseText);
    // };
    // request.send();
      // console.log("watame");

    let response = await fetch(`/api/menus?q=${query}`);
    let json = await response.json();
    bind(json);

  };

  //---------------------------------------

});

