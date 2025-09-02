// app.js

// import
const express = require("express"); //express 모듈
const parser = require("body-parser"); //body-parser 모듈
const sql = require("./sql"); //index.js를 안써도 이렇게 적으면 그 의미
const prodSql = require("./sql/sql"); //mini-projcet query
const cors = require("cors");
const fs = require("fs"); //파일시스템

//console.log(prodSql["imageList"].query); //productList의 query구문을 반환해줌

// express 객체 생성
const app = express();

// Express에서 요청(req) 본문(body)을 해석하기 위한 미들웨어 설정
// x-www-form-urlendcoded
app.use(parser.urlencoded());

// json문자열 정보
app.use(parser.json());

// 용량 옵션
app.use(
  express.json({
    limit: "10mb",
  })
);

// cors
app.use(cors());

// 라우팅(route) 코드
app.get("/", (req, resp) => {
  resp.send("/ 실행");
});

// 파일업로드
app.post("/upload/:file_name", (req, resp) => {
  let file_name = req.params.file_name;
  let data = req.body.param;
  console.log(file_name, data);
  fs.writeFile(__dirname + "/uploads/" + file_name, data, "base64", (err) => {
    if (err) {
      resp.send(err);
      return;
    }
    resp.send("OK");
  }); // 매개변수 : file, data, incoding
});

// 이미지 링크 정보(get방식)
// vue-shop프로젝트의 ProductList.vue의 template를 보면 <img :src="`/download/${product.id}/${product.path}`" > 구조가 있다.
// 이걸 위한 이미지 링크 정보 get방식이 필요하기 때문에 여기서 작성을 해야한다.
app.get("/download/:product_id/:path", (req, resp) => {
  let product_id = req.params.product_id;
  let path = req.params.path; //keyboard.jpg

  resp.header("Content-type", `image/${path.substring(path.lastIndexOf("."))}`);

  const filepath = `${__dirname}/uploads/${product_id}/${path}`;
  if (!fs.existsSync(filepath)) {
    // 경로에 이미지파일이 없을 경우
    resp.send(404, { error: "file not found" });
    return;
  }
  fs.createReadStream(filepath).pipe(resp);
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
