console.log("hello world"); //일반적인 로그
console.log("hello %s", "world"); //일반적인 로그, %s를 사용하여 문자열 데이터를 파라미터로 전달

const world = "wrold";
console.log(`hello ${world}`); //자바스크립트의 템플릿 리터럴 문법을 사용

console.error(new Error(`에러 메시지 출력`)); //에러 로그 출력

const arr = [
  { name: "John Doe", email: "john@mail.com" },
  { name: "Jeremy Go", email: "jeremy@mail.com" },
];
console.table(arr); //테이블 형태로 배열/오브젝트 데이터 출력
const obj = {
  student: {
    grade1: {
      classA: {
        student1: {
          name: "Alice",
          age: 10,
          scores: { math: 95, english: 88, science: 92 },
        },
        student2: {
          name: "Bob",
          age: 11,
          scores: { math: 82, english: 91, science: 87 },
        },
      },
      classB: {
        student1: {
          name: "Charlie",
          age: 10,
          scores: { math: 76, english: 84, science: 80 },
        },
        student2: {
          name: "Daisy",
          age: 11,
          scores: { math: 90, english: 85, science: 93 },
        },
      },
    },
    grade2: {
      classA: {
        student1: {
          name: "Ethan",
          age: 12,
          scores: { math: 88, english: 79, science: 91 },
        },
        student2: {
          name: "Fiona",
          age: 12,
          scores: { math: 94, english: 95, science: 97 },
        },
      },
      classB: {
        student1: {
          name: "George",
          age: 13,
          scores: { math: 70, english: 72, science: 68 },
        },
        student2: {
          name: "Hannah",
          age: 13,
          scores: { math: 85, english: 90, science: 89 },
        },
      },
    },
    teachers: ["John Doe", "Jeremy Go"],
  },
};

console.dir(obj, { depth: 5, colors: true }); // 오브젝트를 콘솔에 출력하는데, 출력할 오브젝트의 깊이와 콘솔 메세지 텍스트에 색상을 적용

console.time("time for for-loop"); //console.time에 파라미터로 전달한 레이블과 뒤에 나오는 console.timeEnd 중 일치하는 레이블을 가지고 있는 console.timeEnd코드 사이의 실행시간 측정
for (let i = 0; i < 999999; i++) {
  console.timeEnd("time for for-loop"); //앞에 나온 console.time 중 console.timeEnd와 레이블이 일치하는 코드 사이의 실행 시간 측정
}
