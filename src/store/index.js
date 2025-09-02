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
    // 동기방식
    addBoard(state, post) {
      state.boardList.push(post);
    },
    setId(state, id) {
      state.logId = id;
    },
  },
  actions: {
    // 비동기방식 처리
    saveBoard({ commit }, post) {
      commit("addBoard", post);
    },
  },
  getters: {
    getBoardList(state) {
      return state.boardList;
    },
    getBoardNo(state) {
      return state.boardList.length + 1;
    },
    getLogId(state) {
      return state.logId;
    },
  },
});
