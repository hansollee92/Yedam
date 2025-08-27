// nodemail.js
// 다음 앱 비번 : fcgqrgspmmupbmsr

const nodemail = require("nodemailer");

let transporter = nodemail.createTransport({
  host: "smtp.daum.net",
  port: 465,
  secure: true,
  auth: {
    user: "hanarin92@daum.net",
    pass: "fcgqrgspmmupbmsr",
  },
});

const mailSend = (data = {}) => {
  transporter.sendMail(data, (err, result) => {
    if (err) {
      console.log(err);
      return err;
    }
    console.log(result.messageId + "를 확인하세요");
    return result.messageId;
  });
};

module.exports = {
  mailSend,
};
