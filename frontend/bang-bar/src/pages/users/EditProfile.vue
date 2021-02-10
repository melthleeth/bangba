<template>
  <div style="flex flex-row">
    <!-- 프로필 변경 -->
    <section class="mb-10 row-span-2 col-span-12">
      <span class="border-gray-800 border-b-2">프로필 변경</span>
      <div class="flex flex-row">
        <div class="flex flex-col">
          <img
            src="@/assets/img/mr.fox.jpg"
            class="h-12 w-12 cursor-pointer rounded-full border-2 border-gray-400 object-cover text-center"
          />
          <button class="w-28">이미지 변경</button>
        </div>
        <div>
          <div>
            <input type="text" />
            <button>중복 확인</button>
          </div>
          <div>
            <p>* 이름은 최소 2자, 최대 10자까지 입력이 가능해요</p>
            <p>* 수정한 정보는 방구석 바텐더의 서비스에 바로 적용돼요</p>
          </div>
        </div>
      </div>
    </section>
    <!-- 개인정보 변경 -->
    <section class="mb-10 row-span-3 col-span-12">
      <span class="border-gray-800 border-b-2">개인정보 변경</span>
      <div>
        <span>이메일</span>
        <span>이메일 내용</span>
      </div>
      <div class="flex flex-row">
        <span>비밀번호</span>
        <div class="flex flex-col">
          <input type="password" placeholder="현재 비밀번호" />
          <input type="password" placeholder="새 비밀번호" />
          <input type="password" placeholder="새 비밀번호 확인" />
        </div>
      </div>
    </section>
    <!-- 수정완료,취소 버튼 -->
    <section class="row-span-1 text-center">
      <button class="mx-3">수정완료</button>
      <button class="mx-3">취소</button>
    </section>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style scoped></style>
