//[].reduce().

//문제
//[10, 20, 30] 으로 최종결과값을 만들고 싶다.
//힌트: elem % 2 == 0 (짝수)
let result = [10, 15, 20, 25, 30].reduce((acc, elem) => {
  console.log(acc, elem);
  if (elem % 2 == 0) {
    acc.push(elem);
  }
  return acc; //return을 위에 적으면 에러~
}, []); //[].push(10) 하면 추가됨
console.log(result);
