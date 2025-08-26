// app.js

// import
const express = require("express"); //express 모듈
const mysql = require("mysql2"); //mysql2 모듈
const parser = require("body-parser"); //body-parser 모듈

// Express에서 요청(req) 본문(body)을 해석하기 위한 미들웨어 설정
// x-www-form-urlendcoded
app.use(parser.urlencoded);

// connect pool 생성
const pool = mysql.createPool({
  host: "127.0.0.1",
  port: 3306,
  user: "dev01",
  password: "dev01",
  database: "dev",
  connectionLimit: 10,
});

// express 객체 생성
const app = express();

app.get("/", (req, resp) => {
  resp.send("/ 실행");
});

// 고객목록(select)
app.get("/customers", (req, resp) => {
  pool.getConnection((err, connection) => {
    // getConnection => connection 객체 획득
    if (err) {
      console.log(err);
      return;
    }
    connection.query("select * from customers", (err, results) => {
      if (err) {
        console.log(err);
        resp.send("쿼리 실행중 에러");
        return;
      } else {
        console.log(results);
        // resp.send("쿼리 실행완료");
        resp.json(results); //json 문자열로 가져오기
        connection.release(); //사용했던 connection을 pool로 환원
      }
    }); // end of query()
  }); // end of getConnection()
});

// 등록(insert)
app.post("/customer", (req, resp) => {
  console.log(req.params);
  pool.getConnection((err, connection) => {
    if (err) {
      console.log(err);
      return;
    }
    connection.query(
      "insert into customers (name, email, phone) values (?, ?, ?)",
      ["Test", "test@email.com", "010-1234-1234"],
      (err, results) => {
        if (err) {
          console.log(err);
          resp.send("쿼리 실행중 에러");
          return;
        } else {
          console.log(results);
          // resp.send("쿼리 실행완료");
          resp.json(results);
          connection.release();
        }
      }
    ); // end of query()
  }); // end of getConnection()
});

// Express 서버를 실행하는 부분
app.listen(3000, () => {
  console.log("http://localhost:3000");
});
