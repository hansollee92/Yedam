//setInterval.js

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// count: 100 -> 0 될 때까지 1씩 감소 (1초에)
let count = 100;
let timer = setInterval(() => {
  count--;
  // console.log(`현재 count: ${count}`);
}, 1000);

let wordAry = "Lorem ipsum dolor sit amet" //
  .split(" ");

function myFunction() {
  if (count < 0) {
    clearInterval(timer);
    rl.close(); //stream close()
    return;
  }

  rl.question("삭제할 단어를 입력하세요.", (answer) => {
    let search = answer;
    let idx = wordAry.indexOf(search);
    wordAry.splice(idx, 1); //삭제

    wordAry.forEach((word) => {
      console.log(word);
    });
    myFunction(); //안에서 한번 더 호출해야지 계속 실행됨
  });

  // 100이 완료되기전에 배열에 있는 값을 clear하면 성공.
  // 100이 완료된 후 배열에 값이 있으면 실패.
  if (wordAry.length == 0) {
    console.log("성공");
    clearInterval(timer);
    rl.close();
    return;
  } else if (count <= 0) {
    console.log("실패");

    clearInterval(timer);
    rl.close();
    return;
  }
}
myFunction();
