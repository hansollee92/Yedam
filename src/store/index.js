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
      },
    ],
    IogId: "", //로그인 정보 저장
  },
  mutations: {
    addBoard(state, post) {
      // state : 위에 있는 state 의미
      state.boardList.push(post);
    },
  },
  getters: {
    getBoardList(state) {
      // BoardList를 get 할 수 있는 함수
      // 여기서 매개변수 state는 createStore 안에 있는(위에 있는) state를 의미
      return state.boardList;
    },
    getBoardNo(state) {
      // BoardList의 id
      return state.boardList.length + 1;
    },
  },
});
