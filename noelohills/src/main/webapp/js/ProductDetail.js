let main_img = document.querySelector("#main_img");
let small_img = document.querySelector("#small_img");

for(let i=0; i<small_img.length; i++){
    small_img[i].addEventListener("click", showBig);
}

function showBig(){
    let newPic = this.src; 
    main_img.setAttribute("src", newPic);
}