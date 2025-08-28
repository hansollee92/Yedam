<!-- 반복문 작업 (다중데이터) -->
<template>
  <div>
    <h3>{{ msg }}</h3>
    <table>
      <thead>
        <tr>
          <th>상품명</th>
          <th>가격</th>
          <th>카테고리</th>
        </tr>
      </thead>
      <tbody>
        <tr v-bind:key="i" v-for="(prod, i) in prodList">
          <th>{{ prod.product_name }}</th>
          <th v-text="prod.price"></th>
          <th>{{ prod.category }}</th>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "학생목록",
      data: [
        { id: 1, name: "홍길동", age: 20 },
        { id: 2, name: "김민수", age: 22 },
        { id: 3, name: "최익수", age: 23 },
      ],
      prodList: [],
    };
  },
  mounted() {
    // DataBindingList 컴포넌트가 생성이 되면 생성, 마운트, 소멸... 과 같은 생명주기들이 있다. 이 주기들에 기능을 넣을 수 있는데
    // 마운트되는 시점에 발생하는 이벤트 훅이 발생하는데 그것이 mounted()라는 것이다.
    fetch("http://192.168.0.83:3000/products")
      .then((response) => response.json())
      .then((result) => {
        console.log(result);
        this.prodList = result;
      })
      .catch();
  },
};
</script>

<style scoped></style>
