<template>
  <div class="container">
    <div class="row">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col" class="text-center table-primary">번호</th>
            <td scope="col" class="text-center">{{ bookInfo.no }}</td>
            <th scope="col" class="text-center table-primary">도서명</th>
            <td scope="col" class="text-center">{{ bookInfo.name }}</td>
            <th scope="col" class="text-center table-primary">저자</th>
            <td scope="col" class="text-center">{{ bookInfo.writer }}</td>
          </tr>

          <tr>
            <th scope="col" class="text-center table-primary">출판사</th>
            <td colspan="2" class="text-center">{{ bookInfo.publisher }}</td>
            <th scope="col" class="text-center table-primary">출판일자</th>
            <td colspan="2" class="text-center">
              {{
                useDateUtils.dateFormat(bookInfo.publication_date, "yyyy-MM-dd")
              }}
            </td>
          </tr>
          <tr>
            <td colspan="6" class="text-center table-primary">책 소개</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colspan="6" class="text-left" valign="top" height="200">
              <pre
                style="
                  white-space: pre-wrap;
                  border: none;
                  background-color: white;
                "
                >{{ bookInfo.info }}</pre
              >
            </td>
          </tr>
          <tr>
            <td colspan="6" class="text-center">
              <button class="btn btn-xs btn-light" @click="goToList()">
                목록
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script setup>
import useDateUtils from "@/utils/useDates.js";
import axios from "axios";

// Composition API : 필요한 함수를 import
import { shallowRef, onBeforeMount } from "vue";
// Router에 접근하는 경우 useRouter 함수와 useRoute 함수를 사용
import { useRoute, useRouter } from "vue-router";
// Router 객체를 반환
const router = useRouter();
// Router를 통해 컴포넌트가 호출될 경우 라우팅 정보에 접근하기 위해 객체 반환
const route = useRoute();

// 반응형 객체 선언 : AJAX를 통해 Server에서 데이터를 가져오면 재할당 + 단순 출력(중첩 프로퍼티 관찰 X)
let bookInfo = shallowRef({});

// Vue 객체가 사용할 기능은 일반 함수를 선언하듯 작성
const getBookInfo = async (selected) => {
  // 서버에 데이터를 요청
  let result = await axios
    .get(`/api/books/${selected}`)
    .catch((err) => console.log(err));

  // ref 기반의 반응형 객체이므로 실제 값에 접근할 떄는 value 필드 사용
  // 동시에 Composition API에선 객체로 선언하지 않으므로 this로 접근 불가
  bookInfo.value = result.data;
};

const goToList = () => {
  // Composition API에선 객체로 선언하지 않으므로 this로 접근 불가
  router.push({ name: "bookList" });
};

const goToForm = () => {
  router.push({ name: "bookForm", query: { bno: bookInfo.value.no } });
};

// beforeCreate 와 created 훅은 사용 불가 => onBeforeMount(), 가장 먼저 실행되는 훅
onBeforeMount(() => {
  // Composition API에선 객체로 선언하지 않으므로 this로 접근 불가
  let searchNo = route.params.bno;
  getBookInfo(searchNo);
});
</script>
