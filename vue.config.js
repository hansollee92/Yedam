const { defineConfig } = require("@vue/cli-service");
const target = "http://localhost:3000";
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8080,
    proxy: {
      "^/api": {
        target,
        changeOrigin: true,
        // "^/api" 으로 작성해야 하는 이유
        // 1) 프록시 규정 :
        // vue.config.js의 키 '^/api'는 “요청 경로가 /api로 시작하면 프록시로 보낸다”는 의미입니다.
        // '^api'처럼 슬래시가 빠지면, 실제 요청 경로는 항상 /로 시작하므로 매칭이 안 됩니다.

        // 2) 브라우저 경로 해석 : "api/productList2"처럼 상대경로로 쓰면, 현재 라우터 경로(/test)를 기준으로 **/test/api/productList2**가 됩니다.
        // 당연히 '^/api'와도 안 맞고, 프록시도 타지 않아 404가 납니다. 반면 **/api/productList2**처럼 루트 기준 절대경로로 쓰면 항상 동일하게 매칭돼서 프록시 동작이 안정적이에요.
      },
    },
  },
});
