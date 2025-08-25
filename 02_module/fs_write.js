// fs_write.js

const fs = require("fs");

/* 문제 : fs.readFile / fs.readFileSync 활용해서 stdout.log 정보를 읽어들이고
          읽으들인 값을 "\n안녕하세요2\n"에 값이 들어갈 수 있도록 해봐라. 
          */

//let logBuf = fs.readFileSync("./stdout.log", "utf8");

fs.readFile("./stdout.log", "utf8", (err, buf) => {
  //callback함수 (callback -> 나중에 부르겠다, 비동기방식)
  if (err) {
    console.error(err);
    return;
  }
  console.log(buf);

  // 비동기
  fs.writeFile(
    "./file_write.txt",
    buf,
    { encoding: "utf8", flag: "a" },
    (err) => {
      if (err) {
        console.log("예외발생");
        return;
      }
      console.log("비동기적 파일 쓰기 완료");
    }
  );
});

// 동기
// fs.writeFileSync("./file_write.txt", "동기적 파일 작성예시", {
//   encoding: "utf8",
//   flag: "a",
// });
// console.log("동기적 파일 쓰기 완료");
