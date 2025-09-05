// sql/index.js

// import
const mysql = require("mysql2"); //mysql2 모듈

// DB접속정보 : connect pool 생성
const pool = mysql.createPool({
  host: "127.0.0.1",
  port: 3306,
  user: "dev01",
  password: "dev01",
  database: "dev",
  connectionLimit: 10,
});

// 매개변수 sql = "select * from customers"
// 매개변수 param = []
function execute(sql = "select * from customers", param = []) {
  return new Promise((resolve, reject) => {
    pool.getConnection((err, connection) => {
      if (err) {
        return reject(err);
      }
      connection.query(sql, param, (queryErr, results) => {
        connection.release();
        if (queryErr) {
          return reject(queryErr);
        }
        resolve(results);
      });
    });
  });
}

module.exports = {
  execute,
};
