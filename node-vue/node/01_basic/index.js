let name = "이한솔";
let score = 80;
console.log("이름은 " + name + ", 점수는 " + score);
console.log(
  `이름은 ${name}, 점수는 ${score} 합격여부는 ${score > 60 ? "합격" : "불합격"}`
);

//변수 var, let, const

for (let i = 1; i <= 5; i++) {
  if (i % 2) {
    // falsy : 0, null, "", undefined
    let name = "kim"; //{} 안에서만 유효한 값을 유지함
  }
  console.log(name);
}
