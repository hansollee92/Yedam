// nodecron.js

const cron = require("node-cron");

// cron.schedule("* * * * * *", () => {
//   console.log("1초마다 작업");
// });
cron.schedule("1,5,10 * * * * *", () => {
  //매분마다 실행되는데 그 매분의 1초,5초,10초마다 작업됨
  let current = new Date();
  console.log(current.toISOString() + " => cron실행됨");
});
