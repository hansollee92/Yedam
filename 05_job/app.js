// 05_job/app.js
const express = require("express");
require("dotenv").config({
  path: "./.env",
});
const nodemail = require("./nodemail"); //읽기전에 환경변수에 넣어줘야해서 위의 순서처럼 작성
//const process = require("process"); 내장객체여서 import 해도 되고 안해도 됨

console.log(process.env);

const app = express();
app.use(express.urlencoded()); //body-parser를 import로 넣어도 되고 이렇게 넣어도 된다.

// 라우팅
app.get("/", (req, resp) => {
  resp.send("/");
});
app.get("/mail", (req, resp) => {
  resp.send(`<form action="mail" method="post">
      <table>
        <tr>
          <th>보내는이:</th>
          <th>
            <input type="email" name="sender" value="hanarin92@daum.net" />
          </th>
        </tr>
        <tr>
          <th>받는이:</th>
          <th>
            <input type="email" name="receiver" value="hansol2886@gmail.com" />
          </th>
        </tr>
        <tr>
          <th>제목:</th>
          <th><input type="text" name="subject" /></th>
        </tr>
        <tr>
          <th>내용:</th>
          <th><textarea name="content"></textarea></th>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="메일보내기" />
          </td>
        </tr>
      </table>
    </form>`);
});
app.post("/mail", (req, resp) => {
  console.log(req.body);
  let data = {
    // from, to, subject, text(html)
    from: req.body.sender,
    to: req.body.receiver,
    subject: req.body.subject,
    html: "<div>" + req.body.content.replace(/\r?\n/g, "<br>") + "</div>",
    //text: req.body.content,
  };
  nodemail.mailSend(data);
  resp.send("done");
});

app.listen(3000, () => {
  console.log("http://localhost:3000");
});
