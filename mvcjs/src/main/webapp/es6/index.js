console.log('import complete.');

let title1 = document.getElementById('title');
console.log(title1);
console.log(title1.textContent);

let title2 = document.querySelector('#title');
console.log(title2);
console.log(title2.textContent);

// class가 여러개인 경우 대응하는 첫 번째 태그만 추출
console.log('----------------------');
let container1 = document.querySelector('.container');
console.log(container1);
console.log(container1.textContent);

// class가 여러개인 경우 배열 발생
let container2 = document.querySelectorAll('.container');
console.log(container2);
console.log(container2.textContent); // undefined

// 배열 태그에 대해 요소로 접근
console.log(container2[0].textContent);
console.log(container2[1].textContent);
console.log(container2[2].textContent);

// DOM API 이용한 태그 생성
// prepend: 태그의 가장 앞 부분에 추가.
let img = document.createElement('img');
img.src = "./images/720.jpg";
img.width = 180;
img.height = 130;
img.style.margin = '10px'; // CSS
container2[1].prepend(img); // container 태그의 2번째 요소의 가장 앞 부분에 추가함.

img = document.createElement('img');
img.src = "./images/741.jpg";
img.width = 180;
img.height = 130;
img.style.marginLeft = '10px'; // CSS
container2[1].prepend(img); // container 태그의 2번째 요소의 가장 앞 부분에 추가함.

// appendChild: 태그의 가장 앞 부분에 추가.
const div1 = document.createElement('div');
img = document.createElement('img');
img.src = "./images/4993.jpg";
img.width = 180;
img.height = 130;
img.style.marginLeft = '100px'; // CSS
div1.appendChild(img); // div1 태그의 가장 마지막 자식 태그로 붙임.
const body = document.querySelector('body');
body.appendChild(div1);

// button 생성
let btn = document.createElement('button');
btn.textContent = '벚꽃 여행';
btn.style.marginTop = '10px';
btn.style.marginLeft = '100px';
btn.setAttribute("class", "btn btn-secondary btn-sm");
// 클릭 기능
btn.addEventListener('click', ( ) => {
  container2[2].textContent = '축제 참가';
});
body.appendChild(btn);

// button 생성
btn = document.createElement('button'); // 새롭게 메모리 할당, 다른 버튼임.
btn.textContent = '기본값';
btn.style.marginTop = '10px';
btn.style.marginLeft = '10px';
btn.setAttribute("class", "btn btn-secondary btn-sm");
// 클릭 기능
btn.addEventListener('click', ( ) => {
  container2[2].textContent = '영역2 입니다.';
});
body.appendChild(btn);