//문제
//댓글내용에 보면 한글로 '연습'라고 적혀있는 글이 있다. 연습이 포함되어있는 글번호를 출력해봐라.
//idexOf를 사용하면 된다.

fetch("http://192.168.0.83/HelloJSP/replyList.do?bno=145")
  .then((response) => response.json())
  .then((result) => {
    console.log(result);
    result
      .filter((elem, idx, ary) => {
        //reply '연습' 포함된 댓글번호
        //'글등록연습'.indexOf('연습') => -1 반환(없음)
        if (elem.reply.indexOf("연습") != -1) {
          return true;
        }
      })
      .forEach((elem) => {
        console.log("댓글번호: " + elem.replyNo);
      });
  })
  .catch(console.log);

// map (mapping)
// A -> A'
// {name, age, point} => {name, point}
