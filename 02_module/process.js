// process_exe.js

const path = require("path");

console.log(__filename); //현재 실행 중인 파일의 전체 절대 경로(Full path), .js까지 나타남
console.log(__dirname); //현재 실행 중인 파일이 들어있는 디렉터리(폴더)의 절대 경로

// path.basename : 경로의 마지막 부분을 반환
console.log(path.basename(__filename)); //process.js
console.log(path.basename(__dirname)); //02_module

// path.dirname : 파일이 위치한 폴더경로를 반환
// path.extname : 파일의 확장자 반환

// path.format : 객체를 받아서 경로 문자열로 만들어주는 함수로,
//               pathObject에는 dir, root, base, name, ext 프로퍼티가 있고 이것을 이용해 경로 문자열로 반환할 수 있다.
let result = path.format({ dir: "C:/Users/admin", base: ".gitconfig" }); //분해해서 나타내기
result = path.parse("C:/Users/admin/.gitconfig"); //객체형태로 나타내기
console.log(result);
