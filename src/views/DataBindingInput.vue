<template>
  <h3><input type="text" v-model.number="valueText" /></h3>
  <h3><input type="number" v-model.number="valueNum" /></h3>
  <p>
    <select v-on:change="calculating" v-model="operator">
      <option value="+">더하기</option>
      <option value="-">빼기</option>
      <option value="*">곱하기</option>
      <option value="/">나누기</option>
    </select>
  </p>
  <h3>
    <button v-on:click="sumNumber">더하기</button>
    <button v-on:click="multiNumber">곱하기</button>
    <button v-on:click="minusNumber">빼기</button>
  </h3>
  <p>{{ valueText }}</p>
  <p>{{ sumVal }}</p>
  <p>{{ operator }}</p>
  <p style="color: #01919ffe; font-weight: 700">{{ result }}</p>
</template>

<script>
export default {
  data() {
    return {
      valueText: 20,
      valueNum: 10,
      sumVal: 0,
      operator: "*",
      result: 0,
    };
  },
  methods: {
    sumNumber() {
      this.sumVal = parseInt(this.valueText) + this.valueNum;
    },
    multiNumber() {
      this.sumVal = this.valueText * this.valueNum;
    },
    minusNumber() {
      this.sumVal = this.valueText - this.valueNum;
    },
    calculating() {
      let result = 0;
      if (this.operator == "+") {
        result = this.valueText + this.valueNum;
      } else if (this.operator == "-") {
        result = this.valueText - this.valueNum;
      } else if (this.operator == "*") {
        result = this.valueText * this.valueNum;
      } else {
        result = this.valueText / this.valueNum;
      }
      this.result = `${this.valueText} ${this.operator} ${this.valueNum} = ${result}`;
    },
  },
};
</script>

<style scoped></style>
