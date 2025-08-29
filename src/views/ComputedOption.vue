<!-- ComputedOption.vue -->

<!-- computed 
 이벤트 함수와 다르게 이벤트가 발생해야지 데이터값이 변경되는 것과 다르게 
 데이터값이 변경되면 계산된 값으로 화면에 나타나게 해주는 것이 computed
 예) 장바구니 값 계산하는 것 -->

<template>
  <div>
    <h3>--- computed 속성 : 연산에 의한 결과 반영 ---</h3>
    <p>FirstName : <input type="text" v-model="fname" /></p>
    <p>LastName : <input type="text" v-model="lname" /></p>
    <p>FullName : {{ fullName }}</p>
  </div>
  <div>
    <h3>--- watch 속성 : 속성의 변경이전, 변경이후 값을 처리 ---</h3>
    <strong>{{ changeName }}</strong>
    <!-- v-bind, :, @ 모두 같은 의미 -->
    <button @click="changingName">이름변경</button>
  </div>
  <div>
    <h3>--- 장바구니 ---</h3>
    <p v-bind:key="i" v-for="(fruit, i) in cartList">
      <strong>{{ fruit.pname }}</strong> - 가격:
      {{ fruit.price.toLocaleString() }} 원 - 수량 :
      <input type="number" v-model="fruit.qty" />
    </p>
    <p>
      <strong>총수량 : {{ totalQuantity }} 개</strong>
    </p>
    <p>
      <!-- toLocaleString() 사용시 130,000 으로 표현 가능 -->
      <strong>합계금액 : {{ totalPrice.toLocaleString() }} 원</strong>
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "",
      fname: "kildong",
      lname: "Hong",
      cartList: [
        { id: 1, pname: "사과", price: 1000, qty: 2 },
        { id: 2, pname: "포도", price: 2000, qty: 3 },
        { id: 3, pname: "수박", price: 6000, qty: 1 },
      ],
      changeName: "Hong",
    };
  },
  computed: {
    //계산된 속성
    fullName() {
      return this.lname + " " + this.fname;
    },
    totalQuantity() {
      return this.cartList.reduce((acc, item) => {
        return acc + item.qty;
      }, 0);
    },
    totalPrice() {
      return this.cartList.reduce((acc, item) => {
        return acc + item.price * item.qty;
      }, 0);
    },
  },
  watch: {
    //watch는 watch에 정의된 데이터 값 하나만을 감시하기 위한 용도로 실제 데이터가 변경되기전까진 실행x
    changeName(next, prev) {
      console.log(`변경전: ${prev}, 변경후: ${next}`);
    },
  },
  methods: {
    changingName() {
      this.changeName = "Hwang";
    },
  },
};
</script>

<style scoped>
body {
  margin: 0 auto;
}
</style>
