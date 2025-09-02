// app.js

// import
const express = require("express"); //express 모듈
const parser = require("body-parser"); //body-parser 모듈
const sql = require("./sql"); //index.js를 안써도 이렇게 적으면 그 의미
const prodSql = require("./sql/sql"); //mini-projcet query
const cors = require("cors");

//console.log(prodSql["imageList"].query); //productList의 query구문을 반환해줌

// express 객체 생성
const app = express();

// Express에서 요청(req) 본문(body)을 해석하기 위한 미들웨어 설정
// x-www-form-urlendcoded
app.use(parser.urlencoded());

// json문자열 정보
app.use(parser.json());

// cors
app.use(cors());

// 라우팅(route) 코드
app.get("/", (req, resp) => {
  resp.send("/ 실행");
});

// 파일업로드
app.post("/upload/:file_name", (req, resp) => {
  let file_name = req.params.file_name;
  console.log(req.body.data);
  console.log(file_name);
  resp.send("OK");
});

// 상품쿼리
app.post("/api/:alias", async (req, resp) => {
  //console.log(prodSql[req.params.alias].query);
  let search = prodSql[req.params.alias].query;
  let param = req.body.param; // [{product_id:9, type:1, path:test.jpg}]
  try {
    let result = await sql.execute(search, param);
    resp.json(result);
  } catch (err) {
    console.log(err);
    resp.json({ retCode: "Error" });
  }
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

// 수정(update)
app.put("/customer", async (req, resp) => {
  try {
    let result = await sql.execute(
      "update customers set ? where id = ?", //
      [req.body[0], req.body[1]]
      // 또는 디스트럭처링(배열풀기) 사용해서
      // const [fields, id] = req.body; -> [fields, id] 사용하는 방법도 있음
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
