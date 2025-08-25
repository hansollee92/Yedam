// console_class.js

const { Console } = require("console"); // Console 객체 가져오기위해 console 모듈 사용
const fs = require("fs"); // fs : 파일시스템 모듈로 파일 읽기, 쓰기 등을 할 수 있는 내장 모듈
const { defaultNum } = require("./helloworld"); // 상수 12

const output = fs.createWriteStream("./stdout.log"); //파일쓰기가 가능하도록 스트림 생성
const errput = fs.createWriteStream("./stderr.log"); // stdout.log, stderr.log 파일을 만들어서 이것을 output, errput 변수에 담아둔것

const logger = new Console({ stdout: output, stderr: errput }); //콘솔객체 생성, stdout은 output에 / stderr은 errput에
// log내용들이 너무 길거나 사라질 수 있으니 그 로그들을 파일에다 계속 파일에다 저장하고자 위와 같은 작업을 하고 있다.
logger.log("디폴트값: %d", defaultNum);
logger.error("에러가 발생했습니다.");

for (let i = 0; i < 10; i++) {
  logger.log(`i의 값은 ${i}`); // => 파일에 작성
  console.log(`i의 값은 ${i}`); // => 콘솔에 출력
}
