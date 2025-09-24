<template>
  <div class="container">
    <table class="table table-hover">
      <caption>
        total :
      </caption>
      <thead>
        <tr>
          <th>No.</th>
          <th>도서명</th>
          <th>저자</th>
          <th>출판사</th>
          <th>출판일수</th>
        </tr>
      </thead>
      <tbody>
        <!-- 임시변수 in 배열 -->
        <!-- v-for 디렉티브 사용할 때 사용하길 권장되는 :key. 이 key를 보면서 뭐가 변경되었는지 확인함(Key를 쓰지 않으면 성능저하가 일어남) -->
        <tr v-for="book in bookList" v-bind:key="book.no">
          <td>{{ book.no }}</td>
          <td>{{ book.name }}</td>
          <td>{{ book.writer }}</td>
          <td>{{ book.publisher }}</td>
          <td>
            {{ useDates.dateFormat(book.publication_date, "yyyy-MM-dd") }}
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
// composition 방식으로 작성할 때는 setup이라는 속성을 script에 넣는다. option방식 넣으면 에러띄게 만들어줌
import axios from "axios";
import { onBeforeMount, shallowRef } from "vue";
import useDates from "@/utils/useDates.js";

// 1) 데이터가 필요
let bookList = shallowRef([]);
//      let bookList = []; <- '반응형 객체'가 되어야함/
//      그리고 이것은 선언만 해놓고 2)에서 데이터가 들어가야하니 바뀐다 -> 근데 들고와서 값이 변경안됨 shallowRef()
//      그래서 위와같이 작성

// 2) Server로부터 데이터 가져오기 => axios API
const getBookList = async () => {
  let result = await axios.get("/api/books").catch((err) => console.log(err));
  bookList.value = result.data;
  //    result.data로 들고오는 이유 : 응답스키마 https://axios-http.com/kr/docs/res_schema 참고
};

// 3) 컴포넌트가 화면에 보여지기 직전에 Server로부터 데이터를 가져오기
onBeforeMount(() => {
  getBookList();
});
</script>

<style scoped>
table * {
  text-align: center;
}
</style>
