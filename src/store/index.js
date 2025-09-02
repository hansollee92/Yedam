// stroe/index.js

import { createStore } from "vuex";

export default createStore({
  state: {
    boardList: [
      {
        id: 1,
        title: "게시글1번",
        content: "등록연습",
        date: new Date().toLocaleDateString(),
        writer: "user01",
      },
    ],
    logId: "", //로그인 정보 저장
  },
  mutations: {
    addBoard(state, post) {
      // state : 위에 있는 state 의미
      state.boardList.push(post);
    },
    setId(state, id) {
      state.logId = id;
    },
  },
  getters: {
    getBoardList(state) {
      // BoardList를 get 할 수 있는 함수
      return state.boardList;
    },
    getBoardNo(state) {
      // BoardList의 id
      return state.boardList.length + 1;
    },
    getLogId(state) {
      return state.logId;
    },
  },
});
