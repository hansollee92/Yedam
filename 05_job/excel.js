// excel.js

const xlsx = require("xlsx");
const sql = require("./sql"); //04_mysql 복사함

// db 조회 후 -> 엑셀파일
async function db_to_excel() {
  // 구조 : workbook > sheet > cell
  // 구조가 위와 같기 때문에 바로 xlsx.utils.json_to_sheet를 만들수 없고 workbook을 만들어야지 sheet를 작성할 수 있음
  const workbook = xlsx.utils.book_new(); // workbook 생성

  let resultSet = await sql.execute("select * from customers");
  console.log(resultSet); // [{}, {}, {}, ... ,{}] 형태로 가져옴
  // 배열 => sheet 변경 (json_to_sheet() 함수 이용)
  const firstSheet = xlsx.utils.json_to_sheet(resultSet, {
    header: ["id", "name", "email", "address"], //매개변수로 header정보가 들어감
  });

  // sheet → workbook → customers.xlsx
  xlsx.utils.book_append_sheet(workbook, firstSheet, "Customers"); //만들어진 sheet를 workbook에 넣음 (시트생성)
  xlsx.writeFile(workbook, "./logs/customers.xlsx"); //저장 (엑셀파일 생성)
}
db_to_excel();

console.log("✅ 파일 저장 완료");

// 엑셀파일 -> db
function excel_to_db() {
  const workbook = xlsx.readFile("./logs/write2.xlsx");
  const firstSheetName = workbook.SheetNames[0];
  const firstSheet = workbook.Sheets[firstSheetName];

  let jsonSheet = xlsx.utils.sheet_to_json(firstSheet); //json 형태로 변경해줌
  console.log(jsonSheet);
  jsonSheet.forEach(async (customer) => {
    let result = await sql.execute("insert into customers set ?", customer);
    console.log(result);
  });
}
