// fs_watch.js

const fs = require("fs");
const path = require("path");
let sql = require("./sql.js");

fs.watchFile(__dirname + "/sql.js", () => {
  console.log("재시작 없이 반영");
  delete require.cache[require.resolve("./sql.js")]; //캐시에 저장되고 있는 파일 삭제
  sql = require("./sql.js"); //sql.js 파일에 변경이 일어날때마다 sql.js 재할당
});

// 이렇게 watchFile을 사용해도 되고 nodemon? nodenoon? 을 사용해도 된다.
