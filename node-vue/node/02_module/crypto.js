// crypto.js
const crypto = require("crypto");
let pass = crypto.createHash("sha512").update("test1234").digest("base64");

// salt값을 생성하는 함수 -> random값이 만들어짐
const createSalt = () => {
  return new Promise((resolve, reject) => {
    crypto.randomBytes(64, (err, buf) => {
      if (err) {
        reject(err); // 실패
      }
      resolve(buf.toString("base64")); //성공
    });
  });
};

// salt 값을 활용해서 평문 -> 암호화 하기 :
const createCryptoPassword = async (trPw) => {
  let salt = await createSalt();
  console.log(salt);
  salt =
    "VeI05YXk7KUh7ZCUtp0LSduXEB5blqnHP+VBRAu9UZaEr+w51+xbObJGSit49UH7Kni6PEOme0eNl0aoscSw2w==";
  pw =
    "NRs09iHcLB0DcEtPqVPbTzHgT0aj2ROEgwrNt+LmB6GR9DY8+J4veMY4eWlDicKC8zY7ZeeU4KRE/tib+0VkHQ==";
  crypto.pbkdf2(trPw, salt, 100000, 64, "sha512", (err, buf) => {
    if (err) {
      console.log("err=>", err);
    }
    console.log(buf.toString("base64"));
    let crPw = buf.toString("base64");
    if (pw == crPw) {
      console.log("비밀번호가 같습니다.");
    } else {
      console.log("비밀번호가 틀렸습니다. 다시 확인하세요.");
    }
  });
};
createCryptoPassword("test1234");
// createCryptoPassword("test1111"); 비밀번호가 틀렸다고 나올것임

// 그럼 이 password를 어떻게 비교?
// 암호화할 salt값과 암호화된 값(비밀번호) 이 두가지를 모두 가지고 있어야지 비교해서 위와 같이 계산이 가능하다. (salt, pw)
