//클래스네임 아예 없애지 않고 구현하기
const h1 = document.querySelector(".onlycss h1");

function handleTitleClick() {
    const clickedClass = "clicked";

    if(h1.classList.contains(clickedClass)) {
        h1.classList.remove(clickedClass);
    } else {
        h1.classList.add(clickedClass);
    }
}
h1.addEventListener("click", handleTitleClick);
//실행 시, 여기까지 (13번라인) 주석처리 해야함


//토글 함수를 이용해 간단하게 구현하기
const h1 = document.querySelector(".onlycss h1");

function handleTitleClick() {
    h1.classList.toggle("clicked");
}

h1.addEventListener("click", handleTitleClick);

