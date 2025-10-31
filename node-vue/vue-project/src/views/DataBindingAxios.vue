<!-- views/DataBindingAxios.vue -->

<template>
  <h3>{{ msg }}</h3>

  <table class="add">
    <tr>
      <th>상품명</th>
      <td><input type="text" v-model="prod_name" /></td>
    </tr>
    <tr>
      <th>가격</th>
      <td><input type="text" v-model="prod_price" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <button v-on:click="registProd">상품등록</button>
      </td>
    </tr>
  </table>

  <table class="list">
    <thead>
      <tr>
        <th>상품번호</th>
        <th>상품명</th>
        <th>가격</th>
        <th>카테고리</th>
      </tr>
    </thead>
    <tbody :key="i" v-for="(prod, i) in prodList">
      <tr>
        <td>{{ prod.id }}</td>
        <td>{{ prod.product_name }}</td>
        <td>{{ prod.product_price.toLocaleString() }}원</td>
        <td>{{ prod.category1 }}/{{ prod.category2 }}/{{ prod.category3 }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      msg: "Axios 연습",
      prod_name: "",
      prod_price: 10000,
      prodList: [],
    };
  },
  methods: {
    async getProductList() {
      // pending, fullfiled, rejected.
      let response = await axios.post(
        "http://localhost:3000/api/productList2",
        []
      );
      return response.data; // Promise 반환
    },
    //axios의 상품등록
    async registProd() {
      //등록할 상품의 정보. axious.post의 메소드를 활용할 경우 : 값은 {} 감싸도록 해야함
      let product = {
        product_name: this.prod_name,
        product_price: this.prod_price,
        seller_id: 1,
        category_id: 1,
      };
      let response = await axios.post(
        "http://localhost:3000/api/productInsert",
        { param: [product] }
      );
      response = await this.getProductList(); // 목록을 가져오는 메소드 호출
      console.log(response);
      this.prodList = response; // 상품목록을 보여주는 배열에 값을 저장.

      // axios
      //   .post("http://localhost:3000/api/productInsert", { param: [product] })
      //   .then((result) => console.log(result))
      //   .catch((err) => console.error(err));
    },
  },
  mounted() {
    this.getProductList().then((list) => {
      console.log(list);
      this.prodList = list;
    });
  },
};
</script>

<style scoped>
table {
  margin: 25px auto;
}
table,
tr,
td,
th {
  border: 1px solid #aaa;
  padding: 8px;
  border-collapse: collapse;
}
table.add {
  width: 30%;
  margin-bottom: 30px;
}
table.add button {
  padding: 8px 30px;
  transition: 0.5s;
  border: 1px solid #aaa;
  border-radius: 5px;
}
table.add button:hover {
  background-color: #628d73;
  color: #fff;
}
table.list {
  width: 70%;
}
table.list thead {
  background-color: #628d73;
  color: #fff;
}
table.list td:nth-child(2) {
  text-align: left;
  padding-left: 10px;
}
</style>
