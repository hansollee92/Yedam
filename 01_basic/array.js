//[].sort() : 배열 요소를 문자열로 변환해서 정렬한다.

//문자열
let fruits = ["apple", "cherry", "banana"];
fruits.sort();
fruits.forEach((fruit) => {
  console.log(fruit);
});

//숫자
let numbers = [1, 10, 100, 2, 12, 44];
// 내림차순으로 정렬하고 싶다면 a,b의 순서를 변경해주면 된다.
numbers.sort(function (a, b) {
  if (a > b) {
    return 1; //위치를 변경: 양의 값
  } else {
    return -1; //위치를 유지: 음의 값
  }
});
numbers.forEach((number) => {
  console.log(number);
});

// filter() : 배열 메소드에서 사용, 특정 조건을 만족하는 배열의 요소를 반환함
[10, 23, 46, 17, 56]
  .filter((elem, idx, ary) => {
    //익명함수,화살표함수
    //console.log(elem);
    if (elem > 30) {
      //30보다 큰값을 새로운 배열로 생성.
      return true;
    }
  })
  .forEach((elem) => {
    console.log(elem); //46, 56
  });

// 문제 :
// 배열의 형태가 아래와 같이 object 타입으로 변경이 되었는데,
// point가 30보다 큰 사람만 가져와서 새로운 배열을 생성해보아라.
[
  { name: "Hong", point: 10 },
  { name: "Kim", point: 23 },
  { name: "Park", point: 46 },
  { name: "Choi", point: 17 },
  { name: "Hwang", point: 56 },
]
  .filter((elem, idx, ary) => {
    if (elem.point > 30) {
      return true;
    }
  })
  .forEach((elem) => {
    console.log("이름: " + elem.name); //이름: Park, 이름:Hwang
  });
