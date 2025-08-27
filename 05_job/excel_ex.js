// excel.js

const xlsx = require("xlsx");

const workbook = xlsx.readFile("./logs/sample.xlsx");
//console.log(workbook.SheetNames);    [ '시트1' ]
//console.log(workbook.SheetNames[0]); // 시트1
const firstSheetName = workbook.SheetNames[0];

const firstSheet = workbook.Sheets[firstSheetName];
console.log(firstSheet["A2"].v); //1

// 데이터 수정
firstSheet["B2"].v = "HongKildong";

// 데이터 넣기 (ws["A3"].v 이렇게 접근시 에러 / 새로운 값 넣을시 워크시트 범위지정 필요)
firstSheet["A3"] = { t: "n", v: "2" };
firstSheet["B3"] = { t: "s", v: "김문어" };
firstSheet["C3"] = { t: "s", v: "mune1004@mail.com" };
firstSheet["D3"] = { t: "s", v: "010-1004-1004" };
firstSheet["E3"] = { t: "s", v: "니마음속" };

// 워크시트 범위 갱신
firstSheet["!ref"] = "A1:E3";

// 저장
xlsx.writeFile(workbook, "./logs/write.xlsx");
