// url_exe.js

const urlInfo =
  "https://username:pass@test.example.com:8080/prod/computer/pageInfo?page=3&pcode=ABC#hash";
const myUrl = new URL(urlInfo);

console.log(myUrl.href);
console.log(myUrl.origin); //프로토콜정보와 서버, 포트정보까지 보여주는 것은 origin
// 이런것들을 이렇게 분해해서 내가 원하는 정보를 볼 수가 있다. (p92)

console.log(myUrl.searchParams); //파라미터
console.log(myUrl.searchParams.get("page")); //파라미터 중 page를 읽어올려면
console.log(myUrl.searchParams.get("pcode")); //파라미터 중 pcode를 읽어올려면
console.log(myUrl.searchParams.keys());
console.log(myUrl.searchParams.values());
