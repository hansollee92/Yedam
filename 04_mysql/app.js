// app.js

// import
const express = require("express"); //express 모듈
const parser = require("body-parser"); //body-parser 모듈
const sql = require("./sql"); //index.js를 안써도 이렇게 적으면 그 의미

// express 객체 생성
const app = express();

// Express에서 요청(req) 본문(body)을 해석하기 위한 미들웨어 설정
// x-www-form-urlendcoded
app.use(parser.urlencoded());

// json문자열 정보
app.use(parser.json());

// 라우팅(route) 코드
app.get("/", (req, resp) => {
  resp.send("/ 실행");
});

// 고객목록(select)
app.get("/customers", async (req, resp) => {
  try {
    let customerList = await sql.execute("select * from customers");
    console.log(customerList);
    resp.json(customerList);
  } catch (err) {
    console.log(err);
    resp.json({ retCode: "Error" });
  }
});

// 등록(insert)
app.post("/customer", async (req, resp) => {
  console.log(req.body.param);
  try {
    let result = await sql.execute(
      "insert into customers set ?", //
      [req.body.param]
    );
    console.log(result);
    resp.json(result);
  } catch (err) {
    console.log(err);
    resp.json({ retCode: "Error" });
  }
});

// 삭제(delete)
// http://localhost:8080/boardList.do?page=3
// http://localhost:3000/customer/:id    << 여기서 :id 도 파라미터이다.
app.delete("/customer/:id", async (req, resp) => {
  console.dir(req.params.id);
  try {
    let result = await sql.execute(
      "delete from customers where id = ?", //
      [req.params.id]
    );
    console.log(result);
    resp.json(result);
  } catch (err) {
    console.log(err);
    resp.json({ retCode: "Error" });
  }
});

// Express 서버를 실행하는 부분
app.listen(3000, () => {
  console.log("http://localhost:3000");
});
