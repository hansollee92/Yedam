// fs_read.js

const fs = require("fs");

// 비동기(non블로킹) 방식의 파일읽기
fs.readFile("./stdout1.log", "utf8", (err, buf) => {
  //callback함수 (callback -> 나중에 부르겠다, 비동기방식)
  if (err) {
    console.error(err);
    return;
  }
  console.log(buf);
});

console.log("뭔가 다른코드~");

// 동기방식(블로킹)인 파일읽기
let errBuf = fs.readFileSync("./stderr.log", "utf8");
console.log(errBuf);
