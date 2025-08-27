// excel.js

const xlsx = require("xlsx");
const sql = require("./sql"); //04_mysql 복사함

// db 조회 후 -> 엑셀파일
async function db_to_excel() {
  const workbook = xlsx.utils.book_new();

  let resultSet = await sql.execute("select * from customers");
  console.log(resultSet);
  const firstSheet = xlsx.utils.json_to_sheet(resultSet, {
    header: ["id", "name", "email", "address"],
  });

  // sheet → workbook → customers.xlsx
  xlsx.utils.book_append_sheet(workbook, firstSheet, "Customers");
  xlsx.writeFile(workbook, "./logs/customer2.xlsx");
}
//db_to_excel();
//console.log("✅ 파일 저장 완료");

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

module.exports = {
  db_to_excel,
  excel_to_db,
};
