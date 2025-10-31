//학생 : 학번, 이름, 키, 몸무게 ...
//     : 먹는다, 잔다, 공부한다 ...

// 객체(인스턴스)
let std1 = {
  stdNo: 1234,
  stdName: "홍길동",
  height: 170,
  eat: function (food) {
    console.log(`${food}를 먹는다`);
  },
  sleep(hours) {
    console.log(`${hours}동안 잔다`);
  },
};

//객체 -> 설계도
class Student {
  //생성자
  constructor(stdNo, stdName, height) {
    this.stdNo = stdNo;
    this.stdName = stdName;
    this.height = height;
  }

  //메소드
  eat(food) {
    console.log(`${food}를 먹는다`);
  }
  sleep(hours) {
    console.log(`${hours}동안 잔다`);
  }
}

let std2 = new Student(1235, "김민수", 180);
let std3 = new Student(1236, "최민식", 160);

console.log(std1.stdNo, std1.stdName, std1.height);
console.log(std2.stdNo, std2.stdName, std2.height);
