<template>
  <div class="container">
    <div class="row">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th scope="col" class="text-center table-primary">번호</th>
            <td scope="col" class="text-center"><!-- 도서번호 출력자리 --></td>
            <th scope="col" class="text-center table-primary">도서명</th>
            <td scope="col" class="text-center"><!-- 도서명 출력자리 --></td>
            <th scope="col" class="text-center table-primary">저자</th>
            <td scope="col" class="text-center"><!-- 저자 출력자리 --></td>
          </tr>

          <tr>
            <th scope="col" class="text-center table-primary">출판사</th>
            <td colspan="2" class="text-center"><!-- 출판사 출력자리 --></td>
            <th scope="col" class="text-center table-primary">출판일자</th>
            <td colspan="2" class="text-center"><!-- 출판일자 출력자리 --></td>
          </tr>
          <tr>
            <td colspan="6" class="text-center table-primary">책 소개</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colspan="6" class="text-left" valign="top" height="200">
              <!-- 책 소개 출력자리 -->
            </td>
          </tr>
          <tr>
            <td colspan="6" class="text-center">
              <button class="btn btn-xs btn-light">목록</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
