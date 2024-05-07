window.onload = function() {
  // document.querySelector('#btn_create').addEventListener('click', () => {
  //   console.log('-> event 등록');
  // })

  // document.querySelector('#btn_create').addEventListener('click', create);
  // document.querySelector('#btn_create').addEventListener('click', create());
  // document.querySelector('#btn_create').addEventListener('click', () => create());
  document.getElementById('btn_create').addEventListener('click', () => create());

  // document.querySelector('#add').addEventListener('onkeydown', create_enter); // X
  // document.querySelector('#add').addEventListener('keydown', create_enter); // 마지막 문자가 인식안됨
  // document.querySelector('#add').addEventListener('input', create_enter); // 마지막 문자 인식됨.
  // document.querySelector('#add').addEventListener('input', (event) => {create_enter(event)}); // X
  // document.querySelector('#add').addEventListener('keypress', (event) => {create_enter(event)}); // 권장
  document.getElementById('add').addEventListener('keypress', (event) => {create_enter(event)}); // 권장
}

const create = () => {
  let add_tag = document.getElementById('add');
  const text = add_tag.value;
  console.log('-> add_tag: ' + text);
  
  const li = document.createElement('li');
  const div = document.createElement('div');
  const divText = document.createElement('div'); // 글 내용
  divText.textContent = text;
  
  div.appendChild(divText); // 글
  li.appendChild(div);
  document.getElementById('memo_list').appendChild(li);
  
  // 삭제버튼 생성
  const button = document.createElement('button');
  button.textContent = '삭제';
  button.style.height = '20px';
  button.style.paddingTop = '0px';
  button.style.paddingBottom = '0px';
  button.setAttribute("class", "btn btn-secondary btn-sm");
  // 삭제 기능
  button.addEventListener('click', ( ) => {
    // 현재 태그로부터 가장 가까운 부모 태그 검색
    const delete_target = button.closest('li');
    console.log(delete_target);
    document.getElementById('memo_list').removeChild(delete_target);
  });
  div.appendChild(button); // 삭제 버튼 추가
  
}

 // Enter 입력시 등록
const create_enter = (event) => {
  // console.log(document.querySelector('#add').textContent); // div, span, X
  // console.log(document.querySelector('#add').value); // input tag 값
  console.log('-> ' + event.key); // ASCII code

  if (event.key == 'Enter') {
    create();
  }
}